
package entidades;

public class Categorias {
    private int Idcategoria;
    private String nom;
    private String estado;

    //<editor-fold defaultstate="collapsed" desc="METODO DE LECTURA Y ESCRITURA">
    public int getIdcategoria() {
        return Idcategoria;
    }
    
    public void setIdcategoria(int Idcategoria) {
        this.Idcategoria = Idcategoria;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Categorias() {
    }

    public Categorias(int Idcategoria) {
        this.Idcategoria = Idcategoria;
    }

    public Categorias(int Idcategoria, String nom) {
        this.Idcategoria = Idcategoria;
        this.nom = nom;
    }
    
    public Categorias(int Idcategoria, String nom, String estado) {
        this.Idcategoria = Idcategoria;
        this.nom = nom;
        this.estado = estado;
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[3];
        aux[0] = String.valueOf(Idcategoria);
        aux[1] = nom;
        aux[2] = estado;
        
        return aux;
    }
    //</editor-fold>
}
