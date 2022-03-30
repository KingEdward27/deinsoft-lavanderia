package entidades;

public class UnidadMedidas implements iArregloLista{

    private int IdUnidadmedida;
    private String Nombre;
    private String Estado;

    //<editor-fold defaultstate="collapsed" desc="METODOS DE LECTURA Y ESCRITURA">
    public int getIdUnidadmedida() {
        return IdUnidadmedida;
    }
    
    public void setIdUnidadmedida(int IdUnidadmedida) {
        this.IdUnidadmedida = IdUnidadmedida;
    }
    
    public String getNombre() {
        return Nombre;
    }
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public String getEstado() {
        return Estado;
    }
    
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public UnidadMedidas() {
    }

    public UnidadMedidas(int IdUnidadmedida) {
        this.IdUnidadmedida = IdUnidadmedida;
    }

    public UnidadMedidas(int IdUnidadmedida, String Nombre) {
        this.IdUnidadmedida = IdUnidadmedida;
        this.Nombre = Nombre;
    }
    
    public UnidadMedidas(int IdUnidadmedida, String Nombre, String Estado) {
        this.IdUnidadmedida = IdUnidadmedida;
        this.Nombre = Nombre;
        this.Estado = Estado;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE LOS DATOS">
    @Override
    public String[] ArregloDatos(){
        String[] aux = new String[3];
        aux[0] = String.valueOf(IdUnidadmedida);
        aux[1] = Nombre;
        aux[2] = Estado;
        return aux;
    }
    //</editor-fold>
}
