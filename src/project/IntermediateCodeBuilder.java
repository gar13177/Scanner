/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Stack;

/**
 *
 * @author Kevin
 */
public class IntermediateCodeBuilder {
    private String method_name;
    private String temp_var = "r";
    private int minimum_register = 4;
    private int maximum_register = 13;
    private int param_size = 0;
    private int param_extend = 56;
    private int sp_actual = 0;//posicion del sp respecto del inicio de la subrutina
    private boolean has_att = false;//
    private int temp_var_number = minimum_register;
    private int while_count =0;
    private int if_count=0;
    private boolean needs_value = false;
    private String heather = ".text\n.align 2\n .global main\n.type main, %function\nmain:\nstmfd sp!,{lr}\nbl main_init\n"+
            "mov r3,#0\nmov r0,#0\nldmfd sp!,{lr}\nbx lr\n";
    
    private Stack<String> return_values = new Stack();
    private Stack<String> strings_call = new Stack();
    
    private Stack<String> while_count_index = new Stack();//aqui meto el indice de la etiqueta
    private Stack<String> if_count_index = new Stack();//aqui meto el indice de la etiqueta
    
    private Stack<String> to_use_temp = new Stack();//variables 
    private LinkedHashMap<String,String> recicle_temp = new LinkedHashMap();//t1 -> exp de 3 direcciones
    private LinkedHashSet<String> used_registers = new LinkedHashSet();
    private String last_used_temp = "";
    
    private int offset = 0;
    
    private String equals ="";
    private String left = "";
    private String right = "";
    
    
    private String code = "";//codigo final
    
    private String to_build_code = "";//codigo en construccion
    
    public void setNewReturn(){
        return_values.push(method_name+"_return_value");
    }
    
    public void buildReturn(){
        getNewRegister();//creamos un nuevo registro libre
        to_build_code += "ldr "+temp_var+""+temp_var_number+",="+method_name+"_return_value\n";
        to_build_code += "str "+last_used_temp+",["+temp_var+""+temp_var_number+"]\n";
        to_build_code += "b "+method_name+"_end_p\n";
    }
    
    public void buildReturnVoid(){
        to_build_code += "b "+method_name+"_end_p\n";
    }
    
    public void pushTemp(String temp){
        to_use_temp.push(temp);
    }
    
    public String getLastUsedTemp(){
        return last_used_temp;
    }
    
    public void pushTempActual(){
        to_use_temp.push(last_used_temp);
    }
    
    public String popTemp(){
        return to_use_temp.pop();
    }
    
    public void popTempActual(){
        last_used_temp = to_use_temp.pop();
    }
    
    public void setOffset(int off){
        offset = off;
        
        if (offset < param_size){
            int posicion_relativa = sp_actual+param_extend+(param_size-offset)-4;
            String op = "add "+temp_var+""+temp_var_number+",sp,#"+posicion_relativa;
            to_build_code += op+"\n";//cargamos la operacion al codigo
        }else if (offset - param_size > sp_actual){
            int posicion_relativa = offset - param_size - sp_actual+4;//sumo 4 porque si piden la direccion sp[30], el elemento ocupara otros 4 bytes
            String op = "sub sp, sp, #"+posicion_relativa+"\n";
            sp_actual += posicion_relativa;//cambiamos la posicion actual del sp
            op += "add "+temp_var+""+temp_var_number+",sp,#4";//me quede a una posicion de la que quiero
            to_build_code += op+"\n";//cargamos la operacion al codigo
        }else{
            int posicion_relativa = sp_actual - (offset-param_size);
            String op = "add "+temp_var+""+temp_var_number+",sp,#"+posicion_relativa;
            to_build_code += op+"\n";//cargamos la operacion al codigo
        }
        
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        getNewRegister();
        
    }
    
    public void setOffset(String off){
        setOffset(Integer.parseInt(off));
    }
    
    public void addOffset(int off){
        offset += off;
    }
    
    public void addOffset(String off){
        offset += Integer.parseInt(off);
    }
    
    public void setGlobalPointer(){
        /*String str = temp_var+""+temp_var_number+" = gp["+last_used_temp+"]";
        to_build_code += str+"\n";//cargamos la operacion al codigo
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        getNewRegister();*/
        getNewRegister();//obtenemos un registro vacio
        String str = "ldr "+temp_var+""+temp_var_number+",=the_global_variables\n";
        
        str += "add "+temp_var+""+temp_var_number+","+last_used_temp+"\n";
        to_build_code += str;
        
        if (needs_value){//
            to_build_code += "ldr "+temp_var+""+temp_var_number+",["+temp_var+""+temp_var_number+"]\n";
        }
        
        last_used_temp = temp_var+""+temp_var_number;//"gp["+last_used_temp+"]";
        getNewRegister();
    }
    
    public void setLocalPointer(){
        /*String str = temp_var+""+temp_var_number+" = lp["+last_used_temp+"]";
        to_build_code += str+"\n";//cargamos la operacion al codigo
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        getNewRegister();*/
        
                
        if (needs_value){//
            to_build_code += "ldr "+last_used_temp+",["+last_used_temp+"]\n";
        }
    }
    
    
    public void flush(){
        method_name = "";
        temp_var_number = minimum_register;
        while_count =0;
        if_count=0;
        to_build_code = "";
        param_size = 0;
        has_att = false;
    }
    
