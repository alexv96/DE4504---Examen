/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controlador.CarreteraServices;
import controlador.UbicacionServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carretera;

/**
 *
 * @author Alex
 */
public class UbicacionServlet extends HttpServlet {

    CarreteraServices servicioCarretera = new CarreteraServices();
    UbicacionServices servicioUbicacion = new UbicacionServices();
    List<Carretera> carreteras = new ArrayList<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        List<Carretera> carreteras = servicioCarretera.obtenerTodo();
        
        switch(accion){
            case "buscar":
                mostrar(request,response);
                break;
            default:
                request.setAttribute("carreteras", carreteras);
                request.getRequestDispatcher("ubicacion.jsp").forward(request, response);
                break;
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("lineas"));
        
        Carretera ubicacion = servicioUbicacion.buscarUbicacionCarretera(id);
        List<Carretera> carreteras = servicioCarretera.obtenerTodo();
        if (ubicacion==null) {
            return;
        }
        System.out.println(ubicacion.toString());
        request.setAttribute("ubicacion", ubicacion);
        request.setAttribute("carreteras", carreteras);
        request.getRequestDispatcher("ubicacion.jsp").forward(request, response);
    }

}
