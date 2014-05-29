package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public interface TypeFilterInterface extends TypeInterface {
    public void passToShader(PShader shad, String name);
    public String callMethod(String left, String name, List<Types> args_types, List<String> args);
    public String getAttribute(String left, String name);
}
