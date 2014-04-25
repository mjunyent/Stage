package interp.Semantic;

import interp.Types.FunctionList;
import interp.Types.Types;


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
}
