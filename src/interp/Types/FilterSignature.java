package interp.Types;

import processing.opengl.PShader;
import java.util.List;

public class FilterSignature {
    public String name;
    public List<Types> args;
    public List<String> args_names;
    public List<String> inputs;

    public PShader shader = null;
}

