
package Models;


public class comercio {
    private String nombre; 
    private String direccion; 
    private String numero; 
    private int comercios_id; 
    private boolean estado; 
    private String informacion; 
    private String redSocial; 
    private rubro r; 
    private String ruta; 

    public comercio(String nombre, String direccion, String numero, int comercios_id, boolean estado, String informacion, String redSocial, rubro r, String ruta) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;
        this.comercios_id = comercios_id;
        this.estado = estado;
        this.informacion = informacion;
        this.redSocial = redSocial;
        this.r = r;
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "comercio{" + "nombre=" + nombre + ", direccion=" + direccion + ", numero=" + numero + ", comercios_id=" + comercios_id + ", estado=" + estado + ", informacion=" + informacion + ", redSocial=" + redSocial + ", r=" + r + '}';
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getComercios_id() {
        return comercios_id;
    }

    public void setComercios_id(int comercios_id) {
        this.comercios_id = comercios_id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getRedSocial() {
        return redSocial;
    }

    public void setRedSocial(String redSocial) {
        this.redSocial = redSocial;
    }

    public rubro getR() {
        return r;
    }

    public void setR(rubro r) {
        this.r = r;
    }
    

   
    
}
