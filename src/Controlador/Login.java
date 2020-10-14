/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import Modelo.modeloLogin;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALEXIS VIDES
 */
public class Login {

    private final Connection conection;

    public Login(Connection connection) {
        this.conection = connection;
    }

    public boolean crearUsuario(modeloLogin login) {
        try {
            PreparedStatement insertar = conection.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?)");
            insertar.setString(1, login.getNombre());
            insertar.setString(2, login.getPass());
            insertar.setString(3, login.getRango());
            
            return insertar.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null, ex);
            return false;
        }

        
    }
     

}
