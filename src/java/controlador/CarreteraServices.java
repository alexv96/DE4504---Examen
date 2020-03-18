/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.CarreteraDAO;
import java.util.List;
import modelo.Carretera;

/**
 *
 * @author Alex
 */
public class CarreteraServices {
    
    CarreteraDAO carreteraDAO;

    public CarreteraServices() {
        this.carreteraDAO = new CarreteraDAO();
    }
    
    
    
    public List<Carretera> obtenerTodo(){
        return carreteraDAO.getCarreteras();
    }
    
    public Carretera obtenerCarreteraID(int id){
        return carreteraDAO.getCarreteraByID(id);
    }

    
    
}
