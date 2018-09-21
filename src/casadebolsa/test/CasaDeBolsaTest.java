/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casadebolsa.test;

import java.time.LocalDate;
import java.util.Scanner;
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
        Scanner s = new Scanner(System.in);
        int opcion;
        do {
            Cliente cliente;
            System.out.println("1.- Loguear como ejecutivo\n2.-Loguear como usuario\n3.-Salir");
            opcion = s.nextInt();
            ServicioAClientes ejecutivo = new ServicioAClientesImp();
            if (opcion == 1) {
                do {
                    System.out.println("\n\n1.- Agregar nuevo cliente\n2.- Listar Clientes\n3.- Modificar un Cliente\n4.- Eliminar un cliente\n5.- Buscar un cliente\n6.-Salir");
                    opcion = s.nextInt();
                    if (opcion == 1) {
                        agregarCliente(ejecutivo);
                    }
                    if (opcion == 2) {
                        listarClientes(ejecutivo);
                    }
                    if (opcion == 3) {
                        cambiarCliente(ejecutivo);
                    }
                    if (opcion == 4) {
                        eliminarCliente(ejecutivo);
                    }
                    if (opcion == 5) {
                        cliente = buscarCliente(ejecutivo);
                        System.out.println(cliente.toString());
                    }
                } while (opcion != 6);
            }
            if (opcion == 2) {
                cliente = buscarCliente(ejecutivo);
                int op;
                do {
                    System.out.println("1.- Listar acciones de la casa\n2.- Comprar acciones\n3.- Historico de movimientos\n4.- Acciones del cliente\n5.- Vender Acciones\n6.-Utilidades\n7.- Salir");
                    op = new Scanner(System.in).nextInt();
                    if (op == 1) {
                        casa.imprimeAccionesDisponibles();
                    }
                    if(op==2){
                        comprarAcciones(cliente,casa);
                    }
                    if(op==3){
                        cliente.getPortafolio().imprimirHistorico();
                    }
                    if(op==4){
                        cliente.getPortafolio().imprimirAcciones();
                    }
                    if(op == 5){
                        venderAcciones(cliente,casa);
                    }
                    if(op==6){
                        verUtilidades(cliente);
                    }
                } while (op != 7);
            }
        } while (opcion != 3);
        casa.imprimirDespedida();
        //////////////////////////////////////
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
        cliente.setNombre("Feliciano");
        ejecutivo.cambiosDatosCliente(cliente);
        //BORRAR
//        ejecutivo.bajaCliente(1);
        //LOGIN CLIENTE
        System.out.println("Consulta del cliente");
        c1 = ejecutivo.consultarCliente(1);
        System.out.println(c1.toString());
        //LISTAR ACCIONES
        casa.imprimeAccionesDisponibles();

        //COMPRAR 3 ACCIONES
        Cliente clienteCompra = ejecutivo.consultarCliente(1);
        clienteCompra.setPortafolio(new Portafolio());
        Portafolio port = clienteCompra.getPortafolio();
//        port.agregarAccion(new Accion("Acc50", 100.0, 10));
        System.out.println("*** SE COMPRA ACCIONES****");
        port.comprarAccion(casa.venderAccion("Acc1", 1));
        port.comprarAccion(casa.venderAccion("Acc2", 1));
        port.comprarAccion(casa.venderAccion("Acc3", 1));
        System.out.println(port.getSaldoTotalEnAcciones());
        //HISTORICO DE MOVIMIENTO
        System.out.println("**HISTORICO DE MOVIMIENTOS**");
        port.imprimirHistorico();
        //LISTAR ACCIONES DEL CLIENTE
        System.out.println("**ACCIONES DEL CLIENTE**");
        clienteCompra.getPortafolio().imprimirAcciones();
        //vender una accion
        System.out.println("**VENDER ACCIONES**");
        casa.comprarAccion(port.venderAccion("Acc1", 1));
        //historico de movimiento
        System.out.println("**HISTORICO DE MOVIMIENTOS**");
        port.imprimirHistorico();
        System.out.println("**ACCIONES DEL CLIENTE**");
        port.imprimirAcciones();
        //determinar utilidad de las acciones
        //despedir
    }

    public static void agregarCliente(ServicioAClientes ejecutivo) {
        Scanner s = new Scanner(System.in);
        Cliente cliente = new Cliente();
        String cadena;
        System.out.println("Inserte el identificador: ");
        cliente.setClaveCliente(s.nextInt());
        System.out.println("Dame el nombre del cliente: ");
        cadena=s.nextLine();
        cliente.setNombre(cadena);
        System.out.println("Dame el apellido paterno del cliente: ");
        cadena=s.nextLine();
        cliente.setApellidoPaterno(cadena);
        System.out.println("Dame el apellido materno del cliente: ");
        cadena=s.nextLine();
        cliente.setApellidoMaterno(cadena);
        cliente.setFechaNacimiento(LocalDate.now().minusYears(25).minusMonths(2).plusDays(1));
        System.out.println("Dame el rfc del cliente: ");
        cadena=s.nextLine();
        cliente.setRfc(cadena);
        //ALTA CLIENTE
        ejecutivo.altaCliente(cliente);
        System.out.println("Se ha agregado un nuevo cliente");
    }

    public static Cliente buscarCliente(ServicioAClientes ejecutivo) {
        ejecutivo.listarClientes();
        System.out.println("id del cliente");
        int id = new Scanner(System.in).nextInt();
        Cliente c1 = ejecutivo.consultarCliente(id);
        return c1;
    }

    public static void listarClientes(ServicioAClientes ejecutivo) {
        ejecutivo.listarClientes();
    }

    public static void eliminarCliente(ServicioAClientes ejecutivo) {
        System.out.println("Selecciona el Id del cliente a eliminar: ");
        ejecutivo.listarClientes();
        ejecutivo.bajaCliente(new Scanner(System.in).nextInt());
    }

    public static void cambiarCliente(ServicioAClientes ejecutivo) {
        Cliente c = buscarCliente(ejecutivo);
        System.out.println("Cambiar nombre");
        c.setNombre(new Scanner(System.in).nextLine());
        System.out.println("Cambiar apellido paterno");
        c.setApellidoPaterno(new Scanner(System.in).nextLine());
        System.out.println("Cambiar apellido materno");
        c.setApellidoMaterno(new Scanner(System.in).nextLine());
        ejecutivo.cambiosDatosCliente(c);
    }
    public static void comprarAcciones(Cliente cliente,CasaDeBolsa casa){ 
        casa.imprimeAccionesDisponibles();
        System.out.println("**Seleccione el nombre de la accion a comprar**");
        Portafolio port=cliente.getPortafolio();
        String nombre=new Scanner(System.in).nextLine();
        System.out.println("Ingrese el numero de acciones a comprar");
        int num=new Scanner(System.in).nextInt();
        port.comprarAccion(casa.venderAccion(nombre, num));
    }
    public static void venderAcciones(Cliente cliente, CasaDeBolsa casa){
        System.out.println("Acciones disponibles del cliente");
        cliente.getPortafolio().imprimirAcciones();
        System.out.println("Escriba el nombre de la accion a vender");
        String nombre=new Scanner(System.in).nextLine();
        System.out.println("Ingrese el numero de aaciones a vender");
        int num=new Scanner(System.in).nextInt();
        casa.comprarAccion(cliente.getPortafolio().venderAccion(nombre, num));
    }
    public static void verUtilidades(Cliente cliente){
        cliente.getPortafolio().verUtilidades();
//        cliente.getPortafolio()
    }
}
