package interp.Semantic;

import interp.Types.FunctionList;
import interp.Types.Types;

import java.util.ArrayList;


public class FilterGlobalFuncs {
    private static final FunctionList table;
    static {
        table = new FunctionList();

        table.add("vec4", new Types[]{ Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T }, Types.VEC4_T, 0);
        table.add("vec2", new Types[]{ Types.FLOAT_T, Types.FLOAT_T }, Types.VEC2_T, 1);
    }

    public static FunctionList getTable() {
        return table;
    }

    public static String getFuncText(int id, ArrayList<String> args) {
        switch (id) {
            case 0:
                return "vec4(" + args.get(0) + "," + args.get(1) + "," + args.get(2) + "," + args.get(3) + ")";
            case 1:
                return "vec2(" + args.get(0) + "," + args.get(1) + ")";
            default:
                return "";
        }
    }
}
