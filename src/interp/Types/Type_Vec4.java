package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class Type_Vec4 implements TypeFunctionInterface,TypeFilterInterface {
    private Type_Float valX, valY, valZ, valW;

    public Type_Vec4() {
        valX = new Type_Float();
        valY = new Type_Float();
        valZ = new Type_Float();
        valW = new Type_Float();
    }

    public Type_Vec4(float x, float y, float z, float w) {
        valX = new Type_Float(x);
        valY = new Type_Float(y);
        valZ = new Type_Float(z);
        valW = new Type_Float(w);
    }

    public void setValue(float x, float y, float z, float w) {
        valX.setValue(x);
        valY.setValue(y);
        valZ.setValue(z);
        valW.setValue(w);
    }

    public float getX() { return valX.getValue(); }
    public float getY() { return valY.getValue(); }
    public float getZ() { return valZ.getValue(); }
    public float getW() { return valW.getValue(); }

    public Types getTypeName() { return Types.VEC4_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 &&
           (args.get(0) == Types.VEC4_T || args.get(0) == Types.FLOAT_T) ) {
            if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("/") || name.equals("-")) {
                return Types.VEC4_T;
            } else if(name.equals("==") || name.equals("!=")) {
                return Types.BOOL_T;
            }
        } else if(args.size() == 0) {
            if(name.equals("-")) {
                return Types.VEC4_T;
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
        if(name.equals("x") || name.equals("y") || name.equals("z") || name.equals("w")) return Types.FLOAT_T;
        return null;
    }
    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("x")) return valX;
        if(name.equals("y")) return valY;
        if(name.equals("z")) return valZ;
        if(name.equals("w")) return valW;
        return null;
    }

    public void set(TypeInterface obj) {
        valX = ((Type_Vec4)obj).valX;
        valY = ((Type_Vec4)obj).valY;
        valZ = ((Type_Vec4)obj).valZ;
        valW = ((Type_Vec4)obj).valW;
    }


    public void passToShader(PShader shad, String name) {
        shad.set(name, valX.getValue(), valY.getValue(), valZ.getValue(), valW.getValue());
    }

    public String callMethod(String left, String name, List<Types> args_types, List<String> args) {
        if(args.size() == 1 && (args_types.get(0) == Types.VEC4_T || args_types.get(0) == Types.FLOAT_T)) {
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
