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
    public Variable(String vI, int vT){
        this._varId = vI;
        this._varType = vT;
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
       return _varId + " - "+_varType;
    }
    
}
