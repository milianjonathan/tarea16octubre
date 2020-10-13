package Controlador;

import Modelo.Conexión;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Libro;

/**
 *
 * @author ALEXIS VIDES
 */
public class Login {

     Connection con = Conexión.getConexion();

    public boolean Create(Libro libro) {

        try {
            PreparedStatement consulta = con.prepareStatement("INSERT INTO libro VALUES(?,?,?,?)");
            consulta.setString(1, libro.getNombre());
            consulta.setString(2, libro.getAutor());
            consulta.setInt(3, libro.getPaginas());
            consulta.setString(4, libro.getContenido());

            if (consulta.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
