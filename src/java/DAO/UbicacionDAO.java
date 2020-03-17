/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.IUbicacion;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Ubicacion;

/**
 *
 * @author Alex
 */
public class UbicacionDAO {
    private Connection conexion;
            
    public UbicacionDAO() {
        this.conexion = new Conexion().getConexion();
    }

    
    
    
}
