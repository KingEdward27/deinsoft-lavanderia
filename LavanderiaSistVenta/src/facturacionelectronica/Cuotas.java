/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacionelectronica;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author EDWARD-PC
 */
public class Cuotas implements Serializable {

    private static final long serialVersionUID = 1L;

    private String monto_pago;
    
    private String tipo_moneda_pago;
    
    private String fecha_pago;

    public Cuotas() {
    }

    public String getMonto_pago() {
        return monto_pago;
    }

    public void setMonto_pago(String monto_pago) {
        this.monto_pago = monto_pago;
    }

    public String getTipo_moneda_pago() {
        return tipo_moneda_pago;
    }

    public void setTipo_moneda_pago(String tipo_moneda_pago) {
        this.tipo_moneda_pago = tipo_moneda_pago;
    }

    

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

   
    
    public JsonObject toJson(Cuotas detail) {
        JsonObject object = null;
        try {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            for (Field f : detail.getClass().getDeclaredFields()) {
                if (f.get(detail) == null) {
                    continue;
                }
                System.out.println(f.getGenericType() + " " + f.getName() + " = " + f.get(detail));
                objectBuilder.add(f.getName(), f.get(detail).toString());
            }

            object = objectBuilder.build();

        } catch (Exception e) {
            System.out.println("error inesperado: " + e.toString());
        }
        return object;
    }
    
}
