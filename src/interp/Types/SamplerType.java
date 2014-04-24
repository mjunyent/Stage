package interp.Types;

import java.util.Arrays;
import java.util.List;

public class SamplerType implements TypeInterface {
    public SamplerType() {
    }

    public Types getTypeName() { return Types.SAMPLER_T; }

    public List<Types> getMethodArgs(String name) {
        if(name.equals("[")) return Arrays.asList(new Types[]{Types.VEC4_T, Types.VEC2_T});

        return null;
    }

    public Types getAttributeType(String name) {
        //Todo, add sizes and relevant things. Also modify Translator.java
        return null;
    }

    //Sampler type is only executed in Shader, it does not need call and get.
    public TypeInterface callMethod(String name, List<TypeInterface> args) { return null; }
    public TypeInterface getAttribute(String name) { return null; }

    public boolean canCastTo(Types type) { return false; };
    public TypeInterface castTo(Types type) { return null; };
}
