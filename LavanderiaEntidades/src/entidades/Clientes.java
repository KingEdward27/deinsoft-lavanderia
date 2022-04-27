package entidades;


public class Clientes {
    private int IdCliente;
    private String Nombres;
    private String dni;   
    private String Direccion;        
    private String Telefono;       
    private String Estado;
    private String correo;   
    private String tipoDoc;

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    
    //<editor-fold defaultstate="collapsed" desc="METODOS DE LECTURA Y ESCRITURA">
    public int getIdCliente() {
        return IdCliente;
    }
    
    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }
    
    public String getNombres() {
        return Nombres;
    }
    
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getDireccion() {
        return Direccion;
    }
    
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public String getTelefono() {
        return Telefono;
    }
    
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    public String getEstado() {
        return Estado;
    }
    
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Clientes() {
    }

    public Clientes(int IdCliente, String Estado) {
        this.IdCliente = IdCliente;
        this.Estado = Estado;
    }
    
    public Clientes(int IdCliente, String Nombres, String dni, String Direccion, 
            String Telefono, String Estado,String correo,String tipo) {
        this.IdCliente = IdCliente;
        this.Nombres = Nombres;
        this.dni = dni;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Estado = Estado;
        this.correo = correo;
        this.tipoDoc = tipo;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[8];
        aux[0] = String.valueOf(IdCliente);
        aux[1] = Nombres;
        aux[2] = dni;
        aux[3] = Direccion;
        aux[4] = Telefono;
        aux[5] = correo;
        aux[6] = tipoDoc;
        aux[7] = Estado;
        return aux;
    }
    //</editor-fold>
}