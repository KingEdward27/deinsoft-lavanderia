
package JRibbonForm;

import FormInternos.JIAcerca;
import FormInternos.JIAnularCompras;
import FormInternos.JIAnularVentas;
import FormInternos.JIBackup;
import FormInternos.JICategorias;
import FormInternos.JIClientes;
import FormInternos.JICompras;
import FormInternos.JIConsultaCompras;
import FormInternos.JIConsultaProductos;
import FormInternos.JIConsultaVentas;
import FormInternos.JIEgresos;
import FormInternos.JIIngresos;
import FormInternos.JIListaVentasPendientes;
import FormInternos.JIMarcas;
import FormInternos.JIColores;
import FormInternos.JICaracteristicas;
import FormInternos.JIConsultaProductos2;
import FormInternos.JIProductos;
import FormInternos.JIProveedores;
import FormInternos.JIStockMinimo;
import FormInternos.JITotalCaja;
import FormInternos.JIUnidadMedidas;
import FormInternos.JIUsuarios;
import FormInternos.JIVentas;
import FormInternos.JIListaVentasPendientes;
import FormInternos.JIVentas2;
import FormInternos.JIParametros;
import FormInternos.JIRestauraBackup;
import FormInternos.JITiposServicio;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.common.JCommandMenuButton;
import org.pushingpixels.flamingo.api.common.icon.ImageWrapperResizableIcon;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.JRibbonFrame;
import org.pushingpixels.flamingo.api.ribbon.RibbonApplicationMenu;
import org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.IconRibbonBandResizePolicy;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.BusinessSkin;
import org.pushingpixels.substance.api.skin.GeminiSkin;
import org.validacion.Controles.FormDS;

/**
 *
 * @author Crixuz
 */
public class JRibbonForm extends JRibbonFrame{
    public static boolean esta = false;
    public static boolean admin = false;
    
