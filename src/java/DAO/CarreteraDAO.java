/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.ICarretera;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Boleta;
import modelo.Carretera;
import modelo.Detalle;
import modelo.Empresa;

/**
 *
 * @author Alex
 */
public class CarreteraDAO implements ICarretera{

    private Connection conexion;
    
    public CarreteraDAO() {
        this.conexion = new Conexion().getConexion();
    }

    
    @Override
    public List<Carretera> getCarreteras() {
        List<Carretera> carreteras = new ArrayList<>();
        
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CARRETERAS");
            
            while (rs.next()) {                
                Carretera c = new Carretera();
                
                c.setIdCarretera(rs.getInt("id_carretera"));
                c.setNombre(rs.getString("nombre_carretera"));
                c.setValor(rs.getDouble("valor"));
                c.setUbicacion(rs.getInt("ubicacion_id"));
                carreteras.add(c);
            }
            return carreteras;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean registrarCarretera(Empresa emp, Detalle det, Boleta bol){
        try {
            Statement stmt = conexion.createStatement();
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public Carretera getCarreteraByID(int id) {
        List<Carretera> carreteras = new ArrayList<>();
        String sql = "SELECT * FROM CARRETERAS WHERE ID_CARRETERA="+id;
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Carretera c = new Carretera();
            while (rs.next()) {                
                c.setIdCarretera(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setValor(rs.getDouble(3));
            }
            return c;
        } catch (Exception e) {
        }
        return null;
    }
    
}
