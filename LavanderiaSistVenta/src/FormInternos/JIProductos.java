/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FormInternos;

import accesodatos.ProductosADN;
import entidades.Categorias;
import entidades.Marcas;
import entidades.Productos;
import entidades.UnidadMedidas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.validacion.Controles.PanelDS;

/**
 *
 * @author Crixuz
 */
public class JIProductos extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIProductos
     */
    public JIProductos() {
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfdFiltro = new org.swing.componet.JTextBoxHintDS();
        jrbnActivos = new javax.swing.JRadioButton();
        jrbnInactivos = new javax.swing.JRadioButton();
        rbnmarca = new javax.swing.JRadioButton();
        rbndescripcion = new javax.swing.JRadioButton();
        jtpeListaDatos = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jteLista = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jtfdMarca = new org.swing.componet.JTextBoxHintDS();
        jLabel4 = new javax.swing.JLabel();
        jbtnBMarca = new javax.swing.JButton();
        jtfdProducto = new org.swing.componet.JTextBoxHintDS();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfdObservacion = new org.swing.componet.JTextBoxHintDS();
        jbtnGuardar = new javax.swing.JButton();
        jtfdPrecio = new org.swing.componet.JTextBoxHintDS();
        jbtnNuevo = new javax.swing.JButton();
        jbtnActivar = new javax.swing.JButton();

        setClosable(true);
        setTitle(">>>:::::: Lista de Productos ::::::<<<");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Productos"));

        jLabel1.setText("Filtro:");

        jtfdFiltro.setHint("Ingrese Categoria");
        jtfdFiltro.setTipoTextBox(null);
        jtfdFiltro.setTiponumero(null);
        jtfdFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfdFiltroActionPerformed(evt);
            }
        });
        jtfdFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfdFiltroKeyPressed(evt);
            }
        });

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

        buttonGroup2.add(rbnmarca);
        rbnmarca.setText("Marca");
        rbnmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnmarcaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbndescripcion);
        rbndescripcion.setSelected(true);
        rbndescripcion.setText("Descripcion");
        rbndescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbndescripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfdFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbndescripcion)
                        .addGap(10, 10, 10)
                        .addComponent(rbnmarca)
                        .addGap(139, 139, 139)))
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
                    .addComponent(jrbnActivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfdFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbnInactivos)
                    .addComponent(rbndescripcion)
                    .addComponent(rbnmarca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jteLista.setAutoCreateRowSorter(true);
        jteLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDPRODUCTO", "MARCA", "CATEGORIA", "UNIDAD MEDIDA", "DESCRIPCION", "COSTO", "PRECIO", "PRECIO X MAYOR", "PAQUETES", "STOCK", "MINIMO", "COD BARRA", "OBSERVACION", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        jScrollPane2.setViewportView(jteLista);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        jtpeListaDatos.addTab("Lista", jPanel2);

        jtfdMarca.setEditable(false);
        jtfdMarca.setHint("Nombre de la marca");
        jtfdMarca.setTipoTextBox(null);
        jtfdMarca.setTiponumero(null);

        jLabel4.setText("Marca:");

        jbtnBMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/find2.png"))); // NOI18N
        jbtnBMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBMarcaActionPerformed(evt);
            }
        });

        jtfdProducto.setEditable(false);
        jtfdProducto.setHint("Ingrese nombre del producto");
        jtfdProducto.setTipoTextBox(null);
        jtfdProducto.setTiponumero(null);

        jLabel5.setText("Producto:");

        jLabel8.setText("Precio:");

        jLabel12.setText("Observacion:");

        jtfdObservacion.setEditable(false);
        jtfdObservacion.setHint("Ingrese Observacion");
        jtfdObservacion.setTipoTextBox(null);
        jtfdObservacion.setTiponumero(null);

        jbtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/save.png"))); // NOI18N
        jbtnGuardar.setText("Guardar");
        jbtnGuardar.setEnabled(false);
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jtfdPrecio.setEditable(false);
        jtfdPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfdPrecio.setHint("S/. 0.00");
        jtfdPrecio.setTiponumero(org.Interfaces.Enum.TiposNumeros.Decimal);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jtfdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnBMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jtfdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jtfdPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtfdObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbtnBMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jtfdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfdPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfdObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbtnGuardar))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jtpeListaDatos.addTab("Datos", jPanel3);

        jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar2.png"))); // NOI18N
        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jbtnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/elimi.png"))); // NOI18N
        jbtnActivar.setText("Inactivar");
        jbtnActivar.setEnabled(false);
        jbtnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jbtnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnActivar))
                    .addComponent(jtpeListaDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpeListaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnNuevo)
                    .addComponent(jbtnActivar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static int iduni = 0, idpro = 0, idsub = 0;
    public static String estado = "", nomuni = "", nomsub = "", opcion = "", est = "";
    public static boolean modif = false, llamada = false;
    DefaultTableModel dtm = null;
    static Productos productos;
    public static Marcas marca;
    public static Categorias categoria;
    public static UnidadMedidas unidadmedida;
    void OcultarColumna(JTable jtable, int indice)
    {
        jtable.getColumnModel().getColumn(indice).setMaxWidth(0);
        jtable.getColumnModel().getColumn(indice).setMinWidth(0);
        jtable.getColumnModel().getColumn(indice).setPreferredWidth(0);
    }
    void ModificarTamaño(JTable jtable, int indice,int tamano)
    {
        jtable.getColumnModel().getColumn(indice).setMaxWidth(tamano);
        jtable.getColumnModel().getColumn(indice).setMinWidth(tamano);
        jtable.getColumnModel().getColumn(indice).setPreferredWidth(tamano);
    }
    private void jbtnBMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBMarcaActionPerformed
        llamada = true;
        marca = new Marcas();
        JDBuscarMarca v = new JDBuscarMarca(null, closable);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
        if (marca.getIdMarcas() > 0) {
            jtfdMarca.setText(marca.getNombre());
            jtfdMarca.setForeground(Color.BLACK);
        } else {
            jtfdMarca.setText("");
            idsub = 0;
        }
        llamada = false;
    }//GEN-LAST:event_jbtnBMarcaActionPerformed

    private void rbnmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnmarcaActionPerformed
        try {
            jtfdFiltro.setHint("Ingrese marca");
            VerDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_rbnmarcaActionPerformed

    private void rbndescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbndescripcionActionPerformed
        try {
            jtfdFiltro.setHint("Ingrese descripcion");
            VerDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_rbndescripcionActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        if (jbtnNuevo.getText().equals("Nuevo")) {
            jbtnNuevo.setText("Cancelar");
            jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/cancelar1.png")));
            jtpeListaDatos.setSelectedIndex(1);
            Habilitar(true);
//            PanelDS.LimpiarCampos(jPanel3);
            PanelDS.HabilitarCajaE(jPanel3);
//            jtfdCategoria.setEditable(false);
//            jtfdUnidadMedida.setEditable(false);
            jtfdMarca.setEditable(false);
        } else {
            jbtnNuevo.setText("Nuevo");
            jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar2.png")));
            jtpeListaDatos.setSelectedIndex(0);
            Habilitar(false);
            PanelDS.LimpiarCampos(jPanel3);
            PanelDS.DesabilitarCajaE(jPanel3);
            Limpiar();
        }
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActivarActionPerformed
        try {
            int IdProducto = 0;
            if (jbtnActivar.getText().equals("Inactivar")) {
                int filas = jteLista.getRowCount();
                if (filas > 0) {
                    int fila = jteLista.getSelectedRow();
                    if (fila >= 0) {
                        IdProducto = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
                        Productos p = new Productos(IdProducto, null, "0");
                        if (IdProducto > 0) {
                            if (ProductosADN.CambiarEstado(p)) {
                                JOptionPane.showMessageDialog(rootPane, "Se cambio el estado del Producto correctamente");
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
                        IdProducto = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
                        Productos p = new Productos(IdProducto, null, "1");
                        if (IdProducto > 0) {
                            if (ProductosADN.CambiarEstado(p)) {
                                JOptionPane.showMessageDialog(rootPane, "Se dio de baja al Producto correctamente");
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
        estado = "1";
        VerDatos();
        OcultarColumna(jteLista, 0);
        OcultarColumna(jteLista, 2);
        OcultarColumna(jteLista, 3);
        OcultarColumna(jteLista, 5);
        OcultarColumna(jteLista, 7);
        OcultarColumna(jteLista, 8);
        OcultarColumna(jteLista, 9);
        OcultarColumna(jteLista, 10);
        OcultarColumna(jteLista, 11);
        OcultarColumna(jteLista, 12);
        OcultarColumna(jteLista, 13);
//        ModificarTamaño(jteLista, 1, 200);
//        ModificarTamaño(jteLista, 4, 280);
//        ModificarTamaño(jteLista, 6, 150);
    }//GEN-LAST:event_formInternalFrameActivated

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        try {
            String des = "", mar = "", ori = "";
            float cos = 0.0f, pre = 0.0f, pre2 = 0.0f, paquete = 0.0f, stock_min = 0.0f;

            mar = jtfdMarca.getText().trim().toUpperCase();
            des = jtfdProducto.getText().trim().toUpperCase();
            cos = 0f;
            pre = Float.valueOf(jtfdPrecio.getText().trim());
            pre2 = 0f;
            stock_min = 0f;
            String obs = jtfdObservacion.getText().trim().toUpperCase();
            String barra = "";
            paquete = 0f;
            Productos cli = null;
            String mensaje = "";
            if (des.length() == 0 ) {
                JOptionPane.showMessageDialog(rootPane, "Asegurese de llenar los datos correctamente");
            } else {
                if (pre < cos) {
                    JOptionPane.showMessageDialog(rootPane, "El precio no puede ser menor que el costo del producto");
                } else {
                    Productos c = new Productos();
                    c.setDescripcion(des);
                    c.setIdProducto(idpro);
                    categoria = new Categorias();
                    categoria.setIdcategoria(1);
                    
                    unidadmedida = new UnidadMedidas();
                    unidadmedida.setIdUnidadmedida(1);
                    if (modif == false) {
                        //cli = new Productos(0, new Subcategorias(idsub), new UnidadMedidas(iduni), mar, des, ori, pre, 0, stock_min,obs, "1");
                        
                        cli = new Productos(0, marca, categoria, unidadmedida, des, cos, pre,pre2, paquete, 0.0f, stock_min, barra, obs, estado);
                        mensaje = "Datos guardados correctamente";
                    } else {
                        //cli = new Productos(idpro, new Subcategorias(idsub), new UnidadMedidas(iduni), mar, des, ori, pre, 0, stock_min,obs, est);
                        cli = new Productos(idpro, marca, categoria, unidadmedida, des, cos, pre,pre2, paquete, 0.0f, stock_min, barra, obs, estado);
                        mensaje = "Datos actualizados correctamente";
                    }
                    if (ProductosADN.Evaluar(c)) {
                        JOptionPane.showMessageDialog(rootPane, "Ya existe una categoria con el mismo nombre, No se puede registrar la categoria");

                    } else {
                        boolean gua = ProductosADN.Guardar(cli);
                        if (gua) {

                            JOptionPane.showMessageDialog(rootPane, mensaje);
                            Limpiar();
                            VerDatos();
                            jbtnNuevoActionPerformed(evt);
                            modif=false;
                        }
                    }
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jtfdFiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfdFiltroKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            VerDatos();
//        }
    }//GEN-LAST:event_jtfdFiltroKeyPressed

    private void jtfdFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfdFiltroActionPerformed
        try {
            VerDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_jtfdFiltroActionPerformed

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

    private void jteListaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jteListaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = jteLista.getSelectedRow();
            modif = true;
            if (fila >= 0) {
                try {
                    idpro = Integer.parseInt(jteLista.getValueAt(fila, 0).toString());
                    //CargarCombo();
                    //String nom=jtblista.getValueAt(fila, 1).toString();
                    marca = new Marcas();
                    jtfdMarca.setText(jteLista.getValueAt(fila, 1).toString());
                    marca.setIdMarcas(ProductosADN.CodigoMarca(jteLista.getValueAt(fila, 1).toString()));
                    categoria = new Categorias();
                    categoria.setIdcategoria(ProductosADN.CodigoCategoria(jteLista.getValueAt(fila, 2).toString()));
                    unidadmedida = new UnidadMedidas();
                    unidadmedida.setIdUnidadmedida(ProductosADN.CodigoUnidad(jteLista.getValueAt(fila, 3).toString()));
                    jtfdProducto.setText(jteLista.getValueAt(fila, 4).toString());
                    jtfdPrecio.setText(jteLista.getValueAt(fila, 6).toString());
                    jtfdObservacion.setText(jteLista.getValueAt(fila, 12).toString());
                    est = jteLista.getValueAt(fila, 13).toString();
                    jbtnNuevoActionPerformed(null);
                    PanelDS.pintartext(jPanel3);
                    jtfdProducto.requestFocus();
//                } catch (NumberFormatException numberFormatException) {
//                } catch (SQLException sQLException) {
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Error - " + e.toString());
                }
            }
        }
    }//GEN-LAST:event_jteListaKeyPressed

    private void jteListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jteListaMouseClicked
        int fila = jteLista.getSelectedRow();
        idpro = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
        jbtnActivar.setEnabled(true);
    }//GEN-LAST:event_jteListaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnActivar;
    private javax.swing.JButton jbtnBMarca;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JRadioButton jrbnActivos;
    private javax.swing.JRadioButton jrbnInactivos;
    private javax.swing.JTable jteLista;
    private org.swing.componet.JTextBoxHintDS jtfdFiltro;
    private org.swing.componet.JTextBoxHintDS jtfdMarca;
    private org.swing.componet.JTextBoxHintDS jtfdObservacion;
    private org.swing.componet.JTextBoxHintDS jtfdPrecio;
    private org.swing.componet.JTextBoxHintDS jtfdProducto;
    private javax.swing.JTabbedPane jtpeListaDatos;
    private javax.swing.JRadioButton rbndescripcion;
    private javax.swing.JRadioButton rbnmarca;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        //tbxsubcategoria.setText("");
        idsub = 0;
        idpro = 0;
        iduni = 0;
    }

    private void Habilitar(boolean es) {
//        jbtnBUnidad.setEnabled(es);
//        jbtnBuscarCategoria.setEnabled(es);
        jbtnGuardar.setEnabled(es);
        jbtnBMarca.setEnabled(es);
    }

    private void VerDatos() {
        try {
            int filas = jteLista.getRowCount();
            for (int i = 0; i < filas; i++) {
                dtm.removeRow(0);
            }
            Productos c = new Productos();
            c.setCodbarra("");
            c.setEstado(String.valueOf(estado));
            if (rbnmarca.isSelected()) {
                c.setCategoriasx(new Categorias(0, ""));
                c.setDescripcion("");
                c.setMarca(new Marcas(jtfdFiltro.getText().trim()));
                for (Productos la : ProductosADN.ListaProductos_Cat(c)) {
                    dtm.addRow(la.ArregloDatos());
                }
            } else if (rbndescripcion.isSelected()) {
                c.setCategoriasx(new Categorias(0, ""));
                c.setDescripcion(jtfdFiltro.getText().trim());
                c.setMarca(new Marcas(""));
                for (Productos la : ProductosADN.ListaProductos_Cat(c)) {
                    dtm.addRow(la.ArregloDatos());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
}