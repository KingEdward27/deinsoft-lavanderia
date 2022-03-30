package accesodatos;

import entidades.Ingresos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class IngresosADN {

    private static boolean Nuevo(Ingresos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "insert into ingresos(fecha, monto, motivo) values(?, ?, ?)";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setDate(1, ent.getFecha());
            pst.setFloat(2, ent.getMonto());
            pst.setString(3, ent.getMotivo());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Actualizar(Ingresos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update ingresos set fecha = ?, monto = ?, motivo = ? where idingreso = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setDate(1, ent.getFecha());
            pst.setFloat(2, ent.getMonto());
            pst.setString(3, ent.getMotivo());
            pst.setInt(4, ent.getIdIngreso());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Borrar(Ingresos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "delete from ingresos where idingreso = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getIdIngreso());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Apertura(Date fecha) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idingreso) from ingresos where motivo = 'Apertura' and fecha=?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setDate(1, fecha);
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }

    private static LinkedList<Ingresos> ListaIngresos(Date fecha1, Date fecha2) throws SQLException, ClassNotFoundException {
        LinkedList<Ingresos> aux = new LinkedList<>();
        String sql = "select fecha,monto,motivo from ingresos where fecha >= ? and fecha <= ? "
                + "and idventa is null and ifnull(estado,'1') = '1'";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setDate(1, fecha1);
            ps.setDate(2, fecha2);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Ingresos(rs.getDate(1), rs.getFloat(2), rs.getString(3)));
                }

            }

        }
        return aux;
    }

    private static boolean Evaluar(Date fecha) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idingreso) from ingresos where fecha=?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setDate(1, fecha);
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }

    public static LinkedList<Ingresos> Lista(Date fecha1,Date fecha2) throws SQLException, ClassNotFoundException {
        return ListaIngresos(fecha1,fecha2);
    }

    public static boolean Guardar(Ingresos i) throws ClassNotFoundException, SQLException {
        return Nuevo(i);
    }
//   public static boolean EvaluarDia(Date fecha) throws ClassNotFoundException, SQLException
//   {
//       return Evaluar(fecha);
//   }

    public static boolean EvaluarApertura(Date fecha) throws ClassNotFoundException, SQLException {
        return Apertura(fecha);
    }
}
