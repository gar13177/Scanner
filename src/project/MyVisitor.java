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
        
        LinkedHashSet<Method> tempMethods = new LinkedHashSet();
        tempMethods.addAll(_scopes.peek().getMethods());//guardamos los metodos pervios
        
        _scopes.peek().getMethods().add(mt);//agregamos el metodo por si hay recursion
        _scopes.push(new Scope());
        _scopes.peek().setVars(mt.getVars());//generamos el nuevo scope con las variables ya definidas
        _scopes.peek().getMethods().add(mt);//agregamos metodo a nuevo scope para evaluacion de tipo
        //
        
        Object obj = visit(ctx.block());//visitamos block
        
        Scope nscope = _scopes.pop();
 
        if (obj == null){
            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en declaracion de metodo '"+mt.getMetID()+"' @line: "+line+" @column: "+column));
            _scopes.peek().setMethods(tempMethods);//regresamos a los metodos previos
            errores = true;
        }
        
        Method mtn = new Method();
        for (Method m: nscope.getMethods()){
            mtn = m;
        }
        
        if (!mtn.isReturn() && !mtn.getMetType().equals("void") ){//si no tiene  retorno y no es void
            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en declaracion de metodo '"+mt.getMetID()+"' sin retorno @line: "+line+" @column: "+column));
            _scopes.peek().setMethods(tempMethods);//regresamos a los metodos previos
            errores = true;
        }
        
        //asignamos las cosas nuevas al metodo
        mt.setReturn(true);
        mt.setVars(nscope.getVars());
        mt.setStructures(nscope.getStructures());
        
        if (errores) return null;
        
       
        return "void";
    }
    
    public Object visitBlock (BlockContext ctx){
        LinkedHashSet<Variable> _vars = new LinkedHashSet();//variables definidas en este scope
        LinkedHashSet<Method> _methods = new LinkedHashSet();//metodos definidos en este scope
        LinkedHashSet<StructDef> _structures = new LinkedHashSet();//estructuras definidas
        _vars.addAll(_scopes.peek().getVars());
        _methods.addAll(_scopes.peek().getMethods());
        _structures.addAll(_scopes.peek().getStructures());
        
        boolean errores = false;
        for (int i = 1; i < ctx.getChildCount()-1; i++){
            ParseTree child = ctx.getChild(i);
            if (child instanceof VarDeclarationContext){
                VarDeclarationContext vdc = (VarDeclarationContext) child;
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
            }else if (child instanceof StatementContext){
                StatementContext st = (StatementContext) child;
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
        }
        
        /*
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
        */
        _scopes.peek().setMethods(_methods);
        _scopes.peek().setStructures(_structures);
        _scopes.peek().setVars(_vars);
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
                    Object[] returnO = {"void",""};
                    return returnO;
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
                Object[] returnO = {"void",""};
                return returnO;
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
            _errors.add(new Exception("Error tipo location: '"+typeL+"' no concuerda tipo expression: '"+typeE+"' @line: "+line+" @column: "+column));
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
            if (var1.isArray()) type += "array";
            
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
            if (var1.isArray()) type += "array";
            
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
    
    public Object visitExpOPExp (ExpOPExpContext ctx){
        
        Object objE1 = visit(ctx.expression(0));
        if (objE1 == null){
            int line = ctx.expression(0).getStart().getLine();
            int column = ctx.expression(0).getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de expression @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_codeE1 = (Object[])objE1;
        String typeE1 = (String) type_codeE1[0];//guarda el tipo del expression
        String codeE1 = (String) type_codeE1[1];//guarda el codigo intermedio del expression
        
        Object objE2 = visit(ctx.expression(1));
        if (objE2 == null){
            int line = ctx.expression(1).getStart().getLine();
            int column = ctx.expression(1).getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de expression @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_codeE2 = (Object[])objE2;
        String typeE2 = (String) type_codeE2[0];//guarda el tipo del expression
        String codeE2 = (String) type_codeE2[1];//guarda el codigo intermedio del expression
        
        String op = (String)visit(ctx.op());//op
        
        if (!typeE2.equals(typeE1)){
            int line = ctx.op().getStart().getLine();
            int column = ctx.op().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en tipo: '"+typeE1+"' no comparable con tipo: '"+typeE2+"' @line: "+line+" @column: "+column));
            return null;
        }
        
        //'<' | '>' | '<=' | '>='
        //'==' | '!='
        //'&&' | '||'
        
        switch (op){
            case "<":
                if (!typeE1.equals("int")){
                    int line = ctx.op().getStart().getLine();
                    int column = ctx.op().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en tipo: '"+typeE1+"' no comparable '<' @line: "+line+" @column: "+column));
                    return null;
                }
                break;
            case ">":
                if (!typeE1.equals("int")){
                    int line = ctx.op().getStart().getLine();
                    int column = ctx.op().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en tipo: '"+typeE1+"' no comparable '>' @line: "+line+" @column: "+column));
                    return null;
                }
                break;
            case "<=":
                if (!typeE1.equals("int")){
                    int line = ctx.op().getStart().getLine();
                    int column = ctx.op().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en tipo: '"+typeE1+"' no comparable '<=' @line: "+line+" @column: "+column));
                    return null;
                }
                break;
            case ">=":
                if (!typeE1.equals("int")){
                    int line = ctx.op().getStart().getLine();
                    int column = ctx.op().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en tipo: '"+typeE1+"' no comparable '>=' @line: "+line+" @column: "+column));
                    return null;
                }
                break;
            case "==":
                break;
            case "!=":
                break;
            case "&&":
                if (!typeE1.equals("boolean")){
                    int line = ctx.op().getStart().getLine();
                    int column = ctx.op().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en tipo: '"+typeE1+"' no comparable '&&' @line: "+line+" @column: "+column));
                    return null;
                }
                break;
            case "||":
                if (!typeE1.equals("boolean")){
                    int line = ctx.op().getStart().getLine();
                    int column = ctx.op().getStart().getCharPositionInLine();
                    _errors.add(new Exception("Error en tipo: '"+typeE1+"' no comparable '||' @line: "+line+" @column: "+column));
                    return null;
                }
                break; 
        }
        
        
        
        Object[] returnO = {"boolean",""};
        return returnO; 
    }
    
    public Object visitExpMinus (ExpMinusContext ctx){
        Object obj = visit(ctx.expression());
        
        if (obj == null){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de expression @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_code = (Object[])obj;
        String type = (String) type_code[0];//guarda el tipo del expression
        String code = (String) type_code[1];//guarda el codigo intermedio del expression
        
        if (!type.equals("int")){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en tipo: '"+type+"' no aplicable '-' @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] returnO = {"int",""};
        return returnO;
    }
    
    public Object visitExpNot (ExpNotContext ctx){
        Object obj = visit(ctx.expression());
        
        if (obj == null){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de expression @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_code = (Object[])obj;
        String type = (String) type_code[0];//guarda el tipo del expression
        String code = (String) type_code[1];//guarda el codigo intermedio del expression
        
        if (!type.equals("boolean")){
            int line = ctx.expression().getStart().getLine();
            int column = ctx.expression().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en tipo: '"+type+"' no aplicable '!' @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] returnO = {"boolean",""};
        return returnO;
    }
    
    public Object visitExpPexp (ExpPexpContext ctx){
        return visit(ctx.expression());
    }
    
    public Object visitMethodCall (MethodCallContext ctx){
        String id = ctx.ID().getText();//nombre
        Method mt = _scopes.get(0).hasMethodDef(id);
        
        if (mt == null){
            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();
            _errors.add(new Exception("Error metodo '"+id+"' no definido @line: "+line+" @column: "+column));
            return null;
        }
        
        ArrayList<String> params = new ArrayList();
        for (ArgContext arg: ctx.arg()){
            Object obj = visit(arg);
            if (obj == null){
                int line = arg.getStart().getLine();
                int column = arg.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en definicion de parametro @line: "+line+" @column: "+column));
                return null;
            }
            
            Object[] type_code = (Object[])obj;
            String type = (String) type_code[0];//guarda el tipo del expression
            String code = (String) type_code[1];//guarda el codigo intermedio del expression
            params.add(type);
        }
        
        if (params.size() != mt.getParams().size()){
            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de parametros, se esperan "+mt.getParams().size()+"' parametros @line: "+line+" @column: "+column));
            return null;
        }
        
        int i = 0;
        for (Variable v: mt.getParams()){
            String typeParam = params.get(i);
            String typeVar = v.getVarType();
            if (typeVar.equals("struct")){
                typeVar += ((StructVar)v).getStructID().getStructID();
            }
            if (v.isArray()) typeVar += "array";
            
            if (!typeParam.equals(typeVar)){//si no son iguales
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en definicion de parametros, se esperaba "+typeVar+"', se obtuvo '"+typeParam+"' @line: "+line+" @column: "+column));
                return null;
            }
            i++;
        }
        
        
        
        Object[] returnO = {mt.getMetType(),""};
        return returnO;
    }
    
    public Object visitPlusOrMinus (PlusOrMinusContext ctx){
        if (ctx.multOrDiv() != null) return visitChildren(ctx);//retornamos mulOrDiv
        
        Object obj1 = visit(ctx.plusOrMinus());
        if (obj1 == null){
            int line = ctx.plusOrMinus().getStart().getLine();
            int column = ctx.plusOrMinus().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de plusOrMinus @line: "+line+" @column: "+column));
            return null;
        }
        
        Object obj2 = visit(ctx.multOrDiv());
        if (obj2 == null){
            int line = ctx.multOrDiv().getStart().getLine();
            int column = ctx.multOrDiv().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de multOrDiv @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_code1 = (Object[])obj1;
        String type1 = (String) type_code1[0];//guarda el tipo del expression
        String code1 = (String) type_code1[1];//guarda el codigo intermedio del expression
        
        Object[] type_code2 = (Object[])obj2;
        String type2 = (String) type_code2[0];//guarda el tipo del expression
        String code2 = (String) type_code2[1];//guarda el codigo intermedio del expression
        
        if (!type1.equals("int")){
            int line = ctx.plusOrMinus().getStart().getLine();
            int column = ctx.plusOrMinus().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de plusOrMinus no es de tipo int @line: "+line+" @column: "+column));
            return null;
        }
        
        if (!type2.equals("int")){
            int line = ctx.multOrDiv().getStart().getLine();
            int column = ctx.multOrDiv().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de multOrDiv no es tipo int @line: "+line+" @column: "+column));
            return null;
        }
        
        
        Object[] returnO = {"int",""};
        return returnO;
    }
    
    public Object visitMultOrDiv (MultOrDivContext ctx){
        if (ctx.getChildCount() <=1) return visitChildren(ctx);
        
        Object obj1 = visit(ctx.multOrDiv());
        if (obj1 == null){
            int line = ctx.multOrDiv().getStart().getLine();
            int column = ctx.multOrDiv().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de multOrDiv @line: "+line+" @column: "+column));
            return null;
        }
        
        Object obj2 = visit(ctx.pow());
        if (obj2 == null){
            int line = ctx.pow().getStart().getLine();
            int column = ctx.pow().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de pow @line: "+line+" @column: "+column));
            return null;
        }
        
        Object[] type_code1 = (Object[])obj1;
        String type1 = (String) type_code1[0];//guarda el tipo del expression
        String code1 = (String) type_code1[1];//guarda el codigo intermedio del expression
        
        Object[] type_code2 = (Object[])obj2;
        String type2 = (String) type_code2[0];//guarda el tipo del expression
        String code2 = (String) type_code2[1];//guarda el codigo intermedio del expression
        
        if (!type1.equals("int")){
            int line = ctx.multOrDiv().getStart().getLine();
            int column = ctx.multOrDiv().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de multOrDiv no es de tipo int @line: "+line+" @column: "+column));
            return null;
        }
        
        if (!type2.equals("int")){
            int line = ctx.pow().getStart().getLine();
            int column = ctx.pow().getStart().getCharPositionInLine();
            _errors.add(new Exception("Error en definicion de multOrDiv no es tipo int @line: "+line+" @column: "+column));
            return null;
        }
        
        
        Object[] returnO = {"int",""};
        return returnO;
    }
    
    public Object visitOp (OpContext ctx){
        return ctx.getText();
    }
    
    public Object visitUnaryMinus (UnaryMinusContext ctx){
        if (ctx.unaryMinus() != null){
            Object obj = visit(ctx.unaryMinus());
            if (obj == null){
                int line = ctx.unaryMinus().getStart().getLine();
                int column = ctx.unaryMinus().getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en definicion de unaryMinus @line: "+line+" @column: "+column));
                return null;
            }
        }else{
            Object obj = visit(ctx.atom());
            if (obj == null){
                int line = ctx.atom().getStart().getLine();
                int column = ctx.atom().getStart().getCharPositionInLine();
                _errors.add(new Exception("Error en definicion de atom @line: "+line+" @column: "+column));
                return null;
            }
        }
        
        
        Object[] returnO = {"int",""};
        return returnO;
        
    }
    
    public Object visitAtom (AtomContext ctx){
        if (ctx.plusOrMinus() != null) return visit(ctx.plusOrMinus());
        
        return visitChildren(ctx);
    }
    
    public Object visitBool_literal (Bool_literalContext ctx){
        Object[] returnO = {"boolean",ctx.getText()};
        return returnO;
    }
    
    public Object visitChar_literal (Char_literalContext ctx){
        Object[] returnO = {"char",ctx.getText()};
        return returnO;
    }
    
    public Object visitInt_literal (Int_literalContext ctx){
        Object[] returnO = {"int",ctx.getText()};
        return returnO;
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
