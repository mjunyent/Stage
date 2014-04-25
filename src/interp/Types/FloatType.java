package interp.Types;

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
            if(name.equals("not")) {
                return Types.FLOAT_T;
            }
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

    //TODO if you want autocast, do it only on interpreter.
/*    public boolean canCastTo(Types type) {
//        if(type == Types.VEC2_T || type == Types.VEC4_T) return true;
        return false;
    }
    public TypeInterface castTo(Types type) { return null; }*/
}