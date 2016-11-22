grammar miniJava;

goal: mainClass classDeclaration+;

mainClass
    : 'class' identifier '{' 
    'public' 'static' 'void' 'main' '(' 'String' '[' ']' ID ')' '{' statement '}' '}' 
    ;

classDeclaration
    : 'class' identifier 
    ( 'extends' identifier )? 
    '{' ( varDeclaration )* ( methodDeclaration )* '}' ;

varDeclaration
    : type identifier ';'  
    ;

methodDeclaration
    : 'public' type identifier 
    '(' ( type identifier ( ',' type identifier )* )? ')' '{' ( varDeclaration )* ( statement )* 'return' extendexp ';' '}' ;

type
    : 'int' '['']'
    |'boolean'
	|'int'
	|identifier ;

statement
    : '{' ( statement )* '}'
	|'if' '(' extendexp ')' statement 'else' statement
	|'while' '(' extendexp ')' statement
	|'System.out.println' '(' extendexp ')' ';'
	|identifier '=' extendexp ';'
	|identifier '[' extendexp ']' '=' extendexp ';' 
    ;

extendexp
    :expression
    |expression ')' {notifyErrorListeners("too many ')'");}
    |'(' expression {notifyErrorListeners("too many '('");}
    ;

expression
    : expression ('&&'|'<') expression   
        | expression ('*'|'/') expression
        | expression ('+'|'-') expression
        | expression '[' expression ']'
        | expression '.' 'length'
        | expression '.' identifier '(' ( expression ( ',' expression )* )? ')'
        | 'true'
        | 'false'
        | identifier
        | 'this'
        | 'new' 'int' '[' expression ']'
        | 'new' identifier '(' ')'
        | '!' expression
        | '(' expression ')'
        | INT
        | STR        
        | '(' expression ')'
        ;

identifier
    :ID
    |WRONG {notifyErrorListeners("Wrong ID");}
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

