/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class Parameter extends Variable {
    private int _metIndex;
    
    /**
     * Init Parameter emtpy
     */
    public Parameter(){
        
    }
    
    /**
     * Init Parameter
     * @param vT variable type
     * @param mI method Index
     */
    public Parameter(String vI, int vT, boolean iA, int mI){
        this.setVarId(vI);
        this.setVarType(vT);
        this.setIsArray(iA);
        this._metIndex = mI;
    }
    
    /**
     * Init Parameter
     * @param vT variable Type
     * @param mI method Index
     */
    public Parameter(String vI, int vT, int mI){
        this.setVarId(vI);
        this.setVarType(vT);
        this.setIsArray(false);
        this._metIndex = mI;
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
        return this.getVarType() + " - " + _metIndex;
    }
    
    public boolean equals(Object o){
        Parameter pr = (Parameter)o;
        boolean r = this._metIndex == pr.getMetIndex();
        r = r && this.getVarId().equals(pr.getVarId());
        return r;
        
    }

    
}
