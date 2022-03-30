/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author EDWARD
 */
public class ProductoDetalle extends Productos {
    private int idproduct;
    private float Cantidad;
    private String descripcio;
    private float pre;
    private float Importe;

    private int idmarca;
    private int idcolor;
    private int idcaracteristica;
    //<editor-fold defaultstate="collapsed" desc="Metodos de lectura y escritura">
    
    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getImporte() {
        return Importe;
    }

    public float getPre() {
        return pre;
    }

    public void setPre(float pre) {
        this.pre = pre;
    }

    

    public void setImporte(float Importe) {
        this.Importe = Importe;
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
    
//
    //</editor-fold>
    
    public ProductoDetalle() {
    }

    public ProductoDetalle(int idproduct, float Cantidad, String descripcio, float pre, 
            float Importe,int idmarca,int idcolor,int idcaracteristica) {
        this.idproduct = idproduct;
        this.Cantidad = Cantidad;
        this.descripcio = descripcio;
        this.pre = pre;
        this.idmarca = idmarca;
        this.idcolor = idcolor;
        this.idcaracteristica = idcaracteristica;
        
    }
    public ProductoDetalle(int idproduct, float Cantidad, String descripcio, float pre, 
            float Importe) {
        this.idproduct = idproduct;
        this.Cantidad = Cantidad;
        this.descripcio = descripcio;
        this.pre = pre;
        this.Importe = Importe;
    }
    
    
 public String[] DatosToArray() {
        Importe = getPrecio() * Cantidad;
        String[] aux = new String[8];
        aux[0] = String.valueOf(getIdProducto());
        aux[1] = Formatos.df.format(getCantidad());
        aux[2] = getDescripcion();
        aux[3] = Formatos.df.format(getPrecio());
        aux[4] = Formatos.df.format(getImporte());
        
        aux[5] = String.valueOf(getIdmarca());
        aux[6] = String.valueOf(getIdcolor());
        aux[7] = String.valueOf(getIdcaracteristica());
        return aux;
    }
    public String[] DatosToArray2() {
//        Importe = getPre()* Cantidad;
        String[] aux = new String[5];
        aux[0] = String.valueOf(idproduct);
        aux[1] = Formatos.df.format(Cantidad);
        aux[2] = descripcio;
        aux[3] = Formatos.df.format(pre);
        aux[4] = Formatos.df.format(Importe);
        return aux;
    }
}
