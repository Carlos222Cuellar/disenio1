/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author karenquintanilla
 */
public class Ordenes {
    
    
    
    private int IdOrden;
    
    private String fecha;
    private String mesero;
    private String mesa;
    private String cliente;
    private char estado;
    private double total;
    private String observacion;

    public Ordenes(Integer IdOrden, String fecha, String mesero, String mesa, String cliente, char estado, double total, String observacion) {
        this.IdOrden = IdOrden;
        this.fecha = fecha;
        this.mesero = mesero;
        this.mesa = mesa;
        this.cliente = cliente;
        this.estado = estado;
        this.total = total;
        this.observacion = observacion;
    }

    public Ordenes() {
    }

    
    
    
    
    public Integer getIdOrden() {
        return IdOrden;
    }

    public void setIdOrden(Integer IdOrden) {
        this.IdOrden = IdOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
}