    public JRibbonForm(){
        Components();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Generar Codigo">
    private void Components(){
        jdpeContainer = new JDesktopPane();
        this.add(jdpeContainer);
        jcbnClientes = new JCommandButton("Clientes", getResizableIconFromResource("Imagen/cliente.png"));
        jcbnColores = new JCommandButton("Colores", getResizableIconFromResource("Imagen/categ.png"));
        //jcbnCompras = new JCommandButton("Compras", getResizableIconFromResource("Imagen/compra.png"));
        jcbnIngresos = new JCommandButton("Ingresos", getResizableIconFromResource("Imagen/ingreso.png"));
        jcbnEgresos = new JCommandButton("Egresos", getResizableIconFromResource("Imagen/egreso.png"));
        jcbnTotalCaja = new JCommandButton("TotalCaja",  getResizableIconFromResource("Imagen/totalcaja.png"));
        jcbnMarcas = new JCommandButton("Marcas", getResizableIconFromResource("Imagen/marca.png"));
        jcbnTiposServicio = new JCommandButton("Tipos de Servicio", getResizableIconFromResource("Imagen/unit.png"));
        jcbnProductos = new JCommandButton("Productos", getResizableIconFromResource("Imagen/producto.png"));
        jcbnProveedores = new JCommandButton("Parametros", getResizableIconFromResource("Imagen/proveedores.png"));
        jcbnCaracteristicas = new JCommandButton("Caracteristicas", getResizableIconFromResource("Imagen/compra1.png"));
        jcbnUsuarios = new JCommandButton("Usuarios", getResizableIconFromResource("Imagen/user.png"));
        jcbnVentas = new JCommandButton("Ventas", getResizableIconFromResource("Imagen/venta1.png"));
        //jcbnComprasR = new JCommandButton("Compras", getResizableIconFromResource("Imagen/compra1.png"));
        jcbnVentasR = new JCommandButton("Servicio", getResizableIconFromResource("Imagen/venta.png"));
        jcbnStock = new JCommandButton("Productos",  getResizableIconFromResource("Imagen/producto2.png"));
        jcbnCierreCaja = new JCommandButton("Cierre de Caja", getResizableIconFromResource("Imagen/to.png"));
//        jcbnAnularCompra = new JCommandButton("Anular Compra", getResizableIconFromResource("Imagen/cancelarventa.png"));
        jcbnAnularVenta = new JCommandButton("Anular Venta", getResizableIconFromResource("Imagen/venta.png"));
        jcbnAcerca = new JCommandMenuButton(null, getResizableIconFromResource("Imagen/acerca.png"));
        jcbnVentasPendientes = new JCommandMenuButton("Entrega", getResizableIconFromResource("Imagen/acerca.png"));
        jcbnBackup = new JCommandMenuButton("Backup", getResizableIconFromResource("Imagen/venta.png"));
        jcbnRestauraBackup = new JCommandMenuButton("Restaurar", getResizableIconFromResource("Imagen/venta.png"));
        
        band1 = new JRibbonBand("Registros", null);
        band2 = new JRibbonBand("Articulos", null);
        band3 = new JRibbonBand("Sevicio y Entrega", null);
        band4 = new JRibbonBand("Acciones de Caja", null);
        band5 = new JRibbonBand("Ventas", null);
        band6 = new JRibbonBand("User", null);
        band7 = new JRibbonBand("Anular", null);
        band8 = new JRibbonBand("Caja y Otros...", null);
        band9 = new JRibbonBand("Backup", null);
        
        band1.setResizePolicies((List) Arrays.asList(new IconRibbonBandResizePolicy(band1.getControlPanel())));
        band2.setResizePolicies((List) Arrays.asList(new IconRibbonBandResizePolicy(band2.getControlPanel())));
        band3.setResizePolicies((List) Arrays.asList(new IconRibbonBandResizePolicy(band3.getControlPanel())));
        band4.setResizePolicies((List) Arrays.asList(new IconRibbonBandResizePolicy(band4.getControlPanel())));
        band5.setResizePolicies((List) Arrays.asList(new IconRibbonBandResizePolicy(band5.getControlPanel())));
        band6.setResizePolicies((List) Arrays.asList(new IconRibbonBandResizePolicy(band6.getControlPanel())));
        band7.setResizePolicies((List) Arrays.asList(new IconRibbonBandResizePolicy(band7.getControlPanel())));
        band8.setResizePolicies((List) Arrays.asList(new IconRibbonBandResizePolicy(band8.getControlPanel())));
        band9.setResizePolicies((List) Arrays.asList(new IconRibbonBandResizePolicy(band9.getControlPanel())));
        
        this.setTitle("::::>>>> ** Sistema de Compras y Ventas **<<<<::::");
        jdpeContainer.setBounds(0, 100, 400, 500);
        
        //<editor-fold defaultstate="collapsed" desc="JRibbonBand1">
        jcbnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnClientesActionPerformed(evt);
            }
        });
        
        jcbnProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnProveedoresActionPerformed(evt);
            }
        });
        band1.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.None(band1.getControlPanel()),
                new IconRibbonBandResizePolicy(band1.getControlPanel())));
        band1.addCommandButton(jcbnClientes, RibbonElementPriority.TOP);
        band1.addCommandButton(jcbnProveedores, RibbonElementPriority.MEDIUM);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="JRibbonBand2">
        
        jcbnProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnProductosActionPerformed(evt);
            }
        });
        jcbnMarcas.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnMarcasActionPerformed(evt);
            }
        });
        jcbnTiposServicio.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnTipoServicioActionPerformed(evt);
            }
        });
        jcbnColores.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnColoresActionPerformed(evt);
            }
        });
        
        jcbnCaracteristicas.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnCarateristicasActionPerformed(evt);
            }
        });
        
        band2.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.None(band2.getControlPanel()),
                new IconRibbonBandResizePolicy(band2.getControlPanel())));
        band2.addCommandButton(jcbnProductos, RibbonElementPriority.TOP);
        band2.addCommandButton(jcbnMarcas, RibbonElementPriority.MEDIUM);
        band2.addCommandButton(jcbnTiposServicio, RibbonElementPriority.MEDIUM);
        band2.addCommandButton(jcbnColores, RibbonElementPriority.MEDIUM);
        band2.addCommandButton(jcbnCaracteristicas, RibbonElementPriority.MEDIUM);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="JRibbonBand3">
        
