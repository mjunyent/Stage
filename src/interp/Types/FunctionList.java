package interp.Types;

import java.util.*;

public class FunctionList {
    private class smallSignature {
        public String name;
        public List<Types> args;

        private smallSignature(String name, List<Types> args) {
            this.name = name;
            this.args = args;
        }
    }

    HashMap<smallSignature, FunctionSignature> table;

    public FunctionList() {
        table = new HashMap<smallSignature, FunctionSignature>();
    }

    public void add(String name, List<Types> args, Types ret) {
        table.put(new smallSignature(name, args), new FunctionSignature(name, args, ret));
    }

    public void add(String name, Types[] args, Types ret) {
        table.put(new smallSignature(name, Arrays.asList(args)), new FunctionSignature(name, Arrays.asList(args), ret));
    }

    public void add(FunctionSignature f) {
        table.put(new smallSignature(f.name, f.args), f);
    }

    public boolean exists(String name, List<Types> args) {
        return table.containsKey(new smallSignature(name,args));
    }

    public FunctionSignature getFunction(String name, List<Types> args) {
        return table.get(new smallSignature(name,args));
    }

    public List<FunctionSignature> getByName(String name) {
        ArrayList<FunctionSignature> args_s = new ArrayList<FunctionSignature>();

        Iterator it = table.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<smallSignature, FunctionSignature> pairs = (Map.Entry)it.next();
            if(pairs.getKey().name.equals(name)) args_s.add(pairs.getValue());
        }

        return args_s;
    }
}
