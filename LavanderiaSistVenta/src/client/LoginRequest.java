/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import facturacionelectronica.Cabecera;
import facturacionelectronica.Cuotas;
import facturacionelectronica.Detalle;
import facturacionelectronica.Tributo;
import java.lang.reflect.Field;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author user
 */
public class LoginRequest {
    String username;
    String password;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toJson(LoginRequest c) throws IllegalArgumentException, IllegalAccessException {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        for (Field f : c.getClass().getDeclaredFields()) {
            if (f.get(c) == null || f.getName().equals("lista")) {
                continue;
            }
            System.out.println(f.getGenericType() + " " + f.getName() + " = " + f.get(c));
            objectBuilder.add(f.getName(), f.get(c).toString());
        }

        JsonArrayBuilder objectBuilderDetail = Json.createArrayBuilder();
        JsonArrayBuilder objectBuilderDetail2 = Json.createArrayBuilder();
        JsonArrayBuilder objectBuilderDetail3 = Json.createArrayBuilder();
//        for (Detalle items : lista) {
//            objectBuilderDetail.add(items.toJson(items));
//        }
//        for (Tributo items : listaTax) {
//            objectBuilderDetail2.add(items.toJson(items));
//        }
//        for (Cuotas items : listaCuotas) {
//            objectBuilderDetail3.add(items.toJson(items));
//        }
        JsonArray objectDetail = objectBuilderDetail.build();
        JsonArray objectDetail2 = objectBuilderDetail2.build();
        JsonArray objectDetail3 = objectBuilderDetail3.build();
//        objectBuilder.add("lista_productos", objectDetail);
//        objectBuilder.add("lista_tributos", objectDetail2);
//        objectBuilder.add("lista_cuotas", objectDetail3);
        JsonObject object = objectBuilder.build();
        return object.toString();
    }
}
