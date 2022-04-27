package entidades;

public class Proveedores {
   private int IdProveedor;
   private String Raz;
   private String Ruc; 
   private String Dir; 
   private String Telef; 
   private String Est;

    //<editor-fold defaultstate="collapsed" desc="METODOS DE LECTURA Y ESCRITURA">
   public int getIdProveedor() {
       return IdProveedor;
   }
   
   public void setIdProveedor(int IdProveedor) {
       this.IdProveedor = IdProveedor;
   }
   
   public String getRaz() {
       return Raz;
   }
   
   public void setRaz(String Raz) {
       this.Raz = Raz;
   }
   
   public String getRuc() {
       return Ruc;
   }
   
   public void setRuc(String Ruc) {
       this.Ruc = Ruc;
   }
   
   public String getDir() {
       return Dir;
   }
   
   public void setDir(String Dir) {
       this.Dir = Dir;
   }
   
   public String getTelef() {
       return Telef;
   }
   
   public void setTelef(String Telef) {
       this.Telef = Telef;
   }
   
   public String getEst() {
       return Est;
   }
   
   public void setEst(String Est) {
       this.Est = Est;
   }
   //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Proveedores() {
    }

    public Proveedores(int IdProveedor, String Est) {
        this.IdProveedor = IdProveedor;
        this.Est = Est;
    }
    
    public Proveedores(int IdProveedor, String Raz, String Ruc, String Dir, String Telef, String Est) {
        this.IdProveedor = IdProveedor;
        this.Raz = Raz;
        this.Ruc = Ruc;
        this.Dir = Dir;
        this.Telef = Telef;
        this.Est = Est;
    }
    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="ARREGLO DE DATOS">
    public String[] ArregloDatos(){
        String[] aux = new String[6];
        aux[0] = String.valueOf(IdProveedor);
        aux[1] = Raz;
        aux[2] = Ruc;
        aux[3] = Dir;
        aux[4] = Telef;
        aux[5] = Est;
        return aux;
    }
    //</editor-fold>
}
