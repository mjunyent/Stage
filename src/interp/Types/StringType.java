package interp.Types;

import java.util.List;

public class StringType implements TypeInterface {
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

    public StringType() {
        value = new String();
    }

    public StringType(String v) {
        value = v; //strings are immutable.
    }

    public String getValue() {
        return value;
    }

    public Types getMethodArgs(String name, List<Types> args) {
        if(fl.exists(name, args)) return fl.getFunction(name,args).ret;
        return null;
    }

    public TypeInterface callMethod(String name, List<TypeInterface> args) {
        if(!fl.existsByInterface(name,args)) return null;

        FunctionSignature fs = fl.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                return new BoolType(value.equals(((StringType)args.get(0)).getValue()));
            case 1:
                return new BoolType(!value.equals(((StringType)args.get(0)).getValue()));
            case 10:
                return new StringType(value + ((StringType)args.get(0)).getValue());
            case 11:
                return new StringType(value + ((BoolType)args.get(0)).getValue());
            case 12:
                return new StringType(value + ((IntType)args.get(0)).getValue());
            case 13:
                return new StringType(value + ((FloatType)args.get(0)).getValue());
            case 14:
                return new StringType(value + ((CharType)args.get(0)).getValue());
            case 15:
                return new StringType(value + "(" + ((Vec2Type)args.get(0)).getX() + ", " + ((Vec2Type)args.get(0)).getY() + ")");
            case 16:
                return new StringType(value + "(" + ((Vec4Type)args.get(0)).getX() + ", " + ((Vec4Type)args.get(0)).getY() + ", " + ((Vec4Type)args.get(0)).getZ() + ", " + ((Vec4Type)args.get(0)).getW() + ")");
            default:
                return null;
        }
    }

    public Types getAttributeType(String name) {
        if(name.equals("size")) return Types.INT_T;
        return null;
    }

    public TypeInterface getAttribute(String name) {
        if(name.equals("size")) return new IntType(value.length());
        return null;
    }

    public void set(TypeInterface obj) {
        value = ((StringType)obj).getValue();
    }
}
