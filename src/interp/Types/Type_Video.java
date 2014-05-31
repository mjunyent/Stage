package interp.Types;

import interp.Semantic.FunctionGlobalVars;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.video.Movie;

import java.util.List;

public class Type_Video extends NodeInterface implements TypeFunctionInterface {
    public Movie video;

    public Type_Video() { video = null; }

    public Type_Video(String path) { video = new Movie(FunctionGlobalVars.screen, path); }

    public void init() { }
    public PImage getImage() { if(video != null && video.width > 0) return video; else return FunctionGlobalVars.pal_card; }
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

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
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
                video.speed(((Type_Float) args.get(0)).getValue());
                break;
            case 3:
                return new Type_Float(video.duration());
            case 4:
                return new Type_Float(video.time());
            case 5:
                video.jump(((Type_Float) args.get(0)).getValue());
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

        return new Type_Void();

    }

    public Types getAttributeType(String name) {
        if(name.equals("width")) return Types.FLOAT_T;
        if(name.equals("height")) return Types.FLOAT_T;
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("width")) return new Type_Float(video==null? -1 : video.width);
        if(name.equals("height")) return new Type_Float(video==null? -1 : video.height);
        return null;
    }

    public void set(TypeInterface obj) {
        this.id = ((Type_Video)obj).id;
        this.video = ((Type_Video)obj).video;
    }
}
