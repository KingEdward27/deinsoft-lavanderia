/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FormInternos;

import Adicional.Util;
import accesodatos.ProductosADN;
import accesodatos.VentasADN;
import entidades.ConsultaVentas;
import entidades.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDWARD
 */
public class JIAnularVentas extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIAnularVentas
     */
    public JIAnularVentas() {
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
        jLabel7 = new javax.swing.JLabel();
        btnanular = new javax.swing.JButton();
        btnmostrar = new javax.swing.JButton();
        jdprFecha = new com.michaelbaranov.microba.calendar.DatePicker();
        jrbnporcobrar = new javax.swing.JRadioButton();
        jrbncobradas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setTitle("::::>>>> Anular ventas<<<<::::");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
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
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));

        jLabel7.setText("Fecha:");

        btnanular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/cancelar1.png"))); // NOI18N
        btnanular.setText("Anular");
        btnanular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanularActionPerformed(evt);
            }
        });

        btnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/show.png"))); // NOI18N
        btnmostrar.setText("Mostrar");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbnporcobrar);
        jrbnporcobrar.setText("Por entregar");
        jrbnporcobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbnporcobrarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbncobradas);
        jrbncobradas.setSelected(true);
        jrbncobradas.setText("Entregadas");
        jrbncobradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbncobradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jdprFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbnporcobrar)
                    .addComponent(jrbncobradas))
                .addGap(29, 29, 29)
                .addComponent(btnmostrar)
                .addGap(18, 18, 18)
                .addComponent(btnanular)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnanular)
                                .addComponent(btnmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbnporcobrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbncobradas))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdprFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod_venta", "Serie", "Nro", "Cliente", "Fecha", "Vendedor", "Importe total", "FlagPSEVenta", "FlagPSEIngreso", "Fecha Envío"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultTableModel dtm = null;
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        dtm = (DefaultTableModel) jTable1.getModel();
        Util.OcultarColumnaJtable(jTable1,7);
        Util.OcultarColumnaJtable(jTable1,8);
        //Util.OcultarColumnaJtable(jTable1,9);
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnanularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanularActionPerformed
        try {
            Ventas v = new Ventas();
            int fila = jTable1.getSelectedRow();
            if (fila >= 0) {
                int id = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
                String flagPSEVenta = dtm.getValueAt(fila, 7).toString();
                String flagPSEIngreso = dtm.getValueAt(fila, 8).toString();
                String fechaEnvio = dtm.getValueAt(fila, 9).toString();
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date dateEnvio = formatter.parse(fechaEnvio);
                java.util.Date currentDate = new java.util.Date(); 
                
                long days = Util.getDateDiff(currentDate,dateEnvio,TimeUnit.DAYS);
//                if(!fechaEnvio.equals("01/01/1900") && days > 0 && flagPSEVenta.equals("1") || flagPSEIngreso.equals("1")){
//                    JOptionPane.showMessageDialog(rootPane, "No se puede anular una venta enviada a SUNAT pasado un día");
//                    return;
//                }
                v.setIdventa(id);
                v.setEstado("0");
//                ConsultaVentas2 datosVenta = null;
////                List<ConsultaVentas2> datosVentaDetalle = null;
//                try {
//                    datosVenta = VentasADN.getDatosVenta(null, null, id, true).get(0);
////                    datosVentaDetalle = VentasADN.Detalle_Ventas(id);
//                } catch (SQLException ex) {
//                    System.out.println(Util.exceptionToString(ex));
//                } catch (ClassNotFoundException ex) {
//                    System.out.println(Util.exceptionToString(ex));
//                }
//                if(flagPSEVenta.equals("1") || flagPSEIngreso.equals("1")){
//                    JOptionPane.showMessageDialog(rootPane, "No se puede anular una venta enviada a SUNAT");
//                    return;
//                }
                int r = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que desea anular esta venta?");
                if (r == 0) {
                    boolean anu = VentasADN.CambiarEstado(v);
                    if (anu) {
//                        int s = JOptionPane.showConfirmDialog(rootPane, "¿Desa actualizaar el stock de los productos incluidos en la venta?");
//                        if (s == 0) {
//                            for (ProductoDetalle item : VentasADN.DetalleVenta(id)) {
//                                Productos p = new Productos();
//                                p.setIdProducto(item.getIdproduct());
//                                p.setStock(item.getCantidad());
//                                ProductosADN.AñadirStock(p);
//                            }
//                        }
                        JOptionPane.showMessageDialog(rootPane, "Venta anulada");
                        VerDatos();
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_btnanularActionPerformed

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        try {
            VerDatos();
//            int nrofilas=0;
//            float totalventas=0;
//            int filas=jTable1.getRowCount();
//            for (int i = 0; i < filas; i++) {
//                nrofilas+=1;
//                tbxnroventas.setText(String.valueOf(nrofilas));
//                totalventas+=Float.parseFloat(dtm.getValueAt(i, 4).toString());
//                tbxtotal.setText(String.valueOf(totalventas));
//            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_btnmostrarActionPerformed

    private void jrbnporcobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbnporcobrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbnporcobrarActionPerformed

    private void jrbncobradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbncobradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbncobradasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnanular;
    private javax.swing.JButton btnmostrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.michaelbaranov.microba.calendar.DatePicker jdprFecha;
    private javax.swing.JRadioButton jrbncobradas;
    private javax.swing.JRadioButton jrbnporcobrar;
    // End of variables declaration//GEN-END:variables

    private void VerDatos() throws SQLException, ClassNotFoundException {
        try {
            int filas = jTable1.getRowCount();
            for (int i = 0; i < filas; i++) {
                dtm.removeRow(0);
            }
            String fec1 = Formatos.sdfFecha.format(jdprFecha.getDate());
            String fec2 = Formatos.sdfFecha.format(jdprFecha.getDate());
            Date fechasql1 = Formatos.FechaSQL(fec1);
            Date fechasql2 = Formatos.FechaSQL(fec2);
            String estado = "";
            if (jrbncobradas.isSelected()) {
                estado = "*2*";
            } else {
                estado = "*p*1*";
            }
            for (ConsultaVentas la : VentasADN.ConsultaVentas2(fechasql1, fechasql2, estado)) {
                dtm.addRow(la.ArregloDatosAnular());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
}
