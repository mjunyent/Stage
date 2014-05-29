package interp.GLSLTranslator;

import interp.Semantic.FilterGlobalFuncs;
import interp.StageTree;
import interp.Types.TypeFilterInterface;
import interp.Types.TypeInterface;
import interp.Types.Types;
import parser.StageLexer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Translator {
    StageTree filter = null;
    ArrayList<String> code;
    String filter_name;

    public Translator(StageTree filter) {
        this.filter = filter;
        code = new ArrayList<String>();
        filter_name = filter.getChild(1).getText();

        ArrayList<String> header = new ArrayList<String>();
        header.add("#ifdef GL_ES");
        header.add("    precision mediump float;");
        header.add("    precision mediump int;");
        header.add("#endif");
        header.add("");
        header.add("#define PROCESSING_COLOR_SHADER");
        header.add("");

        header.add("uniform float time;");
        header.add("uniform vec2 resolution;");

        ArrayList<String> sampler_uniforms = new ArrayList<String>();
        for(int i=0; i<filter.getChild(0).getChildCount(); i++) {
            sampler_uniforms.add("uniform sampler2D " + filter.getChild(0).getChild(i).getText() + ";");
        }

        ArrayList<String> param_uniforms = new ArrayList<String>();
        for(int i=0; i<filter.getChild(2).getChildCount(); i++) {
            String type = filter.getChild(2).getChild(i).getChild(0).getText();
            String name = filter.getChild(2).getChild(i).getChild(1).getText();

            param_uniforms.add("uniform " + type + " " + name + ";");
        }

        ArrayList<String> main_code = new ArrayList<String>();
        main_code.add("void main() {");
        main_code.add("    vec2 UV = gl_FragCoord.xy / resolution.xy;");

        for(int i=0; i<filter.getChild(3).getChildCount(); i++) {
            getInstructionCode(filter.getChild(3).getChild(i), main_code, 4);
        }

        main_code.add("}");

        code.addAll(header);
        code.addAll(sampler_uniforms);
        code.addAll(param_uniforms);
        code.addAll(main_code);
    }

    public void writeFile(String path) {
        String newLine = System.getProperty("line.separator");
        FileWriter f0;
        try {
            f0 = new FileWriter(path + filter_name + ".glsl");
        } catch (IOException e) { e.printStackTrace(); return; }

        for(String line : code) {
            try {
                f0.write(line + newLine);
            } catch (IOException e) { e.printStackTrace(); return; }
        }

        try {
            f0.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    private String printSpaces(int spaces) {
        return String.format("%" + spaces + "s", "");
    }

    private void getInstructionCode(StageTree inst, ArrayList<String> code, int spaces) {
        switch (inst.getType()) {
            case StageLexer.DECLARE:
                String inst_code;
                String varType = inst.getChild(0).getText();
                String varName = inst.getChild(1).getText();
                inst_code = varType + " " + varName;

                if(inst.getChildCount() > 2)    inst_code += " = " + getExpressionCode(inst.getChild(2));
                inst_code += ";";
                code.add(printSpaces(spaces) + inst_code);
                break;
            case StageLexer.ASSIGN:
                String leftCode = getExpressionCode(inst.getChild(0));
                String rightCode = getExpressionCode(inst.getChild(1));
                code.add(printSpaces(spaces) + leftCode + " = " + rightCode + ";");
                break;
            case StageLexer.WHILE:
                String w_condition = getExpressionCode(inst.getChild(0));
                code.add(printSpaces(spaces) + "while(" + w_condition + ") {");
                for(int i=0; i<inst.getChild(1).getChildCount(); i++) {
                    getInstructionCode(inst.getChild(1).getChild(i), code, spaces+4);
                }
                code.add(printSpaces(spaces) + "}");
                break;
            case StageLexer.IF:
                String i_condition = getExpressionCode(inst.getChild(0));
                code.add(printSpaces(spaces) + "if(" + i_condition + ") {");

                for(int i=0; i<inst.getChild(1).getChildCount(); i++) {
                    getInstructionCode(inst.getChild(1).getChild(i), code, spaces+4);
                }

                //if there is else...
                if(inst.getChildCount() > 2) {
                    code.add(printSpaces(spaces) + "} else {");
                    for(int i=0; i<inst.getChild(2).getChildCount(); i++) {
                        getInstructionCode(inst.getChild(2).getChild(i), code, spaces+4);
                    }
                }
                code.add(printSpaces(spaces) + "}");
                break;
            case StageLexer.MEMBER:
            case StageLexer.ARRAY:
            case StageLexer.ID:
            case StageLexer.FUNCALL:
                code.add(printSpaces(spaces) + getExpressionCode(inst) + ";");
                break;
            case StageLexer.RETURN:
                code.add(printSpaces(spaces) + "gl_FragColor = " + getExpressionCode(inst.getChild(0)) + ";");
                break;
            default:
                throw new RuntimeException("Instruction not recognised, this shouldn't appear here.");
        }
    }

    private String getExpressionCode(StageTree exp) {
        if(exp.getType() == StageLexer.INT) return exp.getText();
        if(exp.getType() == StageLexer.FLOAT) return exp.getText();
        if(exp.getType() == StageLexer.BOOLEAN) return exp.getText();
        if(exp.getType() == StageLexer.FUNCALL) {
            ArrayList<String> args = new ArrayList<String>();

            for(int i=0; i<exp.getChild(1).getChildCount(); i++) {
                args.add(getExpressionCode(exp.getChild(1).getChild(i)));
            }

            return FilterGlobalFuncs.getFuncText(exp.getFuncId(), args);
        }
        if(exp.getType() == StageLexer.MEMBER) {
            return getMemberCode(exp);
        }
        if(exp.getType() == StageLexer.ID) return exp.getText();
        if(exp.getType() == StageLexer.ARRAY) {
            TypeFilterInterface ray = exp.getChild(0).getVarType().getTypeFilterInterfaceInstance();

            String expr = getExpressionCode(exp.getChild(1));
            Types exprType = exp.getChild(1).getVarType();
            return ray.callMethod(exp.getChild(0).getText(), "[", Arrays.asList(exprType), Arrays.asList(expr));
        }

        //One child operands.
        if(exp.getChildCount() == 1) { //we expect not or -  (- is an alias of not)
            String opName = exp.getText();

            TypeFilterInterface operand = exp.getChild(0).getVarType().getTypeFilterInterfaceInstance();
            return operand.callMethod(exp.getChild(0).getText(), opName, new ArrayList<Types>(), new ArrayList<String>());
        }

        //Two child operands.
        if(exp.getChildCount() == 2) { //we expect or, and, ==, !=, >, <, >=, <=, +, -, *, /, %
            String opName = exp.getText();

            TypeFilterInterface leftOp = exp.getChild(0).getVarType().getTypeFilterInterfaceInstance();
            String leftExp = getExpressionCode(exp.getChild(0));
            String righExp = getExpressionCode(exp.getChild(1));

            return leftOp.callMethod(leftExp, opName, Arrays.asList(exp.getChild(1).getVarType()), Arrays.asList(righExp));
        }

        return "";
    }


    private String getMemberCode(StageTree exp) {
        String leftCode = getExpressionCode(exp.getChild(0));
        TypeFilterInterface left = exp.getChild(0).getVarType().getTypeFilterInterfaceInstance();
        StageTree right = exp.getChild(1);
        switch (right.getType()) {
            case StageLexer.ID:
                return left.getAttribute(leftCode, right.getText());
            case StageLexer.ARRAY:
                TypeFilterInterface ray = right.getChild(0).getVarType().getTypeFilterInterfaceInstance();
                String expr = getExpressionCode(exp.getChild(1));
                Types exprType = exp.getChild(1).getVarType();

                String leftT = left.getAttribute(leftCode, right.getChild(0).getText());
                return ray.callMethod(leftT, "[", Arrays.asList(exprType), Arrays.asList(expr));
        }

        return "";
    }

}
