/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JRibbonForm;

import accesodatos.UsuariosADN;
import entidades.Usuarios;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.GeminiSkin;
/**
 *
 * @author Crixuz
 */
public class JFLogin extends javax.swing.JFrame{

    /**
     * Creates new form JFLogin
     */
    public JFLogin() {
        initComponents();
        this.setContentPane(jStandardCurvedPanelAC1);
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jStandardCurvedPanelAC1 = new com.crz.swing.custom.component.panel.JStandardCurvedPanelAC();
        jbtnCancelar = new com.crz.swing.custom.component.button.JGlossyButtonAC();
        jbtnAceptar = new com.crz.swing.custom.component.button.JGlossyButtonAC();
        jGlossyButtonAC3 = new com.crz.swing.custom.component.button.JGlossyButtonAC();
        jLabel1 = new javax.swing.JLabel();
        jlblIntentos = new javax.swing.JLabel();
        jtfdUsuario = new org.swing.componet.JTextBoxHintDS();
        jpfdPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/cancelar1.png"))); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setButtonTheme(19);
        jbtnCancelar.setSelectedTheme(19);
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Aceptar.png"))); // NOI18N
        jbtnAceptar.setText("Aceptar");
        jbtnAceptar.setButtonTheme(19);
        jbtnAceptar.setSelectedTheme(19);
        jbtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAceptarActionPerformed(evt);
            }
        });

        jGlossyButtonAC3.setText(">>>::::: INIICIAR SESIÓN :::::<<<");
        jGlossyButtonAC3.setButtonTheme(19);
        jGlossyButtonAC3.setFont(new java.awt.Font("Thoma", 1, 14)); // NOI18N
        jGlossyButtonAC3.setRollOverTheme(19);
        jGlossyButtonAC3.setSelectedTheme(19);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");

        jlblIntentos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblIntentos.setForeground(new java.awt.Color(255, 255, 255));
        jlblIntentos.setText("Intentos: 1");

        jtfdUsuario.setTipoTextBox(null);
        jtfdUsuario.setTiponumero(null);

        jpfdPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfdPassActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        javax.swing.GroupLayout jStandardCurvedPanelAC1Layout = new javax.swing.GroupLayout(jStandardCurvedPanelAC1);
        jStandardCurvedPanelAC1.setLayout(jStandardCurvedPanelAC1Layout);
        jStandardCurvedPanelAC1Layout.setHorizontalGroup(
            jStandardCurvedPanelAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jGlossyButtonAC3, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addGroup(jStandardCurvedPanelAC1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jStandardCurvedPanelAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jStandardCurvedPanelAC1Layout.createSequentialGroup()
                        .addComponent(jbtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jStandardCurvedPanelAC1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlblIntentos))
                    .addGroup(jStandardCurvedPanelAC1Layout.createSequentialGroup()
                        .addGroup(jStandardCurvedPanelAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jStandardCurvedPanelAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpfdPass)
                            .addComponent(jtfdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jStandardCurvedPanelAC1Layout.setVerticalGroup(
            jStandardCurvedPanelAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jStandardCurvedPanelAC1Layout.createSequentialGroup()
                .addComponent(jGlossyButtonAC3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblIntentos)
                .addGap(15, 15, 15)
                .addGroup(jStandardCurvedPanelAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jStandardCurvedPanelAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpfdPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jStandardCurvedPanelAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jStandardCurvedPanelAC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jStandardCurvedPanelAC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int n = 1;
    public static String nom_usuario = "";
    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarActionPerformed
        try {
            Usuarios usu = new Usuarios();
            usu.setNombre(jtfdUsuario.getText().trim());
            usu.setClave(jpfdPass.getText().trim());
            if (UsuariosADN.ValidarSesion(usu) & UsuariosADN.ObtenerTipo(usu).equals("ADMINISTRADOR")) {
                JRibbonForm.admin = true;
                JOptionPane.showMessageDialog(rootPane, "Bienvenido Al Sistema");
                JRibbonForm.esta = true;
                nom_usuario = jtfdUsuario.getText().trim();
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JRibbonForm frame = new JRibbonForm();
                        SubstanceLookAndFeel.setSkin(new GeminiSkin());
                        SwingUtilities.updateComponentTreeUI(frame);
                    }
                });
            } else if (UsuariosADN.ValidarSesion(usu) && UsuariosADN.ObtenerTipo(usu).equals("USUARIO")) {
                JRibbonForm.admin = false;
                JOptionPane.showMessageDialog(rootPane, "Bienvenido Al Sistema");
                JRibbonForm.esta = true;
                nom_usuario = jtfdUsuario.getText().trim();
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JRibbonForm frame = new JRibbonForm();
                        SubstanceLookAndFeel.setSkin(new GeminiSkin());
                        SwingUtilities.updateComponentTreeUI(frame);
                    }
                });
            } else {
                n++;
                if (n <= 4) {
                    JOptionPane.showMessageDialog(rootPane, "Contresaña Invalida");
                    jlblIntentos.setText("Intentos: " + n);
                    if (n == 4) {
                        JOptionPane.showMessageDialog(rootPane, "Sin Intentos");
                        System.exit(0);
                    }
                }
            }
        } catch (Exception ex) {
            
            n++;
            if (n <= 4) {
                JOptionPane.showMessageDialog(rootPane, "Usuario y/o contraseña incorrecto/s");
                jlblIntentos.setText("Intentos: " + n);
                if (n == 4) {
                    JOptionPane.showMessageDialog(rootPane, "Sin Intentos");
                    System.exit(0);
                }
            }
            
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtnAceptarActionPerformed

    private void jpfdPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfdPassActionPerformed
        if (jpfdPass.getText().length() > 0) {
            jbtnAceptarActionPerformed(evt);
        }
    }//GEN-LAST:event_jpfdPassActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtfdUsuario.requestFocus();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.crz.swing.custom.component.button.JGlossyButtonAC jGlossyButtonAC3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private com.crz.swing.custom.component.panel.JStandardCurvedPanelAC jStandardCurvedPanelAC1;
    private com.crz.swing.custom.component.button.JGlossyButtonAC jbtnAceptar;
    private com.crz.swing.custom.component.button.JGlossyButtonAC jbtnCancelar;
    private javax.swing.JLabel jlblIntentos;
    private javax.swing.JPasswordField jpfdPass;
    private org.swing.componet.JTextBoxHintDS jtfdUsuario;
    // End of variables declaration//GEN-END:variables

}