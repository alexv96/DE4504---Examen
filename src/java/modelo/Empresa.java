/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alex
 */
public class Empresa {
    private int idEmpresa;
    private String rut;
    private String nombre;
    private String direccion;
    private String compraPor;

    public Empresa() {
    }

    public Empresa(int idEmpresa, String rut, String nombre, String direccion, String compraPor) {
        this.idEmpresa = idEmpresa;
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.compraPor = compraPor;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCompraPor() {
        return compraPor;
    }

    public void setCompraPor(String compraPor) {
        this.compraPor = compraPor;
    }
    
    
}
