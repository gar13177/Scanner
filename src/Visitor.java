
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
                    System.out.println(_error);
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
        
       
        
        if (ctx.getChild(0) instanceof StructDeclarationContext){//si es un structDeclaration
            String state = visit(ctx.getChild(0));//visitamos struct Declaration
            if (!state.equals(_type.get(5))){//si no es error esta bien definido
                return ctx.getChild(0).getChild(1).getText();//tomamos el nodo ID en structDeclaration y regresamos su valor
            }
            _error.push(new Exception("Variable struct "+ctx.getChild(0).getChild(1).getText()+" error"));//variable definida en el contexto
            return _type.get(5);
            //si no es void, hubo error
            
        }else{//si no es structDeclaration, pero tiene struct, regresamos id del nuevo struct
            if (!type.equals("struct")){//si no es un struct
                return type;
            }
            return ctx.getChild(1).getText();//regresamos struct ID!
        }
        
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
        
        
        if (!ctx.getChild(3).getText().equals("}")){//quiere decir que tiene parametros
            int i = 3;
            while (!ctx.getChild(i).getText().equals("}")){//mientras no sea el ultimo
                if (!ctx.getChild(i).getText().equals(",")){//si no es una coma
                    if (ctx.getChild(i).getChild(0) instanceof StructDeclarationContext){// struct dentro de struct
                        _error.push(new Exception("Struct declared into other struct"));
                        return _type.get(5);
                    }
                    if (visit(ctx.getChild(i)).equals(_type.get(5))){//si es error
                        _error.push(new Exception("Error in variable declaration in struct "+name));
                        return _type.get(5);
                    }
                }
                i++;
            }
        }
        
        
        //el struct esta bien definido
        //suponemos que las nuevas variables estan guardadas en el scope superior
        
        Scope temp = _scope.pop();//tomamos el scope
        _scope.peek().getStruct().add(temp.getVars());//agregamos las variables al array
        int index = _type.indexOf(name);//tomamos el indice de la nueva variable
        _scope.peek().getStructVars().add(new StructVars(index,_scope.peek().getStruct().size()-1));//vinculamos con el ultimo
        
        
        return name;//retornamos void
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
                
                if (!ctx.getChild(i).getText().equals(",")){//nos aseguramos que no sea una coma
                    if (!visit(ctx.getChild(i)).equals(_type.get(0)) && !visit(ctx.getChild(i)).equals("array")){//si el parametro no es correcto y no es array

                        _error.push(new Exception("Error in Parameter in node "+i));//stack de errores
                        return _type.get(5);//retorna error ante el primer error encontrado
                    }else if (visit(ctx.getChild(i)).equals(_type.get(0))){//si es correcto, debemos agregarlo a la relacion

                        //declaramos un nuevo parametro
                        Parameter temp = new Parameter(ctx.getChild(i).getChild(1).getText(),_type.indexOf(ctx.getChild(i).getChild(0).getText()),indexOfMethod);
                        
                        
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
                        Parameter temp = new Parameter(ctx.getChild(i).getChild(1).getText(),_type.indexOf(ctx.getChild(i).getChild(0).getText()),true,indexOfMethod);
                        
                        
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
        
        int lengthOfTypes = _type.size();//tamano de los tipos
        
        _scope.push(new Scope());//nos metemos en el ambito
        
        if (!tempVar.isEmpty()){//si existen parametros, agregamos las variables al scope actual
            _scope.peek().setVars(tempVar);//agregamos las variables definidas como parametros
        }
        
        if (visit(ctx.getChild(ctx.getChildCount()-1)).equals(_type.get(0))){//si es tipo void, todo esta bien
            _scope.pop();//eliminamos ambito 
            
            Method m = _scope.peek().getMethods().get(_scope.peek().getMethods().size()-1);//tomamos el ultimo metodo
            if (!m.isReturn()){//quiere decir que no tiene return
                if (m.getMetType() != 0){//si no es void, hay error
                    _error.push(new Exception("Method "+m.getMetID()+" return type "+_type.get(m.getMetType())+" not declared"));
                    return _type.get(5);
                }
            }
            
            //eliminamos todos los tipos que pudieron haber creado
            while (_type.size() > lengthOfTypes){//mientras sea mas grande que su estado inicial
                _type.remove(_type.size()-1);//quitamos el ultimo tipo
            }
            
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
                
                if (visit(ctx.getChild(i)).equals(_type.get(5))){//si esta en error
                    _error.push(new Exception("Error in Block node "+i));
                    //System.out.println("error");
                    return _type.get(5);//retornamos tipo error
                }
                
                /**
                 * por el momento supongo que si retorna un error explicito, hay error.
                 * de lo contrario todo esta bien
                 */
                
                i++;
            }
        }
        return _type.get(0);//si no tiene nada definido, void
    }
    
    @Override
    public String visitStatement( StatementContext ctx){
        if (ctx.getChild(0).getText().equals("if")){//si el primer hijo es un if
            if (!visit(ctx.getChild(2)).equals(_type.get(3))){//si no es tipo booleano
                _error.push(new Exception("Expression in 'if' not boolean"));
                return _type.get(5);
            }
            
            if (!visit(ctx.getChild(4)).equals(_type.get(0))){//problemas con el bloque
                _error.push(new Exception("Block error in 'if'"));
                return _type.get(5);
            }
            
            if (ctx.getChildCount()>5){//quiere decir que tiene else
                if (!visit(ctx.getChild(6)).equals(_type.get(0))){//si no es void
                    _error.push(new Exception("Else Block error in 'if'"));
                    return _type.get(5);
                }
                
            }
            
            return _type.get(0);
            
        }else if (ctx.getChild(0).getText().equals("while")){//si es un while
            if (!visit(ctx.getChild(2)).equals(_type.get(3))){//si no es tipo booleano
                _error.push(new Exception("Expression in 'while' not boolean"));
                return _type.get(5);
            }
            
            if (!visit(ctx.getChild(4)).equals(_type.get(0))){//problemas con el bloque
                _error.push(new Exception("Block error in 'while'"));
                return _type.get(5);
            }
            
            return _type.get(0);
            
            
        }else if (ctx.getChild(0).getText().equals("return")){
            String type = "";
            if (ctx.getChildCount()>2){//existe expression
                type = visit(ctx.getChild(1));//tomamos expression del return
                
                //revisar retorno type
                Stack<Scope> temp = new Stack();
                temp.addAll(_scope);
                String methodType = getMethodReturn(temp);//retornammos el tipo del metodo
                if (!methodType.equals(type)){//si el metodo no es igual al expression
                    _error.push(new Exception("Method and return type mismatch"));//no concuerda tipo
                    return _type.get(5);
                }
                
                //como es correcto el tipo
                _scope = setMethodReturn(_scope);//actualizamos scope con true para el metodo
                return _type.get(0);//retornamos void
            }else{
                //revisar retorno void
                Stack<Scope> temp = new Stack();
                temp.addAll(_scope);
                String methodType = getMethodReturn(temp);//retornammos el tipo del metodo
                if (!methodType.equals(_type.get(0))){//si el metodo no es tipo void
                    _error.push(new Exception("Method and return type mismatch"));//no concuerda tipo
                    return _type.get(5);
                }
                
                //como es correcto el tipo
                _scope = setMethodReturn(_scope);//actualizamos scope con true para el metodo
                return _type.get(0);//retornamos void
                
            }            
            //no existe error y  tiene un tipo definido   
            
            
        }else if (ctx.getChild(0) instanceof LocationContext){//si es una asignacion, se revisa primero
            String locationType = visit(ctx.getChild(0));//tomamos el tipo de location
            String expressionType = visit(ctx.getChild(2));//tomamos el tipo de expressionType
            
            if (locationType.equals(expressionType)){//si son variables del mismo tipo
                return _type.get(0);//retornamos void para la asignacion
            }
            
            //como es error
            _error.push(new Exception("Location and expression type mismatch"));//no concuerda tipo
            return _type.get(5);
        }
        
        //si no es alguno de los anteriores, quedan:
        //methodCall, block, expression dejando la posiblidad de retornar su tipo
        if (ctx.getChildCount()>1){//como es mas de un hijo, no solo es ';'
            return visit(ctx.getChild(0));//retornamos tipo de mehtod call
        }
        return _type.get(0);//retornamos void por default
    }
    
    /**
     * retorna el tipo del primer metodo encontrado en los ambitos
     * @param st stack(Scope)
     * @return String
     */
    public String getMethodReturn(Stack<Scope> st){
        if (st.size()==0) return _type.get(5);//si no tiene elementos, retornar error
        
        Scope sc = st.pop();//tomamos el ultimo scope definido
        
        if (sc.getMethods().size()>0){//quiere decir que tiene metodos definidos
            //dado que un bloque es tiene return del ultimo metodo identificado, retornamos el return
            int index = sc.getMethods().get(sc.getMethods().size()-1).getMetType();//tomamos el tipo del ultimo metodo
            return _type.get(index);//retornamos el tipo de la variable            
        }
            
        return getMethodReturn(st);
    }
    
    /**
     * modifica el stack de tal forma que actualiza si un metodo tiene un retorno
     * como definimos un boolean que es si un metodo tiene al menos un retorno, 
     * modificamos el mismo para asignarle true
     * 
     * si el metodo ya tiene true, se realiza de todos modos
     * 
     * se realiza tras validar que existe dicho metodo
     * @param st stack de tipo scope
     * @return stack de tipo scope
     */
    public Stack<Scope> setMethodReturn(Stack<Scope> st){
        Scope sc = st.pop();//obtenemos el ultimo scope
        if (sc.getMethods().size()>0){//si tiene al menos un metodo, ese es el que buscamos
            sc.getMethods().get(sc.getMethods().size()-1).setReturn(true);//asignamos true al metodo
            st.push(sc);//volvemos a combinarlo
            return st;//retornamos toda la pila
        }
        
        //si no tiene metodos definidos
        st = setMethodReturn(st);//visitamos cada uno de los scopes restantes, suponiendo que es correcto
        st.push(sc);//agregamos el ultimo pop
        
        return st;
    }
    
    public String visitExpression(ExpressionContext ctx){
        if (ctx.getChildCount()<=1 ){//si no tiene mas de un hijo
            return visit(ctx.getChild(0));//retorna la visita del primer hijo
        }else if (ctx.getChild(0) instanceof ExpressionContext){//si lo primero es expression
            //debe tener 3 hijos
            String type1 = visit(ctx.getChild(0));//tipo de primer expression
            String type2 = visit(ctx.getChild(2));//tipo de segundo expression
            String optype = visit(ctx.getChild(1));//tipo de operacion
            if (optype.equals(_type.get(1))){
                if (type1.equals(_type.get(1)) && type2.equals(_type.get(1))){//si ambos son ints
                    return _type.get(3);//retorna boolean porque la expresion es boolean
                }
                _error.push(new Exception("Error in expression1, expression2, not int type"));
                return _type.get(5);//retornar error
            }else if(optype.equals(_type.get(0))){//si es void, solo es necesario que ambos sean iguales
                if (type1.equals(type2)){
                    return _type.get(3);//retorna tipo booleano
                }
                _error.push(new Exception("Error in expression1, expression2, not same type"));
                return _type.get(5);//retornar error
            }else if(optype.equals(_type.get(3))){//si es boolean, es comparacion boolean
                if (type1.equals(_type.get(3)) && type2.equals(_type.get(3))){//si ambos son ints
                    return _type.get(3);//retorna boolean porque la expresion es boolean
                }
                _error.push(new Exception("Error in expression1, expression2, not boolean type"));
                return _type.get(5);//retornar error
            }
        }else if (ctx.getChild(0).getText().equals("-")){
            if (visit(ctx.getChild(1)).equals(_type.get(1))){//si el tipo de retorno es int
                return _type.get(1);//retornamos tipo int
            }
            _error.push(new Exception("Error in expression, int expected"));
            return _type.get(5);//retornar error
        }else if (ctx.getChild(0).getText().equals("!")){
            if (visit(ctx.getChild(1)).equals(_type.get(3))){//si la expresion es de tipo booleano
                return _type.get(3);//retornamos tipo booleano
            }
            _error.push(new Exception("Error in expression, boolean expected"));
            return _type.get(5);//retornar error
        }else if (ctx.getChild(0).getText().equals("(")){
            return visit(ctx.getChild(1));//retornamos el valor de la expresion entre parentesis
        }
        return _type.get(5);//retornamos error por default
    }
    
    public String visitOp(OpContext ctx){
        if (ctx.getChild(0) instanceof Rel_opContext){
            return _type.get(1);//retorno tipo int
        }else if (ctx.getChild(0) instanceof Eq_opContext){
            return _type.get(0);//retorno void porque puede ser cualquier cosa
        }else{
            return _type.get(3);//retorno boolean
        }
    }
    
    public String visitLocation(LocationContext ctx){
        if (ctx.getChildCount()>1){//quiere decir que tiene mas cosas
            Stack<Scope> temp = new Stack();
            temp.addAll(_scope);//creamos temporal del mismo tipo que ambientes

            Variable var = getVarType(ctx.getChild(0).getText(),temp);
            if (var == null){//quiere decir que no esta definida
                _error.push(new Exception("Variable not defined in Location"));
                return _type.get(5);//retornamos error
            }
            int index = var.getVarType();
            String type = _type.get(index);//tomamos el tipo
            
            if (ctx.getChild(1).getText().equals("[")){//si tiene esto
                if (!var.isIsArray()){//si no es array
                    _error.push(new Exception("Variable not defined as array"));
                    return _type.get(5);//retornamos error
                }
                String expressionType = visit(ctx.getChild(2));//tomamos valor de expression
                if (!expressionType.equals(_type.get(1))){//quiere decir que no es un entero
                    _error.push(new Exception("Expression in variable array isn't int type"));
                    return _type.get(5);
                }
                
                if (ctx.getChildCount()>4){//quiere decir que tiene otro location
                    //type ya tiene el tipo de la variable
                    
                    //este es nuestro paso base, en el cual es definicion de id como variable
                    //si existe un location, hay que seguir buscando
                    Stack<Scope> tempStack = new Stack();
                    tempStack.addAll(_scope);//temporal de scopes
                    return recursiveLocation2(index,tempStack,(LocationContext) ctx.getChild(ctx.getChildCount()-1));
                    
                }
                
                return type;//retonamos tipo sencillo, ya que llamamos a[], por lo que retorna uno
                
                //de lo contrario si es 
            }else if (ctx.getChild(1).getText().equals(".")){//caso en el que se llame a un location
                if (var.isIsArray()){//error porque se debe llamar un elemento
                    _error.push(new Exception("Variable declared as array, new parameter found"));
                    return _type.get(5);
                }
                
                //de lo contario, nuevamente llamamos recursive location
                //tenemos el tipo de la variable global
                Stack<Scope> tempStack = new Stack();
                tempStack.addAll(_scope);//temporal de scopes
                return recursiveLocation2(index,tempStack,(LocationContext) ctx.getChild(ctx.getChildCount()-1));
            }
            
        }
        
        Stack<Scope> temp = new Stack();
        temp.addAll(_scope);//creamos temporal del mismo tipo que ambientes
        
        Variable var = getVarType(ctx.getChild(0).getText(),temp);
        if (var == null){//quiere decir que no esta definida
            _error.push(new Exception("Variable not defined in Location"));
            return _type.get(5);//retornamos error
        }
        int index = var.getVarType();
       
        String type = _type.get(index);//tomamos el tipo
        if (var.isIsArray()){//si es array
            return type+"array";//amplificamos el tipo a array por si no coordina con los demas
        }
        return type;//retornar type de lo contrario        
    }
    
    public Variable getVarType(String varID, Stack<Scope> st){//pedimos el id de la variable y el scope
        if (st.size()==0) return null;//si no tiene elementos, retornar error
        
        Scope sc = st.pop();//tomamos el ultimo scope definido
        
        if (sc.getVars().size()>0){//quiere decir que tiene variables definidas
            //buscamos la variable en ese scope
            Variable temp = new Variable();
            temp.setVarId(varID);//asignamos un varId
            if (sc.getVars().contains(temp)){//si la variable esta contenida en ese scope, retornamos esa variable
                int index = sc.getVars().indexOf(temp);//obtenemos el indice del mismo
                return sc.getVars().get(index);//retornamos variable definida
            }
                       
        }
            
        return getVarType(varID, st);//retornamos recursividad del metodo
    }
    
    /**
     * 
     * @param type tipo del id de primera definicion de este location
     * @param st todos los ambientes (pila)
     * @param ctx siguiente .location si existe!!
     * @return 
     */
    public String recursiveLocation2 (int type, Stack<Scope> st, LocationContext ctx){
        //casos base
        if (st.size()==0) return _type.get(5);//retornamos error si ya no hay scope
        
        Scope sc = st.pop();//tomamos el ultimo scope
        if (sc.getStructVars().isEmpty()) return recursiveLocation2(type,st,ctx);//simplemente bajamos un nivel
        
        ArrayList<StructVars> structVars = new ArrayList();//structvars temporal
        for (int i = 0; i< sc.getStructVars().size(); i++){//recorremos todo el array de vinculaciones de ese ambito
            if (sc.getStructVars().get(i).getStructID() == type){//si es del mismo tipo lo agregamos
                structVars.add(sc.getStructVars().get(i));
            }     
        }
        
        if (structVars.isEmpty()) return recursiveLocation2 (type, st, ctx);//si no estaba definido en este scope, tal vez esta definido en el siguiente
        
        //de lo contrario, ya tenemos el indice de las tablas de variables, por lo que podemos buscarlas
        if (structVars.size()>1){//como no espero que sea mas de una tabla
            _error.push(new Exception("Struct defined multiple times"));
            return _type.get(5);
        }
        

        
        ArrayList<Variable> structVariable = new ArrayList();//creo un arreglo temporal que identifica las variables definidas
        structVariable.addAll(sc.getStruct().get(structVars.get(0).getStructVars()));//tomo el arraylist de variables definidas

        String id = ctx.getChild(0).getText();//sabemos que location siempre va a tener un id, lo tomamos
        Variable temp = new Variable();
        temp.setVarId(id);//creamos una temporal de tipo variable
        
        if (!structVariable.contains(temp)){//si no esta contenida retornamos error
            _error.push(new Exception("Variable not defined in struct"));
            return _type.get(5);
        }
        
        int index = structVariable.indexOf(temp);
        temp = structVariable.get(index);//ya tenemos la variable !
        
        //ahora toca el caso de error
        
        if (ctx.getChildCount() <=1 ){//quiere decir que no lo llamaron como array o con otro location
            if (temp.isIsArray()){//si es array
                return _type.get(temp.getVarType())+"array";          
            }
            return _type.get(temp.getVarType());//retornamos el tipo
        }
        
        if (ctx.getChild(1).getText().equals("[")){//quiere decir que lo llamaron como array
            if (temp.isIsArray()){//si esta declarado como array,  todo bien
                if (ctx.getChildCount()<=4){//quiere decir que no tiene otro location
                    if (!visit(ctx.getChild(2)).equals(_type.get(1))){//si no es int, error
                        _error.push(new Exception("Expression not defined as int"));
                        return _type.get(5);
                    }
                    return _type.get(temp.getVarType());//retornamos el tipo de la variable
                }else{//esto quiere decir que tiene otro location
                    type = temp.getVarType();//nuevo tipo de evaluacion
                    st.push(sc);//volvemos a meter este ambito para que sea evaluado
                    ctx = (LocationContext) ctx.getChild(ctx.getChildCount()-1);//asignamos un nuevo location
                    return recursiveLocation2(type,st,ctx);//we go deeper
                    
                }
                
            }else {
                _error.push(new Exception("Variable not defined as array"));
                return _type.get(5);
            }
            
        }else if (ctx.getChild(1).getText().equals(".")){//quiere decir que hay location
            if (temp.isIsArray()){//si es array y no se busco un elemento, hay error
                _error.push(new Exception("Variable declared as array, new parameter found"));
                return _type.get(5);
            }
            
            //de lo contrario no es array y se busca un nuevo location
            
            type = temp.getVarType();//nuevo tipo de evaluacion
            st.push(sc);//volvemos a meter este ambito para que sea evaluado
            ctx = (LocationContext) ctx.getChild(ctx.getChildCount()-1);//asignamos un nuevo location
            return recursiveLocation2(type,st,ctx);//we go deeper
        }
        
        return _type.get(5);//retornar error por defecto
    }
    
    public String visitMethodCall(MethodCallContext ctx){
        String idMethod = ctx.getChild(0).getText();
        
        //suponemos que los metodos siempre van a estar definidos en la base de la pila
        Scope baseScope = _scope.get(0);//tomamos el scope base
        ArrayList<Method> methods = baseScope.getMethods();//metodos definidos
        Method mt = null;
        int index = 0;
        for (int i = 0; i< methods.size(); i++){
            if (methods.get(i).getMetID().equals(idMethod)){//si existe el metodo
                mt = methods.get(i);//asignamos el metodo
                index = i;
            }
        }
        
        if (mt == null){
            _error.push(new Exception("Method "+idMethod+" not defined"));
            return _type.get(5);
        }
        
        //de lo contrario, el metodo existe y ya tenemos el index
        
        ArrayList<Parameter> params = new ArrayList();
        ArrayList<Parameter> baseParams = baseScope.getParams();
        
        for (Parameter p: baseParams){//para cada parametro
            if (p.getMetIndex() == index){
                params.add(p);//obtenemos todos los parametros de ese metodo
            }
        }
        
        if (!ctx.getChild(2).getText().equals(")")){//si no, quiere decir que tiene parametros
            int i = 2, j=0;//defino punteros
            while (!ctx.getChild(i).getText().equals(")")){//mientras no sea el parentesis
                if (!ctx.getChild(i).getText().equals(",")){//no aseguramos que no sea una coma
                    String paramType = visit(ctx.getChild(i));//visitamos el hijo
                    if (paramType.equals(_type.get(5))){//si es error
                        _error.push(new Exception("Error in parameter in node "+i));//
                    }
                    
                    Parameter p = params.get(j);
                    String paramtype = _type.get(p.getVarType());
                    if (p.isIsArray()) paramtype = paramtype +"array";//obtenemos el caso que sea array
                    
                    if (!paramType.equals(paramtype)){//si no son del mismo tipo
                        _error.push(new Exception("Error in parameter, type mismatch in node "+i));
                        return _type.get(5);
                    }
                    j++;//incremento j para seguir verificando                
                }
                i++;
            }
        }else if (params.size()>0){//quiere decir que el metodo lleva parametro y no se declararon
            System.out.println(params);
            _error.push(new Exception("Method named without parameters"));
            return _type.get(5);//retornamos error
        }
        
        
        return _type.get(mt.getMetType());
    }
    
    public String visitArg(ArgContext ctx){
        return visitChildren(ctx);//como arg tira expression
    }
  
    public String visitCalc_op(Calc_opContext ctx){
        return visitChildren(ctx);//solo va a plusor minus
    }
    
    public String visitPlusOrMinus(PlusOrMinusContext ctx){
        if (ctx.getChildCount()>1){//si es mayor que 1 hace las sumas
            if (visit(ctx.getChild(0)).equals(_type.get(1)) && visit(ctx.getChild(2)).equals(_type.get(1))){
                //si ambos son enteros
                return _type.get(1);//independiente de suma o resta, retorna un int
            }
            _error.push(new Exception("Declared operation not int type"));
        }
        
        return visitChildren(ctx);//como es uno,  es multordiv
    }
    
    public String visitMultOrDiv(MultOrDivContext ctx){
        if (ctx.getChildCount()>1){//si es mayor que 1 hace las multiplicaciones
            if (visit(ctx.getChild(0)).equals(_type.get(1)) && visit(ctx.getChild(2)).equals(_type.get(1))){
                //si ambos son enteros
                return _type.get(1);//independiente de suma o resta, retorna un int
            }
            _error.push(new Exception("Declared operation not int type"));
        }
        
        return visitChildren(ctx);
    }
    
    public String visitPow (PowContext ctx){
        return visitChildren(ctx);//retornamos unaryminus
    }
    
    public String visitUnaryMinus( UnaryMinusContext ctx){
        if (ctx.getChildCount()>1){
            if (visit(ctx.getChild(1)).equals(_type.get(1))){//si es entero
                return _type.get(1);
            }
            
            _error.push(new Exception("UnaryMinus not defined as int"));
            return _type.get(5);
        }
        
        return visitChildren(ctx);//retornamos atom
    }
    
    public String visitAtom( AtomContext ctx){
        if (ctx.getChildCount()>1){//quiere decir que tiene parentesis
            return visit(ctx.getChild(1));//plusorminus
        }
        
        return visitChildren(ctx);//retorna por defecto
    }
    
    public String visitLiteral (LiteralContext ctx){
        if (ctx.getChild(0) instanceof Int_literalContext){
            return _type.get(1);//retorna tipo entero
        }else if (ctx.getChild(0) instanceof Char_literalContext){
            return _type.get(2);//retorna char
        }
        
        return _type.get(3);//retornamos boolean por defecto
    }


}
