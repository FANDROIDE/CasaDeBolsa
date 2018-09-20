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
public class Cliente extends Persona {

    private int claveCliente;
    private String rfc;
    private Portafolio portafolio;

    public Cliente() {
    }

    public int getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(int claveCliente) {
        this.claveCliente = claveCliente;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Portafolio getPortafolio() {
        return portafolio;
    }

    public void setPortafolio(Portafolio portafolio) {
        this.portafolio = portafolio;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre)
                .append("Apellido Paterno: ").append(apellidoPaterno)
                .append("Apellido Materno: ").append(apellidoMaterno)
                .append("RFC: ").append(rfc)
                .append("Fecha de Nacimiento: ").append(fechaNacimiento);
        return sb.toString();
    }

}
