
package Models;


public class Login {
private int idLogin; 
private String usuario; 
private String password; 
private String email; 

    public Login(int idLogin, String usuario, String password, String email) {
        this.idLogin = idLogin;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Login{" + "idLogin=" + idLogin + ", usuario=" + usuario + ", password=" + password + ", email=" + email + '}';
    }

}
