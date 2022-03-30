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
public class ConsultaVentas2 {
    private int idventa;
    private String serie,num,cliente;
    private Date fecha;
    private float ventatotal;

    private String codigo;
    private String producto;
    private String tipoPago;
    private float cantidad;
    private float precio;
    private float importe;
    private float descuento;
    private float afectacion_igv;
    private int idproducto;
    
//    private String tipo_venta;
    private String nomMecanico;
    private String placaVechiculo;
    
    private String dniCliente;
    private String direccionCliente;
    private String descripcionMonto;
    private String tipoIGV;
    private int idDocumento;
    private String tipoCliente;
    private String correoCliente;
    private String codigoQR;
    private String xmlHash;
    private TipoDoc tipoDoc;
    private Tipos_Servicio tipoServicio;
    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }
    
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getVentatotal() {
        return ventatotal;
    }

    public void setVentatotal(float ventatotal) {
        this.ventatotal = ventatotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProducto() {
        return producto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public float getImporte() {
        return importe;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDescripcionMonto() {
        return descripcionMonto;
    }

    public void setDescripcionMonto(String descripcionMonto) {
        this.descripcionMonto = descripcionMonto;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getTipoIGV() {
        return tipoIGV;
    }

    public void setTipoIGV(String tipoIGV) {
        this.tipoIGV = tipoIGV;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreo(String correoCliente) {
        this.correoCliente = correoCliente;
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


    public Tipos_Servicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(Tipos_Servicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public float getAfectacion_igv() {
        return afectacion_igv;
    }

    public void setAfectacion_igv(float afectacion_igv) {
        this.afectacion_igv = afectacion_igv;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    
    public ConsultaVentas2() {
    }
//consulta ventas
    public ConsultaVentas2(int idventa, String num,String nomMecanico, String cliente,String placaVehiculo, Date fecha, float ventatotal,String tipo_venta) {
        this.idventa = idventa;
        this.nomMecanico = nomMecanico;
        this.num = num;
        this.cliente = cliente;
        this.fecha = fecha;
        this.ventatotal = ventatotal;
        this.tipoPago = tipo_venta;
        this.placaVechiculo = placaVehiculo;
    }
    //get datos venta
    public ConsultaVentas2(int idventa, String serie, String num, 
            String cliente, Date fecha, 
            float ventatotal,String tipo_venta,String dni,String direccion,
            String descripcionMonto,float descuento,String tipoIGV,
            String tipoCliente,String correoCliente,String codigoQR,
            String xmlHash,TipoDoc tipoDoc, Tipos_Servicio tipoServicio) {
        this.idventa = idventa;
        this.serie = serie;
        this.num = num;
        this.cliente = cliente;
        this.fecha = fecha;
        this.ventatotal = ventatotal;
        this.tipoPago = tipo_venta;
        this.dniCliente = dni;
        this.direccionCliente = direccion;
        this.descripcionMonto = descripcionMonto;
        this.descuento = descuento;
        this.tipoIGV = tipoIGV;
        this.tipoCliente = tipoCliente;
        this.correoCliente = correoCliente;
        this.codigoQR = codigoQR;
        this.xmlHash = xmlHash;
        this.tipoDoc = tipoDoc;
        this.tipoServicio = tipoServicio;
    }
    //anular ventas
public ConsultaVentas2(int idventa, String serie,  String num, String cliente, Date fecha, float ventatotal) {
        this.idventa = idventa;
        this.serie = serie;
        this.num = num;
        this.cliente = cliente;
        this.fecha = fecha;
        this.ventatotal = ventatotal;
    }
    public ConsultaVentas2(String serie, String num, String cliente, Date fecha,  float ventatotal) {
        this.serie = serie;
        this.num = num;
        this.cliente = cliente;
        this.fecha = fecha;
        this.ventatotal = ventatotal;
    }

    public ConsultaVentas2(String codigo, String producto, float cantidad, float precio, 
            float importe,int idproducto,float afectacionIGV) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
        this.idproducto = idproducto;
        this.afectacion_igv = afectacionIGV;
    }
    
    public String[] ArregloDatos(){
        String[] aux = new String[6];
        aux[0] = String.valueOf(idventa);
        aux[1] = serie;
        aux[2] = num;
        aux[3] = cliente;
        aux[4] = Formatos.sdfFecha.format(fecha);
        aux[5] = Formatos.df.format(ventatotal);
        return aux;
    }
    public String[] ArregloDatosCV(){
        String[] aux = new String[8];
        aux[0] = String.valueOf(idventa);
        aux[1] = num;
        aux[2] = nomMecanico;
        aux[3] = tipoPago;
        aux[4] = cliente;
        aux[5] = placaVechiculo;
        aux[6] = Formatos.sdfFecha.format(fecha);
        aux[7] = Formatos.df.format(ventatotal);
        
        return aux;
    }
    
    public String[] ArregloDatosCC(){
        String[] aux = new String[7];
        aux[0] = String.valueOf(idventa);
        aux[1] = serie;
        aux[2] = num;
        aux[3] = tipoPago;
        aux[4] = cliente;
        aux[5] = Formatos.sdfFecha.format(fecha);
        aux[6] = Formatos.df.format(ventatotal);
        return aux;
    }
    
}

