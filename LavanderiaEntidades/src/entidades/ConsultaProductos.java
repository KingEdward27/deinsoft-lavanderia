                                                                                        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author EDWARD
 */
public class ConsultaProductos{
    private int idproducto;
    private String categ,marc,desc;
    private String unidadmedida;
    private int stock;
    private float precio;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public String getMarc() {
        return marc;
    }

    public void setMarc(String marc) {
        this.marc = marc;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ConsultaProductos() {
    }

    public ConsultaProductos(int idproducto, String categ, String marca, String desc,String unidadmedida, int stock, float precio) {
        this.idproducto = idproducto;
        this.categ = categ;
        this.marc = marca;
        this.desc = desc;
        this.unidadmedida=unidadmedida;
        this.stock = stock;
        this.precio = precio;
    }
    public String[] ArregloDatos(){
        String[] aux = new String[7];
        aux[0] = String.valueOf(idproducto);
        aux[1] = categ;
        aux[2] = marc;
        aux[3] = desc;
        aux[4] = unidadmedida;
        aux[5] = String.valueOf(stock);
        aux[6] = Formatos.df.format(precio);
        return aux;
    }
}
