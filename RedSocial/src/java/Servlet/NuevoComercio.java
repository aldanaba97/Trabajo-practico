/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Models.comercio;
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
@WebServlet(name = "NuevoComercio", urlPatterns = {"/NuevoComercio"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 6,
        location = "C:\\Users\\Aldana\\OneDrive\\Documentos\\NetBeansProjects\\RedSocial\\web\\archivos"
)
public class NuevoComercio extends HttpServlet {

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
        ArrayList<rubro> listado = gestor.obtenerRubro();
        request.setAttribute("rubro", listado);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/FormularioComercio.jsp");
        rd.forward(request, response);

//        
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
            String direccion = request.getParameter("txtDireccion");
            String telefono = request.getParameter("txtTelefono");
            String informacion = request.getParameter("txtInformacion");
            String red = request.getParameter("txtRed");
            int idr = Integer.parseInt(request.getParameter("cboRubro"));
            Part filePart = request.getPart("txtupload1");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (!fileName.isEmpty()) {
                filePart.write(fileName);
            }

            rubro r = new rubro(idr, "", true, "", "");
            comercio c = new comercio(nombre, direccion, telefono, 0, true, informacion, red, r, fileName);
            g.InsertarComercio(c);

            request.setAttribute("comercio", g.listadoComercioMenu());
        RequestDispatcher rd = request.getRequestDispatcher("/ListadoComercioMenu.jsp");
        rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

        }

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
