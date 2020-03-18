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
public class Carretera {
    private int idCarretera;
    private String nombre;
    private double valor;
    private int ubicacion;
    private Ubicacion ubicacionID;

    public Carretera() {
    }

    public Carretera(int idCarretera, String nombre, double valor, Ubicacion ubicacionID) {
        this.idCarretera = idCarretera;
        this.nombre = nombre;
        this.valor = valor;
        this.ubicacionID = ubicacionID;
    }

    public Carretera(int idCarretera, String nombre, double valor, int ubicacion) {
        this.idCarretera = idCarretera;
        this.nombre = nombre;
        this.valor = valor;
        this.ubicacion = ubicacion;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getIdCarretera() {
        return idCarretera;
    }

    public void setIdCarretera(int idCarretera) {
        this.idCarretera = idCarretera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Ubicacion getUbicacionID() {
        return ubicacionID;
    }

    public void setUbicacionID(Ubicacion ubicacionID) {
        this.ubicacionID = ubicacionID;
    }

    @Override
    public String toString() {
        return "Carretera{" + "idCarretera=" + idCarretera + ", nombre=" + nombre + ", valor=" + valor + ", ubicacion=" + ubicacion + ", ubicacionID=" + ubicacionID + '}';
    }
    
    
}
