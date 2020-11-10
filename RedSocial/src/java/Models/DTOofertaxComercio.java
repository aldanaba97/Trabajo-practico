/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Aldana
 */
public class DTOofertaxComercio {
  private comercio c; 
  private oferta o ; 

    public DTOofertaxComercio(comercio c, oferta o) {
        this.c = c;
        this.o = o;
    }

    public comercio getC() {
        return c;
    }

    public void setC(comercio c) {
        this.c = c;
    }

    public oferta getO() {
        return o;
    }

    public void setO(oferta o) {
        this.o = o;
    }

    @Override
    public String toString() {
        return "DTOofertaxComercio{" + "c=" + c + ", o=" + o + '}';
    }
  
    
}
