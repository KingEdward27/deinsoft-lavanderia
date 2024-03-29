/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FormInternos;

import accesodatos.ClientesADN;
import entidades.Clientes;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDWARD
 */
public class JDAgregarClientes extends javax.swing.JDialog {

    /**
     * Creates new form JDBuscarClientes
     */
    public JDAgregarClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtfdNombres = new org.swing.componet.JTextBoxHintDS();
        jLabel3 = new javax.swing.JLabel();
        jtfdTelefono = new org.swing.componet.JTextBoxHintDS();
        jLabel6 = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        jtfdDni = new org.swing.componet.JTextBoxHintDS();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbxTipo = new javax.swing.JComboBox<>();
        jtfdDireccion = new org.swing.componet.JTextBoxHintDS();
        jLabel5 = new javax.swing.JLabel();
        jtfdCorreo = new org.swing.componet.JTextBoxHintDS();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(">>>:::::: Buscar Clientes ::::::<<<");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtfdNombres.setHint("Ingrese sus Apellidos y Nombres");
        jtfdNombres.setPrimeraMayus(java.lang.Boolean.TRUE);
        jtfdNombres.setTipoTextBox(org.Interfaces.Enum.TipoTextBox.SoloTexto);
        jtfdNombres.setTiponumero(null);

        jLabel3.setText("Nombres:");

        jtfdTelefono.setHint("Ingrese su Telefono");
        jtfdTelefono.setLength(10);
        jtfdTelefono.setTiponumero(org.Interfaces.Enum.TiposNumeros.Telefono);

        jLabel6.setText("Telefono:");

        jbtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/save.png"))); // NOI18N
        jbtnGuardar.setText("Guardar");
        jbtnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jtfdDni.setHint("Ingrese su DNI");
        jtfdDni.setLength(11);

        jLabel4.setText("DNI/RUC:");

        jLabel8.setText("Tipo:");

        jcbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-DNI", "4-CARNET EXTRANJERIA", "6-RUC", "7-PASAPORTE" }));

        jtfdDireccion.setHint("Ingrese su Dirección");
        jtfdDireccion.setPrimeraMayus(java.lang.Boolean.TRUE);
        jtfdDireccion.setTipoTextBox(null);
        jtfdDireccion.setTiponumero(null);

        jLabel5.setText("Dirección:");

        jtfdCorreo.setHint("Ingrese su Correo");
        jtfdCorreo.setPrimeraMayus(java.lang.Boolean.TRUE);
        jtfdCorreo.setTipoTextBox(null);
        jtfdCorreo.setTiponumero(null);
        jtfdCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfdCorreoActionPerformed(evt);
            }
        });

        jLabel7.setText("Correo electrónico:");

        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jtfdDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jtfdDni, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel7)
                                                .addComponent(jtfdCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfdNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9))))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfdNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfdDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnGuardar))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static int idcli = 0;
    public static String estado = "";
    public static boolean modif = false;
    DefaultTableModel dtm = null;

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        try {
            String nom = "", dn = "", tel = "", dir = "";
            nom = jtfdNombres.getText().trim().toUpperCase();
            dn = jtfdDni.getText().trim().toUpperCase();
            tel = jtfdTelefono.getText().trim().toUpperCase();
            dir = jtfdDireccion.getText().trim().toUpperCase();
            String mensaje = "";
            String correo = jtfdCorreo.getText().trim();
            String tipo = jcbxTipo.getSelectedItem().toString();
            if(dn.length()> 10 && tipo.contains("1-")){
                JOptionPane.showMessageDialog(rootPane, "Si es RUC, debe seleccionar correctamente el tipo de documento, caso contrario ingrese sólo 8 dígitos");
                return;
            }
            if (nom.length() == 0 ) {
                JOptionPane.showMessageDialog(rootPane, "Asegurese de ingresar el nombre");
            } else {
                boolean respuesta = true;
                Clientes cli = new Clientes(0, nom, dn, dir, tel, "1",correo,tipo);
                mensaje = "Datos guardados correctamente";
                
                if (ClientesADN.Evaluar(cli) == 1) {
                    JOptionPane.showMessageDialog(rootPane, "Ya existe un cliente con el mismo nombre");
                    respuesta = false;
                }
                if (respuesta) {
                    if (ClientesADN.Guardar(cli)) {
                        
                        JOptionPane.showMessageDialog(rootPane,mensaje);
                        JIVentas.nuevo_cliente= nom;
                        dispose();
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jtfdCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfdCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfdCorreoActionPerformed

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
            java.util.logging.Logger.getLogger(JDAgregarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDAgregarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDAgregarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDAgregarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDAgregarClientes dialog = new JDAgregarClientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JComboBox<String> jcbxTipo;
    private org.swing.componet.JTextBoxHintDS jtfdCorreo;
    private org.swing.componet.JTextBoxHintDS jtfdDireccion;
    private org.swing.componet.JTextBoxHintDS jtfdDni;
    private org.swing.componet.JTextBoxHintDS jtfdNombres;
    private org.swing.componet.JTextBoxHintDS jtfdTelefono;
    // End of variables declaration//GEN-END:variables


}
