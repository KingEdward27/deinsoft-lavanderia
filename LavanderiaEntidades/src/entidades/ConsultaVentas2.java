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
    private float sumatoriaIGV;
    
    private String serieDocE;
    private int numDocE;
    
    private String fechaEntrega;
    private String envioPseFlag;
    private String envioPseMensaje;
    private float acuenta;
    private float recibido;
    private float vuelto;
    private String tipo;
    private int idVentaFromIngresos;
    private String serieDocRef;
    private String numDocRef;
    private float montoRef;
    private Date fechaRef;
    private String flagAdelanto;
    private float subtotal;
    
    private String notaTipo;
    private String notaMotivo;
    private String notaReferenciaTipo;
    private String notaReferenciaSerie;
    private String notaReferenciaNumero;
    
    private String tipoOperacion;
    private String dtrCuentaBancaria;
    private float dtrPorcentaje;
    private float dtrMonto;
    private Float saldo;
    private String hora;
    private String formaPago;
    
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

    public float getSumatoriaIGV() {
        return sumatoriaIGV;
    }

    public void setSumatoriaIGV(float sumatoriaIGV) {
        this.sumatoriaIGV = sumatoriaIGV;
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

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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

    public float getAcuenta() {
        return acuenta;
    }

    public void setAcuenta(float acuenta) {
        this.acuenta = acuenta;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdVentaFromIngresos() {
        return idVentaFromIngresos;
    }

    public void setIdVentaFromIngresos(int idVentaFromIngresos) {
        this.idVentaFromIngresos = idVentaFromIngresos;
    }

    public String getSerieDocRef() {
        return serieDocRef;
    }

    public void setSerieDocRef(String serieDocRef) {
        this.serieDocRef = serieDocRef;
    }

    public String getNumDocRef() {
        return numDocRef;
    }

    public void setNumDocRef(String numDocRef) {
        this.numDocRef = numDocRef;
    }

    public float getMontoRef() {
        return montoRef;
    }

    public void setMontoRef(float montoRef) {
        this.montoRef = montoRef;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Date getFechaRef() {
        return fechaRef;
    }

    public void setFechaRef(Date fechaRef) {
        this.fechaRef = fechaRef;
    }

    public String getFlagAdelanto() {
        return flagAdelanto;
    }

    public void setFlagAdelanto(String flagAdelanto) {
        this.flagAdelanto = flagAdelanto;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getNotaTipo() {
        return notaTipo;
    }

    public void setNotaTipo(String notaTipo) {
        this.notaTipo = notaTipo;
    }

    public String getNotaMotivo() {
        return notaMotivo;
    }

    public void setNotaMotivo(String notaMotivo) {
        this.notaMotivo = notaMotivo;
    }

    public String getNotaReferenciaTipo() {
        return notaReferenciaTipo;
    }

    public void setNotaReferenciaTipo(String notaReferenciaTipo) {
        this.notaReferenciaTipo = notaReferenciaTipo;
    }

    public String getNotaReferenciaSerie() {
        return notaReferenciaSerie;
    }

    public void setNotaReferenciaSerie(String notaReferenciaSerie) {
        this.notaReferenciaSerie = notaReferenciaSerie;
    }

    public String getNotaReferenciaNumero() {
        return notaReferenciaNumero;
    }

    public void setNotaReferenciaNumero(String notaReferenciaNumero) {
        this.notaReferenciaNumero = notaReferenciaNumero;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
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
            String xmlHash,TipoDoc tipoDoc, Tipos_Servicio tipoServicio,
            float sumatoriaIGV,String serieDocE,int numDocE,String fechaEntrega,
            String envioPseFlag, String envioPseMensaje,float acuenta,
            float recibido,float vuelto,String tipo,int idVentaFromIngresos,
            String serieDocRef,String numDocRef,float montoRef,Date fechaRef,
            String flagAdelanto,float subtotal,
            String tipoOperacion,String dtrCuentaBancaria,float dtrPorcentaje,float dtrMonto, Float saldo,String hora,String formaPago) {
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
        this.sumatoriaIGV = sumatoriaIGV;
        this.serieDocE = serieDocE;
        this.numDocE = numDocE;
        this.fechaEntrega = fechaEntrega;
        this.envioPseFlag = envioPseFlag;
        this.envioPseMensaje = envioPseMensaje;
        this.acuenta = acuenta;
        this.recibido = recibido;
        this.vuelto = vuelto;
        this.tipo = tipo;
        this.idVentaFromIngresos = idVentaFromIngresos;
        this.serieDocRef = serieDocRef;
        this.numDocRef = numDocRef;
        this.montoRef = montoRef;
        this.fechaRef = fechaRef;
        this.flagAdelanto = flagAdelanto;
        this.subtotal = subtotal;
        
        this.tipoOperacion = tipoOperacion;
        this.dtrCuentaBancaria = dtrCuentaBancaria;
        this.dtrPorcentaje = dtrPorcentaje;
        this.dtrMonto = dtrMonto;
        this.saldo = saldo;
        this.hora = hora;
        this.formaPago = formaPago;
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
    public String[] arregloDatosMonitor(){
        String[] aux = new String[13];
        aux[0] = String.valueOf(idventa);
        aux[1] = tipoDoc.getNombre();
        aux[2] = serieDocE + "-" + String.format("%08d", numDocE);
//        aux[3] = tipoPago;
        aux[3] = cliente;
        aux[4] = Formatos.sdfFecha.format(fecha);
        aux[5] = fechaEntrega;
        aux[6] = Formatos.df.format(ventatotal);
        aux[7] = envioPseFlag.equals("1")?"SI":"NO";
        aux[8] = envioPseMensaje;
        aux[9] = tipo;
        aux[10] = String.valueOf(idVentaFromIngresos);
        aux[11] = flagAdelanto;
        aux[12] = serie + "-"+num;
        return aux;
    }
    
}