//        jcbnCompras.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jcbnComprasActionPerformed(evt);
//            }
//        });
        jcbnVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               jcbnVentasActionPerformed(evt);
            }
        });
        jcbnVentasPendientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               jcbnVentasPendientesActionPerformed(evt);
            }
        });
        band3.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.None(band3.getControlPanel()),
                new IconRibbonBandResizePolicy(band3.getControlPanel())));
        band3.addCommandButton(jcbnVentas, RibbonElementPriority.MEDIUM);
        band3.addCommandButton(jcbnVentasPendientes, RibbonElementPriority.MEDIUM);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="JRibbonBand4">
        
        jcbnIngresos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnIngresosActionPerformed(evt);
            }
        });
        
         jcbnEgresos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnEgresosActionPerformed(evt);
            }
        });
         
          jcbnTotalCaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnTotalCajaActionPerformed(evt);
            }
        });
          
        band4.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.None(band4.getControlPanel()),
                new IconRibbonBandResizePolicy(band4.getControlPanel())));
        band4.addCommandButton(jcbnIngresos, RibbonElementPriority.TOP);
        band4.addCommandButton(jcbnEgresos, RibbonElementPriority.TOP);
        band4.addCommandButton(jcbnTotalCaja, RibbonElementPriority.MEDIUM);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="JRibbonBand5">
        
//        jcbnComprasR.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jcbnComprasRActionPerformed(evt);
//            }
//        });
        
        jcbnVentasR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnVentasRActionPerformed(evt);
            }
        });
        
         band5.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.None(band5.getControlPanel()),
                new IconRibbonBandResizePolicy(band5.getControlPanel())));
         band5.addCommandButton(jcbnVentasR, RibbonElementPriority.TOP);
        //</editor-fold>    

        //<editor-fold defaultstate="collapsed" desc="JRibbonBand6">
        
         jcbnUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnUsuariosActionPerformed(evt);
            }
        });
         
         band6.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.None(band6.getControlPanel()),
                new IconRibbonBandResizePolicy(band6.getControlPanel())));
         band6.addCommandButton(jcbnUsuarios, RibbonElementPriority.TOP);
        //</editor-fold>
         
        //<editor-fold defaultstate="collapsed" desc="JRibbonBand7">
        
