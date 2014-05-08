// $ANTLR 3.4 /Users/marc/IdeaProjects/Stage/src/parser/Stage.g 2014-05-08 20:01:09

package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class StageLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public StageLexer() {} 
    public StageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public StageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/marc/IdeaProjects/Stage/src/parser/Stage.g"; }

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:6:7: ( '(' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:6:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:7:7: ( ')' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:7:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:8:7: ( ',' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:8:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:9:7: ( '->' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:9:9: '->'
            {
            match("->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:10:7: ( ';' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:10:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:11:7: ( '[' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:11:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:12:7: ( ']' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:12:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:13:7: ( 'after' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:13:9: 'after'
            {
            match("after"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:14:7: ( 'with' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:14:9: 'with'
            {
            match("with"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:195:9: ( 'function' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:195:11: 'function'
            {
            match("function"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "FILTER"
    public final void mFILTER() throws RecognitionException {
        try {
            int _type = FILTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:196:9: ( 'filter' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:196:11: 'filter'
            {
            match("filter"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FILTER"

    // $ANTLR start "QUIT"
    public final void mQUIT() throws RecognitionException {
        try {
            int _type = QUIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:198:6: ( 'quit' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:198:8: 'quit'
            {
            match("quit"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUIT"

    // $ANTLR start "ADDFILT"
    public final void mADDFILT() throws RecognitionException {
        try {
            int _type = ADDFILT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:199:9: ( 'add' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:199:11: 'add'
            {
            match("add"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ADDFILT"

    // $ANTLR start "BYPASSF"
    public final void mBYPASSF() throws RecognitionException {
        try {
            int _type = BYPASSF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:200:9: ( 'bypass' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:200:11: 'bypass'
            {
            match("bypass"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BYPASSF"

    // $ANTLR start "CBL"
    public final void mCBL() throws RecognitionException {
        try {
            int _type = CBL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:201:6: ( '{' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:201:8: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CBL"

    // $ANTLR start "CBR"
    public final void mCBR() throws RecognitionException {
        try {
            int _type = CBR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:202:6: ( '}' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:202:8: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CBR"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:203:8: ( 'return' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:203:10: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "FIRST"
    public final void mFIRST() throws RecognitionException {
        try {
            int _type = FIRST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:204:7: ( 'FIRST:' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:204:9: 'FIRST:'
            {
            match("FIRST:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FIRST"

    // $ANTLR start "LOOP"
    public final void mLOOP() throws RecognitionException {
        try {
            int _type = LOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:205:6: ( 'LOOP:' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:205:8: 'LOOP:'
            {
            match("LOOP:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOOP"

    // $ANTLR start "LAST"
    public final void mLAST() throws RecognitionException {
        try {
            int _type = LAST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:206:6: ( 'LAST:' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:206:8: 'LAST:'
            {
            match("LAST:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LAST"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:207:6: ( 'from' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:207:8: 'from'
            {
            match("from"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "UNTIL"
    public final void mUNTIL() throws RecognitionException {
        try {
            int _type = UNTIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:208:7: ( 'until' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:208:9: 'until'
            {
            match("until"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNTIL"

    // $ANTLR start "ASIGEQUAL"
    public final void mASIGEQUAL() throws RecognitionException {
        try {
            int _type = ASIGEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:209:11: ( '=' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:209:13: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASIGEQUAL"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:210:6: ( '==' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:210:8: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "NOT_EQUAL"
    public final void mNOT_EQUAL() throws RecognitionException {
        try {
            int _type = NOT_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:211:10: ( '!=' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:211:12: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT_EQUAL"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:212:8: ( '<' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:212:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:213:8: ( '<=' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:213:10: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:214:8: ( '>' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:214:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:215:8: ( '>=' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:215:10: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:216:6: ( '+' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:216:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:217:7: ( '-' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:217:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MUL"
    public final void mMUL() throws RecognitionException {
        try {
            int _type = MUL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:218:9: ( '*' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:218:11: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MUL"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:219:9: ( '/' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:219:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:220:9: ( '%' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:220:11: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:221:9: ( 'not' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:221:11: 'not'
            {
            match("not"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:222:9: ( 'and' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:222:11: 'and'
            {
            match("and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:223:8: ( 'or' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:223:10: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:224:6: ( 'if' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:224:8: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:225:6: ( 'else' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:225:8: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:226:7: ( 'while' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:226:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:227:9: ( 'true' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:227:11: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:228:9: ( 'false' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:228:11: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:229:6: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:229:8: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:229:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:230:6: ( ( '0' .. '9' )+ )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:230:8: ( '0' .. '9' )+
            {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:230:8: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:231:7: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:231:11: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
            {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:231:11: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            match('.'); 

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:231:25: ( '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "MEMBER"
    public final void mMEMBER() throws RecognitionException {
        try {
            int _type = MEMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:232:9: ( '.' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:232:11: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MEMBER"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:235:9: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='/') ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1=='/') ) {
                    alt8=1;
                }
                else if ( (LA8_1=='*') ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:235:11: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:235:16: (~ ( '\\n' | '\\r' ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:235:30: ( '\\r' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\r') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:235:30: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:236:8: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:236:13: ( options {greedy=false; } : . )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='*') ) {
                            int LA7_1 = input.LA(2);

                            if ( (LA7_1=='/') ) {
                                alt7=2;
                            }
                            else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
                                alt7=1;
                            }


                        }
                        else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:236:41: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:243:9: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:243:12: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:243:16: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\\') ) {
                    alt9=1;
                }
                else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '!')||(LA9_0 >= '#' && LA9_0 <= '[')||(LA9_0 >= ']' && LA9_0 <= '\uFFFF')) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:243:18: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:243:28: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:246:6: ( '\\'' ( ESC_SEQ |~ ( '\\\\' | '\"' ) ) '\\'' )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:246:8: '\\'' ( ESC_SEQ |~ ( '\\\\' | '\"' ) ) '\\''
            {
            match('\''); 

            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:246:13: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\\') ) {
                alt10=1;
            }
            else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '!')||(LA10_0 >= '#' && LA10_0 <= '[')||(LA10_0 >= ']' && LA10_0 <= '\uFFFF')) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:246:15: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:246:25: ~ ( '\\\\' | '\"' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:252:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:252:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            {
            match('\\'); 

            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:255:6: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:255:8: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:8: ( T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | FUNCTION | FILTER | QUIT | ADDFILT | BYPASSF | CBL | CBR | RETURN | FIRST | LOOP | LAST | FROM | UNTIL | ASIGEQUAL | EQUAL | NOT_EQUAL | LT | LE | GT | GE | PLUS | MINUS | MUL | DIV | MOD | NOT | AND | OR | IF | ELSE | WHILE | TRUE | FALSE | ID | INT | FLOAT | MEMBER | COMMENT | STRING | CHAR | WS )
        int alt11=50;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:10: T__63
                {
                mT__63(); 


                }
                break;
            case 2 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:16: T__64
                {
                mT__64(); 


                }
                break;
            case 3 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:22: T__65
                {
                mT__65(); 


                }
                break;
            case 4 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:28: T__66
                {
                mT__66(); 


                }
                break;
            case 5 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:34: T__67
                {
                mT__67(); 


                }
                break;
            case 6 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:40: T__68
                {
                mT__68(); 


                }
                break;
            case 7 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:46: T__69
                {
                mT__69(); 


                }
                break;
            case 8 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:52: T__70
                {
                mT__70(); 


                }
                break;
            case 9 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:58: T__71
                {
                mT__71(); 


                }
                break;
            case 10 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:64: FUNCTION
                {
                mFUNCTION(); 


                }
                break;
            case 11 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:73: FILTER
                {
                mFILTER(); 


                }
                break;
            case 12 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:80: QUIT
                {
                mQUIT(); 


                }
                break;
            case 13 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:85: ADDFILT
                {
                mADDFILT(); 


                }
                break;
            case 14 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:93: BYPASSF
                {
                mBYPASSF(); 


                }
                break;
            case 15 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:101: CBL
                {
                mCBL(); 


                }
                break;
            case 16 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:105: CBR
                {
                mCBR(); 


                }
                break;
            case 17 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:109: RETURN
                {
                mRETURN(); 


                }
                break;
            case 18 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:116: FIRST
                {
                mFIRST(); 


                }
                break;
            case 19 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:122: LOOP
                {
                mLOOP(); 


                }
                break;
            case 20 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:127: LAST
                {
                mLAST(); 


                }
                break;
            case 21 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:132: FROM
                {
                mFROM(); 


                }
                break;
            case 22 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:137: UNTIL
                {
                mUNTIL(); 


                }
                break;
            case 23 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:143: ASIGEQUAL
                {
                mASIGEQUAL(); 


                }
                break;
            case 24 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:153: EQUAL
                {
                mEQUAL(); 


                }
                break;
            case 25 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:159: NOT_EQUAL
                {
                mNOT_EQUAL(); 


                }
                break;
            case 26 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:169: LT
                {
                mLT(); 


                }
                break;
            case 27 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:172: LE
                {
                mLE(); 


                }
                break;
            case 28 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:175: GT
                {
                mGT(); 


                }
                break;
            case 29 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:178: GE
                {
                mGE(); 


                }
                break;
            case 30 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:181: PLUS
                {
                mPLUS(); 


                }
                break;
            case 31 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:186: MINUS
                {
                mMINUS(); 


                }
                break;
            case 32 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:192: MUL
                {
                mMUL(); 


                }
                break;
            case 33 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:196: DIV
                {
                mDIV(); 


                }
                break;
            case 34 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:200: MOD
                {
                mMOD(); 


                }
                break;
            case 35 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:204: NOT
                {
                mNOT(); 


                }
                break;
            case 36 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:208: AND
                {
                mAND(); 


                }
                break;
            case 37 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:212: OR
                {
                mOR(); 


                }
                break;
            case 38 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:215: IF
                {
                mIF(); 


                }
                break;
            case 39 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:218: ELSE
                {
                mELSE(); 


                }
                break;
            case 40 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:223: WHILE
                {
                mWHILE(); 


                }
                break;
            case 41 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:229: TRUE
                {
                mTRUE(); 


                }
                break;
            case 42 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:234: FALSE
                {
                mFALSE(); 


                }
                break;
            case 43 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:240: ID
                {
                mID(); 


                }
                break;
            case 44 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:243: INT
                {
                mINT(); 


                }
                break;
            case 45 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:247: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 46 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:253: MEMBER
                {
                mMEMBER(); 


                }
                break;
            case 47 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:260: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 48 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:268: STRING
                {
                mSTRING(); 


                }
                break;
            case 49 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:275: CHAR
                {
                mCHAR(); 


                }
                break;
            case 50 :
                // /Users/marc/IdeaProjects/Stage/src/parser/Stage.g:1:280: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\4\uffff\1\47\3\uffff\5\40\2\uffff\4\40\1\71\1\uffff\1\73\1\75\2"+
        "\uffff\1\77\1\uffff\5\40\1\uffff\1\105\6\uffff\20\40\10\uffff\1"+
        "\40\1\130\1\131\2\40\2\uffff\1\40\1\135\1\136\15\40\1\154\2\uffff"+
        "\3\40\2\uffff\1\160\3\40\1\164\1\40\1\166\6\40\1\uffff\1\175\1\176"+
        "\1\177\1\uffff\1\u0080\2\40\1\uffff\1\u0083\1\uffff\3\40\2\uffff"+
        "\1\u0087\4\uffff\1\40\1\u0089\1\uffff\1\u008a\1\u008b\2\uffff\1"+
        "\40\3\uffff\1\u008d\1\uffff";
    static final String DFA11_eofS =
        "\u008e\uffff";
    static final String DFA11_minS =
        "\1\11\3\uffff\1\76\3\uffff\1\144\1\150\1\141\1\165\1\171\2\uffff"+
        "\1\145\1\111\1\101\1\156\1\75\1\uffff\2\75\2\uffff\1\52\1\uffff"+
        "\1\157\1\162\1\146\1\154\1\162\1\uffff\1\56\6\uffff\1\164\2\144"+
        "\1\164\1\151\1\156\1\154\1\157\1\154\1\151\1\160\1\164\1\122\1\117"+
        "\1\123\1\164\10\uffff\1\164\2\60\1\163\1\165\2\uffff\1\145\2\60"+
        "\1\150\1\154\1\143\1\164\1\155\1\163\1\164\1\141\1\165\1\123\1\120"+
        "\1\124\1\151\1\60\2\uffff\2\145\1\162\2\uffff\1\60\1\145\1\164\1"+
        "\145\1\60\1\145\1\60\1\163\1\162\1\124\2\72\1\154\1\uffff\3\60\1"+
        "\uffff\1\60\1\151\1\162\1\uffff\1\60\1\uffff\1\163\1\156\1\72\2"+
        "\uffff\1\60\4\uffff\1\157\1\60\1\uffff\2\60\2\uffff\1\156\3\uffff"+
        "\1\60\1\uffff";
    static final String DFA11_maxS =
        "\1\175\3\uffff\1\76\3\uffff\1\156\1\151\2\165\1\171\2\uffff\1\145"+
        "\1\111\1\117\1\156\1\75\1\uffff\2\75\2\uffff\1\57\1\uffff\1\157"+
        "\1\162\1\146\1\154\1\162\1\uffff\1\71\6\uffff\1\164\2\144\1\164"+
        "\1\151\1\156\1\154\1\157\1\154\1\151\1\160\1\164\1\122\1\117\1\123"+
        "\1\164\10\uffff\1\164\2\172\1\163\1\165\2\uffff\1\145\2\172\1\150"+
        "\1\154\1\143\1\164\1\155\1\163\1\164\1\141\1\165\1\123\1\120\1\124"+
        "\1\151\1\172\2\uffff\2\145\1\162\2\uffff\1\172\1\145\1\164\1\145"+
        "\1\172\1\145\1\172\1\163\1\162\1\124\2\72\1\154\1\uffff\3\172\1"+
        "\uffff\1\172\1\151\1\162\1\uffff\1\172\1\uffff\1\163\1\156\1\72"+
        "\2\uffff\1\172\4\uffff\1\157\1\172\1\uffff\2\172\2\uffff\1\156\3"+
        "\uffff\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\6\1\7\5\uffff\1\17\1\20\5\uffff"+
        "\1\31\2\uffff\1\36\1\40\1\uffff\1\42\5\uffff\1\53\1\uffff\1\56\1"+
        "\60\1\61\1\62\1\4\1\37\20\uffff\1\30\1\27\1\33\1\32\1\35\1\34\1"+
        "\57\1\41\5\uffff\1\54\1\55\21\uffff\1\45\1\46\3\uffff\1\15\1\44"+
        "\15\uffff\1\43\3\uffff\1\11\3\uffff\1\25\1\uffff\1\14\3\uffff\1"+
        "\23\1\24\1\uffff\1\47\1\51\1\10\1\50\2\uffff\1\52\2\uffff\1\22\1"+
        "\26\1\uffff\1\13\1\16\1\21\1\uffff\1\12";
    static final String DFA11_specialS =
        "\u008e\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\45\2\uffff\1\45\22\uffff\1\45\1\24\1\43\2\uffff\1\32\1\uffff"+
            "\1\44\1\1\1\2\1\30\1\27\1\3\1\4\1\42\1\31\12\41\1\uffff\1\5"+
            "\1\25\1\23\1\26\2\uffff\5\40\1\20\5\40\1\21\16\40\1\6\1\uffff"+
            "\1\7\1\uffff\1\40\1\uffff\1\10\1\14\2\40\1\36\1\12\2\40\1\35"+
            "\4\40\1\33\1\34\1\40\1\13\1\17\1\40\1\37\1\22\1\40\1\11\3\40"+
            "\1\15\1\uffff\1\16",
            "",
            "",
            "",
            "\1\46",
            "",
            "",
            "",
            "\1\51\1\uffff\1\50\7\uffff\1\52",
            "\1\54\1\53",
            "\1\60\7\uffff\1\56\10\uffff\1\57\2\uffff\1\55",
            "\1\61",
            "\1\62",
            "",
            "",
            "\1\63",
            "\1\64",
            "\1\66\15\uffff\1\65",
            "\1\67",
            "\1\70",
            "",
            "\1\72",
            "\1\74",
            "",
            "",
            "\1\76\4\uffff\1\76",
            "",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "\1\106\1\uffff\12\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\127",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\132",
            "\1\133",
            "",
            "",
            "\1\134",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\161",
            "\1\162",
            "\1\163",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\165",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0081",
            "\1\u0082",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "",
            "",
            "\1\u0088",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "\1\u008c",
            "",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | FUNCTION | FILTER | QUIT | ADDFILT | BYPASSF | CBL | CBR | RETURN | FIRST | LOOP | LAST | FROM | UNTIL | ASIGEQUAL | EQUAL | NOT_EQUAL | LT | LE | GT | GE | PLUS | MINUS | MUL | DIV | MOD | NOT | AND | OR | IF | ELSE | WHILE | TRUE | FALSE | ID | INT | FLOAT | MEMBER | COMMENT | STRING | CHAR | WS );";
        }
    }
 

}