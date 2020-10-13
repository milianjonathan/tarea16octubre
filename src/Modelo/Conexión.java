package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ALEXIS VIDES
 */
public class Conexión {
    public static Connection getConexion() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName= ;user= ;password= ";
        try {
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
