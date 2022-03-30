/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author EDWARD-PC
 */
public class TipoDoc {
    private int tipodocId ;
    private String nombre ;
    private String value;
    private String estado;

    public TipoDoc() {
    }

    public TipoDoc(int tipodocId) {
        this.tipodocId = tipodocId;
    }

    public TipoDoc(int tipodocId, String nombre, String value, String estado) {
        this.tipodocId = tipodocId;
        this.nombre = nombre;
        this.value = value;
        this.estado = estado;
    }

    public int getTipodocId() {
        return tipodocId;
    }

    public void setTipodocId(int tipodocId) {
        this.tipodocId = tipodocId;
    }

    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
