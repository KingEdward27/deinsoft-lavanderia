
package FormInternos;

import accesodatos.ColoresADN;
import entidades.Colores;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.validacion.Controles.PanelDS;
import org.validacion.Controles.TextFieldDS;

/**
 *
 * @author Crixuz
 */
public class JIColores extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIClientes
     */
    public JIColores() {
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
        jtfdMarcaB = new org.swing.componet.JTextBoxHintDS();
        jLabel2 = new javax.swing.JLabel();
        jrbnActivos = new javax.swing.JRadioButton();
        jrbnInactivos = new javax.swing.JRadioButton();
        jtpeTablepanel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jteLista = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jtfdMarca = new org.swing.componet.JTextBoxHintDS();
        jLabel5 = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        jbtnNuevo = new javax.swing.JButton();
        jbtnActivar = new javax.swing.JButton();

        setClosable(true);
        setTitle(">>>>:::::: Lista de Colores ::::::<<<<");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Color"));

        jtfdMarcaB.setHint("Ingrese el Color");
        jtfdMarcaB.setTipoTextBox(null);
        jtfdMarcaB.setTiponumero(null);
        jtfdMarcaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfdMarcaBActionPerformed(evt);
            }
        });

        jLabel2.setText("Color:");

        buttonGroup1.add(jrbnActivos);
        jrbnActivos.setSelected(true);
        jrbnActivos.setText("Activos");
        jrbnActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbnActivosActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbnInactivos);
        jrbnInactivos.setText("Inactivos");
        jrbnInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbnInactivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtfdMarcaB, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbnInactivos)
                    .addComponent(jrbnActivos))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbnActivos)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbnInactivos)
                    .addComponent(jtfdMarcaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jtpeTablepanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jteLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdMarca", "Descripcion", "Estado"
            }
        ));
        jteLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jteListaMouseClicked(evt);
            }
        });
        jteLista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jteListaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jteLista);
        jteLista.getColumnModel().getColumn(0).setMinWidth(0);
        jteLista.getColumnModel().getColumn(0).setPreferredWidth(0);
        jteLista.getColumnModel().getColumn(0).setMaxWidth(0);
        jteLista.getColumnModel().getColumn(2).setMinWidth(0);
        jteLista.getColumnModel().getColumn(2).setPreferredWidth(0);
        jteLista.getColumnModel().getColumn(2).setMaxWidth(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );

        jtpeTablepanel.addTab("Lista", jPanel2);

        jtfdMarca.setHint("Ingrese el Color");
        jtfdMarca.setTipoTextBox(null);
        jtfdMarca.setTiponumero(null);

        jLabel5.setText("Color:");

        jbtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/save.png"))); // NOI18N
        jbtnGuardar.setText("Guardar");
        jbtnGuardar.setEnabled(false);
        jbtnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtfdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jbtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpeTablepanel.addTab("Datos", jPanel3);

        jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar2.png"))); // NOI18N
        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jbtnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/elimi.png"))); // NOI18N
        jbtnActivar.setText("Inactivar");
        jbtnActivar.setEnabled(false);
        jbtnActivar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnActivar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtpeTablepanel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpeTablepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnNuevo)
                    .addComponent(jbtnActivar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static int idcat = 0;
    public static String estado = "",est="";
    public static boolean modif = false;
    DefaultTableModel dtm = null;
    
    private void jrbnInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbnInactivosActionPerformed
        jbtnActivar.setText("Activar");
        jbtnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Aceptar.png")));
        estado = "0";
        VerDatos();
    }//GEN-LAST:event_jrbnInactivosActionPerformed

    private void jrbnActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbnActivosActionPerformed
        jbtnActivar.setText("Inactivar");
        jbtnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/elimi.png")));
        estado = "1";
        VerDatos();
    }//GEN-LAST:event_jrbnActivosActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        if (jbtnNuevo.getText().equals("Nuevo") ){
            jbtnNuevo.setText("Cancelar");
            jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/cancelar1.png")));
            jtpeTablepanel.setSelectedIndex(1);
            jbtnGuardar.setEnabled(true);
//            PanelDS.LimpiarCampos(jPanel3);
            PanelDS.HabilitarCajaE(jPanel3);
