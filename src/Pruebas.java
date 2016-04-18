/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kevin
 */
public class Pruebas {
    
    public int a;
    public char b;
    public boolean c;
    public Pruebas p;
    
    public int getPA(){
        return p.a;
    }
    
    public void instance(){
        k = 0;
        p = new Pruebas();
    }
    public void instance(int a){
        k=a;
        instance();
    }
    
    public int k;
    
}
