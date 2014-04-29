package interp.Semantic;

import interp.Types.FunctionList;
import interp.Types.Types;

/**
 * Created by marc on 29/04/14.
 */
public class FunctionGlobalFuncs {
    private static final FunctionList table;
    static {
        table = new FunctionList();

        table.add("vec4", new Types[]{ Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T }, Types.VEC4_T);
        table.add("vec2", new Types[]{ Types.FLOAT_T, Types.FLOAT_T }, Types.VEC2_T);
    }

    public static FunctionList getTable() {
        return table;
    }
}
