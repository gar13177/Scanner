package project;


import java.util.LinkedHashSet;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class Method {
    private String _metID;
    private String _metType;
    private boolean _return;//identifica si ya se ha puesto return valido
    private LinkedHashSet<Variable> _params;
    private LinkedHashSet<Variable> _vars;//variables definidas en este scope
    private LinkedHashSet<StructDef> _structures;//estructuras definidas
    
    /**
     * Init Method empty
     */
    public Method(){
        _params = new LinkedHashSet();
        _vars = new LinkedHashSet();
        _structures = new LinkedHashSet();
        
    }
    
    /**
     * Init Method
     * @param mI method name
     * @param mT method Type
     */
    public Method(String mI, String mT){
        this._metID = mI;
        this._metType = mT;
        this._return = false;
        _params = new LinkedHashSet();
        _vars = new LinkedHashSet();
        _structures = new LinkedHashSet();
    }

    /**
     * @return the _metID
     */
    public String getMetID() {
        return _metID;
    }

    /**
     * @param _metID the _metID to set
     */
    public void setMetID(String _metID) {
        this._metID = _metID;
    }

   
    
    @Override
    public String toString(){
        return _metID + " - "+ getMetType();
    }

    /**
     * @return the _return
     */
    public boolean isReturn() {
        return _return;
    }

    /**
     * @param _return the _return to set
     */
    public void setReturn(boolean _return) {
        this._return = _return;
    }

    /**
     * @return the _metType
     */
    public String getMetType() {
        return _metType;
    }

    /**
     * @param _metType the _metType to set
     */
    public void setMetType(String _metType) {
        this._metType = _metType;
    }

    /**
     * @return the _params
     */
    public LinkedHashSet<Variable> getParams() {
        return _params;
    }

    /**
     * @param _params the _params to set
     */
    public void setParams(LinkedHashSet<Variable> _params) {
        this._params = _params;
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
    
    public void setParamsAsVars(){
        for (Variable v: _params){
            v.setInitialized(true);
            _vars.add(v);
        }
    }
    
    public int getVarsSize(){
        int size = 0;
        for (Variable v: _vars){
            size += v.getTotalSize();
        }
        return size;
    }
    
}
