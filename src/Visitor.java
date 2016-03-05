
import grammar.ANTLR.decafBaseVisitor;
import java.util.ArrayList;
import java.util.Stack;
import grammar.ANTLR.decafParser.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class Visitor extends decafBaseVisitor<String> {
    
    private ArrayList<String> _type;//tipos predefinidos
    private Stack<Scope> _scope;//ambientes
    
    public void initTypeScope(){
        _scope = new Stack();
        _type = new ArrayList();
        
        _type.add("void"); //0
        _type.add("int"); //1
        _type.add("char"); //2
        _type.add("boolean"); //3
        _type.add("struct"); //4
        _type.add("error"); //5
        
        _scope.push(new Scope(new ArrayList<Variable>(), new ArrayList<Method>(), new ArrayList<Parameter>()));
        
    }
    
    public String visitProgram(ProgramContext ctx){
        initTypeScope();//inicializamos componentes
        
        
        //String declaration = visit(ctx.getChild(4));
        if (!ctx.getChild(3).getText().equals("}")){
            int i = 3;
            while (!ctx.getChild(i).getText().equals("}")){//mientras no sea el ultimo
                if (!visit(ctx.getChild(i)).equals(_type.get(0))){
                    
                    return _type.get(5);//retorna error ante el primer error encontrado
                }
                i++;
            }
        }       
        System.out.println(_scope);
        return _type.get(0);
    }
    
    public String visitDeclaration(DeclarationContext ctx){
        return visitChildren(ctx);//retorna el valor de sus hijos
    }
    
    public String visitVarDeclaration(VarDeclarationContext ctx){
        if (ctx.NUM()==null){
            String type = ctx.getChild(0).getText();
            int index = _type.indexOf(type);
            
            
            String name = ctx.getChild(1).getText();
            System.out.println(index+name);
            
            if (_scope.peek().getVars().contains(name))//error de variable definida
                return _type.get(5);
            
            _scope.peek().getVars().add(new Variable(name, index));//actualizar pila
          
            return "void";
        }else{
            return "array";
        }
        //return "void";
    }
    
    
    
    
}
