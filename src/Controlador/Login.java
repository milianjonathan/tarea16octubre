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
import java.util.ArrayList;
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
                    + "CREATE TABLE TB_LOGIN(\n"
                    + "id_usuario INT IDENTITY(1,1) NOT NULL PRIMARY KEY,\n"
                    + "usuario VARCHAR(100) NOT NULL,\n"
                    + "pass VARCHAR(100) NOT NULL,\n"
                    + "rol INT NOT NULL);");
            sql.executeQuery();
            PreparedStatement insertar = conection.prepareStatement("INSERT INTO TB_LOGIN VALUES(?,?,?,?)");
            insertar.setString(2, login.getNombre());
            insertar.setString(3, login.getPass());
            insertar.setInt(4, login.getRango());

            return insertar.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<modeloLogin> Logear() {
        ArrayList<modeloLogin> Log = new ArrayList<modeloLogin>();
        try {
            Statement resultados = conection.createStatement();

            ResultSet rs = resultados.executeQuery("obtener_libros");

            while (rs.next()) {
                Log.add(new modeloLogin(rs.getInt("id_usuario"), rs.getString("usuario"), rs.getString("pass"),
                        rs.getInt("rol")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return Log;

    }
}
