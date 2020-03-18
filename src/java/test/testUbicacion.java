/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.UbicacionServices;
import modelo.Carretera;

/**
 *
 * @author Alex
 */
public class testUbicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UbicacionServices dao = new UbicacionServices();
        
        Carretera encontro = dao.buscarUbicacionCarretera(1);
        
        if (encontro != null) {
            System.out.println("Encontro");
            System.out.println(encontro.getNombre() + " Longitud: "+encontro.getUbicacionID().getLongitud());
        }else{
            System.out.println("error");
        }
    }
    
}
