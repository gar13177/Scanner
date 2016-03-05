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
    private int _metType;
    
    /**
     * Init Method empty
     */
    public Method(){
        
    }
    
    /**
     * Init Method
     * @param mI method name
     * @param mT method Type
     */
    public Method(String mI, int mT){
        this._metID = mI;
        this._metType = mT;
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

    /**
     * @return the _metType
     */
    public int getMetType() {
        return _metType;
    }

    /**
     * @param _metType the _metType to set
     */
    public void setMetType(int _metType) {
        this._metType = _metType;
    }
    
    @Override
    public String toString(){
        return _metID + " - "+ _metType;
    }
    
    
}
