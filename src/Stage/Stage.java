package Stage;

// Imports for ANTLR
import interp.Player.Player;
import interp.Semantic.SemanticsFilters;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

// Imports from Java
import org.apache.commons.cli.*; // Command Language Interface
import java.io.*;

// Parser and Interpreter
import parser.*;
import interp.*;

//Processing
import processing.core.*;
import processing.video.Capture;
import processing.video.Movie;

public class Stage extends PApplet {
    private static String infile = null;
    private static String astfile = null;
    private static boolean dotformat = false;
    private static int resX = 0;
    private static int resY = 0;
    private static boolean fullscreen = false;
    private static boolean debug = false;

    private static boolean execute = true;

    private static StageTree st;
    private static Player player;

    /** Name of the file storing the trace of the program. */
    //private static String tracefile = null;

    private static void createAST() {
        CharStream input = null;
        try {
            input = new ANTLRFileStream(infile);
        } catch (IOException e) {
            System.err.println ("Error: file " + infile + " could not be opened.");
            System.exit(1);
        }

        StageLexer lex = new StageLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);

        StageParser parser = new StageParser(tokens);
        StageTreeAdaptor adaptor = new StageTreeAdaptor();
        parser.setTreeAdaptor(adaptor);
        StageParser.prog_return result = null;
        try {
            result = parser.prog();
        } catch (Exception e) {}

        int nerrors = parser.getNumberOfSyntaxErrors();
        if (nerrors > 0) {
            System.err.println (nerrors + " errors detected. " +
                    "The program has not been executed.");
            System.exit(1);
        }

        st = (StageTree)result.getTree();
    }

    public static void writeAST() {
        if (astfile != null) {
            File ast = new File(astfile);
            BufferedWriter output = null;
            try { output = new BufferedWriter(new FileWriter(ast)); } catch (IOException e) { e.printStackTrace(); }
            if (dotformat) {
                DOTTreeGenerator gen = new DOTTreeGenerator();
                try { output.write(gen.toDOT(st).toString()); } catch (IOException e) { e.printStackTrace(); }
            } else {
                try { output.write(st.toStringTree()); } catch (IOException e) { e.printStackTrace(); }
            }
            try { output.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }

    public static void main(String[] args) {
        if (!readOptions(args)) System.exit(1);

        if(execute) {
            if(fullscreen) PApplet.main(new String[] { "--present", "Stage.Stage" });
            else PApplet.main(new String[] { "Stage.Stage" });
        } else {
            createAST();
            writeAST();
            SemanticsFilters sem = Player.checkFilters(st, debug);
            Player.checkFunctions(st, debug, sem);
        }
    }

    private static boolean readOptions(String[] args) {
        // Define the options
        Option help = new Option("help", "print this message");
        Option noexec = new Option("noexec", "do not execute the program");
        Option dot = new Option("dot", "dump the AST in dot format");
        Option ast = OptionBuilder
                        .withArgName ("file")
                        .hasArg()
                        .withDescription ("write the AST")
                        .create ("ast");
        Option trace = OptionBuilder
                        .withArgName ("file")
                        .hasArg()
                        .withDescription ("write a trace of function calls during the execution of the program")
                        .create ("trace");
        Option resolution = OptionBuilder
                             .withArgName("x, y")
                             .hasArgs(2)
                             .withDescription("window resolution, use 0 for screen resolution")
                             .create("res");
        Option fs = new Option("fs", "Open in fullscreen");
        Option deb = new Option("debug", "Show more warning messages");

        Options options = new Options();
        options.addOption(help);
        options.addOption(dot);
        options.addOption(ast);
        options.addOption(trace);
        options.addOption(noexec);
        options.addOption(resolution);
        options.addOption(fs);
        options.addOption(deb);
        CommandLineParser clp = new GnuParser();
        CommandLine line = null;

        String cmdline = "Stage [options] file";
        
        
        // Parse the options
        try {
            line = clp.parse (options, args);
        }
        catch (ParseException exp) {
            System.err.println ("Incorrect command line: " + exp.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp (cmdline, options);
            return false;
        }

        // Option -help
        if (line.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp (cmdline, options);
            return false;
        }

        if (line.hasOption("dot")) dotformat = true;
        if (line.hasOption("ast")) astfile = line.getOptionValue ("ast");
        if (line.hasOption("noexec")) execute = false;
        if (line.hasOption("res")) {
            resX = Integer.parseInt(line.getOptionValues("res")[0]);
            resY = Integer.parseInt(line.getOptionValues("res")[1]);
        }
        if (line.hasOption("fs")) fullscreen = true;
        if (line.hasOption("debug")) debug = true;

        // Option -trace dotfile
//        if (line.hasOption ("trace")) tracefile = line.getOptionValue ("trace");


        // Remaining arguments (the input file)
        String[] files = line.getArgs();
        if (files.length != 1) {
            System.err.println ("Incorrect command line.");
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp (cmdline, options);
            return false;
        }
        
        infile = files[0];
        return true;
    }

    int loadstages = 0;
    int playTime = 0;

    public void setup() {
        if(resX <= 0 || resY <= 0) size(displayWidth, displayHeight, OPENGL);
        else size(resX, resY, OPENGL);

        background(0);
        noStroke();
        frame.setTitle("Stage");
    }

    public void movieEvent(Movie m) {
        m.read();
    }

    public void captureEvent(Capture c) {
        c.read();
    }

    public void draw() {
        background(0);

        if(loadstages < 7) {
            float per = 0.0f;
            switch (loadstages) {
                case 0:
                    createAST();
                    writeAST();
                    player = new Player(this, st, null, debug);
                    per = 0.12f;
                    break;
                case 1:
                    player.setFilters();
                    per = 0.24f;
                    break;
                case 2:
                    player.setFunctions();
                    per = 0.36f;
                    break;
                case 3:
                    player.setFiles();
                    per = 0.48f;
                    break;
                case 4:
                    player.setShaders();
                    per = 0.60f;
                    break;
                case 5:
                    player.setGlobals();
                    per = 0.75f;
                    break;
                case 6:
                    player.setMainFirst();
                    per = 1.0f;
                    break;
            }
            loadstages++;
            drawLoadingBar(per);
            playTime = millis();
        } else {
            player.loop((float)((millis()-playTime)/1000.0));
        }
    }

    public void drawLoadingBar(float chant) {
        stroke(255);
        fill(0);
        strokeWeight(2);
        rectMode(CENTER);
        rect(width/2, height/2, width*0.9f, 30);

        noStroke();
        rectMode(CORNER);
        fill(255);
        rect(width*0.05f+4, height/2-11, max(width*0.9f*chant-8,0) , 22);


        fill(0);
    }
}
