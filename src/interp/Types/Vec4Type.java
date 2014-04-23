package interp.Types;

import java.util.Arrays;
import java.util.List;

public class Vec4Type implements TypeInterface {

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

    public List<Types> getMethodArgs(String name) {
        if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("-")) {
            Types sum[] = { Types.VEC4_T, Types.VEC4_T };
            return Arrays.asList(sum);
        } else if(name.equals("==") || name.equals("!=")) {
            Types comp[] = { Types.BOOL_T, Types.VEC4_T };
            return Arrays.asList(comp);
        } else if(name.equals("not")) {
            Types comp[] = { Types.VEC4_T };
            return Arrays.asList(comp);
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
        if(name.equals("x") || name.equals("y") || name.equals("z") || name.equals("w")) return Types.FLOAT_T;
        return null;
    }
    public TypeInterface getAttribute(String name) {
        //TODO
        return null; }

    public boolean canCastTo(Types type) { return false; };
    public TypeInterface castTo(Types type) { return null; };
}
