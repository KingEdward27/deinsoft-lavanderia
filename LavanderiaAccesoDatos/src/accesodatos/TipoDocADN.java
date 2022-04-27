package accesodatos;

import entidades.Categorias;
import entidades.TipoDoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class TipoDocADN {
    
       private static boolean Nuevo(TipoDoc ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into tipodoc(nombre, estado) values(?, ?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getEstado());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(TipoDoc ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update colors set nombre = ?, estado = ? where idcolor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setString(2, ent.getEstado());
            pst.setInt(3, ent.getTipodocId());           
            r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Estado(TipoDoc ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update colors set estado=? where idcolor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEstado());
           pst.setInt(2, ent.getTipodocId());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(TipoDoc ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idcolor) from tipodoc where idcolor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getTipodocId());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getInt(1);
           }
       }
       return r > 0 ? true : false;
   }
   
   private static int CapturarID(String desc) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select tipodoc_id from tipodoc where nombre = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, desc);
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r ;
    }
   public static int getId(String p) throws ClassNotFoundException, SQLException {
        return CapturarID(p);
    }
   private static boolean ExisteNombre(TipoDoc ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idcolor) from tipodoc where nombre = ? and idcolor <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setInt(2, ent.getTipodocId());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
   private static TipoDoc findByName(String ent) throws SQLException, ClassNotFoundException {
        TipoDoc r;
        String sql = "select tipodoc_id,nombre,value from tipodoc where nombre = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent);
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = new TipoDoc(rs.getInt(1), rs.getString(2), rs.getString(3), null) ;
            }
        }
        return r;
    }
   private static LinkedList<TipoDoc> ListaTipoDoc(TipoDoc c) throws SQLException, ClassNotFoundException {
        LinkedList<TipoDoc> aux = new LinkedList<>();
        String sql = "select tipodoc_id,nombre,value,estado from tipodoc "
                + "where nombre like concat(?,'%') and estado like ? and value in ('00','01','03') order by nombre";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new TipoDoc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
                
            }
            
        }
        return aux;
    }

    public static boolean Guardar(TipoDoc p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(TipoDoc p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<TipoDoc> Lista(TipoDoc c) throws SQLException, ClassNotFoundException {
        return ListaTipoDoc(c);
    }
    public static boolean Evaluar(TipoDoc c) throws SQLException, ClassNotFoundException
    {
        return ExisteNombre(c);
    }
    public static TipoDoc getByName(String ent) throws SQLException, ClassNotFoundException{
        return findByName(ent);
    }
}
