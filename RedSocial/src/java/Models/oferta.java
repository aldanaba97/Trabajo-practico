
package Models;

import java.sql.Timestamp;


public class oferta {
    private int id_oferta; 
    private String nombre; 
    private int cantidad; 
    private float precio; 
    private comercio c; 
    private boolean estado;
    private String descripcion; 
    private String fecha; 
    private String ruta; 
    public oferta(int id_oferta, String nombre, int cantidad, float precio, comercio c, boolean estado, String descripcion, String fecha, String ruta) {        this.id_oferta = id_oferta;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.c = c;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ruta = ruta; 
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public comercio getC() {
        return c;
    }

    public void setC(comercio c) {
        this.c = c;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "oferta{" + "id_oferta=" + id_oferta + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", c=" + c + ", estado=" + estado + ", descripcion=" + descripcion + '}';
    }
    
    

   
     
}
