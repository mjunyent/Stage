package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class Type_Int implements TypeFunctionInterface,TypeFilterInterface {
    private int value;

    static private FunctionList fl;
    static {
        fl = new FunctionList();
        fl.add("+", new Types[] {Types.INT_T}, Types.INT_T, 0);
        fl.add("-", new Types[] {Types.INT_T}, Types.INT_T, 1);
        fl.add("*", new Types[] {Types.INT_T}, Types.INT_T, 2);
        fl.add("/", new Types[] {Types.INT_T}, Types.INT_T, 3);

        fl.add("-", new Types[] {}, Types.INT_T, 4);

        fl.add("==", new Types[] {Types.INT_T}, Types.BOOL_T, 10);
        fl.add("!=", new Types[] {Types.INT_T}, Types.BOOL_T, 11);
        fl.add(">=", new Types[] {Types.INT_T}, Types.BOOL_T, 12);
        fl.add("<=", new Types[] {Types.INT_T}, Types.BOOL_T, 13);
        fl.add("<", new Types[] {Types.INT_T}, Types.BOOL_T, 14);
        fl.add(">", new Types[] {Types.INT_T}, Types.BOOL_T, 15);
    }

    public Type_Int() { value = 0; }

    public Type_Int(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Types getTypeName() { return Types.INT_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(fl.exists(name, args)) return fl.getFunction(name,args).ret;
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(!fl.existsByInterface(name,args)) return null;

        FunctionSignature fs = fl.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                return new Type_Int( value + ((Type_Int)args.get(0)).getValue() );
            case 1:
                return new Type_Int( value - ((Type_Int)args.get(0)).getValue() );
            case 2:
                return new Type_Int( value * ((Type_Int)args.get(0)).getValue() );
            case 3:
                return new Type_Int( value / ((Type_Int)args.get(0)).getValue() );
            case 4:
                return new Type_Int( -value );

            case 10:
                return new Type_Bool( value == ((Type_Int)args.get(0)).getValue() );
            case 11:
                return new Type_Bool( value != ((Type_Int)args.get(0)).getValue() );
            case 12:
                return new Type_Bool(  value >= ((Type_Int)args.get(0)).getValue() );
            case 13:
                return new Type_Bool(  value <= ((Type_Int)args.get(0)).getValue() );
            case 14:
                return new Type_Bool(  value < ((Type_Int)args.get(0)).getValue() );
            case 15:
                return new Type_Bool(  value > ((Type_Int)args.get(0)).getValue() );
        }
        return null;
    }

    public Types getAttributeType(String name) { return null; }
    public TypeFunctionInterface getAttribute(String name) { return null; }

    public void set(TypeInterface obj) {
        value = ((Type_Int)obj).getValue();
    }

    public void passToShader(PShader shad, String name) {
        shad.set(name, value);
    }

    public String callMethod(String left, String name, List<Types> args_types, List<String> args) {
        if(args.size() == 1) {
            if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("/") || name.equals("-")
                 || name.equals("==") || name.equals("!=") ||
                    name.equals(">") || name.equals("<") ||
                    name.equals(">=") || name.equals("<=")) {
                return "(" + left + ")" + name + "(" + args.get(0) + ")";
            }
        } else if(args.size() == 0) {
            return "-(" + left + ")";
        }
        return "";
    }

    public String getAttribute(String left, String name) {
        return left + "." + name;
    }
}
