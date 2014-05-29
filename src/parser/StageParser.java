// $ANTLR 3.4 /Users/marc/IdeaProjects/Stage/src/parser/Stage.g 2014-05-29 20:57:41

package parser;
import interp.StageTree;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class StageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADDFILT", "AND", "ARGLIST", "ARRAY", "ASIGEQUAL", "ASSIGN", "BOOLEAN", "BYPASSF", "CBL", "CBR", "CHAR", "COMMENT", "DECLARE", "DIV", "ELSE", "EMPTYFILT", "EQUAL", "ESC_SEQ", "FALSE", "FILTCALL", "FILTER", "FIRST", "FLOAT", "FROM", "FUNCALL", "FUNCTION", "GE", "GT", "ID", "IF", "INPUTS", "INT", "LAST", "LE", "LIST_FILTERS", "LIST_FUNCTIONS", "LIST_INSTR", "LOOP", "LT", "MEMBER", "MINUS", "MOD", "MUL", "NOT", "NOT_EQUAL", "OPERATOR", "OR", "PARAM", "PARAMS", "PLUS", "QUIT", "RETURN", "ROOT", "STRING", "TIMECALL", "TRUE", "UNTIL", "WHILE", "WS", "'('", "')'", "','", "'->'", "';'", "'['", "']'", "'add'", "'after'", "'with'"
    };

    public static final int EOF=-1;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int ADDFILT=4;
    public static final int AND=5;
    public static final int ARGLIST=6;
    public static final int ARRAY=7;
    public static final int ASIGEQUAL=8;
    public static final int ASSIGN=9;
    public static final int BOOLEAN=10;
    public static final int BYPASSF=11;
    public static final int CBL=12;
    public static final int CBR=13;
    public static final int CHAR=14;
    public static final int COMMENT=15;
    public static final int DECLARE=16;
    public static final int DIV=17;
    public static final int ELSE=18;
    public static final int EMPTYFILT=19;
    public static final int EQUAL=20;
    public static final int ESC_SEQ=21;
    public static final int FALSE=22;
    public static final int FILTCALL=23;
    public static final int FILTER=24;
    public static final int FIRST=25;
    public static final int FLOAT=26;
    public static final int FROM=27;
    public static final int FUNCALL=28;
    public static final int FUNCTION=29;
    public static final int GE=30;
    public static final int GT=31;
    public static final int ID=32;
    public static final int IF=33;
    public static final int INPUTS=34;
    public static final int INT=35;
    public static final int LAST=36;
    public static final int LE=37;
    public static final int LIST_FILTERS=38;
    public static final int LIST_FUNCTIONS=39;
    public static final int LIST_INSTR=40;
    public static final int LOOP=41;
    public static final int LT=42;
    public static final int MEMBER=43;
    public static final int MINUS=44;
    public static final int MOD=45;
    public static final int MUL=46;
    public static final int NOT=47;
    public static final int NOT_EQUAL=48;
    public static final int OPERATOR=49;
    public static final int OR=50;
    public static final int PARAM=51;
    public static final int PARAMS=52;
    public static final int PLUS=53;
    public static final int QUIT=54;
    public static final int RETURN=55;
    public static final int ROOT=56;
    public static final int STRING=57;
    public static final int TIMECALL=58;
    public static final int TRUE=59;
    public static final int UNTIL=60;
    public static final int WHILE=61;
    public static final int WS=62;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public StageParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public StageParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return StageParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/marc/IdeaProjects/Stage/src/parser/Stage.g"; }


    public static class prog_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prog"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:43:1: prog : procedures -> ^( ROOT ( procedures )+ ) ;
    public final StageParser.prog_return prog() throws RecognitionException {
        StageParser.prog_return retval = new StageParser.prog_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        StageParser.procedures_return procedures1 =null;


        RewriteRuleSubtreeStream stream_procedures=new RewriteRuleSubtreeStream(adaptor,"rule procedures");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:43:9: ( procedures -> ^( ROOT ( procedures )+ ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:43:11: procedures
            {
            pushFollow(FOLLOW_procedures_in_prog222);
            procedures1=procedures();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_procedures.add(procedures1.getTree());

            // AST REWRITE
            // elements: procedures
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 43:22: -> ^( ROOT ( procedures )+ )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:43:25: ^( ROOT ( procedures )+ )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(ROOT, "ROOT")
                , root_1);

                if ( !(stream_procedures.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_procedures.hasNext() ) {
                    adaptor.addChild(root_1, stream_procedures.nextTree());

                }
                stream_procedures.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prog"


    public static class procedures_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "procedures"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:1: procedures : ( func | filter )+ EOF -> ^( LIST_FUNCTIONS ( func )* ) ^( LIST_FILTERS ( filter )* ) ;
    public final StageParser.procedures_return procedures() throws RecognitionException {
        StageParser.procedures_return retval = new StageParser.procedures_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token EOF4=null;
        StageParser.func_return func2 =null;

        StageParser.filter_return filter3 =null;


        StageTree EOF4_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_func=new RewriteRuleSubtreeStream(adaptor,"rule func");
        RewriteRuleSubtreeStream stream_filter=new RewriteRuleSubtreeStream(adaptor,"rule filter");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:11: ( ( func | filter )+ EOF -> ^( LIST_FUNCTIONS ( func )* ) ^( LIST_FILTERS ( filter )* ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:13: ( func | filter )+ EOF
            {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:13: ( func | filter )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==FUNCTION) ) {
                    alt1=1;
                }
                else if ( (LA1_0==FILTER) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:14: func
            	    {
            	    pushFollow(FOLLOW_func_in_procedures239);
            	    func2=func();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_func.add(func2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:21: filter
            	    {
            	    pushFollow(FOLLOW_filter_in_procedures243);
            	    filter3=filter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_filter.add(filter3.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_procedures247); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF4);


            // AST REWRITE
            // elements: func, filter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 45:34: -> ^( LIST_FUNCTIONS ( func )* ) ^( LIST_FILTERS ( filter )* )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:37: ^( LIST_FUNCTIONS ( func )* )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(LIST_FUNCTIONS, "LIST_FUNCTIONS")
                , root_1);

                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:54: ( func )*
                while ( stream_func.hasNext() ) {
                    adaptor.addChild(root_1, stream_func.nextTree());

                }
                stream_func.reset();

                adaptor.addChild(root_0, root_1);
                }

                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:61: ^( LIST_FILTERS ( filter )* )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(LIST_FILTERS, "LIST_FILTERS")
                , root_1);

                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:45:76: ( filter )*
                while ( stream_filter.hasNext() ) {
                    adaptor.addChild(root_1, stream_filter.nextTree());

                }
                stream_filter.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "procedures"


    public static class func_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:48:1: func : FUNCTION (ret= ID )? nam= ID params CBL function_block_instructions CBR -> ^( FUNCTION $nam ( $ret)? params function_block_instructions ) ;
    public final StageParser.func_return func() throws RecognitionException {
        StageParser.func_return retval = new StageParser.func_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token ret=null;
        Token nam=null;
        Token FUNCTION5=null;
        Token CBL7=null;
        Token CBR9=null;
        StageParser.params_return params6 =null;

        StageParser.function_block_instructions_return function_block_instructions8 =null;


        StageTree ret_tree=null;
        StageTree nam_tree=null;
        StageTree FUNCTION5_tree=null;
        StageTree CBL7_tree=null;
        StageTree CBR9_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_CBL=new RewriteRuleTokenStream(adaptor,"token CBL");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_CBR=new RewriteRuleTokenStream(adaptor,"token CBR");
        RewriteRuleSubtreeStream stream_function_block_instructions=new RewriteRuleSubtreeStream(adaptor,"rule function_block_instructions");
        RewriteRuleSubtreeStream stream_params=new RewriteRuleSubtreeStream(adaptor,"rule params");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:48:6: ( FUNCTION (ret= ID )? nam= ID params CBL function_block_instructions CBR -> ^( FUNCTION $nam ( $ret)? params function_block_instructions ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:48:8: FUNCTION (ret= ID )? nam= ID params CBL function_block_instructions CBR
            {
            FUNCTION5=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_func272); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNCTION.add(FUNCTION5);


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:48:20: (ret= ID )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==ID) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:48:20: ret= ID
                    {
                    ret=(Token)match(input,ID,FOLLOW_ID_in_func276); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ret);


                    }
                    break;

            }


            nam=(Token)match(input,ID,FOLLOW_ID_in_func281); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(nam);


            pushFollow(FOLLOW_params_in_func283);
            params6=params();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_params.add(params6.getTree());

            CBL7=(Token)match(input,CBL,FOLLOW_CBL_in_func285); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CBL.add(CBL7);


            pushFollow(FOLLOW_function_block_instructions_in_func287);
            function_block_instructions8=function_block_instructions();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_block_instructions.add(function_block_instructions8.getTree());

            CBR9=(Token)match(input,CBR,FOLLOW_CBR_in_func289); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CBR.add(CBR9);


            // AST REWRITE
            // elements: ret, function_block_instructions, params, nam, FUNCTION
            // token labels: ret, nam
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_ret=new RewriteRuleTokenStream(adaptor,"token ret",ret);
            RewriteRuleTokenStream stream_nam=new RewriteRuleTokenStream(adaptor,"token nam",nam);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 48:75: -> ^( FUNCTION $nam ( $ret)? params function_block_instructions )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:48:78: ^( FUNCTION $nam ( $ret)? params function_block_instructions )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                stream_FUNCTION.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_nam.nextNode());

                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:48:95: ( $ret)?
                if ( stream_ret.hasNext() ) {
                    adaptor.addChild(root_1, stream_ret.nextNode());

                }
                stream_ret.reset();

                adaptor.addChild(root_1, stream_params.nextTree());

                adaptor.addChild(root_1, stream_function_block_instructions.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func"


    public static class params_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "params"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:51:1: params : '(' ( paramlist )? ')' -> ^( PARAMS ( paramlist )? ) ;
    public final StageParser.params_return params() throws RecognitionException {
        StageParser.params_return retval = new StageParser.params_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token char_literal10=null;
        Token char_literal12=null;
        StageParser.paramlist_return paramlist11 =null;


        StageTree char_literal10_tree=null;
        StageTree char_literal12_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_paramlist=new RewriteRuleSubtreeStream(adaptor,"rule paramlist");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:51:8: ( '(' ( paramlist )? ')' -> ^( PARAMS ( paramlist )? ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:51:10: '(' ( paramlist )? ')'
            {
            char_literal10=(Token)match(input,63,FOLLOW_63_in_params315); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(char_literal10);


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:51:14: ( paramlist )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:51:14: paramlist
                    {
                    pushFollow(FOLLOW_paramlist_in_params317);
                    paramlist11=paramlist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_paramlist.add(paramlist11.getTree());

                    }
                    break;

            }


            char_literal12=(Token)match(input,64,FOLLOW_64_in_params320); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_64.add(char_literal12);


            // AST REWRITE
            // elements: paramlist
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 51:29: -> ^( PARAMS ( paramlist )? )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:51:32: ^( PARAMS ( paramlist )? )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(PARAMS, "PARAMS")
                , root_1);

                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:51:41: ( paramlist )?
                if ( stream_paramlist.hasNext() ) {
                    adaptor.addChild(root_1, stream_paramlist.nextTree());

                }
                stream_paramlist.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "params"


    public static class paramlist_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "paramlist"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:54:1: paramlist : param ( ',' ! param )* ;
    public final StageParser.paramlist_return paramlist() throws RecognitionException {
        StageParser.paramlist_return retval = new StageParser.paramlist_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token char_literal14=null;
        StageParser.param_return param13 =null;

        StageParser.param_return param15 =null;


        StageTree char_literal14_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:54:10: ( param ( ',' ! param )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:54:12: param ( ',' ! param )*
            {
            root_0 = (StageTree)adaptor.nil();


            pushFollow(FOLLOW_param_in_paramlist337);
            param13=param();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, param13.getTree());

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:54:18: ( ',' ! param )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==65) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:54:19: ',' ! param
            	    {
            	    char_literal14=(Token)match(input,65,FOLLOW_65_in_paramlist340); if (state.failed) return retval;

            	    pushFollow(FOLLOW_param_in_paramlist343);
            	    param15=param();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, param15.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "paramlist"


    public static class param_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "param"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:56:1: param : type= ID id= ID -> ^( PARAM $type $id) ;
    public final StageParser.param_return param() throws RecognitionException {
        StageParser.param_return retval = new StageParser.param_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token type=null;
        Token id=null;

        StageTree type_tree=null;
        StageTree id_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:56:9: (type= ID id= ID -> ^( PARAM $type $id) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:56:11: type= ID id= ID
            {
            type=(Token)match(input,ID,FOLLOW_ID_in_param357); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(type);


            id=(Token)match(input,ID,FOLLOW_ID_in_param361); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(id);


            // AST REWRITE
            // elements: id, type
            // token labels: id, type
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 56:25: -> ^( PARAM $type $id)
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:56:28: ^( PARAM $type $id)
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(PARAM, "PARAM")
                , root_1);

                adaptor.addChild(root_1, stream_type.nextNode());

                adaptor.addChild(root_1, stream_id.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "param"


    public static class function_block_instructions_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "function_block_instructions"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:58:1: function_block_instructions : ( first_instructions )? ( loop_instructions )? ( last_instructions )? ;
    public final StageParser.function_block_instructions_return function_block_instructions() throws RecognitionException {
        StageParser.function_block_instructions_return retval = new StageParser.function_block_instructions_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        StageParser.first_instructions_return first_instructions16 =null;

        StageParser.loop_instructions_return loop_instructions17 =null;

        StageParser.last_instructions_return last_instructions18 =null;



        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:59:2: ( ( first_instructions )? ( loop_instructions )? ( last_instructions )? )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:59:4: ( first_instructions )? ( loop_instructions )? ( last_instructions )?
            {
            root_0 = (StageTree)adaptor.nil();


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:59:4: ( first_instructions )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==FIRST) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:59:4: first_instructions
                    {
                    pushFollow(FOLLOW_first_instructions_in_function_block_instructions383);
                    first_instructions16=first_instructions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, first_instructions16.getTree());

                    }
                    break;

            }


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:60:3: ( loop_instructions )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LOOP) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:60:3: loop_instructions
                    {
                    pushFollow(FOLLOW_loop_instructions_in_function_block_instructions388);
                    loop_instructions17=loop_instructions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, loop_instructions17.getTree());

                    }
                    break;

            }


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:61:3: ( last_instructions )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LAST) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:61:3: last_instructions
                    {
                    pushFollow(FOLLOW_last_instructions_in_function_block_instructions393);
                    last_instructions18=last_instructions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, last_instructions18.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "function_block_instructions"


    public static class first_instructions_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "first_instructions"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:64:1: first_instructions : ( FIRST ^ ( instruction )* ) ;
    public final StageParser.first_instructions_return first_instructions() throws RecognitionException {
        StageParser.first_instructions_return retval = new StageParser.first_instructions_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token FIRST19=null;
        StageParser.instruction_return instruction20 =null;


        StageTree FIRST19_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:64:19: ( ( FIRST ^ ( instruction )* ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:64:21: ( FIRST ^ ( instruction )* )
            {
            root_0 = (StageTree)adaptor.nil();


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:64:21: ( FIRST ^ ( instruction )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:64:22: FIRST ^ ( instruction )*
            {
            FIRST19=(Token)match(input,FIRST,FOLLOW_FIRST_in_first_instructions404); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FIRST19_tree = 
            (StageTree)adaptor.create(FIRST19)
            ;
            root_0 = (StageTree)adaptor.becomeRoot(FIRST19_tree, root_0);
            }

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:64:29: ( instruction )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==BYPASSF||(LA8_0 >= ID && LA8_0 <= IF)||(LA8_0 >= QUIT && LA8_0 <= RETURN)||LA8_0==WHILE||LA8_0==66||LA8_0==70) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:64:30: instruction
            	    {
            	    pushFollow(FOLLOW_instruction_in_first_instructions408);
            	    instruction20=instruction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, instruction20.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "first_instructions"


    public static class loop_instructions_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "loop_instructions"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:65:1: loop_instructions : ( LOOP ^ ( instruction )* ) ;
    public final StageParser.loop_instructions_return loop_instructions() throws RecognitionException {
        StageParser.loop_instructions_return retval = new StageParser.loop_instructions_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token LOOP21=null;
        StageParser.instruction_return instruction22 =null;


        StageTree LOOP21_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:65:18: ( ( LOOP ^ ( instruction )* ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:65:20: ( LOOP ^ ( instruction )* )
            {
            root_0 = (StageTree)adaptor.nil();


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:65:20: ( LOOP ^ ( instruction )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:65:21: LOOP ^ ( instruction )*
            {
            LOOP21=(Token)match(input,LOOP,FOLLOW_LOOP_in_loop_instructions418); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOOP21_tree = 
            (StageTree)adaptor.create(LOOP21)
            ;
            root_0 = (StageTree)adaptor.becomeRoot(LOOP21_tree, root_0);
            }

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:65:27: ( instruction )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==BYPASSF||(LA9_0 >= ID && LA9_0 <= IF)||(LA9_0 >= QUIT && LA9_0 <= RETURN)||LA9_0==WHILE||LA9_0==66||LA9_0==70) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:65:28: instruction
            	    {
            	    pushFollow(FOLLOW_instruction_in_loop_instructions422);
            	    instruction22=instruction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, instruction22.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "loop_instructions"


    public static class last_instructions_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "last_instructions"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:66:1: last_instructions : ( LAST ^ ( instruction )* ) ;
    public final StageParser.last_instructions_return last_instructions() throws RecognitionException {
        StageParser.last_instructions_return retval = new StageParser.last_instructions_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token LAST23=null;
        StageParser.instruction_return instruction24 =null;


        StageTree LAST23_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:66:18: ( ( LAST ^ ( instruction )* ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:66:20: ( LAST ^ ( instruction )* )
            {
            root_0 = (StageTree)adaptor.nil();


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:66:20: ( LAST ^ ( instruction )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:66:21: LAST ^ ( instruction )*
            {
            LAST23=(Token)match(input,LAST,FOLLOW_LAST_in_last_instructions432); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LAST23_tree = 
            (StageTree)adaptor.create(LAST23)
            ;
            root_0 = (StageTree)adaptor.becomeRoot(LAST23_tree, root_0);
            }

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:66:27: ( instruction )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==BYPASSF||(LA10_0 >= ID && LA10_0 <= IF)||(LA10_0 >= QUIT && LA10_0 <= RETURN)||LA10_0==WHILE||LA10_0==66||LA10_0==70) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:66:28: instruction
            	    {
            	    pushFollow(FOLLOW_instruction_in_last_instructions436);
            	    instruction24=instruction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, instruction24.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "last_instructions"


    public static class filter_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:69:1: filter : FILTER ^ input ID params CBL ! block_instructions CBR !;
    public final StageParser.filter_return filter() throws RecognitionException {
        StageParser.filter_return retval = new StageParser.filter_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token FILTER25=null;
        Token ID27=null;
        Token CBL29=null;
        Token CBR31=null;
        StageParser.input_return input26 =null;

        StageParser.params_return params28 =null;

        StageParser.block_instructions_return block_instructions30 =null;


        StageTree FILTER25_tree=null;
        StageTree ID27_tree=null;
        StageTree CBL29_tree=null;
        StageTree CBR31_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:69:7: ( FILTER ^ input ID params CBL ! block_instructions CBR !)
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:69:9: FILTER ^ input ID params CBL ! block_instructions CBR !
            {
            root_0 = (StageTree)adaptor.nil();


            FILTER25=(Token)match(input,FILTER,FOLLOW_FILTER_in_filter447); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER25_tree = 
            (StageTree)adaptor.create(FILTER25)
            ;
            root_0 = (StageTree)adaptor.becomeRoot(FILTER25_tree, root_0);
            }

            pushFollow(FOLLOW_input_in_filter450);
            input26=input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, input26.getTree());

            ID27=(Token)match(input,ID,FOLLOW_ID_in_filter452); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID27_tree = 
            (StageTree)adaptor.create(ID27)
            ;
            adaptor.addChild(root_0, ID27_tree);
            }

            pushFollow(FOLLOW_params_in_filter454);
            params28=params();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, params28.getTree());

            CBL29=(Token)match(input,CBL,FOLLOW_CBL_in_filter456); if (state.failed) return retval;

            pushFollow(FOLLOW_block_instructions_in_filter459);
            block_instructions30=block_instructions();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block_instructions30.getTree());

            CBR31=(Token)match(input,CBR,FOLLOW_CBR_in_filter461); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filter"


    public static class input_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:72:1: input : ( inputlist '->' )? -> ^( INPUTS ( inputlist )? ) ;
    public final StageParser.input_return input() throws RecognitionException {
        StageParser.input_return retval = new StageParser.input_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token string_literal33=null;
        StageParser.inputlist_return inputlist32 =null;


        StageTree string_literal33_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleSubtreeStream stream_inputlist=new RewriteRuleSubtreeStream(adaptor,"rule inputlist");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:72:6: ( ( inputlist '->' )? -> ^( INPUTS ( inputlist )? ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:72:8: ( inputlist '->' )?
            {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:72:8: ( inputlist '->' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ID) ) {
                int LA11_1 = input.LA(2);

                if ( ((LA11_1 >= 65 && LA11_1 <= 66)) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:72:9: inputlist '->'
                    {
                    pushFollow(FOLLOW_inputlist_in_input472);
                    inputlist32=inputlist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inputlist.add(inputlist32.getTree());

                    string_literal33=(Token)match(input,66,FOLLOW_66_in_input474); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_66.add(string_literal33);


                    }
                    break;

            }


            // AST REWRITE
            // elements: inputlist
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 72:26: -> ^( INPUTS ( inputlist )? )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:72:29: ^( INPUTS ( inputlist )? )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(INPUTS, "INPUTS")
                , root_1);

                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:72:38: ( inputlist )?
                if ( stream_inputlist.hasNext() ) {
                    adaptor.addChild(root_1, stream_inputlist.nextTree());

                }
                stream_inputlist.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "input"


    public static class inputlist_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inputlist"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:74:1: inputlist : ID ( ',' ! ID )* ;
    public final StageParser.inputlist_return inputlist() throws RecognitionException {
        StageParser.inputlist_return retval = new StageParser.inputlist_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token ID34=null;
        Token char_literal35=null;
        Token ID36=null;

        StageTree ID34_tree=null;
        StageTree char_literal35_tree=null;
        StageTree ID36_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:74:10: ( ID ( ',' ! ID )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:74:12: ID ( ',' ! ID )*
            {
            root_0 = (StageTree)adaptor.nil();


            ID34=(Token)match(input,ID,FOLLOW_ID_in_inputlist492); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID34_tree = 
            (StageTree)adaptor.create(ID34)
            ;
            adaptor.addChild(root_0, ID34_tree);
            }

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:74:15: ( ',' ! ID )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==65) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:74:16: ',' ! ID
            	    {
            	    char_literal35=(Token)match(input,65,FOLLOW_65_in_inputlist495); if (state.failed) return retval;

            	    ID36=(Token)match(input,ID,FOLLOW_ID_in_inputlist498); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    ID36_tree = 
            	    (StageTree)adaptor.create(ID36)
            	    ;
            	    adaptor.addChild(root_0, ID36_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inputlist"


    public static class block_instructions_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block_instructions"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:77:1: block_instructions : ( instruction )* -> ^( LIST_INSTR ( instruction )* ) ;
    public final StageParser.block_instructions_return block_instructions() throws RecognitionException {
        StageParser.block_instructions_return retval = new StageParser.block_instructions_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        StageParser.instruction_return instruction37 =null;


        RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:78:9: ( ( instruction )* -> ^( LIST_INSTR ( instruction )* ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:78:12: ( instruction )*
            {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:78:12: ( instruction )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==BYPASSF||(LA13_0 >= ID && LA13_0 <= IF)||(LA13_0 >= QUIT && LA13_0 <= RETURN)||LA13_0==WHILE||LA13_0==66||LA13_0==70) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:78:13: instruction
            	    {
            	    pushFollow(FOLLOW_instruction_in_block_instructions519);
            	    instruction37=instruction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_instruction.add(instruction37.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            // AST REWRITE
            // elements: instruction
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 79:13: -> ^( LIST_INSTR ( instruction )* )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:79:16: ^( LIST_INSTR ( instruction )* )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(LIST_INSTR, "LIST_INSTR")
                , root_1);

                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:79:29: ( instruction )*
                while ( stream_instruction.hasNext() ) {
                    adaptor.addChild(root_1, stream_instruction.nextTree());

                }
                stream_instruction.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "block_instructions"


    public static class instruction_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instruction"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:83:1: instruction : ( ( bypassFilter ';' )=> bypassFilter ';' !| ( member ';' )=> member ';' !| ( timeFuncCall ';' )=> timeFuncCall ';' !| ( assign ';' )=> assign ';' !| ( filtercall ';' )=> filtercall ';' !| ( declare ';' )=> declare ';' !| ( addFilter ';' )=> addFilter ';' !| quitInst ';' !| returnexp ';' !| ite_stmt | while_stmt );
    public final StageParser.instruction_return instruction() throws RecognitionException {
        StageParser.instruction_return retval = new StageParser.instruction_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token char_literal39=null;
        Token char_literal41=null;
        Token char_literal43=null;
        Token char_literal45=null;
        Token char_literal47=null;
        Token char_literal49=null;
        Token char_literal51=null;
        Token char_literal53=null;
        Token char_literal55=null;
        StageParser.bypassFilter_return bypassFilter38 =null;

        StageParser.member_return member40 =null;

        StageParser.timeFuncCall_return timeFuncCall42 =null;

        StageParser.assign_return assign44 =null;

        StageParser.filtercall_return filtercall46 =null;

        StageParser.declare_return declare48 =null;

        StageParser.addFilter_return addFilter50 =null;

        StageParser.quitInst_return quitInst52 =null;

        StageParser.returnexp_return returnexp54 =null;

        StageParser.ite_stmt_return ite_stmt56 =null;

        StageParser.while_stmt_return while_stmt57 =null;


        StageTree char_literal39_tree=null;
        StageTree char_literal41_tree=null;
        StageTree char_literal43_tree=null;
        StageTree char_literal45_tree=null;
        StageTree char_literal47_tree=null;
        StageTree char_literal49_tree=null;
        StageTree char_literal51_tree=null;
        StageTree char_literal53_tree=null;
        StageTree char_literal55_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:84:9: ( ( bypassFilter ';' )=> bypassFilter ';' !| ( member ';' )=> member ';' !| ( timeFuncCall ';' )=> timeFuncCall ';' !| ( assign ';' )=> assign ';' !| ( filtercall ';' )=> filtercall ';' !| ( declare ';' )=> declare ';' !| ( addFilter ';' )=> addFilter ';' !| quitInst ';' !| returnexp ';' !| ite_stmt | while_stmt )
            int alt14=11;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==BYPASSF) && (synpred1_Stage())) {
                alt14=1;
            }
            else if ( (LA14_0==ID) ) {
                int LA14_2 = input.LA(2);

                if ( (synpred2_Stage()) ) {
                    alt14=2;
                }
                else if ( (synpred3_Stage()) ) {
                    alt14=3;
                }
                else if ( (synpred4_Stage()) ) {
                    alt14=4;
                }
                else if ( (synpred5_Stage()) ) {
                    alt14=5;
                }
                else if ( (synpred6_Stage()) ) {
                    alt14=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;

                }
            }
            else if ( (LA14_0==66) && (synpred5_Stage())) {
                alt14=5;
            }
            else if ( (LA14_0==70) && (synpred7_Stage())) {
                alt14=7;
            }
            else if ( (LA14_0==QUIT) ) {
                alt14=8;
            }
            else if ( (LA14_0==RETURN) ) {
                alt14=9;
            }
            else if ( (LA14_0==IF) ) {
                alt14=10;
            }
            else if ( (LA14_0==WHILE) ) {
                alt14=11;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:84:13: ( bypassFilter ';' )=> bypassFilter ';' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_bypassFilter_in_instruction576);
                    bypassFilter38=bypassFilter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bypassFilter38.getTree());

                    char_literal39=(Token)match(input,67,FOLLOW_67_in_instruction578); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:85:7: ( member ';' )=> member ';' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_member_in_instruction594);
                    member40=member();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, member40.getTree());

                    char_literal41=(Token)match(input,67,FOLLOW_67_in_instruction596); if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:86:13: ( timeFuncCall ';' )=> timeFuncCall ';' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_timeFuncCall_in_instruction617);
                    timeFuncCall42=timeFuncCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timeFuncCall42.getTree());

                    char_literal43=(Token)match(input,67,FOLLOW_67_in_instruction619); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:87:11: ( assign ';' )=> assign ';' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_assign_in_instruction639);
                    assign44=assign();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assign44.getTree());

                    char_literal45=(Token)match(input,67,FOLLOW_67_in_instruction643); if (state.failed) return retval;

                    }
                    break;
                case 5 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:88:13: ( filtercall ';' )=> filtercall ';' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_filtercall_in_instruction671);
                    filtercall46=filtercall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, filtercall46.getTree());

                    char_literal47=(Token)match(input,67,FOLLOW_67_in_instruction673); if (state.failed) return retval;

                    }
                    break;
                case 6 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:89:11: ( declare ';' )=> declare ';' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_declare_in_instruction692);
                    declare48=declare();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declare48.getTree());

                    char_literal49=(Token)match(input,67,FOLLOW_67_in_instruction694); if (state.failed) return retval;

                    }
                    break;
                case 7 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:90:11: ( addFilter ';' )=> addFilter ';' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_addFilter_in_instruction715);
                    addFilter50=addFilter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addFilter50.getTree());

                    char_literal51=(Token)match(input,67,FOLLOW_67_in_instruction717); if (state.failed) return retval;

                    }
                    break;
                case 8 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:91:11: quitInst ';' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_quitInst_in_instruction730);
                    quitInst52=quitInst();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, quitInst52.getTree());

                    char_literal53=(Token)match(input,67,FOLLOW_67_in_instruction732); if (state.failed) return retval;

                    }
                    break;
                case 9 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:92:11: returnexp ';' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_returnexp_in_instruction745);
                    returnexp54=returnexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnexp54.getTree());

                    char_literal55=(Token)match(input,67,FOLLOW_67_in_instruction747); if (state.failed) return retval;

                    }
                    break;
                case 10 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:93:11: ite_stmt
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_ite_stmt_in_instruction760);
                    ite_stmt56=ite_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ite_stmt56.getTree());

                    }
                    break;
                case 11 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:94:11: while_stmt
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_while_stmt_in_instruction778);
                    while_stmt57=while_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_stmt57.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instruction"


    public static class returnexp_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "returnexp"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:98:1: returnexp : RETURN ^ ( expr )? ;
    public final StageParser.returnexp_return returnexp() throws RecognitionException {
        StageParser.returnexp_return retval = new StageParser.returnexp_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token RETURN58=null;
        StageParser.expr_return expr59 =null;


        StageTree RETURN58_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:99:2: ( RETURN ^ ( expr )? )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:99:4: RETURN ^ ( expr )?
            {
            root_0 = (StageTree)adaptor.nil();


            RETURN58=(Token)match(input,RETURN,FOLLOW_RETURN_in_returnexp802); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RETURN58_tree = 
            (StageTree)adaptor.create(RETURN58)
            ;
            root_0 = (StageTree)adaptor.becomeRoot(RETURN58_tree, root_0);
            }

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:99:12: ( expr )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==CHAR||LA15_0==FALSE||LA15_0==FLOAT||LA15_0==ID||LA15_0==INT||LA15_0==MINUS||LA15_0==NOT||LA15_0==STRING||LA15_0==TRUE||LA15_0==63) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:99:12: expr
                    {
                    pushFollow(FOLLOW_expr_in_returnexp805);
                    expr59=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr59.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "returnexp"


    public static class assign_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assign"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:101:1: assign : member eq= ASIGEQUAL expr -> ^( ASSIGN[$eq,\":=\"] member expr ) ;
    public final StageParser.assign_return assign() throws RecognitionException {
        StageParser.assign_return retval = new StageParser.assign_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token eq=null;
        StageParser.member_return member60 =null;

        StageParser.expr_return expr61 =null;


        StageTree eq_tree=null;
        RewriteRuleTokenStream stream_ASIGEQUAL=new RewriteRuleTokenStream(adaptor,"token ASIGEQUAL");
        RewriteRuleSubtreeStream stream_member=new RewriteRuleSubtreeStream(adaptor,"rule member");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:101:8: ( member eq= ASIGEQUAL expr -> ^( ASSIGN[$eq,\":=\"] member expr ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:101:10: member eq= ASIGEQUAL expr
            {
            pushFollow(FOLLOW_member_in_assign815);
            member60=member();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_member.add(member60.getTree());

            eq=(Token)match(input,ASIGEQUAL,FOLLOW_ASIGEQUAL_in_assign819); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASIGEQUAL.add(eq);


            pushFollow(FOLLOW_expr_in_assign821);
            expr61=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr61.getTree());

            // AST REWRITE
            // elements: member, expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 101:35: -> ^( ASSIGN[$eq,\":=\"] member expr )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:101:38: ^( ASSIGN[$eq,\":=\"] member expr )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(ASSIGN, eq, ":=")
                , root_1);

                adaptor.addChild(root_1, stream_member.nextTree());

                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assign"


    public static class filtercall_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filtercall"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:1: filtercall : ( ( inputlist )? '->' ID '(' ( expr_list )? ')' '->' ID -> ^( FILTCALL ^( INPUTS ( inputlist )? ) ID ^( ARGLIST ( expr_list )? ) ID ) |from= ID '->' to= ID -> ^( EMPTYFILT $from $to) );
    public final StageParser.filtercall_return filtercall() throws RecognitionException {
        StageParser.filtercall_return retval = new StageParser.filtercall_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token from=null;
        Token to=null;
        Token string_literal63=null;
        Token ID64=null;
        Token char_literal65=null;
        Token char_literal67=null;
        Token string_literal68=null;
        Token ID69=null;
        Token string_literal70=null;
        StageParser.inputlist_return inputlist62 =null;

        StageParser.expr_list_return expr_list66 =null;


        StageTree from_tree=null;
        StageTree to_tree=null;
        StageTree string_literal63_tree=null;
        StageTree ID64_tree=null;
        StageTree char_literal65_tree=null;
        StageTree char_literal67_tree=null;
        StageTree string_literal68_tree=null;
        StageTree ID69_tree=null;
        StageTree string_literal70_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_inputlist=new RewriteRuleSubtreeStream(adaptor,"rule inputlist");
        RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:12: ( ( inputlist )? '->' ID '(' ( expr_list )? ')' '->' ID -> ^( FILTCALL ^( INPUTS ( inputlist )? ) ID ^( ARGLIST ( expr_list )? ) ID ) |from= ID '->' to= ID -> ^( EMPTYFILT $from $to) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==66) ) {
                    int LA18_3 = input.LA(3);

                    if ( (LA18_3==ID) ) {
                        int LA18_4 = input.LA(4);

                        if ( (LA18_4==63) ) {
                            alt18=1;
                        }
                        else if ( (LA18_4==64||LA18_4==67) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 4, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 3, input);

                        throw nvae;

                    }
                }
                else if ( (LA18_1==65) ) {
                    alt18=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA18_0==66) ) {
                alt18=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:14: ( inputlist )? '->' ID '(' ( expr_list )? ')' '->' ID
                    {
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:14: ( inputlist )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==ID) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:14: inputlist
                            {
                            pushFollow(FOLLOW_inputlist_in_filtercall840);
                            inputlist62=inputlist();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inputlist.add(inputlist62.getTree());

                            }
                            break;

                    }


                    string_literal63=(Token)match(input,66,FOLLOW_66_in_filtercall843); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_66.add(string_literal63);


                    ID64=(Token)match(input,ID,FOLLOW_ID_in_filtercall845); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID64);


                    char_literal65=(Token)match(input,63,FOLLOW_63_in_filtercall847); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_63.add(char_literal65);


                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:37: ( expr_list )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==CHAR||LA17_0==FALSE||LA17_0==FLOAT||LA17_0==ID||LA17_0==INT||LA17_0==MINUS||LA17_0==NOT||LA17_0==STRING||LA17_0==TRUE||LA17_0==63) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:37: expr_list
                            {
                            pushFollow(FOLLOW_expr_list_in_filtercall849);
                            expr_list66=expr_list();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expr_list.add(expr_list66.getTree());

                            }
                            break;

                    }


                    char_literal67=(Token)match(input,64,FOLLOW_64_in_filtercall852); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_64.add(char_literal67);


                    string_literal68=(Token)match(input,66,FOLLOW_66_in_filtercall854); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_66.add(string_literal68);


                    ID69=(Token)match(input,ID,FOLLOW_ID_in_filtercall856); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID69);


                    // AST REWRITE
                    // elements: expr_list, inputlist, ID, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (StageTree)adaptor.nil();
                    // 103:60: -> ^( FILTCALL ^( INPUTS ( inputlist )? ) ID ^( ARGLIST ( expr_list )? ) ID )
                    {
                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:63: ^( FILTCALL ^( INPUTS ( inputlist )? ) ID ^( ARGLIST ( expr_list )? ) ID )
                        {
                        StageTree root_1 = (StageTree)adaptor.nil();
                        root_1 = (StageTree)adaptor.becomeRoot(
                        (StageTree)adaptor.create(FILTCALL, "FILTCALL")
                        , root_1);

                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:74: ^( INPUTS ( inputlist )? )
                        {
                        StageTree root_2 = (StageTree)adaptor.nil();
                        root_2 = (StageTree)adaptor.becomeRoot(
                        (StageTree)adaptor.create(INPUTS, "INPUTS")
                        , root_2);

                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:83: ( inputlist )?
                        if ( stream_inputlist.hasNext() ) {
                            adaptor.addChild(root_2, stream_inputlist.nextTree());

                        }
                        stream_inputlist.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        );

                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:98: ^( ARGLIST ( expr_list )? )
                        {
                        StageTree root_2 = (StageTree)adaptor.nil();
                        root_2 = (StageTree)adaptor.becomeRoot(
                        (StageTree)adaptor.create(ARGLIST, "ARGLIST")
                        , root_2);

                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:103:108: ( expr_list )?
                        if ( stream_expr_list.hasNext() ) {
                            adaptor.addChild(root_2, stream_expr_list.nextTree());

                        }
                        stream_expr_list.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:104:8: from= ID '->' to= ID
                    {
                    from=(Token)match(input,ID,FOLLOW_ID_in_filtercall891); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(from);


                    string_literal70=(Token)match(input,66,FOLLOW_66_in_filtercall893); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_66.add(string_literal70);


                    to=(Token)match(input,ID,FOLLOW_ID_in_filtercall897); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(to);


                    // AST REWRITE
                    // elements: from, to
                    // token labels: to, from
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_to=new RewriteRuleTokenStream(adaptor,"token to",to);
                    RewriteRuleTokenStream stream_from=new RewriteRuleTokenStream(adaptor,"token from",from);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (StageTree)adaptor.nil();
                    // 104:27: -> ^( EMPTYFILT $from $to)
                    {
                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:104:30: ^( EMPTYFILT $from $to)
                        {
                        StageTree root_1 = (StageTree)adaptor.nil();
                        root_1 = (StageTree)adaptor.becomeRoot(
                        (StageTree)adaptor.create(EMPTYFILT, "EMPTYFILT")
                        , root_1);

                        adaptor.addChild(root_1, stream_from.nextNode());

                        adaptor.addChild(root_1, stream_to.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filtercall"


    public static class addFilter_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "addFilter"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:106:1: addFilter : 'add' '(' filtercall ')' 'after' ID -> ^( ADDFILT ID filtercall ) ;
    public final StageParser.addFilter_return addFilter() throws RecognitionException {
        StageParser.addFilter_return retval = new StageParser.addFilter_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token string_literal71=null;
        Token char_literal72=null;
        Token char_literal74=null;
        Token string_literal75=null;
        Token ID76=null;
        StageParser.filtercall_return filtercall73 =null;


        StageTree string_literal71_tree=null;
        StageTree char_literal72_tree=null;
        StageTree char_literal74_tree=null;
        StageTree string_literal75_tree=null;
        StageTree ID76_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_filtercall=new RewriteRuleSubtreeStream(adaptor,"rule filtercall");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:107:2: ( 'add' '(' filtercall ')' 'after' ID -> ^( ADDFILT ID filtercall ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:107:4: 'add' '(' filtercall ')' 'after' ID
            {
            string_literal71=(Token)match(input,70,FOLLOW_70_in_addFilter919); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal71);


            char_literal72=(Token)match(input,63,FOLLOW_63_in_addFilter921); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(char_literal72);


            pushFollow(FOLLOW_filtercall_in_addFilter923);
            filtercall73=filtercall();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filtercall.add(filtercall73.getTree());

            char_literal74=(Token)match(input,64,FOLLOW_64_in_addFilter925); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_64.add(char_literal74);


            string_literal75=(Token)match(input,71,FOLLOW_71_in_addFilter927); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal75);


            ID76=(Token)match(input,ID,FOLLOW_ID_in_addFilter929); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID76);


            // AST REWRITE
            // elements: ID, filtercall
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 107:40: -> ^( ADDFILT ID filtercall )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:107:43: ^( ADDFILT ID filtercall )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(ADDFILT, "ADDFILT")
                , root_1);

                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );

                adaptor.addChild(root_1, stream_filtercall.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "addFilter"


    public static class bypassFilter_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bypassFilter"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:109:1: bypassFilter : BYPASSF ^ ID 'with' ! ( ID | INT ) ;
    public final StageParser.bypassFilter_return bypassFilter() throws RecognitionException {
        StageParser.bypassFilter_return retval = new StageParser.bypassFilter_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token BYPASSF77=null;
        Token ID78=null;
        Token string_literal79=null;
        Token set80=null;

        StageTree BYPASSF77_tree=null;
        StageTree ID78_tree=null;
        StageTree string_literal79_tree=null;
        StageTree set80_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:110:2: ( BYPASSF ^ ID 'with' ! ( ID | INT ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:110:4: BYPASSF ^ ID 'with' ! ( ID | INT )
            {
            root_0 = (StageTree)adaptor.nil();


            BYPASSF77=(Token)match(input,BYPASSF,FOLLOW_BYPASSF_in_bypassFilter949); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BYPASSF77_tree = 
            (StageTree)adaptor.create(BYPASSF77)
            ;
            root_0 = (StageTree)adaptor.becomeRoot(BYPASSF77_tree, root_0);
            }

            ID78=(Token)match(input,ID,FOLLOW_ID_in_bypassFilter952); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID78_tree = 
            (StageTree)adaptor.create(ID78)
            ;
            adaptor.addChild(root_0, ID78_tree);
            }

            string_literal79=(Token)match(input,72,FOLLOW_72_in_bypassFilter954); if (state.failed) return retval;

            set80=(Token)input.LT(1);

            if ( input.LA(1)==ID||input.LA(1)==INT ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (StageTree)adaptor.create(set80)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bypassFilter"


    public static class quitInst_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "quitInst"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:112:1: quitInst : QUIT ;
    public final StageParser.quitInst_return quitInst() throws RecognitionException {
        StageParser.quitInst_return retval = new StageParser.quitInst_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token QUIT81=null;

        StageTree QUIT81_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:113:2: ( QUIT )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:113:4: QUIT
            {
            root_0 = (StageTree)adaptor.nil();


            QUIT81=(Token)match(input,QUIT,FOLLOW_QUIT_in_quitInst973); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUIT81_tree = 
            (StageTree)adaptor.create(QUIT81)
            ;
            adaptor.addChild(root_0, QUIT81_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "quitInst"


    public static class declare_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "declare"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:115:1: declare : (type= ID name= ID ( ASIGEQUAL expr )? -> ^( DECLARE $type $name ( expr )? ) |type= ID '[' INT ']' name= ID ( ASIGEQUAL expr )? -> ^( DECLARE ^( ARRAY $type INT ) $name ( expr )? ) );
    public final StageParser.declare_return declare() throws RecognitionException {
        StageParser.declare_return retval = new StageParser.declare_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token type=null;
        Token name=null;
        Token ASIGEQUAL82=null;
        Token char_literal84=null;
        Token INT85=null;
        Token char_literal86=null;
        Token ASIGEQUAL87=null;
        StageParser.expr_return expr83 =null;

        StageParser.expr_return expr88 =null;


        StageTree type_tree=null;
        StageTree name_tree=null;
        StageTree ASIGEQUAL82_tree=null;
        StageTree char_literal84_tree=null;
        StageTree INT85_tree=null;
        StageTree char_literal86_tree=null;
        StageTree ASIGEQUAL87_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_ASIGEQUAL=new RewriteRuleTokenStream(adaptor,"token ASIGEQUAL");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:115:9: (type= ID name= ID ( ASIGEQUAL expr )? -> ^( DECLARE $type $name ( expr )? ) |type= ID '[' INT ']' name= ID ( ASIGEQUAL expr )? -> ^( DECLARE ^( ARRAY $type INT ) $name ( expr )? ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==ID) ) {
                    alt21=1;
                }
                else if ( (LA21_1==68) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:115:11: type= ID name= ID ( ASIGEQUAL expr )?
                    {
                    type=(Token)match(input,ID,FOLLOW_ID_in_declare983); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(type);


                    name=(Token)match(input,ID,FOLLOW_ID_in_declare987); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(name);


                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:115:27: ( ASIGEQUAL expr )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==ASIGEQUAL) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:115:28: ASIGEQUAL expr
                            {
                            ASIGEQUAL82=(Token)match(input,ASIGEQUAL,FOLLOW_ASIGEQUAL_in_declare990); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ASIGEQUAL.add(ASIGEQUAL82);


                            pushFollow(FOLLOW_expr_in_declare992);
                            expr83=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expr.add(expr83.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: type, expr, name
                    // token labels: name, type
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
                    RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (StageTree)adaptor.nil();
                    // 115:45: -> ^( DECLARE $type $name ( expr )? )
                    {
                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:115:48: ^( DECLARE $type $name ( expr )? )
                        {
                        StageTree root_1 = (StageTree)adaptor.nil();
                        root_1 = (StageTree)adaptor.becomeRoot(
                        (StageTree)adaptor.create(DECLARE, "DECLARE")
                        , root_1);

                        adaptor.addChild(root_1, stream_type.nextNode());

                        adaptor.addChild(root_1, stream_name.nextNode());

                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:115:70: ( expr )?
                        if ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:116:5: type= ID '[' INT ']' name= ID ( ASIGEQUAL expr )?
                    {
                    type=(Token)match(input,ID,FOLLOW_ID_in_declare1017); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(type);


                    char_literal84=(Token)match(input,68,FOLLOW_68_in_declare1019); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_68.add(char_literal84);


                    INT85=(Token)match(input,INT,FOLLOW_INT_in_declare1021); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT85);


                    char_literal86=(Token)match(input,69,FOLLOW_69_in_declare1023); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_69.add(char_literal86);


                    name=(Token)match(input,ID,FOLLOW_ID_in_declare1027); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(name);


                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:116:33: ( ASIGEQUAL expr )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==ASIGEQUAL) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:116:34: ASIGEQUAL expr
                            {
                            ASIGEQUAL87=(Token)match(input,ASIGEQUAL,FOLLOW_ASIGEQUAL_in_declare1030); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ASIGEQUAL.add(ASIGEQUAL87);


                            pushFollow(FOLLOW_expr_in_declare1032);
                            expr88=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expr.add(expr88.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: expr, name, type, INT
                    // token labels: name, type
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
                    RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (StageTree)adaptor.nil();
                    // 116:51: -> ^( DECLARE ^( ARRAY $type INT ) $name ( expr )? )
                    {
                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:116:54: ^( DECLARE ^( ARRAY $type INT ) $name ( expr )? )
                        {
                        StageTree root_1 = (StageTree)adaptor.nil();
                        root_1 = (StageTree)adaptor.becomeRoot(
                        (StageTree)adaptor.create(DECLARE, "DECLARE")
                        , root_1);

                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:116:64: ^( ARRAY $type INT )
                        {
                        StageTree root_2 = (StageTree)adaptor.nil();
                        root_2 = (StageTree)adaptor.becomeRoot(
                        (StageTree)adaptor.create(ARRAY, "ARRAY")
                        , root_2);

                        adaptor.addChild(root_2, stream_type.nextNode());

                        adaptor.addChild(root_2, 
                        stream_INT.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, stream_name.nextNode());

                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:116:89: ( expr )?
                        if ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declare"


    public static class ite_stmt_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ite_stmt"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:119:1: ite_stmt : IF ^ '(' ! expr ')' ! CBL ! block_instructions CBR ! ( ELSE ! CBL ! block_instructions CBR !)? ;
    public final StageParser.ite_stmt_return ite_stmt() throws RecognitionException {
        StageParser.ite_stmt_return retval = new StageParser.ite_stmt_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token IF89=null;
        Token char_literal90=null;
        Token char_literal92=null;
        Token CBL93=null;
        Token CBR95=null;
        Token ELSE96=null;
        Token CBL97=null;
        Token CBR99=null;
        StageParser.expr_return expr91 =null;

        StageParser.block_instructions_return block_instructions94 =null;

        StageParser.block_instructions_return block_instructions98 =null;


        StageTree IF89_tree=null;
        StageTree char_literal90_tree=null;
        StageTree char_literal92_tree=null;
        StageTree CBL93_tree=null;
        StageTree CBR95_tree=null;
        StageTree ELSE96_tree=null;
        StageTree CBL97_tree=null;
        StageTree CBR99_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:119:10: ( IF ^ '(' ! expr ')' ! CBL ! block_instructions CBR ! ( ELSE ! CBL ! block_instructions CBR !)? )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:119:12: IF ^ '(' ! expr ')' ! CBL ! block_instructions CBR ! ( ELSE ! CBL ! block_instructions CBR !)?
            {
            root_0 = (StageTree)adaptor.nil();


            IF89=(Token)match(input,IF,FOLLOW_IF_in_ite_stmt1065); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IF89_tree = 
            (StageTree)adaptor.create(IF89)
            ;
            root_0 = (StageTree)adaptor.becomeRoot(IF89_tree, root_0);
            }

            char_literal90=(Token)match(input,63,FOLLOW_63_in_ite_stmt1068); if (state.failed) return retval;

            pushFollow(FOLLOW_expr_in_ite_stmt1071);
            expr91=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr91.getTree());

            char_literal92=(Token)match(input,64,FOLLOW_64_in_ite_stmt1073); if (state.failed) return retval;

            CBL93=(Token)match(input,CBL,FOLLOW_CBL_in_ite_stmt1076); if (state.failed) return retval;

            pushFollow(FOLLOW_block_instructions_in_ite_stmt1079);
            block_instructions94=block_instructions();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block_instructions94.getTree());

            CBR95=(Token)match(input,CBR,FOLLOW_CBR_in_ite_stmt1081); if (state.failed) return retval;

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:119:60: ( ELSE ! CBL ! block_instructions CBR !)?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ELSE) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:119:61: ELSE ! CBL ! block_instructions CBR !
                    {
                    ELSE96=(Token)match(input,ELSE,FOLLOW_ELSE_in_ite_stmt1085); if (state.failed) return retval;

                    CBL97=(Token)match(input,CBL,FOLLOW_CBL_in_ite_stmt1088); if (state.failed) return retval;

                    pushFollow(FOLLOW_block_instructions_in_ite_stmt1091);
                    block_instructions98=block_instructions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block_instructions98.getTree());

                    CBR99=(Token)match(input,CBR,FOLLOW_CBR_in_ite_stmt1093); if (state.failed) return retval;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ite_stmt"


    public static class while_stmt_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "while_stmt"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:123:1: while_stmt : WHILE ^ '(' ! expr ')' ! CBL ! block_instructions CBR !;
    public final StageParser.while_stmt_return while_stmt() throws RecognitionException {
        StageParser.while_stmt_return retval = new StageParser.while_stmt_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token WHILE100=null;
        Token char_literal101=null;
        Token char_literal103=null;
        Token CBL104=null;
        Token CBR106=null;
        StageParser.expr_return expr102 =null;

        StageParser.block_instructions_return block_instructions105 =null;


        StageTree WHILE100_tree=null;
        StageTree char_literal101_tree=null;
        StageTree char_literal103_tree=null;
        StageTree CBL104_tree=null;
        StageTree CBR106_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:123:12: ( WHILE ^ '(' ! expr ')' ! CBL ! block_instructions CBR !)
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:123:14: WHILE ^ '(' ! expr ')' ! CBL ! block_instructions CBR !
            {
            root_0 = (StageTree)adaptor.nil();


            WHILE100=(Token)match(input,WHILE,FOLLOW_WHILE_in_while_stmt1118); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHILE100_tree = 
            (StageTree)adaptor.create(WHILE100)
            ;
            root_0 = (StageTree)adaptor.becomeRoot(WHILE100_tree, root_0);
            }

            char_literal101=(Token)match(input,63,FOLLOW_63_in_while_stmt1121); if (state.failed) return retval;

            pushFollow(FOLLOW_expr_in_while_stmt1124);
            expr102=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr102.getTree());

            char_literal103=(Token)match(input,64,FOLLOW_64_in_while_stmt1126); if (state.failed) return retval;

            CBL104=(Token)match(input,CBL,FOLLOW_CBL_in_while_stmt1129); if (state.failed) return retval;

            pushFollow(FOLLOW_block_instructions_in_while_stmt1132);
            block_instructions105=block_instructions();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block_instructions105.getTree());

            CBR106=(Token)match(input,CBR,FOLLOW_CBR_in_while_stmt1134); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "while_stmt"


    public static class expr_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:127:1: expr : boolterm ( OR ^ boolterm )* ;
    public final StageParser.expr_return expr() throws RecognitionException {
        StageParser.expr_return retval = new StageParser.expr_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token OR108=null;
        StageParser.boolterm_return boolterm107 =null;

        StageParser.boolterm_return boolterm109 =null;


        StageTree OR108_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:127:9: ( boolterm ( OR ^ boolterm )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:127:13: boolterm ( OR ^ boolterm )*
            {
            root_0 = (StageTree)adaptor.nil();


            pushFollow(FOLLOW_boolterm_in_expr1162);
            boolterm107=boolterm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, boolterm107.getTree());

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:127:22: ( OR ^ boolterm )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==OR) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:127:23: OR ^ boolterm
            	    {
            	    OR108=(Token)match(input,OR,FOLLOW_OR_in_expr1165); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR108_tree = 
            	    (StageTree)adaptor.create(OR108)
            	    ;
            	    root_0 = (StageTree)adaptor.becomeRoot(OR108_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_boolterm_in_expr1168);
            	    boolterm109=boolterm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, boolterm109.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class boolterm_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "boolterm"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:130:1: boolterm : boolfact ( AND ^ boolfact )* ;
    public final StageParser.boolterm_return boolterm() throws RecognitionException {
        StageParser.boolterm_return retval = new StageParser.boolterm_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token AND111=null;
        StageParser.boolfact_return boolfact110 =null;

        StageParser.boolfact_return boolfact112 =null;


        StageTree AND111_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:130:9: ( boolfact ( AND ^ boolfact )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:130:13: boolfact ( AND ^ boolfact )*
            {
            root_0 = (StageTree)adaptor.nil();


            pushFollow(FOLLOW_boolfact_in_boolterm1188);
            boolfact110=boolfact();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, boolfact110.getTree());

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:130:22: ( AND ^ boolfact )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==AND) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:130:23: AND ^ boolfact
            	    {
            	    AND111=(Token)match(input,AND,FOLLOW_AND_in_boolterm1191); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND111_tree = 
            	    (StageTree)adaptor.create(AND111)
            	    ;
            	    root_0 = (StageTree)adaptor.becomeRoot(AND111_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_boolfact_in_boolterm1194);
            	    boolfact112=boolfact();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, boolfact112.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "boolterm"


    public static class boolfact_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "boolfact"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:1: boolfact : num_expr ( ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GT ^| GE ^) num_expr )? ;
    public final StageParser.boolfact_return boolfact() throws RecognitionException {
        StageParser.boolfact_return retval = new StageParser.boolfact_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token EQUAL114=null;
        Token NOT_EQUAL115=null;
        Token LT116=null;
        Token LE117=null;
        Token GT118=null;
        Token GE119=null;
        StageParser.num_expr_return num_expr113 =null;

        StageParser.num_expr_return num_expr120 =null;


        StageTree EQUAL114_tree=null;
        StageTree NOT_EQUAL115_tree=null;
        StageTree LT116_tree=null;
        StageTree LE117_tree=null;
        StageTree GT118_tree=null;
        StageTree GE119_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:9: ( num_expr ( ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GT ^| GE ^) num_expr )? )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:13: num_expr ( ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GT ^| GE ^) num_expr )?
            {
            root_0 = (StageTree)adaptor.nil();


            pushFollow(FOLLOW_num_expr_in_boolfact1214);
            num_expr113=num_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, num_expr113.getTree());

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:22: ( ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GT ^| GE ^) num_expr )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==EQUAL||(LA26_0 >= GE && LA26_0 <= GT)||LA26_0==LE||LA26_0==LT||LA26_0==NOT_EQUAL) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:23: ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GT ^| GE ^) num_expr
                    {
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:23: ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GT ^| GE ^)
                    int alt25=6;
                    switch ( input.LA(1) ) {
                    case EQUAL:
                        {
                        alt25=1;
                        }
                        break;
                    case NOT_EQUAL:
                        {
                        alt25=2;
                        }
                        break;
                    case LT:
                        {
                        alt25=3;
                        }
                        break;
                    case LE:
                        {
                        alt25=4;
                        }
                        break;
                    case GT:
                        {
                        alt25=5;
                        }
                        break;
                    case GE:
                        {
                        alt25=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;

                    }

                    switch (alt25) {
                        case 1 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:24: EQUAL ^
                            {
                            EQUAL114=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_boolfact1218); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            EQUAL114_tree = 
                            (StageTree)adaptor.create(EQUAL114)
                            ;
                            root_0 = (StageTree)adaptor.becomeRoot(EQUAL114_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:33: NOT_EQUAL ^
                            {
                            NOT_EQUAL115=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_boolfact1223); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT_EQUAL115_tree = 
                            (StageTree)adaptor.create(NOT_EQUAL115)
                            ;
                            root_0 = (StageTree)adaptor.becomeRoot(NOT_EQUAL115_tree, root_0);
                            }

                            }
                            break;
                        case 3 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:46: LT ^
                            {
                            LT116=(Token)match(input,LT,FOLLOW_LT_in_boolfact1228); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LT116_tree = 
                            (StageTree)adaptor.create(LT116)
                            ;
                            root_0 = (StageTree)adaptor.becomeRoot(LT116_tree, root_0);
                            }

                            }
                            break;
                        case 4 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:52: LE ^
                            {
                            LE117=(Token)match(input,LE,FOLLOW_LE_in_boolfact1233); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LE117_tree = 
                            (StageTree)adaptor.create(LE117)
                            ;
                            root_0 = (StageTree)adaptor.becomeRoot(LE117_tree, root_0);
                            }

                            }
                            break;
                        case 5 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:58: GT ^
                            {
                            GT118=(Token)match(input,GT,FOLLOW_GT_in_boolfact1238); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            GT118_tree = 
                            (StageTree)adaptor.create(GT118)
                            ;
                            root_0 = (StageTree)adaptor.becomeRoot(GT118_tree, root_0);
                            }

                            }
                            break;
                        case 6 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:133:64: GE ^
                            {
                            GE119=(Token)match(input,GE,FOLLOW_GE_in_boolfact1243); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            GE119_tree = 
                            (StageTree)adaptor.create(GE119)
                            ;
                            root_0 = (StageTree)adaptor.becomeRoot(GE119_tree, root_0);
                            }

                            }
                            break;

                    }


                    pushFollow(FOLLOW_num_expr_in_boolfact1247);
                    num_expr120=num_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, num_expr120.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "boolfact"


    public static class num_expr_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_expr"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:136:1: num_expr : term ( ( PLUS ^| MINUS ^) term )* ;
    public final StageParser.num_expr_return num_expr() throws RecognitionException {
        StageParser.num_expr_return retval = new StageParser.num_expr_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token PLUS122=null;
        Token MINUS123=null;
        StageParser.term_return term121 =null;

        StageParser.term_return term124 =null;


        StageTree PLUS122_tree=null;
        StageTree MINUS123_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:136:9: ( term ( ( PLUS ^| MINUS ^) term )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:136:13: term ( ( PLUS ^| MINUS ^) term )*
            {
            root_0 = (StageTree)adaptor.nil();


            pushFollow(FOLLOW_term_in_num_expr1267);
            term121=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term121.getTree());

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:136:18: ( ( PLUS ^| MINUS ^) term )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==MINUS||LA28_0==PLUS) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:136:20: ( PLUS ^| MINUS ^) term
            	    {
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:136:20: ( PLUS ^| MINUS ^)
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==PLUS) ) {
            	        alt27=1;
            	    }
            	    else if ( (LA27_0==MINUS) ) {
            	        alt27=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:136:21: PLUS ^
            	            {
            	            PLUS122=(Token)match(input,PLUS,FOLLOW_PLUS_in_num_expr1272); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS122_tree = 
            	            (StageTree)adaptor.create(PLUS122)
            	            ;
            	            root_0 = (StageTree)adaptor.becomeRoot(PLUS122_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:136:29: MINUS ^
            	            {
            	            MINUS123=(Token)match(input,MINUS,FOLLOW_MINUS_in_num_expr1277); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS123_tree = 
            	            (StageTree)adaptor.create(MINUS123)
            	            ;
            	            root_0 = (StageTree)adaptor.becomeRoot(MINUS123_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_term_in_num_expr1281);
            	    term124=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term124.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "num_expr"


    public static class term_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:139:1: term : factor ( ( MUL ^| DIV ^| MOD ^) factor )* ;
    public final StageParser.term_return term() throws RecognitionException {
        StageParser.term_return retval = new StageParser.term_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token MUL126=null;
        Token DIV127=null;
        Token MOD128=null;
        StageParser.factor_return factor125 =null;

        StageParser.factor_return factor129 =null;


        StageTree MUL126_tree=null;
        StageTree DIV127_tree=null;
        StageTree MOD128_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:139:9: ( factor ( ( MUL ^| DIV ^| MOD ^) factor )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:139:13: factor ( ( MUL ^| DIV ^| MOD ^) factor )*
            {
            root_0 = (StageTree)adaptor.nil();


            pushFollow(FOLLOW_factor_in_term1305);
            factor125=factor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor125.getTree());

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:139:20: ( ( MUL ^| DIV ^| MOD ^) factor )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==DIV||(LA30_0 >= MOD && LA30_0 <= MUL)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:139:22: ( MUL ^| DIV ^| MOD ^) factor
            	    {
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:139:22: ( MUL ^| DIV ^| MOD ^)
            	    int alt29=3;
            	    switch ( input.LA(1) ) {
            	    case MUL:
            	        {
            	        alt29=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt29=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt29=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt29) {
            	        case 1 :
            	            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:139:23: MUL ^
            	            {
            	            MUL126=(Token)match(input,MUL,FOLLOW_MUL_in_term1310); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MUL126_tree = 
            	            (StageTree)adaptor.create(MUL126)
            	            ;
            	            root_0 = (StageTree)adaptor.becomeRoot(MUL126_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:139:30: DIV ^
            	            {
            	            DIV127=(Token)match(input,DIV,FOLLOW_DIV_in_term1315); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DIV127_tree = 
            	            (StageTree)adaptor.create(DIV127)
            	            ;
            	            root_0 = (StageTree)adaptor.becomeRoot(DIV127_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:139:37: MOD ^
            	            {
            	            MOD128=(Token)match(input,MOD,FOLLOW_MOD_in_term1320); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MOD128_tree = 
            	            (StageTree)adaptor.create(MOD128)
            	            ;
            	            root_0 = (StageTree)adaptor.becomeRoot(MOD128_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_factor_in_term1324);
            	    factor129=factor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, factor129.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "term"


    public static class factor_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "factor"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:142:1: factor : ( NOT ^| MINUS ^)? atom ;
    public final StageParser.factor_return factor() throws RecognitionException {
        StageParser.factor_return retval = new StageParser.factor_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token NOT130=null;
        Token MINUS131=null;
        StageParser.atom_return atom132 =null;


        StageTree NOT130_tree=null;
        StageTree MINUS131_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:142:9: ( ( NOT ^| MINUS ^)? atom )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:142:13: ( NOT ^| MINUS ^)? atom
            {
            root_0 = (StageTree)adaptor.nil();


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:142:13: ( NOT ^| MINUS ^)?
            int alt31=3;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==NOT) ) {
                alt31=1;
            }
            else if ( (LA31_0==MINUS) ) {
                alt31=2;
            }
            switch (alt31) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:142:14: NOT ^
                    {
                    NOT130=(Token)match(input,NOT,FOLLOW_NOT_in_factor1347); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT130_tree = 
                    (StageTree)adaptor.create(NOT130)
                    ;
                    root_0 = (StageTree)adaptor.becomeRoot(NOT130_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:142:21: MINUS ^
                    {
                    MINUS131=(Token)match(input,MINUS,FOLLOW_MINUS_in_factor1352); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS131_tree = 
                    (StageTree)adaptor.create(MINUS131)
                    ;
                    root_0 = (StageTree)adaptor.becomeRoot(MINUS131_tree, root_0);
                    }

                    }
                    break;

            }


            pushFollow(FOLLOW_atom_in_factor1357);
            atom132=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom132.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "factor"


    public static class atom_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:148:1: atom : ( ( member )=> member | INT | FLOAT | CHAR | STRING | (b= TRUE |b= FALSE ) -> ^( BOOLEAN[$b,$b.text] ) | '(' ! expr ')' !);
    public final StageParser.atom_return atom() throws RecognitionException {
        StageParser.atom_return retval = new StageParser.atom_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token b=null;
        Token INT134=null;
        Token FLOAT135=null;
        Token CHAR136=null;
        Token STRING137=null;
        Token char_literal138=null;
        Token char_literal140=null;
        StageParser.member_return member133 =null;

        StageParser.expr_return expr139 =null;


        StageTree b_tree=null;
        StageTree INT134_tree=null;
        StageTree FLOAT135_tree=null;
        StageTree CHAR136_tree=null;
        StageTree STRING137_tree=null;
        StageTree char_literal138_tree=null;
        StageTree char_literal140_tree=null;
        RewriteRuleTokenStream stream_FALSE=new RewriteRuleTokenStream(adaptor,"token FALSE");
        RewriteRuleTokenStream stream_TRUE=new RewriteRuleTokenStream(adaptor,"token TRUE");

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:148:9: ( ( member )=> member | INT | FLOAT | CHAR | STRING | (b= TRUE |b= FALSE ) -> ^( BOOLEAN[$b,$b.text] ) | '(' ! expr ')' !)
            int alt33=7;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==ID) && (synpred8_Stage())) {
                alt33=1;
            }
            else if ( (LA33_0==INT) ) {
                alt33=2;
            }
            else if ( (LA33_0==FLOAT) ) {
                alt33=3;
            }
            else if ( (LA33_0==CHAR) ) {
                alt33=4;
            }
            else if ( (LA33_0==STRING) ) {
                alt33=5;
            }
            else if ( (LA33_0==FALSE||LA33_0==TRUE) ) {
                alt33=6;
            }
            else if ( (LA33_0==63) ) {
                alt33=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:151:4: ( member )=> member
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_member_in_atom1394);
                    member133=member();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, member133.getTree());

                    }
                    break;
                case 2 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:152:13: INT
                    {
                    root_0 = (StageTree)adaptor.nil();


                    INT134=(Token)match(input,INT,FOLLOW_INT_in_atom1408); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT134_tree = 
                    (StageTree)adaptor.create(INT134)
                    ;
                    adaptor.addChild(root_0, INT134_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:153:11: FLOAT
                    {
                    root_0 = (StageTree)adaptor.nil();


                    FLOAT135=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_atom1420); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT135_tree = 
                    (StageTree)adaptor.create(FLOAT135)
                    ;
                    adaptor.addChild(root_0, FLOAT135_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:154:11: CHAR
                    {
                    root_0 = (StageTree)adaptor.nil();


                    CHAR136=(Token)match(input,CHAR,FOLLOW_CHAR_in_atom1432); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHAR136_tree = 
                    (StageTree)adaptor.create(CHAR136)
                    ;
                    adaptor.addChild(root_0, CHAR136_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:155:11: STRING
                    {
                    root_0 = (StageTree)adaptor.nil();


                    STRING137=(Token)match(input,STRING,FOLLOW_STRING_in_atom1444); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING137_tree = 
                    (StageTree)adaptor.create(STRING137)
                    ;
                    adaptor.addChild(root_0, STRING137_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:156:13: (b= TRUE |b= FALSE )
                    {
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:156:13: (b= TRUE |b= FALSE )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==TRUE) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==FALSE) ) {
                        alt32=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;

                    }
                    switch (alt32) {
                        case 1 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:156:14: b= TRUE
                            {
                            b=(Token)match(input,TRUE,FOLLOW_TRUE_in_atom1461); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TRUE.add(b);


                            }
                            break;
                        case 2 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:156:23: b= FALSE
                            {
                            b=(Token)match(input,FALSE,FOLLOW_FALSE_in_atom1467); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_FALSE.add(b);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (StageTree)adaptor.nil();
                    // 156:33: -> ^( BOOLEAN[$b,$b.text] )
                    {
                        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:156:36: ^( BOOLEAN[$b,$b.text] )
                        {
                        StageTree root_1 = (StageTree)adaptor.nil();
                        root_1 = (StageTree)adaptor.becomeRoot(
                        (StageTree)adaptor.create(BOOLEAN, b, (b!=null?b.getText():null))
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 7 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:157:13: '(' ! expr ')' !
                    {
                    root_0 = (StageTree)adaptor.nil();


                    char_literal138=(Token)match(input,63,FOLLOW_63_in_atom1490); if (state.failed) return retval;

                    pushFollow(FOLLOW_expr_in_atom1493);
                    expr139=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr139.getTree());

                    char_literal140=(Token)match(input,64,FOLLOW_64_in_atom1495); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atom"


    public static class member_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "member"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:160:1: member : var ( MEMBER ^ var )* ;
    public final StageParser.member_return member() throws RecognitionException {
        StageParser.member_return retval = new StageParser.member_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token MEMBER142=null;
        StageParser.var_return var141 =null;

        StageParser.var_return var143 =null;


        StageTree MEMBER142_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:160:8: ( var ( MEMBER ^ var )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:160:10: var ( MEMBER ^ var )*
            {
            root_0 = (StageTree)adaptor.nil();


            pushFollow(FOLLOW_var_in_member1521);
            var141=var();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, var141.getTree());

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:160:14: ( MEMBER ^ var )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==MEMBER) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:160:15: MEMBER ^ var
            	    {
            	    MEMBER142=(Token)match(input,MEMBER,FOLLOW_MEMBER_in_member1524); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MEMBER142_tree = 
            	    (StageTree)adaptor.create(MEMBER142)
            	    ;
            	    root_0 = (StageTree)adaptor.becomeRoot(MEMBER142_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_var_in_member1527);
            	    var143=var();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, var143.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "member"


    public static class var_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:162:1: var : ( ( funcVar )=> funcVar | ( arrayVar )=> arrayVar | ID );
    public final StageParser.var_return var() throws RecognitionException {
        StageParser.var_return retval = new StageParser.var_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token ID146=null;
        StageParser.funcVar_return funcVar144 =null;

        StageParser.arrayVar_return arrayVar145 =null;


        StageTree ID146_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:162:6: ( ( funcVar )=> funcVar | ( arrayVar )=> arrayVar | ID )
            int alt35=3;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==ID) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==63) && (synpred9_Stage())) {
                    alt35=1;
                }
                else if ( (LA35_1==68) && (synpred10_Stage())) {
                    alt35=2;
                }
                else if ( (LA35_1==EOF||LA35_1==AND||LA35_1==ASIGEQUAL||LA35_1==DIV||LA35_1==EQUAL||(LA35_1 >= GE && LA35_1 <= GT)||LA35_1==LE||(LA35_1 >= LT && LA35_1 <= MUL)||LA35_1==NOT_EQUAL||LA35_1==OR||LA35_1==PLUS||LA35_1==UNTIL||(LA35_1 >= 64 && LA35_1 <= 65)||LA35_1==67||LA35_1==69) ) {
                    alt35=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:162:8: ( funcVar )=> funcVar
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_funcVar_in_var1544);
                    funcVar144=funcVar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, funcVar144.getTree());

                    }
                    break;
                case 2 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:163:5: ( arrayVar )=> arrayVar
                    {
                    root_0 = (StageTree)adaptor.nil();


                    pushFollow(FOLLOW_arrayVar_in_var1556);
                    arrayVar145=arrayVar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayVar145.getTree());

                    }
                    break;
                case 3 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:164:5: ID
                    {
                    root_0 = (StageTree)adaptor.nil();


                    ID146=(Token)match(input,ID,FOLLOW_ID_in_var1562); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID146_tree = 
                    (StageTree)adaptor.create(ID146)
                    ;
                    adaptor.addChild(root_0, ID146_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var"


    public static class arrayVar_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arrayVar"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:167:1: arrayVar : ID '[' expr ']' -> ^( ARRAY ID expr ) ;
    public final StageParser.arrayVar_return arrayVar() throws RecognitionException {
        StageParser.arrayVar_return retval = new StageParser.arrayVar_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token ID147=null;
        Token char_literal148=null;
        Token char_literal150=null;
        StageParser.expr_return expr149 =null;


        StageTree ID147_tree=null;
        StageTree char_literal148_tree=null;
        StageTree char_literal150_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:168:2: ( ID '[' expr ']' -> ^( ARRAY ID expr ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:168:4: ID '[' expr ']'
            {
            ID147=(Token)match(input,ID,FOLLOW_ID_in_arrayVar1577); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID147);


            char_literal148=(Token)match(input,68,FOLLOW_68_in_arrayVar1579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_68.add(char_literal148);


            pushFollow(FOLLOW_expr_in_arrayVar1581);
            expr149=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr149.getTree());

            char_literal150=(Token)match(input,69,FOLLOW_69_in_arrayVar1583); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(char_literal150);


            // AST REWRITE
            // elements: expr, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 168:20: -> ^( ARRAY ID expr )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:168:23: ^( ARRAY ID expr )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(ARRAY, "ARRAY")
                , root_1);

                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );

                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arrayVar"


    public static class funcVar_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "funcVar"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:169:1: funcVar : ID '(' ( expr_list )? ')' -> ^( FUNCALL ID ^( ARGLIST ( expr_list )? ) ) ;
    public final StageParser.funcVar_return funcVar() throws RecognitionException {
        StageParser.funcVar_return retval = new StageParser.funcVar_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token ID151=null;
        Token char_literal152=null;
        Token char_literal154=null;
        StageParser.expr_list_return expr_list153 =null;


        StageTree ID151_tree=null;
        StageTree char_literal152_tree=null;
        StageTree char_literal154_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:170:2: ( ID '(' ( expr_list )? ')' -> ^( FUNCALL ID ^( ARGLIST ( expr_list )? ) ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:170:4: ID '(' ( expr_list )? ')'
            {
            ID151=(Token)match(input,ID,FOLLOW_ID_in_funcVar1602); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID151);


            char_literal152=(Token)match(input,63,FOLLOW_63_in_funcVar1604); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(char_literal152);


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:170:11: ( expr_list )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==CHAR||LA36_0==FALSE||LA36_0==FLOAT||LA36_0==ID||LA36_0==INT||LA36_0==MINUS||LA36_0==NOT||LA36_0==STRING||LA36_0==TRUE||LA36_0==63) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:170:11: expr_list
                    {
                    pushFollow(FOLLOW_expr_list_in_funcVar1606);
                    expr_list153=expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr_list.add(expr_list153.getTree());

                    }
                    break;

            }


            char_literal154=(Token)match(input,64,FOLLOW_64_in_funcVar1609); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_64.add(char_literal154);


            // AST REWRITE
            // elements: expr_list, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 170:26: -> ^( FUNCALL ID ^( ARGLIST ( expr_list )? ) )
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:170:29: ^( FUNCALL ID ^( ARGLIST ( expr_list )? ) )
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(FUNCALL, "FUNCALL")
                , root_1);

                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );

                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:170:42: ^( ARGLIST ( expr_list )? )
                {
                StageTree root_2 = (StageTree)adaptor.nil();
                root_2 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(ARGLIST, "ARGLIST")
                , root_2);

                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:170:52: ( expr_list )?
                if ( stream_expr_list.hasNext() ) {
                    adaptor.addChild(root_2, stream_expr_list.nextTree());

                }
                stream_expr_list.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "funcVar"


    public static class timeFuncCall_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "timeFuncCall"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:179:1: timeFuncCall : funcVar FROM fexpr= expr UNTIL uexpr= expr -> ^( TIMECALL funcVar $fexpr $uexpr) ;
    public final StageParser.timeFuncCall_return timeFuncCall() throws RecognitionException {
        StageParser.timeFuncCall_return retval = new StageParser.timeFuncCall_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token FROM156=null;
        Token UNTIL157=null;
        StageParser.expr_return fexpr =null;

        StageParser.expr_return uexpr =null;

        StageParser.funcVar_return funcVar155 =null;


        StageTree FROM156_tree=null;
        StageTree UNTIL157_tree=null;
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleTokenStream stream_UNTIL=new RewriteRuleTokenStream(adaptor,"token UNTIL");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_funcVar=new RewriteRuleSubtreeStream(adaptor,"rule funcVar");
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:180:2: ( funcVar FROM fexpr= expr UNTIL uexpr= expr -> ^( TIMECALL funcVar $fexpr $uexpr) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:180:4: funcVar FROM fexpr= expr UNTIL uexpr= expr
            {
            pushFollow(FOLLOW_funcVar_in_timeFuncCall1641);
            funcVar155=funcVar();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_funcVar.add(funcVar155.getTree());

            FROM156=(Token)match(input,FROM,FOLLOW_FROM_in_timeFuncCall1643); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FROM.add(FROM156);


            pushFollow(FOLLOW_expr_in_timeFuncCall1647);
            fexpr=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(fexpr.getTree());

            UNTIL157=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_timeFuncCall1649); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UNTIL.add(UNTIL157);


            pushFollow(FOLLOW_expr_in_timeFuncCall1653);
            uexpr=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(uexpr.getTree());

            // AST REWRITE
            // elements: fexpr, funcVar, uexpr
            // token labels: 
            // rule labels: retval, uexpr, fexpr
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_uexpr=new RewriteRuleSubtreeStream(adaptor,"rule uexpr",uexpr!=null?uexpr.tree:null);
            RewriteRuleSubtreeStream stream_fexpr=new RewriteRuleSubtreeStream(adaptor,"rule fexpr",fexpr!=null?fexpr.tree:null);

            root_0 = (StageTree)adaptor.nil();
            // 180:45: -> ^( TIMECALL funcVar $fexpr $uexpr)
            {
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:180:48: ^( TIMECALL funcVar $fexpr $uexpr)
                {
                StageTree root_1 = (StageTree)adaptor.nil();
                root_1 = (StageTree)adaptor.becomeRoot(
                (StageTree)adaptor.create(TIMECALL, "TIMECALL")
                , root_1);

                adaptor.addChild(root_1, stream_funcVar.nextTree());

                adaptor.addChild(root_1, stream_fexpr.nextTree());

                adaptor.addChild(root_1, stream_uexpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "timeFuncCall"


    public static class expr_list_return extends ParserRuleReturnScope {
        StageTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr_list"
    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:191:1: expr_list : expr ( ',' ! expr )* ;
    public final StageParser.expr_list_return expr_list() throws RecognitionException {
        StageParser.expr_list_return retval = new StageParser.expr_list_return();
        retval.start = input.LT(1);


        StageTree root_0 = null;

        Token char_literal159=null;
        StageParser.expr_return expr158 =null;

        StageParser.expr_return expr160 =null;


        StageTree char_literal159_tree=null;

        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:191:10: ( expr ( ',' ! expr )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:191:13: expr ( ',' ! expr )*
            {
            root_0 = (StageTree)adaptor.nil();


            pushFollow(FOLLOW_expr_in_expr_list1684);
            expr158=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr158.getTree());

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:191:18: ( ',' ! expr )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==65) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:191:19: ',' ! expr
            	    {
            	    char_literal159=(Token)match(input,65,FOLLOW_65_in_expr_list1687); if (state.failed) return retval;

            	    pushFollow(FOLLOW_expr_in_expr_list1690);
            	    expr160=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr160.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (StageTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (StageTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr_list"

    // $ANTLR start synpred1_Stage
    public final void synpred1_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:84:13: ( bypassFilter ';' )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:84:14: bypassFilter ';'
        {
        pushFollow(FOLLOW_bypassFilter_in_synpred1_Stage571);
        bypassFilter();

        state._fsp--;
        if (state.failed) return ;

        match(input,67,FOLLOW_67_in_synpred1_Stage573); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_Stage

    // $ANTLR start synpred2_Stage
    public final void synpred2_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:85:7: ( member ';' )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:85:8: member ';'
        {
        pushFollow(FOLLOW_member_in_synpred2_Stage589);
        member();

        state._fsp--;
        if (state.failed) return ;

        match(input,67,FOLLOW_67_in_synpred2_Stage591); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_Stage

    // $ANTLR start synpred3_Stage
    public final void synpred3_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:86:13: ( timeFuncCall ';' )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:86:14: timeFuncCall ';'
        {
        pushFollow(FOLLOW_timeFuncCall_in_synpred3_Stage612);
        timeFuncCall();

        state._fsp--;
        if (state.failed) return ;

        match(input,67,FOLLOW_67_in_synpred3_Stage614); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_Stage

    // $ANTLR start synpred4_Stage
    public final void synpred4_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:87:11: ( assign ';' )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:87:12: assign ';'
        {
        pushFollow(FOLLOW_assign_in_synpred4_Stage634);
        assign();

        state._fsp--;
        if (state.failed) return ;

        match(input,67,FOLLOW_67_in_synpred4_Stage636); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_Stage

    // $ANTLR start synpred5_Stage
    public final void synpred5_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:88:13: ( filtercall ';' )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:88:14: filtercall ';'
        {
        pushFollow(FOLLOW_filtercall_in_synpred5_Stage666);
        filtercall();

        state._fsp--;
        if (state.failed) return ;

        match(input,67,FOLLOW_67_in_synpred5_Stage668); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_Stage

    // $ANTLR start synpred6_Stage
    public final void synpred6_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:89:11: ( declare ';' )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:89:12: declare ';'
        {
        pushFollow(FOLLOW_declare_in_synpred6_Stage687);
        declare();

        state._fsp--;
        if (state.failed) return ;

        match(input,67,FOLLOW_67_in_synpred6_Stage689); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_Stage

    // $ANTLR start synpred7_Stage
    public final void synpred7_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:90:11: ( addFilter ';' )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:90:12: addFilter ';'
        {
        pushFollow(FOLLOW_addFilter_in_synpred7_Stage708);
        addFilter();

        state._fsp--;
        if (state.failed) return ;

        match(input,67,FOLLOW_67_in_synpred7_Stage710); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_Stage

    // $ANTLR start synpred8_Stage
    public final void synpred8_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:151:4: ( member )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:151:5: member
        {
        pushFollow(FOLLOW_member_in_synpred8_Stage1391);
        member();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred8_Stage

    // $ANTLR start synpred9_Stage
    public final void synpred9_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:162:8: ( funcVar )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:162:9: funcVar
        {
        pushFollow(FOLLOW_funcVar_in_synpred9_Stage1539);
        funcVar();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred9_Stage

    // $ANTLR start synpred10_Stage
    public final void synpred10_Stage_fragment() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:163:5: ( arrayVar )
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:163:6: arrayVar
        {
        pushFollow(FOLLOW_arrayVar_in_synpred10_Stage1551);
        arrayVar();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred10_Stage

    // Delegated rules

    public final boolean synpred5_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_procedures_in_prog222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_in_procedures239 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_filter_in_procedures243 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_EOF_in_procedures247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_func272 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_func276 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_func281 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_params_in_func283 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CBL_in_func285 = new BitSet(new long[]{0x0000021002002000L});
    public static final BitSet FOLLOW_function_block_instructions_in_func287 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CBR_in_func289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_params315 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_paramlist_in_params317 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_params320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_paramlist337 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_paramlist340 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_param_in_paramlist343 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param357 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_param361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_first_instructions_in_function_block_instructions383 = new BitSet(new long[]{0x0000021000000002L});
    public static final BitSet FOLLOW_loop_instructions_in_function_block_instructions388 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_last_instructions_in_function_block_instructions393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FIRST_in_first_instructions404 = new BitSet(new long[]{0x20C0000300000802L,0x0000000000000044L});
    public static final BitSet FOLLOW_instruction_in_first_instructions408 = new BitSet(new long[]{0x20C0000300000802L,0x0000000000000044L});
    public static final BitSet FOLLOW_LOOP_in_loop_instructions418 = new BitSet(new long[]{0x20C0000300000802L,0x0000000000000044L});
    public static final BitSet FOLLOW_instruction_in_loop_instructions422 = new BitSet(new long[]{0x20C0000300000802L,0x0000000000000044L});
    public static final BitSet FOLLOW_LAST_in_last_instructions432 = new BitSet(new long[]{0x20C0000300000802L,0x0000000000000044L});
    public static final BitSet FOLLOW_instruction_in_last_instructions436 = new BitSet(new long[]{0x20C0000300000802L,0x0000000000000044L});
    public static final BitSet FOLLOW_FILTER_in_filter447 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_input_in_filter450 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_filter452 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_params_in_filter454 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CBL_in_filter456 = new BitSet(new long[]{0x20C0000300002800L,0x0000000000000044L});
    public static final BitSet FOLLOW_block_instructions_in_filter459 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CBR_in_filter461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inputlist_in_input472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_input474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_inputlist492 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_inputlist495 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_inputlist498 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_instruction_in_block_instructions519 = new BitSet(new long[]{0x20C0000300000802L,0x0000000000000044L});
    public static final BitSet FOLLOW_bypassFilter_in_instruction576 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_member_in_instruction594 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timeFuncCall_in_instruction617 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_in_instruction639 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filtercall_in_instruction671 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declare_in_instruction692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addFilter_in_instruction715 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quitInst_in_instruction730 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnexp_in_instruction745 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ite_stmt_in_instruction760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_stmt_in_instruction778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_returnexp802 = new BitSet(new long[]{0x8A00900904404002L});
    public static final BitSet FOLLOW_expr_in_returnexp805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_member_in_assign815 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ASIGEQUAL_in_assign819 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_assign821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inputlist_in_filtercall840 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_filtercall843 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_filtercall845 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_filtercall847 = new BitSet(new long[]{0x8A00900904404000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expr_list_in_filtercall849 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_filtercall852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_filtercall854 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_filtercall856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_filtercall891 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_filtercall893 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_filtercall897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_addFilter919 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_addFilter921 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_filtercall_in_addFilter923 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_addFilter925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_addFilter927 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_addFilter929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYPASSF_in_bypassFilter949 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_bypassFilter952 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_bypassFilter954 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_set_in_bypassFilter957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUIT_in_quitInst973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_declare983 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_declare987 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ASIGEQUAL_in_declare990 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_declare992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_declare1017 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_declare1019 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_INT_in_declare1021 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_declare1023 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ID_in_declare1027 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ASIGEQUAL_in_declare1030 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_declare1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ite_stmt1065 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ite_stmt1068 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_ite_stmt1071 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ite_stmt1073 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CBL_in_ite_stmt1076 = new BitSet(new long[]{0x20C0000300002800L,0x0000000000000044L});
    public static final BitSet FOLLOW_block_instructions_in_ite_stmt1079 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CBR_in_ite_stmt1081 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ELSE_in_ite_stmt1085 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CBL_in_ite_stmt1088 = new BitSet(new long[]{0x20C0000300002800L,0x0000000000000044L});
    public static final BitSet FOLLOW_block_instructions_in_ite_stmt1091 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CBR_in_ite_stmt1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_while_stmt1118 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_while_stmt1121 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_while_stmt1124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_while_stmt1126 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CBL_in_while_stmt1129 = new BitSet(new long[]{0x20C0000300002800L,0x0000000000000044L});
    public static final BitSet FOLLOW_block_instructions_in_while_stmt1132 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CBR_in_while_stmt1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolterm_in_expr1162 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_OR_in_expr1165 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_boolterm_in_expr1168 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_boolfact_in_boolterm1188 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AND_in_boolterm1191 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_boolfact_in_boolterm1194 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_num_expr_in_boolfact1214 = new BitSet(new long[]{0x00010420C0100002L});
    public static final BitSet FOLLOW_EQUAL_in_boolfact1218 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_boolfact1223 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_LT_in_boolfact1228 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_LE_in_boolfact1233 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_GT_in_boolfact1238 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_GE_in_boolfact1243 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_num_expr_in_boolfact1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_num_expr1267 = new BitSet(new long[]{0x0020100000000002L});
    public static final BitSet FOLLOW_PLUS_in_num_expr1272 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_MINUS_in_num_expr1277 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_term_in_num_expr1281 = new BitSet(new long[]{0x0020100000000002L});
    public static final BitSet FOLLOW_factor_in_term1305 = new BitSet(new long[]{0x0000600000020002L});
    public static final BitSet FOLLOW_MUL_in_term1310 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_DIV_in_term1315 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_MOD_in_term1320 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_factor_in_term1324 = new BitSet(new long[]{0x0000600000020002L});
    public static final BitSet FOLLOW_NOT_in_factor1347 = new BitSet(new long[]{0x8A00000904404000L});
    public static final BitSet FOLLOW_MINUS_in_factor1352 = new BitSet(new long[]{0x8A00000904404000L});
    public static final BitSet FOLLOW_atom_in_factor1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_member_in_atom1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_atom1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_atom1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_atom1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_atom1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_atom1490 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_atom1493 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_atom1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_member1521 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_MEMBER_in_member1524 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_var_in_member1527 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_funcVar_in_var1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayVar_in_var1556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_var1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayVar1577 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_arrayVar1579 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_arrayVar1581 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_arrayVar1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_funcVar1602 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_funcVar1604 = new BitSet(new long[]{0x8A00900904404000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expr_list_in_funcVar1606 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_funcVar1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcVar_in_timeFuncCall1641 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_FROM_in_timeFuncCall1643 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_timeFuncCall1647 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_UNTIL_in_timeFuncCall1649 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_timeFuncCall1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_expr_list1684 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_expr_list1687 = new BitSet(new long[]{0x8A00900904404000L});
    public static final BitSet FOLLOW_expr_in_expr_list1690 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_bypassFilter_in_synpred1_Stage571 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred1_Stage573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_member_in_synpred2_Stage589 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred2_Stage591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timeFuncCall_in_synpred3_Stage612 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred3_Stage614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_in_synpred4_Stage634 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred4_Stage636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filtercall_in_synpred5_Stage666 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred5_Stage668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declare_in_synpred6_Stage687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred6_Stage689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addFilter_in_synpred7_Stage708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred7_Stage710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_member_in_synpred8_Stage1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcVar_in_synpred9_Stage1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayVar_in_synpred10_Stage1551 = new BitSet(new long[]{0x0000000000000002L});

}