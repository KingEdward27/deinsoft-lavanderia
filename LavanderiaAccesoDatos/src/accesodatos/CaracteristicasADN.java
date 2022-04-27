package accesodatos;

import entidades.Categorias;
import entidades.Caracteristicas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class CaracteristicasADN {
    
       private static boolean Nuevo(Caracteristicas ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into caracteristicas(nombre, estado) values(?, ?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getEstado());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(Caracteristicas ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update caracteristicas set nombre = ?, estado = ? where idcaracteristica = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setString(2, ent.getEstado());
            pst.setInt(3, ent.getIdCaracteristicas());           
            r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   private static int CapturarID(String desc) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select idcaracteristica from caracteristicas where nombre = ?";
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
   public static int CapturarIDCaracteristica(String p) throws ClassNotFoundException, SQLException {
        return CapturarID(p);
    }
   private static boolean Estado(Caracteristicas ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update caracteristicas set estado=? where idcaracteristica = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEstado());
           pst.setInt(2, ent.getIdCaracteristicas());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(Caracteristicas ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idcaracteristica) from caracteristicas where idcaracteristica = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getIdCaracteristicas());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getInt(1);
           }
       }
       return r > 0 ? true : false;
   }
   private static boolean ExisteNombre(Caracteristicas ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idcaracteristica) from caracteristicas where nombre = ? and idcaracteristica <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setInt(2, ent.getIdCaracteristicas());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
   private static LinkedList<Caracteristicas> ListaCaracteristicas(Caracteristicas c) throws SQLException, ClassNotFoundException {
        LinkedList<Caracteristicas> aux = new LinkedList<>();
        String sql = "select idcaracteristica,nombre,estado from caracteristicas where nombre like concat(?,'%') and estado like ? order by nombre";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Caracteristicas(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
                
            }
            
        }
        return aux;
    }

    public static boolean Guardar(Caracteristicas p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(Caracteristicas p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<Caracteristicas> Lista(Caracteristicas c) throws SQLException, ClassNotFoundException {
        return ListaCaracteristicas(c);
    }
    public static boolean Evaluar(Caracteristicas c) throws SQLException, ClassNotFoundException
    {
        return ExisteNombre(c);
    }
}
