/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.LinkedHashSet;

/**
 *
 * @author Kevin
 */
public class StructDef extends LinkedHashSet<Variable>{
    private int _size = 0;//tamanio del struct
    private String _structID;//nombre del struct
    
    public StructDef(String sID){
        super();
        _structID = sID;
    }
    
    @Override
    public boolean add(Variable v){
        boolean canAdd = super.add(v);
        if (canAdd) setSize(getSize() + v.getTotalSize());
        return canAdd;
    }
    
    public void updateSize(){
        _size = 0;
        for (Variable v: this){
            _size += v.getTotalSize();
        }
    }
    
    public Variable hasVariable(String ID){
        for (Variable v: this){
            if (v.getVarId().equals(ID))
                return v;
        }
        return null;
    }
    
    public int offsetOfVar(String ID){
        int offset = 0;
        for (Variable v: this){
            if (v.getVarId().equals(ID)){
                return offset;
            }
            offset += v.getTotalSize();
        }
        return offset;
    }

    /**
     * @return the _size
     */
    public int getSize() {
        return _size;
    }

    /**
     * @param _size the _size to set
     */
    public void setSize(int _size) {
        this._size = _size;
    }

    /**
     * @return the _structID
     */
    public String getStructID() {
        return _structID;
    }

    /**
     * @param _structID the _structID to set
     */
    public void setStructID(String _structID) {
        this._structID = _structID;
    }
    
}
