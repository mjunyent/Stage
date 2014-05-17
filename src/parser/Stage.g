grammar Stage;

options {
    output = AST;
    ASTLabelType = StageTree;
}

// Imaginary tokens to create some AST nodes
tokens {
    ROOT; //Root of the tree.
    LIST_FUNCTIONS;	// List of functions
    LIST_FILTERS;	//List of filters
   	PARAM;
   	PARAMS;     // List of parameters in the declaration of a function
   	INPUTS;
    ARRAY;
    ASSIGN;     // Assignment instruction
    FUNCALL;    // Function call
    FILTCALL;
    EMPTYFILT;
    DECLARE;
    TIMECALL;
    ADDFILT; // : 'add';

    //INSTANCE;
    ARGLIST;    // List of arguments passed in a function call
    LIST_INSTR; // Block of instructions
    BOOLEAN;    // Boolean atom (for Boolean constants "true" or "false")
    OPERATOR;
}

@header {
package parser;
import interp.StageTree;
}

@lexer::header {
package parser;
}


// A program is a list of functions and filters (procedures)
prog    :	procedures -> ^(ROOT procedures+);

procedures:	(func | filter)+ EOF -> ^(LIST_FUNCTIONS func*) ^(LIST_FILTERS filter*);

// A function has a name, a list of parameters and a block of instructions	
func	: FUNCTION ret=ID? nam=ID params CBL function_block_instructions CBR -> ^(FUNCTION $nam $ret? params function_block_instructions);

// The list of parameters grouped in a subtree (it can be empty)
params	: '(' paramlist? ')' -> ^(PARAMS paramlist?);

// Parameters are separated by commas
paramlist: param (','! param)*;

param   : type=ID id=ID -> ^(PARAM $type $id);

function_block_instructions 
	:	first_instructions?
		loop_instructions?
		last_instructions?
	;

first_instructions:	(FIRST^ (instruction)*);
loop_instructions: (LOOP^ (instruction)*);
last_instructions: (LAST^ (instruction)*);


filter: FILTER^ input ID params CBL! block_instructions CBR!
	;

input: (inputlist '->')? -> ^(INPUTS inputlist?);

inputlist:	ID (','! ID)*;

// A list of instructions, all of them gouped in a subtree
block_instructions
        :	 (instruction)*
            -> ^(LIST_INSTR instruction*)
        ;

// The different types of instructions
instruction
        :   (bypassFilter ';')=>bypassFilter ';'! 
		|   (member ';')=>member ';'!
        |   (timeFuncCall ';')=>timeFuncCall ';'! 
        |	(assign ';')=>assign   ';'!       // Assignment
        |   (filtercall ';')=>filtercall ';'!
        |	(declare ';')=>declare ';'!
        |	(addFilter ';') => addFilter ';'!
        |	quitInst ';'!
        |	returnexp ';'!
        |	ite_stmt      // if-then-else
        |	while_stmt    // while statement
        ;

// Assignment
returnexp 
	:	RETURN^ expr?; 

assign	:	member eq=ASIGEQUAL expr -> ^(ASSIGN[$eq,":="] member expr);

filtercall : inputlist? '->' ID '(' expr_list? ')' '->' ID -> ^(FILTCALL ^(INPUTS inputlist?) ID ^(ARGLIST expr_list?) ID)
		   | from=ID '->' to=ID -> ^(EMPTYFILT $from $to);

addFilter 
	: 'add' '(' filtercall ')' 'after' ID -> ^(ADDFILT ID filtercall);

bypassFilter 
	:	BYPASSF^ ID 'with'! (ID | INT);	

quitInst
	:	QUIT;

declare :	type=ID name=ID (ASIGEQUAL expr)? -> ^(DECLARE $type $name expr?)
		|	type=ID '[' INT ']' name=ID (ASIGEQUAL expr)? -> ^(DECLARE ^(ARRAY $type INT) $name expr?);

	// if-then-else (else is optional)
ite_stmt	:	IF^ '('! expr ')'! CBL! block_instructions CBR! (ELSE! CBL! block_instructions CBR!)?
            ;

