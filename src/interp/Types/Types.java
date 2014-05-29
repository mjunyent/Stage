package interp.Types;

import interp.Player.ScreenNode;

import java.util.Arrays;
import java.util.HashMap;

public enum Types {
    //ENUM       NAME        Class              Func    Filt    ArrayOf
    VOID_T      ("void",     VoidType.class,    null),

    INT_T       ("int",      IntType.class,     null),
    A_INT_T     ("0_int",    ArrayType.class,   Types.INT_T),

    FLOAT_T     ("float",    FloatType.class,   null),
    A_FLOAT_T   ("0_float",  ArrayType.class,   Types.FLOAT_T),

    BOOL_T      ("bool",     BoolType.class,    null),
    A_BOOL_T    ("0_bool",   ArrayType.class,   Types.BOOL_T),

    CHAR_T      ("char",     CharType.class,    null),
    STRING_T    ("string",   StringType.class,  null),

    SAMPLER_T   ("_sampler", SamplerType.class, null),

    ARRAY_T     ("_array",   ArrayType.class,   null),

    VEC4_T      ("vec4",     Vec4Type.class,    null),
    VEC2_T      ("vec2",     Vec2Type.class,    null),

    NODE_T      ("node",     NodeType.class,    null),

    VIDEO_T     ("video",    VideoType.class,   null),
    CAM_T       ("camera",   CameraType.class,  null),

    SCREEN_T    ("screen",   ScreenNode.class,  null),

    AUDIO_T     ("audio",    AudioType.class,   null);

    private String  name;
    private Class   cl;
    private Types  arrayOf;

    //Hashmap to fasten queries of types. Only for functions.
    private static HashMap<String, Types> table_functions;
    static {
        table_functions = new HashMap<String, Types>();
        for(Types t : Types.values()) {
            if(t.isAllowedInFunctions()) table_functions.put(t.getName(), t);
        }
    }


    Types(String n, Class c, Types arrayOf) {
        name = n;
        cl = c;
        this.arrayOf = arrayOf;
    }

    //Getters
    public String getName() { return name; }
    public Class getTypeClass() { return cl; }
    public Types getArrayOf() { return arrayOf; }
    public boolean isAllowedInFunctions() { return Arrays.asList(cl.getInterfaces()).contains(TypeFunctionInterface.class); }
    public boolean isAllowedInFilters() { return Arrays.asList(cl.getInterfaces()).contains(TypeFilterInterface.class); }
    public boolean isArray() { return arrayOf!=null; }

    public static Types getByNameFilters(String name) {
        for(Types t : Types.values()) {
            if(t.getName().equals(name)) return t;
        }
        throw new RuntimeException("Type " + name + " not found for filters.");
    }

    public static Types getByNameFunctions(String name) {
        if(table_functions.containsKey(name)) return table_functions.get(name);
        throw new RuntimeException("Type " + name + " not found for functions.");
    }

    public static Types getByArrayTypeFunctions(String name) {
        if(table_functions.containsKey("0_"+name)) return table_functions.get("0_"+name);
        throw new RuntimeException("Type array of " + name + " not found for functions.");
    }

    public TypeInterface getTypeInterfaceInstance() {
        try {
            TypeInterface tp = (TypeInterface) cl.newInstance();
            if(arrayOf != null) ((ArrayType) tp).setType(this);
            return tp;
        } catch (InstantiationException e) { e.printStackTrace(); } catch (IllegalAccessException e) { e.printStackTrace(); }
        return null;
    }

    public TypeFunctionInterface getTypeFunctionInterfaceInstance() {
        return (TypeFunctionInterface) getTypeInterfaceInstance();
    }

    public TypeFilterInterface getTypeFilterInterfaceInstance() {
        return (TypeFilterInterface) getTypeInterfaceInstance();
    }
}
