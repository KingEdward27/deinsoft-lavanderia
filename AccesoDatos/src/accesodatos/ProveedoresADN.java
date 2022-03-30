package accesodatos;


import entidades.Proveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class ProveedoresADN {
    
       private static boolean Nuevo(Proveedores ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into proveedores(razonsocial, ruc, direccion, telefono, estado) values(?, ?, ?, ?, ?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
           pst.setString(1, ent.getRaz());
           pst.setString(2, ent.getRuc());
           pst.setString(3, ent.getDir());
           pst.setString(4, ent.getTelef());
           pst.setString(5, ent.getEst());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Actualizar(Proveedores ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "update proveedores set razonsocial = ?, ruc = ?, direccion = ?, telefono = ?, estado = ? where idproveedor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getRaz());
           pst.setString(2, ent.getRuc());
           pst.setString(3, ent.getDir());
           pst.setString(4, ent.getTelef());
           pst.setString(5, ent.getEst());
           pst.setInt(6, ent.getIdProveedor());           
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Estado(Proveedores ent) throws ClassNotFoundException, SQLException{
       int r = 0;
       String sql = "update proveedores set estado=? where idproveedor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setString(1, ent.getEst());
           pst.setInt(2, ent.getIdProveedor());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static boolean Existe(Proveedores ent) throws SQLException, ClassNotFoundException{
       int r = 0;
       String sql = "select count(idproveedor) from proveedores where idproveedor = ?";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)) {
           pst.setInt(1, ent.getIdProveedor());
           // leer el siguiente valor:
           try(ResultSet rs = pst.executeQuery()) {
               rs.next();
               r = rs.getInt(1);
           }
       }
       return r > 0 ? true : false;
   }
   private static boolean ExisteNombre(Proveedores ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idproveedor) from proveedores where razonsocial = ? and idproveedor <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getRaz());
            pst.setInt(2, ent.getIdProveedor());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
    private static boolean ExisteDNI(Proveedores ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idproveedor) from proveedores where ruc = ? and idproveedor <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getRuc());
            pst.setInt(2, ent.getIdProveedor());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
   private static LinkedList<Proveedores> ListaProveedores(Proveedores c) throws SQLException, ClassNotFoundException {
        LinkedList<Proveedores> aux = new LinkedList<>();
        String sql = "select idproveedor,razonsocial,ruc,direccion,telefono,estado from proveedores where ruc like concat(?,'%') and razonsocial like concat(?,'%') and estado like ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getRuc());
            ps.setString(2, c.getRaz());
            ps.setString(3, c.getEst());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Proveedores(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
                }
                
            }
            
        }
//        JOptionPane.showMessageDialog(null, "a"+c.getDni()+"a");
//                JOptionPane.showMessageDialog(null, "a"+c.getNombres()+"a");
//                JOptionPane.showMessageDialog(null, "a"+c.getEstado()+"a");
        return aux;
    }

    public static boolean Guardar(Proveedores p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(Proveedores p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static LinkedList<Proveedores> Lista(Proveedores c) throws SQLException, ClassNotFoundException {
        return ListaProveedores(c);
    }
    public static int Evaluar(Proveedores c) throws SQLException, ClassNotFoundException
    {
        int est = 0;
        if (ExisteNombre(c)&& ExisteDNI(c)==false) {
            est=1;
        }
        else if (ExisteDNI(c)&& ExisteNombre(c)==false) {
            est=2;
        }
        else if(ExisteDNI(c) && ExisteNombre(c))
        {
            est=3;
        }
        return est;
    }
}
