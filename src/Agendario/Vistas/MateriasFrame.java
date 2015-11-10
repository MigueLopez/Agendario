/*
 * Ventana para el registro de Materias
 */
package Agendario.Vistas;

import Agendario.Datos.Materia;

/**
 *
 * @author Miguel Ángel López Cervantes
 */
public class MateriasFrame extends javax.swing.JFrame {

    private Materia materia;
    
    /**
     * Creates new form MateriasFrame
     */
    public MateriasFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        lblClave = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblDia = new javax.swing.JLabel();
        chkLunes = new javax.swing.JCheckBox();
        spnLunesInicio = new javax.swing.JSpinner();
        spnLunesFin = new javax.swing.JSpinner();
        chkMartes = new javax.swing.JCheckBox();
        spnMartesInicio = new javax.swing.JSpinner();
        spnMartesFin = new javax.swing.JSpinner();
        spnMiercolesInicio = new javax.swing.JSpinner();
        spnMiercolesFin = new javax.swing.JSpinner();
        chkMiercoles = new javax.swing.JCheckBox();
        spnJuevesInicio = new javax.swing.JSpinner();
        chkJueves = new javax.swing.JCheckBox();
        spnJuevesFin = new javax.swing.JSpinner();
        chkViernes = new javax.swing.JCheckBox();
        spnViernesFin = new javax.swing.JSpinner();
        spnViernesInicio = new javax.swing.JSpinner();
        lblHoraInicio = new javax.swing.JLabel();
        lblHoraFin = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Materias");

        lblClave.setText("Clave:");

        lblNombre.setText("Nombre:");

        lblDia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDia.setText("Día");

        chkLunes.setText("Lunes");

        spnLunesInicio.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        spnLunesFin.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        chkMartes.setText("Martes");

        spnMartesInicio.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        spnMartesFin.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        spnMiercolesInicio.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        spnMiercolesFin.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        chkMiercoles.setText("Miércoles");

        spnJuevesInicio.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        chkJueves.setText("Jueves");

        spnJuevesFin.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        chkViernes.setText("Viernes");

        spnViernesFin.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        spnViernesInicio.setModel(new javax.swing.SpinnerNumberModel(7, 7, 22, 1));

        lblHoraInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblHoraInicio.setText("Hora Inicio");

        lblHoraFin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblHoraFin.setText("HoraFin");

        lblHorario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblHorario.setText("Horario");

        btnGuardar.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblClave)
                                .addGap(34, 34, 34)
                                .addComponent(lblNombre))
                            .addComponent(lblHorario)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblDia))
                                    .addComponent(chkMiercoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkMartes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkLunes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkJueves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkViernes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblHoraInicio)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblHoraFin))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(spnViernesInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                            .addComponent(spnJuevesInicio, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(spnMiercolesInicio, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(spnMartesInicio, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(spnLunesInicio, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(spnLunesFin, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                            .addComponent(spnMartesFin)
                                            .addComponent(spnMiercolesFin)
                                            .addComponent(spnJuevesFin)
                                            .addComponent(spnViernesFin))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lblHorario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDia)
                    .addComponent(lblHoraInicio)
                    .addComponent(lblHoraFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkLunes)
                            .addComponent(spnLunesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkMartes)
                            .addComponent(spnMartesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spnLunesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnMartesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkMiercoles)
                    .addComponent(spnMiercolesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMiercolesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkJueves)
                    .addComponent(spnJuevesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnJuevesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkViernes)
                    .addComponent(spnViernesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnViernesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MateriasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MateriasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MateriasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MateriasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MateriasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkJueves;
    private javax.swing.JCheckBox chkLunes;
    private javax.swing.JCheckBox chkMartes;
    private javax.swing.JCheckBox chkMiercoles;
    private javax.swing.JCheckBox chkViernes;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHoraFin;
    private javax.swing.JLabel lblHoraInicio;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JSpinner spnJuevesFin;
    private javax.swing.JSpinner spnJuevesInicio;
    private javax.swing.JSpinner spnLunesFin;
    private javax.swing.JSpinner spnLunesInicio;
    private javax.swing.JSpinner spnMartesFin;
    private javax.swing.JSpinner spnMartesInicio;
    private javax.swing.JSpinner spnMiercolesFin;
    private javax.swing.JSpinner spnMiercolesInicio;
    private javax.swing.JSpinner spnViernesFin;
    private javax.swing.JSpinner spnViernesInicio;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}