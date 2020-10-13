package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Logger.getLogger(Conexión.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
