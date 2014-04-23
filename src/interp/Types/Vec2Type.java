package interp.Types;

import java.util.Arrays;
import java.util.List;

/**
 * Created by marc on 22/04/14.
 */
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

    public List<Types> getMethodArgs(String name) {
        if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("-")) {
            Types sum[] = { Types.VEC2_T, Types.VEC2_T };
            return Arrays.asList(sum);
        } else if(name.equals("==") || name.equals("!=")) {
            Types comp[] = { Types.BOOL_T, Types.VEC2_T };
            return Arrays.asList(comp);
        } else if(name.equals("not")) {
            Types comp[] = { Types.VEC2_T };
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
        if(name.equals("x") || name.equals("y")) return Types.FLOAT_T;
        return null;
    }
    public TypeInterface getAttribute(String name) {
        //TODO
        return null; }

    public boolean canCastTo(Types type) { return false; };
    public TypeInterface castTo(Types type) { return null; };
}
