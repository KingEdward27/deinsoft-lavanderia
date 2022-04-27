package accesodatos;

import entidades.Categorias;
import entidades.NumeracionDocumento;
import entidades.TipoDoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class NumeracionDocumentoADN {
    
       private static boolean Nuevo(NumeracionDocumento ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into numeracion_documento(nombre, estado) values(?, ?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
//           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getEstado());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(NumeracionDocumento ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update colors set nombre = ?, estado = ? where idcolor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
//            pst.setString(1, ent.getNombre());
            pst.setString(2, ent.getEstado());
            pst.setInt(3, ent.getNumeracionDocumentoId());           
            r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Estado(NumeracionDocumento ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update colors set estado=? where idcolor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEstado());
           pst.setInt(2, ent.getNumeracionDocumentoId());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(NumeracionDocumento ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idcolor) from numeracion_documento where idcolor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getNumeracionDocumentoId());
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
        String sql = "select idcolor from numeracion_documento where nombre = ?";
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
   private static NumeracionDocumento findByTipoddocId(int tipoDocId) throws SQLException, ClassNotFoundException {
        NumeracionDocumento r = null;
        String sql = "select serie,ultimo_numero from numeracion_documento where tipodoc_id = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, tipoDocId);
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = new NumeracionDocumento(0, null, rs.getString(1), rs.getInt(2), null);
            }
        }
        return r ;
    }
   public static NumeracionDocumento getByTipoddocId(int tipoDocId) throws SQLException, ClassNotFoundException{
       return findByTipoddocId(tipoDocId);
   }
   public static int CapturarIDColor(String p) throws ClassNotFoundException, SQLException {
        return CapturarID(p);
    }
   private static boolean ExisteNombre(NumeracionDocumento ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idcolor) from numeracion_documento where nombre = ? and idcolor <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
//            pst.setString(1, ent.getNombre());
            pst.setInt(2, ent.getNumeracionDocumentoId());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
   private static LinkedList<NumeracionDocumento> ListaNumeracionDocumento(NumeracionDocumento c) throws SQLException, ClassNotFoundException {
        LinkedList<NumeracionDocumento> aux = new LinkedList<>();
        String sql = "select numeracion_documento_id,tipodoc_id,serie,ultimo_numero,estado from numeracion_documento "
                + "where tipodoc_id = ? and serie like concat(?,'%')order by nombre";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setInt(1, c.getTipodoc().getTipodocId());
            ps.setString(2, c.getSerie());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new NumeracionDocumento(rs.getInt(1),new TipoDoc( rs.getInt(2))
                            , rs.getString(3), rs.getInt(4), rs.getString(5)));
                }
                
            }
            
        }
        return aux;
    }

    public static boolean Guardar(NumeracionDocumento p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(NumeracionDocumento p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<NumeracionDocumento> Lista(NumeracionDocumento c) throws SQLException, ClassNotFoundException {
        return ListaNumeracionDocumento(c);
    }
    public static boolean Evaluar(NumeracionDocumento c) throws SQLException, ClassNotFoundException
    {
        return ExisteNombre(c);
    }
}
