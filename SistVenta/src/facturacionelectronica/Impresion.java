/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacionelectronica;

import Adicional.Util;
//import accesodatos.ConfiguracionADN;
import entidades.ConsultaVentas;
import entidades.ConsultaVentas2;
//import entidades.Empresa;
import entidades.Formatos;
import entidades.Parametros;
import facturacionelectronica.util.Constantes;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
//import sistventa.JDVisor;
//import static sistventa.JIVentas.round;

/**
 *
 * @author EDWARD
 */
public class Impresion {

    public static final float IGV = 0.18f;
    public static final String UNIDAD_MEDIDA = "ZZ";
    public static String Imprimir(int tipo, List<Parametros> datosEmpresa, 
            ConsultaVentas2 datosVenta, 
            List<ConsultaVentas2> datosVentaDetalle) {
        try {
            JasperReport reporte = null;
            String ubicacion = "";
            if (tipo == 1) {
                ubicacion = "/jasper/boleta.jasper";
            }else
            {
                ubicacion = "/jasper/ticket.jasper";
            }
            String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("currentPath + ubicacion: "+currentPath + ubicacion);
            File archivo = new File(currentPath + ubicacion);
            InputStream targetStream = new FileInputStream(archivo);
            reporte = (JasperReport) JRLoader.loadObject(targetStream);
            Map parametros;
            parametros = new HashMap<String, Object>();

            float subTotal = Util.round(datosVenta.getVentatotal() / (IGV+ 1), 2);
            float igvTotal = Util.round(datosVenta.getVentatotal() - subTotal, 2);
            parametros.put("tipodoc", datosVenta.getTipoDoc().getNombre());
            parametros.put("razon_social", datosEmpresa.get(0).getNombre_empresa());
            parametros.put("direccion", datosEmpresa.get(0).getDireccion());
            parametros.put("ruc", datosEmpresa.get(0).getRuc());

            parametros.put("numero", datosVenta.getSerie() + "-" + datosVenta.getNum());
            parametros.put("ruc_dniCliente", datosVenta.getDniCliente());
            parametros.put("nombreCliente", datosVenta.getCliente());
            parametros.put("direccionCliente", datosVenta.getDireccionCliente());
            parametros.put("pFechaEmision", Formatos.sdfFecha.format(datosVenta.getFecha()));
            parametros.put("fechaVencimiento", "");
            parametros.put("moneda", "SOLES");

            parametros.put("pdescuento2",Formatos.df.format( datosVenta.getDescuento()));
            parametros.put("pgravado", Formatos.df.format(subTotal));
            parametros.put("pigv",Formatos.df.format( igvTotal));
            parametros.put("ptotal", Formatos.df.format(datosVenta.getVentatotal()));
            parametros.put("ptotal_letras", "SON "+ datosVenta.getDescripcionMonto());

            parametros.put("pusuario_fecha", "admin el " + Formatos.sdfFecha.format(datosVenta.getFecha()));
            parametros.put("presolucion", "Autorizado mediantes resolución N° "+ Constantes.RESOLUCION);
            parametros.put("tipoDocFooter", "Representación impresa de la "+ datosVenta.getTipoDoc());
            parametros.put("ppagina","Para consultar el comprobante visita "+ Constantes.PAGINA_WEB);
            parametros.put("presumen", datosVenta.getXmlHash());
            parametros.put("idTipoDoc", datosVenta.getTipoDoc().getValue());
            parametros.put("psummary", "NOTA: Una vez retirada la prenda no hay lugar a reclamo. "
                                            + "Pasado 30 dias de no retirar su ropa esta sera rematada "
                                            + "para recuperar los gastos del servicio dado."
                                            + "Prendas gastadas que no soporten el lavado seran "
                                            + "responsabilidad del cliente. En este caso la lavenderia "
                                            + "no se responsabiliza");
            if (tipo != 2) {
                if (!datosVenta.getTipoDoc().getValue().equals(Constantes.TIPO_DOC_TICKET)) {
                    String pathResult = CodigoQR.GenerarQR(datosVenta.getCodigoQR());
                    if (!pathResult.equals("")) {
                        parametros.put("rutaimagen", pathResult);
                    }
                }
            }
            
            
            List<Map<String, String>> listaBean = new ArrayList();
            Integer count = 0;
            for (ConsultaVentas2 item : datosVentaDetalle) {
                ++count;
                Map<String, String> beanMap = new HashMap<>();
                float subtotalDet = Util.round(item.getPrecio() / (IGV + 1), 2);
                float igv = Util.round(item.getPrecio() - subtotalDet, 2);
                beanMap.put("nro", count.toString());
                beanMap.put("cantidad", Formatos.df.format(item.getCantidad()));
                beanMap.put("um", UNIDAD_MEDIDA);
                beanMap.put("codigo", item.getCodigo());
                beanMap.put("descripcion", item.getProducto());
                beanMap.put("vu", Formatos.df.format(subtotalDet));
                beanMap.put("pu", Formatos.df.format(item.getPrecio()));
                beanMap.put("igv", Formatos.df.format(igv));
                beanMap.put("descuento", Formatos.df.format(item.getDescuento()));
                beanMap.put("importe", Formatos.df.format(item.getImporte()));

                listaBean.add(beanMap);
            }
            if (count < 20 && tipo == 1) {
                if (count >= 15 && count < 20) {
                    for (int i = 0; i < 2; i++) {
                        Map<String, String> beanMap = new HashMap<>();
                        String empty = "";
                        beanMap.put("nro",empty);
                        beanMap.put("cantidad", empty);
                        beanMap.put("um", empty);
                        beanMap.put("codigo", empty);
                        beanMap.put("descripcion",empty);
                        beanMap.put("vu", empty);
                        beanMap.put("pu", empty);
                        beanMap.put("igv", empty);
                        beanMap.put("descuento", empty);
                        beanMap.put("importe",empty);
                        listaBean.add(beanMap);
                    }
                    
                }else if(count >= 10 && count < 15)
                {
                    for (int i = 0; i < 5; i++) {
                        Map<String, String> beanMap = new HashMap<>();
                        String empty = "";
                        beanMap.put("nro",empty);
                        beanMap.put("cantidad", empty);
                        beanMap.put("um", empty);
                        beanMap.put("codigo", empty);
                        beanMap.put("descripcion",empty);
                        beanMap.put("vu", empty);
                        beanMap.put("pu", empty);
                        beanMap.put("igv", empty);
                        beanMap.put("descuento", empty);
                        beanMap.put("importe",empty);
                        listaBean.add(beanMap);
                    }
                }else if(count >= 5 && count < 10)
                {
                    for (int i = 0; i < 5; i++) {
                        Map<String, String> beanMap = new HashMap<>();
                        String empty = "";
                        beanMap.put("nro",empty);
                        beanMap.put("cantidad", empty);
                        beanMap.put("um", empty);
                        beanMap.put("codigo", empty);
                        beanMap.put("descripcion",empty);
                        beanMap.put("vu", empty);
                        beanMap.put("pu", empty);
                        beanMap.put("igv", empty);
                        beanMap.put("descuento", empty);
                        beanMap.put("importe",empty);
                        listaBean.add(beanMap);
                    }
                }else if(count < 5)
                {
                    for (int i = 0; i < 10; i++) {
                        Map<String, String> beanMap = new HashMap<>();
                        String empty = "";
                        beanMap.put("nro",empty);
                        beanMap.put("cantidad", empty);
                        beanMap.put("um", empty);
                        beanMap.put("codigo", empty);
                        beanMap.put("descripcion",empty);
                        beanMap.put("vu", empty);
                        beanMap.put("pu", empty);
                        beanMap.put("igv", empty);
                        beanMap.put("descuento", empty);
                        beanMap.put("importe",empty);
                        listaBean.add(beanMap);
                    }
                }
            }
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaBean));
            JasperViewer visor = new JasperViewer(print,false);
            
            JDVisor dialog = new JDVisor(null, true);//the owner
            dialog.setContentPane(visor.getContentPane());
            dialog.setSize(visor.getSize());
            dialog.setTitle("Visor");
//            dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(
//            getClass().getResource("URL IMG")));
            dialog.setVisible(true);
            
//            visor.setTitle("Impresión de documento");
//            visor.setVisible(true);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }
}
