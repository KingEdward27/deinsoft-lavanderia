package accesodatos;

import entidades.Categorias;
import entidades.Colores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class ColoresADN {
    
       private static boolean Nuevo(Colores ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into colores(nombre, estado) values(?, ?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getEstado());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(Colores ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update colors set nombre = ?, estado = ? where idcolor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setString(2, ent.getEstado());
            pst.setInt(3, ent.getIdColors());           
            r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Estado(Colores ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update colors set estado=? where idcolor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEstado());
           pst.setInt(2, ent.getIdColors());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(Colores ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idcolor) from colores where idcolor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getIdColors());
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
        String sql = "select idcolor from colores where nombre = ?";
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
   public static int CapturarIDColor(String p) throws ClassNotFoundException, SQLException {
        return CapturarID(p);
    }
   private static boolean ExisteNombre(Colores ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idcolor) from colores where nombre = ? and idcolor <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setInt(2, ent.getIdColors());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
   private static LinkedList<Colores> ListaColors(Colores c) throws SQLException, ClassNotFoundException {
        LinkedList<Colores> aux = new LinkedList<>();
        String sql = "select idcolor,nombre,estado from colores where nombre like concat(?,'%') and estado like ? order by nombre";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Colores(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
                
            }
            
        }
        return aux;
    }

    public static boolean Guardar(Colores p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(Colores p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<Colores> Lista(Colores c) throws SQLException, ClassNotFoundException {
        return ListaColors(c);
    }
    public static boolean Evaluar(Colores c) throws SQLException, ClassNotFoundException
    {
        return ExisteNombre(c);
    }
}
