
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
public class Variable {
    private String _varId;
    private int _varType;
    private boolean _isArray;
    
    /**
     * Init Variable empty
     */
    public Variable(){
        
    }
    
    /**
     * Init Variable
     * @param vI variable name
     * @param vT variable type
     */
    public Variable(String vI, int vT, boolean iA){
        this._varId = vI;
        this._varType = vT;
        this._isArray = iA;
    }
    
    public Variable(String vI, int vT){
        this._varId = vI;
        this._varType = vT;
        this._isArray = false;
    }
    
    public Variable(Parameter pr){
        this._varId = pr.getVarId();
        this._varType = pr.getVarType();
        this._isArray = pr.isIsArray();
    }

    /**
     * @return the _varId
     */
    public String getVarId() {
        return _varId;
    }

    /**
     * @param _varId the _varId to set
     */
    public void setVarId(String _varId) {
        this._varId = _varId;
    }

    /**
     * @return the _varType
     */
    public int getVarType() {
        return _varType;
    }

    /**
     * @param _varType the _varType to set
     */
    public void setVarType(int _varType) {
        this._varType = _varType;
    }
    
    @Override
    public String toString(){
       return _varId + " - "+_varType+" - "+_isArray;
       
    }
    
    @Override
    public boolean equals(Object o){
        Variable v = (Variable)o;
        boolean r = this._varId.equals(v.getVarId());
        
        return r;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this._varId);
        hash = 37 * hash + this._varType;
        return hash;
    }

    /**
     * @return the _isArray
     */
    public boolean isIsArray() {
        return _isArray;
    }

    /**
     * @param _isArray the _isArray to set
     */
    public void setIsArray(boolean _isArray) {
        this._isArray = _isArray;
    }
    
}
