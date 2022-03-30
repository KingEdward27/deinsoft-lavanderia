package entidades;


public class Detalle_Compra {
    private int IdCompra, IdProducto;
    private float Precio, Importe ,Cantidad;

    //<editor-fold defaultstate="collapsed" desc="METODOS LECTURA Y ESCRITURA">
    public int getIdCompra() {
        return IdCompra;
    }
    
    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }
    
    public int getIdProducto() {
        return IdProducto;
    }
    
    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
    public float getPrecio() {
        return Precio;
    }
    
    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
    
    public float getImporte() {
        return Importe;
    }
    
    public void setImporte(float Importe) {
        this.Importe = Importe;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Detalle_Compra() {
    }
    
    public Detalle_Compra(int IdCompra, int IdProducto, int Cantidad, float Precio, float Importe) {
        this.IdCompra = IdCompra;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Importe = Importe;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE LOS DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[5];
        aux[0] = String.valueOf(IdCompra);
        aux[1] = String.valueOf(IdProducto);
        aux[2] = Formatos.df.format(Cantidad);
        aux[3] = Formatos.df.format(Precio);
        aux[4] = Formatos.df.format(Importe);
        return aux;
    }
    //</editor-fold>
}
