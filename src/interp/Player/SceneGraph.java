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
    LinkedList<Integer> emptySpaces;
    ArrayList<Effect> effects;
    ArrayList<ArrayList<Integer>> graph;
    int nextId;
    boolean debug;

    class Effect {
        public FilterSignature fs;
        public boolean checked;
        public List<TypeFunctionInterface> args_values;

        Effect(FilterSignature fs, List<TypeFunctionInterface> args_values) {
            this.fs = fs;
            this.args_values = args_values;
            checked = false;
        }
    }

    public void printReferenceCount() {
        System.out.println("Printing reference count");
        for(int i=0; i<referenceCount.size(); i++) {
            System.out.println(i + ": " + referenceCount.get(i));
        }
    }

    public SceneGraph(PApplet screen, boolean debug) {
        nodes = new ArrayList<NodeInterface>();
        referenceCount = new ArrayList<Integer>();
        graph = new ArrayList<ArrayList<Integer>>();
        effects = new ArrayList<Effect>();
        emptySpaces = new LinkedList<Integer>();
        this.debug = debug;
        nextId = 0;

        FunctionGlobalVars.screen_node = new ScreenNode(screen);

        addNode(FunctionGlobalVars.screen_node);
    }

    public void clear() {
        for(int i=0; i<effects.size(); i++) effects.set(i,null);
        for(int i=0; i<graph.size(); i++) if(graph.get(i) != null) graph.get(i).clear();
        for(int i=1; i<referenceCount.size(); i++) {
            if(referenceCount.get(i) != null && referenceCount.get(i) <= 0) {
                nodes.set(i, null);
                referenceCount.set(i, null);
                effects.set(i, null);
                graph.set(i, null);
                emptySpaces.addLast(i);
            }
        }
    }

    public void addNode(NodeInterface node) {
        node.init();
        if(emptySpaces.size() == 0) {
            node.setId(nextId);
            nextId++;
            nodes.add(node);
            referenceCount.add(0);
            graph.add(new ArrayList<Integer>());
            effects.add(null);
        } else {
            int id = emptySpaces.pollFirst();
            node.setId(id);
            nodes.set(id, node);
            referenceCount.set(id, 0);
            graph.set(id, new ArrayList<Integer>());
            effects.set(id, null);
        }
    }

    public void addRef(NodeInterface node) {
        int id = node.getId();
        referenceCount.set(id, referenceCount.get(id)+1);
    }

    public void delRef(NodeInterface node) {
        int id = node.getId();
        referenceCount.set(id, referenceCount.get(id)-1);
    }

    public void addEffect(NodeInterface node, FilterSignature filter, List<TypeFunctionInterface> args, List<NodeInterface> inputs) {
        effects.set(node.getId(), new Effect(filter, args));

        graph.get(node.getId()).clear();
        for(NodeInterface n : inputs) {
            graph.get(node.getId()).add(n.getId());
        }
    }

    public void bypassEffect(NodeInterface node, Integer which, NodeInterface nwhich) {
        int id = node.getId();
        Effect effect = effects.get(id);
        ArrayList<Integer> dependencies = graph.get(id);

        if(which == null && nwhich == null) {
            effects.set(id, null);
            graph.set(id, new ArrayList<Integer>());
            return;
        }

        int which_id;
        if(which == null) {
            which_id = nwhich.getId();
        } else {
            if(which >= dependencies.size() || which < 0) {
                if(debug) System.err.println("Bypassing with id out of range, empty will be used.");
                effects.set(id, null);
                graph.set(id, new ArrayList<Integer>());
                return;
            }
            which_id = dependencies.get(which);
        }

        ArrayList<Integer> new_dep = new ArrayList<Integer>();
        new_dep.add(which_id);
        graph.set(id, new_dep);
        effect.fs = null;
        effect.args_values = null;
    }

    public void addEffectAfter(NodeInterface after_what, NodeInterface node, FilterSignature filter, List<TypeFunctionInterface> args, List<NodeInterface> inputs) {
        //change all references pointin to after_what to point ot node.
        for(int i=0; i<graph.size(); i++) {
            if(graph.get(i) != null) {
                for(int j=0; j<graph.get(i).size(); j++) {
                    if(graph.get(i).get(j) == after_what.getId()) {
                        graph.get(i).set(j,node.getId());
                    }
                }
            }
        }
        //add effect as normal.
        effects.set(node.getId(), new Effect(filter, args));
        graph.get(node.getId()).clear();
        for(NodeInterface n : inputs) {
            graph.get(node.getId()).add(n.getId());
        }
    }

    public boolean isCyclicUtil(int v, ArrayList<Boolean> visited, ArrayList<Boolean> recStack) {
        if(!visited.get(v)) {
            visited.set(v,true);
            recStack.set(v,true);

            if(graph.get(v) != null) {
                for(Integer adj : graph.get(v)) {
                    if(!visited.get(adj) && isCyclicUtil(adj, visited, recStack)) {
                        return true;
                    } else if(recStack.get(adj)) return true;
                }
            }
        }
        recStack.set(v,false);
        return false;
    }

    public boolean isCyclic() {
        ArrayList<Boolean> visited = new ArrayList<Boolean>(graph.size());
        ArrayList<Boolean> recStack = new ArrayList<Boolean>(graph.size());
        for(int i=0; i<graph.size(); i++) {
            visited.add(i, false);
            recStack.add(i, false);
        }

        for(int i=0; i<graph.size(); i++) {
            if(isCyclicUtil(i,visited,recStack)) return true;
        }
        return false;
    }

    public void process(int id) {
        NodeInterface node = nodes.get(id);
        Effect effect = effects.get(id);
        ArrayList<Integer> dependencies = graph.get(id);

        if(effect == null) return; //nothing to do
        if(effect.checked) return; //avoid loops

        //effect checked.
        effect.checked = true;

        //process dependencies
        for(Integer i : dependencies) {
            process(i);
        }

        //Shortcut, copy shader (empty filter signature variable).
        if(effect.fs == null) {
            node.getRenderer().beginDraw();
            node.getRenderer().background(0);
            node.getRenderer().image(nodes.get(dependencies.get(0)).getImage(), 0.0f, 0.0f, node.getRenderer().width, node.getRenderer().height);
            node.getRenderer().endDraw();
            return;
        }

        //call shader
        node.getRenderer().beginDraw();
        node.getRenderer().background(0);
        node.getRenderer().shader(effect.fs.shader);

        //give system uniforms.
        effect.fs.shader.set("time", FunctionGlobalVars.time.getValue());
        effect.fs.shader.set("resolution", (float)node.getRenderer().width, (float)node.getRenderer().height);

        //give input images.
        for(int i=0; i<dependencies.size(); i++) {
            NodeInterface input = nodes.get(dependencies.get(i));
            if(input.getImage() == null) continue;
            effect.fs.shader.set(effect.fs.inputs.get(i)+".texture", input.getImage());
            effect.fs.shader.set(effect.fs.inputs.get(i)+".resolution", input.getImage().width, input.getImage().height);
        }

        //give input data.
        for(int i=0; i<effect.args_values.size(); i++) {
            TypeFilterInterface ti = (TypeFilterInterface)effect.args_values.get(i);
            ti.passToShader(effect.fs.shader, effect.fs.args_names.get(i));
        }

        node.getRenderer().rect(0, 0, node.getRenderer().width, node.getRenderer().height);
        node.getRenderer().endDraw();
    }
}
