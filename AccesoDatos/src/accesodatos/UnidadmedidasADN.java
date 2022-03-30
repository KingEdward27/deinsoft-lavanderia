package accesodatos;


import entidades.UnidadMedidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class UnidadmedidasADN {
    
   private static boolean Nuevo(UnidadMedidas ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into unidadmedidas(nombre, estado) values(?, ?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getEstado());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(UnidadMedidas ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update unidadmedidas set nombre = ?, estado = ? where idunidadmedida = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setString(2, ent.getEstado());
            pst.setInt(3, ent.getIdUnidadmedida());           
            r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Estado(UnidadMedidas ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update unidadmedidas set estado=? where idunidadmedida = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEstado());
           pst.setInt(2, ent.getIdUnidadmedida());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(UnidadMedidas ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idunidadmedida) from unidadmedidas where idunidadmedida = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getIdUnidadmedida());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getInt(1);
           }
       }
       return r > 0 ? true : false;
   }
   private static boolean ExisteNombre(UnidadMedidas ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idunidadmedida) from unidadmedidas where nombre = ? and idunidadmedida <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setInt(2, ent.getIdUnidadmedida());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
   private static LinkedList<UnidadMedidas> ListaMedidas(UnidadMedidas c) throws SQLException, ClassNotFoundException {
        LinkedList<UnidadMedidas> aux = new LinkedList<>();
        String sql = "select idunidadmedida,nombre,estado from unidadmedidas where nombre like concat(?,'%') and estado like ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new UnidadMedidas(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
                
            }
            
        }
//        JOptionPane.showMessageDialog(null, "a"+c.getDni()+"a");
//                JOptionPane.showMessageDialog(null, "a"+c.getNombres()+"a");
//                JOptionPane.showMessageDialog(null, "a"+c.getEstado()+"a");
        return aux;
    }

    public static boolean Guardar(UnidadMedidas p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(UnidadMedidas p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<UnidadMedidas> Lista(UnidadMedidas c) throws SQLException, ClassNotFoundException {
        return ListaMedidas(c);
    }
    public static boolean Evaluar(UnidadMedidas c) throws SQLException, ClassNotFoundException
    {
        return ExisteNombre(c);
    }
}
