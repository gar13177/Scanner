package project;


import java.util.ArrayList;
import java.util.LinkedHashSet;

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
    
    private LinkedHashSet<Variable> _vars;//variables definidas en este scope
    private LinkedHashSet<Method> _methods;//metodos definidos en este scope
    private LinkedHashSet<StructDef> _structures;//estructuras definidas
    
    /**
     * Init Scope emtpy
     */
    public Scope(){
        _vars = new LinkedHashSet();
        _methods = new LinkedHashSet();
        _structures = new LinkedHashSet();
    }
    
    public Scope(Scope sc){
        _vars = sc.getVars();
        _methods = sc.getMethods();
        _structures = sc.getStructures();
    }
    
    

    
    @Override
    public String toString(){
        String val = "";
        val += "VARIABLE\n";
        val += "id - name - type\n";
        int i = 0;
        for (Variable vr: getVars()){
            val += i+ " - "+vr+"\n";
            i++;
        }
        
        val += "\n\n";
        
        val+= "METHOD\n";
        val+= "id - name - type\n";
        i = 0;
        for (Method mt: getMethods()){
            val += i+" - "+mt+"\n";
            i++;
        }
        
        val += "\n\n";
        
       
                
        
        return val;
    }

    /**
     * @return the _vars
     */
    public LinkedHashSet<Variable> getVars() {
        return _vars;
    }

    /**
     * @param _vars the _vars to set
     */
    public void setVars(LinkedHashSet<Variable> _vars) {
        this._vars = _vars;
    }

    /**
     * @return the _methods
     */
    public LinkedHashSet<Method> getMethods() {
        return _methods;
    }

    /**
     * @param _methods the _methods to set
     */
    public void setMethods(LinkedHashSet<Method> _methods) {
        this._methods = _methods;
    }

    /**
     * @return the _structures
     */
    public LinkedHashSet<StructDef> getStructures() {
        return _structures;
    }

    /**
     * @param _structures the _structures to set
     */
    public void setStructures(LinkedHashSet<StructDef> _structures) {
        this._structures = _structures;
    }
    
    public StructDef hasStructDef(String ID){
        for (StructDef sd: _structures){
            if (sd.getStructID().equals(ID))
                return sd;
        }
        
        return null;
    }
    
    public Variable hasVariableDef(String ID){
        for (Variable v: _vars){
            if (v.getVarId().equals(ID)){
                return v;
            }
        }
        return null;
    }
    
    public int offsetOfVar(String ID){
        int offset = 0;
        for (Variable v: _vars){
            if (v.getVarId().equals(ID)){
                return offset;
            }
            offset += v.getTotalSize();
        }
        return offset;
    }
    
    
    
    public Method hasMethodDef(String ID){
        for (Method mt: _methods){
            if (mt.getMetID().equals(ID)){
                return mt;
            }
        }
        return null;
    }

    
}