//            jPanel3.setEnabled(true);
        }else{
            jbtnNuevo.setText("Nuevo");
            jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar2.png")));
            jtpeTablepanel.setSelectedIndex(0);
            jbtnGuardar.setEnabled(false);
            PanelDS.LimpiarCampos(jPanel3);
            PanelDS.DesabilitarCajaE(jPanel3);
        }
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActivarActionPerformed
         try {
            int IdMarca = 0;
            if (jbtnActivar.getText().equals("Inactivar")) {
                int filas = jteLista.getRowCount();
                if (filas > 0) {
                    int fila = jteLista.getSelectedRow();
                    if (fila >= 0) {
                        IdMarca = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
                        Colores m = new Colores(IdMarca, null,  "0");
                        if (IdMarca > 0) {
                            if (ColoresADN.CambiarEstado(m)) {
                                JOptionPane.showMessageDialog(rootPane, "Se cambio el estado de la marca correctamente");
                                VerDatos();
                                jbtnActivar.setEnabled(false);
                            }
                        }
                    }
                    
                }
            } else {
                int filas = jteLista.getRowCount();
                if (filas > 0) {
                    int fila = jteLista.getSelectedRow();
                    if (fila >= 0) {
                       IdMarca = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
                        Colores m = new Colores(IdMarca, null,  "1");
                        if (IdMarca > 0) {
                            if (ColoresADN.CambiarEstado(m)) {
                                JOptionPane.showMessageDialog(rootPane, "Se dio de baja a la marca correctamente");
                                VerDatos();
                                jbtnActivar.setEnabled(false);
                            }
                        }
                    }
                    
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.toString());
        }
    }//GEN-LAST:event_jbtnActivarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        try {
            dtm = (DefaultTableModel) jteLista.getModel();
            estado = "1";
            VerDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
       try {
            String nom = "";
            nom = jtfdMarca.getText().trim().toUpperCase();
            Colores cli = null;
            String mensaje = "";
            if (nom.length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Asegurese de llenar los datos correctamente");
            } else {
                Colores c = new Colores();
                c.setNombre(nom);
                c.setIdColors(idcat);
                if (modif == false) {
                    cli = new Colores(0, nom, "1");
                    mensaje = "Datos guardados correctamente";
                } else {
                    cli = new Colores(idcat, nom, est);
                    mensaje = "Datos actualizados correctamente";
                }if (ColoresADN.Evaluar(c)) {
                    JOptionPane.showMessageDialog(rootPane, "Ya existe un color con el mismo nombre, No se puede registrar la categoria");
                    
                }else{
                    boolean gua = ColoresADN.Guardar(cli);
                    if (gua) {
                        JOptionPane.showMessageDialog(rootPane,mensaje);
                        VerDatos();
                        jbtnNuevoActionPerformed(evt);
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jtfdMarcaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfdMarcaBActionPerformed
        try {
            VerDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_jtfdMarcaBActionPerformed

    private void jteListaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jteListaKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = jteLista.getSelectedRow();
            modif = true;
            if (fila >= 0) {
                idcat = Integer.parseInt(jteLista.getValueAt(fila, 0).toString());
                //CargarCombo();
                //String nom=jtblista.getValueAt(fila, 1).toString();                               
                jtfdMarca.setText(jteLista.getValueAt(fila, 1).toString());
                est=jteLista.getValueAt(fila, 2).toString();
                jbtnNuevoActionPerformed(null);
                PanelDS.pintartext(jPanel3);
            }
        }
    }//GEN-LAST:event_jteListaKeyPressed

    private void jteListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jteListaMouseClicked
         int fila = jteLista.getSelectedRow();
        idcat = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
        jbtnActivar.setEnabled(true);
    }//GEN-LAST:event_jteListaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnActivar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JRadioButton jrbnActivos;
    private javax.swing.JRadioButton jrbnInactivos;
    private javax.swing.JTable jteLista;
    private org.swing.componet.JTextBoxHintDS jtfdMarca;
    private org.swing.componet.JTextBoxHintDS jtfdMarcaB;
    private javax.swing.JTabbedPane jtpeTablepanel;
    // End of variables declaration//GEN-END:variables

     private void VerDatos(){
        try {
            int filas = jteLista.getRowCount();
            for (int i = 0; i < filas; i++) {
                dtm.removeRow(0);
            }
            Colores c = new Colores();
            c.setNombre(jtfdMarcaB.getText().trim());
            c.setEstado(String.valueOf(estado));
            for (Colores la : ColoresADN.Lista(c)) {
                dtm.addRow(la.ArregloDatos());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }

    }
}
