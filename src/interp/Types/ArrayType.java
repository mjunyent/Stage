package interp.Types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayType implements TypeInterface {

    Types type;
    ArrayList<TypeInterface> array;

    public ArrayType() {
        type = Types.VOID_T;
        array = new ArrayList<TypeInterface>();
    }

    public ArrayType(Types t, int size) {
        type = t;
        array = new ArrayList<TypeInterface>();
        for(int i=0; i<size; i++) {
            array.add(t.getInstance());
        }
    }

    public void setValue(int pos, TypeInterface obj) {
        if(pos < 0 || pos > array.size()) throw new RuntimeException("Array out of bounds!");
        array.set(pos, obj);
    }

    public TypeInterface getValue(int pos) {
        if(pos < 0 || pos > array.size()) throw new RuntimeException("Array out of bounds!");
        return array.get(pos);
    }

    public Types getTypeName() { return Types.ARRAY_T; }
    public Types getElementTypeName() { return type; }

    public List<Types> getMethodArgs(String name) {
        if(name.equals("[")) {
            return Arrays.asList(new Types[]{type, Types.INT_T});
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

    public boolean canCastTo(Types type) { return false; };
    public TypeInterface castTo(Types type) { return null; };
}
