package interp.Semantic;

import interp.Types.*;
import java.util.List;

public class FunctionGlobalFuncs {
    private static final FunctionList table;
    static {
        table = new FunctionList();

        table.add("vec4", new Types[]{ Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T }, Types.VEC4_T, 0);
        table.add("vec2", new Types[]{ Types.FLOAT_T, Types.FLOAT_T }, Types.VEC2_T, 1);

        table.add("println", new Types[] { Types.INT_T }, Types.VOID_T, 10);
        table.add("println", new Types[] { Types.FLOAT_T }, Types.VOID_T, 11);
        table.add("println", new Types[] { Types.BOOL_T }, Types.VOID_T, 12);
        table.add("println", new Types[] { Types.CHAR_T }, Types.VOID_T, 13);
        table.add("println", new Types[] { Types.STRING_T }, Types.VOID_T, 14);


        table.add("video", new Types[] { Types.STRING_T }, Types.VIDEO_T, 20);
    }

    public static FunctionList getTable() {
        return table;
    }

//TODO add tostring and copy.

    public static TypeInterface callFunc(String name, List<TypeInterface> args) {
        if(!table.existsByInterface(name,args)) return null;

        FunctionSignature fs = table.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                return new Vec4Type(((FloatType)args.get(0)).getValue(),
                                    ((FloatType)args.get(1)).getValue(),
                                    ((FloatType)args.get(2)).getValue(),
                                    ((FloatType)args.get(3)).getValue());
            case 1:
                return new Vec2Type(((FloatType)args.get(0)).getValue(),
                                    ((FloatType)args.get(1)).getValue());


            case 10:
                System.out.println("Int value: " + ((IntType)args.get(0)).getValue());
                return new VoidType();
            case 11:
                System.out.println("Float value: " + ((FloatType)args.get(0)).getValue());
                return new VoidType();
            case 12:
                System.out.println("Bool value: " + ((BoolType)args.get(0)).getValue());
                return new VoidType();
            case 13:
                System.out.println("Char value: " + ((CharType)args.get(0)).getValue());
                return new VoidType();
            case 14:
                System.out.println(((StringType)args.get(0)).getValue());
                return new VoidType();

            case 20:
                VideoType retvideo = new VideoType(((StringType)args.get(0)).getValue());
                FunctionGlobalVars.scene_graph.addNode(retvideo);
                FunctionGlobalVars.scene_graph.addRef(retvideo);
                return retvideo;
            default:
                return null;
        }
    }
}
