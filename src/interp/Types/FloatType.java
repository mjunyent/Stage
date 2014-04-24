package interp.Types;

import java.util.Arrays;
import java.util.List;


public class FloatType implements TypeInterface {
    private float value;

    public FloatType() { value = 0; }

    public FloatType(float value) {
        this.value = value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public Types getTypeName() { return Types.FLOAT_T; }

    public List<Types> getMethodArgs(String name) {
        if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("-")) {
            Types sum[] = { Types.FLOAT_T, Types.FLOAT_T };
            return Arrays.asList(sum);
        } else if(name.equals("==") || name.equals("!=") ||
                name.equals(">") || name.equals("<") ||
                name.equals(">=") || name.equals("=<")) {
            Types comp[] = { Types.BOOL_T, Types.FLOAT_T };
            return Arrays.asList(comp);
        } else if(name.equals("not")) {
            Types comp[] = { Types.FLOAT_T };
            return Arrays.asList(comp);
        }

        return null;
    }


    public TypeInterface callMethod(String name, List<TypeInterface> args) {
        if(name.equals("+")) {
            return new FloatType( value + ((FloatType)args.get(0)).getValue() );
        } else if(name.equals("-")) {
            return new FloatType( value - ((FloatType)args.get(0)).getValue() );
        } else if(name.equals("*")) {
            return new FloatType( value * ((FloatType)args.get(0)).getValue() );
        } else if(name.equals("/")) {
            return new FloatType( value / ((FloatType)args.get(0)).getValue() );
        }

        else if(name.equals("==")) {
            return new BoolType( value == ((FloatType)args.get(0)).getValue() );
        } else if(name.equals("!=")) {
            return new BoolType( value != ((FloatType)args.get(0)).getValue() );
        } else if(name.equals("<")) {
            return new BoolType(  value < ((FloatType)args.get(0)).getValue() );
        } else if(name.equals(">")) {
            return new BoolType(  value > ((FloatType)args.get(0)).getValue() );
        } else if(name.equals("<=")) {
            return new BoolType(  value <= ((FloatType)args.get(0)).getValue() );
        } else if(name.equals(">=")) {
            return new BoolType(  value >= ((FloatType)args.get(0)).getValue() );
        }

        else if(name.equals("not")) {
            return new FloatType( -value );
        }

        return null;
    }

    public Types getAttributeType(String name) { return null; }
    public TypeInterface getAttribute(String name) { return null; }

    public boolean canCastTo(Types type) {
        if(type == Types.VEC2_T || type == Types.VEC4_T) return true;
        return false;
    }
    public TypeInterface castTo(Types type) { return null; }
}