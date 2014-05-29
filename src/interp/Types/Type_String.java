package interp.Types;

import java.util.List;

public class Type_String implements TypeFunctionInterface {
    static private FunctionList fl;
    static {
        fl = new FunctionList();
        fl.add("==", new Types[] {Types.STRING_T}, Types.BOOL_T, 0);
        fl.add("!=", new Types[] {Types.STRING_T}, Types.BOOL_T, 1);

        fl.add("+", new Types[] {Types.STRING_T}, Types.STRING_T, 10);
        fl.add("+", new Types[] {Types.BOOL_T}, Types.STRING_T, 11);
        fl.add("+", new Types[] {Types.INT_T}, Types.STRING_T, 12);
        fl.add("+", new Types[] {Types.FLOAT_T}, Types.STRING_T, 13);
        fl.add("+", new Types[] {Types.CHAR_T}, Types.STRING_T, 14);
        fl.add("+", new Types[] {Types.VEC2_T}, Types.STRING_T, 15);
        fl.add("+", new Types[] {Types.VEC4_T}, Types.STRING_T, 16);
    }
    private String value;

    public Types getTypeName() { return Types.STRING_T; }

    public Type_String() {
        value = new String();
    }

    public Type_String(String v) {
        value = v; //strings are immutable.
    }

    public String getValue() {
        return value;
    }

    public Types getMethodArgs(String name, List<Types> args) {
        if(fl.exists(name, args)) return fl.getFunction(name,args).ret;
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(!fl.existsByInterface(name,args)) return null;

        FunctionSignature fs = fl.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                return new Type_Bool(value.equals(((Type_String)args.get(0)).getValue()));
            case 1:
                return new Type_Bool(!value.equals(((Type_String)args.get(0)).getValue()));
            case 10:
                return new Type_String(value + ((Type_String)args.get(0)).getValue());
            case 11:
                return new Type_String(value + ((Type_Bool)args.get(0)).getValue());
            case 12:
                return new Type_String(value + ((Type_Int)args.get(0)).getValue());
            case 13:
                return new Type_String(value + ((Type_Float)args.get(0)).getValue());
            case 14:
                return new Type_String(value + ((Type_Char)args.get(0)).getValue());
            case 15:
                return new Type_String(value + "(" + ((Type_Vec2)args.get(0)).getX() + ", " + ((Type_Vec2)args.get(0)).getY() + ")");
            case 16:
                return new Type_String(value + "(" + ((Type_Vec4)args.get(0)).getX() + ", " + ((Type_Vec4)args.get(0)).getY() + ", " + ((Type_Vec4)args.get(0)).getZ() + ", " + ((Type_Vec4)args.get(0)).getW() + ")");
            default:
                return null;
        }
    }

    public Types getAttributeType(String name) {
        if(name.equals("size")) return Types.INT_T;
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("size")) return new Type_Int(value.length());
        return null;
    }

    public void set(TypeInterface obj) {
        value = ((Type_String)obj).getValue();
    }
}
