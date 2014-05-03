package interp.Player;

import interp.Semantic.FunctionGlobalFuncs;
import interp.StageTree;
import interp.Types.*;
import parser.StageLexer;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Interpreter {
    private HashMap<String, FunctionSignature> function_list;
    private HashMap<String, FilterSignature> filter_list;
    private SceneGraph scene_graph;
    private FunctionDispatcher func_disp;

    //temp vars.
    private boolean quit;
    private boolean ret;
    private TypeInterface ret_val;
    private StageStack current_stack;

    public Interpreter(HashMap<String, FunctionSignature> function_list,
                       HashMap<String, FilterSignature> filter_list,
                       SceneGraph scene_graph,
                       FunctionDispatcher func_disp) {
        this.function_list = function_list;
        this.filter_list = filter_list;
        this.scene_graph = scene_graph;
        this.func_disp = func_disp;
    }

    public boolean quit() {
        return quit;
    }

    public boolean ret() {
        return ret;
    }

    public void run(FunctionSignature func, int mode, StageStack stack) {
        current_stack = stack;
        quit = false;
        ret = false;

        switch (mode) {
            case Player.FIRST:
                if(func.first == null) return;
                current_stack.pushScope();
                runFuncs(func.first);
                break;
            case Player.LOOP:
                if(func.loop == null) return;
                current_stack.pushScope();
                runFuncs(func.loop);
                current_stack.popScope();
                break;
            case Player.LAST:
                if(func.last == null) return;
                current_stack.pushScope();
                runFuncs(func.last);
                break;
            default:
                throw new RuntimeException("Running function mode not recognized " + mode);
        }
    }

    private void runFuncs(StageTree t) {
        for(int i=0; i<t.getChildCount() && !quit && !ret; i++) {
            runInst(t.getChild(i));
        }
    }

    private void runInst(StageTree inst) {
        switch (inst.getType()) {
            case StageLexer.BYPASSF:
                //TODO edit scene graph.
                break;
            case StageLexer.EMPTYFILT:
                //TODO edit scene graph.
                break;
            case StageLexer.FILTCALL:
                //TODO edit scene graph.
                break;
            case StageLexer.ADDFILT:
                //TODO edit scene graph.
                break;
            case StageLexer.QUIT:
                quit = true;
                return;
            case StageLexer.DECLARE:
                String varName = inst.getChild(1).getText();
                if(inst.getChildCount() == 2) {
                    Types varType = inst.getChild(0).getVarType();
                    TypeInterface var;
                    var = varType.getInstance();
                    if(inst.getChild(0).getType() == StageLexer.ARRAY) {
                        IntType size = (IntType)inst.getChild(0).getChild(1).getValue();
                        ((ArrayType) var).setSize(size);
                    }
                    current_stack.add(varName, var);
                } else { //TODO be careful with what you copy and not! Second parameter is makecopy ALWAYS.
                    current_stack.add(varName, evaluateExpr(inst.getChild(2), true));
                }
                break;
            case StageLexer.ASSIGN:
                TypeInterface leftT = evaluateExpr(inst.getChild(0), false); //pass left whatever by reference.
                TypeInterface rightT = evaluateExpr(inst.getChild(1), true); //make a copy of right whatever.
                leftT = rightT;
                break;
            case StageLexer.WHILE:
                BoolType w_condition = (BoolType) evaluateExpr(inst.getChild(0), false);

                while (w_condition.getValue()) {
                    current_stack.pushScope();
                    for(int i=0; i<inst.getChild(1).getChildCount(); i++) {
                        runInst(inst.getChild(1).getChild(i));
                    }
                    current_stack.popScope();
                    w_condition = (BoolType) evaluateExpr(inst.getChild(0), false);
                }
                break;
            case StageLexer.IF:
                BoolType i_condition = (BoolType) evaluateExpr(inst.getChild(0), false);

                if(i_condition.getValue()) {
                    current_stack.pushScope();
                    for(int i=0; i<inst.getChild(1).getChildCount(); i++) {
                        runInst(inst.getChild(1).getChild(i));
                    }
                    current_stack.popScope();
                }
                else if(inst.getChildCount() > 2) {
                    current_stack.pushScope();
                    for(int i=0; i<inst.getChild(2).getChildCount(); i++) {
                        runInst(inst.getChild(2).getChild(i));
                    }
                    current_stack.popScope();
                }
                break;
            case StageLexer.MEMBER:
            case StageLexer.ARRAY:
            case StageLexer.ID:
            case StageLexer.FUNCALL:
                evaluateExpr(inst, false);
                break;
            case StageLexer.TIMECALL:
                StageStack fun_stack = new StageStack();
                FloatType stTime = (FloatType)evaluateExpr(inst.getChild(1), false);
                FloatType edTime = (FloatType)evaluateExpr(inst.getChild(2), false);

                StageTree funcall = inst.getChild(0);
                String funname = funcall.getChild(0).getText();
                StageTree argst = funcall.getChild(1);
                FunctionSignature fs = function_list.get(funname);

                for(int i=0; i<argst.getChildCount(); i++) {
                    fun_stack.add(fs.args_names.get(i), evaluateExpr(argst.getChild(i), false));
                }
//TODO check what's by copy and what's not.
                func_disp.addFunc(funname, stTime.getValue(), edTime.getValue(), fun_stack);
                break;
            case StageLexer.RETURN:
                if(inst.getChildCount() == 0) {
                    ret = true;
                    ret_val = null;
                } else {
                    TypeInterface rtp = evaluateExpr(inst.getChild(0), false);
                    ret = true;
                    ret_val = rtp;
                }
                break;
            default:
                throw new RuntimeException("Instruction not recognised, this shouldn't appear here.");
        }
    }

    private TypeInterface evaluateExpr(StageTree exp, boolean copy) {
        switch (exp.getType()) {
            case StageLexer.INT:
            case StageLexer.FLOAT:
            case StageLexer.CHAR:
            case StageLexer.STRING:
            case StageLexer.BOOLEAN:
                return exp.getValue();
            case StageLexer.FUNCALL:
                String func_name = exp.getChild(0).getText();
                ArrayList<TypeInterface> fargs = new ArrayList<TypeInterface>();
                for(int i=0; i<exp.getChild(1).getChildCount(); i++) {
                    fargs.add(evaluateExpr(exp.getChild(1).getChild(i), false));
                }

                if(FunctionGlobalFuncs.getTable().exists(func_name)) {
                    return FunctionGlobalFuncs.callFunc(func_name, fargs);
                } else {
                    return getFuncReturn(func_name, fargs);
                }
            case StageLexer.ARRAY:
                TypeInterface leftT = current_stack.getVar(exp.getChild(0).getText());
                TypeInterface pos = (IntType) evaluateExpr(exp.getChild(1), false);
                return leftT.callMethod("[", Arrays.asList(pos));
            case StageLexer.MEMBER:
                TypeInterface m_leftT = evaluateExpr(exp.getChild(0), false);

                StageTree node = exp.getChild(1);
                switch (node.getType()) {
                    case StageLexer.ID:
                        return m_leftT.getAttribute(node.getText());
                    case StageLexer.FUNCALL:
                        String fname = node.getChild(0).getText();
                        ArrayList<TypeInterface> args = new ArrayList<TypeInterface>();
                        for(int i=0; i<node.getChild(1).getChildCount(); i++) {
                            args.add(evaluateExpr(node.getChild(1).getChild(i), false));
                        }
                        return m_leftT.callMethod(fname, args);
                    case StageLexer.ARRAY:
                        String name = node.getChild(0).getText();
                        TypeInterface m_pos = evaluateExpr(node.getChild(1), false);
                        return m_leftT.getAttribute(name).callMethod("[", Arrays.asList(m_pos));
                    default:
                        throw new RuntimeException("Instruction not recognised, this shouldn't appear here.");
                }
            case StageLexer.ID:
                //TODO add builtin vars.
                return current_stack.getVar(exp.getText());
        }

        //One child operands.
        if(exp.getChildCount() == 1) { //we expect not or -  (- is an alias of not)
            String opName = exp.getText();
            if(exp.getType() == StageLexer.MINUS) opName = "not"; //TODO think if it's necessary.
            TypeInterface leftType = evaluateExpr(exp.getChild(0), false);
            return leftType.callMethod(opName, new ArrayList<TypeInterface>());
        }

        //Two child operands.
        if(exp.getChildCount() == 2) { //we expect or, and, ==, !=, >, <, >=, <=, +, -, *, /, %
            TypeInterface leftType = evaluateExpr(exp.getChild(0), false);
            TypeInterface rightType = evaluateExpr(exp.getChild(1), false);
            return leftType.callMethod(exp.getText(), Arrays.asList(rightType));
        }
        throw new RuntimeException("Interpreter: Expression not recognized. This is impossible!");
    }

    private TypeInterface getFuncReturn(String name, ArrayList<TypeInterface> args) {
        System.out.println("CALLING FUNC INNER. INTERPRETER 248, HUEHUE" + name);
        FunctionSignature fs = function_list.get(name);
        StageStack old_stack = current_stack;

        current_stack = new StageStack();
        TypeInterface ret = fs.ret.getInstance();

        for(int i=0; i<args.size(); i++) {
            current_stack.add(fs.args_names.get(i), args.get(i));
        }

        //Run first.
        if(fs.first != null) {
            current_stack.pushScope();
            runFuncs(fs.first);
        }
        if(this.ret) {
            current_stack = old_stack;
            quit = false;
            this.ret = false;
            return ret_val;
        }
        if(this.quit) {
            if(fs.last != null) {
                current_stack.pushScope();
                runFuncs(fs.last);
                if(this.ret) {
                    current_stack = old_stack;
                    quit = false;
                    this.ret = false;
                    return ret_val;
                }
            }
            current_stack = old_stack;
            quit = false;
            this.ret = false;
            return ret;
        }
        if(fs.loop != null) {
            current_stack.pushScope();
            runFuncs(fs.loop);
            current_stack.popScope();
        }
        if(this.ret) {
            current_stack = old_stack;
            quit = false;
            this.ret = false;
            return ret_val;
        }

        if(fs.last != null) {
            current_stack.pushScope();
            runFuncs(fs.last);
        }
        if(this.ret) {
            current_stack = old_stack;
            quit = false;
            this.ret = false;
            return ret_val;
        }

        current_stack = old_stack;
        quit = false;
        this.ret = false;
        return ret;
    }
}
