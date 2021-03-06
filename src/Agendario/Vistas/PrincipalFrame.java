/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agendario.Vistas;

import Agendario.Conexion.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel Ángel López Cervantes
 */
public class PrincipalFrame extends javax.swing.JFrame {
    
    private int idUsuario;

    /**
     * Creates new form PrincipalFrame
     */
    public PrincipalFrame(int idUsuario) {
        initComponents();
        this.idUsuario = idUsuario;
        actualizaTablaHorario();
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
        listaEventos = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHorario = new javax.swing.JTable();
        lblHorario = new javax.swing.JLabel();
        lblEventos = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        menuModificarUsuario = new javax.swing.JMenuItem();
        menuMaterias = new javax.swing.JMenu();
        menuAgregarMateria = new javax.swing.JMenuItem();
        menuEditarMateria = new javax.swing.JMenuItem();
        menuConsultarMateria = new javax.swing.JMenuItem();
        menuEliminarMateria = new javax.swing.JMenuItem();
        menuEventos = new javax.swing.JMenu();
        menuAgregarEvento = new javax.swing.JMenuItem();
        menuEditarEvento = new javax.swing.JMenuItem();
        menuConsultarEvento = new javax.swing.JMenuItem();
        menuEliminarEvento = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        menuCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jScrollPane1.setViewportView(listaEventos);

        tablaHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaHorario);

        lblHorario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHorario.setText("HORARIO:");

        lblEventos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEventos.setText("EVENTOS:");

        menuPrincipal.setBorder(null);

        menuUsuario.setText("Usuario");

        menuModificarUsuario.setText("Modificar");
        menuModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(menuModificarUsuario);

        menuPrincipal.add(menuUsuario);

        menuMaterias.setText("Materias");

