package accesodatos;

import entidades.Clientes;
import entidades.Detalle_Venta;
import entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class VentasADN {

    private static int Nuevo(Ventas ent) throws ClassNotFoundException, SQLException {
        int r = 0, r2 = 0, maxid = 0;
        boolean result = false;
        Connection cn = null;
        PreparedStatement ps = null;
        String sql;
        try {//manejador de recursos
            cn = Conexion.Conexion();

//            sql = "select ultimo_numero + 1 "
//                    + "from numeracion_documento where "
//                    + "tipodoc_id = ? and serie = ?";
//            ps = cn.prepareStatement(sql);
//            ps.setInt(1, ent.getTipoDoc().getTipodocId());
//            ps.setString(2, ent.getSerieDocE());
//            String numeroElectronico = "", serie = "";
//            try (ResultSet rs2 = ps.executeQuery()) {
//                rs2.next();
//                numeroElectronico = String.valueOf(rs2.getInt(1));
//            }
            sql = "insert into ventas(idcliente, tipodoc, seriedoc, numdoc, fecha,hora, igv, subtotal, "
                    + "total,idusuario,estado,tipo_pago,idtiposervicio,fecha_entrega,"
                    + "fecha_reg,a_cuenta,descuento,tipodoc_id,envio_pse_flag,envio_pse_mensaje,serieDocE,numDocE) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,?,null,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            if (ent.getIdcliente() == 0) {
                ps.setString(1, null);
            } else if (ent.getIdcliente() > 0) {
                ps.setInt(1, ent.getIdcliente());
            }
            ps.setString(2, "TICKET");
            ps.setString(3, ent.getSerie());
            ps.setString(4, ent.getNro());
            ps.setDate(5, ent.getFecha());
            ps.setString(6, ent.getHora());
            ps.setFloat(7, ent.getIgv());
            ps.setFloat(8, ent.getSubtotal());
            ps.setFloat(9, ent.getTotal());
            ps.setInt(10, ent.getIdusuario());
            ps.setString(11, ent.getEstado());
//            cn.setAutoCommit(false);
            ps.setString(12, ent.getTipo_pago());
            ps.setInt(13, ent.getIdtiposervicio());
            ps.setString(14, ent.getStrfecha_Entrega());
            ps.setFloat(15, ent.getA_cuenta());
            ps.setFloat(16, ent.getDescuento());
//            ps.setInt(17, 0);
            ps.setString(17, null);
            ps.setString(18, null);
//            if (!ent.getTipo_pago().equals("POR PAGAR")) {
//                ps.setString(19, ent.getSerieDocE());
//                ps.setString(20, numeroElectronico);
//            } else {
            ps.setString(19, null);
            ps.setString(20, null);
//            }

            r = ps.executeUpdate();

            sql = "select max(idventa) from ventas";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            rs.next();
            maxid = rs.getInt(1);

            for (Detalle_Venta ele : ent.getLista()) {
                sql = "insert into detalleventas(idventa, idproducto, cantidad, precio,descuento,"
                        + " importe,descripcion_producto,idmarca,idcolor,idcaracteristica,afectacion_igv) "
                        + "values(?,?,?,?,?,?,?,(case " + ele.getIdmarca() + " when 0 then null else " + ele.getIdmarca() + " end),"
                        + "                     (case " + ele.getIdcolor() + " when 0 then null else " + ele.getIdcolor() + " end),"
                        + "                     (case " + ele.getIdcaracteristica() + " when 0 then null else " + ele.getIdcaracteristica() + " end),"
                        + "?)";
                PreparedStatement ps2 = cn.prepareStatement(sql);
                ps2.setInt(1, maxid);
                ps2.setInt(2, ele.getIdProducto());
                ps2.setFloat(3, ele.getCantidad());
                ps2.setFloat(4, ele.getPrecio());
                ps2.setFloat(5, ele.getDescuento());
                ps2.setFloat(6, ele.getImporte());
                ps2.setString(7, ele.getDescripcion_producto());
                ps2.setFloat(8, ele.getAfectacionIgv());
                r2 = ps2.executeUpdate();
            }

            if (r == 1 && r2 == 1) {
//                if(ent.getA_cuenta() > 0){
//                    String numeroElectronico = "";
//                    if (i.getTipoDoc() != null) {
//                        sql = "select ultimo_numero + 1 "
//                                + "from numeracion_documento where "
//                                + "tipodoc_id = ? and serie = ?";
//                        ps = cn.prepareStatement(sql);
//                        ps.setInt(1, i.getTipoDoc().getTipodocId());
//                        ps.setString(2, i.getSerieDocE());
//                        try (ResultSet rs2 = ps.executeQuery()) {
//                            rs2.next();
//                            numeroElectronico = String.valueOf(rs2.getInt(1));
//                        }
//                    }
//                    sql = "insert into ingresos(idventa, fecha, monto, motivo, tipodoc_id,"
//                            + "serie_doc,num_doc,cliente_id,estado) "
//                            + "values(?, now(), ?,?,?,?,?,?,'1')";
//                    ps = cn.prepareStatement(sql);
//                    ps.setInt(1, ent.getIdventa());
//                    ps.setFloat(2, i.getMonto());
//                    ps.setString(3, i.getMotivo());
//                    ps.setInt(4, i.getTipoDoc().getTipodocId());
//                    ps.setString(5, i.getSerieDocE());
//                    ps.setString(6, numeroElectronico);
//                    ps.setInt(7, i.getIndClienteE());
//                    r = ps.executeUpdate();
//                    
//                    if (r > 0) {
//                        sql = "update numeracion_documento set ultimo_numero = ultimo_numero + 1 where "
//                                + "tipodoc_id = ? and serie = ?";
//                        ps = cn.prepareStatement(sql);
//                        ps.setInt(1, i.getTipoDoc().getTipodocId());
//                        ps.setString(2, i.getSerieDocE());
//                        r = ps.executeUpdate();
//                    }
//                    sql = "select max(idventa) from ventas";
//                    pst = cn.prepareStatement(sql);
//                    rs = pst.executeQuery(sql);
//                    rs.next();
//                    maxid = rs.getInt(1);
//                }

                sql = "update parametros set num_venta = num_venta+1";
                PreparedStatement ps3 = cn.prepareStatement(sql);
                r2 = ps3.executeUpdate();
            }
//            cn.commit();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + ex.toString());
        } finally {
            if (cn != null) {
                cn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return r == 1 && r2 == 1 ? maxid : 0;
    }

    

    private static boolean entregar(Ventas ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        Connection cn = null;
        PreparedStatement ps = null;
        String sql;
        try {
            cn = Conexion.Conexion();
            sql = "update ventas set estado=2,"
                    + "fecha_entrega = date_format(now(),'%d/%m/%Y %H:%i') "
                    + "where idventa = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, ent.getIdventa());
            r = ps.executeUpdate();
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

        return r == 1 ? true : false;
    }

//    private static boolean flagEnvioPSE(Ventas ent) throws ClassNotFoundException, SQLException {
//        int r = 0;
//        String sql = "update ventas set envio_pse_flag=? , "
//                + "envio_pse_mensaje = ?,num_ticket = ?,"
//                + "codigoqr = ?,xmlhash =? "
//                + "where idventa = ?";
//        try (Connection cn = Conexion.Conexion();
//                PreparedStatement pst = cn.prepareStatement(sql)) {
//            pst.setString(1, ent.getEnvioPseFlag());
//            pst.setString(2, ent.getEnvioPseMensaje());
//            pst.setString(3, ent.getNroRespuesta());
//            pst.setString(4, ent.getCodigoQR());
//            pst.setString(5, ent.getXmlHash());
//            pst.setInt(6, ent.getIdventa());
//            r = pst.executeUpdate();
//        }
//        return r == 1 ? true : false;
//    }

    private static boolean Existe(Clientes ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "select count(idventa) from ventas where idventa = ?";
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

    private static String Serie(String doc) {
        String serie = "";
        int r = 0;
        String sql = "select count(idventa) from ventas where tipodoc = ?";
        try (Connection cn = Conexion.Conexion()) {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, doc);
            ResultSet rs = pst.executeQuery();
            rs.next();
            r = rs.getInt(1);
            if (r <= 0) {
                serie = "001";
            } else if (r > 0) {
                sql = "select seriedoc from ventas where idventa = (select max(idventa) from ventas where tipodoc = ?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, doc);
                rs = pst.executeQuery();
                rs.next();
                serie = rs.getString(1);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
        }
        return serie;
    }

    private static String Nro(String doc) {
        String nro = "";
        int r = 0;
        String sql = "select count(idventa) from ventas where tipodoc = ?";
        try (Connection cn = Conexion.Conexion()) {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, doc);
            ResultSet rs = pst.executeQuery();
            rs.next();
            r = rs.getInt(1);
            if (r <= 0) {
                nro = "0001";
            } else if (r > 0) {
                sql = "select ifnull(num_venta,0) + 1 from parametros";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                rs.next();
                nro = rs.getString(1);
//                nro = String.format("%04d", Integer.parseInt(nro) + 1);

            }
            rs.close();
            pst.close();
        } catch (Exception e) {
        }
        return nro;
    }

    public static String fecha_hora() {
        String r = "";
        String sql = "select now()";
        try (Connection cn = Conexion.Conexion()) {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            r = rs.getString(1);
            rs.close();
            pst.close();
        } catch (Exception e) {
        }
        return r;
    }

    public static boolean ExisteNro(String nro) {
        int r = 0;
        String sql = "select count(*) from ventas where numdoc = ? and estado in ('p','1')";
        try (Connection cn = Conexion.Conexion()) {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            pst.setString(1, nro);
            rs.next();
            r = rs.getInt(1);
            rs.close();
            pst.close();
        } catch (Exception e) {
        }
        return r > 0 ? true : false;
    }

    private static LinkedList<ConsultaVentas> Lista(Date fec1, Date fec2, String estado, String cliente, int tipoFecha) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaVentas> aux = new LinkedList<>();
        String sql = "select concat(v.seriedoc,'-',v.numdoc) numdoc,v.tipo_pago,ts.descripcion,cli.nombres,v.fecha,"
                + "(CASE v.estado when '1' then 'PAGADO Y POR ENTREGAR' "
                + "                   when '2' then 'PAGADO Y ENTREGADO' "
                + "                   when '0' then 'ANULADO' else 'POR ENTREGAR' end) estado,\n"
                + "v.descuento,v.total\n"
                + "from ventas v inner join clientes cli on v.idcliente=cli.idcliente\n"
                + "              inner join tipos_servicio ts on v.idtiposervicio = ts.idtiposervicio\n";
                if(tipoFecha == 0){
                    sql = sql + "where v.fecha >=? and v.fecha<=? ";
                }
                if(tipoFecha == 1){
                    sql = sql + "where v.fecha_pago >=? and v.fecha_pago<=? ";
                }
                if(tipoFecha == 2){
                    sql = sql + "where STR_TO_DATE(substr( fecha_entrega,1,10),'%d/%m/%Y') >=? and "
                            + "STR_TO_DATE(substr( fecha_entrega,1,10),'%d/%m/%Y') <=? and v.estado = '2' ";
                }
                sql = sql + "and cli.nombres like ? and ("
                + "                                         ('" + estado + "' = 't' and v.estado in ('p','1','2')) or \n"
                + "                                         ('" + estado + "' = '0' and v.estado in ('0')) or \n"
                + "                                         ('" + estado + "' = '1' and v.estado in ('1')) or \n"
                + "                                         ('" + estado + "' = '2' and v.estado in ('2')) or \n"
                + "                                         ('" + estado + "' = 'p' and v.estado in ('p')) \n"
                + "                                      ) and\n"
                + "ifnull(STR_TO_DATE(v.fecha_entrega,'%d/%m/%Y %H:%i'),'-')  <> '-' order by v.numdoc desc";
        System.out.println("sql: " + sql);
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setDate(1, (Date) fec1);
            ps.setDate(2, fec2);
            ps.setString(3, cliente);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaVentas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getFloat(7), rs.getFloat(8)));
                }
            }
        }
        return aux;
    }

    private static LinkedList<ConsultaVentas> ListaTC(Date fec1, Date fec2, String estado) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaVentas> aux = new LinkedList<>();
        String sql
                = //                "select v.seriedoc,v.numdoc,cli.nombres,v.fecha, (case when v.estado = 'p' and ifnull(a_cuenta,0) > 0 then v.a_cuenta else (v.total - ifnull(v.descuento,0))  end) ,"
                //                + "(case v.estado when '1' then 'ENTREGADO' when '0' then 'ANULADO' else 'POR ENTREGAR' end) estado\n" +
                //                    "from ventas v inner join clientes cli on v.idcliente=cli.idcliente\n" +
                //                    "              inner join tipos_servicio ts on v.idtiposervicio = ts.idtiposervicio\n" +
                //                    "        where v.fecha >=? and v.fecha<=?   \n" +
                //                    "                                    and  (                                         \n" +
                //                    "                                         ('1' = 't' and v.estado in ('p','1')) or \n" +
                //                    "                                         ('1' = '0' and v.estado in ('0')) or \n" +
                //                    "                                         ('1' = '1' and (v.estado in ('1') or (tipo_pago = 'EFECTIVO' and v.estado in ('p')))) or \n" +
                //                    "                                         ('1' = 'p' and v.estado in ('p')) \n" +
                //                    "                                      ) and\n" +
                //                    "ifnull(STR_TO_DATE(v.fecha_entrega,'%d/%m/%Y %H:%i'),'-')  <> '-'\n" +
                //                    "and not exists (select * from ingresos s where s.idventa = v.idventa)\n" +
                //                    "union\n" +
                "select v.seriedoc,v.numdoc,cli.nombres,s.fecha, s.monto  ,"
                + "(CASE v.estado when '1' then 'PAGADO Y POR ENTREGAR' "
                + "                   when '2' then 'PAGADO Y ENTREGADO' "
                + "                   when '0' then 'ANULADO' else 'POR ENTREGAR' end) estado\n"
                + "from ventas v inner join clientes cli on v.idcliente=cli.idcliente\n"
                + "              inner join tipos_servicio ts on v.idtiposervicio = ts.idtiposervicio\n"
                + "inner join ingresos s on v.idventa = s.idventa where s.fecha >=? and s.fecha<=? \n"
                + "                                    and  (                                         \n"
                + "                                         ('" + estado + "' = 't' and v.estado in ('p','1','2')) or \n"
                + "                                         ('" + estado + "' = '0' and v.estado in ('0')) or \n"
                + "                                         ('" + estado + "' = '1' and (v.estado in ('p','1','2') or (tipo_pago <> 'POR PAGAR' and v.estado in ('p')))) or \n"
                + "                                         ('" + estado + "' = 'p' and v.estado in ('p')) \n"
                + "                                      ) and\n"
                + "ifnull(STR_TO_DATE(v.fecha_entrega,'%d/%m/%Y %H:%i'),'-')  <> '-'";
        System.out.println("sql: " + sql);
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setDate(1, (Date) fec1);
            ps.setDate(2, fec2);
