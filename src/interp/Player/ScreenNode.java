package interp.Player;

import interp.Types.NodeInterface;
import interp.Types.TypeInterface;
import interp.Types.Types;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.List;

public class ScreenNode extends NodeInterface implements TypeInterface {
    PApplet screen;

    public ScreenNode() { }

    public ScreenNode(PApplet screen) {
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
    public TypeInterface callMethod(String name, List<TypeInterface> args) { return null; }
    public Types getAttributeType(String name) { return null; }
    public TypeInterface getAttribute(String name) { return null; }
    public void set(TypeInterface obj) { }
}
