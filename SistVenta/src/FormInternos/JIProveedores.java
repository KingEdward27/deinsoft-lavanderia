/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FormInternos;

import accesodatos.ProveedoresADN;
import entidades.Proveedores;
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
public class JIProveedores extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIProveedores
     */
    public JIProveedores() {
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
        jbtnNuevo = new javax.swing.JButton();
        jbtnActivar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfdRucB = new org.swing.componet.JTextBoxHintDS();
        jtfdRazonSocialB = new org.swing.componet.JTextBoxHintDS();
        jLabel2 = new javax.swing.JLabel();
        jrbnActivos = new javax.swing.JRadioButton();
        jrbnInactivos = new javax.swing.JRadioButton();
        jtpeTablepanel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jteLista = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfdRazonSocial = new org.swing.componet.JTextBoxHintDS();
        jtfdRuc = new org.swing.componet.JTextBoxHintDS();
        jLabel4 = new javax.swing.JLabel();
        jtfdDireccion = new org.swing.componet.JTextBoxHintDS();
        jLabel5 = new javax.swing.JLabel();
        jtfdTelefono = new org.swing.componet.JTextBoxHintDS();
        jLabel6 = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();

        setClosable(true);
        setTitle(">>>>:::::: Lista de Proveedores ::::::<<<<");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
        });

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Proveedor"));

        jLabel1.setText("RUC:");

        jtfdRucB.setHint("Ingrese su RUC");
        jtfdRucB.setLength(11);
        jtfdRucB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfdRucBActionPerformed(evt);
            }
        });

        jtfdRazonSocialB.setHint("Ingrese su Razon Social");
        jtfdRazonSocialB.setTipoTextBox(null);
        jtfdRazonSocialB.setTiponumero(null);
        jtfdRazonSocialB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfdRucBActionPerformed(evt);
            }
        });

        jLabel2.setText("Razon Social:");

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
                    .addComponent(jtfdRucB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtfdRazonSocialB, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbnInactivos)
                    .addComponent(jrbnActivos))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfdRucB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfdRazonSocialB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jrbnActivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbnInactivos)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtpeTablepanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jteLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdProveedor", "Razon Social", "RUC", "Dirección", "Telefono", "Estado"
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
        jteLista.getColumnModel().getColumn(5).setMinWidth(0);
        jteLista.getColumnModel().getColumn(5).setPreferredWidth(0);
        jteLista.getColumnModel().getColumn(5).setMaxWidth(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        jtpeTablepanel.addTab("Lista", jPanel2);

        jLabel3.setText("Razon Social:");

        jtfdRazonSocial.setEditable(false);
        jtfdRazonSocial.setHint("Ingrese su Razon Social");
        jtfdRazonSocial.setTipoTextBox(null);
        jtfdRazonSocial.setTiponumero(null);

        jtfdRuc.setEditable(false);
        jtfdRuc.setHint("Ingrese su RUC");
        jtfdRuc.setLength(11);

        jLabel4.setText("RUC:");

        jtfdDireccion.setEditable(false);
        jtfdDireccion.setHint("Ingrese su Dirección");
        jtfdDireccion.setTipoTextBox(null);
        jtfdDireccion.setTiponumero(null);

        jLabel5.setText("Dirección:");

        jtfdTelefono.setEditable(false);
        jtfdTelefono.setHint("Ingrese su Telefono");
        jtfdTelefono.setLength(10);
        jtfdTelefono.setTiponumero(org.Interfaces.Enum.TiposNumeros.Telefono);

        jLabel6.setText("Telefono:");

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
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfdDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfdRazonSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfdTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jtfdRuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfdRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfdRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfdDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpeTablepanel.addTab("Datos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtpeTablepanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnActivar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpeTablepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnActivar)
                    .addComponent(jbtnNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static int idpro = 0;
    public static String estado = "",est="";
    public static boolean modif = false;
    DefaultTableModel dtm = null;
    
    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        if (jbtnNuevo.getText().equals("Nuevo") ){
            jbtnNuevo.setText("Cancelar");
            jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/cancelar1.png")));
            jtpeTablepanel.setSelectedIndex(1);
            jbtnGuardar.setEnabled(true);
//            PanelDS.LimpiarCampos(jPanel3);
            PanelDS.HabilitarCajaE(jPanel3);
        }else{
            jbtnNuevo.setText("Nuevo");
            jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar2.png")));
            jtpeTablepanel.setSelectedIndex(0);
            jbtnGuardar.setEnabled(false);
            PanelDS.LimpiarCampos(jPanel3);
            PanelDS.DesabilitarCajaE(jPanel3);
        }
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jrbnActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbnActivosActionPerformed
        jbtnActivar.setText("Inactivar");
        jbtnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/elimi.png")));
        estado = "1";
        VerDatos();
    }//GEN-LAST:event_jrbnActivosActionPerformed

    private void jrbnInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbnInactivosActionPerformed
        jbtnActivar.setText("Activar");
        jbtnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Aceptar.png")));
        estado = "0";
        VerDatos();
    }//GEN-LAST:event_jrbnInactivosActionPerformed

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
            String nom = "", ruc = "", tel = "", dir = "";
            nom = jtfdRazonSocial.getText().trim().toUpperCase();
            ruc = jtfdRuc.getText().trim().toUpperCase();
            tel = jtfdTelefono.getText().trim().toUpperCase();
            dir = jtfdDireccion.getText().trim().toUpperCase();
            Proveedores cli = null;
            String mensaje = "";
            if (nom.length() == 0 || ruc.length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Asegurese de llenar los datos correctamente");
            } else {
                Proveedores c = new Proveedores();
                c.setRaz(nom);
                c.setRuc(ruc);
                c.setIdProveedor(idpro);
                boolean respuesta = true;
                if (modif == false) {
                    cli = new Proveedores(idpro, nom, ruc, dir, tel, "1");
                    mensaje = "Datos guardados correctamente";
                } else {
                    cli = new Proveedores(idpro, nom, ruc, dir, tel, est);
                    mensaje = "Datos actualizados correctamente";
                }
                if (ProveedoresADN.Evaluar(c) == 1) {
                    int r = JOptionPane.showConfirmDialog(rootPane, "Ya existe un proveedor con la misma razon social, ¿Desea registrarlo de todas maneras?");
                    if (r == 0) {
                        respuesta = true;
                    } else {
                        respuesta = false;
                    }
                }
                if (ProveedoresADN.Evaluar(c) == 2) {
                    int r = JOptionPane.showConfirmDialog(rootPane, "Ya existe un proveedor con el msmo RUC, ¿Desea registrarlo de todas maneras?");
                    if (r == 0) {
                        respuesta = true;
                    } else {
                        respuesta = false;
                    }
                }
                if (ProveedoresADN.Evaluar(c) == 3) {
                    JOptionPane.showMessageDialog(rootPane, "Ya existe un proveedor con la misma razon social y RUC, No se puede registrar al proveedor");
                    respuesta = false;
                }
                if (respuesta) {
                    boolean gua = ProveedoresADN.Guardar(cli);
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

    private void jtfdRucBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfdRucBActionPerformed
        try {
            VerDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_jtfdRucBActionPerformed

    private void jteListaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jteListaKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = jteLista.getSelectedRow();
            modif = true;
            if (fila >= 0) {
                idpro = Integer.parseInt(jteLista.getValueAt(fila, 0).toString());
                //CargarCombo();
                //String nom=jtblista.getValueAt(fila, 1).toString();                               
                jtfdRazonSocial.setText(jteLista.getValueAt(fila, 1).toString());
                jtfdRuc.setText(jteLista.getValueAt(fila, 2).toString());
                jtfdDireccion.setText(jteLista.getValueAt(fila, 3).toString());
                jtfdTelefono.setText(jteLista.getValueAt(fila, 4).toString());
                est=jteLista.getValueAt(fila, 5).toString();   
                jbtnNuevoActionPerformed(null);
                PanelDS.pintartext(jPanel3);
            }
        }
    }//GEN-LAST:event_jteListaKeyPressed

    private void jbtnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActivarActionPerformed
        try {
            int IdProveedor = 0;
            if (jbtnActivar.getText().equals("Inactivar")) {
                int filas = jteLista.getRowCount();
                if (filas > 0) {
                    int fila = jteLista.getSelectedRow();
                    if (fila >= 0) {
                        IdProveedor = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
                        Proveedores p = new Proveedores(IdProveedor, "0");
                        if (IdProveedor > 0) {
                            if (ProveedoresADN.CambiarEstado(p)) {
                                JOptionPane.showMessageDialog(rootPane, "Se cambio el estado del proveedor correctamente");
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
                        IdProveedor = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
                        Proveedores p = new Proveedores(IdProveedor, "1");
                        if (IdProveedor > 0) {
                            if (ProveedoresADN.CambiarEstado(p)) {
                                JOptionPane.showMessageDialog(rootPane, "Se dio de baja al proveedor correctamente");
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

    private void jteListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jteListaMouseClicked
        int fila = jteLista.getSelectedRow();
        idpro = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
        jbtnActivar.setEnabled(true);
    }//GEN-LAST:event_jteListaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private org.swing.componet.JTextBoxHintDS jtfdDireccion;
    private org.swing.componet.JTextBoxHintDS jtfdRazonSocial;
    private org.swing.componet.JTextBoxHintDS jtfdRazonSocialB;
    private org.swing.componet.JTextBoxHintDS jtfdRuc;
    private org.swing.componet.JTextBoxHintDS jtfdRucB;
    private org.swing.componet.JTextBoxHintDS jtfdTelefono;
    private javax.swing.JTabbedPane jtpeTablepanel;
    // End of variables declaration//GEN-END:variables

    private void VerDatos(){
        try {
            int filas = jteLista.getRowCount();
            for (int i = 0; i < filas; i++) {
                dtm.removeRow(0);
            }
            Proveedores c = new Proveedores();
            c.setRuc(jtfdRucB.getText().trim());
            c.setRaz(jtfdRazonSocialB.getText().trim());
            c.setEst(String.valueOf(estado));
            for (Proveedores la : ProveedoresADN.Lista(c)) {
                dtm.addRow(la.ArregloDatos());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }

    }
}