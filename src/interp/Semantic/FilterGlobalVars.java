package interp.Semantic;


import interp.Types.Types;
import java.util.HashMap;
import java.util.Map;

public class FilterGlobalVars {
    private static final Map<String, Types> table;
    static {
        table = new HashMap<String, Types>();

        table.put("time", Types.FLOAT_T);
        table.put("resolution", Types.VEC2_T);
        table.put("UV", Types.VEC2_T);
    }

    public static Map<String,Types> getTable() {
        return table;
    }
}
