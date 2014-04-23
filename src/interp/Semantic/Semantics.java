package interp.Semantic;

import Stage.Stage;
import interp.StageTree;
import interp.Types.*;
import parser.StageLexer;

import java.util.*;

public class Semantics {
    private HashMap<String, StageTree> functions = null;
    private HashMap<String, StageTree> filters = null;
    StageTree functions_root = null;
    StageTree filters_root = null;

    boolean debug = true;

    public Semantics(StageTree tree, boolean debug) {
        this.debug = debug;

        functions = new HashMap<String, StageTree>();
        filters = new HashMap<String, StageTree>();

        for(int i=0; i<Math.max(tree.getChildCount(),2); i++) {
            StageTree node = tree.getChild(i);
            if(node.getType() == StageLexer.LIST_FUNCTIONS) functions_root = node;
            else if(node.getType() == StageLexer.LIST_FILTERS) filters_root = node;
        }

        fillFunctionsMap();
        fillFiltersMap();

//        this.functions = functions;
//        this.filters = filters;
    }

    private void fillFunctionsMap() {
        if(functions_root == null) return;

        for(int i=0; i<functions_root.getChildCount(); i++) {
            StageTree node = functions_root.getChild(i);

            String fname = node.getChild(0).getText();
            if (functions.containsKey(fname)) throw new RuntimeException("Multiple definitions of function " + fname);
            functions.put(fname, node);
        }
    }

    private void fillFiltersMap() {
        if(filters_root == null) return;

        for(int i=0; i<filters_root.getChildCount(); i++) {
            StageTree node = filters_root.getChild(i);

            String fname = node.getChild(1).getText();
            if (filters.containsKey(fname)) throw new RuntimeException("Multiple definitions of filter " + fname);
            filters.put(fname, node);
        }
    }

    public void checkFilters() {
        if(filters_root == null) return;

        for(int i=0; i<filters_root.getChildCount(); i++) {
            checkFilter(filters_root.getChild(i));
        }
    }

    private void checkFilter(StageTree tree) {
        FilterSymbolTable symbol_table = new FilterSymbolTable(debug);

        symbol_table.pushScope();
        //add inputs to the scope.
        StageTree inputs = tree.getChild(0);
        for(int i=0; i<inputs.getChildCount(); i++) {
            symbol_table.add(inputs.getChild(i).getText(), Types.SAMPLER_T);
        }
        //add params to the scope.
        StageTree params = tree.getChild(2);
        for(int i=0; i<params.getChildCount(); i++) {
            String var_type = params.getChild(i).getChild(0).getText();
            String var_name = params.getChild(i).getChild(1).getText();
            if(!Types.containsForFilters(var_type)) throw new RuntimeException("Type " + var_type + " not valid for filters");
            symbol_table.add(var_name, Types.getByName(var_type));
        }

        symbol_table.pushScope();

        //check types for each instruction.
        StageTree instructions = tree.getChild(3);
        for(int i=0; i<instructions.getChildCount(); i++) {
            checkFilterInstruction(instructions.getChild(i), symbol_table);
        }
    }

    private void checkFilterInstruction(StageTree inst, FilterSymbolTable symbol_table) {
        switch (inst.getType()) {
            case StageLexer.FILTCALL:
                throw new RuntimeException("Can't make a call to a filter from a filter");
            case StageLexer.ADDFILT:
                throw new RuntimeException("Can't add new filters to pipeline from a filter");
            case StageLexer.BYPASSF:
                throw new RuntimeException("Can't bypass a filter from a filter");
            case StageLexer.QUIT:
                throw new RuntimeException("Can't QUIT a filter, perhaps you should use return");
            case StageLexer.DECLARE:
                if(inst.getChild(0).getType() == StageLexer.ARRAY) throw new RuntimeException("Cannot declare arrays in filter");
                if(!Types.containsForFilters(inst.getChild(0).getText())) throw new RuntimeException("Type " + inst.getChild(0).getText() + " not valid for filters");
                Types varType = Types.getByName(inst.getChild(0).getText());
                String varName = inst.getChild(1).getText();
                if(inst.getChildCount() > 2) {
                   if(!varType.isCompatibleWith(getExpressionType(inst.getChild(2), symbol_table))) {
                       throw new RuntimeException("Types don't match declaring: " + varName + " as " + varType.getName());
                   }
                }
                symbol_table.add(varName, varType);
                break;
            case StageLexer.ASSIGN:
                Types leftType = getExpressionType(inst.getChild(0), symbol_table);
                Types rightType = getExpressionType(inst.getChild(1), symbol_table);
                if(!leftType.isCompatibleWith(rightType)) throw new RuntimeException("Types don't match");
                break;
            case StageLexer.WHILE:
                Types w_condition = getExpressionType(inst.getChild(0), symbol_table);
                if(!Types.BOOL_T.isCompatibleWith(w_condition)) throw new RuntimeException("Condition expression must be boolean");

                symbol_table.pushScope();
                for(int i=0; i<inst.getChild(1).getChildCount(); i++) {
                    checkFilterInstruction(inst.getChild(1).getChild(i), symbol_table);
                }
                symbol_table.popScope();

                break;
            case StageLexer.IF:
                Types i_condition = getExpressionType(inst.getChild(0), symbol_table);
                if(!Types.BOOL_T.isCompatibleWith(i_condition)) throw new RuntimeException("Condition expression must be boolean");

                symbol_table.pushScope();
                for(int i=0; i<inst.getChild(1).getChildCount(); i++) {
                    checkFilterInstruction(inst.getChild(1).getChild(i), symbol_table);
                }
                symbol_table.popScope();

                //if there is else...
                if(inst.getChildCount() > 2) {
                    symbol_table.pushScope();
                    for(int i=0; i<inst.getChild(2).getChildCount(); i++) {
                        checkFilterInstruction(inst.getChild(2).getChild(i), symbol_table);
                    }
                    symbol_table.popScope();
                }

                break;
            case StageLexer.MEMBER:
            case StageLexer.ARRAY:
            case StageLexer.ID:
            case StageLexer.FUNCALL:
                getExpressionType(inst, symbol_table);
                break;
            case StageLexer.TIMECALL:
                throw new RuntimeException("Functions in filter cannot be called over time.");
            case StageLexer.RETURN:
                if(inst.getChildCount() == 0 || getExpressionType(inst.getChild(0), symbol_table) != Types.VEC4_T)
                    throw new RuntimeException("Filters must return a vec4");
                break;
            default:
                throw new RuntimeException("Instruction not recognised, this shouldn't appear here.");

        }

    }

