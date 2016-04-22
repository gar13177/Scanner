/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.LinkedHashMap;
import java.util.Stack;

/**
 *
 * @author Kevin
 */
public class IntermediateCodeBuilder {
    private String method_name;
    private String temp_var = "t";
    private int temp_var_number = 0;
    private int while_count =0;
    private int if_count=0;
    
    private Stack<String> while_count_index = new Stack();//aqui meto el indice de la etiqueta
    private Stack<String> if_count_index = new Stack();//aqui meto el indice de la etiqueta
    
    private Stack<String> to_use_temp = new Stack();//variables 
    private LinkedHashMap<String,String> recicle_temp = new LinkedHashMap();//t1 -> exp de 3 direcciones
    private String last_used_temp = "";
    
    private int offset = 0;
    
    private String equals ="";
    private String left = "";
    private String right = "";
    
    
    private String code = "";//codigo final
    
    private String to_build_code = "";//codigo en construccion
    
    public void buildReturn(){
        to_build_code += "lp[0] = "+last_used_temp+"\n";
        to_build_code += "b "+method_name+"_end_p:\n";
    }
    
    public void buildReturnVoid(){
        to_build_code += "b "+method_name+"_end_p:\n";
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
    }
    
    public void setOffset(String off){
        offset = Integer.parseInt(off);
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
        temp_var_number++;*/
        last_used_temp = "gp["+last_used_temp+"]";
    }
    
    public void setLocalPointer(){
        /*String str = temp_var+""+temp_var_number+" = lp["+last_used_temp+"]";
        to_build_code += str+"\n";//cargamos la operacion al codigo
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        temp_var_number++;*/
        
        last_used_temp = "lp["+last_used_temp+"]";
    }
    
    
    public void flush(){
        method_name = "";
        temp_var_number = 0;
        while_count =0;
        if_count=0;
        to_build_code = "";
    }
    
    public void newMethod(String mn){
        flush();
        method_name = mn;
        to_build_code = mn+"_init\n";
    }
    
    public void buildMethod(){
        to_build_code += method_name+"_end_p:\n";
        to_build_code += method_name+"_end\n\n\n";
        code += to_build_code;
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
        String str = last_used_temp +" = NOT "+last_used_temp+"\n";
        //t1 = not t1
        String if_str = "if "+last_used_temp +", b "+method_name+"_while_end_"+while_count_index.peek()+"\n";
        
        to_build_code += str+if_str;
        
    }
    
    public void endWhile(){
        String loop = "b "+method_name+"_while_"+while_count_index.peek();
        String str = method_name+"_while_end_"+while_count_index.pop();
        to_build_code += loop+"\n"+str+":\n";
        while_count --;
    }
    
    public void newIf(){
        to_build_code += last_used_temp +" = NOT "+last_used_temp+"\n";
        String if_prelude = "if "+last_used_temp+",";
        String if_str = "b "+method_name+"_else_"+if_count;
        String index = ""+if_count;
        while (to_build_code.contains(if_str)){
            if_str += if_count;
            index += if_count;
        }
        
        to_build_code += if_prelude+" "+if_str+":\n";
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
        String op = temp_var+""+temp_var_number+" = "+integer;
        to_build_code += op+"\n";//cargamos la operacion al codigo
        
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        temp_var_number++;
    }
    
    public void setCharLiteral(String character){
        //t1 = 3
        String op = temp_var+""+temp_var_number+" = "+character;
        to_build_code += op+"\n";//cargamos la operacion al codigo
        
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        temp_var_number++;
    }
    
    public void setBoolLiteral(String bool){
        //t1 = 3
        String op = temp_var+""+temp_var_number+" = "+bool;
        to_build_code += op+"\n";//cargamos la operacion al codigo
        
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        temp_var_number++;
    }
    
    public void buildOperation (String op){
        //t1 = 3
        String str = temp_var+""+temp_var_number+" = "+left+" "+op +" "+right;
        to_build_code += str+"\n";//cargamos la operacion al codigo
        
        last_used_temp = temp_var+""+temp_var_number;//cargamos la ultima variable usada
        temp_var_number++;
    }
    
    public void buildEqual(){
        String st = equals +" = "+left+"\n";
        to_build_code += st;
    }
    
    public void toMinus(){
        to_build_code += last_used_temp +" = - "+last_used_temp+"\n";
    }
    
    public void toNot(){
        to_build_code += last_used_temp +" = NOT "+last_used_temp+"\n";
    }
    
    public void pushParam(){
        to_build_code += "push_param "+last_used_temp+"\n";
    }
    
    public void callMethod(String methodName){
        to_build_code += temp_var+""+temp_var_number+" = call "+methodName+"_init\n";
        last_used_temp = temp_var+""+temp_var_number;
        temp_var_number++;
    }
    
    public String toString(){
        return code;
    }    
    
}
