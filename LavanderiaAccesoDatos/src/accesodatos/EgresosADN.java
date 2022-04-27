package accesodatos;

import entidades.Egresos;
import entidades.Ingresos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class EgresosADN {

    private static boolean Nuevo(Egresos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "insert into egresos(fecha, monto, motivo) values(?, ?, ?)";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setDate(1, ent.getFecha());
            pst.setFloat(2, ent.getMonto());
            pst.setString(3, ent.getMotivo());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Actualizar(Egresos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update egresos set fecha = ?, monto = ?, motivo = ? where idegreso = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setDate(1, ent.getFecha());
            pst.setFloat(2, ent.getMonto());
            pst.setString(3, ent.getMotivo());
            pst.setInt(4, ent.getIdEgreso());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Borrar(Egresos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "delete from egresos where idegreso = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getIdEgreso());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Existe(Egresos ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idegreso) from egresos where idegreso = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getIdEgreso());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
    private static LinkedList<Egresos> ListaEgresos(Date fecha1,Date fecha2) throws SQLException, ClassNotFoundException {
        LinkedList<Egresos> aux = new LinkedList<>();
        String sql = "select fecha,monto,motivo from egresos where fecha >= ? and fecha <= ? and ifnull(estado,'1') <> '0'";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setDate(1,fecha1);
            ps.setDate(2,fecha2);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Egresos(rs.getDate(1), rs.getFloat(2), rs.getString(3)));
                }
                
            }
            
        }
        return aux;
    }
   public static LinkedList<Egresos> Lista(Date fecha1,Date fecha2) throws SQLException, ClassNotFoundException
   {
       return ListaEgresos(fecha1,fecha2);
   }
    public static boolean Guardar(Egresos i) throws ClassNotFoundException, SQLException {
        return Nuevo(i);
    }
}