// while statement
while_stmt	:	WHILE^ '('! expr ')'! CBL! block_instructions CBR!
            ;

// Grammar for expressions with boolean, relational and aritmetic operators
expr    :   boolterm (OR^ boolterm)*
        ;

boolterm:   boolfact (AND^ boolfact)*
        ;

boolfact:   num_expr ((EQUAL^ | NOT_EQUAL^ | LT^ | LE^ | GT^ | GE^) num_expr)?
        ;

num_expr:   term ( (PLUS^ | MINUS^) term)*
        ;

term    :   factor ( (MUL^ | DIV^ | MOD^) factor)*
        ;

factor  :   (NOT^ | MINUS^)? atom
        ;

// Atom of the expressions (variables, integer and boolean literals).
// An atom can also be a function call or another expression
// in parenthesis
atom    :	//(static_funcall)=>static_funcall
		//|	instance
		//|
		 (member)=>member
        |   INT
        |	FLOAT
        |	CHAR
        |	STRING
        |   (b=TRUE | b=FALSE)  -> ^(BOOLEAN[$b,$b.text])
        |   '('! expr ')'!
        ;
        
member	: var (MEMBER^ var)*;

var		:	(funcVar) => funcVar
		|	(arrayVar) => arrayVar
		|	ID
		;
		
arrayVar 
	:	ID '[' expr ']' -> ^(ARRAY ID expr);
funcVar 
	:	ID '(' expr_list? ')' -> ^(FUNCALL ID ^(ARGLIST expr_list?));


//static_funcall : (member MEMBER)? ID '(' expr_list? ')' -> ^(FUNCALL member? ID ^(ARGLIST expr_list?))
//        ;

//nfcl 
//	:	member (FROM fexpr=expr UNTIL uexpr=expr)? -> ^(TIMECALL member $fexpr? $uexpr?);
	
timeFuncCall
	:	funcVar FROM fexpr=expr UNTIL uexpr=expr -> ^(TIMECALL funcVar $fexpr $uexpr);

// A function call has a lits of arguments in parenthesis (possibly empty)
//funcall : (member MEMBER)? ID '(' expr_list? ')' (FROM fexpr=expr UNTIL uexpr=expr)? -> ^(FUNCALL member? ID ^(ARGLIST expr_list?) $fexpr? $uexpr? )
//        ;

//instance 
//	: NEW ID '(' expr_list? ')' -> ^(INSTANCE ID ^(ARGLIST expr_list?))
//	;

// A list of expressions separated by commas
expr_list:  expr (','! expr)*
        ;

// Basic tokens
FUNCTION: 'function' ;
FILTER  : 'filter';
//NEW		: 'new';
QUIT	: 'quit';
BYPASSF : 'bypass';
CBL		: '{';
CBR		: '}';
RETURN	: 'return' ;
FIRST	: 'FIRST:';
LOOP	: 'LOOP:';
LAST	: 'LAST:';
FROM	: 'from';
UNTIL	: 'until';
ASIGEQUAL	: '=' ;
EQUAL:	'==';
NOT_EQUAL: '!=' ;
LT	    : '<' ;
LE	    : '<=';
GT	    : '>';
GE	    : '>=';
PLUS	: '+' ;
MINUS	: '-' ;
MUL	    : '*';
DIV	    : '/';
MOD	    : '%' ;
NOT	    : 'not';
AND	    : 'and' ;
OR	    : 'or' ;	
IF  	: 'if' ;
ELSE	: 'else' ;
WHILE	: 'while' ;
TRUE    : 'true' ;
FALSE   : 'false';
ID  	:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
INT 	:	'0'..'9'+ ;
FLOAT	:   '0'..'9'+ '.' '0'..'9'*;
MEMBER  :	'.';

// C-style comments
COMMENT	: '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    	| '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    	;

/*MACRO_GLSL
	:	'#GLSL_CODE_START' ~('#GLSL_CODE_START')* '#GLSL_CODE_END';*/

// Strings (in quotes) with escape sequences        
STRING  :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
        ;

CHAR	: '\'' ( ESC_SEQ | ~('\\'|'"') ) '\'';


fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;

// White spaces
WS  	: ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    	;
