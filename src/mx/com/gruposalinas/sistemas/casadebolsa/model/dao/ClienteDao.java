/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gruposalinas.sistemas.casadebolsa.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.Cliente;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.Domicilio;
import mx.com.gruposalinas.sistemas.casadebolsa.model.entity.Portafolio;

/**
 *
 * @author 180917_GPO_SALINAS
 */
public class ClienteDao {

    public ClienteDao() {
    }

    public void altaCliente(Cliente c) {
        var sqlSelect = "INSERT INTO cliente (clavecliente, nombres, apellidopaterno, apellidomaterno, fechanacimiento, rfc, iddomicilio, idportafolio)"
                + "    VALUES (?,?,?,?,?,?,?,?)";
        Connection conexion = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.obtenConexion();
            pStmt = conexion.prepareStatement(sqlSelect);
            pStmt.setInt(1, c.getClaveCliente());
            pStmt.setString(2, c.getNombre());
            pStmt.setString(3, c.getApellidoPaterno());
            pStmt.setString(4, c.getApellidoMaterno());
            pStmt.setDate(5, Date.valueOf(c.getFechaNacimiento()));
            pStmt.setString(6, c.getRfc());
            pStmt.setInt(7, 1);
            pStmt.setInt(8, 1);
            int res = pStmt.executeUpdate();
        } catch (SQLException ex) {
//            domDAO.baja(c.getDomicilio());
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Hubo un error al agregar un cliente");
        } finally {
            Conexion.cierraObjeto(rs, pStmt, conexion);
        }
    }

    public void bajaCliente(int  claveCliente) {
        var sqlSelect = "DELETE FROM cliente WHERE clavecliente=?";
        Connection conexion = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.obtenConexion();
            pStmt = conexion.prepareStatement(sqlSelect);
            pStmt.setInt(1, claveCliente);
            int res = pStmt.executeUpdate();
//            DomicilioDAO domDAO = new DomicilioDAO();
//            PortafolioDAO portDAO = new PortafolioDAO();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.cierraObjeto(rs, pStmt, conexion);
        }
    }

    public Cliente consultaCliente(int claveCliente) {
        var sqlSelect = "SELECT * FROM cliente WHERE clavecliente=?";
        Connection conexion = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        Cliente c = null;
        try {
            conexion = Conexion.obtenConexion();
            pStmt = conexion.prepareStatement(sqlSelect);
            pStmt.setInt(1, claveCliente);
            rs = pStmt.executeQuery();
//            DomicilioDAO domDAO = new DomicilioDAO();
//            PortafolioDAO portDAO = new PortafolioDAO();
            while (rs.next()) {
                c = new Cliente();
                c.setClaveCliente(rs.getInt("CLAVECLIENTE"));
                c.setNombre(rs.getString("NOMBRES"));
                c.setApellidoPaterno(rs.getString("APELLIDOPATERNO"));
                c.setApellidoMaterno(rs.getString("APELLIDOMATERNO"));
                c.setRfc("RFC");
                c.setFechaNacimiento((rs.getDate("FECHANACIMIENTO")).toLocalDate());
                c.setPortafolio(new Portafolio());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.cierraObjeto(rs, pStmt, conexion);
        }
        if (c == null) {
//            throw new NoExisteClienteException("No existe el cliente con el id: " + id);
            System.out.println("No existe el cliente");
        }

        return c;
    }

    public void cambioCliente(Cliente c) {
        var sqlSelect = "UPDATE cliente SET nombres=?, apellidopaterno=?, apellidomaterno=?,"
                + " fechanacimiento=?, rfc=?, iddomicilio=?, idportafolio=?"
                + " WHERE clavecliente=?";
        Connection conexion = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.obtenConexion();
            pStmt = conexion.prepareStatement(sqlSelect);
            pStmt.setString(1, c.getNombre());
            pStmt.setString(2, c.getApellidoPaterno());
            pStmt.setString(3, c.getApellidoMaterno());
            pStmt.setDate(4, Date.valueOf(c.getFechaNacimiento()));
            pStmt.setString(5, c.getRfc());
            pStmt.setInt(6, 1);
            pStmt.setInt(7, 1);
            pStmt.setInt(8, c.getClaveCliente());
            int res = pStmt.executeUpdate();
            System.out.println("Se cambia correctamente el cliente");
        } catch (SQLException ex) {
//            domDAO.baja(c.getDomicilio());
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.cierraObjeto(rs, pStmt, conexion);
        }
    }
        public List<Cliente> obtenListadoClientes() {
        List<Cliente> clientes = null;
        var sqlSelect = "SELECT * FROM CLIENTE";
        Connection conexion = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.obtenConexion();
            pStmt = conexion.prepareStatement(sqlSelect);
            rs = pStmt.executeQuery();
            clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente c1=new Cliente();
                c1.setClaveCliente(rs.getInt("CLAVECLIENTE"));
                c1.setNombre(rs.getString("NOMBRES"));
                c1.setApellidoPaterno(rs.getString("APELLIDOPATERNO"));
                c1.setApellidoMaterno(rs.getString("APELLIDOMATERNO"));
                c1.setRfc(rs.getString("RFC"));
                c1.setFechaNacimiento((rs.getDate("FECHANACIMIENTO")).toLocalDate());
                c1.setPortafolio(new Portafolio());
                clientes.add(c1);
            }
        } catch (SQLException ex) {
        } finally {
            Conexion.cierraObjeto(rs, pStmt, conexion);
        }
        return clientes;
    }
}
