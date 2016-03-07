
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
    
    private ArrayList<Variable> _vars;//variables definidas en este scope
    private ArrayList<Method> _methods;//metodos definidos en este scope
    private ArrayList<Parameter> _params;//tipo de variable definida para un metodo
    private ArrayList<ArrayList<Variable>> _struct;//arraylist de struct declaradas, se guarda cada variable del struct
    private ArrayList<StructVars> _structVars; //vinculacion de tipo struct "" al array anterior
    
    /**
     * Init Scope emtpy
     */
    public Scope(){
        _vars = new ArrayList();
        _methods = new ArrayList();
        _params = new ArrayList();
        _struct = new ArrayList();
        _structVars = new ArrayList();
    }
    
    /**
     * Init Scope
     * @param vr variables
     * @param mt methods
     * @param pr parameters
     */
    public Scope(ArrayList<Variable> vr, ArrayList<Method> mt, ArrayList<Parameter> pr, ArrayList<ArrayList<Variable>> st, ArrayList<StructVars> stv){
        this._vars = vr;
        this._methods = mt;
        this._params = pr;
        this._struct = st;
        this._structVars = stv;
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

    /**
     * @return the _struct
     */
    public ArrayList<ArrayList<Variable>> getStruct() {
        return _struct;
    }

    /**
     * @param _struct the _struct to set
     */
    public void setStruct(ArrayList<ArrayList<Variable>> _struct) {
        this._struct = _struct;
    }

    /**
     * @return the _structVars
     */
    public ArrayList<StructVars> getStructVars() {
        return _structVars;
    }

    /**
     * @param _structVars the _structVars to set
     */
    public void setStructVars(ArrayList<StructVars> _structVars) {
        this._structVars = _structVars;
    }
    
}
