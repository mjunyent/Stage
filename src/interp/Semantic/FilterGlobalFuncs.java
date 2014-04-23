package interp.Semantic;

import interp.Types.Types;

import java.util.HashMap;
import java.util.Map;

public class FilterGlobalFuncs {
    private static final Map<String, Types[]> table;
    static {
        table = new HashMap<String, Types[]>();

        table.put("vec4", new Types[]{ Types.VEC4_T, Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T });
        table.put("vec2", new Types[]{ Types.VEC2_T, Types.FLOAT_T, Types.FLOAT_T } );
    }

    public static Map<String,Types[]> getTable() {
        return table;
    }

}
