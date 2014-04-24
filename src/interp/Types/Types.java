package interp.Types;

public enum Types {
    VOID_T      ("void",     null,              true,   true ),
    INT_T       ("int",      IntType.class,     true,   true ),
    FLOAT_T     ("float",    FloatType.class,   true,   true ),
    BOOL_T      ("bool",     BoolType.class,    true,   true ),
    CHAR_T      ("char",     null,              true,   false),
    STRING_T    ("string",   null,              true,   false),
    SAMPLER_T   ("_sampler", SamplerType.class, false,  true ),
    ARRAY_T     ("_array",   ArrayType.class,   true,   false),
    VEC4_T      ("vec4",     Vec4Type.class,    true,   true ),
    VEC2_T      ("vec2",     Vec2Type.class,    true,   true );

    private String name;
    private Class cl;
    private boolean allowedInFunctions;
    private boolean allowedInFilters;
    Types(String n, Class c, boolean inFunc, boolean inFilt) {
        name = n;
        cl = c;
        allowedInFunctions = inFunc;
        allowedInFilters = inFilt;
    }

    public String getName() { return name; }
    public Class getTypeClass() { return cl; }
    boolean isAllowedInFunctions() { return allowedInFunctions; }
    boolean isAllowedInFilters() { return allowedInFilters; }


    public static boolean containsForFilters(String name) {
        for(Types t : Types.values()) {
            if(t.isAllowedInFilters() && t.getName().equals(name)) return true;
        }
        return false;
    }

    public static boolean containsForFunctions(String name) {
        for(Types t: Types.values()) {
            if(t.isAllowedInFunctions() && t.getName().equals(name)) return true;
        }
        return false;
    }

    public static Types getByName(String name) {
        for(Types t : Types.values()) {
            if(t.getName().equals(name)) return t;
        }
        return null;
    }

    public boolean isCompatibleWith(Types t) {
        if(this == Types.ARRAY_T) {
            if(t != Types.ARRAY_T) return false;
            if( ((ArrayType)this.getInstance()).getElementTypeName() != ((ArrayType)t.getInstance()).getElementTypeName() ) return false;
            return true;
        }
        if(this == t) return true;
        if(t.getInstance().canCastTo(this)) {
            System.err.println("Warning, casting from " + t.getName() + " to " + this.getName());
            return true;
        }

        return false;
    }

    public TypeInterface getInstance() {
        System.out.println(name);
        try {
            return (TypeInterface) cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
