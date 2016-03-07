
import grammar.ANTLR.decafBaseVisitor;
import java.util.ArrayList;
import java.util.Stack;
import grammar.ANTLR.decafParser.*;
import static java.lang.Integer.parseInt;
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
    private Stack<Exception> _error;//errores
    
    public void initTypeScope(){
        _scope = new Stack();
        _error = new Stack();
        _type = new ArrayList();
        
        _type.add("void"); //0
        _type.add("int"); //1
        _type.add("char"); //2
        _type.add("boolean"); //3
        _type.add("struct"); //4 no se usa solo como struct
        _type.add("error"); //5
        
        _scope.push(new Scope());//creamos el primer ambiente
        
    }
    
    @Override
    public String visitProgram(ProgramContext ctx){
        initTypeScope();//inicializamos componentes
        
        
        //String declaration = visit(ctx.getChild(4));
        if (!ctx.getChild(3).getText().equals("}")){
            int i = 3;
            while (!ctx.getChild(i).getText().equals("}")){//mientras no sea el ultimo
                if (!visit(ctx.getChild(i)).equals(_type.get(0))){
                    
                    _error.push(new Exception("Error in Program in node "+i));//stack de errores
                    return _type.get(5);//retorna error ante el primer error encontrado
                }
                i++;
            }
        }
        return _type.get(0);
    }
    
    public String visitDeclaration(DeclarationContext ctx){
        return visitChildren(ctx);//retorna el valor de sus hijos
    }
    
    
    public String visitVarType(VarTypeContext ctx){
        //verificamos el tipo de la variable
        String type = ctx.getChild(0).getText();//tomamos la primera palabra del tipo
        
        if (!type.equals("struct")){//si no es un struct
            return type;
        }
        
        if (ctx.getChild(0) instanceof StructDeclarationContext){//si es un structDeclaration
            String state = visit(ctx.getChild(0));//visitamos struct Declaration
            if (state.equals(_type.get(0))){//si es igual a void esta bien definido
                return ctx.getChild(0).getChild(1).getText();//tomamos el nodo ID en structDeclaration y regresamos su valor
            }
            _error.push(new Exception("Variable struct "+ctx.getChild(0).getChild(1).getText()+" error"));//variable definida en el contexto
            //si no es void, hubo error
            
        }else{//si no es structDeclaration, pero tiene struct, regresamos id del nuevo struct
            return ctx.getChild(1).getText();//regresamos struct ID!
        }
        
        return _type.get(5);//retornamos error
    }
    
    public String visitVarDeclaration(VarDeclarationContext ctx){
        
        //siempre hay varType y ID, por lo que siempre se revisa que no exista
        String type = visit(ctx.getChild(0));//visitamos varType
        int index = 0;
        if (_type.contains(type)&& !type.equals("error")){//si esta contenido y no es error
             index = _type.indexOf(type);//indice del tipo
        }else{//si es un struct, tendria que estar definido como otra variable
            //ademas, si no cumple con lo anterior podria ser error
            _error.push(new Exception("Variable type error"));
            return _type.get(5);
        }
        
        String name = ctx.getChild(1).getText();//nombre de la variable
        
        Variable temp = new Variable(name, index);


        if (_scope.peek().getVars().contains(temp)){//error de variable definida
            _error.push(new Exception("Variable "+name+" already defined"));//variable definida en el contexto
            return _type.get(5);
        }//else if (_scope.peek().getMethods().contains(name)){
        //    _error.push(new Exception("Variable "+name+" defined as method"));//variable con nombre de metodo
        //    return _type.get(5);
        //}
        
        if (ctx.NUM()==null){//no es array

            _scope.peek().getVars().add(new Variable(name, index));//actualizar pila
          
            return _type.get(0);
        }
        
        String num = ctx.getChild(3).getText();//tomamos el tamano del array
        try{
            int num1 = parseInt(num);
            if (num1 <= 0 ){//longitud de array mayor a 0
                _error.push(new Exception("NUM length in array "+name+" not suitable"));//variable con nombre de metodo
                return _type.get(5);
            }
        }catch (Exception e){
            //do nothing
            _error.push(new Exception("NUM length in array "+name+" not suitable"));//variable con nombre de metodo
        }
        
        //ya sabemos que es array
        _scope.peek().getVars().add(new Variable(name, index,true));//actualizar pila de variable con array
        
        
        
        
        return _type.get(0);//retornar void por default?
    }
    
    public String visitStructDeclaration(StructDeclarationContext ctx){
        // 'struct' id '{' (varDeclaration)* '}'
        
        //sabemos que struct ya esta escrito para que sea correcto
        //podriamos tener un struct definido por un struct?
        //como no se, y podria estar correcto, agregamos struct id a los tipos
        
        String name = ctx.getChild(1).getText();
        if (_type.contains(name)){//si el struct ya esta definido, error
            _error.push(new Exception("Struct already defined "+name));
            return _type.get(5);//retornamos error
        }
        
        //como el tipo struct no esta definido, lo agregamos a las variables
        int length = _type.size();//guardamos el tamano del tipo previo a la creacion del struct
        _type.add(name);//definimos un struct
        //ahora, las variables definidas dentro del struct deben ser nuevas
        _scope.push(new Scope());//creamos un nuevo ambiente para definir variables
        String state = visitChildren(ctx);//visitamos los hijos
        if (state.equals(_type.get(5))){//si el struct esta mal definido
            //como no se cuantos struct pudo haber creado, elimino todo lo nuevo
            while (_type.size()!= length){//mientras no se hayan eliminado las nuevas creaciones
                _type.remove(-1);//quitamos el ultimo de la lista
            }
            
            //ahora eliminamos el scope
            _scope.pop();
            
            _error.push(new Exception("Struct definition error "+name));
            return _type.get(5);//retornamos error
        }
        
        //el struct esta bien definido
        //suponemos que las nuevas variables estan guardadas en el scope superior
        
        /**
         * falta arreglar cuando un struct esta definido en un struct
         * tambien si hay un array dentro del struct
         */
        Scope temp = _scope.pop();//tomamos el scope
        _scope.peek().getStruct().add(temp.getVars());//agregamos las variables al array
        int index = _type.indexOf(name);//tomamos el indice de la nueva variable
        _scope.peek().getStructVars().add(new StructVars(index,_scope.peek().getStruct().size()-1));//vinculamos con el ultimo
        
        
        return _type.get(0);//retornamos void
    }
    
    public String visitMethodType(MethodTypeContext ctx){
        return ctx.getText();//retornamos el texto que indica el tipo
    }
    
    public String visitMethodDeclaration(MethodDeclarationContext ctx){
        String type = visit(ctx.getChild(0));//visitamos el tipo de metodo
        if (!_type.contains(type)){//si no esta declarado el tipo
            _error.push(new Exception("Error in method type "+type));
            return _type.get(5);//retornamos error
        }
        
        int index = _type.indexOf(type);//retornamos indice del tipo
        
        String methodId = ctx.getChild(1).getText();//tomamos id del metodo
        
        if (_scope.peek().getMethods().contains(new Method(methodId, index))){//creamos un nuevo metodo y revisamos si esta contenido
            //si esta contenido, es error
            _error.push(new Exception("Method  already defined "+methodId));
            return _type.get(5);//retornamos error
        }
        
        //si no esta contenido, podemos agregarlo
        
        _scope.peek().getMethods().add(new Method(methodId, index));//agregamos el nuevo metodo
        ArrayList<Variable> tempVar = new ArrayList();//variables definidas para el siguiente scope
        
        if (!ctx.getChild(3).getText().equals(")")){//si contiene parametros, realizamos lo siguiente:
            int indexOfMethod = _scope.peek().getMethods().size()-1;//apuntamos al ultimo metodo agregado

            int i = 3;//apuntamos a donde inician los parametros
  
            while (!ctx.getChild(i).getText().equals(")")){//mientras no sea el parentesis
                
                if (!ctx.getChild(i).getText().equals(",")){//no aseguramos que no sea una coma
                    if (!visit(ctx.getChild(i)).equals(_type.get(0)) && !visit(ctx.getChild(i)).equals("array")){//si el parametro no es correcto y no es array

                        _error.push(new Exception("Error in Parameter in node "+i));//stack de errores
                        return _type.get(5);//retorna error ante el primer error encontrado
                    }else if (visit(ctx.getChild(i)).equals(_type.get(0))){//si es correcto, debemos agregarlo a la relacion

                        //declaramos un nuevo parametro
                        Parameter temp = new Parameter(ctx.getChild(i).getChild(1).getText(),_type.indexOf(ctx.getChild(i).getChild(0)),indexOfMethod);
                        
                        
                        if (_scope.peek().getParams().contains(temp)){//si ya hay un parametro definido asi
                            _error.push(new Exception("Parameter already defined in node "+i));//agregamos error

                            //FALTA REMOVER LO QUE YA SE HA HECHO
                            //suponemos que como tiene error no es necesario seguir guardando
                            return _type.get(5);//regresamos error
                        }

                        //si no esta definido, podemos agregarlo
                        _scope.peek().getParams().add(temp);//agregamos parametro
                        tempVar.add(new Variable(temp));//construimos set de variables

                    }else{//ya sabemos que no tiene error y no es void, entonces es array

                        //creamos parametro de tipo array
                        Parameter temp = new Parameter(ctx.getChild(i).getChild(1).getText(),_type.indexOf(ctx.getChild(i).getChild(0)),true,indexOfMethod);
                        
                        
                        if (_scope.peek().getParams().contains(temp)){//si ya hay un parametro definido asi
                            _error.push(new Exception("Parameter already defined in node "+i));//agregamos error

                            //FALTA REMOVER LO QUE YA SE HA HECHO
                            //suponemos que como tiene error no es necesario seguir guardando
                            return _type.get(5);//regresamos error
                        }

                        //si no esta definido, podemos agregarlo
                        _scope.peek().getParams().add(temp);//agregamos parametro
                        tempVar.add(new Variable(temp));//construimos set de variables

                    }
                }
                i++;
            }
        }//de lo contrario no tiene parametros y lo dejamos pasar
        
        _scope.push(new Scope());//nos metemos en el ambito
        
        if (tempVar.size() != 0){//si existen parametros, agregamos las variables al scope actual
            _scope.peek().setVars(tempVar);//agregamos las variables definidas como parametros
        }
        
        if (visit(ctx.getChild(ctx.getChildCount()-1)).equals(_type.get(0))){//si es tipo void, todo esta bien
            _scope.pop();//eliminamos ambito 
            return _type.get(0);//retornamos tipo void
        }
        
        //si no es tipo void
        _error.push(new Exception("Error in block definition, method "+methodId));//agregamos error
        
        return _type.get(5);//retornamos error
    }
    
    public String visitParameter (ParameterContext ctx){
        if (ctx.getChildCount()>2){//quiere decir que es array
            return "array";
        }
        return _type.get(0);//retornamos void
    }
    
    public String visitBlock(BlockContext ctx){
        if(!ctx.getChild(1).getText().equals("}")){//si tiene algo definido, evaluamos todo
            int i = 1;
            while (!ctx.getChild(i).getText().equals("}")){//mientras no sea el ultimo
                i++;
            }
        }
        return _type.get(0);//si no tiene nada definido, void
    }
    
    
}
