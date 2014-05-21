package interp.Types;

import java.util.List;

public class SamplerType implements TypeInterface {
    public SamplerType() {
    }

    public Types getTypeName() { return Types.SAMPLER_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(args.size() == 1 && args.get(0)==Types.VEC2_T && name.equals("[")) return Types.VEC4_T;

        return null;
    }

    public Types getAttributeType(String name) {
        //Todo, add sizes and relevant things. Also modify Translator.java to make them work
        return null;
    }

    //Sampler type is only executed in Shader, it does not need call and get.
    public TypeInterface callMethod(String name, List<TypeInterface> args) { return null; }
    public TypeInterface getAttribute(String name) { return null; }

    public void set(TypeInterface obj) {
    }
}
