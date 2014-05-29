package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class Type_Int implements TypeFunctionInterface,TypeFilterInterface {
    private int value;

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
        if(args.size() == 1 && args.get(0) == Types.INT_T) {
            if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("/") || name.equals("-")) {
                return Types.INT_T;
            } else if(name.equals("==") || name.equals("!=") ||
                      name.equals(">") || name.equals("<") ||
                      name.equals(">=") || name.equals("<=")) {
                return Types.BOOL_T;
            }
        } else if(args.size() == 0) {
            if(name.equals("-")) {
                return Types.INT_T;
            }
        }
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(name.equals("+")) {
            return new Type_Int( value + ((Type_Int)args.get(0)).getValue() );
        } else if(name.equals("-") && args.size() == 1) {
            return new Type_Int( value - ((Type_Int)args.get(0)).getValue() );
        } else if(name.equals("*")) {
            return new Type_Int( value * ((Type_Int)args.get(0)).getValue() );
        } else if(name.equals("/")) {
            return new Type_Int( value / ((Type_Int)args.get(0)).getValue() );
        }

        else if(name.equals("==")) {
            return new Type_Bool( value == ((Type_Int)args.get(0)).getValue() );
        } else if(name.equals("!=")) {
            return new Type_Bool( value != ((Type_Int)args.get(0)).getValue() );
        } else if(name.equals("<")) {
            return new Type_Bool(  value < ((Type_Int)args.get(0)).getValue() );
        } else if(name.equals(">")) {
            return new Type_Bool(  value > ((Type_Int)args.get(0)).getValue() );
        } else if(name.equals("<=")) {
            return new Type_Bool(  value <= ((Type_Int)args.get(0)).getValue() );
        } else if(name.equals(">=")) {
            return new Type_Bool(  value >= ((Type_Int)args.get(0)).getValue() );
        }

        else if(name.equals("-")) {
            return new Type_Int( -value );
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
        if(args.size() == 1 && args_types.get(0) == Types.INT_T) {
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
