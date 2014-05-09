package interp.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class SceneGraph {
    private HashMap<String, Integer> name2id;
    private ArrayList<String> id2name;
    private ArrayList<ArrayList<Integer>> graph;
    int nextId;

    public SceneGraph() {
        name2id = new HashMap<String, Integer>();
        id2name = new ArrayList<String>();
        graph   = new ArrayList<ArrayList<Integer>>();
        nextId = 0;
    }

    public void addNode(String name) {
        name2id.put(name, nextId);
        id2name.add(name);
        graph.add(new ArrayList<Integer>());
    }

    


}
