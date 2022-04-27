package entidades;
import java.sql.Date;

public class Egresos implements iArregloLista{
    private int IdEgreso;
    private Date Fecha;
    private float Monto;
    private String Motivo;

    //<editor-fold defaultstate="collapsed" desc="METODOS DE LECTURA Y ESCRITURA">
    public int getIdEgreso() {
        return IdEgreso;
    }

    public void setIdEgreso(int IdEgreso) {
        this.IdEgreso = IdEgreso;
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
    public Egresos() {
    }

    public Egresos(int IdEgreso, Date Fecha, float Monto, String Motivo) {
        this.IdEgreso = IdEgreso;
        this.Fecha = Fecha;
        this.Monto = Monto;
        this.Motivo = Motivo;
    }
    
    public Egresos( Date Fecha, float Monto, String Motivo) {
        
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
