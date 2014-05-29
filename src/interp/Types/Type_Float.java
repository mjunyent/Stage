package interp.Types;

import processing.opengl.PShader;

import java.util.List;


public class Type_Float implements TypeFunctionInterface,TypeFilterInterface {
    private float value;

    public Type_Float() { value = 0; }

    public Type_Float(float value) {
        this.value = value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public Types getTypeName() { return Types.FLOAT_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 &&
          (args.get(0) == Types.FLOAT_T || args.get(0) == Types.VEC4_T)) {
            if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("/") || name.equals("-")) {
                return args.get(0);
            } else if(name.equals("==") || name.equals("!=") ||
                    name.equals(">") || name.equals("<") ||
                    name.equals(">=") || name.equals("<=")) {
                return Types.BOOL_T;
            }
        } else if(args.size() == 0) {
            if(name.equals("-")) {
                return Types.FLOAT_T;
            }
        }
        return null;
    }


    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(name.equals("+")) {
            return new Type_Float( value + ((Type_Float)args.get(0)).getValue() );
        } else if(name.equals("-")) {
            return new Type_Float( value - ((Type_Float)args.get(0)).getValue() );
        } else if(name.equals("*")) {
            return new Type_Float( value * ((Type_Float)args.get(0)).getValue() );
        } else if(name.equals("/")) {
            return new Type_Float( value / ((Type_Float)args.get(0)).getValue() );
        }

        else if(name.equals("==")) {
            return new Type_Bool( value == ((Type_Float)args.get(0)).getValue() );
        } else if(name.equals("!=")) {
            return new Type_Bool( value != ((Type_Float)args.get(0)).getValue() );
        } else if(name.equals("<")) {
            return new Type_Bool(  value < ((Type_Float)args.get(0)).getValue() );
        } else if(name.equals(">")) {
            return new Type_Bool(  value > ((Type_Float)args.get(0)).getValue() );
        } else if(name.equals("<=")) {
            return new Type_Bool(  value <= ((Type_Float)args.get(0)).getValue() );
        } else if(name.equals(">=")) {
            return new Type_Bool(  value >= ((Type_Float)args.get(0)).getValue() );
        }

        else if(name.equals("-")) {
            return new Type_Float( -value );
        }

        return null;
    }

    public Types getAttributeType(String name) { return null; }
    public TypeFunctionInterface getAttribute(String name) { return null; }

    public void set(TypeInterface obj) {
        value = ((Type_Float)obj).getValue();
    }

    public void passToShader(PShader shad, String name) {
        shad.set(name, value);
    }

    public String callMethod(String left, String name, List<Types> args_types, List<String> args) {
        if(args.size() == 1 && (args_types.get(0) == Types.FLOAT_T || args_types.get(0) == Types.VEC4_T)) {
            if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("/") || name.equals("-") || name.equals("==") || name.equals("!=") ||
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