/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Alex
 */
public class Detalle {
    private int idDetalle;
    private int cantidad;
    private double valor;
    private Carretera carreteraID;
    private Boleta boletaID;

    private List<Carretera> listaCarretera;
    public Detalle() {
    }

    public Detalle(int idDetalle, int cantidad, double valor, Carretera carreteraID, Boleta boletaID) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.valor = valor;
        this.carreteraID = carreteraID;
        this.boletaID = boletaID;
    }

    public Detalle(int cantidad, double valor, Carretera carreteraID, Boleta boletaID) {
        this.cantidad = cantidad;
        this.valor = valor;
        this.carreteraID = carreteraID;
        this.boletaID = boletaID;
    }

    public Detalle(int cantidad, double valor, Boleta boletaID, List<Carretera> listaCarretera) {
        this.cantidad = cantidad;
        this.valor = valor;
        this.boletaID = boletaID;
        this.listaCarretera = listaCarretera;
    }

    public Detalle(int cantidad, double valor, Carretera carreteraID) {
        this.cantidad = cantidad;
        this.valor = valor;
        this.carreteraID = carreteraID;
    }
    
    

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Carretera getCarreteraID() {
        return carreteraID;
    }

    public void setCarreteraID(Carretera carreteraID) {
        this.carreteraID = carreteraID;
    }

    public Boleta getBoletaID() {
        return boletaID;
    }

    public void setBoletaID(Boleta boletaID) {
        this.boletaID = boletaID;
    }
    
    
}
