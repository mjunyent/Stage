package interp.Types;

import java.util.List;

/**
 * Created by marc on 03/05/14.
 */
public class VoidType implements TypeInterface {
    public Types getTypeName() {
        return Types.VOID_T;
    }

    public Types getMethodArgs(String name, List<Types> args) {
        return null;
    }

    public TypeInterface callMethod(String name, List<TypeInterface> args) {
        return null;
    }

    public Types getAttributeType(String name) {
        return null;
    }

    public TypeInterface getAttribute(String name) {
        return null;
    }
}
