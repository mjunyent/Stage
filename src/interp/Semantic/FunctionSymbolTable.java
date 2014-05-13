package interp.Semantic;

import interp.Types.Types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
public class FunctionSymbolTable {
    private LinkedList<HashMap<String,Types>> stack;
    private HashMap<String,Types> current_scope = null;

    private boolean warnMasking;

    public FunctionSymbolTable(boolean warnings) {
        this.warnMasking = warnings;

        stack = new LinkedList<HashMap<String, Types>>();

        current_scope = new HashMap<String, Types>();
        stack.addLast(current_scope);

        //Add global vars.
        Iterator it = FunctionGlobalVars.getTable().entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Types> pairs = (Map.Entry)it.next();
            current_scope.put(pairs.getKey(), pairs.getValue());
        }
    }

    public boolean exists(String name) {
        for(HashMap<String,Types> scope : stack) {
            if(scope.containsKey(name)) return true;
        }
        return false;
    }

    public boolean existsInCurrentScope(String name) {
        return current_scope.containsKey(name);
    }

    public Types getType(String name) {
        for(int i=stack.size()-1; i>=0; i--) {
            HashMap<String, Types> scope = stack.get(i);
            if(scope.containsKey(name)) return scope.get(name);
        }

        throw new RuntimeException ("Variable " + name + " not defined");
    }

    public void add(String name, Types type) {
        if(existsInCurrentScope(name)) {
            throw new RuntimeException ("Variable " + name + " already defined in this scope");
        }

        if(warnMasking && exists(name)) {
            System.err.println("Warning: variable " + name + " is being masked. This can cause trouble.");
        }

        current_scope.put(name, type);
    }

    public void pushScope() {
        current_scope = new HashMap<String, Types>();
        stack.addLast(current_scope);
    }

    public void popScope() {
        if(stack.size() > 1) {
            stack.removeLast();
            current_scope = stack.getLast();
        }
    }
}
