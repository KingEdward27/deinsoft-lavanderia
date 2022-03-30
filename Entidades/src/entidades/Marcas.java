/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author PRINCIP
 */
public class Marcas {
    private int IdMarca;
    private String nombre;
    private String estado;

    //<editor-fold defaultstate="collapsed" desc="Getter y Setter">
    public int getIdMarcas() {
        return IdMarca;
    }
    
    public void setIdMarcas(int IdMarcas) {
        this.IdMarca = IdMarcas;
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
    public Marcas() {
    }

    public Marcas(String nombre) {
        this.nombre = nombre;
    }
    
    public Marcas(int IdMarcas, String nombre, String estado) {
        this.IdMarca = IdMarcas;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Marcas(int IdMarca, String nombre) {
        this.IdMarca = IdMarca;
        this.nombre = nombre;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[3];
        aux[0] = String.valueOf(IdMarca);
        aux[1] = nombre;
        aux[2] = estado;
        return aux;
    }
}
//</editor-fold>

     
