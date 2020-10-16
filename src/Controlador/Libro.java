package Controlador;

import Modelo.modeloLibro;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALEXIS VIDES
 */
public class Libro {

    private final Connection conection;

    public Libro(Connection connection) {
        this.conection = connection;
    }

    public boolean Insertar(modeloLibro libro) {
        try {
            PreparedStatement sql = conection.prepareStatement("if not exists (select * from sysobjects where name='libro' and xtype='U')"
                    + "CREATE TABLE libro (\n"
                    + "id_libro INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,\n"
                    + "genero_libro VARCHAR(100) NOT NULL,\n"
                    + "fecha_libro INT NOT NULL,\n"
                    + "nombre_libro VARCHAR(100) NOT NULL,\n"
                    + "autor_libro VARCHAR(100) NOT NULL,\n"
                    + "paginas_libro INT NOT NULL,\n"
                    + "contenido_libro VARCHAR(MAX) NOT NULL);");

            sql.executeQuery();
            PreparedStatement insertar = conection.prepareStatement("INSERT INTO libro VALUES(?,?,?,?)");

            return insertar.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<modeloLibro> Buscar() {
        ArrayList<modeloLibro> lib = new ArrayList<modeloLibro>();
        try {
            Statement resultados = conection.createStatement();

            ResultSet rs = resultados.executeQuery("obtener_libros");

            while (rs.next()) {
                lib.add(new modeloLibro(rs.getInt("id_usuario"), rs.getString("genero_libro"), rs.getInt("fecha_libro"),
                        rs.getString("nombre_libro"), rs.getInt("paginas_libro"),
                        rs.getString("autor_libro"), rs.getString("contenido_libro")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lib;

    }
    
    //Javier
    public void Seleccionar_libros(DefaultTableModel model){
        try {
            PreparedStatement sql = conection.prepareStatement("execute obtener_libros");
            ResultSet rs = sql.executeQuery();
            String[] datos = new String[5];
            while(rs.next()){
                for(int i =0; i<7;i++){
                    datos[i] = rs.getString(i+1);
                }
                model.addRow(datos);
            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