        menuAgregarMateria.setText("Agregar");
        menuAgregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarMateriaActionPerformed(evt);
            }
        });
        menuMaterias.add(menuAgregarMateria);

        menuEditarMateria.setText("Editar");
        menuEditarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarMateriaActionPerformed(evt);
            }
        });
        menuMaterias.add(menuEditarMateria);

        menuConsultarMateria.setText("Consultar");
        menuConsultarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarMateriaActionPerformed(evt);
            }
        });
        menuMaterias.add(menuConsultarMateria);

        menuEliminarMateria.setText("Eliminar");
        menuEliminarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarMateriaActionPerformed(evt);
            }
        });
        menuMaterias.add(menuEliminarMateria);

        menuPrincipal.add(menuMaterias);

        menuEventos.setText("Eventos");

        menuAgregarEvento.setText("Agregar");
        menuAgregarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarEventoActionPerformed(evt);
            }
        });
        menuEventos.add(menuAgregarEvento);

        menuEditarEvento.setText("Editar");
        menuEditarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarEventoActionPerformed(evt);
            }
        });
        menuEventos.add(menuEditarEvento);

        menuConsultarEvento.setText("Consultar");
        menuConsultarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarEventoActionPerformed(evt);
            }
        });
        menuEventos.add(menuConsultarEvento);

        menuEliminarEvento.setText("Eliminar");
        menuEliminarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarEventoActionPerformed(evt);
            }
        });
        menuEventos.add(menuEliminarEvento);

        menuPrincipal.add(menuEventos);

        menuSalir.setText("Salir");

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuSalir.add(menuLogout);

        menuCerrar.setText("Cerrar");
        menuCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarActionPerformed(evt);
            }
        });
        menuSalir.add(menuCerrar);

        menuPrincipal.add(menuSalir);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHorario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEventos))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHorario)
                    .addComponent(lblEventos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuEditarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarMateriaActionPerformed
        new BusquedaFrame("Clave Materia:","clave","materia","Editar",idUsuario).setVisible(true);
    }//GEN-LAST:event_menuEditarMateriaActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_menuCerrarActionPerformed

    private void menuModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarUsuarioActionPerformed
        new BusquedaFrame("Login:","login","usuario","Editar",idUsuario).setVisible(true);
    }//GEN-LAST:event_menuModificarUsuarioActionPerformed

    private void menuAgregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarMateriaActionPerformed
        new MateriasFrame("Agregar",idUsuario).setVisible(true);
    }//GEN-LAST:event_menuAgregarMateriaActionPerformed

    private void menuConsultarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarMateriaActionPerformed
        new BusquedaFrame("Clave Materia:","clave","materia","Consultar",idUsuario).setVisible(true);
    }//GEN-LAST:event_menuConsultarMateriaActionPerformed

    private void menuEliminarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarMateriaActionPerformed
        new BusquedaFrame("Clave Materia:","clave","materia","Borrar",idUsuario).setVisible(true);
    }//GEN-LAST:event_menuEliminarMateriaActionPerformed

    private void menuAgregarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarEventoActionPerformed
        new EventoFrame("Agregar",idUsuario).setVisible(true);
    }//GEN-LAST:event_menuAgregarEventoActionPerformed

    private void menuEditarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarEventoActionPerformed
        new BusquedaFrame("Título:","titulo","evento","Editar",idUsuario).setVisible(true);
    }//GEN-LAST:event_menuEditarEventoActionPerformed

    private void menuConsultarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarEventoActionPerformed
        new BusquedaFrame("Título:","titulo","evento","Consultar",idUsuario).setVisible(true);
    }//GEN-LAST:event_menuConsultarEventoActionPerformed

    private void menuEliminarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarEventoActionPerformed
        new BusquedaFrame("Título:","titulo","evento","Borrar",idUsuario).setVisible(true);
    }//GEN-LAST:event_menuEliminarEventoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        actualizaTablaHorario();
        actualizaListaEventos();
    }//GEN-LAST:event_formWindowGainedFocus

    public int getIdUsuario(){
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
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
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame(2).setVisible(true);
            }
        });
    }
    
    private void actualizaTablaHorario(){
        Connection con;
        ResultSet rs;
        DefaultTableModel model = (DefaultTableModel) tablaHorario.getModel();
        String qry = "SELECT h.hora," +
                     "(SELECT clave FROM materia m JOIN clase c ON m.idmateria=c.idmateria WHERE dia = 'Lunes'     AND horainicio <= h.hora AND horafin > hora AND idusuario = "+idUsuario+") AS lunes," +
                     "(SELECT clave FROM materia m JOIN clase c ON m.idmateria=c.idmateria WHERE dia = 'Martes'    AND horainicio <= h.hora AND horafin > hora AND idusuario = "+idUsuario+") AS martes," +
                     "(SELECT clave FROM materia m JOIN clase c ON m.idmateria=c.idmateria WHERE dia = 'Miercoles' AND horainicio <= h.hora AND horafin > hora AND idusuario = "+idUsuario+") AS miercoles," +
	             "(SELECT clave FROM materia m JOIN clase c ON m.idmateria=c.idmateria WHERE dia = 'Jueves'    AND horainicio <= h.hora AND horafin > hora AND idusuario = "+idUsuario+") AS jueves," +
	             "(SELECT clave FROM materia m JOIN clase c ON m.idmateria=c.idmateria WHERE dia = 'Viernes'   AND horainicio <= h.hora AND horafin > hora AND idusuario = "+idUsuario+") AS viernes," +
                     "(SELECT clave FROM materia m JOIN clase c ON m.idmateria=c.idmateria WHERE dia = 'Sabado'    AND horainicio <= h.hora AND horafin > hora AND idusuario = "+idUsuario+") AS sabado" +
                     " FROM horas h";
        
        con = ConexionPostgreSQL.getConexion();
        
        //Limpiar el horario para actualizarlo
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        
        if(con != null){
            try{
                Statement st = con.createStatement();
                rs = st.executeQuery(qry);
                
                while(rs.next()){
                    model.addRow(new Object[]{rs.getString("hora"),rs.getString("lunes"),rs.getString("martes"),rs.getString("miercoles"),rs.getString("jueves"),rs.getString("viernes"),rs.getString("sabado")});
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    private void actualizaListaEventos(){
        Connection con;
        ResultSet rs;
        DefaultListModel lm = new DefaultListModel();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        String qry = "SELECT * FROM evento ORDER BY fecha, hora";
        
        con = ConexionPostgreSQL.getConexion();
        
        //Limpiar la lista para actualizarla
        listaEventos.removeAll();        
        
        if(con != null){
            try{
                Statement st = con.createStatement();
                rs = st.executeQuery(qry);
                
                while(rs.next()){
                    lm.addElement(rs.getString("titulo") + " - " + df.format(rs.getDate("fecha")) + " " + rs.getString("hora") + ":00");
                }
                
                listaEventos.setModel(lm);
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEventos;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JList listaEventos;
    private javax.swing.JMenuItem menuAgregarEvento;
    private javax.swing.JMenuItem menuAgregarMateria;
    private javax.swing.JMenuItem menuCerrar;
    private javax.swing.JMenuItem menuConsultarEvento;
    private javax.swing.JMenuItem menuConsultarMateria;
    private javax.swing.JMenuItem menuEditarEvento;
    private javax.swing.JMenuItem menuEditarMateria;
    private javax.swing.JMenuItem menuEliminarEvento;
    private javax.swing.JMenuItem menuEliminarMateria;
    private javax.swing.JMenu menuEventos;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuMaterias;
    private javax.swing.JMenuItem menuModificarUsuario;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JTable tablaHorario;
    // End of variables declaration//GEN-END:variables
}
