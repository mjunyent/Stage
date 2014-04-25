package interp.Types;

import java.util.*;

public class FunctionList {
    HashMap<FunctionDescriptor, Integer> functions;

    public FunctionList() {
        functions = new HashMap<FunctionDescriptor, Integer>();
    }

    public void add(FunctionDescriptor f, int index) {
        functions.put(f, index);
    }

    public void add(String name, Types[] args, Types ret, int index) {
        functions.put(new FunctionDescriptor(name, args, ret), index);
    }

    public void add(String name, List<Types> args, Types ret, int index) {
        functions.put(new FunctionDescriptor(name, args, ret), index);
    }

    public boolean exists(FunctionDescriptor f) {
        return functions.containsKey(f);
    }

    public boolean exists(String name, List<Types> args) {
        return exists(new FunctionDescriptor(name, args, Types.VOID_T));
    }

    public Types getReturn(String name, List<Types> args) {
        Iterator it = functions.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<FunctionDescriptor, Integer> pairs = (Map.Entry)it.next();
            if(pairs.getKey().equals(name,args)) return pairs.getKey().getRet();
        }
        return null;
    }

    public int getId(String name, List<Types> args) {
        return functions.get(new FunctionDescriptor(name, args, Types.VOID_T));
    }

    public int getIdFromInterfaces(String name, List<TypeInterface> args) {
        ArrayList<Types> args_types = new ArrayList<Types>();
        for(TypeInterface t : args) {
            args_types.add(t.getTypeName());
        }
        return getId(name, args_types);
    }

    public List<FunctionDescriptor> getByName(String name) {
        ArrayList<FunctionDescriptor> args_s = new ArrayList<FunctionDescriptor>();

        Iterator it = functions.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<FunctionDescriptor, Integer> pairs = (Map.Entry)it.next();
            if(pairs.getKey().getName().equals(name)) args_s.add(pairs.getKey());
        }

        return args_s;
    }
}
