package accesodatos;

import entidades.Categorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class CategoriasADN {
    
       private static boolean Nuevo(Categorias ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into categorias(nombre, estado) values(?, ?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
           pst.setString(1, ent.getNom());
           pst.setString(2, ent.getEstado());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(Categorias ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update categorias set nombre = ?, estado = ? where idcategoria = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNom());
            pst.setString(2, ent.getEstado());
            pst.setInt(3, ent.getIdcategoria());           
            r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Estado(Categorias ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update categorias set estado=? where idcategoria = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEstado());
           pst.setInt(2, ent.getIdcategoria());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(Categorias ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idcategoria) from categorias where idcategoria = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getIdcategoria());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getInt(1);
           }
       }
       return r > 0 ? true : false;
   }
   private static boolean ExisteNombre(Categorias ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idcategoria) from Categorias where nombre = ? and idcategoria <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNom());
            pst.setInt(2, ent.getIdcategoria());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
   private static LinkedList<Categorias> ListaCategorias(Categorias c) throws SQLException, ClassNotFoundException {
        LinkedList<Categorias> aux = new LinkedList<>();
        String sql = "select idcategoria,nombre,estado from categorias where nombre like concat(?,'%') and estado like ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getNom());
            ps.setString(2, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Categorias(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
                
            }
            
        }
        return aux;
    }

    public static boolean Guardar(Categorias p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(Categorias p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<Categorias> Lista(Categorias c) throws SQLException, ClassNotFoundException {
        return ListaCategorias(c);
    }
    public static boolean Evaluar(Categorias c) throws SQLException, ClassNotFoundException
    {
        return ExisteNombre(c);
    }
}
