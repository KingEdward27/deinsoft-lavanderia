package entidades;

public class Productos {

    private int IdProducto;
    private Marcas marca;
    private Categorias categoriasx;
    private UnidadMedidas unidadmedidasx;
    private String descripcion; 
    private float costo;
    private float precio;
    private float precio2;
    private float paquetes;
    private float stock;
    private float stockMinimo;
    private String Codbarra;
    private String observacion;
    private String estado;   

    

    public Productos() {
    }

    public Productos(int IdProducto, String descripcion) {
        this.IdProducto = IdProducto;
        this.descripcion = descripcion;
    }

    public Productos(int IdProducto, String observacion, String estado) {
        this.IdProducto = IdProducto;
        this.observacion = observacion;
        this.estado = estado;
    }
    
    
    public Productos(int IdProducto,Marcas marcasx, Categorias categoriasx, UnidadMedidas unidadmedidasx,
            String descripcion,float costo, float precio,float precio2, float paquetes, float stock, float stockMinimo,
            String Codbarra, String observacion, String estado) {
        this.IdProducto = IdProducto;
        this.marca = marcasx;
        this.categoriasx = categoriasx;
        this.unidadmedidasx = unidadmedidasx;
        this.descripcion = descripcion;     
        this.costo = costo;
        this.precio = precio;
        this.precio2=precio2;
        this.paquetes = paquetes;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.Codbarra = Codbarra;
        this.observacion = observacion;
        this.estado = estado;
    }

    public Productos(int IdProducto, Marcas marcasx, Categorias categoriasx, UnidadMedidas unidadmedidasx, String descripcion, float precio, float stock) {
        this.IdProducto = IdProducto;
        this.marca = marcasx;
        this.categoriasx = categoriasx;
        this.unidadmedidasx = unidadmedidasx;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public String[] ArregloDatos() {
        String[] aux = new String[14];
        aux[0] = String.valueOf(IdProducto);
        //aux[1] = String.valueOf(marca.getIdMarcas());
        aux[1] = marca.getNombre();
        //aux[3] = String.valueOf(categoriasx.getIdcategoria());
        aux[2] = categoriasx.getNom();
        //aux[5] = String.valueOf(unidadmedidasx.getIdUnidadmedida());
        aux[3] = unidadmedidasx.getNombre();
        aux[4] = descripcion;       
        aux[5] = Formatos.df.format(costo);
        aux[6] = Formatos.df.format(precio);
        aux[7] = Formatos.df.format(precio2);
        aux[8] = String.valueOf(paquetes);
        aux[9] = Formatos.df.format(stock);
        aux[10] = String.valueOf(stockMinimo);
        aux[11] = Codbarra;
        aux[12] = observacion;
        aux[13] = estado;
        return aux;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    public Categorias getCategoriasx() {
        return categoriasx;
    }

    public void setCategoriasx(Categorias categoriasx) {
        this.categoriasx = categoriasx;
    }

    public UnidadMedidas getUnidadmedidasx() {
        return unidadmedidasx;
    }

    public void setUnidadmedidasx(UnidadMedidas unidadmedidasx) {
        this.unidadmedidasx = unidadmedidasx;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public float getPrecio2() {
        return precio2;
    }

    public void setPrecio2(float precio2) {
        this.precio2 = precio2;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(float paquetes) {
        this.paquetes = paquetes;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(float stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String getCodbarra() {
        return Codbarra;
    }

    public void setCodbarra(String Codbarra) {
        this.Codbarra = Codbarra;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
