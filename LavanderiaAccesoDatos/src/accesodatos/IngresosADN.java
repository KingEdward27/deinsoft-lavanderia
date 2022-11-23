package accesodatos;

import entidades.Ingresos;
import entidades.Ventas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

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

    private static Ingresos findIngresoIdByVentaId(int ventaId) throws SQLException, ClassNotFoundException {
        Ingresos r = null;
        String sql = "select i.idingreso,i.monto,i.estado,ifnull(td.nombre,'') nombre from ingresos i "
                + "left join tipodoc td on td.tipodoc_id = i.tipodoc_id "
                + "where i.idventa = ? and i.flag_adelanto = '1'";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ventaId);
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    r = new Ingresos(rs.getInt(1), null, rs.getFloat(2), null, rs.getString(3), rs.getString(4));
                    
                }
            }
        }
        return r;
    }

    private static boolean flagEnvioPSE(Ingresos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update ingresos set envio_pse_flag=? , "
                + "envio_pse_mensaje = ?,num_ticket = ?,"
                + "codigoqr = ?,xmlhash =?,fecha_envio = ? "
                + "where idingreso = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getEnvioPseFlag());
            pst.setString(2, ent.getEnvioPseMensaje());
            pst.setString(3, ent.getNroRespuesta());
            pst.setString(4, ent.getCodigoQR());
            pst.setString(5, ent.getXmlHash());
            pst.setDate(6, ent.getFechaEnvio());
            pst.setInt(7, ent.getIdIngreso());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static int facturar(Ingresos i) throws ClassNotFoundException, SQLException {
        int r = 0;
        Connection cn = null;
        PreparedStatement ps = null;
        String sql;
        int ingresoId = 0;
        int index = 0;
        try {
            cn = Conexion.Conexion();
            String numeroElectronico = "";
            if (i.getTipoDoc() != null) {
                sql = "select ultimo_numero + 1 "
                        + "from numeracion_documento where "
                        + "tipodoc_id = ? and serie = ?";
                ps = cn.prepareStatement(sql);
                ps.setInt(1, i.getTipoDoc().getTipodocId());
                ps.setString(2, i.getSerieDocE());
                try (ResultSet rs2 = ps.executeQuery()) {
                    rs2.next();
                    numeroElectronico = String.valueOf(rs2.getInt(1));
                }
                sql = "update ventas set estado=?,"
                        + "descuento=?,"
                        + "recibido = ?,";
                if (i.getVenta().getA_cuenta() != null) {
                    sql = sql + "a_cuenta = ?,"
                        + "saldo = ?,";
                }
                sql = sql + "vuelto = ?,"
                        + "fecha_pago = ? "
                        + "where idventa = ?";
                ps = cn.prepareStatement(sql);
                ps.setString(++index, i.getVenta().getEstado());
                ps.setFloat(++index, i.getVenta().getDescuento());
                ps.setFloat(++index, i.getVenta().getRecibido());
                if (i.getVenta().getA_cuenta() != null) {
                    ps.setFloat(++index, i.getVenta().getA_cuenta());
                    ps.setFloat(++index, i.getVenta().getSaldo());
                }
                ps.setFloat(++index, i.getVenta().getVuelto());
                ps.setDate(++index, i.getVenta().getFechaPago());
                ps.setInt(++index, i.getVentaId());
                r = ps.executeUpdate();

                if (r > 0) {
                    if (i.getIdIngreso() == 0) {
                        sql = "insert into ingresos (monto,motivo,idventa,tipodoc_id,"
                                + "serie_doc,"
                                + "num_doc,"
                                + "cliente_id,"
                                + "estado,igv,subtotal,fecha_pago,fecha,descuento,recibido,"
                                + "tipo_operacion,detr_cuenta_bancaria,detr_porcentaje,detr_monto) "
                                + "VALUES (?,?,?,?,?,?,?,'2',?,?,?,now(),?,?,?,?,?,?) ";
                        ps = cn.prepareStatement(sql);
                        ps.setFloat(1, i.getMonto());
                        ps.setString(2, i.getMotivo());
                        ps.setInt(3, i.getVentaId());
                        ps.setInt(4, i.getTipoDoc().getTipodocId());
                        ps.setString(5, i.getSerieDocE());
                        ps.setString(6, numeroElectronico);
                        ps.setInt(7, i.getIndClienteE());
                        ps.setFloat(8, i.getIgv());
                        ps.setFloat(9, i.getSubtotal());
                        ps.setDate(10, i.getFechaPago());
                        ps.setFloat(11, i.getDescuento());
                        ps.setFloat(12, i.getRecibido());
                        
                        ps.setString(13, i.getTipoOperacion());
                        ps.setString(14, i.getDtrCuentaBancaria());
                        ps.setFloat(15, i.getDtrPorcentaje());
                        ps.setFloat(16, i.getDtrMonto());
                        
                        r = ps.executeUpdate();

                        sql = "select max(idingreso) from ingresos";
                        PreparedStatement pst = cn.prepareStatement(sql);
                        ResultSet rs = pst.executeQuery(sql);
                        rs.next();
                        ingresoId = rs.getInt(1);

                    } else {
                        sql = "update ingresos set tipodoc_id = ?,"
                                + "serie_doc = ?,"
                                + "num_doc = ?,"
                                + "cliente_id = ?,"
                                + "estado = '2',"
                                + "igv = ?,"
                                + "subtotal = ?,fecha_pago = ?,descuento = ?, recibido = ?, monto = ?,"
                                + "tipo_operacion = ?,detr_cuenta_bancaria = ?,detr_porcentaje = ?,detr_monto = ? "
                                + "where idingreso = ?";
                        ps = cn.prepareStatement(sql);
                        //                ps.setString(1, ent.getEstado());
                        //                ps.setFloat(1, ent.getDescuento());
//                        ps.setInt(1, i.getVentaId());
//                        ps.setFloat(2, i.getMonto());
//                        ps.setString(3, i.getMotivo());
                        ps.setInt(1, i.getTipoDoc().getTipodocId());
                        ps.setString(2, i.getSerieDocE());
                        ps.setString(3, numeroElectronico);
                        ps.setInt(4, i.getIndClienteE());
                        
                        ps.setFloat(5, i.getIgv());
                        ps.setFloat(6, i.getSubtotal());
                        ps.setDate(7, i.getFechaPago());
                        ps.setFloat(8, i.getDescuento());
                        ps.setFloat(9, i.getRecibido());
                        ps.setFloat(10, i.getMonto());
                        
                        ps.setString(11, i.getTipoOperacion());
                        ps.setString(12, i.getDtrCuentaBancaria());
                        ps.setFloat(13, i.getDtrPorcentaje());
                        ps.setFloat(14, i.getDtrMonto());
                        
                        ps.setInt(15, i.getIdIngreso());
                        
                        r = ps.executeUpdate();
                        ingresoId = i.getIdIngreso();
                    }

                }

                if (r > 0) {
                    sql = "update numeracion_documento set ultimo_numero = ultimo_numero + 1 where "
                            + "tipodoc_id = ? and serie = ?";
                    ps = cn.prepareStatement(sql);
                    ps.setInt(1, i.getTipoDoc().getTipodocId());
                    ps.setString(2, i.getSerieDocE());
                    r = ps.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.toString());
        } finally {
            if (cn != null) {
                cn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return ingresoId;
    }

    public static LinkedList<Ingresos> Lista(Date fecha1, Date fecha2) throws SQLException, ClassNotFoundException {
        return ListaIngresos(fecha1, fecha2);
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

    public static int generarComprobante(Ingresos i) throws ClassNotFoundException, SQLException {
        return facturar(i);
    }

    public static Ingresos getIngresoIdByVentaId(int ventaId) throws SQLException, ClassNotFoundException {
        return findIngresoIdByVentaId(ventaId);
    }

    public static boolean updateFlagEnvioPSE(Ingresos p) throws ClassNotFoundException, SQLException {
        return flagEnvioPSE(p);
    }
}
