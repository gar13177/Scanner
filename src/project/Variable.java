package project;


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
    protected String _varId;//nombre de la variable
    protected String _varType;//tipo de la variable
    protected int _size;//tamanio de la variable
    
    protected boolean _array;//verdadero si es array
    protected int _arraySize;//tamanio del array
    
    protected int _totalSize;//tamanio de array * tamanio de objeto
    
    protected boolean _initialized;//identifica si ya se ha inicializado la variable
    
     
    /**
     * Constructor
     * @param vID nombre de la variable
     * @param vType string de tipo de variable 'int' char, boolean (no struct)
     * @param vSize tamanio del tipo de variable
     * @param vArray boolean si es array o no
     * @param vASize tamanio del array si es array
     */
    public Variable(String vID, String vType, int vSize, boolean vArray, int vASize){
        this._varId = vID;
        this._varType = vType;
        this._size = vSize;
        this._array = vArray;
        this._arraySize = vASize;
        this._totalSize = _arraySize*_size;
        this._initialized = false;
    }
    
    public Variable(String vID, String vType, int vSize){
        this._varId = vID;
        this._varType = vType;
        this._size = vSize;
        this._array = false;
        this._arraySize = 0;
        this._totalSize = _size;
        this._initialized = false;
    }
    
    public Variable(){}
    

   
    
    @Override
    public String toString(){
       return getVarId() + " - "+getVarType()+" - "+isArray();
       
    }
    
    @Override
    public boolean equals(Object o){
        Variable v = (Variable)o;
        boolean r = this.getVarId().equals(v.getVarId());
        return r;
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
    public String getVarType() {
        return _varType;
    }

    /**
     * @param _varType the _varType to set
     */
    public void setVarType(String _varType) {
        this._varType = _varType;
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
     * @return the _array
     */
    public boolean isArray() {
        return _array;
    }

    /**
     * @param _array the _array to set
     */
    public void setArray(boolean _array) {
        this._array = _array;
    }

    /**
     * @return the _arraySize
     */
    public int getArraySize() {
        return _arraySize;
    }

    /**
     * @param _arraySize the _arraySize to set
     */
    public void setArraySize(int _arraySize) {
        this._arraySize = _arraySize;
    }

    /**
     * @return the _totalSize
     */
    public int getTotalSize() {
        return _totalSize;
    }

    /**
     * @param _totalSize the _totalSize to set
     */
    public void setTotalSize(int _totalSize) {
        this._totalSize = _totalSize;
    }
    
    public void updateTotalSize(){
        if (_array){
            _totalSize = _size*_arraySize;
        }else{
            _totalSize = _size;
        }
    }

    /**
     * @return the _initialized
     */
    public boolean isInitialized() {
        return _initialized;
    }

    /**
     * @param _initialized the _initialized to set
     */
    public void setInitialized(boolean _initialized) {
        this._initialized = _initialized;
    }

    
    
}
