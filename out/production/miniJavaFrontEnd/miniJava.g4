grammar miniJava;

goal: mainClass classDeclaration+;

mainClass
    : 'class' identifier '{' 
    'public' 'static' 'void' 'main' '(' 'String' '[' ']' ID ')' '{' statement '}' '}' 
    ;

classDeclaration
    : 'class' identifier 
    ( 'extends' identifier )? 
    '{' ( varDeclaration )* ( methodDeclaration )* '}'             #InsideClass
	;           

varDeclaration
    : type identifier ';'                                          #DeclareVariable
    ;

methodDeclaration
    : 'public' type identifier 
    '(' ( type identifier ( ',' type identifier )* )? ')' '{' ( varDeclaration )* ( statement )* 'return' extendexp ';' '}'   #Method
	;

type
    : 'int' '['']'                                                 #IntegerArray
    |'boolean'                                                     #Boolean
	|'int'                                                         #Integer
	|identifier                                                    #Instance
	;                                                  

statement
    : '{' ( statement )* '}'                                       #BracesOfStatement
	|'if' '(' extendexp ')' statement 'else' statement             #Ifelse
	|'while' '(' extendexp ')' statement                           #While
	|'System.out.println' '(' extendexp ')' ';'                    #Println	
	|identifier '=' extendexp ';'                                  #Assign
	|identifier '[' extendexp ']' '=' extendexp ';'                #ArrayValueAssign
    ;

extendexp
    :expression
    |expression ')' {notifyErrorListeners("too many ')'");}
    |'(' expression {notifyErrorListeners("too many '('");}
    ;

expression
    :     expression '&&' expression                                                #And
	    | expression '<' expression                                                 #Lessthan
        | expression ('*'|'/') expression                                           #MulDivide
        | expression ('+'|'-') expression                                           #AddSub
        | expression '[' expression ']'                                             #GetArrayValue
        | expression '.' 'length'                                                   #GetLength
        | expression '.' identifier '(' ( expression ( ',' expression )* )? ')'     #CallFunction
        | 'true'                                                                    #BoolTrue
        | 'false'                                                                   #BoolFalse
        | identifier                                                                #VarOfExpression
        | 'this'                                                                    #This
        | 'new' 'int' '[' expression ']'                                            #NewIntArray
        | 'new' identifier '(' ')'                                                  #NewClass
        | '!' expression                                                            #Negative
        | '(' expression ')'                                                        #Bracketpair
        | INT                                                                       #IntValueOfExpression
        | STR                                                                       #StringValueOfExpression        
        ;

identifier
    :ID                                                                             #Variable
    |WRONG {notifyErrorListeners("Wrong ID");}                                      #WrongID   
    ;                                                                              


ID:[a-zA-Z][a-zA-Z0-9_]*;
INT: [0-9]+;
WRONG:[0-9][a-zA-Z0-9_]*;
STR: '"' .*? '"';
WS: [ \t\r\n]+ -> skip;
COMMENT
    : '/*' .*? '*/' -> skip;
LINE_COMMENT
    : '//' .*? '\r'? '\n' -> skip;

