package interp.Semantic;

import ddf.minim.Minim;
import interp.Player.SceneGraph;
import interp.Player.ScreenNode;
import interp.Types.*;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.HashMap;
import java.util.Map;

public class FunctionGlobalVars {
    public static FloatType time = new FloatType(-1.0f);
    public static FloatType dt = new FloatType(1.0f);
    public static Vec2Type resolution = new Vec2Type(0.0f,0.0f);
    public static FloatType Infinity = new FloatType(Float.MAX_VALUE);

    public static ScreenNode screen_node = null;
    public static PApplet screen = null;
    public static SceneGraph scene_graph = null;
    public static String renderer = null;
    public static Minim minim = null;
    public static PImage pal_card = null;

    private static final Map<String, Types> table;
    static {
        table = new HashMap<String, Types>();

        table.put("time", Types.FLOAT_T);
        table.put("now", Types.FLOAT_T);
        table.put("dt", Types.FLOAT_T);
        table.put("resolution", Types.VEC2_T);
        table.put("INFINITY", Types.FLOAT_T);
        table.put("output", Types.SCREEN_T);
    }

    public static Map<String,Types> getTable() {
        return table;
    }

    public static TypeFunctionInterface getVar(String name) {
        if(name.equals("time") || name.equals("now")) return time;
        if(name.equals("resolution")) return resolution;
        if(name.equals("dt")) return dt;
        if(name.equals("INFINITY")) return Infinity;
        if(name.equals("output")) return screen_node;

        return null;
    }
}
