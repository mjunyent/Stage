package interp.Player;

import interp.Types.FilterSignature;
import interp.Types.NodeInterface;

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

    private HashMap<String, Integer> name2id;
    private ArrayList<node> id2node;

    private ArrayList<ArrayList<Integer>> graph;
    int nextId;

    public SceneGraph() {
        name2id = new HashMap<String, Integer>();
        id2node = new ArrayList<node>();
        graph   = new ArrayList<ArrayList<Integer>>();
        nextId = 0;
    }

    //TODO check recursivity.
    public void addNode(String name, NodeInterface node, FilterSignature fs) {
        int id;
        if(name2id.containsKey(name)) { //if it's already in graph we overwrite it.
            id = name2id.get(name);
            id2node.set(id, new node(name,node,fs));
            graph.set(id, new ArrayList<Integer>());
        } else { //If its not added we add it.
            name2id.put(name, nextId);
            id2node.add(new node(name, node, fs));
            graph.add(new ArrayList<Integer>());
            id = nextId;
            nextId++;
        }

        //finally we add inputs. If input doesn't exist. We create one.
        if(fs != null) {
            for(String input_name : fs.inputs_ids) {
                if(name2id.containsKey(input_name)) {
                    graph.get(nextId).add(name2id.get(input_name));
                } else {
                    addNode(input_name, null, null);
                }
            }
        }
    }

    public void process(String name) {
        int id = name2id.get(name);
        node info = id2node.get(id);

        for(String pre : info.fs.)
        int n_prereq = graph.get(id).size();
        for(int pre : graph.get(id)) {
            process()
        }

    }


}
