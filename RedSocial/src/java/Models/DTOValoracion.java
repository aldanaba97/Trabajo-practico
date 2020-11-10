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
public class DTOValoracion {
    private int valoracion; 
    private int cantidad; 

    public DTOValoracion(int valoracion, int cantidad) {
        this.valoracion = valoracion;
        this.cantidad = cantidad;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DTOValoracion{" + "valoracion=" + valoracion + ", cantidad=" + cantidad + '}';
    }
    
    
}
