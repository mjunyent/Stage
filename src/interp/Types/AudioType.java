package interp.Types;

import ddf.minim.AudioPlayer;
import interp.Semantic.FunctionGlobalVars;

import java.util.List;

public class AudioType implements TypeInterface {
    AudioPlayer player;

    public AudioType() { player = null; }

    public AudioType(String file) { player = FunctionGlobalVars.minim.loadFile(file); }

    public Types getTypeName() { return Types.AUDIO_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        return null;
    }

    public TypeInterface callMethod(String name, List<TypeInterface> args) {
        return null;
    }

    public Types getAttributeType(String name) {
        return null;
    }

    public TypeInterface getAttribute(String name) {
        return null;
    }

    public void set(TypeInterface obj) {
        player = ((AudioType)obj).player;
    }
}
