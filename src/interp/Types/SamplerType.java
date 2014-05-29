package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class SamplerType implements TypeFilterInterface {
    public SamplerType() {
    }

    public Types getTypeName() { return Types.SAMPLER_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 && args.get(0)==Types.VEC2_T && name.equals("[")) return Types.VEC4_T;

        return null;
    }

    public Types getAttributeType(String name) {
        if(name.equals("resolution")) return Types.VEC2_T;

        //Todo, add sizes and relevant things. Also modify Translator.java to make them work
        return null;
    }


    public void passToShader(PShader shad, String name) { //sample is a proxy type for all kinds of textures. passToShader not necessary.
    }

    public String callMethod(String left, String name, List<Types> args_types, List<String> args) {
        if(name.equals("[") && args_types.size() == 1 && args_types.get(0)==Types.VEC2_T) {
            return "texture2D(" + left + ".texture , " + args.get(0) + ")";
        }

        return null;
    }

    public String getAttribute(String left, String name) {
        return left + "." + name;
    }
}
