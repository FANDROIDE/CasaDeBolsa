/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casadebolsa.test;

import java.time.LocalDate;
import mx.com.gruposalinas.sistemas.casadebolsa.model.CasaDeBolsa;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.Accion;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.Cliente;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.Portafolio;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.ServicioAClientes;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.ServicioAClientesImp;

/**
 *
 * @author 180917_GPO_SALINAS
 */
public class CasaDeBolsaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //BIENVENIDA
        CasaDeBolsa casa = CasaDeBolsa.getInstancia();
        casa.ImprimirBiemvenida();
        //LOGIN EJECUTIVO
        ServicioAClientes ejecutivo = new ServicioAClientesImp();
        Cliente cliente = new Cliente();
        cliente.setClaveCliente(1);
        cliente.setNombre("Feliciano");
        cliente.setApellidoPaterno("Martinez");
        cliente.setApellidoMaterno("Santiago");
        cliente.setFechaNacimiento(LocalDate.now().minusYears(25).minusMonths(2).plusDays(1));
        cliente.setRfc("MASFMS");
        //ALTA CLIENTE
//        ejecutivo.altaCliente(cliente);
        //MOSTRAR
        Cliente c1 = ejecutivo.consultarCliente(1);
        System.out.println(c1.toString());
        //CAMBIAR
        cliente.setNombre("Luis Fernando");
        ejecutivo.cambiosDatosCliente(cliente);
        //BORRAR
//        ejecutivo.bajaCliente(1);
        //LOGIN CLIENTE
        System.out.println("Consulta del cliente");
        c1=ejecutivo.consultarCliente(1);
        System.out.println(c1.toString());
        //LISTAR ACCIONES
        casa.imprimeAccionesDisponibles();
        
        //COMPRAR 3 ACCIONES
        Cliente clienteCompra=ejecutivo.consultarCliente(1);
        clienteCompra.setPortafolio(new Portafolio());
        Portafolio port=clienteCompra.getPortafolio();
        port.agregarAccion(new Accion("Acc50", 100.0, 10));
        
        System.out.println(port.getSaldoTotalEnAcciones());
        //HISTORICO DE MOVIMIENTO
        //LISTAR ACCIONES DEL CLIENTE
        //
    }

}
