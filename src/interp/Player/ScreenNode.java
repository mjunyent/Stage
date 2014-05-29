package interp.Player;

import interp.Types.NodeInterface;
import interp.Types.TypeFunctionInterface;
import interp.Types.TypeInterface;
import interp.Types.Types;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.List;
//TODO, check this a bite. Sizes and all that stuff.
public class ScreenNode extends NodeInterface implements TypeFunctionInterface {
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
    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) { return null; }
    public Types getAttributeType(String name) { return null; }
    public TypeFunctionInterface getAttribute(String name) { return null; }
    public void set(TypeInterface obj) { }
}
