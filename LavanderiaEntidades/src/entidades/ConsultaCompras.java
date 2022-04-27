/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author EDWARD
 */
public class ConsultaCompras {
    private int idcompra;
    private String nro,razoosocial;
    private Date fecha;
    private float total;

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }
    
    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getRazoosocial() {
        return razoosocial;
    }

    public void setRazoosocial(String razoosocial) {
        this.razoosocial = razoosocial;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ConsultaCompras() {
    }

    public ConsultaCompras(int idcompra, String nro, String razoosocial, Date fecha, float total) {
        this.idcompra = idcompra;
        this.nro = nro;
        this.razoosocial = razoosocial;
        this.fecha = fecha;
        this.total = total;
    }

    public ConsultaCompras(String nro, String razoosocial, Date fecha, float total) {
        this.nro = nro;
        this.razoosocial = razoosocial;
        this.fecha = fecha;
        this.total = total;
    }
    public String[] ArregloDatos(){
        String[] aux = new String[4];
        aux[0] = nro;
        aux[1] = razoosocial;
        aux[2] = Formatos.sdfFecha.format(fecha);
        aux[3] = Formatos.df.format(total);
        return aux;
    }
    public String[] ArregloDatos2(){
        String[] aux = new String[5];
        aux[0] = String.valueOf(idcompra);
        aux[1] = nro;
        aux[2] = razoosocial;
        aux[3] = Formatos.sdfFecha.format(fecha);
        aux[4] = Formatos.df.format(total);
        return aux;
    }
}
