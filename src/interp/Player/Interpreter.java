package interp.Player;

import interp.StageTree;
import interp.Types.FilterSignature;
import interp.Types.FunctionSignature;
import interp.Types.TypeInterface;
import processing.core.PApplet;

import java.util.HashMap;

public class Interpreter {
    private HashMap<String, FunctionSignature> function_list;
    private HashMap<String, FilterSignature> filter_list;
    private SceneGraph scene_graph;
    private FunctionDispatcher func_disp;

    private boolean quit;
    private boolean ret;
    private TypeInterface ret_val;

    public Interpreter(HashMap<String, FunctionSignature> function_list,
                       HashMap<String, FilterSignature> filter_list,
                       SceneGraph scene_graph,
                       FunctionDispatcher func_disp) {
        this.function_list = function_list;
        this.filter_list = filter_list;
        this.scene_graph = scene_graph;
        this.func_disp = func_disp;
    }

    public void run(StageTree func, int mode, StageStack stack) {

    }
}
