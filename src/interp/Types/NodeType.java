package interp.Types;

import interp.Semantic.FunctionGlobalVars;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.List;

public class NodeType extends NodeInterface implements TypeInterface {
    private PGraphics image;

    public NodeType() {
        id = -1;
    }

    public void init() {
        image = FunctionGlobalVars.screen.createGraphics(
                                                         FunctionGlobalVars.screen.width,
                                                         FunctionGlobalVars.screen.height,
                                                         FunctionGlobalVars.renderer
                                                        );
    }

    public boolean writable() { return true; }
    public PImage getImage() {
        return image;
    }
    public PGraphics getRenderer() {
        return image;
    }

    public Types getTypeName() { return Types.NODE_T; }

    public Types getMethodArgs(String name, List<Types> args) { return null; }
    public TypeInterface callMethod(String name, List<TypeInterface> args) { return null; }
    public Types getAttributeType(String name) { return null; }
    public TypeInterface getAttribute(String name) { return null; }

    public void set(TypeInterface obj) {
        this.id = ((NodeType)obj).id;
        this.image = ((NodeType)obj).image;
    }
}
