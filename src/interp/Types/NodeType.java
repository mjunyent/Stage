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

    public NodeType(int width, int height) {
        id = -1;
        this.width = width;
        this.height = height;
    }

    public void init() {
        this.width  = FunctionGlobalVars.screen.width;
        this.height = FunctionGlobalVars.screen.height;
        image = FunctionGlobalVars.screen.createGraphics(
                                                         width,
                                                         height,
                                                         FunctionGlobalVars.renderer
                                                        );
        image.noStroke();
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
