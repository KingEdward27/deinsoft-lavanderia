package accesodatos;

import entidades.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientesADN {

    private static boolean Nuevo(Clientes ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "insert into clientes(nombres, dni, direccion, telefono, estado,correo,tipo) "
                + "values(?, ?, ?, ?, ?,?,?)";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombres());
            pst.setString(2, ent.getDni());
            pst.setString(3, ent.getDireccion());
            pst.setString(4, ent.getTelefono());
            pst.setString(5, ent.getEstado());
            pst.setString(6, ent.getCorreo());
            pst.setString(7, ent.getTipoDoc());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Actualizar(Clientes ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update clientes set nombres = ?, dni = ?, direccion = ?, telefono = ?, "
                + "estado = ?,correo = ?,tipo = ? where idcliente = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombres());
            pst.setString(2, ent.getDni());
            pst.setString(3, ent.getDireccion());
            pst.setString(4, ent.getTelefono());
            pst.setString(5, ent.getEstado());
            pst.setString(6, ent.getCorreo());
            pst.setString(7, ent.getTipoDoc());
            pst.setInt(8, ent.getIdCliente());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Estado(Clientes ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update clientes set estado=? where idcliente = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getEstado());
            pst.setInt(2, ent.getIdCliente());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Existe(Clientes ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idcliente) from clientes where idcliente = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getIdCliente());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
    private static boolean ExisteNombre(Clientes ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idcliente) from clientes where nombres = ? and idcliente <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombres());
            pst.setInt(2, ent.getIdCliente());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
    private static boolean ExisteDNI(Clientes ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idcliente) from clientes where dni = ? and idcliente <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getDni());
            pst.setInt(2, ent.getIdCliente());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
    private static int CapturaID(Clientes ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select idcliente from clientes where nombres = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombres());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r;
    }
    private static Clientes findByName(String name) throws SQLException, ClassNotFoundException {
        Clientes r = null;
        String sql = "select idcliente,nombres,trim(dni) from clientes where nombres = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, name);
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = new Clientes(rs.getInt(1), rs.getString(2), rs.getString(3), null, null, null,null,null);
            }
        }
        return r;
    }
    private static LinkedList<Clientes> ListaClientes(Clientes c) throws SQLException, ClassNotFoundException {
        LinkedList<Clientes> aux = new LinkedList<>();
        String sql = "select idcliente,nombres,dni,direccion,telefono,estado,ifnull(correo,''),ifnull(tipo,'') correo "
                + "from clientes where dni like concat(?,'%') and "
                + "nombres like concat(?,'%') and estado like ? order by nombres";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Clientes(rs.getInt(1), rs.getString(2), rs.getString(3), 
                            rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
                }
                
            }catch(SQLException ex){
                System.out.println("error: "+ex.toString());
                JOptionPane.showMessageDialog(null, ex.toString());
            }
            
        }
//        JOptionPane.showMessageDialog(null, "a"+c.getDni()+"a");
//                JOptionPane.showMessageDialog(null, "a"+c.getNombres()+"a");
//                JOptionPane.showMessageDialog(null, "a"+c.getEstado()+"a");
        return aux;
    }
private static List<String> ListaClientes_combo(Clientes c) throws SQLException, ClassNotFoundException {
        List<String> aux = new LinkedList<>();
        String sql = "select nombres from clientes where dni like concat(?,'%') and nombres like concat(?,'%') and estado like ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(rs.getString(1));
                }
                
            }
            
        }
//        JOptionPane.showMessageDialog(null, "a"+c.getDni()+"a");
//                JOptionPane.showMessageDialog(null, "a"+c.getNombres()+"a");
//                JOptionPane.showMessageDialog(null, "a"+c.getEstado()+"a");
        return aux;
    }
    public static boolean Guardar(Clientes p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(Clientes p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }
    public static int CapturaIDCliente(Clientes p) throws ClassNotFoundException, SQLException {
        return CapturaID(p);
    }

    public static LinkedList<Clientes> Lista(Clientes c) throws SQLException, ClassNotFoundException {
        return ListaClientes(c);
    }
    public static List<String> ListaCombo(Clientes c) throws SQLException, ClassNotFoundException {
        return ListaClientes_combo(c);
    }
    public static int Evaluar(Clientes c) throws SQLException, ClassNotFoundException
    {
        int est = 0;
        if (ExisteNombre(c)) {
            est=1;
        }
        return est;
    }
    public static Clientes getByName(String name) throws SQLException, ClassNotFoundException{
        return findByName(name);
    }
}
