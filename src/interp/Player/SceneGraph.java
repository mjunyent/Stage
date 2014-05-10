package interp.Player;

import interp.Types.*;
import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;

import java.util.ArrayList;
import java.util.HashMap;

public class SceneGraph {
    class node {
        public String name;
        public NodeInterface node;
        public FilterSignature fs;

        node(String name, NodeInterface node, FilterSignature fs) {
            this.name = name;
            this.node = node;
            this.fs = fs;
        }
    }

    private HashMap<String, node> name2node;
    private PApplet screen;

    public SceneGraph(PApplet screen) {
        name2node = new HashMap<String, node>();
        this.screen = screen;
    }

    //TODO check recursivity.
    public void addNode(String name, NodeInterface node, FilterSignature fs) {
        name2node.put(name, new node(name,node,fs));
    }

    public void process(String name) {
        node info = name2node.get(name);

        //process all requisites before.
        for(String pre : info.fs.inputs_ids) {
            process(pre);
        }

        //TODO if there is shader!
        //TODO IF there is node?!

        //call shader.
        info.node.getRenderer().shader(info.fs.shader);

        //give input images.
        for(int i=0; i<info.fs.inputs_ids.size(); i++) {
            node input = name2node.get(info.fs.inputs_ids.get(i)); if(input == null) continue;
            PImage input_img = input.node.getImage(); if(input_img == null) continue;
            info.fs.shader.set(input.fs.inputs.get(i), input_img);
        }

        //give input data.
        for(int i=0; i<info.fs.args_values.size(); i++) {
            String n = info.fs.args_names.get(i);
            TypeInterface ti = info.fs.args_values.get(i);
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

//        info.node.getRenderer().rect(0, 0, info.node.getWidth(), info.node.getHeight());
    }


}
