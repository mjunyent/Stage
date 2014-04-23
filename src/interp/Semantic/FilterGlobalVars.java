package interp.Semantic;


import interp.Types.Types;
import java.util.HashMap;
import java.util.Map;

public class FilterGlobalVars {
    private static final Map<String, Types> table;
    static {
        table = new HashMap<String, Types>();

        table.put("time", Types.FLOAT_T);
        table.put("resolution", Types.FLOAT_T);
        table.put("width", Types.INT_T);
        table.put("height", Types.INT_T);
        table.put("UV", Types.VEC2_T);
        table.put("OUTPUT", Types.VEC4_T);
    }

    public static Map<String,Types> getTable() {
        return table;
    }
}
