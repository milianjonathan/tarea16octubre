package Controlador;

//Librerías a utilizar
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buscar {
    
    private Connection conector;

    public Buscar(Connection conector) {
        this.conector = conector;
    }
    
    public ResultSet buscarLibro(String palabra){
        
        
        try {
            Statement declaracion = conector.createStatement();
            ResultSet resultados = declaracion.executeQuery("EXEC buscar_libro @palabra='"+palabra+"'");
            return resultados;

        } catch (SQLException ex) {
            Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
}
