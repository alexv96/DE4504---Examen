/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import interfaces.ITipoPago;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TipoPago;

/**
 *
 * @author Alex
 */
public class TipoPagoDAO implements ITipoPago{

    private Connection conexion;
            
    public TipoPagoDAO() {
        this.conexion = new Conexion().getConexion();
    }
    
    @Override
    public List<TipoPago> getTiposPagos() {
        List<TipoPago> pagos = new ArrayList<>();
        
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TIPOS_PAGOS");
            
            while (rs.next()) {                
                TipoPago tp = new TipoPago();
                tp.setIdTipoPago(rs.getInt("id_tipoPagos"));
                tp.setDescripcion(rs.getString("descripcion_tipo"));
                
                pagos.add(tp);
            }
            conexion.close();
            return pagos;
        } catch (Exception e) {
            return null;
        }
    }
    
}
