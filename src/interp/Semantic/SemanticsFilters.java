package interp.Semantic;

import interp.StageTree;
import interp.Types.*;
import parser.StageLexer;

import java.util.*;

public class SemanticsFilters {
    private HashMap<String, StageTree> filters = null;
    private HashMap<String, FilterSignature> filter_list;
    StageTree filters_root = null;
    private StageTree currentNode = null;

    boolean debug = true;

    public SemanticsFilters(StageTree tree, boolean debug) {
        this.debug = debug;

        filters = new HashMap<String, StageTree>();
        filter_list = new HashMap<String, FilterSignature>();

        for(int i=0; i<Math.max(tree.getChildCount(),2); i++) {
            StageTree node = tree.getChild(i);
            if(node.getType() == StageLexer.LIST_FILTERS) filters_root = node;
        }

        fillFiltersMap();
    }

    public int getLineNumber() {
        if(currentNode == null) return -1;
        return currentNode.getLine();
    }

    public StageTree getFiltersRoot() {
        return filters_root;
    }

    private void fillFiltersMap() {
        if(filters_root == null) return;

        for(int i=0; i<filters_root.getChildCount(); i++) {
            StageTree node = filters_root.getChild(i);
            currentNode = node;

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

        setFilterList();
    }

    public HashMap<String, FilterSignature> getFilterList() {
        return filter_list;
    }

    private void setFilterList() {
        for(int i=0; i<filters_root.getChildCount(); i++) {
            StageTree node = filters_root.getChild(i);

            FilterSignature fs = new FilterSignature();
            fs.name = node.getChild(1).getText();
            fs.args = new ArrayList<Types>();
            fs.args_names = new ArrayList<String>();
            fs.inputs = new ArrayList<String>();

            for(int j=0; j<node.getChild(0).getChildCount(); j++) {
                fs.inputs.add(node.getChild(0).getChild(j).getText());
            }
            for(int j=0; j<node.getChild(2).getChildCount(); j++) {
                //TODO chekckckck rays maybe already chkd.
                String var_type = node.getChild(2).getChild(j).getChild(0).getText();
                String var_name = node.getChild(2).getChild(j).getChild(1).getText();
                fs.args.add( Types.getByNameFilters(var_type) );
                fs.args_names.add( var_name );
            }
            filter_list.put(fs.name, fs);
        }
    }

    //TODO check arrays in headers of filters.
    private void checkFilter(StageTree tree) {
        FilterSymbolTable symbol_table = new FilterSymbolTable(debug);
        currentNode = tree;

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
            symbol_table.add(var_name, Types.getByNameFilters(var_type));
        }

        symbol_table.pushScope();

        //check types for each instruction.
        StageTree instructions = tree.getChild(3);
        for(int i=0; i<instructions.getChildCount(); i++) {
            checkFilterInstruction(instructions.getChild(i), symbol_table);
        }
    }

    private void checkFilterInstruction(StageTree inst, FilterSymbolTable symbol_table) {
        currentNode = inst;
        switch (inst.getType()) {
            case StageLexer.FILTCALL:
            case StageLexer.EMPTYFILT:
                throw new RuntimeException("Can't make a call to a filter from a filter");
            case StageLexer.ADDFILT:
                throw new RuntimeException("Can't add new filters to pipeline from a filter");
            case StageLexer.BYPASSF:
                throw new RuntimeException("Can't bypass a filter from a filter");
            case StageLexer.QUIT:
                throw new RuntimeException("Can't QUIT a filter, perhaps you should use return");
            case StageLexer.DECLARE:
                if(inst.getChild(0).getType() == StageLexer.ARRAY) throw new RuntimeException("Cannot declare arrays in filter");
                Types varType = Types.getByNameFilters(inst.getChild(0).getText());
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
                getFunCallReturnType(inst, symbol_table);
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
        currentNode = exp;
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
            return getFunCallReturnType(exp, symbol_table);
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
        currentNode = tree;
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

    private Types getFunCallReturnType(StageTree tree, FilterSymbolTable symbol_table) {
        currentNode = tree;
        FunctionList funcs = FilterGlobalFuncs.getTable();

        ArrayList<Types> args = new ArrayList<Types>();
        for(int i=0; i< tree.getChild(1).getChildCount(); i++) {
            args.add(getExpressionType(tree.getChild(1).getChild(i), symbol_table));
        }

        String name = tree.getChild(0).getText();

        if(!funcs.exists(name,args)) {
            throw new RuntimeException("Function " + name + " doesn't exist or has wrong parameters. Calling with " + args);
        }

        return funcs.getFunction(name,args).ret;
    }

    private Types getMemberFunctionReturn(String name, Types base, List<Types> args) {
        TypeInterface myType = base.getInstance();
        Types method_return = myType.getMethodArgs(name, args);

        if(method_return == null) throw new RuntimeException("Method " + name + " arguments don't match");
        return method_return;
    }

}
