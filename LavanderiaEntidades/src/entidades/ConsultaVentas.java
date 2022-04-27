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
public class ConsultaVentas {
    private int idventa;
    private String tipodoc,serie,num,cliente;
    
    private Date fecha;
    private String hora;
    private String nomusuario;
    private float igv,subtotal,ventatotal,cantidad,precio;

    private int idtiposervicio;
    private String tipo_pago;
    private String descripcion_servicio,descripcion_producto;
    private String fecha_Entrega;
    private Date fec_Entrega;
    private String estado;
    private float a_cuenta;
    private float descuento;
    private String dniCliente;
    
    private String envioPSEVenta;
    private String envioPSEIngreso;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    public String getNomusuario() {
        return nomusuario;
    }
    
    public float getVentatotal() {
        return ventatotal;
    }

    public void setVentatotal(float ventatotal) {
        this.ventatotal = ventatotal;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
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

    public String getFecha_Entrega() {
        return fecha_Entrega;
    }

    public void setFecha_Entrega(String fecha_Entrega) {
        this.fecha_Entrega = fecha_Entrega;
    }

    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFec_Entrega() {
        return fec_Entrega;
    }

    public void setFec_Entrega(Date fec_Entrega) {
        this.fec_Entrega = fec_Entrega;
    }

    public float getA_cuenta() {
        return a_cuenta;
    }

    public void setA_cuenta(float a_cuenta) {
        this.a_cuenta = a_cuenta;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getEnvioPSEVenta() {
        return envioPSEVenta;
    }

    public void setEnvioPSEVenta(String envioPSEVenta) {
        this.envioPSEVenta = envioPSEVenta;
    }

    public String getEnvioPSEIngreso() {
        return envioPSEIngreso;
    }

    public void setEnvioPSEIngreso(String envioPSEIngreso) {
        this.envioPSEIngreso = envioPSEIngreso;
    }

    public ConsultaVentas() {
    }
    //consultaventas anular
    public ConsultaVentas(int idventa, String serie, String num, String cliente, 
            Date fecha,String nomusuario, float ventatotal,String envioPSEVenta,String envioPSEIngreso) {
        this.idventa = idventa;
        this.serie = serie;
        this.num = num;
        this.cliente = cliente;
        this.fecha = fecha;
        this.nomusuario=nomusuario;
        
        this.ventatotal = ventatotal;
        this.envioPSEVenta = envioPSEVenta;
        this.envioPSEIngreso = envioPSEIngreso;
    }
    public ConsultaVentas(String cliente,Date fecha,String fec_entrega, 
            float cantidad,String descripcion_producto,float precio) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.fecha_Entrega = fec_entrega;
        this.cantidad = cantidad;
        this.descripcion_producto = descripcion_producto;
        this.precio = precio;
    }

    public ConsultaVentas(String serie, String num, String cliente, Date fecha, 
            float ventatotal,String estado) {
        this.serie = serie;
        this.num = num;
        this.cliente = cliente;
        this.fecha = fecha;
        this.ventatotal = ventatotal;
        this.estado = estado;
    }
    //consultaventas
    public ConsultaVentas(String num,String tipopago,String descripcion_servicio, 
            String cliente, Date fecha,String estado, float descuento,  float ventatotal) {
        
        this.num = num;
        this.tipo_pago = tipopago;
        this.descripcion_servicio = descripcion_servicio;
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = estado;
        this.descuento = descuento;
        this.ventatotal = ventatotal;
    }
    public ConsultaVentas(int idventa, String cliente, String tipodoc, String serie, String num, Date fecha, String hora,float igv, float subtotal, String nomusuario,  float ventatotal) {
        this.idventa = idventa;
        this.tipodoc = tipodoc;
        this.serie = serie;
        this.num = num;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.nomusuario = nomusuario;
        this.igv = igv;
        this.subtotal = subtotal;
        this.ventatotal = ventatotal;
    }
 public ConsultaVentas(int idventa, String cliente, String tipodoc, String serie, String num, Date fecha, String hora,float igv, float subtotal, 
                        String nomusuario,  float ventatotal,String tipo_pago,
                        String descripcion_servicio,String fecha_entrega,String estado,
                        float a_cuenta,float descuento,String dniCliente) {
        this.idventa = idventa;
        this.tipodoc = tipodoc;
        this.serie = serie;
        this.num = num;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.nomusuario = nomusuario;
        this.igv = igv;
        this.subtotal = subtotal;
        this.ventatotal = ventatotal;
        this.tipo_pago = tipo_pago;
        this.descripcion_servicio = descripcion_servicio;
        this.fecha_Entrega = fecha_entrega;
        this.estado = estado;
        this.a_cuenta=a_cuenta;
        this.descuento=descuento;
        this.dniCliente = dniCliente;
    }
    
    
    public String[] ArregloDatos(){
        String[] aux = new String[8];
        
        aux[0] = num;
        aux[1] = tipo_pago;
        aux[2] = descripcion_servicio;
        aux[3] = cliente;
        aux[4] = Formatos.sdfFecha.format(fecha);
        aux[5] = estado;
        aux[6] = Formatos.df.format(descuento);
        aux[7] = Formatos.df.format(ventatotal);
        return aux;
    }
    public String[] ArregloDatosTC(){
        String[] aux = new String[6];
        
        aux[0] = serie;
        aux[1] = num;
        aux[2] = cliente;
        aux[3] = Formatos.sdfFecha.format(fecha);
        aux[4] = Formatos.df.format(ventatotal);
        aux[5] = estado;
        return aux;
    }
    public String[] ArregloDatosP(){
        String[] aux = new String[7];
        aux[0] = cliente;
        aux[1] = Formatos.sdfFecha.format(fecha);
        aux[2] = fecha_Entrega;
        aux[3] = Formatos.df.format(cantidad);
        aux[4] = descripcion_producto;
        aux[5] = Formatos.df.format(precio);
        aux[6] = Formatos.df.format(cantidad*precio);
        return aux;
    }
    public String[] ArregloDatosAnular(){
        String[] aux = new String[9];
        aux[0] = String.valueOf(idventa);
        aux[1] = serie;
        aux[2] = num;
        aux[3] = cliente;
        aux[4] = Formatos.sdfFecha.format(fecha);
        aux[5] = nomusuario;
        aux[6] = Formatos.df.format(ventatotal);
        aux[7] = envioPSEVenta;
        aux[8] = envioPSEIngreso;
        return aux;
    }
    public String[] ArregloDatos3(){
        String[] aux = new String[17];
        aux[0] = String.valueOf(idventa);
        aux[1] = cliente;
        aux[2] = tipodoc;
        aux[3] = serie;
        aux[4] = num;
        aux[5] = Formatos.sdfFecha.format(fecha);
        aux[6] = hora;
        aux[7] = Formatos.df.format(igv);
        aux[8] = Formatos.df.format(subtotal);
        aux[9] = nomusuario;
        aux[10] = Formatos.df.format(descuento);
        aux[11] = Formatos.df.format(ventatotal);
        
        aux[12] = tipo_pago;
        aux[13] = descripcion_servicio;
        aux[14] = fecha_Entrega;
        aux[15] = estado;
        aux[16] = Formatos.df.format(a_cuenta);
        return aux;
    }
}
