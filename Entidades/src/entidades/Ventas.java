package entidades;

import java.sql.Date;
import java.util.LinkedList;

public class Ventas {
    private int Idventa;
    private int idcliente;
    private String Serie;
    private String nro;
    private Date fecha;
    private String hora;
    private float igv;
    private float subtotal;
    private float total;
    private int idusuario;
    private String estado;
    
    private int idtiposervicio;
    private String tipo_pago;
    private String descripcion_servicio;
    private Date fecha_Entrega;
    
    private String strfecha_Entrega;
    private Date fecha_reg;
     private LinkedList <Detalle_Venta> lista;
    private float a_cuenta;
    private float descuento;
    private float recibido;
    private float vuelto;
    private TipoDoc tipoDoc;
    private String envioPseFlag;
    private String envioPseMensaje ;
    private String nroRespuesta ;
    private String codigoQR;
    private String xmlHash; 
    private String serieDocE;
    private int numDocE;
    private int indClienteE;
    
    //<editor-fold defaultstate="collapsed" desc="METODOS DE LECTURA Y ESCRITURA">
    public int getIdventa() {
        return Idventa;
    }
    
    public void setIdventa(int Idventa) {
        this.Idventa = Idventa;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public String getSerie() {
        return Serie;
    }
    
    public void setSerie(String Serie) {
        this.Serie = Serie;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public LinkedList<Detalle_Venta> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Detalle_Venta> lista) {
        this.lista = lista;
    }

    public int getIdtiposervicio() {
        return idtiposervicio;
    }

    public void setIdtiposervicio(int idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    public Date getFecha_Entrega() {
        return fecha_Entrega;
    }

    public void setFecha_Entrega(Date fecha_Entrega) {
        this.fecha_Entrega = fecha_Entrega;
    }

    public String getStrfecha_Entrega() {
        return strfecha_Entrega;
    }

    public void setStrfecha_Entrega(String strfecha_Entrega) {
        this.strfecha_Entrega = strfecha_Entrega;
    }

    public float getA_cuenta() {
        return a_cuenta;
    }

    public void setA_cuenta(float a_cuenta) {
        this.a_cuenta = a_cuenta;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getEnvioPseFlag() {
        return envioPseFlag;
    }

    public void setEnvioPseFlag(String envioPseFlag) {
        this.envioPseFlag = envioPseFlag;
    }

    public String getEnvioPseMensaje() {
        return envioPseMensaje;
    }

    public void setEnvioPseMensaje(String envioPseMensaje) {
        this.envioPseMensaje = envioPseMensaje;
    }

    public String getNroRespuesta() {
        return nroRespuesta;
    }

    public void setNroRespuesta(String nroRespuesta) {
        this.nroRespuesta = nroRespuesta;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public String getXmlHash() {
        return xmlHash;
    }

    public void setXmlHash(String xmlHash) {
        this.xmlHash = xmlHash;
    }

    public String getSerieDocE() {
        return serieDocE;
    }

    public void setSerieDocE(String serieDocE) {
        this.serieDocE = serieDocE;
    }

    public int getNumDocE() {
        return numDocE;
    }

    public void setNumDocE(int numDocE) {
        this.numDocE = numDocE;
    }

    public int getIndClienteE() {
        return indClienteE;
    }

    public void setIndClienteE(int indClienteE) {
        this.indClienteE = indClienteE;
    }

    public float getRecibido() {
        return recibido;
    }

    public void setRecibido(float recibido) {
        this.recibido = recibido;
    }

    public float getVuelto() {
        return vuelto;
    }

    public void setVuelto(float vuelto) {
        this.vuelto = vuelto;
    }


    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Ventas() {
        lista = new LinkedList<>();
    }

    public Ventas(int Idventa, int idcliente, TipoDoc tipodoc, String Serie, String nro, 
            Date fecha,String hora, float igv, float subtotal, float total,int idusuario, 
            String estado,float a_cuenta,float descuento) {
        this.Idventa = Idventa;
        this.idcliente = idcliente;
        this.tipoDoc = tipodoc;
        this.Serie = Serie;
        this.nro = nro;
        this.fecha = fecha;
        this.hora=hora;
        this.igv = igv;
        this.subtotal = subtotal;
        this.total = total;
        this.idusuario=idusuario;
        this.estado = estado;
        this.a_cuenta = a_cuenta;
        this.descuento=descuento;
    }
    
    public Ventas(int Idventa, int idcliente, TipoDoc tipodoc, String Serie, String nro, Date fecha, float igv, float subtotal, float total) {
        this.Idventa = Idventa;
        this.idcliente = idcliente;
        this.tipoDoc = tipodoc;
        this.Serie = Serie;
        this.nro = nro;
        this.fecha = fecha;
        this.igv = igv;
        this.subtotal = subtotal;
        this.total = total;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Ventas{" + "Idventa=" + Idventa + ", idcliente=" + idcliente + ", Serie=" + Serie + ", nro=" + nro + ", fecha=" + fecha + ", hora=" + hora + ", igv=" + igv + ", subtotal=" + subtotal + ", total=" + total + ", idusuario=" + idusuario + ", estado=" + estado + ", idtiposervicio=" + idtiposervicio + ", tipo_pago=" + tipo_pago + ", descripcion_servicio=" + descripcion_servicio + ", fecha_Entrega=" + fecha_Entrega + ", strfecha_Entrega=" + strfecha_Entrega + ", fecha_reg=" + fecha_reg + ", lista=" + lista + ", a_cuenta=" + a_cuenta + ", descuento=" + descuento + ", tipoDoc=" + tipoDoc + ", envioPseFlag=" + envioPseFlag + ", envioPseMensaje=" + envioPseMensaje + ", nroRespuesta=" + nroRespuesta + ", codigoQR=" + codigoQR + ", xmlHash=" + xmlHash + ", serieDocE=" + serieDocE + ", numDocE=" + numDocE + ", indClienteE=" + indClienteE + '}';
    }

    
    
    
    
}
