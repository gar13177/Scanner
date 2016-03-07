/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class StructVars {
    private int _structID;
    private int _structVars;
    
    public StructVars(){}
    
    /**
     * Init StructVars 
     * @param sI struct ID defined in types
     * @param sV struct vars defined in structs
     */
    public StructVars(int sI, int sV){
        this._structID = sI;
        this._structVars = sV;
    }

    /**
     * @return the _structID
     */
    public int getStructID() {
        return _structID;
    }

    /**
     * @param _structID the _structID to set
     */
    public void setStructID(int _structID) {
        this._structID = _structID;
    }

    /**
     * @return the _structVars
     */
    public int getStructVars() {
        return _structVars;
    }

    /**
     * @param _structVars the _structVars to set
     */
    public void setStructVars(int _structVars) {
        this._structVars = _structVars;
    }
    
}
