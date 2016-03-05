/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class Parameter {
    private int _varType;
    private int _metIndex;
    
    /**
     * Init Parameter emtpy
     */
    public Parameter(){
        
    }
    
    /**
     * Init Parameter
     * @param vT variable Type
     * @param mI method Index
     */
    public Parameter(int vT, int mI){
        this._metIndex = mI;
        this._varType = vT;
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

    /**
     * @return the _metIndex
     */
    public int getMetIndex() {
        return _metIndex;
    }

    /**
     * @param _metIndex the _metIndex to set
     */
    public void setMetIndex(int _metIndex) {
        this._metIndex = _metIndex;
    }
    
    @Override
    public String toString(){
        return _varType + " - " + _metIndex;
    }
}
