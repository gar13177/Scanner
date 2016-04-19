package project;

import grammar.ANTLR.decafBaseVisitor;
import java.util.ArrayList;
import java.util.Stack;
import grammar.ANTLR.decafParser.*;
import static java.lang.Integer.parseInt;
import java.util.LinkedHashSet;
import org.antlr.v4.runtime.tree.ParseTree;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class MyVisitor extends decafBaseVisitor<Object> {
    
    private LinkedHashSet<String> _types;//tipos predefinidos
    private Stack<Scope> _scopes;//ambiente global
    private Stack<Exception> _errors;//errores
    private Method _methodRevision;
    
    public void initAll(){
        _types = new LinkedHashSet();
        _scopes = new Stack();
        _scopes.push(new Scope());
        _errors = new Stack();
    }
    
    public Object visitProgram(ProgramContext ctx){
        initAll();
        //'class' ID '{' (declaration)* '}'
        for (DeclarationContext child: ctx.declaration()){
            Object obj = visit(child);//visitamos hijo
            if (obj == null){
                int line = child.getStart().getLine();
                int column = child.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en declaration @line: "+line+" @column: "+column));
            }
        }
        
        if (_errors.empty())
            return null;
        
        //else: crear codigo intermedio
        return null;
    }
    
    public Object visitDeclaration(DeclarationContext ctx){
       
        if (ctx.methodDeclaration() != null){
            visitChildren(ctx);//
            System.out.println("visit methodDeclaration");
            return "void";
        }
        
        
        if (ctx.structDeclaration() != null){
            
            Object obj = visitChildren(ctx);
            if (obj == null){
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en structDeclaration @line: "+line+" @column: "+column));
                return null;
            }
            Object[] structDec = (Object[]) obj;
            //Object[] objR = {"struct", sd.getSize(), sd};
            
            StructDef sd = _scopes.peek().hasStructDef(((StructDef) structDec[2]).getStructID());
            
            if (sd != null){
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error struct '"+sd.getStructID()+"' previamente definido @line: "+line+" @column: "+column));
                return null;
            }
            
            _scopes.peek().getStructures().add((StructDef) structDec[2]);//agregamos structure
            return "void";
        }
        
        if (ctx.varDeclaration() != null){
            Object obj = visitChildren(ctx);
            
            if (obj == null){
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en varDeclaration @line: "+line+" @column: "+column));
                return null;
            }
            
            Variable varDec = (Variable) obj;
            Variable var = _scopes.peek().hasVariableDef(varDec.getVarId());
            if (var != null){
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error variable definida anteriormente '"+varDec.getVarId()+"' @line: "+line+" @column: "+column));
                return null;
            }
            _scopes.peek().getVars().add(varDec);//agregamos variable
            return "void";
        }
        
        return null;
    }
    
    public Object visitVarDeclaration(VarDeclarationContext ctx){
        Object obj1 = visit(ctx.varType());
        if (obj1 == null){
            int line = ctx.varType().getStart().getLine();
            int column = ctx.varType().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en varType @line: "+line+" @column: "+column));
            return null;
        }
        
        Variable var;
        
        Object[] varType = (Object[]) obj1;//casteamos obj1 como array
        if (((String)varType[0]).equals("struct")){
            
            var = new StructVar(ctx.ID().getText(),(StructDef) varType[2]);//si es struct, se crea un struct
            
        }else{
            var = new Variable(ctx.ID().getText(), (String)varType[0], (int)varType[1]);//si es variable, se crea variable
        }        
        var.updateTotalSize();
        if (ctx.getChildCount()<=3)
            return var;
        
        //de lo contrario
        int length = Integer.parseInt(ctx.NUM().getText());//parseamos length
        var.setArray(true);//lo identificamos como array
        var.setArraySize(length);//iniciamos su tamanio
        var.updateTotalSize();//
        
        return var;//retornamos variable
    }
    
    public Object visitVarType(VarTypeContext ctx){
        
        if (ctx.getChild(0).getText().equals("int")){
            Object[] obj = {"int", 4};
            return obj;
        }
        
        if (ctx.getChild(0).getText().equals("char")){
            Object[] obj = {"char", 1};
            return obj;
        }
        
        if (ctx.getChild(0).getText().equals("boolean")){
            Object[] obj = {"boolean", 1};
        }
        
        if (ctx.getChild(0).getText().equals("struct")){
            String id = ctx.ID().getText();
            StructDef sd = _scopes.peek().hasStructDef(id);
            if (sd == null){
                sd = _scopes.get(0).hasStructDef(id);
                if (sd == null){
                    int line = ctx.getStart().getLine();
                    int column = ctx.getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error tipo struct '"+id+"' no definido @line: "+line+" @column: "+column));
                    return null;
                }
            }
            Object[] obj = {"struct", sd.getSize(),sd};//retornamos struct, tamanio y struct referencia
            return obj;
        }
        
        //visita structDeclaration  
        Object obj = visitChildren(ctx);
        if (obj == null){
            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en structDeclaration @line: "+line+" @column: "+column));
            return null;
        }
        Object[] structDec = (Object[]) obj;
        //Object[] objR = {"struct", sd.getSize(), sd};

        StructDef sd = _scopes.peek().hasStructDef(((StructDef) structDec[2]).getStructID());

        if (sd != null){
            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();
            _errors.add(new Exception("Error struct '"+sd.getStructID()+"' previamente definido @line: "+line+" @column: "+column));
            return null;
        }

        _scopes.peek().getStructures().add((StructDef) structDec[2]);//agregamos structure
        return structDec;
    }
    
    public Object visitStructDeclaration(StructDeclarationContext ctx){
        
        StructDef sd = _scopes.peek().hasStructDef(ctx.ID().getText());//buscamos
        if (sd != null){
            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();
            _errors.add(new Exception("Error tipo struct '"+ctx.ID().getText()+"' ya definido @line: "+line+" @column: "+column));
            return null;
        }
        
        sd = new StructDef(ctx.ID().getText());
        boolean errores = false;
        for (VarDeclarationContext vd: ctx.varDeclaration()){
            if (vd.varType().structDeclaration() != null){
                int line = vd.getStart().getLine();
                int column = vd.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error no se puede declarar tipo struct en struct @line: "+line+" @column: "+column));
                errores = true;
            }else{
                Object obj = visit(vd);//visitamos 
                if (obj == null){
                    int line = vd.getStart().getLine();
                    int column = vd.getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error declaracion de variable @line: "+line+" @column: "+column));
                    errores = true;
                }else{
                    Variable var = (Variable)obj;//casteamos el objeto a variable
                    Variable v2 = sd.hasVariable(var.getVarId());//identificamos si ya la tiene
                    if (v2 != null){
                        int line = vd.getStart().getLine();
                        int column = vd.getStart().getCharPositionInLine();
                        _errors.add(new Exception("Error variable '"+v2.getVarId()+"' previamente definida @line: "+line+" @column: "+column));
                        errores = true;
                    }else{
                        sd.add(var);//agregamos la variable si no tiene  errores y no existe previamente
                        
                    }
                }
            } 
        }
        
        if (errores){
            
            return null;
        }
        
        sd.updateSize();
        
        Object[] objR = {"struct", sd.getSize(), sd};//creamos el objeto de retorno
        return objR;
    }
    
    public Object visitMethodDeclaration(MethodDeclarationContext ctx){
        String type = ctx.methodType().getText();
        String id = ctx.ID().toString();
        LinkedHashSet<Variable> parameters = new LinkedHashSet();
        boolean errores = false;
        for (ParameterContext pr: ctx.parameter()){
            Object obj = visit(pr);
            if (obj == null){
                int line = pr.getStart().getLine();
                int column = pr.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en parameter @line: "+line+" @column: "+column));
                errores = true;
            }else{
                Variable var = (Variable) obj;//variable de retorno
                int contador= 0;
                for (Variable param: parameters){
                    if (param.getVarId().equals(var.getVarId())){
                        int line = pr.getStart().getLine();
                        int column = pr.getStart().getCharPositionInLine();
                        _errors.add(new Exception("Error variable definida anteriormente '"+param.getVarId()+"' @line: "+line+" @column: "+column));
                        errores = true;
                        contador++;
                    }
                }
                if (contador==0){
                    parameters.add(var);
                }
            }
        }
        
        Method mt = new Method(id,type);
        mt.setParams(parameters);//agregamos parametros
        mt.setParamsAsVars();//agregamos los parametros como variables locales
        _scopes.peek().getMethods().add(mt);//agregamos el metodo por si hay recursion
        _scopes.push(new Scope());
        _scopes.peek().setVars(mt.getVars());//generamos el nuevo scope con las variables ya definidas
        _scopes.peek().getMethods().add(mt);//agregamos metodo a nuevo scope para evaluacion de tipo
        //
        
        Object obj = visit(ctx.block());//visitamos block
        
        if (errores) return null;
        return null;
    }
    
    public Object visitBlock (BlockContext ctx){
        boolean errores = false;
        for (VarDeclarationContext vdc: ctx.varDeclaration()){//para cada definicion de variable
            Object obj = visit(vdc);//visitamos varDeclaration
            if (obj == null){
                int line = vdc.getStart().getLine();
                int column = vdc.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en parameter @line: "+line+" @column: "+column));
                errores = true;
            }else{
                Variable varDec = (Variable) obj;
                
                Variable var = _scopes.peek().hasVariableDef(varDec.getVarId());
                
                if (var != null){
                    int line = vdc.getStart().getLine();
                    int column = vdc.getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error variable definida anteriormente '"+varDec.getVarId()+"' @line: "+line+" @column: "+column));
                    errores = true;
                }else{
                    _scopes.peek().getVars().add(varDec);//agregamos variable
                }
            }
            
        }
        
        for (StatementContext st: ctx.statement()){
            Object obj = visit(st);//visitamos statement
            if (obj == null){
                int line = st.getStart().getLine();
                int column = st.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en statement @line: "+line+" @column: "+column));
                errores = true;
            }else{
                Object[] type_code = (Object[])obj;
                String type = (String) type_code[0];//guarda el tipo del statement
                String code = (String) type_code[1];//guarda el codigo intermedio del statement
            }
        }
        
        if (errores) return null;
        
        Object[] returnO = {"void",""};
        return returnO;
    }
    
    public Object visitStatementIf (StatementIfContext ctx){
        Object obj = visit(ctx.expression());//visitamos expression
        if (obj == null){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en expression @line: "+line+" @column: "+column));
            return null;
        }
        Object[] type_code = (Object[])obj;
        String type = (String) type_code[0];//guarda el tipo del statement
        String code = (String) type_code[1];//guarda el codigo intermedio del statement
        
        if (!type.equals("boolean")){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en expression no booleana @line: "+line+" @column: "+column));
            return null;
        }
        for (BlockContext bc: ctx.block()){
            Object objB = visit(bc);//visitamos bloque
            
            if (objB == null){
                int line = bc.getStart().getLine();
                int column = bc.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en bloque if @line: "+line+" @column: "+column));
                return null;
            }
            Object[] type_codeB = (Object[])objB;
            String typeB = (String) type_code[0];//guarda el tipo del statement
            String codeB = (String) type_code[1];//guarda el codigo intermedio del statement
        }
        Object[] returnO = {"void",""};
        return returnO ;
    }
    
    public Object visitStatementWhile (StatementWhileContext ctx){
        Object obj = visit(ctx.expression());//visitamos expression
        if (obj == null){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en expression @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_code = (Object[])obj;
        String type = (String) type_code[0];//guarda el tipo del statement
        String code = (String) type_code[1];//guarda el codigo intermedio del statement

        if (!type.equals("boolean")){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en expression no booleana @line: "+line+" @column: "+column));
            return null;
        }
        
        Object objB = visit(ctx.block());//visitamos bloque
        if (objB == null){
            int line = ctx.block().getStart().getLine();
            int column = ctx.block().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en bloque while @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_codeB = (Object[])objB;
        String typeB = (String) type_code[0];//guarda el tipo del statement
        String codeB = (String) type_code[1];//guarda el codigo intermedio del statement

        Object[] returnO = {"void",""};
        return returnO;
    }
    
    public Object visitStatementReturn (StatementReturnContext ctx){
        if (ctx.expression() == null){
            //como se que solo puede haber un metodo en este momento
            for (Method mt: _scopes.peek().getMethods()){
                String methodType = mt.getMetType();
                if (!methodType.equals("void")){
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en tipo de metodo: '"+methodType+"' no es tipo expression: 'void' @line: "+line+" @column: "+column));
                    return null;
                }else{
                    mt.setReturn(true);
                    return "void";
                }
            }
        }
        
        Object obj = visit(ctx.expression());//visitamos expression
        
        if (obj == null){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en expression @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_code = (Object[])obj;
        String type = (String) type_code[0];//guarda el tipo del statement
        String code = (String) type_code[1];//guarda el codigo intermedio del statement
 
        for (Method mt: _scopes.peek().getMethods()){
            String methodType = mt.getMetType();
            if (!methodType.equals(type)){
                int line = ctx.expression().getStart().getLine();
                int column = ctx.expression().getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en tipo de metodo: '"+methodType+"' no es tipo expression: '"+type+"' @line: "+line+" @column: "+column));
                return null;
            }else{
                mt.setReturn(true);
                return "void";
            }
        }       
       
        Object[] returnO = {"void",""};
        return returnO;
    }
    
    public Object visitStatementAsign (StatementAsignContext ctx){
        Object objL = visit(ctx.location());
        if (objL == null){
            int line = ctx.location().getStart().getLine();
            int column = ctx.location().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en location @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_codeL = (Object[])objL;
        String typeL = (String) type_codeL[0];//guarda el tipo del statement
        String codeL = (String) type_codeL[1];//guarda el codigo intermedio del statement
        
        
        Object objE = visit(ctx.expression());
        if (objE == null){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en expression @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_codeE = (Object[])objE;
        String typeE = (String) type_codeE[0];//guarda el tipo del statement
        String codeE = (String) type_codeE[1];//guarda el codigo intermedio del statement
        
        if (!typeL.equals(typeE)){
            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();
            _errors.add(new Exception("Error tipo location: '"+typeL+"' no concuerda typo expression: '"+typeE+"' @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] returnO = {"void",""};
        return returnO; 
        
    }
    
    public Object visitStatementExp (StatementExpContext ctx){
        return visit(ctx.expression());//retornamos valor de expression
    }
    
    public Object visitLocation (LocationContext ctx){
        Variable var = _scopes.peek().hasVariableDef(ctx.ID().getText());
        if (var == null){
            var = _scopes.get(0).hasVariableDef(ctx.ID().getText());
            if (var == null){
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error variable '"+ctx.ID().getText()+"' no definida @line: "+line+" @column: "+column));
                return null;
            }
        }
        
        if (var instanceof StructVar){
            StructVar var1 = (StructVar)var;//guardo structvar
            if (ctx.expression() != null){//quiere decir que se llama como array
                if (!var1.isArray()){//si no es array
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error variable '"+ctx.ID().getText()+"' no definida como array @line: "+line+" @column: "+column));
                    return null;
                }
                //quiere decir que si es array, y se esta llamando expression
                Object obj = visit(ctx.expression());//visitamos expression
                if (obj == null){//error en expression
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en expression @line: "+line+" @column: "+column));
                    return null;
                }
                
                //si no existe error
                Object[] type_codeE = (Object[])obj;
                String typeE = (String) type_codeE[0];//guarda el tipo del expression
                String codeE = (String) type_codeE[1];//guarda el codigo intermedio del expression
                
                if (!typeE.equals("int")){
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en expression no de tipo int @line: "+line+" @column: "+column));
                    return null;
                }
                
                var1 = new StructVar(ctx.ID().getText(),var1.getStructID());//re escribimos var1 como un solo elemento
                //quiere decir que la llamada es correcta, si es array, y se esta buscando un elemento
            }
            
            //ya sabemos si se esta llamando a un solo ID o si es a una casilla del ID
            if (ctx.location() != null){//si se sigue llamando a location
                if (var1.isArray()){//quiere decir que se llama location a un array
                    int line = ctx.location().getStart().getLine();
                    int column = ctx.location().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error variable tipo array no tiene location definido @line: "+line+" @column: "+column));
                    return null;
                }
                
                return visitLocationContinuous(ctx.location(),var1);//retornamos el valor del location
            }
            //si ya no se llama a location
            String type = "struct"+ var1.getStructID().getStructID();//'struct' 'ID'
            if (var.isArray()) type += "array";
            
            Object[] returnO = {type,""};
            return returnO; 
        }else{//no es structvar
            if (ctx.expression() != null){//quiere decir que se llama como array
                if (!var.isArray()){//si no es array
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error variable '"+ctx.ID().getText()+"' no definida como array @line: "+line+" @column: "+column));
                    return null;
                }
                //quiere decir que si es array, y se esta llamando expression
                Object obj = visit(ctx.expression());//visitamos expression
                if (obj == null){//error en expression
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en expression @line: "+line+" @column: "+column));
                    return null;
                }
                
                //si no existe error
                Object[] type_codeE = (Object[])obj;
                String typeE = (String) type_codeE[0];//guarda el tipo del expression
                String codeE = (String) type_codeE[1];//guarda el codigo intermedio del expression
                
                if (!typeE.equals("int")){
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en expression no de tipo int @line: "+line+" @column: "+column));
                    return null;
                }
                
                var = new Variable(var.getVarId(),var.getVarType(), var.getSize());//re escribimos var1 como un solo elemento
                //quiere decir que la llamada es correcta, si es array, y se esta buscando un elemento
            }
            
            //ya sabemos si se esta llamando a un solo ID o si es a una casilla del ID
            if (ctx.location() != null){//si se sigue llamando a location aunque no es struct
                int line = ctx.location().getStart().getLine();
                int column = ctx.location().getStart().getCharPositionInLine();
                _errors.add(new Exception("Error variable no definida como 'struct' @line: "+line+" @column: "+column));
                return null;
            }
            
            String type = var.getVarType();//'tipo'
            if (var.isArray()) type += "array";
            
            Object[] returnO = {type,""};
            return returnO; 
        }
        
    }
    
    public Object visitLocationContinuous (LocationContext ctx, StructVar varCheck){
        Variable var = varCheck.getStructID().hasVariable(ctx.ID().getText());
        if (var == null){
            var = _scopes.get(0).hasVariableDef(ctx.ID().getText());
            if (var == null){
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error variable '"+ctx.ID().getText()+"' no definida @line: "+line+" @column: "+column));
                return null;
            }
        }
        
        if (var instanceof StructVar){
            StructVar var1 = (StructVar)var;//guardo structvar
            if (ctx.expression() != null){//quiere decir que se llama como array
                if (!var1.isArray()){//si no es array
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error variable '"+ctx.ID().getText()+"' no definida como array @line: "+line+" @column: "+column));
                    return null;
                }
                //quiere decir que si es array, y se esta llamando expression
                Object obj = visit(ctx.expression());//visitamos expression
                if (obj == null){//error en expression
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en expression @line: "+line+" @column: "+column));
                    return null;
                }
                
                //si no existe error
                Object[] type_codeE = (Object[])obj;
                String typeE = (String) type_codeE[0];//guarda el tipo del expression
                String codeE = (String) type_codeE[1];//guarda el codigo intermedio del expression
                
                if (!typeE.equals("int")){
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en expression no de tipo int @line: "+line+" @column: "+column));
                    return null;
                }
                
                var1 = new StructVar(ctx.ID().getText(),var1.getStructID());//re escribimos var1 como un solo elemento
                //quiere decir que la llamada es correcta, si es array, y se esta buscando un elemento
            }
            
            //ya sabemos si se esta llamando a un solo ID o si es a una casilla del ID
            if (ctx.location() != null){//si se sigue llamando a location
                if (var1.isArray()){//quiere decir que se llama location a un array
                    int line = ctx.location().getStart().getLine();
                    int column = ctx.location().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error variable tipo array no tiene location definido @line: "+line+" @column: "+column));
                    return null;
                }
                
                return visitLocationContinuous(ctx.location(),var1);//retornamos el valor del location
            }
            //si ya no se llama a location
            String type = "struct"+ var1.getStructID().getStructID();//'struct' 'ID'
            if (var.isArray()) type += "array";
            
            Object[] returnO = {type,""};
            return returnO; 
        }else{//no es structvar
            if (ctx.expression() != null){//quiere decir que se llama como array
                if (!var.isArray()){//si no es array
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error variable '"+ctx.ID().getText()+"' no definida como array @line: "+line+" @column: "+column));
                    return null;
                }
                //quiere decir que si es array, y se esta llamando expression
                Object obj = visit(ctx.expression());//visitamos expression
                if (obj == null){//error en expression
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en expression @line: "+line+" @column: "+column));
                    return null;
                }
                
                //si no existe error
                Object[] type_codeE = (Object[])obj;
                String typeE = (String) type_codeE[0];//guarda el tipo del expression
                String codeE = (String) type_codeE[1];//guarda el codigo intermedio del expression
                
                if (!typeE.equals("int")){
                    int line = ctx.expression().getStart().getLine();
                    int column = ctx.expression().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en expression no de tipo int @line: "+line+" @column: "+column));
                    return null;
                }
                
                var = new Variable(var.getVarId(),var.getVarType(), var.getSize());//re escribimos var1 como un solo elemento
                //quiere decir que la llamada es correcta, si es array, y se esta buscando un elemento
            }
            
            //ya sabemos si se esta llamando a un solo ID o si es a una casilla del ID
            if (ctx.location() != null){//si se sigue llamando a location aunque no es struct
                int line = ctx.location().getStart().getLine();
                int column = ctx.location().getStart().getCharPositionInLine();
                _errors.add(new Exception("Error variable no definida como 'struct' @line: "+line+" @column: "+column));
                return null;
            }
            
            String type = var.getVarType();//'tipo'
            if (var.isArray()) type += "array";
            
            Object[] returnO = {type,""};
            return returnO; 
        }
    }
    
    public Object visitExpression (ExpressionContext ctx){
        return null;
    }
    
    public Object visitParameter (ParameterContext ctx){
        Object obj = visit(ctx.parameterType());
        if (obj == null){
            int line = ctx.parameterType().getStart().getLine();
            int column = ctx.parameterType().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en parameterType @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type = (Object[])obj;
        String varType = (String) type[0];
        int varSize = (int)type[1];
        
        String varName = ctx.ID().getText();
        
        Variable var = new Variable(varName,varType,varSize);
        
        if (ctx.getChildCount()>2){
            var.setArray(true);
        }
        
        return var;
    }
    
    public Object visitParameterType(ParameterTypeContext ctx){
         if (ctx.getText().equals("int")){
            Object[] obj = {"int", 4};
            return obj;
        }
        
        if (ctx.getText().equals("char")){
            Object[] obj = {"char", 1};
            return obj;
        }
        
        if (ctx.getText().equals("boolean")){
            Object[] obj = {"boolean", 1};
        }
        
        return null;
    }
    
    public Stack<Exception> getError(){
        return _errors;
    }
    
    public String toStringError(){
        String st = "";
        while (!_errors.isEmpty()){
            st += _errors.pop().toString()+"\n";
        }
        return st;
    }
}
