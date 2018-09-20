/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gruposalinas.sistemas.casadebolsa.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author 180917_GPO_SALINAS
 */
public class Portafolio {
    private LocalDate fechaApertura;
    private LocalDate fechaCancelacion;
    private double saldoTotalEnAcciones;
    private ArrayList<Accion> acciones;
    private ArrayList<String> movimientos;

    public Portafolio(LocalDate fechaApertura, LocalDate fechaCancelacion, ArrayList<Accion> acciones, ArrayList<String> movimientos) {
        this.fechaApertura = fechaApertura;
        this.fechaCancelacion = fechaCancelacion;
        this.acciones = acciones;
        this.movimientos = movimientos;
    }

    public Portafolio() {
        acciones=new ArrayList<>();
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public LocalDate getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(LocalDate fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public double getSaldoTotalEnAcciones() {
        saldoTotalEnAcciones = calcularTotal();
        return saldoTotalEnAcciones;
    }

    public ArrayList<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(ArrayList<Accion> acciones) {
        this.acciones = acciones;
    }

    public ArrayList<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<String> movimientos) {
        this.movimientos = movimientos;
    }
    
    private double calcularTotal(){
        return  acciones.stream().mapToDouble(Accion::precioTotal).sum();
    }
    public void agregarAccion(Accion accion){
        acciones.add(accion);
    }
}
