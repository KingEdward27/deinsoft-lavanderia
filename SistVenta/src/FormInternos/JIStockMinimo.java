/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FormInternos;

import accesodatos.ProductosADN;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entidades.ConsultaProductos;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDWARD
 */
public class JIStockMinimo extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIStockMinimo
     */
    public JIStockMinimo() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tbxnroventas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tbxtotal = new javax.swing.JTextField();
        btnimprimir = new javax.swing.JButton();

        setClosable(true);
        setTitle("::::>>>> Consulta de productos<<<<::::");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod_prod", "Categoria", "Marca", "Descripcion", "Unidad medida", "Stock", "Precio venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Nro de registros:");

        jLabel3.setText("Total valores:");

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Print2.png"))); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbxnroventas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbxtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbxnroventas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultTableModel dtm = null;
    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        Imprimir();
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            dtm = (DefaultTableModel) jTable1.getModel();
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(170);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);
            VerDatos();
            int nrofilas = 0;
            float totalventas = 0;
            int filas = jTable1.getRowCount();
            for (int i = 0; i < filas; i++) {
                nrofilas += 1;
                tbxnroventas.setText(String.valueOf(nrofilas));
                totalventas += Float.parseFloat(dtm.getValueAt(i, 6).toString());
                tbxtotal.setText(String.valueOf(totalventas));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_formInternalFrameOpened
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tbxnroventas;
    private javax.swing.JTextField tbxtotal;
    // End of variables declaration//GEN-END:variables

    private void VerDatos() throws SQLException, ClassNotFoundException {
        try {
            int filas = jTable1.getRowCount();
            for (int i = 0; i < filas; i++) {
                dtm.removeRow(0);
            }
            for (ConsultaProductos la : ProductosADN.StockMinimo()) {
                dtm.addRow(la.ArregloDatos());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }

    void Imprimir() {
        try {
            //creamos un documento
            Document doc = new Document(PageSize.A4, 30f, 20f, 50f, 20f);
            OutputStream archivo = new FileOutputStream("Reporte_productos.pdf");
            PdfWriter.getInstance(doc, archivo);

            //abrimos el archivo
            doc.open();
            Paragraph encabezado = new Paragraph("Reporte de productos", FontFactory.getFont("arial", 24, Font.BOLD));
            encabezado.setAlignment(encabezado.ALIGN_CENTER);
            Paragraph separacion = new Paragraph("\n");
//            Paragraph fecha1 = new Paragraph("Del: " + Formatos.sdfFecha.format(snrfecha.getValue())+"   "+"Al: " + Formatos.sdfFecha.format(snrfecha.getValue()));
//            fecha1.setAlignment(fecha1.ALIGN_CENTER);
//            Paragraph fecha2 = new Paragraph();
            Paragraph linea = new Paragraph("-------------------------------------------------------------------------------------------------------------------------------------");

            BaseFont tipo = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, false);
            Font fuente = new Font(tipo, 13, Font.BOLD, BaseColor.BLUE);
            Paragraph totales = new Paragraph("Nro registros: " + tbxnroventas.getText() + "                                                                                                          " + "Total: " + tbxtotal.getText(), fuente);

            //creamos la tabla para las filas del jtable
            PdfPTable tabla = new PdfPTable(7);
            tabla.getDefaultCell().setBorder(0);
            tabla.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
            int[] ancho = new int[]{80, 100, 140, 180, 100, 80, 100};
            tabla.setWidths(ancho);
            tabla.setSpacingBefore(50);
            tabla.setWidthPercentage(100);
            tabla.addCell("Cod");
            tabla.addCell("Categoria");
            tabla.addCell("Marca");
            tabla.addCell("Descripcion");
            tabla.addCell("Uni-med");
            tabla.addCell("Stock");
            tabla.addCell("Prec_venta");
            PdfPTable tabla2 = new PdfPTable(7);
            tabla2.getDefaultCell().setBorder(0);

            tabla2.setWidths(ancho);
            tabla2.setWidthPercentage(100);

            int filas = jTable1.getRowCount();
            for (int i = 0; i < filas; i++) {
                tabla2.addCell(dtm.getValueAt(i, 0).toString());
                tabla2.addCell(dtm.getValueAt(i, 1).toString());
                tabla2.addCell(dtm.getValueAt(i, 2).toString());
                tabla2.addCell(dtm.getValueAt(i, 3).toString());
                tabla2.addCell(dtm.getValueAt(i, 4).toString());
                tabla2.addCell(dtm.getValueAt(i, 5).toString());
                tabla2.addCell(dtm.getValueAt(i, 6).toString());
            }
            //le añadimos los elementos al documento
            doc.add(encabezado);
//            doc.add(fecha1);
            doc.add(tabla);
            doc.add(linea);
            doc.add(tabla2);
            doc.add(linea);
            doc.add(totales);
            doc.close();
            archivo.close();

            //abrir el documento
            File arch = new File("Reporte_productos.pdf");
            Desktop.getDesktop().open(arch);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al imprimir reporte");
        }
    }
}
