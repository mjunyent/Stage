package interp;

import parser.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Player {
    private HashMap<String,StageTree> functions;
    private HashMap<String,StageTree> filters;

    public Player(StageTree tree) {

    }


    private void MapFunctions(StageTree tree) {
        functions = new HashMap<String, StageTree>();

        for(int i=0; i<tree.getChildCount(); i++) {
            StageTree f = tree.getChild(i);
            String name = f.getChild(0).getText();
            if(functions.containsKey(name)) {
                throw new RuntimeException("Multiple definitions of function " + name);
            }
            functions.put(name, f);
        }
    }

}
