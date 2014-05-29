package interp.Types;

import java.util.ArrayList;
import java.util.List;

public class Type_Array implements TypeFunctionInterface {
    Types general_type, array_type;
    public ArrayList<TypeFunctionInterface> array;

    public Type_Array() {
        general_type = array_type = Types.VOID_T;
        array = new ArrayList<TypeFunctionInterface>();
    }

    public void setType(Types t) {
        general_type = t;
        array_type = t.getArrayOf();
    }

    public void setSize(Type_Int s) {
        array = new ArrayList<TypeFunctionInterface>();
        for(int i=0; i<s.getValue(); i++) {
            array.add(array_type.getTypeFunctionInterfaceInstance());
        }
    }

    public TypeFunctionInterface getValue(int pos) {
        if(pos < 0 || pos > array.size()) throw new RuntimeException("Array out of bounds!");
        return array.get(pos);
    }

    public Types getTypeName() { return general_type; }
    public Types getElementTypeName() { return array_type; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 && args.get(0) == Types.INT_T && name.equals("[")) {
            return array_type;
        }
        if(args.size() == 1 && args.get(0) == array_type && name.equals("push")) {
            return Types.VOID_T;
        }
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(name.equals("[")) {
            int pos = ((Type_Int)args.get(0)).getValue();
            return getValue(pos);
        }
        if(name.equals("push")) {
            array.add(args.get(0));
            return new Type_Void();
        }
        return null;
    }

    public Types getAttributeType(String name) {
        if(name.equals("size")) return Types.INT_T;
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("size")) return new Type_Int(array.size());
        return null;
    }

    public void set(TypeInterface obj) {
        general_type = ((Type_Array)obj).general_type;
        array_type = ((Type_Array)obj).array_type;
        array = (ArrayList<TypeFunctionInterface>)((Type_Array)obj).array.clone();
    }
}
