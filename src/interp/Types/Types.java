package interp.Types;

import java.util.HashMap;

public enum Types {
    //ENUM       NAME        Class              Func    Filt    ArrayOf
    VOID_T      ("void",     null,              true,   true,   Types.VOID_T),
    INT_T       ("int",      IntType.class,     true,   true,   Types.VOID_T),
    FLOAT_T     ("float",    FloatType.class,   true,   true,   Types.VOID_T),
    BOOL_T      ("bool",     BoolType.class,    true,   true,   Types.VOID_T),
    CHAR_T      ("char",     null,              true,   false,  Types.VOID_T),
    STRING_T    ("string",   null,              true,   false,  Types.VOID_T),
    SAMPLER_T   ("_sampler", SamplerType.class, false,  true,   Types.VOID_T),
    ARRAY_T     ("_array",   ArrayType.class,   true,   false,  Types.VOID_T),
    VEC4_T      ("vec4",     Vec4Type.class,    true,   true,   Types.VOID_T),
    VEC2_T      ("vec2",     Vec2Type.class,    true,   true,   Types.VOID_T),

    ARRAY_INT_T ("array_int",ArrayType.class,   true,   false,  Types.INT_T);

    private String  name;
    private Class   cl;
    private boolean allowedInFunctions;
    private boolean allowedInFilters;
    private Types  arrayOf;
    private TypeInterface inst = null;

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

        if(c != null) {
            try {
                inst = (TypeInterface) cl.newInstance();
                if(arrayOf != null) ((ArrayType) inst).setType(arrayOf); //TODO GIVE TYPE AND TYPE OF ARRAY.
            } catch (InstantiationException e) { e.printStackTrace(); } catch (IllegalAccessException e) { e.printStackTrace(); }
        }
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

    public static Types getArrayByName(String name) {
        for(Types t : Types.values()) {
            if(t.getArrayOf().getName().equals(name)) return t;
        }
        return null;
    }

    public TypeInterface getInstance() {
        try {
            TypeInterface tp = (TypeInterface) cl.newInstance();
            if(arrayOf != null) ((ArrayType) inst).setType(arrayOf); //TODO GIVE TYPE AND TYPE OF ARRAY.
            return tp;
        } catch (InstantiationException e) { e.printStackTrace(); } catch (IllegalAccessException e) { e.printStackTrace(); }
        return null;
    }

}
