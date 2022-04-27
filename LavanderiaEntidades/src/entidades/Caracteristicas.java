/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author PRINCIP
 */
public class Caracteristicas {
    private int IdCaracteristica;
    private String nombre;
    private String estado;

    //<editor-fold defaultstate="collapsed" desc="Getter y Setter">
    public int getIdCaracteristicas() {
        return IdCaracteristica;
    }
    
    public void setIdCaracteristicas(int IdCaracteristicas) {
        this.IdCaracteristica = IdCaracteristicas;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Caracteristicas() {
    }

    public Caracteristicas(String nombre) {
        this.nombre = nombre;
    }
    
    public Caracteristicas(int IdCaracteristicas, String nombre, String estado) {
        this.IdCaracteristica = IdCaracteristicas;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Caracteristicas(int IdCaracteristica, String nombre) {
        this.IdCaracteristica = IdCaracteristica;
        this.nombre = nombre;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[3];
        aux[0] = String.valueOf(IdCaracteristica);
        aux[1] = nombre;
        aux[2] = estado;
        return aux;
    }
}

     