//         jcbnAnularCompra.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jcbnAnularComprasActionPerformed(evt);
//            }
//        });
         
         jcbnAnularVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnAnularVentasActionPerformed(evt);
            }
        });
         band7.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.None(band7.getControlPanel()),
                new IconRibbonBandResizePolicy(band7.getControlPanel())));
         band7.addCommandButton(jcbnAnularVenta, RibbonElementPriority.TOP);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="JRibbonBand8">
        
       jcbnStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnStockActionPerformed(evt);
            }
        });
        
        jcbnCierreCaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              jcbnTotalCajaActionPerformed(evt);
            }
        });
        
         band8.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.None(band8.getControlPanel()),
                new IconRibbonBandResizePolicy(band8.getControlPanel())));
         band8.addCommandButton(jcbnStock, RibbonElementPriority.TOP);
         band8.addCommandButton(jcbnCierreCaja, RibbonElementPriority.TOP);
        //</editor-fold>
        
         
         //<editor-fold defaultstate="collapsed" desc="JRibbonBand9">
        
       jcbnBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnBackupActionPerformed(evt);
            }
        });
        
        jcbnRestauraBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              jcbnRestauraBackupActionPerformed(evt);
            }
        });
        
         band9.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.None(band9.getControlPanel()),
                new IconRibbonBandResizePolicy(band9.getControlPanel())));
         band9.addCommandButton(jcbnBackup, RibbonElementPriority.TOP);
         band9.addCommandButton(jcbnRestauraBackup, RibbonElementPriority.MEDIUM);
        //</editor-fold>
         
        //<editor-fold defaultstate="collapsed" desc="Acerca de">
         jcbnAcerca.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(java.awt.event.ActionEvent evt) {
               jcbnAcercaActionPerformed(evt);
             }
         });
        getRibbon().addTaskbarComponent(jcbnAcerca);    
        getRibbon().addTaskbarComponent(new JLabel("About"));
         //</editor-fold>
        
        RibbonTask task1 = new RibbonTask("Mantenimientos y Busqueda", band1, band2);
        RibbonTask task2 = new RibbonTask("Operaciones", band3, band4);
        RibbonTask task3 = new RibbonTask("Consultas y Reportes", band5,band8);
        RibbonTask task4 = new RibbonTask("Seguridad", band6,band9);
        RibbonTask task5 = new RibbonTask("Anulaciones", band7);

        
        this.addWindowListener(new WindowListener() {
            
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                JIConsultaProductos2 v = new JIConsultaProductos2();
                try {
                    if (esta == true) {
                        FormDS.FormControlCenter(v, jdpeContainer);
                        jcbnRestauraBackup.setEnabled(false);
                        if (admin == false) {
//                            jcbnAnularCompra.setEnabled(false);
                            jcbnAnularVenta.setEnabled(false);
//                            jcbnCategorias.setEnabled(false);
                            jcbnCierreCaja.setEnabled(false);
//                            jcbnClientes.setEnabled(false);
//                            jcbnCompras.setEnabled(false);
//                            jcbnComprasR.setEnabled(false);
                            jcbnIngresos.setEnabled(false);
                            jcbnEgresos.setEnabled(false);
                            jcbnMarcas.setEnabled(false);
                            jcbnTiposServicio.setEnabled(false);
                            jcbnProductos.setEnabled(false);
                            jcbnProveedores.setEnabled(false);
                            jcbnStock.setEnabled(false);
                            jcbnTotalCaja.setEnabled(false);
//                            jcbnUnidadMedida.setEnabled(false);
                            jcbnUsuarios.setEnabled(false);
//                            jcbnVentas.setEnabled(false);
//                            jcbnVentasR.setEnabled(false);
//                            jcbnVentasPendientes.setEnabled(false);
                        }
                        esta = false;
                    }
//                    JLabel use = new JLabel(user);
                } catch (Exception ex) {
                }
            }
            
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                System.exit(0);
            }
            
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                
            }
            
            @Override
            public void windowIconified(java.awt.event.WindowEvent evt) {
                
            }
            
            @Override
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                
            }
            
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                
            }
            
            @Override
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                
            }
        });
        
        this.getRibbon().addTask(task1);
        this.getRibbon().addTask(task2);
        this.getRibbon().addTask(task5);
        this.getRibbon().addTask(task3);
        this.getRibbon().addTask(task4);
        this.getRibbon().setApplicationMenu(new RibbonApplicationMenu());
        this.getRibbon().setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setBounds(0,0,800,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    //</editor-fold>
    
    
    private void jcbnClientesActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIClientes clientes = new JIClientes();
            FormDS.FormControlCenter(clientes, jdpeContainer);
        } catch (Exception e) {
        }
    }
    private void jcbnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIParametros proveedores = new JIParametros();
            FormDS.FormControlCenter(proveedores, jdpeContainer);
        } catch (Exception exception) {
            
        }
    }
    private void jcbnCarateristicasActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JICaracteristicas v = new JICaracteristicas();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    
    private void jcbnMarcasActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIMarcas v = new JIMarcas();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    private void jcbnTipoServicioActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JITiposServicio v = new JITiposServicio();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    private void jcbnAcercaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIAcerca v = new JIAcerca();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    private void jcbnColoresActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIColores v = new JIColores();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    
    private void jcbnProductosActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIProductos v = new JIProductos();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    
    private void jcbnVentasActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIVentas v = new JIVentas();
            FormDS.FormControlCenter(v, jdpeContainer);
            v.setMaximum(true);     
        } catch (Exception e) {
        }
    }
    private void jcbnVentasPendientesActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIListaVentasPendientes v= new JIListaVentasPendientes();
            FormDS.FormControlCenter(v, jdpeContainer);
