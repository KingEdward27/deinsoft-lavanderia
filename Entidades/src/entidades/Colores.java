/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author PRINCIP
 */
public class Colores {
    private int IdColor;
    private String nombre;
    private String estado;

    //<editor-fold defaultstate="collapsed" desc="Getter y Setter">
    public int getIdColors() {
        return IdColor;
    }
    
    public void setIdColors(int IdColors) {
        this.IdColor = IdColors;
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
    public Colores() {
    }

    public Colores(String nombre) {
        this.nombre = nombre;
    }
    
    public Colores(int IdColors, String nombre, String estado) {
        this.IdColor = IdColors;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Colores(int IdColor, String nombre) {
        this.IdColor = IdColor;
        this.nombre = nombre;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[3];
        aux[0] = String.valueOf(IdColor);
        aux[1] = nombre;
        aux[2] = estado;
        return aux;
    }
}

     
