/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Models.rubro;
import gestor.Gestor;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
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
@WebServlet(name = "NuevoRubro", urlPatterns = {"/NuevoRubro"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 6,
        location = "C:\\Users\\Aldana\\OneDrive\\Documentos\\NetBeansProjects\\RedSocial\\web\\archivos"
)
public class NuevoRubro extends HttpServlet {

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
          
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/FormularioRubro.jsp");
//       rd.forward(request, response);  
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
//    RequestDispatcher rd = getServletContext().getRequestDispatcher("/FormularioRubro.jsp");
//       rd.forward(request, response);  
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
        
        try {
            Gestor g = new Gestor();
        
        
        
             String nombre = request.getParameter("txtNombre");
        String descripcion = request.getParameter("txtDescripcion");
         Part filePart = request.getPart("txtupload1");
    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (!fileName.isEmpty()) {
                filePart.write(fileName);}

          rubro r = new rubro(0, nombre, true, descripcion, fileName); 
          g.InsertarRubro(r);
          
           
            request.setAttribute("lista", g.obtenerTodoslosRubros());

            RequestDispatcher rd = request.getRequestDispatcher("/ListadoRubros.jsp");
            rd.forward(request, response);
         } 
 
        catch (Exception e)
                {
                    e.printStackTrace();
                }
    }

        
       
       
        
        // Forward o redirect
    
    
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
