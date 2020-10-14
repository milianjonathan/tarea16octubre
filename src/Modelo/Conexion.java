package Modelo;

//Librerías a utilizar
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    //Variables de la clase
    private final String url_conexion;
    private Connection conector;

    //Constructor
    public Conexion(String url_conexion) {
        this.url_conexion = url_conexion;
    }

    //Método Conectar: Retorna la conexión con la base de datos
    public Connection Conectar() {

        //Tratando de conectarse con la base de datos
        try {

            conector = DriverManager.getConnection(url_conexion);
            System.out.println("Hola");

        } catch (SQLException ex) {
            
            System.out.println("Hubo un problema para conectarse a la base de datos. A continuación los detalles: ");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        //El método retorna un conector
        return conector;

    }
    
}
