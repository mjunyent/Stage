package interp.Player;

import interp.Semantic.FunctionGlobalVars;
import interp.Types.*;
import processing.core.PApplet;
import processing.opengl.PShader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SceneGraph {
    ArrayList<NodeInterface> nodes;
    ArrayList<Integer> referenceCount;
    ArrayList<Effect> effects;
    ArrayList<ArrayList<Integer>> graph;
    int nextId;

    class Effect {
        public FilterSignature fs;
        public boolean checked;
        public List<TypeInterface> args_values;

        Effect(FilterSignature fs, List<TypeInterface> args_values) {
            this.fs = fs;
            this.args_values = args_values;
            checked = false;
        }
    }

    public void printatuputamadre() {
        System.out.println("PRINTATUPUTAMADRE");
        for(int i=0; i<referenceCount.size(); i++) {
            System.out.println(i + ": " + referenceCount.get(i));
        }
    }

    public SceneGraph(PApplet screen) {
        nodes = new ArrayList<NodeInterface>();
        referenceCount = new ArrayList<Integer>();
        graph = new ArrayList<ArrayList<Integer>>();
        effects = new ArrayList<Effect>();
        nextId = 0;

        FunctionGlobalVars.screen_node = new ScreenNode(screen);

        addNode(FunctionGlobalVars.screen_node);
    }

    public void clear() {
        for(int i=0; i<effects.size(); i++) effects.set(i,null);
        for(int i=0; i<graph.size(); i++) if(graph.get(i) != null) graph.get(i).clear();
        for(int i=1; i<referenceCount.size(); i++) {
            if(referenceCount.get(i) <= 0) {
                nodes.set(i, null);
                referenceCount.set(i, -99);
                effects.set(i, null);
                graph.set(i, null);
            }
        }
    }

    public void addNode(NodeInterface node) {
        node.init();
        node.setId(nextId);
        nextId++;

        nodes.add(node);
        referenceCount.add(0);
        graph.add(new ArrayList<Integer>());
        effects.add(null);
    }

    public void addRef(NodeInterface node) {
        int id = node.getId();
        referenceCount.set(id, referenceCount.get(id)+1);
    }

    public void delRef(NodeInterface node) {
        int id = node.getId();
        referenceCount.set(id, referenceCount.get(id)-1);
    }

    public void addEffect(NodeInterface node, FilterSignature filter, List<TypeInterface> args, List<NodeInterface> inputs) {
        effects.set(node.getId(), new Effect(filter, args));

        graph.get(node.getId()).clear();
        for(NodeInterface n : inputs) {
            graph.get(node.getId()).add(n.getId());
        }
    }

    public void process(int id) {
        NodeInterface node = nodes.get(id);
        Effect effect = effects.get(id);
        ArrayList<Integer> dependencies = graph.get(id);

        if(effect == null) return; //nothing to do
        if(effect.checked) return; //avoid loops

        //process dependencies
        for(Integer i : dependencies) {
            process(i);
        }

        //call shader
        node.getRenderer().beginDraw();
        node.getRenderer().background(0);
        node.getRenderer().shader(effect.fs.shader);

        //give input images.
        for(int i=0; i<dependencies.size(); i++) {
            NodeInterface input = nodes.get(dependencies.get(i));
            if(input.getImage() == null) continue;
            effect.fs.shader.set(effect.fs.inputs.get(i), input.getImage());
        }

        //give input data.
        for(int i=0; i<effect.args_values.size(); i++) {
            String argname = effect.fs.args_names.get(i);
            TypeInterface ti = effect.args_values.get(i);
            PShader shader = effect.fs.shader;

            switch (ti.getTypeName()) {
                case INT_T:
                    shader.set(argname, ((IntType)ti).getValue());
                    break;
                case FLOAT_T:
                    shader.set(argname, ((FloatType)ti).getValue());
                    break;
                case BOOL_T:
                    shader.set(argname, ((BoolType)ti).getValue());
                    break;
                case VEC2_T:
                    shader.set(argname, ((Vec2Type)ti).getX(), ((Vec2Type)ti).getY());
                    break;
                case VEC4_T:
                    shader.set(argname, ((Vec4Type)ti).getX(), ((Vec4Type)ti).getY(), ((Vec4Type)ti).getZ(), ((Vec4Type)ti).getW());
                    break;
            }

        }

        node.getRenderer().rect(0, 0, FunctionGlobalVars.resolution.getX(), FunctionGlobalVars.resolution.getY());
        node.getRenderer().endDraw();

        //effect checked.
        effect.checked = true;
    }
}
