package interp.Semantic;

import interp.StageTree;
import interp.Types.*;
import parser.StageLexer;

import java.util.*;

public class SemanticsFunctions {
    /*public class FunctionSignature {
        public List<Types> args;
        public List<String> args_names;
        public Types ret;
        public StageTree root;
        public StageTree first, loop, last;
    }*/

    private HashMap<String, FunctionSignature> function_list;
    private HashMap<String, FilterSignature> filter_list;
    private StageTree functions_root = null;
    private boolean debug = true;
    private StageTree current_node = null;

    //temp vars.
    private FunctionSignature current_func;

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

    public int getLineNumber() {
        if(current_node == null) return -1;
        return current_node.getLine();
    }

    public HashMap<String, FunctionSignature> getFunctionList() { return function_list; }

    public StageTree getFunctionsRoot() {
        return functions_root;
    }

    //TODO, check if argument is an ARRAY.
    private void fillFunctionsMap() {
        if(functions_root == null) return;

        FunctionList builtinFuncs = FunctionGlobalFuncs.getTable();

        for(int i=0; i<functions_root.getChildCount(); i++) {
            current_node = functions_root.getChild(i);
            String fname = functions_root.getChild(i).getChild(0).getText();
            if(builtinFuncs.exists(fname)) throw new RuntimeException("Function name " + fname + " reserved for builtin functions.");
            if (function_list.containsKey(fname)) throw new RuntimeException("Multiple definitions of function " + fname);

            StageTree params;

            FunctionSignature func_sig = new FunctionSignature();
            func_sig.name = fname;
            func_sig.root = functions_root.getChild(i);
            func_sig.args = new ArrayList<Types>();
            func_sig.args_names = new ArrayList<String>();

            if(func_sig.root.getChild(1).getType() == StageLexer.ID) {
                func_sig.ret = Types.getByNameFunctions(func_sig.root.getChild(1).getText());
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
                //TODO add array compatibility if(node.getType() != StageLexer.ARRAY)
                func_sig.args.add(Types.getByNameFunctions(node.getChild(0).getText()));
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
        current_func = func;
        FunctionSymbolTable symbol_table = new FunctionSymbolTable(debug);

        symbol_table.pushScope();
        for(int i=0; i<func.args.size(); i++) {
            symbol_table.add(func.args_names.get(i), func.args.get(i));
        }

        if(func.first != null) {
            symbol_table.pushScope();
            for(int i=0; i<func.first.getChildCount(); i++) {
                checkInstruction(func.first.getChild(i), symbol_table);
            }
        }

        if(func.loop != null) {
            symbol_table.pushScope();
            for(int i=0; i<func.loop.getChildCount(); i++) {
                checkInstruction(func.loop.getChild(i), symbol_table);
            }
            symbol_table.popScope();
        }

        if(func.last != null) {
            symbol_table.pushScope();
            for(int i=0; i<func.last.getChildCount(); i++) {
                checkInstruction(func.last.getChild(i), symbol_table);
            }
        }

        //TODO check return.
    }

    private void checkInstruction(StageTree inst, FunctionSymbolTable symbol_table) {
        current_node = inst;
        switch (inst.getType()) {
            case StageLexer.BYPASSF:
                TypeInterface toskip = symbol_table.getType(inst.getChild(0).getText()).getTypeInterfaceInstance();
                if(! (toskip instanceof NodeInterface))  throw new RuntimeException(inst.getChild(0).getText() + " can't be input of a filter.");
                if(inst.getChild(1).getType() != StageLexer.INT) {
                    TypeInterface with = symbol_table.getType(inst.getChild(1).getText()).getTypeInterfaceInstance();
                    if(! (with instanceof NodeInterface))  throw new RuntimeException(inst.getChild(1).getText() + " can't be input of a filter.");
                } else {
                    inst.getChild(1).setIntValue();
                }
                break;
            case StageLexer.QUIT:
                //Nothing to check.
                break;
            case StageLexer.EMPTYFILT:
                TypeInterface leftFilt  = symbol_table.getType(inst.getChild(0).getText()).getTypeInterfaceInstance();
                TypeInterface rightFilt = symbol_table.getType(inst.getChild(1).getText()).getTypeInterfaceInstance();
                if(! (leftFilt instanceof NodeInterface))  throw new RuntimeException(inst.getChild(0).getText() + "<" + leftFilt.getTypeName().getName() + "> can't be input/output of a filter.");
                if(! (rightFilt instanceof NodeInterface)) throw new RuntimeException(inst.getChild(1).getText() + " can't be input/output of a filter.");
                if(!((NodeInterface)rightFilt).writable()) throw new RuntimeException(inst.getChild(1).getText() + " can't be output of a filter.");
                break;
            case StageLexer.FILTCALL:
                String filter_name = inst.getChild(1).getText();

                int numInputs = inst.getChild(0).getChildCount();
                for(int i=0; i<numInputs; i++) {
                    TypeInterface input = symbol_table.getType(inst.getChild(0).getChild(i).getText()).getTypeInterfaceInstance();
                    if(! (input instanceof NodeInterface))  throw new RuntimeException(inst.getChild(0).getChild(i).getText() + " can't be input of a filter.");
                }

                TypeInterface output = symbol_table.getType(inst.getChild(3).getText()).getTypeInterfaceInstance();
                if(! (output instanceof NodeInterface)) throw new RuntimeException(inst.getChild(3).getText() + " can't be output of a filter.");
                if(!((NodeInterface)output).writable()) throw new RuntimeException(inst.getChild(3).getText() + " can't be output of a filter.");

                ArrayList<Types> args = new ArrayList<Types>();

                for(int i=0; i<inst.getChild(2).getChildCount(); i++) {
                    args.add( getExpressionType(inst.getChild(2).getChild(i), symbol_table) );
                }

                if(!filter_list.containsKey(filter_name)) throw new RuntimeException("Filter " + filter_name + " doesn't exist.");
                FilterSignature f = filter_list.get(filter_name);

                if(f.inputs.size() != numInputs) throw new RuntimeException("Filter call to " + filter_name + " number of inputs don't match");
                if(!f.args.equals(args)) throw new RuntimeException("Filter call to " + filter_name + " parameter types don't match.");
                break;
            case StageLexer.ADDFILT:
                TypeInterface toadd = symbol_table.getType(inst.getChild(0).getText()).getTypeInterfaceInstance();
                if(! (toadd instanceof NodeInterface))  throw new RuntimeException(inst.getChild(0).getText() + " can't be input of a filter.");
                checkInstruction(inst.getChild(1), symbol_table);
                break;

            case StageLexer.DECLARE:
                Types varType;

                if(inst.getChild(0).getType() == StageLexer.ARRAY) {
                    varType = Types.getByArrayTypeFunctions(inst.getChild(0).getChild(0).getText());
                    if(inst.getChild(0).getChild(1).getType() != StageLexer.INT) throw new RuntimeException("Array declaration parameter can only be an integer");
                    inst.getChild(0).getChild(1).setIntValue();
                } else {
                    varType = Types.getByNameFunctions(inst.getChild(0).getText());
                }
                inst.getChild(0).setVarType(varType);

                String varName = inst.getChild(1).getText();
                if(inst.getChildCount() > 2) {
                    if(varType != getExpressionType(inst.getChild(2), symbol_table)) throw new RuntimeException("Types don't match declaring: " + varName + " as " + varType.getName());
                }
                symbol_table.add(varName, varType);
                break;
            case StageLexer.ASSIGN:
                //TODO: check assignability.
                Types leftType = getExpressionType(inst.getChild(0), symbol_table);
                Types rightType = getExpressionType(inst.getChild(1), symbol_table);
                if(leftType != rightType) throw new RuntimeException("Types don't match");
                break;
            case StageLexer.WHILE:
                Types w_condition = getExpressionType(inst.getChild(0), symbol_table);
                if(Types.BOOL_T != w_condition) throw new RuntimeException("Condition expression must be boolean");

                symbol_table.pushScope();
                for(int i=0; i<inst.getChild(1).getChildCount(); i++) {
                    checkInstruction(inst.getChild(1).getChild(i), symbol_table);
                }
                symbol_table.popScope();
                break;
            case StageLexer.IF:
                Types i_condition = getExpressionType(inst.getChild(0), symbol_table);
                if(Types.BOOL_T != i_condition) throw new RuntimeException("Condition expression must be boolean");

                symbol_table.pushScope();
                for(int i=0; i<inst.getChild(1).getChildCount(); i++) {
                    checkInstruction(inst.getChild(1).getChild(i), symbol_table);
                }
                symbol_table.popScope();

                //if there is else...
                if(inst.getChildCount() > 2) {
                    symbol_table.pushScope();
                    for(int i=0; i<inst.getChild(2).getChildCount(); i++) {
                        checkInstruction(inst.getChild(2).getChild(i), symbol_table);
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
                getExpressionType(inst.getChild(0), symbol_table);
                if(getExpressionType(inst.getChild(1), symbol_table) != Types.FLOAT_T
                   | getExpressionType(inst.getChild(2), symbol_table) != Types.FLOAT_T)
                    throw new RuntimeException("Time values must be float.");
                break;
            case StageLexer.RETURN:
                if(inst.getChildCount() == 0 && current_func.ret != Types.VOID_T) throw new RuntimeException("Function must return a " + current_func.ret.getName() + ".");
                if(inst.getChildCount() != 0 && getExpressionType(inst.getChild(0), symbol_table) != current_func.ret)
                    throw new RuntimeException("Function must return a " + current_func.ret.getName() + ".");
                break;
            default:
                throw new RuntimeException("Instruction not recognised, this shouldn't appear here.");
        }
    }

    private Types getExpressionType(StageTree exp, FunctionSymbolTable symbol_table) {
        current_node = exp;
        if(exp.getType() == StageLexer.INT) {
            exp.setIntValue();
            return Types.INT_T;
        }
        if(exp.getType() == StageLexer.FLOAT) {
            exp.setFloatValue();
            return Types.FLOAT_T;
        }
        if(exp.getType() == StageLexer.CHAR) {
            exp.setCharValue();
            return Types.CHAR_T;
        }
        if(exp.getType() == StageLexer.STRING) {
            exp.setStringValue();
            return Types.STRING_T;
        }
        if(exp.getType() == StageLexer.BOOLEAN) {
            exp.setBooleanValue();
            return Types.BOOL_T;
        }
        if(exp.getType() == StageLexer.FUNCALL) {
            Types retType = getFunCallReturn(exp, symbol_table);
            exp.setVarType(retType);
            return retType;
        }
        if(exp.getType() == StageLexer.ARRAY) {
            Types leftType = symbol_table.getType(exp.getChild(0).getText());
            Types pos = getExpressionType(exp.getChild(1), symbol_table);
            Types array_access_ret = leftType.getTypeInterfaceInstance().getMethodArgs("[", Arrays.asList(pos) );
            if(array_access_ret == null) throw new RuntimeException("Type: " + pos.getName() + " has no array access for this kind of index");
                exp.setVarType(array_access_ret);
                exp.getChild(0).setVarType(leftType);
                exp.getChild(1).setVarType(pos);
            return array_access_ret;
        }
        if(exp.getType() == StageLexer.MEMBER) {
            return getMemberType(exp, symbol_table);
        }
        if(exp.getType() == StageLexer.ID) {
            Types type = symbol_table.getType(exp.getText());
            exp.setVarType(type);
            return type;
        }

        //One child operands.
        if(exp.getChildCount() == 1) { //we expect not or -  (- is an alias of not)
            String opName = exp.getText();
            if(exp.getType() == StageLexer.MINUS) opName = "not"; //TODO think if it's necessary.
            Types leftType = getExpressionType(exp.getChild(0), symbol_table);

            Types retType = getMemberFunCallReturn(opName, leftType, new ArrayList<Types>());

            exp.getChild(0).setVarType(leftType);
            exp.setVarType(retType);
            return retType;
        }

        //Two child operands.
        if(exp.getChildCount() == 2) { //we expect or, and, ==, !=, >, <, >=, <=, +, -, *, /, %
            Types leftType = getExpressionType(exp.getChild(0), symbol_table);
            Types rightType = getExpressionType(exp.getChild(1), symbol_table);
            Types retType = getMemberFunCallReturn(exp.getText(), leftType, Arrays.asList(rightType));

            exp.getChild(0).setVarType(leftType);
            exp.getChild(1).setVarType(rightType);
            exp.setVarType(retType);
            return retType;
        }

        throw new RuntimeException("Expression not recognized");
    }

    private Types getFunCallReturn(StageTree tree, FunctionSymbolTable symbol_table) {
        current_node = tree;
        String fname = tree.getChild(0).getText();
        ArrayList<Types> args = new ArrayList<Types>();
        for(int i=0; i<tree.getChild(1).getChildCount(); i++) {
            Types parmesano = getExpressionType(tree.getChild(1).getChild(i), symbol_table);
            //tree.getChild(1).getChild(i).setVarType(parmesano); no need, getExpression does it.
            args.add(parmesano);
        }

        if(FunctionGlobalFuncs.getTable().exists(fname, args)) { //Check builtin functions.
            return FunctionGlobalFuncs.getTable().getFunction(fname,args).ret;
        } else if(function_list.containsKey(fname)) { //Check global functions.
            if(!function_list.get(fname).args.equals(args)) throw new RuntimeException("Calling function " + fname + " with wrong parameters. Calling with " + args);
            return function_list.get(fname).ret;
        }
        throw new RuntimeException("Function " + fname + " doesn't exist or has wrong parameters. Calling with " + args);
    }

    private Types getMemberFunCallReturn(String name, Types base, List<Types> args) {
        TypeInterface myType = base.getTypeInterfaceInstance();
        Types method_return = myType.getMethodArgs(name, args);

        if(method_return == null) throw new RuntimeException("Method " + name + " arguments don't match");
        return method_return;
    }

    private Types getMemberType(StageTree tree, FunctionSymbolTable symbol_table) {
        current_node = tree;
        Types leftType = getExpressionType(tree.getChild(0), symbol_table);
        TypeInterface leftTypeInstance = leftType.getTypeInterfaceInstance();

        Types ret;
        StageTree node = tree.getChild(1);

        switch (node.getType()) {
            case StageLexer.ID:
                ret = leftTypeInstance.getAttributeType(node.getText());
                node.setVarType(ret);
                if(ret == null) throw new RuntimeException("Member " + node.getText() + " doesn't exist in type " + leftTypeInstance.getTypeName());
                return ret;
            case StageLexer.FUNCALL:
                String fname = node.getChild(0).getText();
                ArrayList<Types> args = new ArrayList<Types>();
                for(int i=0; i<node.getChild(1).getChildCount(); i++) {
                    Types gorgonzola = getExpressionType(node.getChild(1).getChild(i), symbol_table);
                    args.add(gorgonzola);
                }
                ret = leftTypeInstance.getMethodArgs(fname, args);
                if(ret == null) throw new RuntimeException("Method " + fname + " arguments don't match");
                node.setVarType(ret);
                return ret;
            case StageLexer.ARRAY:
                String name = node.getChild(0).getText();
                Types pos = getExpressionType(node.getChild(1), symbol_table);
                //Check array is a member.
                Types member_arr = leftTypeInstance.getAttributeType(name);
                if(member_arr == null) throw new RuntimeException("Member " + name + " not found in type " + leftTypeInstance.getTypeName());
                //Check tipes of array and values it returns
                ret = member_arr.getTypeInterfaceInstance().getMethodArgs("[", Arrays.asList(pos));
                if(ret == null) throw new RuntimeException("Member " + name + " of type " + member_arr.getName() + " has no array access for this kind of index");
                node.setVarType(ret);
                node.getChild(0).setVarType(member_arr);
                node.getChild(1).setVarType(pos);
                return ret;
            default:
                throw new RuntimeException("Instruction not recognised, this shouldn't appear here.");
        }
    }
}
