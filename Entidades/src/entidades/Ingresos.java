package entidades;
import java.sql.Date;

public class Ingresos implements iArregloLista{
    private int IdIngreso;
    private Date Fecha;
    private float Monto;
    private String Motivo;

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

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Ingresos() {
    }

    public Ingresos(int IdIngreso, Date Fecha, float Monto, String Motivo) {
        this.IdIngreso = IdIngreso;
        this.Fecha = Fecha;
        this.Monto = Monto;
        this.Motivo = Motivo;
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
