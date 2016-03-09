/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
grammar decaf;




//reglas

program : 'class' ID '{' (declaration)* '}'  ;

declaration:  structDeclaration |  varDeclaration | methodDeclaration ;

varType: 'int' | 'char' | 'boolean' | 'struct' ID |  'void' |structDeclaration  ;

varDeclaration: varType ID ';' | varType ID '[' NUM ']' ';'  ;

structDeclaration : 'struct' ID '{' (varDeclaration)* '}'  ;



//methodDeclaration : methodType ID '(' (parameter (',' parameter)*)* ')' block  ;
methodDeclaration : methodType ID '(' (parameter (',' parameter)*)? ')' block  ;//cero o una en vez de estrella

methodType : 'int' | 'char' | 'boolean' | 'void' ;

parameter : parameterType ID | parameterType ID '[' ']' ;

parameterType: 'int' | 'char' | 'boolean'  ;

block : '{' (varDeclaration)* (statement)* '}' ;

statement : 'if' '(' expression ')' block ( 'else' block )? 
           | 'while' '(' expression ')' block
           //|'return' expressionA ';' 
           | 'return' ( expression )? ';'
           | methodCall ';' 
           | block  
           | location '=' expression 
           | (expression)? ';'  ;

//expressionA: expression | ;


location : (ID|ID '[' expression ']') ('.' location)?  ;

expression : location | methodCall | literal | calc_op | expression op expression | '-' expression | '!' expression | '('expression')'  ;

//methodCall :    ID '(' arg1 ')' ;
methodCall :    ID '(' (arg (',' arg)*)? ')' ;

//arg1    :   arg2 | ;

//arg2    :   (arg) (',' arg)* ;

arg :   expression;

//op: arith_op | rel_op | eq_op | cond_op  ;
op:  rel_op | eq_op | cond_op  ;

//arith_op : '+' | '-' | '*' | '/' | '%' ;

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

literal : int_literal | char_literal | bool_literal ;

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
/*
Revisar uso para comentarios y espacios en blanco
al momento error al tratar de parsear
*/
//COMMENTS: '//' ~('\r' | '\n' )*  -> channel(HIDDEN);
//WS : [ \t\r\n\f]+  ->channel(HIDDEN);