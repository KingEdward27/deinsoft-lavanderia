/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacionelectronica;

import Adicional.SystemOutToLog4j;
import Adicional.Util;
import FormInternos.JIVentas;
//import accesodatos.ConfiguracionADN;
import entidades.ConsultaVentas;
import entidades.ConsultaVentas2;
//import entidades.Empresa;
import entidades.Formatos;
import entidades.Parametros;
import facturacionelectronica.util.Constantes;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
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

    static {
        SystemOutToLog4j.enableForClass(Impresion.class);
    }

    public static JasperPrint Imprimir(int tipo, List<Parametros> datosEmpresa,
            ConsultaVentas2 datosVenta,
            List<ConsultaVentas2> datosVentaDetalle, boolean isTicket) {
        try {
            JasperReport reporte = null;
            String ubicacion = "";
            if (tipo == 1) {
                ubicacion = "/jasper/boleta.jasper";
            } else {
                ubicacion = "/jasper/ticket.jasper";
            }
            String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("currentPath + ubicacion: " + currentPath + ubicacion);
            File archivo = new File(currentPath + ubicacion);
            InputStream targetStream = new FileInputStream(archivo);
            reporte = (JasperReport) JRLoader.loadObject(targetStream);
            Map parametros;
            parametros = new HashMap<String, Object>();

//            float subTotal = Util.round(datosVenta.getVentatotal() / (IGV + 1), 2);
//            float igvTotal = Util.round(datosVenta.getVentatotal() - subTotal, 2);
            parametros.put("tipodoc", isTicket ? "TICKET DE ATENCIÓN" : (datosVenta.getTipoDoc().getValue().equals("00") ? datosVenta.getTipoDoc().getNombre() : datosVenta.getTipoDoc().getNombre() + " ELECTRÓNICA"));
            parametros.put("razon_social", datosEmpresa.get(0).getNombre_empresa());
            parametros.put("direccion", datosEmpresa.get(0).getDireccion());
            parametros.put("ruc", datosEmpresa.get(0).getRuc());
            parametros.put("ptelefono", datosEmpresa.get(0).getTelefono());

            parametros.put("numero", isTicket ? datosVenta.getSerie() + "-" + String.format("%08d", Integer.parseInt(datosVenta.getNum())) : datosVenta.getSerieDocE() + "-" + String.format("%08d", datosVenta.getNumDocE()));
            parametros.put("ruc_dniCliente", datosVenta.getDniCliente());
            parametros.put("nombreCliente", datosVenta.getCliente());
            parametros.put("direccionCliente", datosVenta.getDireccionCliente());
            parametros.put("pFechaEmision", Formatos.sdfFecha.format(datosVenta.getFecha()));
            parametros.put("fechaVencimiento", "");
            parametros.put("moneda", "SOLES");

            parametros.put("pdescuento2", Formatos.df.format(datosVenta.getDescuento()));
            parametros.put("pgravado", Formatos.df.format(Util.round(datosVenta.getVentatotal() - datosVenta.getSumatoriaIGV(), 2)));
            parametros.put("pigv", Formatos.df.format(Util.round(datosVenta.getSumatoriaIGV(), 2)));
            parametros.put("ptotal", Formatos.df.format(datosVenta.getVentatotal()));
            parametros.put("ptotal_letras", "SON " + datosVenta.getDescripcionMonto());

            parametros.put("pusuario_fecha", "admin el " + Formatos.sdfFecha.format(datosVenta.getFecha()));
            parametros.put("presolucion", "Autorizado mediantes resolución N° " + Constantes.RESOLUCION);
            parametros.put("tipoDocFooter", "Representación impresa de la " + datosVenta.getTipoDoc());
            parametros.put("ppagina", "Para consultar el comprobante visita " + Constantes.PAGINA_WEB);
            parametros.put("presumen", datosVenta.getXmlHash());
            parametros.put("pACuenta", Formatos.df.format(datosVenta.getAcuenta()));
            parametros.put("pSaldo", Formatos.df.format(isTicket?datosVenta.getVentatotal() - datosVenta.getAcuenta():0));
            parametros.put("pRecibido", Formatos.df.format(datosVenta.getRecibido()));
            parametros.put("pVuelto", Formatos.df.format(datosVenta.getVuelto()));
            parametros.put("pAnticipo", Formatos.df.format(datosVenta.getMontoRef()));
            parametros.put("idTipoDoc", datosVenta.getTipoDoc().getValue()== null? "00":datosVenta.getTipoDoc().getValue());
            parametros.put("isTicket", isTicket);
            parametros.put("psummary", "NOTA: Una vez retirada la prenda no hay lugar a reclamo. "
                    + "Pasado 30 dias de no retirar su ropa esta sera rematada "
                    + "para recuperar los gastos del servicio dado."
                    + "Prendas gastadas que no soporten el lavado seran "
                    + "responsabilidad del cliente. En este caso la lavenderia "
                    + "no se responsabiliza");
            if (!isTicket) {
                String pathResult = CodigoQR.GenerarQR(datosEmpresa.get(0).getRuc() + "|"
                        + datosVenta.getTipoDoc().getValue() + "|"
                        + datosVenta.getSerieDocE() + "-" + datosVenta.getNumDocE() + "|"
                        + String.valueOf(datosVenta.getSumatoriaIGV()) + "|"
                        + String.valueOf(datosVenta.getVentatotal()) + "|"
                        + Util.sdfFecha.format(datosVenta.getFecha()) + "|"
                        + datosVenta.getTipoCliente() + "|"
                        + datosVenta.getDniCliente());
                if (!pathResult.equals("")) {
                    parametros.put("rutaimagen", pathResult);
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
                        beanMap.put("nro", empty);
                        beanMap.put("cantidad", empty);
                        beanMap.put("um", empty);
                        beanMap.put("codigo", empty);
                        beanMap.put("descripcion", empty);
                        beanMap.put("vu", empty);
                        beanMap.put("pu", empty);
                        beanMap.put("igv", empty);
                        beanMap.put("descuento", empty);
                        beanMap.put("importe", empty);
                        listaBean.add(beanMap);
                    }

                } else if (count >= 10 && count < 15) {
                    for (int i = 0; i < 5; i++) {
                        Map<String, String> beanMap = new HashMap<>();
                        String empty = "";
                        beanMap.put("nro", empty);
                        beanMap.put("cantidad", empty);
                        beanMap.put("um", empty);
                        beanMap.put("codigo", empty);
                        beanMap.put("descripcion", empty);
                        beanMap.put("vu", empty);
                        beanMap.put("pu", empty);
                        beanMap.put("igv", empty);
                        beanMap.put("descuento", empty);
                        beanMap.put("importe", empty);
                        listaBean.add(beanMap);
                    }
                } else if (count >= 5 && count < 10) {
                    for (int i = 0; i < 5; i++) {
                        Map<String, String> beanMap = new HashMap<>();
                        String empty = "";
                        beanMap.put("nro", empty);
                        beanMap.put("cantidad", empty);
                        beanMap.put("um", empty);
                        beanMap.put("codigo", empty);
                        beanMap.put("descripcion", empty);
                        beanMap.put("vu", empty);
                        beanMap.put("pu", empty);
                        beanMap.put("igv", empty);
                        beanMap.put("descuento", empty);
                        beanMap.put("importe", empty);
                        listaBean.add(beanMap);
                    }
                } else if (count < 5) {
                    for (int i = 0; i < 10; i++) {
                        Map<String, String> beanMap = new HashMap<>();
                        String empty = "";
                        beanMap.put("nro", empty);
                        beanMap.put("cantidad", empty);
                        beanMap.put("um", empty);
                        beanMap.put("codigo", empty);
                        beanMap.put("descripcion", empty);
                        beanMap.put("vu", empty);
                        beanMap.put("pu", empty);
                        beanMap.put("igv", empty);
                        beanMap.put("descuento", empty);
                        beanMap.put("importe", empty);
                        listaBean.add(beanMap);
                    }
                }
            }
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaBean));
            JasperViewer visor = new JasperViewer(print, false);

