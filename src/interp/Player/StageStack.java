package interp.Player;

import interp.Types.NodeInterface;
import interp.Types.TypeFunctionInterface;
import java.util.HashMap;
import java.util.LinkedList;

import java.util.Iterator;
import java.util.Map;

public class StageStack {
    private LinkedList<HashMap<String,TypeFunctionInterface>> stack;
    private HashMap<String,TypeFunctionInterface> current_scope = null;
    private LinkedList<NodeInterface> nodes = null;
    private SceneGraph scene_graph;

    public StageStack(SceneGraph scene_graph) {
        stack = new LinkedList<HashMap<String, TypeFunctionInterface>>();
        nodes = new LinkedList<NodeInterface>();
        current_scope = new HashMap<String, TypeFunctionInterface>();
        stack.addLast(current_scope);
        nodes.addLast(null);

        this.scene_graph = scene_graph;

        /* Global vars won't go with stack.
        //Add global vars.
        Iterator it = FunctionGlobalVars.getTable().entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Types> pairs = (Map.Entry)it.next();
            current_scope.put(pairs.getKey(), pairs.getValue().getInstance());
        }*/
    }

    public void printAllScopes() {
        for(int i=0; i<stack.size(); i++) {
            System.out.println("Scope level: " + i);
            HashMap<String,TypeFunctionInterface> scope = stack.get(i);

            Iterator it = scope.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry<String, TypeFunctionInterface> hue = (Map.Entry)it.next();
                System.out.println("    var: " + hue.getKey() + "<" + hue.getValue().getTypeName().getName() + ">");
            }
        }
    }

    public boolean exists(String name) {
        for(HashMap<String,TypeFunctionInterface> scope : stack) {
            if(scope.containsKey(name)) return true;
        }
        return false;
    }

    public boolean existsInCurrentScope(String name) {
        return current_scope.containsKey(name);
    }

    public TypeFunctionInterface getVar(String name) {
        for(int i=stack.size()-1; i>=0; i--) {
            HashMap<String, TypeFunctionInterface> scope = stack.get(i);
            if(scope.containsKey(name)) return scope.get(name);
        }

        throw new RuntimeException ("Stack: Variable " + name + " not defined");
    }

    public void add(String name, TypeFunctionInterface var) {
        if(existsInCurrentScope(name)) {
            throw new RuntimeException ("Stack: Variable " + name + " already defined in this scope");
        }

        current_scope.put(name, var);
        if(var instanceof NodeInterface) nodes.addLast((NodeInterface) var);
    }

    public void pushScope() {
        current_scope = new HashMap<String, TypeFunctionInterface>();
        stack.addLast(current_scope);
        nodes.addLast(null);
    }

    public void popScope() {
        if(stack.size() > 1) {
            stack.removeLast();
            current_scope = stack.getLast();

            NodeInterface last = nodes.pollLast();
            while(last != null) {
                scene_graph.delRef(last);
                last = nodes.pollLast();
            }
        }
    }

    public void flushStack() {
        NodeInterface last = nodes.pollLast();
        while(!nodes.isEmpty()) {
            if(last != null) scene_graph.delRef(last);
            last = nodes.pollLast();
        }
    }
}
