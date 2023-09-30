package entidades;
import java.sql.Date;
import java.util.LinkedList;

public class Ingresos implements iArregloLista{
    private int IdIngreso;
    private Date Fecha;
    private float Monto;
    private String Motivo;
    private int ventaId;
    private String estado;
    private float igv;
    private float subtotal;
    private float descuento;
    private float recibido;
    private TipoDoc tipoDoc;
    private String envioPseFlag;
    private String envioPseMensaje ;
    private String nroRespuesta ;
    private String codigoQR;
    private String xmlHash; 
    private String serieDocE;
    private int numDocE;
    private int indClienteE;
    private Date fechaPago;
    private Date fechaEnvio;
    private Ventas venta;
    private String tipoDocName ;
    private String tipoOperacion ;
    private String dtrCuentaBancaria;
    private float dtrPorcentaje;
    private float dtrMonto;
    private String formaPago;
    
    //<editor-fold defaultstate="collapsed" desc="METODOS DE LECTURA Y ESCRITURA">
    public int getIdIngreso() {
        return IdIngreso;
    }
    
    public void setIdIngreso(int IdIngreso) {
        this.IdIngreso = IdIngreso;
    }
    
    public Date getFecha() {
        return Fecha;
    }
    
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    public float getMonto() {
        return Monto;
    }
    
    public void setMonto(float Monto) {
        this.Monto = Monto;
    }
    
    public String getMotivo() {
        return Motivo;
    }
    
    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
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

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    
    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getRecibido() {
        return recibido;
    }

    public void setRecibido(float recibido) {
        this.recibido = recibido;
    }

    public String getTipoDocName() {
        return tipoDocName;
    }

    public void setTipoDocName(String tipoDocName) {
        this.tipoDocName = tipoDocName;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getDtrCuentaBancaria() {
        return dtrCuentaBancaria;
    }

    public void setDtrCuentaBancaria(String dtrCuentaBancaria) {
        this.dtrCuentaBancaria = dtrCuentaBancaria;
    }

    public float getDtrPorcentaje() {
        return dtrPorcentaje;
    }

    public void setDtrPorcentaje(float dtrPorcentaje) {
        this.dtrPorcentaje = dtrPorcentaje;
    }

    public float getDtrMonto() {
        return dtrMonto;
    }

    public void setDtrMonto(float dtrMonto) {
        this.dtrMonto = dtrMonto;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    


    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Ingresos() {
    }

    public Ingresos(int IdIngreso) {
        this.IdIngreso = IdIngreso;
    }
    
    public Ingresos(int IdIngreso, Date Fecha, float Monto, String Motivo,String estado,String tipoDocName,String formaPago) {
        this.IdIngreso = IdIngreso;
        this.Fecha = Fecha;
        this.Monto = Monto;
        this.Motivo = Motivo;
        this.estado = estado;
        this.tipoDocName = tipoDocName;
        this.formaPago = formaPago;
    }
    
    public Ingresos(Date Fecha, float Monto, String Motivo) {
        this.Fecha = Fecha;
        this.Monto = Monto;
        this.Motivo = Motivo;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE LOS DATOS">
    @Override
    public String[] ArregloDatos(){
        String[] aux = new String[3];
        aux[0] = Formatos.sdfFecha.format(Fecha);
        aux[1] = Formatos.df.format(Monto);
        aux[2] = Motivo;
        return aux;
    }
    //</editor-fold>
}
