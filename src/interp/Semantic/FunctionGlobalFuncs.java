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

    public static TypeFunctionInterface callFunc(String name, List<TypeFunctionInterface> args) {
        if(!table.existsByInterface(name,args)) return null;

        FunctionSignature fs = table.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                return new Type_Vec4(((Type_Float)args.get(0)).getValue(),
                                    ((Type_Float)args.get(1)).getValue(),
                                    ((Type_Float)args.get(2)).getValue(),
                                    ((Type_Float)args.get(3)).getValue());
            case 1:
                return new Type_Vec2(((Type_Float)args.get(0)).getValue(),
                                    ((Type_Float)args.get(1)).getValue());

            case 2:
                return new Type_Int((int)((Type_Float)args.get(0)).getValue());
            case 3:
                return new Type_Float((float)((Type_Int)args.get(0)).getValue());

            case 10:
                System.out.println("Int value: " + ((Type_Int)args.get(0)).getValue());
                return new Type_Void();
            case 11:
                System.out.println("Float value: " + ((Type_Float)args.get(0)).getValue());
                return new Type_Void();
            case 12:
                System.out.println("Bool value: " + ((Type_Bool)args.get(0)).getValue());
                return new Type_Void();
            case 13:
                System.out.println("Char value: " + ((Type_Char)args.get(0)).getValue());
                return new Type_Void();
            case 14:
                System.out.println(((Type_String)args.get(0)).getValue());
                return new Type_Void();

            case 20:
                Type_Video retvideo = new Type_Video(((Type_String)args.get(0)).getValue());
                FunctionGlobalVars.scene_graph.addNode(retvideo);
                FunctionGlobalVars.scene_graph.addRef(retvideo);
                return retvideo;
            case 21:
                Type_Camera retcamera = new Type_Camera(((Type_Int)args.get(0)).getValue());
                FunctionGlobalVars.scene_graph.addNode(retcamera);
                FunctionGlobalVars.scene_graph.addRef(retcamera);
                return retcamera;
            case 22:
                Type_Node retnode = new Type_Node(((Type_Int)args.get(0)).getValue(), ((Type_Int)args.get(1)).getValue());
                FunctionGlobalVars.scene_graph.addNode(retnode);
                FunctionGlobalVars.scene_graph.addRef(retnode);
                return retnode;
            case 30:
                return new Type_Audio(((Type_String)args.get(0)).getValue());
            default:
                return null;
        }
    }
}
