/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gruposalinas.sistemas.casadebolsa.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;
import mx.com.gruposalinas.sistemas.casadebolsa.model.enums.Operacion;

/**
 *
 * @author 180917_GPO_SALINAS
 */
public class Portafolio {

    private LocalDate fechaApertura;
    private LocalDate fechaCancelacion;
    private double saldoTotalEnAcciones;
    private ArrayList<Accion> acciones;
    private ArrayList<Movimiento> movimientos;

    public Portafolio(LocalDate fechaApertura, LocalDate fechaCancelacion, ArrayList<Accion> acciones, ArrayList<Movimiento> movimientos) {
        this.fechaApertura = fechaApertura;
        this.fechaCancelacion = fechaCancelacion;
        this.acciones = acciones;
        this.movimientos = movimientos;
    }

    public Portafolio() {
        acciones = new ArrayList<>();
        movimientos = new ArrayList<>();
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

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    private double calcularTotal() {
        return acciones.stream().mapToDouble(Accion::precioTotal).sum();
    }

    public void comprarAccion(Accion accion) {
        acciones.add(accion);
        Movimiento m = new Movimiento();
        m.setAccion(accion);
        m.setDescripcion(new StringBuilder().append("Compra de accion: ").append(accion.getSimbolo()).toString());
        m.setFecha(LocalDateTime.now());
        m.setFolio(1);
        m.setMontoOperacion(accion.getCantidad() * accion.getPrecio());
        m.setNumeroAcciones(accion.getCantidad());
        m.setTipo(Operacion.COMPRA);
        movimientos.add(m);
    }

    public void imprimirHistorico() {
        movimientos.stream().forEach(s -> System.out.println("**************\n" + s.toString()));
    }

    public void imprimirAcciones() {
        acciones.stream().forEach(s -> System.out.println("**************\n" + s.toString()));
    }

    public Accion venderAccion(String nombreAccion, int cantidad) {
        Accion a = acciones.stream().filter(n -> n.getSimbolo().equals(nombreAccion)).collect(Collectors.toList()).get(0);
        var cantidadAccionesDisponibles = a.getCantidad();
        
        ////
        System.out.println("hola mundooooo"+a);
        Movimiento m = new Movimiento();
        m.setAccion(a);
        m.setDescripcion(new StringBuilder().append("Venta de accion: ").append(a.getSimbolo()).toString());
        m.setFecha(LocalDateTime.now());
        m.setFolio(1);
        m.setMontoOperacion(a.getCantidad() * a.getPrecio());
        m.setTipo(Operacion.VENTA);
        m.setNumeroAcciones(a.getCantidad()-cantidad);
        movimientos.add(m);
        acciones.removeIf(n -> (n.getSimbolo().equals(nombreAccion) && n.getCantidad() <= cantidad));
        a.setCantidad(cantidadAccionesDisponibles - cantidad);
        return new Accion(a.getSimbolo(), a.getPrecio(), cantidad);
    }
    public void verUtilidades(){
        cambiarPrecio();
    }
    public void cambiarPrecio(){
        acciones.stream().forEach(acc->acc.setCantidad((int) Math.random()*20));
    }
}
