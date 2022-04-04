/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author EDWARD
 */
public class Parametros {
    private int idparametro ;
    private String nombre_empresa;
    private String direccion;
    private String telefono  ;
    private String ruc ;
    private float monto_kilo ;
    private String estado  ;

    private int num_venta ;
    private String ruta_dump;
    private String rutaPse;
    private String token;
    private String rutadocs;
    private String nombreImpresora;
    
    public int getIdparametro() {
        return idparametro;
    }

    public void setIdparametro(int idparametro) {
        this.idparametro = idparametro;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public float getMonto_kilo() {
        return monto_kilo;
    }

    public void setMonto_kilo(float monto_kilo) {
        this.monto_kilo = monto_kilo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
    }

    public String getRuta_dump() {
        return ruta_dump;
    }

    public void setRuta_dump(String ruta_dump) {
        this.ruta_dump = ruta_dump;
    }

    public String getRutaPse() {
        return rutaPse;
    }

    public void setRutaPse(String rutaPse) {
        this.rutaPse = rutaPse;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRutadocs() {
        return rutadocs;
    }

    public void setRutadocs(String rutadocs) {
        this.rutadocs = rutadocs;
    }

    public String getNombreImpresora() {
        return nombreImpresora;
    }

    public void setNombreImpresora(String nombreImpresora) {
        this.nombreImpresora = nombreImpresora;
    }
    
    public Parametros() {
    }

    public Parametros(int idparametro, String nombre_empresa, String direccion, String telefono, 
            String ruc, float monto_kilo, String estado,int num_venta,String ruta_dump,String rutaPse,
            String token,String rutadocs,String nombreImpresora) {
        this.idparametro = idparametro;
        this.nombre_empresa = nombre_empresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ruc = ruc;
        this.monto_kilo = monto_kilo;
        this.estado = estado;
        this.num_venta = num_venta;
        this.ruta_dump = ruta_dump;
        this.rutaPse = rutaPse;
        this.token = token;
        this.rutadocs = rutadocs;
        this.nombreImpresora = nombreImpresora;
    }
    
    
}
