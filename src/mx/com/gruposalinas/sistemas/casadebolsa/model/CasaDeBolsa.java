/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gruposalinas.sistemas.casadebolsa.model;

import java.util.ArrayList;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.Accion;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.Cliente;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.Domicilio;

/**
 *
 * @author 180917_GPO_SALINAS
 */
public class CasaDeBolsa {

    private final String NOMBRE;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private ArrayList<Cliente> clientes;
    private static final CasaDeBolsa INSTANCIA = new CasaDeBolsa();
    public ArrayList<Accion> acciones = new ArrayList<>();
//    private static final Accion acciones[]={new Accion("Acc1",100.0,10),new Accion("Acc2",200.0,30),new Accion("Acc3",250.0,25)};

    private CasaDeBolsa() {
        NOMBRE = "JAVAPLUS";
        domicilio = new Domicilio("calle", "numero", "colonia", "localidad", "estado", 1400);
        rfc = "";
        telefono = "9512038719";
        clientes = new ArrayList<>();

        acciones.add(new Accion("Acc1", 100.0, 10));
        acciones.add(new Accion("Acc2", 200.0, 30));
        acciones.add(new Accion("Acc3", 250.0, 25));
    }

    public static CasaDeBolsa getInstancia() {
        return INSTANCIA;
    }

    public String getNombre() {
        return NOMBRE;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public void ImprimirBiemvenida() {
        StringBuilder sb = new StringBuilder();
        sb.append("=============================\n");
        sb.append("      WELCOM ");
        sb.append(NOMBRE);
        sb.append("\n=============================");
        System.out.println(sb.toString());
    }

    public void imprimeAccionesDisponibles() {
        System.out.println("**ACCIONES DISPONIBLES**");
        acciones.forEach(s -> {System.out.println(s.toString());System.out.println("---------------");});
    }
}
