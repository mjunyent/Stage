package interp.Types;

import java.util.ArrayList;
import java.util.List;

public class ArrayType implements TypeInterface {
    Types general_type, array_type;
    public ArrayList<TypeInterface> array;

    public ArrayType() {
        general_type = array_type = Types.VOID_T;
        array = new ArrayList<TypeInterface>();
    }

    public void setType(Types t) {
        general_type = t;
        array_type = t.getArrayOf();
    }

    public void setSize(IntType s) {
        array = new ArrayList<TypeInterface>();
        for(int i=0; i<s.getValue(); i++) {
            array.add(array_type.getInstance());
        }
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
        if(args.size() == 1 && args.get(0) == array_type && name.equals("push")) {
            return Types.VOID_T;
        }
        return null;
    }

    public TypeInterface callMethod(String name, List<TypeInterface> args) {
        if(name.equals("[")) {
            int pos = ((IntType)args.get(0)).getValue();
            return getValue(pos);
        }
        if(name.equals("push")) {
            array.add(args.get(0));
            return new VoidType();
        }
        return null;
    }

    public Types getAttributeType(String name) {
        if(name.equals("size")) return Types.INT_T;
        return null;
    }

    public TypeInterface getAttribute(String name) {
        if(name.equals("size")) return new IntType(array.size());
        return null;
    }

    public void set(TypeInterface obj) {
        general_type = ((ArrayType)obj).general_type;
        array_type = ((ArrayType)obj).array_type;
        array = (ArrayList<TypeInterface>)((ArrayType)obj).array.clone();
    }
}
