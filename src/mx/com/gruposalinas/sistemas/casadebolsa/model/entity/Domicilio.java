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
public class Domicilio {
    private String calle;
    private String numero;
    private String colonia;
    private String localidad;
    private String estado;
    private int codigoPostal;

    public Domicilio(String calle, String numero, String colonia, String localidad, String estado, int codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.localidad = localidad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public Domicilio() {
    }
    
    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the codigoPostal
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        sb.append("calle: ").append(calle).append("/");
        sb.append("numero: ").append(numero).append("/");
        sb.append("colonia: ").append(colonia).append("/");
        sb.append("localidad: ").append(localidad).append("/");
        sb.append("estado: ").append(estado).append("/");
        sb.append("cp: ").append(codigoPostal).append("]");
        return sb.toString();
    }
    
}
