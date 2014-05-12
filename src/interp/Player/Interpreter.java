package interp.Player;

import interp.Semantic.FunctionGlobalFuncs;
import interp.Semantic.FunctionGlobalVars;
import interp.StageTree;
import interp.Types.*;
import parser.StageLexer;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//TODO node reference counter for return and funcall.

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
//                System.out.println("FIRST");
//                current_stack.printAllScopes();
                break;
            case Player.LOOP:
                if(func.loop == null) return;
                current_stack.pushScope();
                runFuncs(func.loop);
//                System.out.println("LOOP");
//                current_stack.printAllScopes();
                current_stack.popScope();
//                System.out.println("LOOP AFTER");
//                current_stack.printAllScopes();
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
                NodeInterface from = (NodeInterface)evaluateExpr(inst.getChild(0),true);
                NodeInterface to   = (NodeInterface)evaluateExpr(inst.getChild(1),true);
                scene_graph.addEffect(to, null, null, Arrays.asList(from));
                break;
            case StageLexer.FILTCALL:
                NodeInterface node = (NodeInterface)evaluateExpr(inst.getChild(3),true);

                String filter_name = inst.getChild(1).getText();
                FilterSignature filt_sig = filter_list.get(filter_name);

                ArrayList<TypeInterface> args_values = new ArrayList<TypeInterface>();
                for(int i=0; i<inst.getChild(2).getChildCount(); i++) {
                    args_values.add( evaluateExpr(inst.getChild(2).getChild(i), false) );
                }

                ArrayList<NodeInterface> input_nodes = new ArrayList<NodeInterface>();
                for(int i=0; i<inst.getChild(0).getChildCount(); i++) {
                    input_nodes.add( (NodeInterface) evaluateExpr(inst.getChild(0).getChild(i), true) );
                }
                scene_graph.addEffect(node, filt_sig, args_values, input_nodes);
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

                    if(var instanceof NodeInterface) {
                        scene_graph.addNode((NodeInterface) var);
                        scene_graph.addRef((NodeInterface) var);
                    }
                    current_stack.add(varName, var);
                } else {
                    TypeInterface t = evaluateExpr(inst.getChild(2), false);
                    if(t instanceof NodeInterface) scene_graph.addRef((NodeInterface) t);
                    current_stack.add(varName, t);
                }
                break;
            case StageLexer.ASSIGN:
                TypeInterface leftT = evaluateExpr(inst.getChild(0), true); //pass left whatever by reference.
                TypeInterface rightT = evaluateExpr(inst.getChild(1), false); //make a copy of right whatever.
                if(rightT instanceof NodeInterface) scene_graph.addRef((NodeInterface) rightT);
                if(leftT  instanceof NodeInterface) scene_graph.delRef((NodeInterface) leftT );
                leftT.set(rightT);
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
                StageStack fun_stack = new StageStack(scene_graph);
                FloatType stTime = (FloatType)evaluateExpr(inst.getChild(1), false);
                FloatType edTime = (FloatType)evaluateExpr(inst.getChild(2), false);

                StageTree funcall = inst.getChild(0);
                String funname = funcall.getChild(0).getText();
                StageTree argst = funcall.getChild(1);
                FunctionSignature fs = function_list.get(funname);

                for(int i=0; i<argst.getChildCount(); i++) {
                    TypeInterface tps = evaluateExpr(argst.getChild(i), true);
                    fun_stack.add(fs.args_names.get(i), tps);
                    if(tps instanceof NodeInterface) scene_graph.addRef((NodeInterface) tps);
                }
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

    /*
     * Hardcoded values (int,float,char,string,bool) always passed by copy.
     * Funcall returns always passed by copy (return does it).
     *  Array passed by copy if specified.
     *  Member passed by copy if specified.
     *  Id passed by copy if specified.
     * Operators always passed by copy.
     */
    private TypeInterface evaluateExpr(StageTree exp, boolean getByReference) {
        switch (exp.getType()) {
            case StageLexer.INT:
            case StageLexer.FLOAT:
            case StageLexer.CHAR:
            case StageLexer.STRING:
            case StageLexer.BOOLEAN:
                TypeInterface t = exp.getVarType().getInstance(); //we make a copy.
                t.set(exp.getValue());
                return t;
            case StageLexer.FUNCALL:
                String func_name = exp.getChild(0).getText();
                ArrayList<TypeInterface> fargs = new ArrayList<TypeInterface>();
                for(int i=0; i<exp.getChild(1).getChildCount(); i++) {
                    TypeInterface tps = evaluateExpr(exp.getChild(1).getChild(i), false);
                    fargs.add(tps);
                    if(tps instanceof NodeInterface) scene_graph.addRef((NodeInterface) tps);
                }

                if(FunctionGlobalFuncs.getTable().exists(func_name)) {
                    return FunctionGlobalFuncs.callFunc(func_name, fargs);
                } else {
                    return getFuncReturn(func_name, fargs);
                }
            case StageLexer.ARRAY:
                TypeInterface leftT = current_stack.getVar(exp.getChild(0).getText());
                TypeInterface pos = (IntType) evaluateExpr(exp.getChild(1), false);

                if(getByReference) return leftT.callMethod("[", Arrays.asList(pos));
                else {
                    TypeInterface ret = exp.getVarType().getInstance();
                    ret.set(leftT.callMethod("[", Arrays.asList(pos)));
                    return ret;
                }
            case StageLexer.MEMBER:
                TypeInterface m_leftT = evaluateExpr(exp.getChild(0), getByReference);

                StageTree node = exp.getChild(1);
                switch (node.getType()) {
                    case StageLexer.ID:
                        TypeInterface m = m_leftT.getAttribute(node.getText());
                        if(getByReference) return m;
                        else {
                            TypeInterface r = m.getTypeName().getInstance();
                            r.set(m);
                            return r;
                        }
                    case StageLexer.FUNCALL:
                        String fname = node.getChild(0).getText();
                        ArrayList<TypeInterface> args = new ArrayList<TypeInterface>();
                        for(int i=0; i<node.getChild(1).getChildCount(); i++) {
                            TypeInterface tps = evaluateExpr(node.getChild(1).getChild(i), false);
                            args.add(tps);
                            if(tps instanceof NodeInterface) scene_graph.addRef((NodeInterface) tps);
                        }
                        TypeInterface fm = m_leftT.callMethod(fname, args);
                        if(getByReference) return fm;
                        else {
                            TypeInterface r = fm.getTypeName().getInstance();
                            r.set(fm);
                            return r;
                        }
                    case StageLexer.ARRAY:
                        String name = node.getChild(0).getText();
                        TypeInterface m_pos = evaluateExpr(node.getChild(1), false);
                        TypeInterface am = m_leftT.getAttribute(name).callMethod("[", Arrays.asList(m_pos));
                        if(getByReference) return am;
                        else {
                            TypeInterface r = am.getTypeName().getInstance();
                            r.set(am);
                            return r;
                        }
                    default:
                        throw new RuntimeException("Instruction not recognised, this shouldn't appear here.");
                }
            case StageLexer.ID:
                if(current_stack.exists(exp.getText())) {
                    TypeInterface tid = current_stack.getVar(exp.getText());
                    if(getByReference) return tid;
                    else {
                        TypeInterface r = tid.getTypeName().getInstance();
                        r.set(tid);
                        return r;
                    }
                } else {
                    TypeInterface tid = FunctionGlobalVars.getVar(exp.getText());
                    if(getByReference) return tid;
                    else {
                        TypeInterface r = tid.getTypeName().getInstance();
                        r.set(tid);
                        return r;
                    }
                }
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
        FunctionSignature fs = function_list.get(name);
        StageStack old_stack = current_stack;

        current_stack = new StageStack(scene_graph);
        TypeInterface ret = fs.ret.getInstance();

        for(int i=0; i<args.size(); i++) {
            current_stack.add(fs.args_names.get(i), args.get(i));
        }

        //Run first
        if(fs.first != null) {
            current_stack.pushScope();
            runFuncs(fs.first);
        }
        //Check if return was invoked
        if(this.ret) {
            current_stack.flushStack();
            current_stack = old_stack;
            quit = false;
            this.ret = false;
            return ret_val;
        }
        //Check if quit was invoked
        if(this.quit) {
            if(fs.last != null) { //then call last if not null
                current_stack.pushScope();
                runFuncs(fs.last);
                if(this.ret) { //if ret call ret, if quit we don't bother to check
                    current_stack.flushStack();
                    current_stack = old_stack;
                    quit = false;
                    this.ret = false;
                    return ret_val;
                }
            } //anyways, flush, unstack and return
            current_stack.flushStack();
            current_stack = old_stack;
            quit = false;
            this.ret = false;
            return ret;
        }
        //Call loop if not null
        if(fs.loop != null) {
            current_stack.pushScope();
            runFuncs(fs.loop);
            current_stack.popScope();
        }
        //If return end here
        if(this.ret) {
            current_stack.flushStack();
            current_stack = old_stack;
            quit = false;
            this.ret = false;
            return ret_val;
        }
        //Call last if not null
        if(fs.last != null) {
            current_stack.pushScope();
            runFuncs(fs.last);
        }
        if(this.ret) { //Check if return was invoked
            current_stack.flushStack();
            current_stack = old_stack;
            quit = false;
            this.ret = false;
            return ret_val;
        }

        current_stack.flushStack();
        current_stack = old_stack;
        quit = false;
        this.ret = false;
        return ret;
    }
}
