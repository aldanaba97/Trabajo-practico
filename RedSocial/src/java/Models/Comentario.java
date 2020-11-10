
package Models;




public class Comentario {
    private int id_comentarios;
    private String descripcion; 
    private int valoracion;
    private String nombreUsuario; 
    private String fecha;  
    private comercio c; 

    public Comentario(int id_comentarios, String descripcion, int valoracion, String nombreUsuario, String fecha, comercio c) {
        this.id_comentarios = id_comentarios;
        this.descripcion = descripcion;
        this.valoracion = valoracion;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.c = c;
    }

    public int getId_comentarios() {
        return id_comentarios;
    }

    public void setId_comentarios(int id_comentarios) {
        this.id_comentarios = id_comentarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

    public comercio getC() {
        return c;
    }

    public void setC(comercio c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id_comentarios=" + id_comentarios + ", descripcion=" + descripcion + ", valoracion=" + valoracion + ", nombreUsuario=" + nombreUsuario + ", fecha=" + fecha + " c=" + c + '}';
    }
    
}
   