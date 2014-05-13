package interp.Player;

import interp.GLSLTranslator.Translator;
import interp.Semantic.*;
import interp.StageTree;
import interp.Types.FilterSignature;
import interp.Types.FunctionSignature;
import processing.core.PApplet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.File;

//Processing
import processing.core.*;
import processing.opengl.*;

/**
 * Created by marc on 30/04/14.
 */
public class Player {
    public static final int FIRST = 0;
    public static final int LOOP = 1;
    public static final int LAST = 2;

    private HashMap<String, FunctionSignature> function_list;
    private HashMap<String, FilterSignature> filter_list;
    private StageTree tree;
    private PApplet screen;
    private SceneGraph scene_graph;
    private FunctionDispatcher func_disp;
    private Interpreter interpreter;

    private float lastTime;
    private boolean debug;
    private String folder;

    public Player(PApplet screen, StageTree tree, String folder, boolean debug) {
        this.tree = tree;
        this.debug = debug;
        if(folder == null) folder = "temp/";
        this.folder = folder;
        this.screen = screen;
        FunctionGlobalVars.resolution.setValue(screen.width, screen.height);
        FunctionGlobalVars.screen = screen;
        FunctionGlobalVars.renderer = screen.OPENGL;

        if(debug) System.err.println("Checking filter semantics: ");
        SemanticsFilters sem = new SemanticsFilters(tree, debug);
        sem.checkFilters();

        if(debug) System.err.println("Checking function semantics: ");
        SemanticsFunctions semf = new SemanticsFunctions(tree, sem, debug);
        semf.checkFunctions();

        filter_list = sem.getFilterList();
        function_list = semf.getFunctionList();

        if(debug) System.err.println("Writing filter files: ");
        for(int i=0; i<sem.getFiltersRoot().getChildCount(); i++) {
            Translator tr = new Translator(sem.getFiltersRoot().getChild(i));
            tr.writeFile(folder);
        }

        compileShaders();

        scene_graph = new SceneGraph(screen, debug);
        func_disp = new FunctionDispatcher(tree, function_list, this, scene_graph);
        interpreter = new Interpreter(function_list, filter_list, scene_graph, func_disp);
        lastTime = 0;
    }

    public Interpreter getInterpreter() { return interpreter; }

    private void compileShaders() {
        File file = new File("./" + folder);
        if(!file.exists()) {
            if(!file.mkdir()) throw new RuntimeException("Couldn't create folder.");
        }

        Iterator it = filter_list.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, FilterSignature> pairs = (Map.Entry)it.next();
            FilterSignature fs = pairs.getValue();
            String filter_name = pairs.getKey();
            fs.shader = screen.loadShader(folder + filter_name + ".glsl");
        }
    }

    public void loop(float time) {
        FunctionGlobalVars.time.setValue(time);
        FunctionGlobalVars.dt.setValue(time-lastTime);
        lastTime = time;
        func_disp.process(time);
        scene_graph.process(0);
        scene_graph.clear();
    }
}
