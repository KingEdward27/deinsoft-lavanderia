package Adicional;

import entidades.Formatos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.commons.codec.binary.Base64;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDWARD
 */
public class Util {
    
    public static void ModificarTamañoJtable(JTable jtable, int indice,int tamano)
    {
        jtable.getColumnModel().getColumn(indice).setMaxWidth(tamano);
        jtable.getColumnModel().getColumn(indice).setMinWidth(tamano);
        jtable.getColumnModel().getColumn(indice).setPreferredWidth(tamano);
    }
    public static void OcultarColumnaJtable(JTable jtable, int indice)
    {
        jtable.getColumnModel().getColumn(indice).setMaxWidth(0);
        jtable.getColumnModel().getColumn(indice).setMinWidth(0);
        jtable.getColumnModel().getColumn(indice).setPreferredWidth(0);
    }
    public static void AlinearDerecha(JTable jtable, int indice)
    {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        jtable.getColumnModel().getColumn(indice).setCellRenderer(tcr);
    }
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    public static SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat sdfFecha2 = new SimpleDateFormat("MM/dd/yyyy");
    public static SimpleDateFormat sdfFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static SimpleDateFormat sdfFecha3 = new SimpleDateFormat("yyyy-MM-dd");
    public static DecimalFormat df = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US));

    public static java.sql.Date FechaSQL(String fecha)throws ParseException 
    {
        java.util.Date f = Formatos.sdfFecha.parse(fecha);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(f.getTime());
        java.sql.Date f2 = new java.sql.Date(gc.getTimeInMillis());
        return f2;
    }
    public static java.sql.Date HoraSql(String fecha)throws ParseException 
    {
        java.util.Date f = sdfHora.parse(fecha);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(f.getTime());
        java.sql.Date f2 = new java.sql.Date(gc.getTimeInMillis());
        return f2;
    }
    public static void getPDF(String base64PDF,String ruta)
    {
        File file = new File(ruta);

        try ( FileOutputStream fos = new FileOutputStream(file); ) {
          // To be short I use a corrupted PDF string, so make sure to use a valid one if you want to preview the PDF file
          byte[] decoder = Base64.decodeBase64(base64PDF);
          fos.write(decoder);
            System.out.println("archivo guardado: "+ruta);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    public static String exceptionToString(Exception ex){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date1.getTime() - date2.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    
    public static String simpleApiWithJsonBody(String urlParam, String jsonBody,  String httpMethod, String authorization,
             String accept,
             String contentType) {
        boolean result = false;
        System.out.println("jsonBody: " + jsonBody);
        try {
            URL url = new URL(urlParam);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod(httpMethod);
            conn.setRequestProperty("Accept", accept);
            conn.setRequestProperty("Authorization", "Bearer " + authorization);
            conn.setRequestProperty("Content-Type", contentType);
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
            return jsonString;
        } catch (ConnectException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
