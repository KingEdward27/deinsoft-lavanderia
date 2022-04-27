/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author PRINCIP
 */
public class Usuarios {
    private int IdUsuarios;
    private String nombre;
    private String clave;
    private String tipo;
    private String estado;

    //<editor-fold defaultstate="collapsed" desc="GETTER Y SETTER">
    public int getIdUsuarios() {
        return IdUsuarios;
    }
    
    public void setIdUsuarios(int IdUsuarios) {
        this.IdUsuarios = IdUsuarios;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Usuarios() {
    }

    public Usuarios(int IdUsuarios, String nombre) {
        this.IdUsuarios = IdUsuarios;
        this.nombre = nombre;
    }

    public Usuarios(int IdUsuarios, String clave, String estado) {
        this.IdUsuarios = IdUsuarios;
        this.clave = clave;
        this.estado = estado;
    }
    
    public Usuarios(int IdUsuarios, String nombre, String clave, String tipo, String estado) {
        this.IdUsuarios = IdUsuarios;
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[5];
        aux[0] = String.valueOf(IdUsuarios);
        aux[1] = nombre;
        aux[2] = clave;
        aux[3] = tipo;
        aux[4] = estado;
        
        return aux;
    }
}
//</editor-fold>
