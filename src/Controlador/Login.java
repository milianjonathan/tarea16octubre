/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import Modelo.modeloLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            PreparedStatement sql = conection.prepareStatement("if not exists (select * from sysobjects where name='TB_LOGIN' and xtype='U')\n"
                    + "       CREATE TABLE TB_LOGIN ( IDmascota varchar(50) not null PRIMARY KEY, \n"
                    + "	   edad int, nombreDuenio varchar(50), \n"
                    + "	   raza varchar(30), diagnostico varchar(200), telefono int )");
            sql.executeQuery();
            PreparedStatement insertar = conection.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?)");
            insertar.setString(1, login.getNombre());
            insertar.setString(2, login.getPass());
            insertar.setInt(3, login.getRango());

            return insertar.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean Logear(){
         try {
            Statement resultados = conection.createStatement();

            String consulta = "obtener_libros";
            ResultSet rs = resultados.executeQuery(consulta);

            
            while (rs.next()) {
                
            }
            rs.close();
            resultados.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
}
