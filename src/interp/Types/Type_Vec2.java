package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class Type_Vec2 implements TypeFunctionInterface, TypeFilterInterface {
    private Type_Float valX, valY;

    public Type_Vec2() {
        valX = new Type_Float();
        valY = new Type_Float();
    }

    public Type_Vec2(float x, float y) {
        valX = new Type_Float(x);
        valY = new Type_Float(y);
    }

    public void setValue(float x, float y) {
        valX.setValue(x);
        valY.setValue(y);
    }

    public float getX() { return valX.getValue(); }
    public float getY() { return valY.getValue(); }

    public Types getTypeName() { return Types.VEC2_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 && (args.get(0) == Types.VEC2_T || args.get(0) == Types.FLOAT_T)) {
            if(name.equals("+") || name.equals("-") || name.equals("*")  || name.equals("/") || name.equals("-")) {
                return args.get(0);
            } else if(name.equals("==") || name.equals("!=")) {
                return Types.BOOL_T;
            }
        }
        else if(args.size()==0) {
            if(name.equals("-")) {
                return Types.VEC2_T;
            }
        }

        return null;
    }


    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        //TODO
/*        if(name.equals("+")) {
            return new Type_Int( value + ((Type_Int)args.get(0)).getValue() );
        } else if(name.equals("-")) {
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
*/
        return null;
    }

    public Types getAttributeType(String name) {
        if(name.equals("x") || name.equals("y")) return Types.FLOAT_T;
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        //TODO
        return null; }

    public void set(TypeInterface obj) {
        valX = ((Type_Vec2)obj).valX;
        valY = ((Type_Vec2)obj).valY;
    }


    public void passToShader(PShader shad, String name) {
        shad.set(name, valX.getValue(), valY.getValue());
    }

    public String callMethod(String left, String name, List<Types> args_types, List<String> args) {
        if(args.size() == 1 && (args_types.get(0) == Types.VEC2_T || args_types.get(0) == Types.FLOAT_T)) {
            if(name.equals("+") || name.equals("-") || name.equals("*")  || name.equals("/") || name.equals("-") || name.equals("==") || name.equals("!=")) {
                return "(" + left + ")" + name + "(" + args.get(0) + ")";
            }
        }
        else if(args.size()==0) {
            return "-(" + left + ")";
        }
        return "";
    }

    public String getAttribute(String left, String name) {
        return left + "." + name;
    }
}
