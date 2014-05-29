package interp.Types;

import interp.Semantic.FunctionGlobalVars;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.video.Capture;

import java.util.List;

public class Type_Camera extends NodeInterface implements TypeFunctionInterface {
    public Capture cam;

    public Type_Camera() { cam = null; }

    public Type_Camera(int id) {
        String[] cameras = Capture.list();
        if(id >= 0 && id < cameras.length) {
            cam = new Capture(FunctionGlobalVars.screen, cameras[id]);
        } else {
            System.err.println("Camera id " + id + " out of range (" + cameras.length + ").");
            cam = null;
        }
    }

    public void init() { }
    public PImage getImage() { if(cam != null && cam.width > 0) { return cam; } else return FunctionGlobalVars.pal_card; }
    public boolean writable() { return false; }
    public PGraphics getRenderer() { return null; }


    public Types getTypeName() { return Types.CAM_T; }

    static private FunctionList fl;
    static {
        fl = new FunctionList();
        fl.add("start", new Types[] {}, Types.VOID_T, 0);
        fl.add("stop", new Types[] {}, Types.VOID_T, 1);
        fl.add("init", new Types[] {}, Types.BOOL_T, 2);
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
                if(cam != null) cam.start();
                break;
            case 1:
                if(cam != null) cam.stop();
                break;
            case 2:
                if(cam != null) return new Type_Bool(true); else return new Type_Bool(false);
            default:
                return null;
        }
        return new Type_Void();
    }

    @Override
    public Types getAttributeType(String name) {
        return null;
    }

    @Override
    public TypeFunctionInterface getAttribute(String name) {
        return null;
    }

    public void set(TypeInterface obj) {
        this.id = ((Type_Camera)obj).id;
        this.cam = ((Type_Camera)obj).cam;
    }
}
