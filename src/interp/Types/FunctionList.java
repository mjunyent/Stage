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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof smallSignature)) return false;

            smallSignature that = (smallSignature) o;

            if (args != null ? !args.equals(that.args) : that.args != null) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (args != null ? args.hashCode() : 0);
            return result;
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

    public void add(String name, Types[] args, Types ret, int id) {
        table.put(new smallSignature(name, Arrays.asList(args)), new FunctionSignature(name, Arrays.asList(args), ret, id));
    }

    public void add(FunctionSignature f) {
        table.put(new smallSignature(f.name, f.args), f);
    }

    public boolean exists(String name, List<Types> args) {
        return table.containsKey(new smallSignature(name,args));
    }

    public boolean exists(String name) {
        Iterator it = table.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<smallSignature, FunctionSignature> pairs = (Map.Entry)it.next();
            if(pairs.getKey().name.equals(name)) return true;
        }
        return false;
    }

    public FunctionSignature getFunction(String name, List<Types> args) {
        return table.get(new smallSignature(name,args));
    }

    public FunctionSignature getFunctionByInterface(String name, List<TypeInterface> args) {
        ArrayList<Types> at = new ArrayList<Types>();
        for(TypeInterface a : args) at.add(a.getTypeName());

        return table.get(new smallSignature(name, at));
    }

    public boolean existsByInterface(String name, List<TypeInterface> args) {
        ArrayList<Types> at = new ArrayList<Types>();
        for(TypeInterface a : args) at.add(a.getTypeName());

        return table.containsKey(new smallSignature(name, at));
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

    public void printTable() {
        Iterator it = table.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<smallSignature, FunctionSignature> pairs = (Map.Entry)it.next();
            System.out.println("SIGN: " + pairs.getKey().name + ": " + pairs.getKey().args);
            System.out.println("DESC: " + pairs.getValue().name + ": " + pairs.getValue().args + "->" + pairs.getValue().ret);
        }
    }
}
