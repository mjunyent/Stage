package interp.Player;

import interp.Semantic.FunctionGlobalVars;
import interp.Types.*;
import processing.core.PImage;
import processing.opengl.PShader;

import java.util.HashMap;
import java.util.List;

public class SceneGraph {
    class node {
        public String name;
        public NodeInterface node;
        public FilterSignature fs;
        public boolean checked;
        public List<TypeInterface> args_values;
        public List<String> inputs_ids;

        node(String name, NodeInterface node, FilterSignature fs, List<TypeInterface> args_values, List<String> inputs_ids) {
            this.name = name;
            this.node = node;
            this.fs = fs;
            this.args_values = args_values;
            this.inputs_ids = inputs_ids;
            if(fs == null) checked = true;
            else checked = false;
        }
    }

    private HashMap<String, node> name2node;

    public SceneGraph() {
        name2node = new HashMap<String, node>();
    }

    //TODO check recursivity.
    public void addNode(String name, NodeInterface node, FilterSignature fs, List<TypeInterface> args_values, List<String> inputs_ids) {
        name2node.put(name, new node(name,node,fs,args_values,inputs_ids));
    }

    public void addCopy(String name, String from, NodeInterface to) {
     // TO DO   name2node.put(name, )
    }

    public void process(String name) {
        node info = name2node.get(name);
        if(info.checked) return;

        //process all requisites before.
        for(String pre : info.inputs_ids) {
            process(pre);
        }

        //TODO IF there is no node?!

        //call shader.
        info.node.getRenderer().shader(info.fs.shader);

        //give input images.
        for(int i=0; i<info.inputs_ids.size(); i++) {
            node input = name2node.get(info.inputs_ids.get(i)); if(input == null) continue;
            PImage input_img = input.node.getImage(); if(input_img == null) continue;
            info.fs.shader.set(input.fs.inputs.get(i), input_img);
        }

        //give input data.
        for(int i=0; i<info.args_values.size(); i++) {
            String n = info.fs.args_names.get(i);
            TypeInterface ti = info.args_values.get(i);
            PShader shader = info.fs.shader;

            switch (ti.getTypeName()) {
                case INT_T:
                    shader.set(n, ((IntType)ti).getValue());
                    break;
                case FLOAT_T:
                    shader.set(n, ((FloatType)ti).getValue());
                    break;
                case BOOL_T:
                    shader.set(n, ((BoolType)ti).getValue());
                    break;
                case VEC2_T:
                    shader.set(n, ((Vec2Type)ti).getX(), ((Vec2Type)ti).getY());
                    break;
                case VEC4_T:
                    shader.set(n, ((Vec4Type)ti).getX(), ((Vec4Type)ti).getY(), ((Vec4Type)ti).getZ(), ((Vec4Type)ti).getW());
                    break;
            }
        }

        info.node.getRenderer().rect(0, 0, FunctionGlobalVars.resolution.getX(), FunctionGlobalVars.resolution.getY());

        info.checked = true;
    }
}
