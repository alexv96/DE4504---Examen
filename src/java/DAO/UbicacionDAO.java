/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.IUbicacion;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Carretera;
import modelo.Ubicacion;

/**
 *
 * @author Alex
 */
public class UbicacionDAO implements IUbicacion{
    private Connection conexion;
            
    public UbicacionDAO() {
        this.conexion = new Conexion().getConexion();
    }

    @Override
    public Carretera getUbicacion(int id) {
        List<Ubicacion> listado = new ArrayList<>();
        String sql = "select id_carretera, nombre_carretera, valor, latitud, longitud from carreteras join ubicacion on carreteras.ubicacion_id = ubicacion.id_ubicacion where id_carretera="+id;
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Carretera c = null;
            while (rs.next()) {                
                int idCarretera = rs.getInt(1);
                String nombreCarretera = rs.getString(2);
                double valor = rs.getDouble(3);
                String latitud = rs.getString(4);
                String longitud = rs.getString(5);
                
                Ubicacion u = new Ubicacion(latitud, longitud);
                c = new Carretera(idCarretera, nombreCarretera, valor, u);
            }
            return c;
        } catch (Exception e) {
        }
        return null;
    }

    
    
    
}
