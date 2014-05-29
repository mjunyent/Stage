package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class VoidType implements TypeFunctionInterface,TypeFilterInterface {
    public Types getTypeName() {
        return Types.VOID_T;
    }

    public Types getMethodArgs(String name, List<Types> args) {
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        return null;
    }

    public Types getAttributeType(String name) {
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        return null;
    }

    public void set(TypeInterface obj) {
    }

    public void passToShader(PShader shad, String name) {

    }

    public String callMethod(String left, String name, List<Types> args_types, List<String> args) {
        return "";
    }

    public String getAttribute(String left, String name) {
        return left + "." + name;
    }
}
