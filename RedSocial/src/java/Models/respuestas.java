package Models;

import java.sql.Timestamp;


public class respuestas {
private int id_respuesta; 
private String descripcion; 
private Comentario come;
private String fecha; 

    public respuestas(int id_respuesta, String descripcion, Comentario come, String fecha) {
        this.id_respuesta = id_respuesta;
        this.descripcion = descripcion;
        this.come = come;
       
        this.fecha = fecha;
    }

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Comentario getCome() {
        return come;
    }

    public void setCome(Comentario come) {
        this.come = come;
    }

   
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "respuestas{" + "id_respuesta=" + id_respuesta + ", descripcion=" + descripcion + ", come=" + come + ", fecha=" + fecha + '}';
    }

    

}
