/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controlador.CarreteraServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carretera;
import modelo.Detalle;

/**
 *
 * @author Alex
 */
public class CarreteraServlet extends HttpServlet {

    CarreteraServices servicioCarretera = new CarreteraServices();
    List<Detalle> listaCarretera = new ArrayList<>();
    List<Carretera> carreteras = new ArrayList<>();
    int cantidad = 1;
    int item;
    double totalPagar = 0.0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Accion del JSP
        String accion = request.getParameter("accion");

        //Variable Global para index.
        List<Carretera> carreteras = servicioCarretera.obtenerTodo();

        switch (accion) {
            case "agregarCarro":
                agregarCarrito(request, response);
                break;
            case "eliminar":
                eliminarCarro(request, response);
                break;
            case "actualizarCantidad":
                actualizarCantidad(request, response);
                break;
            case "totalPagar":
                total(request, response);
                break;
            default:
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carro", listaCarretera);
                request.setAttribute("carreteras", carreteras);
                request.getRequestDispatcher("index.jsp").forward(request, response);
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

    private void agregarCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int posicion = 0;
        cantidad = 1;

        int idSelect = Integer.parseInt(request.getParameter("lineas"));

        Carretera carreteraObtenida = servicioCarretera.obtenerCarreteraID(idSelect);

        if (listaCarretera.size() > 0) {
            for (int i = 0; i < listaCarretera.size(); i++) {
                if (idSelect == listaCarretera.get(i).getCarreteraID().getIdCarretera()) {
                    posicion = i;
                }
            }

            if (idSelect == listaCarretera.get(posicion).getCarreteraID().getIdCarretera()) {
                cantidad = listaCarretera.get(posicion).getCantidad() + cantidad;
                double subtotal = listaCarretera.get(posicion).getCarreteraID().getValor() * cantidad;
                listaCarretera.get(posicion).setCantidad(cantidad);
                listaCarretera.get(posicion).setValor(subtotal);
            } else {
                item = item + 1;
                Detalle detalle = new Detalle();
                detalle.setCantidad(cantidad);
                detalle.setIdDetalle(item);
                detalle.setCarreteraID(carreteraObtenida);
                detalle.setValor(cantidad * carreteraObtenida.getValor());

                listaCarretera.add(detalle);
                total(request, response);
            }
        } else {
            item = item + 1;
            Detalle detalle = new Detalle();
            detalle.setCantidad(cantidad);
            detalle.setIdDetalle(item);
            detalle.setCarreteraID(carreteraObtenida);
            detalle.setValor(cantidad * carreteraObtenida.getValor());

            listaCarretera.add(detalle);
            total(request, response);
        }
    }

    private void eliminarCarro(HttpServletRequest request, HttpServletResponse response) {
        int idCarro = Integer.parseInt(request.getParameter("idPista"));

        for (int i = 0; i < listaCarretera.size(); i++) {
            if (listaCarretera.get(i).getCarreteraID().getIdCarretera() == idCarro) {
                listaCarretera.remove(i);
            }
        }
    }

    private void actualizarCantidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCarretera = Integer.parseInt(request.getParameter("idCarretera"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        for (int i = 0; i < listaCarretera.size(); i++) {
            if (listaCarretera.get(i).getCarreteraID().getIdCarretera() == idCarretera) {
                listaCarretera.get(i).setCantidad(cantidad);

                double st = listaCarretera.get(i).getCarreteraID().getValor() * cantidad;

                listaCarretera.get(i).setValor(st);
            }
        }
        
        total(request, response);
    }

    private void total(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        totalPagar = 0;

        for (int i = 0; i < listaCarretera.size(); i++) {
            totalPagar = totalPagar + listaCarretera.get(i).getValor();
        }

        request.setAttribute("totalPagar", totalPagar);
        request.setAttribute("carro", listaCarretera);
        request.setAttribute("carreteras", carreteras);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return;
    }

}
