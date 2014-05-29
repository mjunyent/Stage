package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class Vec4Type implements TypeFunctionInterface,TypeFilterInterface {
    private FloatType valX, valY, valZ, valW;

    public Vec4Type() {
        valX = new FloatType();
        valY = new FloatType();
        valZ = new FloatType();
        valW = new FloatType();
    }

    public Vec4Type(float x, float y, float z, float w) {
        valX = new FloatType(x);
        valY = new FloatType(y);
        valZ = new FloatType(z);
        valW = new FloatType(w);
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
            if(name.equals("not")) {
                return Types.VEC4_T;
            }
        }

        return null;
    }


    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        //TODO
/*        if(name.equals("+")) {
            return new IntType( value + ((IntType)args.get(0)).getValue() );
        } else if(name.equals("-")) {
            return new IntType( value - ((IntType)args.get(0)).getValue() );
        } else if(name.equals("*")) {
            return new IntType( value * ((IntType)args.get(0)).getValue() );
        } else if(name.equals("/")) {
            return new IntType( value / ((IntType)args.get(0)).getValue() );
        }

        else if(name.equals("==")) {
            return new BoolType( value == ((IntType)args.get(0)).getValue() );
        } else if(name.equals("!=")) {
            return new BoolType( value != ((IntType)args.get(0)).getValue() );
        } else if(name.equals("<")) {
            return new BoolType(  value < ((IntType)args.get(0)).getValue() );
        } else if(name.equals(">")) {
            return new BoolType(  value > ((IntType)args.get(0)).getValue() );
        } else if(name.equals("<=")) {
            return new BoolType(  value <= ((IntType)args.get(0)).getValue() );
        } else if(name.equals(">=")) {
            return new BoolType(  value >= ((IntType)args.get(0)).getValue() );
        }

        else if(name.equals("not")) {
            return new IntType( -value );
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
        valX = ((Vec4Type)obj).valX;
        valY = ((Vec4Type)obj).valY;
        valZ = ((Vec4Type)obj).valZ;
        valW = ((Vec4Type)obj).valW;
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
