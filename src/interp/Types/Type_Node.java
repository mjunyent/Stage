package interp.Types;

import interp.Semantic.FunctionGlobalVars;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.List;

public class Type_Node extends NodeInterface implements TypeFunctionInterface {
    private PGraphics image;

    public Type_Node() {
        id = -1;
        this.width = -1;
        this.height = -1;
    }

    public Type_Node(int width, int height) {
        id = -1;
        this.width = width;
        this.height = height;
    }

    public void init() {
        if(this.width < 0) this.width  = FunctionGlobalVars.screen.width;
        if(this.height < 0) this.height = FunctionGlobalVars.screen.height;
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

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) { return null; }

    public Types getAttributeType(String name) {
        if(name.equals("width")) return Types.FLOAT_T;
        if(name.equals("height")) return Types.FLOAT_T;
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("width")) return new Type_Float(width);
        if(name.equals("height")) return new Type_Float(height);
        return null;
    }

    public void set(TypeInterface obj) {
        this.id = ((Type_Node)obj).id;
        this.image = ((Type_Node)obj).image;
        this.width = ((Type_Node)obj).width;
        this.height = ((Type_Node)obj).height;
    }
}
