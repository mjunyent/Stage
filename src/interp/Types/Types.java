package interp.Types;

import interp.Player.ScreenNode;

import java.util.Arrays;
import java.util.HashMap;

public enum Types {
    //ENUM       NAME        Class              Func    Filt    ArrayOf
    VOID_T      ("void",     Type_Void.class,    null),

    INT_T       ("int",      Type_Int.class,     null),
    A_INT_T     ("0_int",    Type_Array.class,   Types.INT_T),

    FLOAT_T     ("float",    Type_Float.class,   null),
    A_FLOAT_T   ("0_float",  Type_Array.class,   Types.FLOAT_T),

    BOOL_T      ("bool",     Type_Bool.class,    null),
    A_BOOL_T    ("0_bool",   Type_Array.class,   Types.BOOL_T),

    CHAR_T      ("char",     Type_Char.class,    null),
    STRING_T    ("string",   Type_String.class,  null),

    SAMPLER_T   ("_sampler", Type_Sampler.class, null),

    ARRAY_T     ("_array",   Type_Array.class,   null),

    VEC4_T      ("vec4",     Type_Vec4.class,    null),
    VEC2_T      ("vec2",     Type_Vec2.class,    null),

    NODE_T      ("node",     Type_Node.class,    null),

    VIDEO_T     ("video",    Type_Video.class,   null),
    CAM_T       ("camera",   Type_Camera.class,  null),

    SCREEN_T    ("screen",   ScreenNode.class,  null),

    AUDIO_T     ("audio",    Type_Audio.class,   null);

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
            if(arrayOf != null) ((Type_Array) tp).setType(this);
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
