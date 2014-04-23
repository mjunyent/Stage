package interp.Types;

import java.util.Arrays;
import java.util.List;

public class BoolType implements TypeInterface {
    private boolean value;

    public BoolType() { value = false; }

    public BoolType(boolean value) {
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    public Types getTypeName() { return Types.BOOL_T; }

    public List<Types> getMethodArgs(String name) {
        if(name.equals("==") || name.equals("!=") || name.equals("or") || name.equals("and")) {
            Types comp[] = { Types.BOOL_T, Types.BOOL_T };
            return Arrays.asList(comp);
        } else if(name.equals("not")) {
            Types comp[] = { Types.BOOL_T };
            return Arrays.asList(comp);
        }
        return null;
    }

    public TypeInterface callMethod(String name, List<TypeInterface> args) {
        if(name.equals("==")) {
            return new BoolType( value == ((BoolType)args.get(0)).getValue() );
        } else if(name.equals("!=")) {
            return new BoolType( value != ((BoolType)args.get(0)).getValue() );
        } else if(name.equals("or")) {
            return new BoolType( value || ((BoolType)args.get(0)).getValue() );
        } else if(name.equals("and")) {
            return new BoolType( value && ((BoolType)args.get(0)).getValue() );
        } else if(name.equals("not")) {
            return new BoolType( !value );
        }

        return null;
    }

    public Types getAttributeType(String name) { return null; }
    public TypeInterface getAttribute(String name) { return null; }

    public boolean canCastTo(Types type) { return false; };
    public TypeInterface castTo(Types type) { return null; };
}
