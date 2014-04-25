package interp.Types;

import java.util.List;
import java.util.Arrays;

public class FunctionDescriptor {
    private String name;
    private List<Types> args;
    private Types ret;

    public FunctionDescriptor(String name, Types[] args, Types ret) {
        this.name = name;
        this.args = Arrays.asList(args);
        this.ret = ret;
    }

    public FunctionDescriptor(String name, List<Types> args, Types ret) {
        this.name = name;
        this.args = args;
        this.ret = ret;
    }

    public String getName() {
        return name;
    }

    public List<Types> getArgs() {
        return args;
    }

    public Types getRet() {
        return ret;
    }

    public boolean equals(String name, List<Types> args) {
        if(!this.name.equals(name)) return false;
        if(!this.args.equals(args)) return false;

        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FunctionDescriptor)) return false;

        FunctionDescriptor that = (FunctionDescriptor) o;

        if (!args.equals(that.args)) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + args.hashCode();
//        result = 31 * result + ret.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String ts = ret.getName() + " " + name + "(";

        for(int i=0; i<args.size(); i++) {
            if(i != 0) ts += ", ";
            ts += args.get(i).getName();
        }

        ts = ")";
        return ts;
    }
}
