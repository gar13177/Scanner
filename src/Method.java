
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
    private int _metType;
    private boolean _return;//identifica si ya se ha puesto return valido
    
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
        this._return = false;
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
    
    @Override
    public boolean equals(Object o){
        Method m = (Method)o;
        boolean r = this._metID.equals(m.getMetID());
        r = r && this._metType == m.getMetType();
        return r;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this._metID);
        hash = 17 * hash + this._metType;
        return hash;
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
    
    
}
