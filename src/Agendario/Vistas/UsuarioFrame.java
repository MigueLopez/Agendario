/*
 * Interfaz para el registro de Usuarios
 */
package Agendario.Vistas;

import Agendario.Datos.Usuario;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Regex
//[a-zA-Z0-9]{5,15} Login - Letras sin acentos y numeros, minimo 5 y maximo 15 caracteres
//[a-zA-ZÁáÉéÍíÓóÚú ]{1,30} Nombre - cualquier letra con acetos y espacios en blanco , mínimo 1 máximo 30
//[^\s]{5,15}  -Cualquier caracter excepto espacios en blanco (5 a 15 cracteres)

class VerifierNombre extends InputVerifier {
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        String regex = "[a-zA-ZÁáÉéÍíÓóÚú ]{1,30}";
        
        if(text.matches(regex)){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Debe capturar un NOMBRE válido");
        }
        return false;
    }
}

class VerifierLogin extends InputVerifier {
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        String regex = "[a-zA-Z0-9]{5,15}";
        
        if(text.matches(regex)){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Debe capturar un LOGIN válido");
        }
        return false;
    }
}

class VerifierPassword extends InputVerifier {
    public boolean verify(JComponent input) {
        String text = new String(((JPasswordField)input).getPassword());
        String regex = "[^\\s]{5,15}";
        
        if(text.matches(regex)){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Debe capturar una CONTRASEÑA válida");
        }
        return false;
    }
}

/**
 *
 * @author Miguel Ángel López Cervantes
 */
public class UsuarioFrame extends javax.swing.JFrame {
    
    private Usuario usuario;
    private String accion; //Agregar, Editar, Consultar

    /**
     * Creates new form UsuarioFrame
     */
    public UsuarioFrame(String accion) {
        initComponents();
        this.accion = accion;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblPassword2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtPassword2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setResizable(false);

        lblNombre.setText("Nombre:");

        txtNombre.setInputVerifier(new VerifierNombre());

        lblLogin.setText("Login:");

        txtLogin.setInputVerifier(new VerifierLogin());

        lblPassword.setText("Contraseña:");

        lblPassword2.setText("Repita Contraseña:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtPassword.setInputVerifier(new VerifierPassword());

        txtPassword2.setInputVerifier(new VerifierPassword());

        jLabel1.setText("De 5 a 15 caracteres");

        jLabel2.setText("Letras y numeros (de 5 a 15 caracteres)");

        jLabel3.setText("De 5 a 15 caracteres");

        jLabel4.setText("Máximo 30 caracteres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblLogin)
                            .addComponent(lblPassword)
                            .addComponent(lblPassword2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPassword2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //validar que las contraseñas coincidan
        if(txtPassword.getText().equals(txtPassword2.getText())){
            switch(accion.charAt(0)){
                case 'A': //Agregar
                    usuario = new Usuario(txtNombre.getText(),txtLogin.getText(),txtPassword.getText());
                    usuario.inserta();
                    dispose();
                    break;
                
                case 'E':
                    actualizaUsuario();
                    usuario.actualiza();
                    dispose();
                    break;
                
                case 'C':  //En la consulta simplemente se cierra la ventana
                    dispose();
                    break;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void llenarCamposFrame(ResultSet rs){
        //Tomar los datos del ResultSet y ponerlos en el Frame y en usuario
        usuario = new Usuario();
        try {
            usuario.setIdUsuario(rs.getInt("idusuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setLogin(rs.getString("login"));
            usuario.setPassword(rs.getString("password"));
            
            txtNombre.setText(usuario.getNombre());
            txtLogin.setText(usuario.getLogin());
            txtPassword.setText(usuario.getPassword());
            txtPassword2.setText(usuario.getPassword());            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
        }
    }
    
    public void inhabilitaCampos(){
        txtNombre.setEditable(false);
        txtLogin.setEditable(false);
        txtPassword.setEditable(false);
        txtPassword2.setEditable(false);
    }
    
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
            java.util.logging.Logger.getLogger(UsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioFrame("Agregar").setVisible(true);
            }
        });
    }
    
    private void actualizaUsuario(){        
        usuario.setNombre(txtNombre.getText());
        usuario.setLogin(txtLogin.getText());
        usuario.setPassword(txtPassword.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword2;
    // End of variables declaration//GEN-END:variables
}
