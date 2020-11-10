/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Models.Comentario;
import Models.comercio;
import Models.rubro;
import gestor.Gestor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aldana
 */
@WebServlet(name = "Comentario", urlPatterns = {"/Comentario"})
public class comentario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Gestor gestor = new Gestor();

        String modo = request.getParameter("modo");

        if (modo == null || modo.isEmpty()) {
            int idComercio = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("comercio", gestor.listadoComentarioxComercio(idComercio));

            RequestDispatcher rd = request.getRequestDispatcher("/PerfilComercio.jsp");
            rd.forward(request, response);
            
        } else if (modo.equals("alta")) {
            
            int idComercio = Integer.parseInt(request.getParameter("idc"));
            comercio o = gestor.portalComercioDatos(idComercio);
            request.setAttribute("comercio", o);
            RequestDispatcher rd = request.getRequestDispatcher("/FormularioComentario.jsp");
            rd.forward(request, response);

        } else if (modo.equals("eliminar")) {
            int idComercio = Integer.parseInt(request.getParameter("idc"));
            request.setAttribute("comercio", gestor.portalComercioDatos(idComercio));
         request.setAttribute("lista", gestor.listadoOfertaxComercio(idComercio));
          request.setAttribute("listaComercio", gestor.listadoComentarioxComercio(idComercio));
        RequestDispatcher rd = request.getRequestDispatcher("/eliminarComentario.jsp");
           rd.forward(request, response);
            
          
       // RequestDispatcher rd = request.getRequestDispatcher("/PerfilComercio.jsp");
         //  rd.forward(request, response);

        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Gestor gestor = new Gestor();

        int idComercio = Integer.parseInt(request.getParameter("idComercio"));
        String nombreU = request.getParameter("txtNombre");
        String descripcion = request.getParameter("txtDescripcion");
        int valoracion = Integer.parseInt(request.getParameter("rbtValoracion"));

        rubro rf = new rubro(0, "", true, "", "");
        comercio come = new comercio("", "", "", idComercio, true, "", "", rf, "");
        Comentario c = new Comentario(0, descripcion, valoracion, nombreU, "", come);
        gestor.InsertarComentario(c);
        
        
        request.setAttribute("comercio", gestor.portalComercioDatos(idComercio));
         request.setAttribute("lista", gestor.listadoOfertaxComercio(idComercio));
          request.setAttribute("listaComercio", gestor.listadoComentarioxComercio(idComercio));
        RequestDispatcher rd = request.getRequestDispatcher("/PerfilComercio.jsp");
           rd.forward(request, response);

//        request.setAttribute("comercio", gestor.portalComercioDatos(idComercio));
//
//        RequestDispatcher rd = request.getRequestDispatcher("/PerfilComercio.jsp");
//        rd.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
