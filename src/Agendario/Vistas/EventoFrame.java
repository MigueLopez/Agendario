/*
 * Ventana para el registro de eventos
 */
package Agendario.Vistas;

import Agendario.Conexion.*;
import Agendario.Datos.Evento;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Ángel López Cervantes
 */
public class EventoFrame extends javax.swing.JFrame {

    private Evento evento;
    private int idUsuario;
    private String accion;
    
    /**
     * Creates new form EventoFrame
     */
    public EventoFrame(String accion, int idUsuario) {
        initComponents();
        this.accion = accion;
        this.idUsuario = idUsuario; //Se guarda el idUsuario que este logeado al momento
        traerMaterias();
        traerTiposEvento();
    }
    
    public void inhabilitaCampos(){
        txtTitulo.setEditable(false);
        areaNotas.setEditable(false);
        txtFecha.setEditable(false);
        spnHora.setEnabled(false);
        cmbTipo.setEnabled(false);
        cmbMateria.setEnabled(false);
    }
    
     public void llenarCamposFrame(ResultSet rs){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //Tomar los datos del ResultSet y ponerlos en el Frame y en usuario
        evento = new Evento();
        try {   
            txtTitulo.setText(rs.getString("titulo"));
            areaNotas.setText(rs.getString("notas"));
            txtFecha.setText(df.format(rs.getDate("fecha")));
            spnHora.setValue(rs.getInt("hora"));
            traerMaterias();
            traerTiposEvento();
            
            evento.setIdEvento(rs.getInt("idevento"));
            evento.setNotas(rs.getString("notas"));
            evento.setFecha(rs.getString("fecha"));
            evento.setHora(rs.getInt("hora"));
            evento.setIdTipoEvento(rs.getInt("idtipoevento")); 
            evento.setIdMateria(rs.getInt("idmateria")); 
            evento.setIdUsuario(rs.getInt("idusuario"));    
            
            
            seleccionarTipoEvento(evento.getIdTipoEvento());
            seleccionarMateria(evento.getIdMateria());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
        }
    }
     
    private void traerTiposEvento(){
        ResultSet rs;
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        rs = ConexionPostgreSQL.obtenerRegistro("tipoevento", "0=0");  //Traer todo los tipos de evento
        cmbTipo.removeAllItems();
        try {
            while(rs.next()){
                cbm.addElement(rs.getString("tipoevento"));
            }
            cmbTipo.setModel(cbm);
        } catch (SQLException ex) {
            System.out.println("Error al traer tipos de evento: " + ex.getMessage());
        }
    }
    
    private void traerMaterias(){
        ResultSet rs;
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        rs = ConexionPostgreSQL.obtenerRegistro("materia", "idusuario = " + idUsuario);  //Traer todo las materias del usuario actual
        cmbMateria.removeAllItems();
        try {
            cbm.addElement("- Ninguna -");
            while(rs.next()){
                cbm.addElement(rs.getString("materia"));
            }
            cmbMateria.setModel(cbm);
        } catch (SQLException ex) {
            System.out.println("Error al traer materias: " + ex.getMessage());
        }
    }
    
