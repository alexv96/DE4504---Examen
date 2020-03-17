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
public class TipoDespacho {
    private int idTipoDespacho;
    private String descripcion;

    public TipoDespacho() {
    }

    public TipoDespacho(int idTipoDespacho, String descripcion) {
        this.idTipoDespacho = idTipoDespacho;
        this.descripcion = descripcion;
    }

    public int getIdTipoDespacho() {
        return idTipoDespacho;
    }

    public void setIdTipoDespacho(int idTipoDespacho) {
        this.idTipoDespacho = idTipoDespacho;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
