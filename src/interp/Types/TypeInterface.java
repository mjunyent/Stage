package interp.Types;

import java.util.List;

public interface TypeInterface {
    // Gets name of type.
    public Types getTypeName();

    // Returns the method "name" arguments type and return type (in first position). First position void type if no return.
    public List<Types> getMethodArgs(String name);

    //Calls method, returns return of the method. Null if no method found.
    public TypeInterface callMethod(String name, List<TypeInterface> args);

    //Get type of attribute. Null if no attribute found.
    public Types getAttributeType(String name);

    //Get attribute.
    public TypeInterface getAttribute(String name);

    //Auto cast.
    public boolean canCastTo(Types type);
    public TypeInterface castTo(Types type);
}
