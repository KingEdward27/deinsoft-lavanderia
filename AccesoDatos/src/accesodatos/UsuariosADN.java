package accesodatos;

import entidades.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;


public class UsuariosADN {
    
    private static boolean Nuevo(Usuarios ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into usuarios(nombre, clave, tipo, estado) values(?, ?, ?, ?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getClave());
           pst.setString(3, ent.getTipo());
           pst.setString(4, ent.getEstado());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(Usuarios ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update usuarios set nombre = ?, clave = ?, tipo = ? where idusuario = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getClave());
           pst.setString(3, ent.getTipo());
           pst.setInt(4, ent.getIdUsuarios());           
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Estado(Usuarios ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update usuarios set estado=? where idusuario = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEstado());
           pst.setInt(2, ent.getIdUsuarios());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(Usuarios ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idusuario) from usuarios where idusuario = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getIdUsuarios());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getInt(1);
           }
       }
       return r > 0 ? true : false;
   }
   private static boolean ExisteNombre(Usuarios ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idusuario) from usuarios where nombre = ? and idusuario <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre());
            pst.setInt(2, ent.getIdUsuarios());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
//    public static boolean ExisteDNI(Usuarios ent) throws SQLException, ClassNotFoundException {
//        int r = 0;
//        String sql = "select count(idusuario) from usuarios where clave = ? and idusuario <> ?";
//        try (Connection cn = Conexion.Conexion();
//                PreparedStatement pst = cn.prepareStatement(sql)) {
//            pst.setString(1, ent.getClave());
//            pst.setInt(2, ent.getIdUsuarios());
//            // leer el siguiente valor:
//            try (ResultSet rs = pst.executeQuery()) {
//                rs.next();
//                r = rs.getInt(1);
//            }
//        }
//        return r > 0 ? true : false;
//    }
   private static LinkedList<Usuarios> ListaUsuarios(Usuarios c) throws SQLException, ClassNotFoundException {
        LinkedList<Usuarios> aux = new LinkedList<>();
        String sql = "select idusuario, nombre, tipo, estado,clave from usuarios where nombre like concat(?,'%') and estado like ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                }                
            }            
        }
        return aux;
    }
    private static boolean Validar(Usuarios ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idusuario) from usuarios where nombre = ? and clave=?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getClave());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getInt(1);
           }
       }
       return r > 0 ? true : false;
   }
    private static String Validar2(Usuarios ent) throws SQLException, ClassNotFoundException{
       String r = "";
       String sql = "select tipo from usuarios where nombre = ? and clave=?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getNombre());
           pst.setString(2, ent.getClave());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getString(1);
           }
       }
       return r;
   } 
   public static boolean Guardar(Usuarios p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            if (ExisteNombre(p)) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
                return false;
            }else{
            return Nuevo(p);
            }
        }
    }

    public static boolean CambiarEstado(Usuarios p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<Usuarios> Lista(Usuarios c) throws SQLException, ClassNotFoundException {
        return ListaUsuarios(c);
    }
    public static boolean ValidarSesion(Usuarios ent) throws SQLException, ClassNotFoundException{    
        return Validar(ent);
    }
    public static String ObtenerTipo(Usuarios ent) throws SQLException, ClassNotFoundException{    
        return Validar2(ent);
    }
}


    

