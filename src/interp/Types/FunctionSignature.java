package interp.Types;

import interp.Semantic.SemanticsFunctions;
import interp.StageTree;

import java.util.List;

public class FunctionSignature {
    //Important fields
    public String name;
    public List<Types> args;
    public Types ret;

    //Optional fields
    public List<String> args_names;
    public StageTree root = null;
    public StageTree first = null, loop = null, last = null;
    public int id = -1;

    public FunctionSignature() { }

    public FunctionSignature(String name, List<Types> args, Types ret) {
        this.name = name;
        this.args = args;
        this.ret = ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FunctionSignature)) return false;

        FunctionSignature that = (FunctionSignature) o;

        if (args != null ? !args.equals(that.args) : that.args != null) return false;
        if (args_names != null ? !args_names.equals(that.args_names) : that.args_names != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = args != null ? args.hashCode() : 0;
        result = 31 * result + (args_names != null ? args_names.hashCode() : 0);
        return result;
    }
}