//            JDVisor dialog = new JDVisor(null, true);//the owner
//            dialog.setContentPane(visor.getContentPane());
//            dialog.setSize(visor.getSize());
//            dialog.setTitle("Visor");
//            dialog.setVisible(true);
            return print;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(Util.exceptionToString(e));
            return null;
        }

    }

    public static void sendToPrinter(JasperPrint jasper, String printerName) throws JRException {
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        PageFormat pageFormat = PrinterJob.getPrinterJob().defaultPage();
        printerJob.defaultPage(pageFormat);

        int selectedService = 0;
//                                        PrinterName printerName = new PrinterName("Microsoft XPS Document Writer", null); //gets printer 
        javax.print.attribute.AttributeSet attributeSet = new HashPrintServiceAttributeSet(new PrinterName(printerName, null));

        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, attributeSet);

        try {
            printerJob.setPrintService(printService[selectedService]);

        } catch (Exception e) {

            System.out.println(e);
        }
        JRPrintServiceExporter exporter;
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        printRequestAttributeSet.add(MediaSizeName.NA_LETTER);
        printRequestAttributeSet.add(new Copies(1));

        // these are deprecated
        exporter = new JRPrintServiceExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasper);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService[selectedService]);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printService[selectedService].getAttributes());
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
        exporter.exportReport();
    }
}
