package interp.Types;

import java.util.ArrayList;
import java.util.List;

public class ArrayType implements TypeInterface {

    Types general_type, array_type;
    ArrayList<TypeInterface> array;

    public ArrayType() {
        general_type = array_type = Types.VOID_T;
        array = new ArrayList<TypeInterface>();
    }

    public ArrayType(Types t, int size) {
        general_type = t;
        array_type = t.getArrayOf();

        array = new ArrayList<TypeInterface>();
        for(int i=0; i<size; i++) {
            array.add(array_type.getInstance());
        }
    }

    public void setType(Types t) {
        general_type = t;
        array_type = t.getArrayOf();
    }

    public void setValue(int pos, TypeInterface obj) {
        if(pos < 0 || pos > array.size()) throw new RuntimeException("Array out of bounds!");
        array.set(pos, obj);
    }

    public TypeInterface getValue(int pos) {
        if(pos < 0 || pos > array.size()) throw new RuntimeException("Array out of bounds!");
        return array.get(pos);
    }

    public Types getTypeName() { return general_type; }
    public Types getElementTypeName() { return array_type; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 && args.get(0) == Types.INT_T && name.equals("[")) {
            return array_type;
        }

        //TODO
        return null;
    }

    public TypeInterface callMethod(String name, List<TypeInterface> args) {
        if(name.equals("[")) {
            int pos = ((IntType)args.get(0)).getValue();
            return getValue(pos);
        }

        //TODO
        return null;
    }

    public Types getAttributeType(String name) {
        //TODO
        return null;
    }
    public TypeInterface getAttribute(String name) {
        //TODO
        return null;
    }
}
