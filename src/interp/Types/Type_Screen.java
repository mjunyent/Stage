package interp.Types;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.List;

public class Type_Screen extends NodeInterface implements TypeFunctionInterface {
    PApplet screen;

    public Type_Screen() { }

    public Type_Screen(PApplet screen) {
        this.screen = screen;
    }

    public void init() {}
    public PImage getImage() {
        return screen.g;
    }
    public boolean writable() { return true; }

    public PGraphics getRenderer() {
        return screen.g;
    }

    public Types getTypeName() { return Types.SCREEN_T; }

    public Types getMethodArgs(String name, List<Types> args) { return null; }
    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) { return null; }
    public Types getAttributeType(String name) {
        if(name.equals("width")) return Types.FLOAT_T;
        if(name.equals("height")) return Types.FLOAT_T;
        return null;
    }
    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("width")) return new Type_Float(screen==null? -1 : screen.width);
        if(name.equals("height")) return new Type_Float(screen==null? -1 : screen.height);
        return null;
    }
    public void set(TypeInterface obj) { }
}
