package interp.Types;

import interp.Semantic.FunctionGlobalVars;
import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.List;

public class NodeType implements NodeInterface, TypeInterface {
    private PGraphics image;

    public void init() {
        image = FunctionGlobalVars.screen.createGraphics(
                                                         FunctionGlobalVars.screen.width,
                                                         FunctionGlobalVars.screen.height,
                                                         FunctionGlobalVars.renderer
                                                        );
    }

    public void setTarget() {

    }

    public void passToShad() {

    }

    public void delete() {
    }

    public boolean writable() { return true; }

    public Types getTypeName() { return Types.NODE_T; }


    public Types getMethodArgs(String name, List<Types> args) { return null; }

    public TypeInterface callMethod(String name, List<TypeInterface> args) { return null; }

    public Types getAttributeType(String name) { return null; }

    public TypeInterface getAttribute(String name) { return null; }

    public void set(TypeInterface obj) {
        //TODO
    }
}
