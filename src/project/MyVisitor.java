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
    private Scope _scopes;//ambientes
    private Stack<Exception> _errors;//errores
    
    public void initAll(){
        _types = new LinkedHashSet();
        _scopes = new Scope();
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
            
            StructDef sd = _scopes.hasStructDef(((StructDef) structDec[2]).getStructID());
            
            if (sd != null){
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error struct '"+sd.getStructID()+"' previamente definido @line: "+line+" @column: "+column));
                return null;
            }
            
            _scopes.getStructures().add((StructDef) structDec[2]);//agregamos structure
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
            Variable var = _scopes.hasVariableDef(varDec.getVarId());
            if (var != null){
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error variable definida anteriormente '"+varDec.getVarId()+"' @line: "+line+" @column: "+column));
                return null;
            }
            _scopes.getVars().add(varDec);//agregamos variable
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
            StructDef sd = _scopes.hasStructDef(id);
            if (sd == null){
                int line = ctx.getStart().getLine();
                int column = ctx.getStart().getCharPositionInLine();
                _errors.add(new Exception("Error tipo struct '"+id+"' no definido @line: "+line+" @column: "+column));
                return null;
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

        StructDef sd = _scopes.hasStructDef(((StructDef) structDec[2]).getStructID());

        if (sd != null){
            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();
            _errors.add(new Exception("Error struct '"+sd.getStructID()+"' previamente definido @line: "+line+" @column: "+column));
            return null;
        }

        _scopes.getStructures().add((StructDef) structDec[2]);//agregamos structure
        return structDec;
    }
    
    public Object visitStructDeclaration(StructDeclarationContext ctx){
        
        StructDef sd = _scopes.hasStructDef(ctx.ID().getText());//buscamos
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
        
        if (errores) return null;
        
        sd.updateSize();
        
        Object[] objR = {"struct", sd.getSize(), sd};//creamos el objeto de retorno
        return objR;
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
