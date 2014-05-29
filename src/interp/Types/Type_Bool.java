package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class Type_Bool implements TypeFunctionInterface,TypeFilterInterface {
    private boolean value;

    public Type_Bool() { value = false; }

    public Type_Bool(boolean value) {
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
            return new Type_Bool( value == ((Type_Bool)args.get(0)).getValue() );
        } else if(name.equals("!=")) {
            return new Type_Bool( value != ((Type_Bool)args.get(0)).getValue() );
        } else if(name.equals("or")) {
            return new Type_Bool( value || ((Type_Bool)args.get(0)).getValue() );
        } else if(name.equals("and")) {
            return new Type_Bool( value && ((Type_Bool)args.get(0)).getValue() );
        } else if(name.equals("not")) {
            return new Type_Bool( !value );
        }

        return null;
    }

    public void set(TypeInterface obj) {
        value = ((Type_Bool)obj).getValue();
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
