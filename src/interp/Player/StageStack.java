package interp.Player;

import interp.Types.TypeInterface;
import java.util.HashMap;
import java.util.LinkedList;

public class StageStack {
    private LinkedList<HashMap<String,TypeInterface>> stack;
    private HashMap<String,TypeInterface> current_scope = null;

    public StageStack() {
        stack = new LinkedList<HashMap<String, TypeInterface>>();

        current_scope = new HashMap<String, TypeInterface>();
        stack.addLast(current_scope);

        /* Global vars won't go with stack.
        //Add global vars.
        Iterator it = FunctionGlobalVars.getTable().entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Types> pairs = (Map.Entry)it.next();
            current_scope.put(pairs.getKey(), pairs.getValue().getInstance());
        }*/
    }

    public boolean exists(String name) {
        for(HashMap<String,TypeInterface> scope : stack) {
            if(scope.containsKey(name)) return true;
        }
        return false;
    }

    public boolean existsInCurrentScope(String name) {
        return current_scope.containsKey(name);
    }

    public TypeInterface getVar(String name) {
        for(int i=stack.size()-1; i>=0; i--) {
            HashMap<String, TypeInterface> scope = stack.get(i);
            if(scope.containsKey(name)) return scope.get(name);
        }

        throw new RuntimeException ("Stack: Variable " + name + " not defined");
    }

    public void add(String name, TypeInterface var) {
        if(existsInCurrentScope(name)) {
            throw new RuntimeException ("Stack: Variable " + name + " already defined in this scope");
        }

        current_scope.put(name, var);
    }

    public void pushScope() {
        current_scope = new HashMap<String, TypeInterface>();
        stack.addLast(current_scope);
    }

    public void popScope() {
        if(stack.size() > 1) {
            stack.removeLast();
            current_scope = stack.getLast();
        }
    }
}
