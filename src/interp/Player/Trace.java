package interp.Player;

import java.util.LinkedList;
import java.util.ListIterator;

public class Trace {
    class StackTraceItem {
        public String fname;
        public int line;
        public StackTraceItem (String name, int l) {
            fname = name; line = l;
        }
    }

    int line, mode, iteration;
    float from, to, when;
    public String fun_name, called_from;

    LinkedList<StackTraceItem> callList;

    public Trace(String fun_name, String called_from, int line, float when, float from, float to) {
        callList = new LinkedList<StackTraceItem>();
        this.line = line;
        this.from = from;
        this.when = when;
        this.to = to;
        this.fun_name = fun_name;
        this.called_from = called_from;
        this.iteration = -1;
        callList.add(new StackTraceItem(fun_name, line));
    }

    public void setMode(int mode) {
        this.mode = mode;
        if(this.mode == Player.LOOP) iteration++;
    }

    public void push(String name, int line) {
        callList.addLast(new StackTraceItem(name,line));
    }

    public void pop() {
        callList.removeLast();
    }

    public String printTrace(int current_line) {
        StringBuffer trace = new StringBuffer("Executing function " + fun_name + ", from " + from + " until " + to + System.lineSeparator());
        trace.append("Called from " + called_from + " at " + when + System.lineSeparator());
        if(mode == Player.LOOP) trace.append("Executing iteration " + iteration + " on loop" + System.lineSeparator());
        trace.append("TRACE" + System.lineSeparator());

        ListIterator<StackTraceItem> it = callList.listIterator(callList.size());
        while(it.hasPrevious()) {
            StackTraceItem st = it.previous();
            trace.append("|> " + st.fname + ": line " + current_line + System.lineSeparator());
            current_line = st.line;
        }

        return trace.toString();
    }
}
