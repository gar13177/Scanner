/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
grammar decaf;




//reglas

program : 'class' ID '{' (declaration)* '}'  ;

declaration: structDeclaration
           | varDeclaration
           | methodDeclaration ;

varType: 'int'
       | 'char'
       | 'boolean'
       | 'struct' ID 
       |structDeclaration;

varDeclaration: varType ID ';'
              | varType ID '[' NUM ']' ';'  ;

structDeclaration : 'struct' ID '{' (varDeclaration)* '}'  ;



//methodDeclaration : methodType ID '(' (parameter (',' parameter)*)* ')' block  ;
methodDeclaration : methodType ID '(' (parameter (',' parameter)*)? ')' block  ;//cero o una en vez de estrella

methodType : 'int' 
           | 'char' 
           | 'boolean' 
           | 'void' ;

parameter : parameterType ID 
          | parameterType ID '[' ']' ;

parameterType: 'int' 
             | 'char' 
             | 'boolean'  ;

block : '{' (varDeclaration |statement)* '}' ;

statement : 'if' '(' expression ')' block ( 'else' block )? #statementIf
           | 'while' '(' expression ')' block #statementWhile
           | 'return' ( expression )? ';' #statementReturn//falta
           //| methodCall ';' #statementMethod
           | block  #statementBlock
           | location '=' expression ';' #statementAsign
           | expression ';'  #statementExp;


location : ID #locationID
         |ID '.' location #locationIDlocation//para despues
         |ID '[' expression ']' #locationExp
         |ID '[' expression ']' '.' location #locationExplocation ;//para despues

expression : location #expLocation
           | methodCall #expMethodCall
           | literal #expLiteral
           | calc_op #expCalc
           | expression op expression #expOPExp
           | '-' expression #expMinus
           | '!' expression #expNot
           | '('expression')' #expPexp ;

methodCall :    ID '(' (arg (',' arg)*)? ')' ;

arg :   expression;

op:  rel_op 
  | eq_op 
  | cond_op  ;

calc_op: plusOrMinus;

plusOrMinus : plusOrMinus '+' multOrDiv
            | plusOrMinus '-' multOrDiv
            | multOrDiv;

multOrDiv : multOrDiv '*' pow
          | multOrDiv '/' pow
          | pow;

pow : unaryMinus;

unaryMinus : '-' unaryMinus
           | atom;

atom : '(' plusOrMinus ')'
     | literal
     | location
     | methodCall;

rel_op : '<' | '>' | '<=' | '>=' ;

eq_op : '==' | '!=' ;

cond_op : '&&' | '||' ;

literal : int_literal 
        | char_literal 
        | bool_literal ;

int_literal : NUM ;

char_literal : CHAR ;

bool_literal : 'true' | 'false' ;

//definicion
fragment LETTER: ('a'..'z'|'A'..'Z') ;
fragment DIGIT : ('0'..'9') ;
ID : LETTER( LETTER | DIGIT)* ;
NUM: DIGIT(DIGIT)* ;
CHAR : '\'' ( ~['\r\n\\] | '\\' ['\\] ) '\'';
WS : [ \t\r\n\f]+  ->channel(HIDDEN);
COMMENTS: '//' ~('\r' | '\n' )*  -> channel(HIDDEN);
