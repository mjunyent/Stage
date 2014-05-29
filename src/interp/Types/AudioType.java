package interp.Types;

import ddf.minim.AudioPlayer;
import ddf.minim.analysis.FFT;
import interp.Semantic.FunctionGlobalVars;

import java.util.List;

public class AudioType implements TypeFunctionInterface {
    AudioPlayer player;
    FFT fft;

    static private FunctionList fl;
    static {
        fl = new FunctionList();
        fl.add("play", new Types[] {}, Types.VOID_T, 0);
        fl.add("isPlaying", new Types[] {}, Types.BOOL_T, 1);
        fl.add("loop", new Types[] {}, Types.VOID_T, 2);
        fl.add("isLooping", new Types[] {}, Types.BOOL_T, 3);
        fl.add("duration", new Types[] {}, Types.FLOAT_T, 4);
        fl.add("position", new Types[] {}, Types.FLOAT_T, 5);
        fl.add("jump", new Types[] { Types.FLOAT_T }, Types.VOID_T, 6);
        fl.add("pause", new Types[] {}, Types.VOID_T, 7);
        fl.add("stop", new Types[] {}, Types.VOID_T, 8);
        fl.add("setLoopPoints", new Types[] {Types.FLOAT_T, Types.FLOAT_T}, Types.VOID_T, 9);
        fl.add("mute", new Types[] {}, Types.VOID_T, 10);
        fl.add("unmute", new Types[] {}, Types.VOID_T, 11);
        fl.add("isMuted", new Types[] {}, Types.BOOL_T, 12);

        fl.add("FFT", new Types[] {}, Types.A_FLOAT_T, 13);
/*      getBalance()	 	Returns the current balance.
        getGain ( )	 	Returns the current gain.
        getPan ( )	 	Returns the current pan.
        getVolume ( )	 	Returns the current volume.

        shiftBalance()	 	Transitions the balance from one value to another.
        shiftGain ( )	 	Transitions the gain from one value to another.
        shiftPan ( )	 	Transitions the pan from one value to another.
        shiftVolume ( )	 	Transitions the volume from one value to another.*/

    }

    public AudioType() {
        player = null;
    }

    public AudioType(String file) {
        player = FunctionGlobalVars.minim.loadFile(file, 1024);
        fft = new FFT( player.bufferSize(), player.sampleRate() );
    }

    public Types getTypeName() { return Types.AUDIO_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(fl.exists(name, args)) return fl.getFunction(name,args).ret;
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(!fl.existsByInterface(name,args)) return null;

        FunctionSignature fs = fl.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                player.play();
                return new VoidType();
            case 1:
                return new BoolType(player.isPlaying());
            case 2:
                player.loop();
                return new VoidType();
            case 3:
                return new BoolType(player.isLooping());
            case 4:
                return new FloatType(((float)player.length())/ 1000.0f);
            case 5:
                return new FloatType(((float)player.position()) / 1000.0f);
            case 6:
                player.cue((int)(((FloatType)args.get(0)).getValue()*1000));
                return new VoidType();
            case 7:
                player.pause();
                return new VoidType();
            case 8:
                player.pause();
                player.rewind();
                return new VoidType();
            case 9:
                player.setLoopPoints((int)(((FloatType)args.get(0)).getValue()*1000), (int)(((FloatType)args.get(1)).getValue()*1000));
                return new VoidType();
            case 10:
                player.mute();
                return new VoidType();
            case 11:
                player.unmute();
                return new VoidType();
            case 12:
                return new BoolType(player.isMuted());

            case 13:
                fft.forward(player.mix);
                ArrayType t = new ArrayType();
                t.setType(Types.A_FLOAT_T);

                System.out.println(fft.specSize());

                for(int i = 0; i < fft.specSize(); i++)
                    t.array.add(new FloatType(fft.getBand(i)));

                return t;
            default:
                return null;
        }
    }

    public Types getAttributeType(String name) {
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        return null;
    }

    public void set(TypeInterface obj) {
        player = ((AudioType)obj).player;
    }
}