    private void seleccionarTipoEvento(int idTipoEvento){
        ResultSet rs;
        rs = ConexionPostgreSQL.obtenerRegistro("tipoevento", "idtipoevento = " + idTipoEvento);
        boolean encontrado = false;
        int i = 0;
        int len = cmbTipo.getItemCount();
        String aux;
        
        try {
            if(rs.next()){
                while(!encontrado && i<len){
                    aux = (String)cmbTipo.getItemAt(i);
                    if(aux.equals(rs.getString("tipoevento"))){
                        cmbTipo.setSelectedIndex(i);
                        encontrado = true;
                    }
                    i++;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al asignar el tipo de evento al ComboBox: " + ex.getMessage());
        }
    }
    
    private void seleccionarMateria(int idMateria){
        ResultSet rs;
        rs = ConexionPostgreSQL.obtenerRegistro("materia", "idmateria = " + idMateria);
        boolean encontrado = false;
        int i = 0;
        int len = cmbMateria.getItemCount();
        String aux;
        
        try {
            if(rs.next()){
                while(!encontrado && i<len){
                    aux = (String)cmbMateria.getItemAt(i);
                    if(aux.equals(rs.getString("materia"))){
                        cmbMateria.setSelectedIndex(i);
                        encontrado = true;
                    }
                    i++;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al asignar la materia al ComboBox: " + ex.getMessage());
        }
    }
    
    private int getIdTipoEventoSeleccionado(){
        int index = cmbTipo.getSelectedIndex();
        String aux = (String)cmbTipo.getItemAt(index);
        int resultado = 0;
        ResultSet rs;
        rs = ConexionPostgreSQL.obtenerRegistro("tipoevento", "tipoevento = '" + aux + "'");
        
        try {
            rs.next();
            resultado = rs.getInt("idtipoevento");
        } catch (SQLException ex) {
            System.out.println("Error al obtener el ID del tipo de evento seleccionado: " + ex.getMessage());
        }
        
        return resultado;
    }
    
    private int getIdMateriaSeleccionada(){
        int index = cmbMateria.getSelectedIndex();
        String aux = (String)cmbMateria.getItemAt(index);
        int resultado = 0;
        ResultSet rs;
        rs = ConexionPostgreSQL.obtenerRegistro("materia", "materia = '" + aux + "'");
        
        try {
            rs.next();
            resultado = rs.getInt("idmateria");
        } catch (SQLException ex) {
            System.out.println("Error al obtener el ID de la materia seleccionada: " + ex.getMessage());
        }
        
        return resultado;
    }
    
    private void actualizaEvento(){   
        evento.setTitulo(txtTitulo.getText()); 
        evento.setNotas(areaNotas.getText());
        evento.setFecha(txtFecha.getText());
        evento.setHora((int)spnHora.getValue());
        evento.setIdMateria(getIdMateriaSeleccionada());
        evento.setIdTipoEvento(getIdTipoEventoSeleccionado());
        evento.setIdUsuario(idUsuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblNotas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaNotas = new javax.swing.JTextArea();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        lblHora = new javax.swing.JLabel();
        spnHora = new javax.swing.JSpinner();
        lblTipo = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        lblMateria = new javax.swing.JLabel();
        cmbMateria = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eventos");
        setResizable(false);

        lblTitulo.setText("Título:");

        lblNotas.setText("Notas:");

        areaNotas.setColumns(20);
        areaNotas.setRows(5);
        jScrollPane1.setViewportView(areaNotas);

        lblFecha.setText("Fecha:");

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        lblHora.setText("Hora:");

        spnHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        lblTipo.setText("Tipo de Evento:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblMateria.setText("Materia:");

        cmbMateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
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
                        .addComponent(lblMateria)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNotas, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                            .addComponent(lblTipo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblFecha)
                                .addGap(74, 74, 74)
                                .addComponent(lblHora))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNotas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(lblHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMateria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //validar que no se repita el titulo
            switch(accion.charAt(0)){
                case 'A': //Agregar
                    if(Evento.validaTitulo(txtTitulo.getText())){
                        evento = new Evento(txtTitulo.getText(),areaNotas.getText(),txtFecha.getText(),(int)spnHora.getValue(),idUsuario,getIdTipoEventoSeleccionado(),getIdMateriaSeleccionada());
                        evento.inserta();
                        dispose(); 
                    }
                    break;

                case 'E':
                    actualizaEvento();
                    evento.actualiza();
                    dispose();                
                    break;

                case 'C':  //En la consulta simplemente se cierra la ventana
                    dispose();
                    break;
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(EventoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new EventoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaNotas;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbMateria;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMateria;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSpinner spnHora;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
