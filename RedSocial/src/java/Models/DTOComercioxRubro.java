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
public class DTOComercioxRubro {
    private rubro r ; 
    private comercio c; 
    private float promedioV; 

    public DTOComercioxRubro(rubro r, comercio c, float promedioV) {
        this.r = r;
        this.c = c;
        this.promedioV = promedioV;
    }

    public rubro getR() {
        return r;
    }

    public void setR(rubro r) {
        this.r = r;
    }

    public comercio getC() {
        return c;
    }

    public void setC(comercio c) {
        this.c = c;
    }

    public float getPromedioV() {
        return promedioV;
    }

    public void setPromedioV(float promedioV) {
        this.promedioV = promedioV;
    }

    @Override
    public String toString() {
        return "DTOComercioxRubro{" + "r=" + r + ", c=" + c + ", promedioV=" + promedioV + '}';
    }
    
    

}
