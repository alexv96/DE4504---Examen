/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controlador.CarreteraServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carretera;

/**
 *
 * @author Alex
 */
@WebServlet(name = "indexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {

    CarreteraServices servicio = new CarreteraServices();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        
        if (accion == null) {
            doGet(request, response);
        }
        
        switch(accion){
            default:
                obtenerCarreteras(request,response);
                break;
        }
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
        try {
            CarreteraServices servicio = new CarreteraServices();
            
            List<Carretera> carreteras = servicio.obtenerTodo();
            request.setAttribute("carreteras", carreteras);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } catch (Exception e) {
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

    private void obtenerCarreteras(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            
            List<Carretera> carreteras = servicio.obtenerTodo();
            request.setAttribute("carreteras", carreteras);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } catch (Exception e) {
        }
    }

}
