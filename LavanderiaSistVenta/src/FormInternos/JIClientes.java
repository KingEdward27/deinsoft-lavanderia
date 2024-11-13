/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FormInternos;

import Adicional.Util;
import accesodatos.ClientesADN;
import client.LoginRequest;
import entidades.Clientes;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.validacion.Controles.PanelDS;
import org.validacion.Controles.TextFieldDS;

/**
 *
 * @author Crixuz
 */
public class JIClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIClientes
     */
    public JIClientes() {
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
        jLabel1 = new javax.swing.JLabel();
        jtfdDniB = new org.swing.componet.JTextBoxHintDS();
        jtfdNombresB = new org.swing.componet.JTextBoxHintDS();
        jLabel2 = new javax.swing.JLabel();
        jrbnActivos = new javax.swing.JRadioButton();
        jrbnInactivos = new javax.swing.JRadioButton();
        jtpeTablepanel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jteLista = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfdNombres = new org.swing.componet.JTextBoxHintDS();
        jtfdDni = new org.swing.componet.JTextBoxHintDS();
        jLabel4 = new javax.swing.JLabel();
        jtfdDireccion = new org.swing.componet.JTextBoxHintDS();
        jLabel5 = new javax.swing.JLabel();
        jtfdTelefono = new org.swing.componet.JTextBoxHintDS();
        jLabel6 = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        jtfdCorreo = new org.swing.componet.JTextBoxHintDS();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbxTipo = new javax.swing.JComboBox<>();
        jbtnNuevo = new javax.swing.JButton();
        jbtnActivar = new javax.swing.JButton();

        setClosable(true);
        setTitle(">>>>:::::: Lista de Clientes ::::::<<<<");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Cliente"));

        jLabel1.setText("DNI:");

        jtfdDniB.setHint("Ingrese su Dni");
        jtfdDniB.setLength(8);
        jtfdDniB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfdNombresBKeyPressed(evt);
            }
        });

        jtfdNombresB.setHint("Ingrese sus Nombres");
        jtfdNombresB.setTipoTextBox(org.Interfaces.Enum.TipoTextBox.SoloTexto);
        jtfdNombresB.setTiponumero(null);
        jtfdNombresB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfdNombresBKeyPressed(evt);
            }
        });

        jLabel2.setText("Nombres:");

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
                    .addComponent(jtfdDniB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtfdNombresB, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jtfdDniB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfdNombresB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                "IdCliente", "Nombres", "DNI", "Dirección", "Telefono", "Correo", "Tipo", "Estado"
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
        if (jteLista.getColumnModel().getColumnCount() > 0) {
            jteLista.getColumnModel().getColumn(0).setMinWidth(0);
            jteLista.getColumnModel().getColumn(0).setPreferredWidth(0);
            jteLista.getColumnModel().getColumn(0).setMaxWidth(0);
            jteLista.getColumnModel().getColumn(1).setMinWidth(180);
            jteLista.getColumnModel().getColumn(1).setPreferredWidth(180);
            jteLista.getColumnModel().getColumn(1).setMaxWidth(180);
            jteLista.getColumnModel().getColumn(2).setMinWidth(70);
            jteLista.getColumnModel().getColumn(2).setPreferredWidth(70);
            jteLista.getColumnModel().getColumn(2).setMaxWidth(70);
            jteLista.getColumnModel().getColumn(4).setMinWidth(80);
            jteLista.getColumnModel().getColumn(4).setPreferredWidth(80);
            jteLista.getColumnModel().getColumn(4).setMaxWidth(80);
            jteLista.getColumnModel().getColumn(5).setMinWidth(0);
            jteLista.getColumnModel().getColumn(5).setPreferredWidth(0);
            jteLista.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        jtpeTablepanel.addTab("Lista", jPanel2);

        jLabel3.setText("Nombres:");

        jtfdNombres.setEditable(false);
        jtfdNombres.setHint("Ingrese sus Apellidos y Nombres");
        jtfdNombres.setPrimeraMayus(java.lang.Boolean.TRUE);
        jtfdNombres.setTipoTextBox(org.Interfaces.Enum.TipoTextBox.SoloTexto);
        jtfdNombres.setTiponumero(null);

        jtfdDni.setEditable(false);
        jtfdDni.setHint("Ingrese su DNI");
        jtfdDni.setLength(11);
        jtfdDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfdDniActionPerformed(evt);
            }
        });

        jLabel4.setText("DNI/RUC:");

        jtfdDireccion.setEditable(false);
        jtfdDireccion.setHint("Ingrese su Dirección");
        jtfdDireccion.setPrimeraMayus(java.lang.Boolean.TRUE);
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

        jtfdCorreo.setEditable(false);
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

        jLabel8.setText("Tipo:");

        jcbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-DNI", "4-CARNET EXTRANJERIA", "6-RUC", "7-PASAPORTE" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jtfdNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jcbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfdDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jtfdCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfdTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jtfdDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnGuardar)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfdDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfdCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpeTablepanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnActivar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpeTablepanel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnNuevo)
                    .addComponent(jbtnActivar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    DefaultTableModel dtm = null;
    public static int idcli = 0;
    public static String estado = "", est = "";
    public static boolean modif = false;
    
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
            int IdCliente = 0;
            if (jbtnActivar.getText().equals("Inactivar")) {
                int filas = jteLista.getRowCount();
                if (filas > 0) {
                    int fila = jteLista.getSelectedRow();
                    if (fila >= 0) {
                        IdCliente = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
                        Clientes c = new Clientes(IdCliente, "0");
                        if (IdCliente > 0) {
                            if (ClientesADN.CambiarEstado(c)) {
                                JOptionPane.showMessageDialog(rootPane, "Se cambio el estado del cliente correctamente");
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
                        IdCliente = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
                        Clientes c = new Clientes(IdCliente, "1");
                        if (IdCliente > 0) {
                            if (ClientesADN.CambiarEstado(c)) {
                                JOptionPane.showMessageDialog(rootPane, "Se dio de baja al cliente correctamente");
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
       dtm = (DefaultTableModel) jteLista.getModel();
       if (jteLista.getColumnModel().getColumnCount() > 0) {
//            jteLista.getColumnModel().getColumn(0).setMinWidth(0);
//            jteLista.getColumnModel().getColumn(0).setPreferredWidth(0);
//            jteLista.getColumnModel().getColumn(0).setMaxWidth(0);
            jteLista.getColumnModel().getColumn(1).setMinWidth(180);
            jteLista.getColumnModel().getColumn(1).setPreferredWidth(180);
            jteLista.getColumnModel().getColumn(1).setMaxWidth(180);
            jteLista.getColumnModel().getColumn(2).setMinWidth(70);
            jteLista.getColumnModel().getColumn(2).setPreferredWidth(70);
            jteLista.getColumnModel().getColumn(2).setMaxWidth(70);
            jteLista.getColumnModel().getColumn(4).setMinWidth(80);
            jteLista.getColumnModel().getColumn(4).setPreferredWidth(80);
            jteLista.getColumnModel().getColumn(4).setMaxWidth(80);
            jteLista.getColumnModel().getColumn(5).setMinWidth(120);
            jteLista.getColumnModel().getColumn(5).setPreferredWidth(120);
            jteLista.getColumnModel().getColumn(5).setMaxWidth(120);
            jteLista.getColumnModel().getColumn(6).setMinWidth(0);
            jteLista.getColumnModel().getColumn(6).setPreferredWidth(0);
            jteLista.getColumnModel().getColumn(6).setMaxWidth(0);
            jteLista.getColumnModel().getColumn(7).setMinWidth(0);
            jteLista.getColumnModel().getColumn(7).setPreferredWidth(0);
            jteLista.getColumnModel().getColumn(7).setMaxWidth(0);
        }
       estado = "1";
       VerDatos();
    }//GEN-LAST:event_formInternalFrameActivated

    private void jtfdNombresBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfdNombresBKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                VerDatos();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.toString());
            }
        }
    }//GEN-LAST:event_jtfdNombresBKeyPressed

    private void jteListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jteListaMouseClicked
        jbtnActivar.setEnabled(true);
    }//GEN-LAST:event_jteListaMouseClicked

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        try {
            String nom = "", dn = "", tel = "", dir = "";
            nom = jtfdNombres.getText().trim().toUpperCase();
            dn = jtfdDni.getText().trim().toUpperCase();
            tel = jtfdTelefono.getText().trim().toUpperCase();
            dir = jtfdDireccion.getText().trim().toUpperCase();
            String tipo = jcbxTipo.getSelectedItem().toString();
            Clientes cli = null;
            String mensaje = "";
            if(dn.length()> 10 && tipo.contains("1-")){
                JOptionPane.showMessageDialog(rootPane, "Si es RUC, debe seleccionar correctamente el tipo de documento, caso contrario ingrese sólo 8 dígitos");
                return;
            }
            if (nom.length() == 0 ) {
                JOptionPane.showMessageDialog(rootPane, "Asegurese de ingresar el nombre");
            } else {
                Clientes c = new Clientes();
                c.setNombres(nom);
                c.setDni(dn);
                c.setIdCliente(idcli);
                boolean respuesta = true;
                
                if (modif == false) {
                    cli = new Clientes(idcli, nom, dn, dir, tel, "1",jtfdCorreo.getText().trim(),tipo);
                    mensaje = "Datos guardados correctamente";
                } else {
                    cli = new Clientes(idcli, nom, dn, dir, tel, est,jtfdCorreo.getText().trim(),tipo);
                    mensaje = "Datos actualizados correctamente";
                }
                if (ClientesADN.Evaluar(c) == 1) {
                    int r = JOptionPane.showConfirmDialog(rootPane, "Ya existe un cliente con el msmo nombre, ¿Desea registrarlo de todas maneras?");
                    if (r == 0) {
                        respuesta = true;
                    } else {
                        respuesta = false;
                    }
                }
//                if (ClientesADN.Evaluar(c) == 2) {
//                    int r = JOptionPane.showConfirmDialog(rootPane, "Ya existe un cliente con el msmo DNI, ¿Desea registrarlo de todas maneras?");
//                    if (r == 0) {
//                        respuesta = true;
//                    } else {
//                        respuesta = false;
//                    }
//                }
//                if (ClientesADN.Evaluar(c) == 3) {
//                    JOptionPane.showMessageDialog(rootPane, "Ya existe un cliente con el msmo nombre y DNI, No se puede registrar al cliente");
//                    respuesta = false;
//                }
                if (respuesta) {
                    if (ClientesADN.Guardar(cli)) {
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

    private void jteListaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jteListaKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = jteLista.getSelectedRow();
            modif = true;
            if (fila >= 0) {
                String es = jteLista.getValueAt(fila, 7).toString();
                if ("1".equals(es)) {
                    idcli = Integer.parseInt(jteLista.getValueAt(fila, 0).toString());                            
                    jtfdNombres.setText(jteLista.getValueAt(fila, 1).toString());
                    jtfdDni.setText(jteLista.getValueAt(fila, 2).toString());
                    jtfdDireccion.setText(jteLista.getValueAt(fila, 3).toString());
                    jtfdTelefono.setText(jteLista.getValueAt(fila, 4).toString());
                    jtfdCorreo.setText(jteLista.getValueAt(fila, 5).toString());
                    jcbxTipo.setSelectedItem(jteLista.getValueAt(fila, 6).toString());
                    est=jteLista.getValueAt(fila, 7).toString();
                    jbtnNuevoActionPerformed(null);
                    PanelDS.pintartext(jPanel3);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "El Cliente Seleccionado se \n encuentra Inactivo");
                }
            }
        }
    }//GEN-LAST:event_jteListaKeyPressed

    private void jtfdCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfdCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfdCorreoActionPerformed

    private void jtfdDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfdDniActionPerformed
        LoginRequest l = new LoginRequest("edward21.sistemas@gmail.com", "123456");
        try {
            String jsonToken = Util.simpleApiWithJsonBody("http://inifact.pro/ventas-backend/login",l.toJson(l), "post", null, "*/*", "application/json");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Operación inválida: "+ e.getMessage());
        }
        
    }//GEN-LAST:event_jtfdDniActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnActivar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JComboBox<String> jcbxTipo;
    private javax.swing.JRadioButton jrbnActivos;
    private javax.swing.JRadioButton jrbnInactivos;
    private javax.swing.JTable jteLista;
    private org.swing.componet.JTextBoxHintDS jtfdCorreo;
    private org.swing.componet.JTextBoxHintDS jtfdDireccion;
    private org.swing.componet.JTextBoxHintDS jtfdDni;
    private org.swing.componet.JTextBoxHintDS jtfdDniB;
    private org.swing.componet.JTextBoxHintDS jtfdNombres;
    private org.swing.componet.JTextBoxHintDS jtfdNombresB;
    private org.swing.componet.JTextBoxHintDS jtfdTelefono;
    private javax.swing.JTabbedPane jtpeTablepanel;
    // End of variables declaration//GEN-END:variables

    private void VerDatos() {
        try {
            int filas = jteLista.getRowCount();
            for (int i = 0; i < filas; i++) {
                dtm.removeRow(0);
            }
            Clientes c = new Clientes();
            c.setDni(jtfdDniB.getText().trim());
            c.setNombres(jtfdNombresB.getText().trim());
            c.setEstado(String.valueOf(estado));
            for (Clientes la : ClientesADN.Lista(c)) {
                dtm.addRow(la.ArregloDatos());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }

    }
}
