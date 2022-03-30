package accesodatos;

import entidades.Clientes;
import entidades.Compras;
import entidades.*;
import entidades.Detalle_Compra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ComprasADN {

    private static boolean Nuevo(Compras ent) throws ClassNotFoundException, SQLException {
        int r = 0, r2 = 0, maxid = 0;
        String sql = "insert into compras(idproveedor, tipodoc, numdoc, fecha, igv, subtotal, total,estado) values(?,?,?,?,?,?,?,?)";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos
            if (ent.getIdProveedor() == 0) {
                ps.setString(1, null);
            } else {
                ps.setInt(1, ent.getIdProveedor());
            }

            ps.setString(2, ent.getTipodoc());
            ps.setString(3, ent.getNro());
            ps.setDate(4, ent.getFecha());
            ps.setFloat(5, ent.getIgv());
            ps.setFloat(6, ent.getSubtotal());
            ps.setFloat(7, ent.getTotal());
            ps.setString(8, ent.getEstado());
            r = ps.executeUpdate();
            sql = "select max(idcompra) from compras";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            rs.next();
            maxid = rs.getInt(1);
            sql = "insert into detallecompras(idcompra, idproducto, cantidad, precio, importe) values(?,?,?,?,?)";
            for (Detalle_Compra ele : ent.getLista()) {
                PreparedStatement ps2 = cn.prepareStatement(sql);
                ps2.setInt(1, maxid);
                ps2.setInt(2, ele.getIdProducto());
                ps2.setFloat(3, ele.getCantidad());
                ps2.setFloat(4, ele.getPrecio());
                ps2.setFloat(5, ele.getImporte());
                r2 = ps2.executeUpdate();
            }
        }
        return r == 1 && r2 == 1 ? true : false;
    }

    private static boolean Existe(Clientes ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "select count(idcompra) from compras where idcompra = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getIdCliente());
            // leer el valor
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }

    private static String Nro(String doc) {
        String nro = "";
        int r = 0;
        String sql = "select count(idcompra) from compras where tipodoc = ?";
        try (Connection cn = Conexion.Conexion()) {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, doc);
            ResultSet rs = pst.executeQuery();
            rs.next();
            r = rs.getInt(1);
            if (r <= 0) {
                nro = "0001";
            } else if (r > 0) {
                sql = "select numdoc from compras where idcompra = (select max(idcompra) from compras where tipodoc = ?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, doc);
                rs = pst.executeQuery();
                rs.next();
                nro = rs.getString(1);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
        }
        return nro;
    }

    private static LinkedList<ConsultaCompras> Lista(Date fec1, Date fec2,String estado) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaCompras> aux = new LinkedList<>();
        String sql = "select c.numdoc,p.razonsocial,c.fecha,c.total\n"
                + "from compras c inner join proveedores p on c.idproveedor=p.idproveedor\n"
                + "where c.fecha >=? and c.fecha<=? and c.estado like ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setDate(1, (Date) fec1);
            ps.setDate(2, fec2);
            ps.setString(3, estado);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaCompras(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getFloat(4)));
                }
            }
        }
        return aux;
    }
    private static LinkedList<ConsultaCompras> Lista2(Date fec1, Date fec2) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaCompras> aux = new LinkedList<>();
        String sql = "select c.idcompra,c.numdoc,p.razonsocial,c.fecha,c.total\n"
                + "from compras c inner join proveedores p on c.idproveedor=p.idproveedor\n"
                + "where c.fecha >=? and c.fecha<=? and c.estado like '1'";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setDate(1, (Date) fec1);
            ps.setDate(2, fec2);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaCompras(rs.getInt(1) ,rs.getString(2),rs.getString(3), rs.getDate(4), rs.getFloat(5)));
                }
            }
        }
        return aux;
    }
    private static LinkedList<ProductoDetalle> Detalle(int idcompra) throws SQLException, ClassNotFoundException {
        LinkedList<ProductoDetalle> aux = new LinkedList<>();
        String sql = "select dc.idproducto,dc.cantidad,p.descripcion,dc.precio,dc.importe\n"
                + "from detallecompras dc\n"
                + "inner join compras c on c.idcompra=dc.idcompra\n"
                + "inner join productos p on p.idproducto=dc.idproducto\n"
                + "where c.idcompra=?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setInt(1, idcompra);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ProductoDetalle(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5)));
                }
            }
        }
        return aux;
    }
    private static boolean Estado(Compras ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update compras set estado=? where idcompra = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getEstado());
            pst.setInt(2, ent.getIdCompra());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }
    public static boolean CambiarEstado(Compras p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }
    public static boolean Guardar(Compras v) throws ClassNotFoundException, SQLException {
        return Nuevo(v);
    }
    public static LinkedList<ConsultaCompras> ConsultaCompras(Date fec1, Date fec2,String estado) throws SQLException, ClassNotFoundException {
        return Lista(fec1, fec2,estado);
    }
    public static LinkedList<ConsultaCompras> ConsultaCompras2(Date fec1, Date fec2) throws SQLException, ClassNotFoundException {
        return Lista2(fec1, fec2);
    }
    public static LinkedList<ProductoDetalle> DetallCompra(int idcompra) throws SQLException, ClassNotFoundException {
        return Detalle(idcompra);
    }
}
