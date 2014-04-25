package interp.Types;

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

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 &&
           args.get(0) == Types.BOOL_T &&
           (name.equals("==") || name.equals("!=") || name.equals("or") || name.equals("and")) ) {
            return Types.BOOL_T;
        } else if(args.size() == 0 && name.equals("not")) {
            return Types.BOOL_T;
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

}
