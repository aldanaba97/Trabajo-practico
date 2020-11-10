
package Models;

public class rubro {
    private int id; 
    private String nombre; 
    private boolean estado;
    private String descripcion; 
    private String ruta; 

    public rubro(int id, String nombre, boolean estado, String descripcion, String ruta) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.ruta = ruta;
    }
    public rubro () 
    {
        
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "rubro{" + "id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", descripcion=" + descripcion + '}';
    }
    
    
}
   