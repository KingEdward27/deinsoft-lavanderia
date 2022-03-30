package entidades;


public class Detalle_Venta {
    private int IdVenta, IdProducto ;
    private float Precio, Importe,Cantidad,Descuento,afectacionIgv;
    private String descripcion_producto;

    private int idmarca;
    private int idcolor;
    private int idcaracteristica;
    
    //<editor-fold defaultstate="collapsed" desc="METODOS DE LECTURA Y ESCRITURA">
    public int getIdVenta() {
        return IdVenta;
    }
    
    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
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

    public float getDescuento() {
        return Descuento;
    }

    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public int getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
    }

    public int getIdcaracteristica() {
        return idcaracteristica;
    }

    public void setIdcaracteristica(int idcaracteristica) {
        this.idcaracteristica = idcaracteristica;
    }

    public float getAfectacionIgv() {
        return afectacionIgv;
    }

    public void setAfectacionIgv(float afectacionIgv) {
        this.afectacionIgv = afectacionIgv;
    }
    
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Detalle_Venta() {
        
    }
    
    public Detalle_Venta(int IdVenta, int IdProducto, float Cantidad, float Precio,
            float Descuento, float Importe,String descripcion_producto,
            int idmarca,int idcolor,int idcaracteristica) {
        this.IdVenta = IdVenta;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Descuento=Descuento;
        this.Importe = Importe;
        this.descripcion_producto = descripcion_producto;
        this.idmarca = idmarca;
        this.idcolor = idcolor;
        this.idcaracteristica = idcaracteristica;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[10];
        aux[0] = String.valueOf(IdVenta);
        aux[1] = String.valueOf(IdProducto);
        aux[2] = Formatos.df.format(Cantidad);
        aux[3] = Formatos.df.format(Precio);
        aux[4] = Formatos.df.format(Descuento);
        aux[5] = Formatos.df.format(Importe);
        aux[6] = descripcion_producto;
        aux[7] = String.valueOf(idmarca);;
        aux[8] = String.valueOf(idcolor);;
        aux[9] = String.valueOf(idcaracteristica);;
        return aux;
    }
    //</editor-fold>
}
