/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Models.DTOComercioxRubro;
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
@WebServlet(name = "ListadoComercio", urlPatterns = {"/ListadoComercio"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 6,
        location = "C:\\Users\\Aldana\\OneDrive\\Documentos\\NetBeansProjects\\RedSocial\\web\\archivos"
)
public class ListadoComercio extends HttpServlet {

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
        int idRubroC = Integer.parseInt(request.getParameter("id"));

        if (modo == null || modo.isEmpty()) {
            ArrayList<DTOComercioxRubro> lista = gestor.listadoComercio(idRubroC);
            request.setAttribute("listado", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/ListadoComercio.jsp");
            rd.forward(request, response);
        } //        else if(modo.equals("alta"))
        //        {
        //         ArrayList<rubro> listado = gestor.obtenerRubro();
        //            request.setAttribute("rubro", listado);
        //         RequestDispatcher rd = request.getRequestDispatcher("/FormularioComercio.jsp");
        //         rd.forward(request, response);
        //        }
        else if (modo.equals("editar")) {
            int idComercio = Integer.parseInt(request.getParameter("id"));
            comercio c = gestor.ObtenerComercio(idComercio);
            request.setAttribute("comercio", c);
            ArrayList<rubro> listado = gestor.obtenerRubro();
            request.setAttribute("rubro", listado);
            RequestDispatcher rd = request.getRequestDispatcher("/editarComercio.jsp");
            rd.forward(request, response);

        } else if (modo.equals("eliminar")) {

            int idComercio = Integer.parseInt(request.getParameter("id"));
            comercio c = gestor.ObtenerComercio(idComercio);
            request.setAttribute("comercio", c);
            ArrayList<rubro> listado = gestor.obtenerRubro();
            request.setAttribute("rubro", listado);
            RequestDispatcher rd = request.getRequestDispatcher("/eliminarComercio.jsp");
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

        Gestor gestor = new Gestor();
Part filePart = request.getPart("txtupload1");
    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (!fileName.isEmpty()) {
                filePart.write(fileName);}
        int id = Integer.parseInt(request.getParameter("idComercio"));
        String nombre = request.getParameter("txtNombre");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
        String informacion = request.getParameter("txtInformacion");
        String red = request.getParameter("txtRed");
        int idr = Integer.parseInt(request.getParameter("cboRubro"));

        rubro r = new rubro(idr, "", true, "", "");
        comercio c = new comercio(nombre, direccion, telefono, id, true, informacion, red, r, fileName);
        gestor.modificarComercio(c);
            
        request.setAttribute("listado", gestor.listadoComercio(idr));
        RequestDispatcher rd = request.getRequestDispatcher("/ListadoComercio.jsp");
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
