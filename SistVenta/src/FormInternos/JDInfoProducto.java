/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FormInternos;

import accesodatos.ProductosADN;
import entidades.Productos;
import javax.swing.JOptionPane;

/**
 *
 * @author EDWARD
 */
public class JDInfoProducto extends javax.swing.JDialog {

    /**
     * Creates new form JDInfoProducto
     */
    public JDInfoProducto(java.awt.Frame parent, boolean modal) {
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

        jtfdprecio2 = new org.swing.componet.JTextBoxHintDS();
        jLabel5 = new javax.swing.JLabel();
        jtfdstock = new org.swing.componet.JTextBoxHintDS();
        jtfdcategoria = new org.swing.componet.JTextBoxHintDS();
        jtfdprecio = new org.swing.componet.JTextBoxHintDS();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfdunidadmedida = new org.swing.componet.JTextBoxHintDS();
        jtfdcantidad = new org.swing.componet.JTextBoxHintDS();
        jLabel3 = new javax.swing.JLabel();
        rbnpaquete = new javax.swing.JRadioButton();
        jtfddescripcion = new org.swing.componet.JTextBoxHintDS();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfdmarca = new org.swing.componet.JTextBoxHintDS();
        jtfdcosto = new org.swing.componet.JTextBoxHintDS();
        jtfdCodBarra = new org.swing.componet.JTextBoxHintDS();
        jLabel2 = new javax.swing.JLabel();
        rbnunidades = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtfdprecio2.setEditable(false);
        jtfdprecio2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfdprecio2.setHint("S/. 0.00");
        jtfdprecio2.setTiponumero(org.Interfaces.Enum.TiposNumeros.Decimal);

        jLabel5.setText("Categoria:");

        jtfdstock.setEditable(false);
        jtfdstock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfdstock.setHint("00");
        jtfdstock.setTiponumero(org.Interfaces.Enum.TiposNumeros.Decimal);

        jtfdcategoria.setEditable(false);
        jtfdcategoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfdcategoria.setHint("categoria");
        jtfdcategoria.setTipoTextBox(null);
        jtfdcategoria.setTiponumero(null);

        jtfdprecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfdprecio.setHint("S/. 0.00");
        jtfdprecio.setTiponumero(org.Interfaces.Enum.TiposNumeros.Decimal);

        jLabel6.setText("Unid. Med.:");

        jLabel8.setText("Precio x Mayor:");

        jtfdunidadmedida.setEditable(false);
        jtfdunidadmedida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfdunidadmedida.setTipoTextBox(null);
        jtfdunidadmedida.setTiponumero(null);

        jtfdcantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfdcantidad.setHint("00");
        jtfdcantidad.setTiponumero(org.Interfaces.Enum.TiposNumeros.Decimal);

        jLabel3.setText("Producto:");

        rbnpaquete.setText("X mayor");
        rbnpaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnpaqueteActionPerformed(evt);
            }
        });

        jtfddescripcion.setEditable(false);
        jtfddescripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtfddescripcion.setHint("nombre del producto");
        jtfddescripcion.setTipoTextBox(null);
        jtfddescripcion.setTiponumero(null);

        jLabel9.setText("Stock:");

        jLabel4.setText("Marca:");

        jLabel10.setText("Cantidad:");

        jtfdmarca.setEditable(false);
        jtfdmarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfdmarca.setHint("marca");
        jtfdmarca.setTipoTextBox(null);
        jtfdmarca.setTiponumero(null);

        jtfdcosto.setEditable(false);
        jtfdcosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfdcosto.setHint("S/. 0.00");
        jtfdcosto.setTipoTextBox(null);
        jtfdcosto.setTiponumero(null);

        jtfdCodBarra.setEditable(false);
        jtfdCodBarra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfdCodBarra.setHint("Buscar Codigo de Barra");
        jtfdCodBarra.setTipoTextBox(null);
        jtfdCodBarra.setTiponumero(null);

        jLabel2.setText("Codigo Barra:");

        rbnunidades.setSelected(true);
        rbnunidades.setText("X menor");
        rbnunidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnunidadesActionPerformed(evt);
            }
        });

        jLabel7.setText("Precio:");

        jLabel1.setText("Costo:");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/cancelarventa.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/enviar.png"))); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
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
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jtfdcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdunidadmedida, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdcosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfdCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfddescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfdmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfdprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfdprecio2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfdstock, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfdcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbnpaquete)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbnunidades)))))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfdCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfddescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfdmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfdcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfdunidadmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtfdcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfdprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfdprecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jtfdstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtfdcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbnunidades)
                    .addComponent(rbnpaquete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbnpaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnpaqueteActionPerformed
        //        if (JIVentas.llamada) {
            //            if (rbnpaquete.isSelected()) {
                //                jtfdPrecio.setText(jteLista.getValueAt(jteLista.getSelectedRow(), 7).toString());
                //            } else if (rbnunidades.isSelected()) {
                //                jtfdPrecio.setText(jteLista.getValueAt(jteLista.getSelectedRow(), 6).toString());
                //            }
            //        }
    }//GEN-LAST:event_rbnpaqueteActionPerformed

    private void rbnunidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnunidadesActionPerformed
        //        if (JIVentas.llamada || JIVentas2.llamada) {
            //            if (rbnpaquete.isSelected()) {
                //                jtfdPrecio.setText(jteLista.getValueAt(jteLista.getSelectedRow(), 7).toString());
                //            } else if (rbnunidades.isSelected()) {
                //                jtfdPrecio.setText(jteLista.getValueAt(jteLista.getSelectedRow(), 6).toString());
                //            }
            //        }
    }//GEN-LAST:event_rbnunidadesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        //        try {
            //            if (jteLista.getSelectedRowCount() >= 0) {
                //                if (JIVentas.llamada) {
                    //
                    //                    int fila = jteLista.getSelectedRow();
                    //                    idpro = Integer.parseInt(jteLista.getValueAt(fila, 0).toString());
                    //                    float pre = Float.parseFloat(jtfdPrecio.getText().toString());
                    //                    float can = Float.parseFloat(jtfdCantidad.getText().toString());
                    //                    float stock = Float.parseFloat(jteLista.getValueAt(fila, 9).toString());
                    //                    if (rbnpaquete.isSelected()) {
                        //                        float conversor = ProductosADN.Cantidad_XPaquete(idpro);
                        //                        can = conversor * can;
                        //                    }
                    //                    if (can > stock || stock == 0) {
                        //                        JOptionPane.showMessageDialog(rootPane, "No hay stock suficiente");
                        //                    } else {
                        //                        if (fila >= 0 && pre > 0 && can > 0) {
                            //                            JIVentas.ProX.setIdProducto(idpro);
                            //                            JIVentas.ProX.setDescripcion(jteLista.getValueAt(fila, 4).toString());
                            //                            JIVentas.ProX.setPrecio(pre);
                            //                            JIVentas.ProX.setCantidad(can);
                            //                            Productos p = new Productos();
                            //                            p.setPrecio(Float.parseFloat(jtfdPrecio.getText()));
                            //                            p.setStock(can);
                            //                            p.setIdProducto(idpro);
                            //                            if (rbnunidades.isSelected() && Float.parseFloat(jteLista.getValueAt(jteLista.getSelectedRow(), 6).toString()) != Float.parseFloat(jtfdPrecio.getText())) {
                                //                                int r = JOptionPane.showConfirmDialog(rootPane, "¿Desea actualizar el nuevo precio?");
                                //                                if (r == 0) {
                                    //
                                    //                                    ProductosADN.ActualizarPrecio(p);
                                    //
                                    //                                }
                                //                            } else if (rbnpaquete.isSelected() && Float.parseFloat(jteLista.getValueAt(jteLista.getSelectedRow(), 7).toString()) != Float.parseFloat(jtfdPrecio.getText())) {
                                //                                int r = JOptionPane.showConfirmDialog(rootPane, "¿Desea actualizar el nuevo precio?");
                                //                                if (r == 0) {
                                    //
                                    //                                    ProductosADN.ActualizarPrecio2(p);
                                    //
                                    //                                }
                                //                            }
                            //                            ProductosADN.QuitarStock(p);
                            //                            dispose();
                            //                        }
                        //
                        //                    }
                    //                }
                //                if (JIVentas2.llamada) {
                    //
                    //                    int fila = jteLista.getSelectedRow();
                    //                    idpro = Integer.parseInt(jteLista.getValueAt(fila, 0).toString());
                    //                    float pre = Float.parseFloat(jtfdPrecio.getText().toString());
                    //                    float can = Float.parseFloat(jtfdCantidad.getText().toString());
                    //                    float stock = Float.parseFloat(jteLista.getValueAt(fila, 9).toString());
                    //                    if (rbnpaquete.isSelected()) {
                        //                        float conversor = ProductosADN.Cantidad_XPaquete(idpro);
                        //                        can = conversor * can;
                        //                    }
                    //                    if (can > stock || stock == 0) {
                        //                        JOptionPane.showMessageDialog(rootPane, "No hay stock suficiente");
                        //                    } else {
                        //                        if (fila >= 0 && pre > 0 && can > 0) {
                            //                            JIVentas2.ProX.setIdProducto(idpro);
                            //                            JIVentas2.ProX.setDescripcion(jteLista.getValueAt(fila, 4).toString());
                            //                            JIVentas2.ProX.setPrecio(pre);
                            //                            JIVentas2.ProX.setCantidad(can);
                            //                            Productos p = new Productos();
                            //                            p.setPrecio(Float.parseFloat(jtfdPrecio.getText()));
                            //                            p.setStock(can);
                            //                            p.setIdProducto(idpro);
                            //                            if (rbnunidades.isSelected() && Float.parseFloat(jteLista.getValueAt(jteLista.getSelectedRow(), 6).toString()) != Float.parseFloat(jtfdPrecio.getText())) {
                                //                                int r = JOptionPane.showConfirmDialog(rootPane, "¿Desea actualizar el nuevo precio?");
                                //                                if (r == 0) {
                                    //
                                    //                                    ProductosADN.ActualizarPrecio(p);
                                    //
                                    //                                }
                                //                            } else if (rbnpaquete.isSelected() && Float.parseFloat(jteLista.getValueAt(jteLista.getSelectedRow(), 7).toString()) != Float.parseFloat(jtfdPrecio.getText())) {
                                //                                int r = JOptionPane.showConfirmDialog(rootPane, "¿Desea actualizar el nuevo precio?");
                                //                                if (r == 0) {
                                    //
                                    //                                    ProductosADN.ActualizarPrecio2(p);
                                    //
                                    //                                }
                                //                            }
                            //                            ProductosADN.QuitarStock(p);
                            //                            dispose();
                            //                        }
                        //
                        //                    }
                    //                } else if (JICompras.llamada) {
                    //
                    //                    int fila = jteLista.getSelectedRow();
                    //                    idpro = Integer.parseInt(jteLista.getValueAt(fila, 0).toString());
                    //                    float pre = Float.parseFloat(jtfdPrecio.getText().toString());
                    //                    float can = Float.parseFloat(jtfdCantidad.getText().toString());
                    //                    if (rbnpaquete.isSelected()) {
                        //                        float conversor = ProductosADN.Cantidad_XPaquete(idpro);
                        //                        can = conversor * can;
                        //                    }
                    //                    if (fila >= 0 && pre > 0 && can > 0) {
                        //                        JICompras.ProX.setIdProducto(idpro);
                        //                        JICompras.ProX.setDescripcion(jteLista.getValueAt(fila, 4).toString());
                        //                        JICompras.ProX.setPrecio(pre);
                        //                        JICompras.ProX.setCantidad(can);
                        //                        dispose();
                        //                    }
                    //
                    //                }
                //            }
            //        } catch (Exception e) {
            //            JOptionPane.showMessageDialog(rootPane, "Operacion invalida - " + e.toString());
            //        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            Productos p = new Productos();
            p.setCodbarra(JIVentas2.codbarra);
            for (Productos i : ProductosADN.DatosProducto(p)) {
                jtfdCodBarra.setText(i.getCodbarra());
                jtfddescripcion.setText(i.getDescripcion());
                jtfdcategoria.setText(i.getCategoriasx().getNom());
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
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
            java.util.logging.Logger.getLogger(JDInfoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDInfoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDInfoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDInfoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDInfoProducto dialog = new JDInfoProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private org.swing.componet.JTextBoxHintDS jtfdCodBarra;
    private org.swing.componet.JTextBoxHintDS jtfdcantidad;
    private org.swing.componet.JTextBoxHintDS jtfdcategoria;
    private org.swing.componet.JTextBoxHintDS jtfdcosto;
    private org.swing.componet.JTextBoxHintDS jtfddescripcion;
    private org.swing.componet.JTextBoxHintDS jtfdmarca;
    private org.swing.componet.JTextBoxHintDS jtfdprecio;
    private org.swing.componet.JTextBoxHintDS jtfdprecio2;
    private org.swing.componet.JTextBoxHintDS jtfdstock;
    private org.swing.componet.JTextBoxHintDS jtfdunidadmedida;
    private javax.swing.JRadioButton rbnpaquete;
    private javax.swing.JRadioButton rbnunidades;
    // End of variables declaration//GEN-END:variables
}