    public void newMethod(String mn){
        flush();
        method_name = mn;
        to_build_code = mn+"_init:\n";
        to_build_code += "push {lr,r0-r12}\n";
    }
    
    public void buildMethod(){
        to_build_code += method_name+"_end_p:\n";
        to_build_code += "add sp, sp,#"+sp_actual+"\n";
        to_build_code += "pop {lr,r0-r12}\n";
        if (param_size > 0){
            to_build_code += "add sp, sp,#"+param_size+"\n";
        }
        to_build_code += "mov pc, lr\n";
        //to_build_code += method_name+"_end\n\n\n";
        code += to_build_code+"\n\n";
    }
    
    public void newWhile(){
        String method = method_name+"_while_"+while_count;
        String index = ""+while_count;
        while (to_build_code.contains(method)){
            method += while_count;
            index += while_count;//sumo otro
            
        }
        to_build_code += method+":\n";
        while_count_index.push(index);
        while_count ++;
    }
    
    public void meanWhile(){
        toNot();//remplaza la siguiente linea
        //String str = last_used_temp +" = NOT "+last_used_temp+"\n";
        //t1 = not t1
        String if_str = "cmp "+last_used_temp +",#1\n"
                +"beq "+method_name+"_while_end_"+while_count_index.peek()+"\n";
        
        to_build_code += if_str;
        
    }
    
    public void endWhile(){
        String loop = "b "+method_name+"_while_"+while_count_index.peek();
        String str = method_name+"_while_end_"+while_count_index.pop();
        to_build_code += loop+"\n"+str+":\n";
        while_count --;
    }
    
    public void newIf(){
        toNot();//to not remplaza  linea siguiente
        //to_build_code += last_used_temp +" = NOT "+last_used_temp+"\n";
        String if_prelude = "cmp "+last_used_temp+",#1\n";
        String if_str = "beq "+method_name+"_else_"+if_count;
        String index = ""+if_count;
        while (to_build_code.contains(if_str)){
            if_str += if_count;
            index += if_count;
        }
        
        to_build_code += if_prelude+""+if_str+"\n";
        if_count_index.push(index);
        if_count ++;
        
        //if a, b metodo_if_0
    }
    
    public void newElse(){
        String final_jump = "b "+method_name+"_if_end_"+if_count_index.peek();
        String else_jump = method_name+"_else_"+if_count_index.peek();
        to_build_code += final_jump+"\n";
        to_build_code += else_jump+":\n";
                
    }
    
    public void endIf(){
        String final_jump = method_name+"_if_end_"+if_count_index.pop()+":\n";
        to_build_code += final_jump+"\n";
        if_count--;
    }
    
    public void setLastAsEq(){
        equals = last_used_temp;
        
    } 
    public void setLastAsLeft(){
        left = last_used_temp;
    } 
    public void setLastAsRight(){
        right = last_used_temp;
    }
    
    public void setIntLiteral(String integer){
        //t1 = 3
        String op = "ldr "+temp_var+""+temp_var_number+", ="+integer;
        to_build_code += op+"\n";//cargamos la operacion al codigo
        
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        getNewRegister();
    }
    
    public void setCharLiteral(String character){
        //t1 = 3
        String op = temp_var+""+temp_var_number+" = "+character;
        to_build_code += op+"\n";//cargamos la operacion al codigo
        
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        getNewRegister();
    }
    
    public void setBoolLiteral(String bool){
        
        String op = "";
        //t1 = 3
        switch (bool){
            case "true":
                op = "mov "+temp_var+""+temp_var_number+",#1";
                break;
            case "false":
                op = "mov "+temp_var+""+temp_var_number+",#0";
                break;
            default:
                System.out.println("booleano: "+bool);
                op = temp_var+""+temp_var_number+" = "+bool;
                break;
        }
        to_build_code += op+"\n";//cargamos la operacion al codigo
        
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        getNewRegister();
    }
    
