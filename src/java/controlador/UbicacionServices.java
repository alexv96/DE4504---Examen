/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.UbicacionDAO;
import modelo.Carretera;
import modelo.Ubicacion;

/**
 *
 * @author Alex
 */
public class UbicacionServices {

    UbicacionDAO dao;
    
    public UbicacionServices() {
        this.dao = new UbicacionDAO();
    }
    
    
    public Carretera buscarUbicacionCarretera(int id){
        return dao.getUbicacion(id);
    }
}
