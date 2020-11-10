/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Models.DTOcomentarioRta;
import Models.comercio;
import Models.oferta;
import Models.rubro;
import gestor.Gestor;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Aldana
 */
@WebServlet(name = "Oferta", urlPatterns = {"/Oferta"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 6,
        location = "C:\\Users\\Aldana\\OneDrive\\Documentos\\NetBeansProjects\\RedSocial\\web\\archivos"
)
public class Oferta extends HttpServlet {

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
          
        if (modo == null || modo.isEmpty())
        {
              int idComercio = Integer.parseInt(request.getParameter("id"));
        
        request.setAttribute("lista", gestor.listadoOfertaxComercio(idComercio));

        RequestDispatcher rd = request.getRequestDispatcher("/PerfilComercio.jsp");
           rd.forward(request, response);
        }
       
        else if(modo.equals("alta"))
        {
            int idComercio = Integer.parseInt(request.getParameter("idc"));
            comercio o = gestor.portalComercioDatos(idComercio);
            request.setAttribute("comercio", o );
            RequestDispatcher rd = request.getRequestDispatcher("/FormularioOferta.jsp");
         rd.forward(request, response);
        }

        else if(modo.equals("editar") )
        {
            int idOferta = Integer.parseInt(request.getParameter("id"));
            oferta o = gestor.ObtenerOferta(idOferta);
            request.setAttribute("oferta", o );
            RequestDispatcher rd = request.getRequestDispatcher("/editarOferta.jsp");
            rd.forward(request, response);
            
        }
        else if(modo.equals("eliminar"))
        {
            int idOferta = Integer.parseInt(request.getParameter("id"));
            oferta o = gestor.ObtenerOferta(idOferta);
            request.setAttribute("oferta", o );
            RequestDispatcher rd = request.getRequestDispatcher("/eliminarOferta.jsp");
            rd.forward(request, response);
            
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
           
           Gestor g = new Gestor();
          
           
            
       int id = Integer.parseInt(request.getParameter("idOferta"));
         String nombre = request.getParameter("txtNombre");
                Float precio = Float.parseFloat(request.getParameter("txtPrecio"));
                int cantidad = Integer.parseInt((request.getParameter("txtCantidad")));
                String descripcion = request.getParameter("txtDescripcion");
                int comercio = Integer.parseInt((request.getParameter("idComercio")));
                Part filePart = request.getPart("txtupload1");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (!fileName.isEmpty()) {
                filePart.write(fileName);
            }
            
                rubro rf = new rubro(0, "", true, "", "");
                comercio come = new comercio("", "", "", comercio, true, "", "", rf,"");
                oferta o = new oferta(id, nombre, cantidad, precio, come, true,"", descripcion, fileName);
                g.ModificarOferta(o);
                
                  
         request.setAttribute("comercio", g.portalComercioDatos(comercio));
         request.setAttribute("lista", g.listadoOfertaxComercio(comercio));
          request.setAttribute("listaComercio", g.listadoComentarioxComercio(comercio));
         
        RequestDispatcher rd = request.getRequestDispatcher("/PerfilComercio.jsp");
           rd.forward(request, response);
                  
             
    }
     private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
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
