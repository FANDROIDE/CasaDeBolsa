/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gruposalinas.sistemas.casadebolsa.model.entity;

/**
 *
 * @author 180917_GPO_SALINAS
 */
public class Accion {
    private String simbolo;
    private double precio;
    private int cantidad;

    public Accion(String simbolo, double precio, int cantidad) {
        this.simbolo = simbolo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Nombre: ").append(simbolo).
        append("\nPrecio Actual").append(precio).
        append("\nCantidad: ").append(cantidad);
        return sb.toString();
    }
    public double precioTotal(){
        return precio*cantidad;
    }
    
}