    private Types getExpressionType(StageTree exp, FilterSymbolTable symbol_table) {
        if(exp.getType() == StageLexer.INT) {
            return Types.INT_T;
        }
        if(exp.getType() == StageLexer.FLOAT) {
            return Types.FLOAT_T;
        }
        if(exp.getType() == StageLexer.CHAR) {
            return Types.CHAR_T;
        }
        if(exp.getType() == StageLexer.STRING) {
            return Types.STRING_T;
        }
        if(exp.getType() == StageLexer.BOOLEAN) {
            return Types.BOOL_T;
        }
        if(exp.getType() == StageLexer.FUNCALL) {
            return getFunCallReturnType(exp, symbol_table, null);
        }
        if(exp.getType() == StageLexer.MEMBER) {
            return getMemberType(exp, symbol_table);
        }
        if(exp.getType() == StageLexer.ID) {
            return symbol_table.getType(exp.getText());
        }

        //One child operands.
        if(exp.getChildCount() == 1) { //we expect not or -  (- is an alias of not)
            String opName = exp.getText();
            if(exp.getType() == StageLexer.MINUS) opName = "not";
            Types leftType = getExpressionType(exp.getChild(0), symbol_table);
            return getMemberFunctionReturn(opName, leftType, null);
        }

        //Two child operands.
        if(exp.getChildCount() == 2) { //we expect or, and, ==, !=, >, <, >=, <=, +, -, *, /, %
            Types leftType = getExpressionType(exp.getChild(0), symbol_table);
            Types rightType[] = { getExpressionType(exp.getChild(1), symbol_table) };
            return getMemberFunctionReturn(exp.getText(), leftType, Arrays.asList(rightType));
        }

        throw new RuntimeException("Expression not recognized");
    }

    private Types getMemberType(StageTree tree, FilterSymbolTable symbol_table) {
        Types leftType = getExpressionType(tree.getChild(0), symbol_table);
        TypeInterface leftTypeInstance = leftType.getInstance();

        switch (tree.getChild(1).getType()) {
            case StageLexer.ID:
                Types ret = leftTypeInstance.getAttributeType(tree.getChild(1).getText());
                if(ret == null) throw new RuntimeException("Member " + tree.getChild(1).getText() + " not found in type " + leftTypeInstance.getTypeName());
                return ret;
            case StageLexer.FUNCALL:
                return getFunCallReturnType(tree.getChild(1), symbol_table, leftType);
            case StageLexer.ARRAY:
                String name = tree.getChild(1).getChild(0).getText();
                Types pos = getExpressionType(tree.getChild(1).getChild(1), symbol_table);
                List<Types> arrayAccess = leftTypeInstance.getMethodArgs("[");
                //We assume arrayAccess.size() == 2, else the function is wrong, in our code.
                if(arrayAccess.get(1) != pos) throw new RuntimeException("Access in array is type: " + pos.getName() + " expecting " + arrayAccess.get(1).getName());
                return arrayAccess.get(0);
            default:
                throw new RuntimeException("Instruction not recognised, this shouldn't appear here.");
        }
    }

    private Types getFunCallReturnType(StageTree tree, FilterSymbolTable symbol_table, Types leftType) {
        if(leftType == null) { //direct function.
            Map<String, Types[]> funcs = FilterGlobalFuncs.getTable();

            if(!funcs.containsKey(tree.getChild(0).getText())) throw new RuntimeException("Function " + tree.getChild(0).getText() + " doesn't exist");
            Types[] args = funcs.get(tree.getChild(0).getText());

            if(args.length-1 != tree.getChild(1).getChildCount()) throw new RuntimeException("Argument length doesn't fit for function " + tree.getChild(0).getText());
            for(int i=0; i<tree.getChild(1).getChildCount(); i++) {
                if(args[i+1] != getExpressionType(tree.getChild(1).getChild(i), symbol_table)) throw new RuntimeException("Method arguments don't have the same type");
            }
            return args[0];
        } else { //method
            ArrayList<Types> args = new ArrayList<Types>();
            for(int i=0; i< tree.getChild(2).getChildCount(); i++) {
                args.add(getExpressionType(tree.getChild(2).getChild(i), symbol_table));
            }

            return getMemberFunctionReturn(tree.getChild(1).getText(), leftType, args);
        }
    }

    private Types getMemberFunctionReturn(String name, Types base, List<Types> args) {
        TypeInterface myType = base.getInstance();
        List<Types> methodArgs = myType.getMethodArgs(name);

        if(args == null && methodArgs.size() == 1) return methodArgs.get(0); //No arguments needed.
        if(methodArgs.size()-1 != args.size()) throw new RuntimeException("Argument length doesn't fit for function " + name);
        for(int i=0; i<args.size(); i++) {
            if(methodArgs.get(i+1) != args.get(i)) throw new RuntimeException("Method arguments don't have the same type");
        }
        return methodArgs.get(0);
    }

}
