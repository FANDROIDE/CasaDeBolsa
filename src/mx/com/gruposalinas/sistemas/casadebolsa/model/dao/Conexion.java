/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gruposalinas.sistemas.casadebolsa.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 180917_GPO_SALINAS
 */
public class Conexion {
    
    private final static String url = "jdbc:derby://localhost:1527/GS_CDB2";
    private final static String usuario = "usuario";
    private final static String password = "password";

    public static Connection obtenConexion() {
        Connection cxn = null;
        try {
            cxn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            while (ex != null) {
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code:" + ex.getErrorCode());
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }
        return cxn;
    }

    public static void cierraObjeto(AutoCloseable... objsCerrables) {
        for (AutoCloseable cerrable : objsCerrables) {
            if (cerrable instanceof AutoCloseable) {
                try {
                    if (cerrable != null) {
                        cerrable.close();
                    }
                } catch (Exception ex) {
                    System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
                    
                }
            }
        }
    }
}
