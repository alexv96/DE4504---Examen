/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;

/**
 *
 * @author Alex
 */
public class Boleta {
    private int idBoleta;
    private Calendar fechaCompra;
    private double total;
    private TipoPago pagoID;
    private TipoDespacho despachoID;
    private Empresa clienteID;

    public Boleta() {
    }

    public Boleta(int idBoleta, Calendar fechaCompra, double total, TipoPago pagoID, TipoDespacho despachoID, Empresa clienteID) {
        this.idBoleta = idBoleta;
        this.fechaCompra = fechaCompra;
        this.total = total;
        this.pagoID = pagoID;
        this.despachoID = despachoID;
        this.clienteID = clienteID;
    }

    public Boleta(Calendar fechaCompra, double total, TipoPago pagoID, TipoDespacho despachoID, Empresa clienteID) {
        this.fechaCompra = fechaCompra;
        this.total = total;
        this.pagoID = pagoID;
        this.despachoID = despachoID;
        this.clienteID = clienteID;
    }

    public int getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(int idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Calendar getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Calendar fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public TipoPago getPagoID() {
        return pagoID;
    }

    public void setPagoID(TipoPago pagoID) {
        this.pagoID = pagoID;
    }

    public TipoDespacho getDespachoID() {
        return despachoID;
    }

    public void setDespachoID(TipoDespacho despachoID) {
        this.despachoID = despachoID;
    }

    public Empresa getClienteID() {
        return clienteID;
    }

    public void setClienteID(Empresa clienteID) {
        this.clienteID = clienteID;
    }
    
    
}
