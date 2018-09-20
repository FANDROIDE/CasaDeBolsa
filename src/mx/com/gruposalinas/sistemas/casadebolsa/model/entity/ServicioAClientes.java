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
public interface ServicioAClientes {
    public void altaCliente(Cliente cliente);
    public void bajaCliente(int claveCliente);
    public void cambiosDatosCliente(Cliente cliente);
    public Cliente consultarCliente(int claveCliente);
    public default void listarClientes(){
        System.out.println("listando clientes");
    }
}
