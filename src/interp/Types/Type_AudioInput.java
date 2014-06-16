package interp.Types;

import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.analysis.FFT;
import interp.Semantic.FunctionGlobalVars;

import java.util.List;

public class Type_AudioInput implements TypeFunctionInterface {
    AudioInput in;
    FFT fft;

    static private FunctionList fl;
    static {
        fl = new FunctionList();

        fl.add("monitoring", new Types[] { Types.BOOL_T }, Types.VOID_T, 0);
        fl.add("init", new Types[] {}, Types.VOID_T, 1);

        fl.add("FFT", new Types[] {}, Types.A_FLOAT_T, 12);
        fl.add("LeftFFT", new Types[] {}, Types.A_FLOAT_T, 13);
        fl.add("RightFFT", new Types[] {}, Types.A_FLOAT_T, 14);

        fl.add("left", new Types[] { Types.INT_T }, Types.FLOAT_T, 15);
        fl.add("right", new Types[] { Types.INT_T }, Types.FLOAT_T, 16);
    }

    public Type_AudioInput() {
        in = null;
        fft = null;
    }

    public Types getTypeName() { return Types.AINPUT_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(fl.exists(name, args)) return fl.getFunction(name,args).ret;
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(!fl.existsByInterface(name,args)) return null;

        FunctionSignature fs = fl.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                if(((Type_Bool)args.get(0)).getValue()) in.enableMonitoring();
                else in.disableMonitoring();
                return new Type_Void();
            case 1:
                in = FunctionGlobalVars.minim.getLineIn();
                fft = new FFT( in.bufferSize(), in.sampleRate() );
                in.disableMonitoring();
                return new Type_Void();
            case 12:
                fft.forward(in.mix);
                Type_Array t = new Type_Array();
                t.setType(Types.A_FLOAT_T);

                for(int i = 0; i < fft.specSize(); i++)
                    t.array.add(new Type_Float(fft.getBand(i)));

                return t;
            case 13:
                fft.forward(in.left);
                Type_Array tl = new Type_Array();
                tl.setType(Types.A_FLOAT_T);

                for(int i = 0; i < fft.specSize(); i++)
                    tl.array.add(new Type_Float(fft.getBand(i)));

                return tl;
            case 14:
                fft.forward(in.right);
                Type_Array tr = new Type_Array();
                tr.setType(Types.A_FLOAT_T);

                for(int i = 0; i < fft.specSize(); i++)
                    tr.array.add(new Type_Float(fft.getBand(i)));

                return tr;

            case 15:
                int pl = ((Type_Int)args.get(0)).getValue();
                if(pl < 0 || pl >= in.bufferSize()) throw new RuntimeException("Audio buffer access out of bounds");
                return new Type_Float(in.left.get(pl));
            case 16:
                int pr = ((Type_Int)args.get(0)).getValue();
                if(pr < 0 || pr >= in.bufferSize()) throw new RuntimeException("Audio buffer access out of bounds");
                return new Type_Float(in.right.get(pr));
            default:
                return null;
        }
    }

    public Types getAttributeType(String name) {
        if(name.equals("size")) return Types.INT_T;
        if(name.equals("isMonitoring")) return Types.BOOL_T;
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("size")) return new Type_Int(in.bufferSize());
        if(name.equals("isMonitoring")) return new Type_Bool(in.isMonitoring());
        return null;
    }

    public void set(TypeInterface obj) {
        in = ((Type_AudioInput)obj).in;
        fft = ((Type_AudioInput)obj).fft;
    }
}
