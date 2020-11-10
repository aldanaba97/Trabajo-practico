/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Models.DTOcomentarioRta;
import Models.DTOofertaxComercio;
import Models.comercio;
import Models.oferta;
import gestor.Gestor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "perfilComercio", urlPatterns = {"/perfilComercio"})
public class perfilComercio extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
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
        
//         int idRubroC = Integer.parseInt(request.getParameter("id"));
//           
//            ArrayList<DTOComercioxRubro> lista = gestor.listadoComercio(idRubroC);
//            request.setAttribute("listado", lista);          
//             RequestDispatcher rd = request.getRequestDispatcher("/ListadoComercio.jsp");
//            rd.forward(request, response);
         Gestor g = new Gestor();
        int idComercio = Integer.parseInt(request.getParameter("id"));
        comercio o = g.portalComercioDatos(idComercio);
        request.setAttribute("comercio", o);
        request.setAttribute("lista", g.listadoOfertaxComercio(idComercio));
        ArrayList <DTOcomentarioRta> listaComercio = g.listadoComentarioxComercio(idComercio);
        request.setAttribute("listaComercio", listaComercio);

        RequestDispatcher rd = request.getRequestDispatcher("/PerfilComercio.jsp");
           rd.forward(request, response);
        
        
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
