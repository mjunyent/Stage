package interp.Types;

import java.util.List;

public interface TypeFunctionInterface extends TypeInterface {
    //Calls method, returns return of the method. Null if no method found.
    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args);

    //Get attribute.
    public TypeFunctionInterface getAttribute(String name);

    //Set
    public void set(TypeInterface obj);

}
