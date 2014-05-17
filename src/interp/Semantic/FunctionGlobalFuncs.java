package interp.Semantic;

import interp.Types.*;
import java.util.List;

public class FunctionGlobalFuncs {
    private static final FunctionList table;
    static {
        table = new FunctionList();

        table.add("vec4", new Types[]{ Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T, Types.FLOAT_T }, Types.VEC4_T, 0);
        table.add("vec2", new Types[]{ Types.FLOAT_T, Types.FLOAT_T }, Types.VEC2_T, 1);
        table.add("int", new Types[]{ Types.FLOAT_T }, Types.INT_T, 2);
        table.add("float", new Types[]{ Types.INT_T }, Types.FLOAT_T, 3);

        table.add("println", new Types[] { Types.INT_T }, Types.VOID_T, 10);
        table.add("println", new Types[] { Types.FLOAT_T }, Types.VOID_T, 11);
        table.add("println", new Types[] { Types.BOOL_T }, Types.VOID_T, 12);
        table.add("println", new Types[] { Types.CHAR_T }, Types.VOID_T, 13);
        table.add("println", new Types[] { Types.STRING_T }, Types.VOID_T, 14);


        table.add("video", new Types[] { Types.STRING_T }, Types.VIDEO_T, 20);
        table.add("camera", new Types[] { Types.INT_T }, Types.CAM_T, 21);
        table.add("node", new Types[] { Types.INT_T, Types.INT_T}, Types.NODE_T, 22);

        table.add("audio", new Types[] { Types.STRING_T }, Types.AUDIO_T, 30);
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

            case 2:
                return new IntType((int)((FloatType)args.get(0)).getValue());
            case 3:
                return new FloatType((float)((IntType)args.get(0)).getValue());

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
            case 21:
                CameraType retcamera = new CameraType(((IntType)args.get(0)).getValue());
                FunctionGlobalVars.scene_graph.addNode(retcamera);
                FunctionGlobalVars.scene_graph.addRef(retcamera);
                return retcamera;
            case 22:
                NodeType retnode = new NodeType(((IntType)args.get(0)).getValue(), ((IntType)args.get(1)).getValue());
                FunctionGlobalVars.scene_graph.addNode(retnode);
                FunctionGlobalVars.scene_graph.addRef(retnode);
                return retnode;
            case 30:
                return new AudioType(((StringType)args.get(0)).getValue());
            default:
                return null;
        }
    }
}