//            ps.setDate(3, (Date) fec1);
//            ps.setDate(4, fec2);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaVentas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getFloat(5), rs.getString(6)));
                }
            }
        }
        return aux;
    }

    private static LinkedList<ConsultaVentas> Lista2(Date fec1, Date fec2, String est) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaVentas> aux = new LinkedList<>();
        String sql = "select v.idventa,v.seriedoc,v.numdoc,cli.nombres,v.fecha,u.nombre,v.total\n"
                + "from ventas v inner join clientes cli on v.idcliente=cli.idcliente\n"
                + "inner join usuarios u on u.idusuario=v.idusuario "
                + "where v.fecha >=? and v.fecha<=? and v.estado like ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setDate(1, (Date) fec1);
            ps.setDate(2, fec2);
            ps.setString(3, est);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaVentas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getFloat(7)));
                }
            }
        }
        return aux;
    }

    private static LinkedList<ConsultaVentas> Lista_productos(String marca, String color, String caracteristica) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaVentas> aux = new LinkedList<>();
        String sql = "select  concat(v.seriedoc,'-',v.numdoc) numdoc,v.fecha,str_to_date(v.fecha_entrega,'%d/%m/%Y %H:%i') fec_entrega,cantidad,ifnull(descripcion_producto,''),dv.precio \n"
                + "from ventas v inner join detalleventas dv on v.idventa = dv.idventa\n"
                + "inner join clientes ce on v.idcliente = ce.idcliente\n"
                + "left join marcas m on dv.idmarca = m.idmarca\n"
                + "left join colores c on dv.idcolor = c.idcolor\n"
                + "left join caracteristicas ca on dv.idcaracteristica = ca.idcaracteristica\n"
                + "where ifnull(m.nombre,'') like ? and ifnull(c.nombre,'') like ? and ifnull(ca.nombre,'') like ? "
                + "and v.estado in ('p','1') \n"
                + "and ifnull(STR_TO_DATE(v.fecha_entrega,'%d/%m/%Y %H:%i'),'-')  <> '-'  order by fec_entrega desc,numdoc desc";
        System.out.println("sql Lista_productos: " + sql);
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, marca);
            ps.setString(2, color);
            ps.setString(3, caracteristica);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaVentas(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getFloat(6)));
                }
            }
        }
        return aux;
    }

    private static LinkedList<ConsultaVentas> ListaPendiente(String numdoc) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaVentas> aux = new LinkedList<>();
        String sql = "select v.idventa,c.nombres,v.tipodoc,v.seriedoc,v.numdoc,v.fecha,ifnull(v.hora,'00:00'),v.igv,v.subtotal,u.nombre,v.total ,"
                + "         v.tipo_pago,ts.descripcion,ifnull(fecha_entrega,''),"
                + "v.estado estado,"
                + "ifnull(a_cuenta,0),ifnull(descuento,0),c.dni \n"
                + "from ventas v \n"
                + "inner join usuarios u on u.idusuario=v.idusuario\n"
                + "inner join clientes c on c.idcliente=v.idcliente\n"
                + "inner join tipos_servicio ts on ts.idtiposervicio = v.idtiposervicio\n"
                + "where v.numdoc = ? \n"
                + "order by v.fecha,v.hora";
        System.out.println("sql Lista pendientes: " + sql);
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, numdoc);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaVentas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7),
                            rs.getFloat(8), rs.getFloat(9), rs.getString(10), rs.getFloat(11),
                            rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                            rs.getFloat(16), rs.getFloat(17), rs.getString(18)));
                }
            }
        }
        return aux;
    }

    private static LinkedList<ProductoDetalle> Detalle(int idventa) throws SQLException, ClassNotFoundException {
        LinkedList<ProductoDetalle> aux = new LinkedList<>();
        String sql = "select dv.idproducto,dv.cantidad,ifnull(dv.descripcion_producto,'') descripcion_producto,dv.precio,dv.importe \n"
                + "from detalleventas dv\n"
                + "inner join ventas v on v.idventa=dv.idventa\n"
                + "inner join productos p on p.idproducto=dv.idproducto\n"
                + "where v.idventa=?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setInt(1, idventa);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ProductoDetalle(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5)));
                }
            }
        }
        return aux;
    }

    private static LinkedList<ConsultaVentas2> datosVentaPre(Date fecIni, Date fecFin, int idVenta) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaVentas2> aux = new LinkedList<>();
        String sql = "select v.idventa,v.seriedoc,v.numdoc,\n"
                + "trim(concat(ifnull(cli.nombres,''))) cliente,\n"
                + "v.fecha,\n"
                + "v.total-ifnull(v.descuento,0) importe,\n"
                + "ifnull(v.tipo_pago,'Contado') forma_pago,\n"
                + "case when cli.dni= '11111111' then '00000000' \n"
                + "else cli.dni end nrodocumento,\n"
                + "cli.direccion,\n"
                + "f_descripcion_monto(v.total-ifnull(v.descuento,0),'SOLES') descripcion_monto,\n"
                + "ifnull(v.descuento,0) descuento ,\n"
                + "'10' tipo_igv,\n"
                + "cli.tipo,\n"
                + "ifnull(cli.correo,''),\n"
                + "ifnull(v.codigoqr,''),\n"
                + "ifnull(v.xmlhash,''),\n"
                + "td.tipodoc_id,td.nombre,td.value,\n"
                + "ts.idtiposervicio,ts.descripcion,v.igv,ifnull(serieDocE,'') serieDocE,"
                + "ifnull(numDocE,0) numDocE, ifnull(fecha_entrega,'') fecha_entrega,"
                + "ifnull(envio_pse_flag,'') envio_pse_flag, ifnull(envio_pse_mensaje,'') envio_pse_mensaje,\n"
                + "ifnull(v.a_cuenta,0) a_cuenta,"
                + "ifnull(v.recibido,0) recibido,"
                + "ifnull(v.vuelto,0) vuelto "
                + "from ventas v \n"
                + "inner join clientes cli on v.idcliente=cli.idcliente\n"
                + "left join tipodoc td on td.tipodoc_id = v.tipodoc_id\n"
                + "inner join tipos_servicio ts on ts.idtiposervicio = v.idtiposervicio "
                + "where ((? = 0 and "
                + "         v.fecha between ? and ? and v.estado = '1' and td.value <> '00') or (v.idventa  = ?)) "
                + "order by v.idventa desc";
        System.out.println("VentasADN/datosVenta/sql:" + sql);
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setInt(1, idVenta);
            ps.setDate(2, fecIni);
            ps.setDate(3, fecFin);
            ps.setInt(4, idVenta);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaVentas2(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getDate(5),
                            rs.getFloat(6), rs.getString(7),
                            rs.getString(8), rs.getString(9), rs.getString(10), rs.getFloat(11),
                            rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                            rs.getString(16), new TipoDoc(rs.getInt(17), rs.getString(18), rs.getString(19), null),
                            new Tipos_Servicio(rs.getInt(20), rs.getString(21), null), rs.getFloat(22),
                            rs.getString(23), rs.getInt(24),
                            rs.getString(25), rs.getString(26), rs.getString(27),rs.getFloat(28),rs.getFloat(29),
                            rs.getFloat(30),null,0,null,null,0,null,""));
                }
            }
        }
        return aux;
    }
    private static LinkedList<ConsultaVentas2> datosVentaPreE(Date fecIni, Date fecFin, int idVenta) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaVentas2> aux = new LinkedList<>();
        String sql = "select v.idventa,v.seriedoc,v.numdoc,\n"
                + "trim(concat(ifnull(cli.nombres,''))) cliente,\n"
                + "v.fecha_pago,\n"
                + "v.total-ifnull(v.descuento,0) importe,\n"
                + "ifnull(v.tipo_pago,'Contado') forma_pago,\n"
                + "case when cli.dni= '11111111' then '00000000' \n"
                + "else cli.dni end nrodocumento,\n"
                + "cli.direccion,\n"
                + "f_descripcion_monto(v.total-ifnull(v.descuento,0),'SOLES') descripcion_monto,\n"
                + "ifnull(v.descuento,0) descuento ,\n"
                + "'10' tipo_igv,\n"
                + "cli.tipo,\n"
                + "ifnull(cli.correo,''),\n"
                + "ifnull(v.codigoqr,''),\n"
                + "ifnull(v.xmlhash,''),\n"
                + "td.tipodoc_id,td.nombre,td.value,\n"
                + "ts.idtiposervicio,ts.descripcion,v.igv,ifnull(serieDocE,'') serieDocE,"
                + "ifnull(numDocE,0) numDocE, "
                + "case when v.estado = '2' then ifnull(v.fecha_entrega,'') else '' end fecha_entrega,"
                + "ifnull(envio_pse_flag,'') envio_pse_flag, ifnull(envio_pse_mensaje,'') envio_pse_mensaje,\n"
                + "ifnull(v.a_cuenta,0) a_cuenta,"
                + "ifnull(v.recibido,0) recibido,"
                + "ifnull(v.vuelto,0) vuelto,'v' tipo,v.idventa idVenta "
                + "from ventas v \n"
                + "inner join clientes cli on v.clienteE_ID=cli.idcliente\n"
                + "left join tipodoc td on td.tipodoc_id = v.tipodoc_id\n"
                + "inner join tipos_servicio ts on ts.idtiposervicio = v.idtiposervicio "
                + "where ((? = 0 and "
                + "         v.fecha_pago between ? and ? and v.estado in ('1','2') and td.value <> '00') or (v.idventa  = ?)) "
                + "order by v.numdocE desc";
        System.out.println("VentasADN/datosVenta/sql:" + sql);
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setInt(1, idVenta);
            ps.setDate(2, fecIni);
            ps.setDate(3, fecFin);
            ps.setInt(4, idVenta);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaVentas2(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getDate(5),
                            rs.getFloat(6), rs.getString(7),
                            rs.getString(8), rs.getString(9), rs.getString(10), rs.getFloat(11),
                            rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                            rs.getString(16), new TipoDoc(rs.getInt(17), rs.getString(18), rs.getString(19), null),
                            new Tipos_Servicio(rs.getInt(20), rs.getString(21), null), rs.getFloat(22),
                            rs.getString(23), rs.getInt(24),
                            rs.getString(25), rs.getString(26), rs.getString(27),rs.getFloat(28),rs.getFloat(29),
                            rs.getFloat(30), rs.getString(31), rs.getInt(32),null,null,0,null,""));
                }
            }
        }
        return aux;
    }
    private static LinkedList<ConsultaVentas2> datosVentaPre2E(Date fecIni, Date fecFin, int idVenta) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaVentas2> aux = new LinkedList<>();
        String sql = "select distinct i.idingreso,v.seriedoc,v.numdoc,\n" +
                    "trim(concat(ifnull(cli.nombres,''))) cliente,\n" +
                    "i.fecha_pago,\n" +
                    "i.monto-ifnull(i.descuento,0) importe,\n" +
                    "ifnull(v.tipo_pago,'Contado') forma_pago,\n" +
                    "case when cli.dni= '11111111' then '00000000' \n" +
                    "else cli.dni end nrodocumento,\n" +
                    "cli.direccion,\n" +
                    "f_descripcion_monto(i.monto-ifnull(i.descuento,0),'SOLES') descripcion_monto,\n" +
                    "ifnull(i.descuento,0) descuento ,\n" +
                    "'10' tipo_igv,\n" +
                    "cli.tipo,\n" +
                    "ifnull(cli.correo,''),\n" +
                    "ifnull(i.codigoqr,''),\n" +
                    "ifnull(i.xmlhash,''),\n" +
                    "td.tipodoc_id,td.nombre,td.value,\n" +
                    "ts.idtiposervicio,ts.descripcion,\n" +
                    "i.igv,ifnull(i.serie_doc,'') serieDocE,\n" +
                    "ifnull(i.num_doc,0) numDocE, \n" +
                    "case when v.estado = '2' then ifnull(v.fecha_entrega,'') else '' end fecha_entrega,\n" +
                    "ifnull(i.envio_pse_flag,'') envio_pse_flag, \n" +
                    "ifnull(i.envio_pse_mensaje,'') envio_pse_mensaje,\n" +
                    "0 a_cuenta,\n" +
                    "ifnull(i.recibido,i.monto) recibido,\n" +
                    "ifnull(i.recibido,i.monto) - i.monto  vuelto,'i' tipo,v.idventa idVenta,"+ 
                    "ifnull(i2.serie_doc,''),ifnull(i2.num_doc,''),ifnull(i2.monto,''),ifnull(i2.fecha_pago,now()),"+ 
                    "ifnull(i.flag_adelanto,'0') \n" +
                    "from ventas v \n" +
                    "inner join ingresos i on i.idventa = v.idventa\n" +
                    "inner join clientes cli on i.cliente_id=cli.idcliente\n" +
                    "left join tipodoc td on td.tipodoc_id = i.tipodoc_id\n" +
                    "inner join tipos_servicio ts on ts.idtiposervicio = v.idtiposervicio "+ 
                    "left join ingresos i2 on i2.idventa = v.idventa and i2.flag_adelanto = '1' and i2.estado = '2'\n"+ 
                    " and i2.idingreso <> i.idingreso " +
                     "left join tipodoc td2 on td.tipodoc_id = i2.tipodoc_id\n" +
                    "where ((? = 0 and \n" +
                    "         i.fecha_pago between ? and ? and i.estado = '2' and td.value <> '00') or (i.idingreso  = ?)) \n" +
                    "order by i.num_doc desc";
        System.out.println("VentasADN/datosVenta2/sql:" + sql);
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setInt(1, idVenta);
            ps.setDate(2, fecIni);
            ps.setDate(3, fecFin);
            ps.setInt(4, idVenta);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaVentas2(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getDate(5),
                            rs.getFloat(6), rs.getString(7),
                            rs.getString(8), rs.getString(9), rs.getString(10), rs.getFloat(11),
                            rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                            rs.getString(16), new TipoDoc(rs.getInt(17), rs.getString(18), rs.getString(19), null),
                            new Tipos_Servicio(rs.getInt(20), rs.getString(21), null), rs.getFloat(22),
                            rs.getString(23), rs.getInt(24),
                            rs.getString(25), rs.getString(26), rs.getString(27),rs.getFloat(28),rs.getFloat(29),
                            rs.getFloat(30), rs.getString(31), rs.getInt(32),
                            rs.getString(33), rs.getString(34), rs.getFloat(35), rs.getDate(36),rs.getString(37)));
                }
            }
        }
        return aux;
    }
    private static LinkedList<ConsultaVentas2> ListaDetalle(int idventa) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaVentas2> aux = new LinkedList<>();
        String sql = "select p.codigo,\n"
                + "ifnull(d.descripcion_producto,'') descripcion ,d.cantidad,\n"
                + "d.precio as precio_venta,d.importe,p.idproducto,\n"
                + "ifnull(d.afectacion_igv,0) afectacion_igv\n"
                + "from productos p \n"
                + "inner join detalleventas d\n"
                + "on p.idproducto = d.idproducto\n"
                + "left join marcas m on m.idmarca = d.idmarca\n"
                + "left join colores c on c.idcolor = d.idcolor\n"
                + "left join caracteristicas ca on ca.idcaracteristica = d.idcaracteristica\n"
                + "where d.idventa = ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            

            ps.setInt(1, idventa);
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaVentas2(rs.getString(1), rs.getString(2), rs.getFloat(3),
                            rs.getFloat(4), rs.getFloat(5), rs.getInt(6), rs.getFloat(7)));
                }
            }
        }
        return aux;
    }
