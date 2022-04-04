/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacionelectronica;

//import accesodatos.ConfiguracionADN;
import Adicional.Util;
import accesodatos.ParametrosADN;
import entidades.ConsultaVentas;
import entidades.ConsultaVentas2;
import entidades.Detalle_Venta;
import entidades.Formatos;
import facturacionelectronica.util.Constantes;
import java.lang.reflect.Field;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObjectBuilder;
//import org.json.JSONException;
//import org.json.JSONObject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import org.json.JSONObject;

/**
 *
 * @author EDWARD
 */
public class EnvioPSE {

    private static String TOKENSTR = "";

    public String paramToJson(ConsultaVentas2 datosVenta, List<ConsultaVentas2> det) {
        try {
            Cabecera servicio = new Cabecera();
            String tipoDocSunat = datosVenta.getTipoDoc().getValue();
            servicio.setTipo(tipoDocSunat);
            servicio.setSerie(datosVenta.getSerieDocE());
            servicio.setNumero(String.valueOf(datosVenta.getNumDocE()));
            servicio.setForma_pago("Contado");
            servicio.setFecha_emision(Util.sdfFecha2.format(datosVenta.getFecha()));
            servicio.setFecha_vencimiento(null);
            servicio.setTipo_operacion(Constantes.TIPO_OPERACION_WS);
            servicio.setCliente_tipo(datosVenta.getTipoCliente().split("-")[0]);
            servicio.setCliente_documento(datosVenta.getDniCliente());
            servicio.setCliente_nombre(datosVenta.getCliente());
            servicio.setCliente_direccion(datosVenta.getDireccionCliente());
            servicio.setCliente_email(datosVenta.getCorreoCliente());
            servicio.setCliente_telefono(null);
            servicio.setVendedor_nombre("admin");
            servicio.setObservaciones(null);
            servicio.setPlaca_vehiculo(null);
            servicio.setOrden_compra(null);
            servicio.setGuia_remision(null);
            servicio.setDescuento_global_porcentaje(Formatos.df.format(datosVenta.getDescuento()));
            servicio.setMoneda(Constantes.MONEDA);
            servicio.setNota_tipo(null);
            servicio.setNota_motivo(null);
            servicio.setNota_referencia_tipo(null);
            servicio.setNota_referencia_serie(null);
            servicio.setNota_referencia_numero(null);
//            servicio.setIncluir_pdf(ConfiguracionADN.Datos().get(0).getFlagPDF().equals("1")?"true":"false");
//            servicio.setIncluir_xml(ConfiguracionADN.Datos().get(0).getFlagXML().equals("1")?"true":"false");
            List<Detalle> listaItemsEnvio = new ArrayList<Detalle>();
            int count = 0;
            for (ConsultaVentas2 detalleVenta : det) {
                Detalle items = new Detalle();
                items.setCodigo(detalleVenta.getCodigo());
                items.setDescripcion(detalleVenta.getProducto());
                items.setDetalle_adicional(null);
                items.setUnidad_medida(Constantes.DESCRIPCION_UNIDAD);
                items.setCantidad(String.valueOf(detalleVenta.getCantidad()));
                items.setPrecio_unitario(Formatos.df.format(detalleVenta.getPrecio()));
                items.setDescuento_porcentaje(Formatos.df.format(detalleVenta.getDescuento()));
                items.setTipo_igv(datosVenta.getTipoIGV());
                items.setAfectacion_igv(String.valueOf(detalleVenta.getAfectacion_igv()));
                listaItemsEnvio.add(items);
                count++;
            }
            
            servicio.setLista(listaItemsEnvio);
            
            String jsonBody;
            try {
                jsonBody = servicio.toJson(servicio);
                return jsonBody;
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(EnvioPSE.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            } catch (IllegalAccessException ex) {
                Logger.getLogger(EnvioPSE.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            }
        } catch (Exception ex) {
            Logger.getLogger(EnvioPSE.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }


    }

    public RespuestaPSE envioJsonPSE(String jsonBody) {
        boolean result = false;
        RespuestaPSE respuesta = null;
        
        try {
            String requestUrl = ParametrosADN.Lista().get(0).getRutaPse();
            TOKENSTR = ParametrosADN.Lista().get(0).getToken();
            String webService = requestUrl;
            URL url = new URL(webService);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", TOKENSTR);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();

            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            writer.write(jsonBody);
            writer.close();

            BufferedReader br = null;
            if (conn.getResponseCode() == 200 || conn.getResponseCode() == 201) {
                br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                result = true;
            } else {
                br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
                result = false;
            }
            String output, jsonString = "";
            System.out.println("output is-----------------");

            while ((output = br.readLine()) != null) {
                System.out.println(output);
                jsonString = jsonString + output;
            }
            respuesta = new RespuestaPSE(jsonString, result);

            return respuesta;
        } catch (IOException e) {
            System.out.println(Util.exceptionToString(e));
            e.printStackTrace();
            return respuesta;
        } catch (Exception e) {
            System.out.println(Util.exceptionToString(e));
            e.printStackTrace();
            return respuesta;
        }
    }
}
