package interp.Types;

import interp.Player.ScreenNode;

import java.util.HashMap;

public enum Types {
    //ENUM       NAME        Class              Func    Filt    ArrayOf
    VOID_T      ("void",     VoidType.class,    true,   true,   null),

    INT_T       ("int",      IntType.class,     true,   true,   null),
    A_INT_T     ("0_int",    ArrayType.class,   true,   false,  Types.INT_T),

    FLOAT_T     ("float",    FloatType.class,   true,   true,   null),
    A_FLOAT_T   ("0_float",  ArrayType.class,   true,   false,  Types.FLOAT_T),

    BOOL_T      ("bool",     BoolType.class,    true,   true,   null),
    A_BOOL_T    ("0_bool",   ArrayType.class,   true,   false,  Types.BOOL_T),

    CHAR_T      ("char",     CharType.class,    true,   false,  null),
    STRING_T    ("string",   StringType.class,  true,   false,  null),

    SAMPLER_T   ("_sampler", SamplerType.class, false,  true,   null),

    ARRAY_T     ("_array",   ArrayType.class,   true,   false,  null),

    VEC4_T      ("vec4",     Vec4Type.class,    true,   true,   null),
    VEC2_T      ("vec2",     Vec2Type.class,    true,   true,   null),

    NODE_T      ("node",     NodeType.class,    true,   false,  null),

    SCREEN_T    ("screen",   ScreenNode.class,  false,  false,  null);

    private String  name;
    private Class   cl;
    private boolean allowedInFunctions;
    private boolean allowedInFilters;
    private Types  arrayOf;
//    private TypeInterface inst = null;

    //Hashmap to fasten queries of types. Only for functions.
    private static HashMap<String, Types> table_functions;
    static {
        table_functions = new HashMap<String, Types>();
        for(Types t : Types.values()) {
            if(t.isAllowedInFunctions()) table_functions.put(t.getName(), t);
        }
    }


    Types(String n, Class c, boolean inFunc, boolean inFilt, Types arrayOf) {
        name = n;
        cl = c;
        allowedInFunctions = inFunc;
        allowedInFilters = inFilt;
        this.arrayOf = arrayOf;

/*        if(c != null) {
            try {
                inst = (TypeInterface) cl.newInstance();
                if(arrayOf != null) ((ArrayType) inst).setType(this); //TODO GIVE TYPE AND TYPE OF ARRAY.
            } catch (InstantiationException e) { e.printStackTrace(); } catch (IllegalAccessException e) { e.printStackTrace(); }
        }*/
    }

    //Getters
    public String getName() { return name; }
    public Class getTypeClass() { return cl; }
    public Types getArrayOf() { return arrayOf; }
    public boolean isAllowedInFunctions() { return allowedInFunctions; }
    public boolean isAllowedInFilters() { return allowedInFilters; }
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

    public static Types getArrayByElementName(String name) {
        for(Types t : Types.values()) {
            if(t.isArray() && t.getArrayOf().getName().equals(name)) return t;
        }
        return null;
    }

    public TypeInterface getInstance() {
        try {
            TypeInterface tp = (TypeInterface) cl.newInstance();
            if(arrayOf != null) ((ArrayType) tp).setType(this);
            return tp;
        } catch (InstantiationException e) { e.printStackTrace(); } catch (IllegalAccessException e) { e.printStackTrace(); }
        return null;
    }

}
