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
public class DTOcomentarioRta {
   private Comentario come;
   private respuestas rta;

    public DTOcomentarioRta(Comentario come, respuestas rta) {
        this.come = come;
        this.rta = rta;
    }

    public Comentario getCome() {
        return come;
    }

    public void setCome(Comentario come) {
        this.come = come;
    }

    public respuestas getRta() {
        return rta;
    }

    public void setRta(respuestas rta) {
        this.rta = rta;
    }

    @Override
    public String toString() {
        return "DTOcomentarioRta{" + "come=" + come + ", rta=" + rta + '}';
    }
   
    }
