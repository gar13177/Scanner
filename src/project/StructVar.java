package project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class StructVar extends Variable{
    private StructDef _structID;//nombre del tipo de struct
   

    public StructVar(String vID, String vType, int vSize, boolean vArray, int vASize) {
        super(vID, vType, vSize, vArray, vASize);
    }
   
    /**
     *
     * @param vID
     * @param str
     * @param vArray
     * @param vASize
     */
    public StructVar(String vID,StructDef str, boolean vArray, int vASize) {
        super(vID,"struct",str.getSize(),vArray,vASize);
        _structID = str;//agregamos el struct al que hace referencia
    }
    
    public StructVar(String vID,StructDef str) {
        super(vID,"struct",str.getSize());
        _structID = str;//agregamos el struct al que hace referencia
    }

    /**
     * @return the _structID
     */
    public StructDef getStructID() {
        return _structID;
    }

    /**
     * @param _structID the _structID to set
     */
    public void setStructID(StructDef _structID) {
        this._structID = _structID;
    }
    
    
    
    
    
    
}