//    private static LinkedList<ConsultaVentas> ListaDetalle(int idventa) throws SQLException, ClassNotFoundException {
//        LinkedList<ConsultaVentas> aux = new LinkedList<>();
//        String sql = "select  p.codigo,p.descripcion,d.cantidad,\n" +
//                    "         d.precio as precio_venta,d.importe,p.idproducto \n" +
//                    "         from productos p inner join detalleventas d\n" +
//                    "on p.idproducto = d.idproducto\n" +
//                    "where d.idventa = ?";
//        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
//            
//            ps.setInt(1, idventa);
//            try (ResultSet rs = ps.executeQuery()) { //leer el valor
//                while (rs.next()) {//leer los valores devuelto
//                    aux.add(new ProductoDetalle(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getInt(6)));
//                }
//            }
//        }
//        return aux;
//    }

    private static boolean Estado(Ventas ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update ventas set estado=? where idventa = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getEstado());
            pst.setInt(2, ent.getIdventa());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    public static boolean CambiarEstado(Ventas p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

    public static boolean entregarProducto(Ventas p) throws ClassNotFoundException, SQLException {
        return entregar(p);
    }
    
    public static int Guardar(Ventas v) throws ClassNotFoundException, SQLException {
        return Nuevo(v);
    }

    public static String GenerarSerie(String doc) {
        return Serie(doc);
    }

    public static String GeneraNro(String doc) {
        return Nro(doc);
    }

    public static LinkedList<ConsultaVentas> ConsultaVentas(Date fec1, Date fec2, String estado, String cliente,int TipoFecha) throws SQLException, ClassNotFoundException {
        return Lista(fec1, fec2, estado, cliente,TipoFecha);
    }

    public static LinkedList<ConsultaVentas> ConsultaVentasTC(Date fec1, Date fec2, String estado) throws SQLException, ClassNotFoundException {
        return ListaTC(fec1, fec2, estado);
    }

    public static LinkedList<ConsultaVentas> ConsultaProductos(String marca, String color, String carac) throws SQLException, ClassNotFoundException {
        return Lista_productos(marca, color, carac);
    }

    public static LinkedList<ConsultaVentas> ConsultaVentas2(Date fec1, Date fec2, String est) throws SQLException, ClassNotFoundException {
        return Lista2(fec1, fec2, est);
    }

    public static LinkedList<ConsultaVentas> ListaVentasPendientes(String numdoc) throws SQLException, ClassNotFoundException {
        return ListaPendiente(numdoc);
    }

    public static LinkedList<ProductoDetalle> DetalleVenta(int idventa) throws SQLException, ClassNotFoundException {
        return Detalle(idventa);
    }

    public static LinkedList<ConsultaVentas2> getDatosVenta(Date fecIni, Date fecFin, int idVenta,boolean isForComprobante) throws SQLException, ClassNotFoundException {
        if(isForComprobante){
            return datosVentaPreE(fecIni, fecFin, idVenta);
        }else{
            return datosVentaPre(fecIni, fecFin, idVenta);
        }
        
    }
    public static LinkedList<ConsultaVentas2> getDatosVenta2(Date fecIni, Date fecFin, int idVenta,boolean isForComprobante) throws SQLException, ClassNotFoundException {
        return datosVentaPre2E(fecIni, fecFin, idVenta);
    }
    public static LinkedList<ConsultaVentas2> getDatosVentaFacturacion(Date fecIni, Date fecFin, int idVenta) throws SQLException, ClassNotFoundException {
        return datosVentaPreE(fecIni, fecFin, idVenta);
    }
    public static LinkedList<ConsultaVentas2> Detalle_Ventas(int idventa) throws SQLException, ClassNotFoundException {
        return ListaDetalle(idventa);
    }


}
