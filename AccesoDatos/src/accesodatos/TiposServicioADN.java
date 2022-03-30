package accesodatos;

import entidades.Categorias;
import entidades.Tipos_Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class TiposServicioADN {
    
       private static boolean Nuevo(Tipos_Servicio ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into Tipos_servicio(descripcion, estado) values(?, '1')";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
           pst.setString(1, ent.getDescripcion());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(Tipos_Servicio ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update Tipos_servicio set nombre = ? where idtiposervicio = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getDescripcion());
            pst.setInt(2, ent.getIdtiposervicio());           
            r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Estado(Tipos_Servicio ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update Tipos_servicio set estado=? where idtiposervicio = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEstado());
           pst.setInt(2, ent.getIdtiposervicio());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(Tipos_Servicio ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idtiposervicio) from Tipos_servicio where idtiposervicio = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getIdtiposervicio());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getInt(1);
           }
       }
       return r > 0 ? true : false;
   }
   private static boolean ExisteNombre(Tipos_Servicio ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idtiposervicio) from Tipos_servicio where descripcion = ? and idtiposervicio <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getDescripcion());
            pst.setInt(2, ent.getIdtiposervicio());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
   private static int CapturarID(String desc) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select idtiposervicio from Tipos_servicio where descripcion = ?";
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
   private static LinkedList<Tipos_Servicio> ListaTipos_Servicio(Tipos_Servicio c) throws SQLException, ClassNotFoundException {
        LinkedList<Tipos_Servicio> aux = new LinkedList<>();
        String sql = "select idtiposervicio,descripcion,estado from Tipos_servicio where descripcion like concat(?,'%') and estado like ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getDescripcion());
            ps.setString(2, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Tipos_Servicio(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
                
            }
            
        }
        return aux;
    }

    public static boolean Guardar(Tipos_Servicio p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(Tipos_Servicio p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<Tipos_Servicio> Lista(Tipos_Servicio c) throws SQLException, ClassNotFoundException {
        return ListaTipos_Servicio(c);
    }
    public static boolean Evaluar(Tipos_Servicio c) throws SQLException, ClassNotFoundException
    {
        return ExisteNombre(c);
    }
    public static int CapturarId(String c) throws SQLException, ClassNotFoundException
    {
        return CapturarID(c);
    }
}
