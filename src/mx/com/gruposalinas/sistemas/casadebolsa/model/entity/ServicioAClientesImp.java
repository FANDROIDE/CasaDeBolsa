/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gruposalinas.sistemas.casadebolsa.model.entity;

import mx.com.gruposalinas.sistemas.casadebolsa.model.dao.ClienteDao;

/**
 *
 * @author 180917_GPO_SALINAS
 */
public class ServicioAClientesImp implements ServicioAClientes {
    ClienteDao c;

    public ServicioAClientesImp() {
        c=new ClienteDao();
    }
    
    @Override
    public void altaCliente(Cliente cliente) {
        c.altaCliente(cliente);
        
    }

    @Override
    public void bajaCliente(int claveCliente) {
        c.bajaCliente(claveCliente);
    }

    @Override
    public void cambiosDatosCliente(Cliente cliente) {
        c.cambioCliente(cliente);
    }

    @Override
    public Cliente consultarCliente(int claveCliente) {
        return c.consultaCliente(claveCliente);
    }
    
}
