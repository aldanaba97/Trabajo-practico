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
public class ComentarioComp {
    private String nombreComercio; 
    private String nombre; 
    private String descripcion; 
    private String fecha; 
    private int valoracion; 

    public ComentarioComp(String nombreComercio, String nombre, String descripcion, String fecha, int valoracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.valoracion = valoracion;
        this.nombreComercio = nombreComercio;
    }

    public String getNombreComercio() {
        return nombreComercio;
    }

    public void setNombreComercio(String nombreComercio) {
        this.nombreComercio = nombreComercio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "ComentarioComp{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", valoracion=" + valoracion + '}';
    }
    
    
}
