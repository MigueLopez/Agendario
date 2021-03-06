/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agendario.Vistas;


import java.sql.*;
import Agendario.Conexion.ConexionPostgreSQL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author migue_000
 */
public class BusquedaFrame extends javax.swing.JFrame {
    private String campo;
    private String tabla;
    private String accion; //Consultar,Editar,Borrar
    private int idUsuario; //Id del usuario logeado al momento

    /**
     * Creates new form BusquedaFrame
     */
    public BusquedaFrame(String label,String campo, String tabla, String accion, int idUsuario) {
        initComponents();
        lblCampo.setText(label);
        this.campo = campo;
        this.tabla = tabla;
        this.accion = accion;
        this.idUsuario = idUsuario;
        btnBuscar.setActionCommand(accion);
        btnBuscar.setText(accion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCampo = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblCampo.setText("Clave:");

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCampo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCampo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Dependiendo la tabla se crea el Frame
        ResultSet rs;
        switch(tabla.charAt(0)){
            case 'u' : //Usuario
                rs = ConexionPostgreSQL.obtenerRegistro(tabla, campo + " = '" + txtBusca.getText() + "'");
                switch(accion.charAt(0)){
                    case 'E': //Editar
                        try{
                            if(rs.next()){
                                UsuarioFrame uf = new UsuarioFrame("Editar");
                                uf.llenarCamposFrame(rs);
                                uf.setVisible(true);
                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"No se encontró el registro");
                            }
                        }catch (SQLException e) {
                            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
                        }        
                        break;
                    case 'C': //Consultar
                        try{
                            if(rs.next()){
                                UsuarioFrame uf = new UsuarioFrame("Consultar");
                                uf.llenarCamposFrame(rs);
                                uf.inhabilitaCampos();
                                uf.setVisible(true);
                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"No se encontró el registro");
                            }
                        }catch (SQLException e) {
                            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
                        }  
                        break;
                    case 'B': //Borrar
                        if(ConexionPostgreSQL.borrarRegistro(tabla,campo + " = '" + txtBusca.getText() + "'")){
                            JOptionPane.showMessageDialog(null,"El registro se eliminó correctamente");
                        }
                        this.dispose();
                        break;
                }
                break;
            case 'm' : //Materia
                rs = ConexionPostgreSQL.obtenerRegistro(tabla, campo + " = '" + txtBusca.getText() + "' AND idUsuario = " + idUsuario);
                switch(accion.charAt(0)){
                    case 'E': //Editar
                        try{
                            if(rs.next()){
                                MateriasFrame mf = new MateriasFrame("Editar",idUsuario);
                                mf.llenarCamposFrame(rs);
                                mf.setVisible(true);
                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"No se encontró el registro");
                            }
                        }catch (SQLException e) {
                            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
                        }        
                        break;
                    case 'C': //Consultar
                        try{
                            if(rs.next()){
                                MateriasFrame mf = new MateriasFrame("Consultar",idUsuario);
                                mf.llenarCamposFrame(rs);
                                mf.inhabilitaCampos();
                                mf.setVisible(true);
                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"No se encontró el registro");
                            }
                        }catch (SQLException e) {
                            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
                        }  
                        break;
                    case 'B': 
                        try {
                            //Borrar
                            rs.next();
                            ConexionPostgreSQL.borrarRegistro("clase","idmateria = " + String.valueOf(rs.getInt("idmateria")));
                        } catch (SQLException ex) {
                            System.out.println("Error al eliminar registros de clases: " + ex.getMessage());
                        }
                        if(ConexionPostgreSQL.borrarRegistro(tabla,campo + " = '" + txtBusca.getText() + "'")){
                            JOptionPane.showMessageDialog(null,"El registro se eliminó correctamente");
                        }
                        this.dispose();
                        break;
                }
                break;
            case 'e' : //Evento
                rs = ConexionPostgreSQL.obtenerRegistro(tabla, campo + " = '" + txtBusca.getText() + "' AND idUsuario = " + idUsuario);
                switch(accion.charAt(0)){
                     case 'E': //Editar
                        try{
                            if(rs.next()){
                                EventoFrame mf = new EventoFrame("Editar",idUsuario);
                                mf.llenarCamposFrame(rs);
                                mf.setVisible(true);
                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"No se encontró el registro");
                            }
                        }catch (SQLException e) {
                            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
                        }        
                        break;
                    case 'C': //Consultar
                        try{
                            if(rs.next()){
                                EventoFrame ef = new EventoFrame("Consultar",idUsuario);
                                ef.llenarCamposFrame(rs);
                                ef.inhabilitaCampos();
                                ef.setVisible(true);
                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"No se encontró el registro");
                            }
                        }catch (SQLException e) {
                            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
                        }  
                        break;
                    case 'B': 
                        if(ConexionPostgreSQL.borrarRegistro(tabla,campo + " = '" + txtBusca.getText() + "'")){
                            JOptionPane.showMessageDialog(null,"El registro se eliminó correctamente");
                        }
                        this.dispose();
                        break;
                }
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
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
            java.util.logging.Logger.getLogger(BusquedaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaFrame("Clave Materia:","clave","materia","Editar",2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel lblCampo;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
