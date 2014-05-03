package interp.Types;

import java.util.List;

public class Vec2Type implements TypeInterface {
    private FloatType valX, valY;

    public Vec2Type() {
        valX = new FloatType();
        valY = new FloatType();
    }

    public Vec2Type(float x, float y) {
        valX = new FloatType(x);
        valY = new FloatType(y);
    }

    public void setValue(float x, float y) {
        valX.setValue(x);
        valY.setValue(y);
    }

    public float getX() { return valX.getValue(); }
    public float getY() { return valY.getValue(); }

    public Types getTypeName() { return Types.VEC2_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 && args.get(0)==Types.VEC2_T) {
            if(name.equals("+") || name.equals("-") || name.equals("*")  || name.equals("/") || name.equals("-")) {
                return Types.VEC2_T;
            } else if(name.equals("==") || name.equals("!=")) {
                return Types.BOOL_T;
            }
        }
        else if(args.size()==0) {
            if(name.equals("not")) {
                return Types.VEC2_T;
            }
        }

        return null;
    }


    public TypeInterface callMethod(String name, List<TypeInterface> args) {
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
        if(name.equals("x") || name.equals("y")) return Types.FLOAT_T;
        return null;
    }

    public TypeInterface getAttribute(String name) {
        //TODO
        return null; }

    public void set(TypeInterface obj) {
        valX = ((Vec2Type)obj).valX;
        valY = ((Vec2Type)obj).valY;
    }
}