//            v.setMaximum(true);     
        } catch (Exception e) {
        }
    }
    private void jcbnComprasActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JICompras v = new JICompras();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    
    private void jcbnIngresosActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIIngresos v = new JIIngresos();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    
    private void jcbnEgresosActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIEgresos v = new JIEgresos();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    
    private void jcbnTotalCajaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JITotalCaja v = new JITotalCaja();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    
    private void jcbnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIUsuarios v = new JIUsuarios();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
    
     private void jcbnComprasRActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIConsultaCompras v = new JIConsultaCompras();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
    }
     
      private void jcbnVentasRActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIConsultaVentas v = new JIConsultaVentas();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
      }
      private void jcbnStockActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIConsultaProductos v = new JIConsultaProductos();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
      }

      private void jcbnAnularComprasActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIAnularCompras v = new JIAnularCompras();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
      }
    
      private void jcbnAnularVentasActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIAnularVentas v = new JIAnularVentas();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
      }
      private void jcbnBackupActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIBackup v = new JIBackup();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
      }
      private void jcbnRestauraBackupActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JIRestauraBackup v = new JIRestauraBackup();
            FormDS.FormControlCenter(v, jdpeContainer);
        } catch (Exception e) {
        }
      }
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
            java.util.logging.Logger.getLogger(JRibbonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JRibbonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JRibbonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JRibbonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JRibbonForm frame = new JRibbonForm();
                SubstanceLookAndFeel.setSkin(new BusinessSkin());
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
    }
    
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnClientes;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnColores;
//private org.pushingpixels.flamingo.api.common.JCommandButton jcbnCompras;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnEgresos;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnIngresos;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnTotalCaja;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnMarcas;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnTiposServicio;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnProductos;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnProveedores;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnCaracteristicas; 
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnUsuarios; 
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnVentas;
//private org.pushingpixels.flamingo.api.common.JCommandButton jcbnComprasR;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnVentasR;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnStock;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnCierreCaja;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnAnularVenta;
//private org.pushingpixels.flamingo.api.common.JCommandButton jcbnAnularCompra;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnAcerca;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnVentasPendientes;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnBackup;
private org.pushingpixels.flamingo.api.common.JCommandButton jcbnRestauraBackup;
private org.pushingpixels.flamingo.api.ribbon.JRibbonBand band1;
private org.pushingpixels.flamingo.api.ribbon.JRibbonBand band2;
private org.pushingpixels.flamingo.api.ribbon.JRibbonBand band3;
private org.pushingpixels.flamingo.api.ribbon.JRibbonBand band4;
private org.pushingpixels.flamingo.api.ribbon.JRibbonBand band5;
private org.pushingpixels.flamingo.api.ribbon.JRibbonBand band6;
private org.pushingpixels.flamingo.api.ribbon.JRibbonBand band7;
private org.pushingpixels.flamingo.api.ribbon.JRibbonBand band8;
private org.pushingpixels.flamingo.api.ribbon.JRibbonBand band9;
private javax.swing.JDesktopPane jdpeContainer;
 private ResizableIcon getResizableIconFromResource(String resource) {
        return ImageWrapperResizableIcon.getIcon(JRibbonForm.class.getClassLoader().getResource(resource), new Dimension(48, 48));
    }
     
}
