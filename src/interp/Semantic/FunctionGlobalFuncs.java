package interp.Semantic;

import interp.Types.*;

import java.util.Arrays;
import java.util.List;

public class FunctionGlobalFuncs {
    private static final FunctionList table;
    static {
        table = new FunctionList();

        table.add("vec4", new Types[]{ Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T }, Types.VEC4_T);
        table.add("vec2", new Types[]{ Types.FLOAT_T, Types.FLOAT_T }, Types.VEC2_T);

        table.add("println", new Types[] { Types.INT_T }, Types.VOID_T);
        table.add("println", new Types[] { Types.FLOAT_T }, Types.VOID_T);
        table.add("println", new Types[] { Types.BOOL_T }, Types.VOID_T);
    }

    public static FunctionList getTable() {
        return table;
    }
//TODO add tostring and copy.
    public static TypeInterface callFunc(String name, List<TypeInterface> args) {
        if(name.equals("println")) {
            if(args.get(0).getTypeName() == Types.INT_T) {
                System.out.println("Int value: " + ((IntType)args.get(0)).getValue());
            } else if(args.get(0).getTypeName() == Types.FLOAT_T) {
                System.out.println("Float value: " + ((FloatType)args.get(0)).getValue());
            } else if(args.get(0).getTypeName() == Types.BOOL_T) {
                System.out.println("Bool value: " + ((BoolType)args.get(0)).getValue());
            }
            return Types.VOID_T.getInstance();
        }
        return null; //TODO
    }
}
