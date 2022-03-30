package entidades;

import java.sql.Date;
import java.util.LinkedList;


public class Compras {
    private int IdCompra;
    private int IdProveedor;
    private String Tipodoc;
    private String nro;
    private Date fecha;
    private float igv;
    private float subtotal;
    private float total;
    private String estado;
    private LinkedList<Detalle_Compra> Lista;

    //<editor-fold defaultstate="collapsed" desc="METODOS DE LECTURA Y ESCRITURA">
    public int getIdCompra() {
        return IdCompra;
    }
    
    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }
    
    
    public String getTipodoc() {
        return Tipodoc;
    }
    
    public void setTipodoc(String Tipodoc) {
        this.Tipodoc = Tipodoc;
    }
    
    public String getNro() {
        return nro;
    }
    
    public void setNro(String nro) {
        this.nro = nro;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public float getIgv() {
        return igv;
    }
    
    public void setIgv(float igv) {
        this.igv = igv;
    }
    
    public float getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    public float getTotal() {
        return total;
    }
    
    public void setTotal(float total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LinkedList<Detalle_Compra> getLista() {
        return Lista;
    }

    public void setLista(LinkedList<Detalle_Compra> Lista) {
        this.Lista = Lista;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Compras() {
         Lista = new LinkedList<>();
    }
    
    public Compras(int IdCompra, int IdProveedor, String Tipodoc, String Serie, String nro, Date fecha, float igv, float subtotal, float total,String estado) {
        this.IdCompra = IdCompra;
        this.IdProveedor = IdProveedor;
        this.Tipodoc = Tipodoc;
        this.nro = nro;
        this.fecha = fecha;
        this.igv = igv;
        this.subtotal = subtotal;
        this.total = total;
        this.estado=estado;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[8];
        aux[0] = String.valueOf(IdCompra);
        aux[1] = String.valueOf(getIdProveedor());
        aux[2] = Tipodoc;
        aux[3] = nro;
        aux[4] = Formatos.sdfFecha.format(fecha);
        aux[5] = Formatos.df.format(igv);
        aux[6] = String.valueOf(subtotal);
        aux[7] = String.valueOf(total);
        return aux;
    }
    //</editor-fold>
}
