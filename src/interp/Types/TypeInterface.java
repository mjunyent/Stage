package interp.Types;

import java.util.List;

public interface TypeInterface {
    // Gets name of type.
    public Types getTypeName();

    // Returns the return of a method given the name and the arguments (YES, WE HAVE FKNG METHOD OVERLOADS)
    public Types getMethodArgs(String name, List<Types> args);

    //Calls method, returns return of the method. Null if no method found.
    public TypeInterface callMethod(String name, List<TypeInterface> args);

    //Get type of attribute. Null if no attribute found.
    public Types getAttributeType(String name);

    //Get attribute.
    public TypeInterface getAttribute(String name);

    //Set
    public void set(TypeInterface obj);

    //Auto cast.
//    public boolean canCastTo(Types type);
//    public TypeInterface castTo(Types type);
}
