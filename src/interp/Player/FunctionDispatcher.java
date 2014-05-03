package interp.Player;

import interp.StageTree;
import interp.Types.FilterSignature;
import interp.Types.FunctionSignature;
import java.util.HashMap;
import java.util.LinkedList;

public class FunctionDispatcher {
    public class FuncTime {
        public String fname;
        public float startTime;
        public float endTime;
        public boolean init;
        public boolean fin;
        public StageStack stack;

        public FuncTime(String name, float s, float e) {
            fname = name; startTime = s; endTime = e;
            init = false; fin = false;
            stack = new StageStack();
        }

        public FuncTime(String name, float s, float e, StageStack st) {
            fname = name; startTime = s; endTime = e;
            init = false; fin = false;
            stack = st;
        }
    }
    private HashMap<String, FunctionSignature> function_list;
    private LinkedList<FuncTime> callList;
    private StageTree tree;
    private Player player;

    public FunctionDispatcher(StageTree t, HashMap<String, FunctionSignature> fl, Player p) {
        tree = t;
        function_list = fl;
        player = p;

        callList = new LinkedList<FuncTime>();
        callList.add(new FuncTime("main", 0, Float.POSITIVE_INFINITY));
    }

    public void process(float time) {
        for(int i=0; i<callList.size(); i++) {
            FuncTime ft = callList.get(i);

            if(time > ft.endTime) { //func already ended.
                System.out.println(ft.fname + " hue " + ft.endTime + "-" + time);
                if(ft.fin) callList.remove(i); //already ended, remove.
                else { //not ended but finished, end and remove.
                   executeFunc(ft, player.LAST);
                   callList.remove(i);
                }
            } else if(time > ft.startTime) { //func has started some time ago.
                if(!ft.init) {
                    executeFunc(ft, player.FIRST);
                    ft.init = true;
                }
                executeFunc(ft, player.LOOP);
            } //else func hasn't started.

//            callList.set(i, ft);
        }
    }

    public void addFunc(String fname, float start, float end) {
        callList.addLast(new FuncTime(fname,start,end));
    }

    public void addFunc(String fname, float start, float end, StageStack st) {
        callList.addLast(new FuncTime(fname,start,end,st));
    }

    private void executeFunc(FuncTime ft, int what) {
        if(!function_list.containsKey(ft.fname)) throw new RuntimeException("Dispatcher didn't find " + ft.fname + ". This shouldn't happen");
        FunctionSignature fs = function_list.get(ft.fname);

        Interpreter interp = player.getInterpreter();

        interp.run(fs, what, ft.stack);
        if(interp.quit()) ft.endTime = -1; //next iteration func last will be called.
        if(interp.ret()) { ft.endTime = -1; ft.fin = true; } //next iteration func will be removed.
    }
}