    public void buildOperation (String op){
        //t1 = 3
        String str = "";
        switch (op){
            case "+":
                str = "add "+temp_var+""+temp_var_number+","+left+","+right+"\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;
            case "*":
                str = "mul "+temp_var+""+temp_var_number+","+left+","+right+"\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;
            case "-":
                str = "sub "+temp_var+""+temp_var_number+","+left+","+right+"\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;
                //break;
            case "==":
                str = "cmp "+left+","+right+"\n";
                str += "moveq "+temp_var+""+temp_var_number+",#1\n";
                str += "movne "+temp_var+""+temp_var_number+",#0\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;  
            case "!=":
                str = "cmp "+left+","+right+"\n";
                str += "moveq "+temp_var+""+temp_var_number+",#0\n";
                str += "movne "+temp_var+""+temp_var_number+",#1\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;
            case "<=":
                str = "cmp "+left+","+right+"\n";
                str += "movle "+temp_var+""+temp_var_number+",#1\n";
                str += "movgt "+temp_var+""+temp_var_number+",#0\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;
            case ">=":
                str = "cmp "+left+","+right+"\n";
                str += "movge "+temp_var+""+temp_var_number+",#1\n";
                str += "movlt "+temp_var+""+temp_var_number+",#0\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;
            case ">":
                str = "cmp "+left+","+right+"\n";
                str += "movgt "+temp_var+""+temp_var_number+",#1\n";
                str += "movle "+temp_var+""+temp_var_number+",#0\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;
            case "<":
                str = "cmp "+left+","+right+"\n";
                str += "movlt "+temp_var+""+temp_var_number+",#1\n";
                str += "movge "+temp_var+""+temp_var_number+",#0\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;
            case "||":
                str = "orr "+temp_var+""+temp_var_number+","+left+","+right+"\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;   
            case "&&":
                str = "and "+temp_var+""+temp_var_number+","+left+","+right+"\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break; 
             
            default:
                System.out.println("operacion: "+op);
                str = temp_var+""+temp_var_number+" = "+left+" "+op +" "+right+"\n";
                //to_build_code += str+"\n";//cargamos la operacion al codigo
                break;
        }
        to_build_code += str;
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        getNewRegister();
    }
    
    public void buildEqual(){
        String st = "str "+left+",["+equals +"]\n";
        to_build_code += st;
    }
    
    public void toMinus(){
        to_build_code += "neg "+last_used_temp+","+last_used_temp +"\n";
    }
    
    public void toNot(){
        to_build_code += "cmp "+last_used_temp +",#0\n";
        to_build_code += "moveq "+last_used_temp+",#1\n";
        to_build_code += "movne "+last_used_temp+",#0\n";
    }
    
    public void pushParam(){
        to_build_code += "push {"+last_used_temp+"}\n";
    }
    
    public void callMethod(String methodName){
        to_build_code += "bl "+methodName+"_init\n";
        to_build_code += "ldr "+temp_var+""+temp_var_number+",="+methodName+"_return_value\n";
        to_build_code += "ldr "+temp_var+""+temp_var_number+",["+temp_var+""+temp_var_number+"]\n";
        last_used_temp = temp_var+""+temp_var_number;
        getNewRegister();
    }
    
    public String toString(){
        return code;
    }  
    
    public void getNewRegister(){
        temp_var_number = minimum_register;
        
        
        
        while (to_use_temp.contains(temp_var+temp_var_number)
                || (temp_var+temp_var_number).equals(equals)
                || (temp_var+temp_var_number).equals(left)
                || (temp_var+temp_var_number).equals(right)
                || (temp_var+temp_var_number).equals(last_used_temp)
                || to_use_temp.contains("lp["+temp_var+temp_var_number+"]")
                || ("lp["+temp_var+temp_var_number+"]").equals(equals)
                || ("lp["+temp_var+temp_var_number+"]").equals(left)
                || ("lp["+temp_var+temp_var_number+"]").equals(right)
                || ("lp["+temp_var+temp_var_number+"]").equals(last_used_temp)
                ||to_use_temp.contains("gp["+temp_var+temp_var_number+"]")
                || ("gp["+temp_var+temp_var_number+"]").equals(equals)
                || ("gp["+temp_var+temp_var_number+"]").equals(left)
                || ("gp["+temp_var+temp_var_number+"]").equals(right)
                || ("gp["+temp_var+temp_var_number+"]").equals(last_used_temp)
                ){
            temp_var_number+=1;
        }
    }
    
    public void finishBuilding(){
        code = heather+"\n"+code;
    }
    
    public void buildReturnValues(){
        code+=".data\n" +
                ".align 2\n";
        while (!return_values.empty()){
            code += return_values.pop()+":\t.word 0\n";
        }
        
        code += "the_global_variables:\n";
    }
    
    public void buildStringValue(){
        code+=".data\n" +
                ".align 2\n";
        int i = 0;
        while (!strings_call.empty()){
            code += "string_label"+i+":\t.asciz \""+strings_call.pop()+"\"\n";
            i++;
        }
    }

    /**
     * @return the needs_value
     */
    public boolean isNeeds_value() {
        return needs_value;
    }

    /**
     * @param needs_value the needs_value to set
     */
    public void setNeeds_value(boolean needs_value) {
        this.needs_value = needs_value;
    }
    
    public void addNewString(String string){
        string = string.substring(1, string.length()-1);
        strings_call.push(string);
    }
    
    public void setNewPrint(boolean has_param){
        String str = "";
        if (has_param)
            str = "mov r1,"+left+"\n";
        str += "ldr r0,=string_label"+(strings_call.size()-1)+"\n";
        str += "bl printf\n";
        to_build_code += str;
    }

    /**
     * @return the param_size
     */
    public int getParam_size() {
        return param_size;
    }

    /**
     * @param param_size the param_size to set
     */
    public void setParam_size(int param_size) {
        this.param_size = param_size;
        if (param_size >0) has_att = true;
    }
    
}
