package interp.Types;

import java.util.List;

public class Type_Char implements TypeFunctionInterface {
    private char value;

    public Type_Char() { value = ' '; }

    public Type_Char(char value) {
        this.value = value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public Types getTypeName() { return Types.CHAR_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 &&
                args.get(0) == Types.CHAR_T &&
                (name.equals("==") || name.equals("!=") ||
                 name.equals(">=") || name.equals("<=") ||
                 name.equals(">")  || name.equals("<")) ) {
            return Types.BOOL_T;
        }
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(name.equals("==")) {
            return new Type_Bool( value == ((Type_Char)args.get(0)).getValue() );
        } else if(name.equals("!=")) {
            return new Type_Bool( value != ((Type_Char)args.get(0)).getValue() );
        } else if(name.equals(">=")) {
            return new Type_Bool( value >= ((Type_Char)args.get(0)).getValue() );
        } else if(name.equals("<=")) {
            return new Type_Bool( value <= ((Type_Char)args.get(0)).getValue() );
        } else if(name.equals(">")) {
            return new Type_Bool( value > ((Type_Char)args.get(0)).getValue() );
        } else if(name.equals("<")) {
            return new Type_Bool( value < ((Type_Char)args.get(0)).getValue() );
        }

        return null;
    }

    public void set(TypeInterface obj) {
        value = ((Type_Char)obj).getValue();
    }

    public Types getAttributeType(String name) { return null; }
    public TypeFunctionInterface getAttribute(String name) { return null; }

}
