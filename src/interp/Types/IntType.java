package interp.Types;

import java.util.List;
import java.util.Arrays;

public class IntType implements TypeInterface {
    private int value;

    public IntType() { value = 0; }

    public IntType(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Types getTypeName() { return Types.INT_T; }

    public List<Types> getMethodArgs(String name) {
        if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("-")) {
            Types sum[] = { Types.INT_T, Types.INT_T };
            return Arrays.asList(sum);
        } else if(name.equals("==") || name.equals("!=") ||
                  name.equals(">") || name.equals("<") ||
                  name.equals(">=") || name.equals("=<")) {
            Types comp[] = { Types.BOOL_T, Types.INT_T };
            return Arrays.asList(comp);
        } else if(name.equals("not")) {
            Types comp[] = { Types.INT_T };
            return Arrays.asList(comp);
        }

        return null;
    }


    public TypeInterface callMethod(String name, List<TypeInterface> args) {
        if(name.equals("+")) {
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

        return null;
    }

    public Types getAttributeType(String name) { return null; }
    public TypeInterface getAttribute(String name) { return null; }

    public boolean canCastTo(Types type) { return false; };
    public TypeInterface castTo(Types type) { return null; };
}
