/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.ITipoDespacho;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoDespacho;

/**
 *
 * @author Alex
 */
public class TipoDespachoDAO implements ITipoDespacho{

    private Connection conexion;
            
    public TipoDespachoDAO() {
        this.conexion = new Conexion().getConexion();
    }
    
    @Override
    public List<TipoDespacho> getTiposPagos() {
        List<TipoDespacho> despachos = new ArrayList<>();
        
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TIPO_DESPACHO");
            
            while (rs.next()) {                
                TipoDespacho td = new TipoDespacho();
                td.setIdTipoDespacho(rs.getInt("id_tipo_despacho"));
                td.setDescripcion(rs.getString("descripcion_despacho"));
                
                despachos.add(td);
            }
            conexion.close();
            return despachos;
        } catch (Exception e) {
            return null;
        }
    }
    
}
