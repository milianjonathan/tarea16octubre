/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.Libro;
import Modelo.Conexion;
import Modelo.modeloLibro;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAVIER OSORIO
 */
public class ABC extends javax.swing.JFrame {

    Conexion con = new Conexion("jdbc:sqlserver://localhost:1433;databaseName=TAREA_MVC;user=usrTIENDA;password=123456;");

    modeloLibro modlb = new modeloLibro();
    Menu m = new Menu();

    /**
     * Creates new form ABC
     */
    public ABC() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void Mostrar_Tabla() {
        Connection conectar = con.Conectar();
        String[] Titulos = {"id_libro", "genero_libro", "fecha_libro", "nombre_libro", "autor_libro", "paginas_libro", "contenido_libro"};
        DefaultTableModel Modelo = new DefaultTableModel(null, Titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//hace que las celdas de la tabla no se pueda editar, SOLO LECTURA
            }
        };
        try {
            PreparedStatement sql = conectar.prepareCall("execute obtener_libros");
            ResultSet rs = sql.executeQuery();
            String[] datos = new String[7];

            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                Modelo.addRow(datos);
            }
            jtblLibros.setModel(Modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiar_texto() {
        this.txtId.setText("");
        this.txtAutor.setText("");
        this.txtaContenido.setText("");
        this.txtFecha.setText("");
        this.txtNombre.setText("");
        this.txtPaginas.setText("");
        this.txtaContenido.setText("");
        this.cbxGenero.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblLibros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtPaginas = new javax.swing.JTextField();
        cbxGenero = new javax.swing.JComboBox<>();
        btnIngresarR = new javax.swing.JButton();
        btnRegresarMenu = new javax.swing.JButton();
        btnActualizarR = new javax.swing.JButton();
        btnBorrarR = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaContenido = new javax.swing.JTextArea();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblLibros);

        jLabel1.setText("ID Libro:");

        jLabel2.setText("Genero:");

        jLabel3.setText("Fecha:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Autor:");

        jLabel6.setText("Paginas:");

        jLabel7.setText("Contenido:");

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Terror", "Romantica", "Ciencia Ficcion", "Historia", "Biografia", "Autoayuda", "Poesia", "Infantil" }));

        btnIngresarR.setText("Insertar Registro");
        btnIngresarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarRActionPerformed(evt);
            }
        });

        btnRegresarMenu.setText("Regresar Menu");
        btnRegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuActionPerformed(evt);
            }
        });

        btnActualizarR.setText("Actualizar Registro");
        btnActualizarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRActionPerformed(evt);
            }
        });

        btnBorrarR.setText("Borrar Registro");
        btnBorrarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarRActionPerformed(evt);
            }
        });

        txtaContenido.setColumns(20);
        txtaContenido.setRows(5);
        jScrollPane2.setViewportView(txtaContenido);

        btnLimpiar.setText("Limpiar Textos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                                    .addComponent(cbxGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtFecha)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(95, 95, 95)
                                        .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnActualizarR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBorrarR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegresarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIngresarR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresarR))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarR))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnBorrarR)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresarMenu))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnLimpiar))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuActionPerformed
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarMenuActionPerformed

    private void btnIngresarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarRActionPerformed
        Libro lb = new Libro(con.Conectar());
        if (this.cbxGenero.getSelectedItem().toString() == "Seleccione..." || this.txtFecha.getText().isEmpty() || this.txtNombre.getText().isEmpty() || this.txtAutor.getText().isEmpty() || this.txtPaginas.getText().isEmpty() || this.txtaContenido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los datos correspondientes, escoja un genero", "AVISO", 2);
        } else {
            modlb.setGenero(this.cbxGenero.getSelectedItem().toString());
            modlb.setFecha(Integer.parseInt(this.txtFecha.getText()));
            modlb.setNombre(this.txtNombre.getText());
            modlb.setAutor(this.txtAutor.getText());
            modlb.setPaginas(Integer.parseInt(this.txtPaginas.getText()));
            modlb.setContenido(this.txtaContenido.getText());
            if (lb.Insertar(modlb)) {
                JOptionPane.showMessageDialog(null, "Registro ingresado correctamente");
                limpiar_texto();
                m.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al ingresar", "ERROR", JOptionPane.ERROR_MESSAGE);
                limpiar_texto();
            }
        }
    }//GEN-LAST:event_btnIngresarRActionPerformed

    private void btnActualizarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRActionPerformed
        Libro lb = new Libro(con.Conectar());
        if (this.txtId.getText().isEmpty() || this.cbxGenero.getSelectedItem().toString() == "Seleccione..." || this.txtFecha.getText().isEmpty() || this.txtNombre.getText().isEmpty() || this.txtAutor.getText().isEmpty() || this.txtPaginas.getText().isEmpty() || this.txtaContenido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los datos correspondientes, escoja un genero", "AVISO", 2);
        } else {
            modlb.setId(Integer.parseInt(this.txtId.getText()));
            modlb.setGenero(this.cbxGenero.getSelectedItem().toString());
            modlb.setFecha(Integer.parseInt(this.txtFecha.getText()));
            modlb.setNombre(this.txtNombre.getText());
            modlb.setAutor(this.txtAutor.getText());
            modlb.setPaginas(Integer.parseInt(this.txtPaginas.getText()));
            modlb.setContenido(this.txtaContenido.getText());
            if (lb.actualizar(modlb)) {
                JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
                limpiar_texto();
                m.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar", "ERROR", JOptionPane.ERROR_MESSAGE);
                limpiar_texto();
            }
        }
    }//GEN-LAST:event_btnActualizarRActionPerformed

    private void btnBorrarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarRActionPerformed
        Libro lb = new Libro(con.Conectar());
        if (this.txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado o ingresado un registro", "AVISO", 2);
        } else {
            modlb.setId(Integer.parseInt(this.txtId.getText()));
            if (lb.eliminar(modlb)) {
                JOptionPane.showMessageDialog(null, "Registro borrado correctamente");
                limpiar_texto();
                m.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
                limpiar_texto();
            }
        }
    }//GEN-LAST:event_btnBorrarRActionPerformed

    private void jtblLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblLibrosMouseClicked
        int fila = jtblLibros.rowAtPoint(evt.getPoint());
        txtId.setText(jtblLibros.getValueAt(fila, 0).toString());
        cbxGenero.setSelectedItem(jtblLibros.getValueAt(fila, 1));
        txtFecha.setText(jtblLibros.getValueAt(fila, 2).toString());
        txtNombre.setText(jtblLibros.getValueAt(fila, 3).toString());
        txtAutor.setText(jtblLibros.getValueAt(fila, 4).toString());
        txtPaginas.setText(jtblLibros.getValueAt(fila, 5).toString());
        txtaContenido.setText(jtblLibros.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_jtblLibrosMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar_texto();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ABC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarR;
    public javax.swing.JButton btnBorrarR;
    public javax.swing.JButton btnIngresarR;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresarMenu;
    public javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jtblLibros;
    public javax.swing.JTextField txtAutor;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPaginas;
    public javax.swing.JTextArea txtaContenido;
    // End of variables declaration//GEN-END:variables
}
