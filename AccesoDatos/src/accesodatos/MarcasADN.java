package accesodatos;

import entidades.Categorias;
import entidades.Marcas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class MarcasADN {
    
       private static boolean Nuevo(Marcas ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into marcas(nombre, estado) values(?, ?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getEstado());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(Marcas ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update marcas set nombre = ?, estado = ? where idmarca = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setString(2, ent.getEstado());
            pst.setInt(3, ent.getIdMarcas());           
            r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Estado(Marcas ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update marcas set estado=? where idmarca = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEstado());
           pst.setInt(2, ent.getIdMarcas());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(Marcas ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idmarca) from marcas where idmarca = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getIdMarcas());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getInt(1);
           }
       }
       return r > 0 ? true : false;
   }
   private static boolean ExisteNombre(Marcas ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idmarca) from marcas where nombre = ? and idmarca <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setInt(2, ent.getIdMarcas());
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
        String sql = "select idmarca from marcas where nombre = ?";
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
   public static int CapturarIDMarca(String p) throws ClassNotFoundException, SQLException {
        return CapturarID(p);
    }
   private static LinkedList<Marcas> ListaMarcas(Marcas c) throws SQLException, ClassNotFoundException {
        LinkedList<Marcas> aux = new LinkedList<>();
        String sql = "select idmarca,nombre,estado from marcas where nombre like concat(?,'%') and estado like ? order by nombre";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Marcas(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
                
            }
            
        }
        return aux;
    }

    public static boolean Guardar(Marcas p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(Marcas p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<Marcas> Lista(Marcas c) throws SQLException, ClassNotFoundException {
        return ListaMarcas(c);
    }
    public static boolean Evaluar(Marcas c) throws SQLException, ClassNotFoundException
    {
        return ExisteNombre(c);
    }
}
