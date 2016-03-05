
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class Scope {
    
    private ArrayList<Variable> _vars;
    private ArrayList<Method> _methods;
    private ArrayList<Parameter> _params;
    
    /**
     * Init Scope emtpy
     */
    public Scope(){}
    
    /**
     * Init Scope
     * @param vr variables
     * @param mt methods
     * @param pr parameters
     */
    public Scope(ArrayList<Variable> vr, ArrayList<Method> mt, ArrayList<Parameter> pr){
        this._vars = vr;
        this._methods = mt;
        this._params = pr;
    }

    /**
     * @return the _vars
     */
    public ArrayList<Variable> getVars() {
        return _vars;
    }

    /**
     * @param _vars the _vars to set
     */
    public void setVars(ArrayList<Variable> _vars) {
        this._vars = _vars;
    }

    /**
     * @return the _methods
     */
    public ArrayList<Method> getMethods() {
        return _methods;
    }

    /**
     * @param _methods the _methods to set
     */
    public void setMethods(ArrayList<Method> _methods) {
        this._methods = _methods;
    }

    /**
     * @return the _params
     */
    public ArrayList<Parameter> getParams() {
        return _params;
    }

    /**
     * @param _params the _params to set
     */
    public void setParams(ArrayList<Parameter> _params) {
        this._params = _params;
    }
    
    @Override
    public String toString(){
        String val = "";
        val += "VARIABLE\n";
        val += "id - name - type\n";
        int i = 0;
        for (Variable vr: _vars){
            val += i+ " - "+vr+"\n";
            i++;
        }
        
        val += "\n\n";
        
        val+= "METHOD\n";
        val+= "id - name - type\n";
        i = 0;
        for (Method mt: _methods){
            val += i+" - "+mt+"\n";
            i++;
        }
        
        val += "\n\n";
        
        val+= "PARAMETER\n";
        val+= "id - var_type - method_id\n";
        i = 0;
        for (Parameter pr: _params){
            val += i+" - "+pr;
            i++;
        }
                
        
        return val;
    }
    
}
