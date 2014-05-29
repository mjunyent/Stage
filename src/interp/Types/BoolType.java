package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class BoolType implements TypeFunctionInterface,TypeFilterInterface {
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

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
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

    public void set(TypeInterface obj) {
        value = ((BoolType)obj).getValue();
    }

    public Types getAttributeType(String name) { return null; }
    public TypeFunctionInterface getAttribute(String name) { return null; }


    public void passToShader(PShader shad, String name) {
        shad.set(name, value);
    }

    public String callMethod(String left, String name, List<Types> args_types, List<String> args) {
        if(args.size() == 1 &&
           args_types.get(0) == Types.BOOL_T &&
           (name.equals("==") || name.equals("!=") || name.equals("or") || name.equals("and")) ) {
            String opName = name;
            if(name.equals("or")) opName = "||";
            if(name.equals("and")) opName = "&&";
            return "(" + left + ")" + opName + "(" + args.get(0) + ")";
        } else if(args.size() == 0) {
            return "!(" + left + ")";
        }
        return "";
    }

    public String getAttribute(String left, String name) {
        return left + "." + name;
    }
}
