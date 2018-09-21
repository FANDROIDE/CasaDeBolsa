/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gruposalinas.sistemas.casadebolsa.model.entity;

import java.time.LocalDateTime;
import mx.com.gruposalinas.sistemas.casadebolsa.model.enums.Operacion;

/**
 *
 * @author 180917_GPO_SALINAS
 */
public class Movimiento {

    private int folio;
    private LocalDateTime fecha;
    private Operacion tipo;
    private double montoOperacion;
    private int numeroAcciones;
    private String descripcion;
    private Accion accion;

    public Movimiento() {
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Operacion getTipo() {
        return tipo;
    }

    public void setTipo(Operacion tipo) {
        this.tipo = tipo;
    }

    public double getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(double montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Folio:\t").append(folio)
                .append("\nFecha:\t").append(fecha)
                .append("\nTipo:\t").append(tipo)
                .append("\nMonto de operacion:\t").append(montoOperacion)
                .append("\nNumero de acciones\t").append(numeroAcciones)
                .append("\nDescripcion:\t").append(descripcion).append("\n");
        return sb.toString();
    }

    public void setNumeroAcciones(int numeroAcciones) {
        this.numeroAcciones = numeroAcciones;
    }

    public int getNumeroAcciones() {
        return numeroAcciones;
    }

}
