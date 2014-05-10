package interp.Semantic;

import interp.Types.FloatType;
import interp.Types.TypeInterface;
import interp.Types.Types;
import interp.Types.Vec2Type;
import processing.core.PApplet;

import java.util.HashMap;
import java.util.Map;

public class FunctionGlobalVars {
    public static FloatType time = new FloatType(-1.0f);
    public static FloatType dt = new FloatType(1.0f);
    public static Vec2Type resolution = new Vec2Type(0.0f,0.0f);
    public static FloatType Infinity = new FloatType(Float.MAX_VALUE);

    public static PApplet screen;
    public static String renderer;

    private static final Map<String, Types> table;
    static {
        table = new HashMap<String, Types>();

        table.put("time", Types.FLOAT_T);
        table.put("now", Types.FLOAT_T);
        table.put("dt", Types.FLOAT_T);
        table.put("resolution", Types.VEC2_T);
        table.put("INFINITY", Types.FLOAT_T);
    }

    public static Map<String,Types> getTable() {
        return table;
    }

    public static TypeInterface getVar(String name) {
        if(name.equals("time") || name.equals("now")) return time;
        if(name.equals("resolution")) return resolution;
        if(name.equals("dt")) return dt;
        if(name.equals("INFINITY")) return Infinity;

        return null;
    }
}
