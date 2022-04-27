/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author EDWARD
 */
public class Tipos_Servicio {
    int idtiposervicio;
    String descripcion;
    String estado;

    public int getIdtiposervicio() {
        return idtiposervicio;
    }

    public void setIdtiposervicio(int idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Tipos_Servicio() {
    }

    public Tipos_Servicio(int idtiposervicio, String descripcion, String estado) {
        this.idtiposervicio = idtiposervicio;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    public String[] ArregloDatos(){
        String[] aux = new String[3];
        aux[0] = String.valueOf(idtiposervicio);
        aux[1] = descripcion;
        aux[2] = estado;
        return aux;
    }
    
}
