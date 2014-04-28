package interp.Semantic;

import interp.StageTree;
import interp.Types.FilterSignature;
import interp.Types.FunctionList;
import interp.Types.TypeInterface;
import interp.Types.Types;
import parser.StageLexer;
import sun.org.mozilla.javascript.internal.Function;

import java.util.*;

public class SemanticsFunctions {
    public class FunctionSignature {
        public List<Types> args;
        public List<String> args_names;
        public Types ret;
        public StageTree root;
        public StageTree first, loop, last;
    }

    private HashMap<String, FunctionSignature> function_list;
    private HashMap<String, FilterSignature> filter_list;
    private StageTree functions_root = null;
    private boolean debug = true;

    public SemanticsFunctions(StageTree tree, SemanticsFilters sm, boolean debug) {
        this.debug = debug;

        function_list = new HashMap<String, FunctionSignature>();
        filter_list = sm.getFilterList();

        for(int i=0; i<Math.max(tree.getChildCount(),2); i++) {
            StageTree node = tree.getChild(i);
            if(node.getType() == StageLexer.LIST_FUNCTIONS) functions_root = node;
        }

        fillFunctionsMap();
    }

    public StageTree getFunctionsRoot() {
        return functions_root;
    }

    //TODO, check if argument is an ARRAY.
    private void fillFunctionsMap() {
        if(functions_root == null) return;

        for(int i=0; i<functions_root.getChildCount(); i++) {
            String fname = functions_root.getChild(i).getChild(0).getText();
            if (function_list.containsKey(fname)) throw new RuntimeException("Multiple definitions of function " + fname);
            StageTree params;

            FunctionSignature func_sig = new FunctionSignature();
            func_sig.root = functions_root.getChild(i);
            func_sig.args = new ArrayList<Types>();
            func_sig.args_names = new ArrayList<String>();

            if(func_sig.root.getChild(1).getType() == StageLexer.ID) {
                String ret_type_name = func_sig.root.getChild(1).getText();
                if(Types.containsForFunctions(ret_type_name)) {
                    func_sig.ret = Types.getByName(ret_type_name);
                } else throw new RuntimeException("Type " + ret_type_name + " not recognized for functions");

                params = func_sig.root.getChild(2);
            } else {
                func_sig.ret = Types.VOID_T;
                params = func_sig.root.getChild(1);
            }

            for(int j=0; j<func_sig.root.getChildCount(); j++) {
                StageTree node = func_sig.root.getChild(j);
                if(node.getType() == StageLexer.FIRST) func_sig.first = node;
                if(node.getType() == StageLexer.LOOP) func_sig.loop = node;
                if(node.getType() == StageLexer.LAST) func_sig.last = node;
            }

            for(int j=0; j<params.getChildCount(); j++) {
                StageTree node = params.getChild(j);
                if(Types.containsForFunctions(node.getChild(0).getText())) {
                    func_sig.args.add(Types.getByName(node.getChild(0).getText()));
                } else throw new RuntimeException("Type " + node.getChild(0).getText() + " not recognized for functions");

                func_sig.args_names.add(node.getChild(1).getText());
            }
            function_list.put(fname, func_sig);
        }
    }

