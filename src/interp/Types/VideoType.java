package interp.Types;

import interp.Semantic.FunctionGlobalVars;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.video.Movie;

import java.util.List;

public class VideoType extends NodeInterface implements TypeInterface {
    public Movie video;

    public VideoType() { video = null; }

    public VideoType(String path) { video = new Movie(FunctionGlobalVars.screen, path); }

    public void init() { }
    public PImage getImage() { return video; }
    public boolean writable() { return false; }
    public PGraphics getRenderer() { return null; }


    public Types getTypeName() { return Types.VIDEO_T; }

    static private FunctionList fl;
    static {
        fl = new FunctionList();
        fl.add("play", new Types[] {}, Types.VOID_T, 0);
        fl.add("loop", new Types[] {}, Types.VOID_T, 1);
        fl.add("speed", new Types[] {Types.FLOAT_T}, Types.VOID_T, 2);
        fl.add("duration", new Types[] {}, Types.FLOAT_T, 3);
        fl.add("time", new Types[] {}, Types.FLOAT_T, 4);
        fl.add("jump", new Types[] { Types.FLOAT_T }, Types.VOID_T, 5);
        fl.add("noloop", new Types[] {}, Types.VOID_T, 6);
        fl.add("pause", new Types[] {}, Types.VOID_T, 7);
        fl.add("stop", new Types[] {}, Types.VOID_T, 8);
    }

    public Types getMethodArgs(String name, List<Types> args) {
        if(fl.exists(name, args)) return fl.getFunction(name,args).ret;
        return null;
    }

    public TypeInterface callMethod(String name, List<TypeInterface> args) {
        if(!fl.existsByInterface(name,args)) return null;

        FunctionSignature fs = fl.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                video.play();
                break;
            case 1:
                video.loop();
                break;
            case 2:
                video.speed(((FloatType) args.get(0)).getValue());
                break;
            case 3:
                return new FloatType(video.duration());
            case 4:
                return new FloatType(video.time());
            case 5:
                video.jump(((FloatType) args.get(0)).getValue());
                break;
            case 6:
                video.noLoop();
                break;
            case 7:
                video.pause();
                break;
            case 8:
                video.stop();
                break;
            default:
                return null;
        }

        return new VoidType();

    }

    @Override
    public Types getAttributeType(String name) {
        return null;
    }

    @Override
    public TypeInterface getAttribute(String name) {
        return null;
    }

    public void set(TypeInterface obj) {
        this.id = ((VideoType)obj).id;
        this.video = ((VideoType)obj).video;
    }
}