    public void checkFunctions() {
        Iterator it = function_list.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, FunctionSignature> pairs = (Map.Entry)it.next();
            checkFunction(pairs.getValue());
        }
    }

    private void checkFunction(FunctionSignature func) {
        FunctionSymbolTable symbol_table = new FunctionSymbolTable(debug);

        symbol_table.pushScope();
        for(int i=0; i<func.args.size(); i++) {
            symbol_table.add(func.args_names.get(i), func.args.get(i));
        }

        symbol_table.pushScope();
        for(int i=0; i<func.first.getChildCount(); i++) {
            checkInstruction(func.first.getChild(i), symbol_table);
        }

        symbol_table.pushScope();
        for(int i=0; i<func.loop.getChildCount(); i++) {
            checkInstruction(func.loop.getChild(i), symbol_table);
        }
        symbol_table.popScope();

        symbol_table.pushScope();
        for(int i=0; i<func.last.getChildCount(); i++) {
            checkInstruction(func.last.getChild(i), symbol_table);
        }

        //TODO check return.
    }

    private void checkInstruction(StageTree inst, FunctionSymbolTable symbol_table) {
        switch (inst.getType()) {
            case StageLexer.FILTCALL:

                break;

            case StageLexer.DECLARE:
                if(inst.getChild(0).getType() == StageLexer.ARRAY) {
                    if(!Types.containsForFunctions(inst.getChild(0).getChild(0).getText())) throw new RuntimeException("Type " + inst.getChild(0).getChild(0).getText() + " not valid for functions");
                    if(inst.getChild(0).getChild(1).getType() != StageLexer.INT) throw new RuntimeException("Array declaration parameter can only be an int");

                    Types varType = Types.getByName(inst.getChild(0).getChild(0).getText());
                    String varName = inst.getChild(1).getText();


                    symbol_table.addArray(varName, varType);
                } else {
                    if(!Types.containsForFunctions(inst.getChild(0).getText())) throw new RuntimeException("Type " + inst.getChild(0).getText() + " not valid for functions");
                    Types varType = Types.getByName(inst.getChild(0).getText());
                    String varName = inst.getChild(1).getText();
                    if(inst.getChildCount() > 2) {
                        if(varType != getExpressionType(inst.getChild(2), symbol_table)) {
                            throw new RuntimeException("Types don't match declaring: " + varName + " as " + varType.getName());
                        }
                    }
                    symbol_table.add(varName, varType);
                }

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
                    if(varType != getExpressionType(inst.getChild(2), symbol_table)) {
                        throw new RuntimeException("Types don't match declaring: " + varName + " as " + varType.getName());
                    }
                }
                symbol_table.add(varName, varType);
                break;
            case StageLexer.ASSIGN:
                //TODO: check assignability (not all vars are writable).
                Types leftType = getExpressionType(inst.getChild(0), symbol_table);
                Types rightType = getExpressionType(inst.getChild(1), symbol_table);
                if(leftType != rightType) throw new RuntimeException("Types don't match");
                break;
            case StageLexer.WHILE:
                Types w_condition = getExpressionType(inst.getChild(0), symbol_table);
                if(Types.BOOL_T != w_condition) throw new RuntimeException("Condition expression must be boolean");

                symbol_table.pushScope();
                for(int i=0; i<inst.getChild(1).getChildCount(); i++) {
                    checkFilterInstruction(inst.getChild(1).getChild(i), symbol_table);
                }
                symbol_table.popScope();

                break;
            case StageLexer.IF:
                Types i_condition = getExpressionType(inst.getChild(0), symbol_table);
                if(Types.BOOL_T != i_condition) throw new RuntimeException("Condition expression must be boolean");

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
            /* THere are no member functions in filters, so any of that will give no result (except funcall)
            case StageLexer.MEMBER:
            case StageLexer.ARRAY:
            case StageLexer.ID:
            case StageLexer.FUNCALL:
                getExpressionType(inst, symbol_table);
                break;*/
            case StageLexer.MEMBER:
            case StageLexer.ARRAY:
            case StageLexer.ID:
                throw new RuntimeException("Instruction does nothing or calls member function which is not allowed in filters.");
            case StageLexer.FUNCALL:
                getFunCallReturnType(inst, symbol_table, null);
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
        if(exp.getType() == StageLexer.ARRAY) {
            String name = exp.getChild(0).getText();
            Types pos = getExpressionType(exp.getChild(1), symbol_table);
            Types leftType = symbol_table.getType(name);
            Types array_access_ret = leftType.getInstance().getMethodArgs("[", Arrays.asList(pos) );
            if(array_access_ret == null) throw new RuntimeException("Type: " + pos.getName() + " has no array access for this kind of index");
            return array_access_ret;
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
            return getMemberFunctionReturn(opName, leftType, new ArrayList<Types>());
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
                throw new RuntimeException("Member functions can not be called from filter. Calling " + tree.getChild(1).getText() + " in type " + leftTypeInstance.getTypeName());
                //return getFunCallReturnType(tree.getChild(1), symbol_table, leftType);
            case StageLexer.ARRAY:
                String name = tree.getChild(1).getChild(0).getText();
                Types pos = getExpressionType(tree.getChild(1).getChild(1), symbol_table);

                //Check member is in array.
                Types member_arr = leftTypeInstance.getAttributeType(name);
                if(member_arr == null) throw new RuntimeException("Member " + name + " not found in type " + leftTypeInstance.getTypeName());

                //Check tipes of array and values it returns
                Types array_access_ret = member_arr.getInstance().getMethodArgs("[", Arrays.asList(pos));
                if(array_access_ret == null) throw new RuntimeException("Type: " + member_arr + " in " + name + " has no array access for this kind of index");
                return array_access_ret;
            default:
                throw new RuntimeException("Instruction not recognised, this shouldn't appear here.");
        }
    }

    private Types getFunCallReturnType(StageTree tree, FilterSymbolTable symbol_table, Types leftType) {
        if(leftType == null) { //direct function.
            FunctionList funcs = FilterGlobalFuncs.getTable();

            ArrayList<Types> args = new ArrayList<Types>();
            for(int i=0; i< tree.getChild(1).getChildCount(); i++) {
                args.add(getExpressionType(tree.getChild(1).getChild(i), symbol_table));
            }

            String name = tree.getChild(0).getText();

            if(!funcs.exists(name,args)) {
                throw new RuntimeException("Function " + name + " doesn't exist or has wrong parameters. Calling with " + args);
            }

            return funcs.getReturn(name,args);
        } else { //method //TODO this call is always with null. Let it here until you do the interpreter to copy & paste. IN FACT THIS DOESNT WORK, CHILDS IDS ARE WRONG.
            ArrayList<Types> args = new ArrayList<Types>();
            for(int i=0; i< tree.getChild(2).getChildCount(); i++) {
                args.add(getExpressionType(tree.getChild(2).getChild(i), symbol_table));
            }

            return getMemberFunctionReturn(tree.getChild(1).getText(), leftType, args);
        }
    }

    private Types getMemberFunctionReturn(String name, Types base, List<Types> args) {
        TypeInterface myType = base.getInstance();
        Types method_return = myType.getMethodArgs(name, args);

        if(method_return == null) throw new RuntimeException("Method " + name + " arguments don't match");
        return method_return;
    }

}
