/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import entidades.Parametros;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class ParametrosADN {
    private static boolean Nuevo(Parametros ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "insert into parametros(nombre_empresa, direccion, telefono,"
                + "ruc,monto_kilo,estado,num_venta,ruta_dump,ruta_pse,token,rutadocs,nombre_impresora) "
                + "values(?, ?, ?,?,?,'1',?,?,?,?,?,?)";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre_empresa());
            pst.setString(2, ent.getDireccion());
            pst.setString(3, ent.getTelefono());
            pst.setString(4, ent.getRuc());
            pst.setFloat(5, ent.getMonto_kilo());
             
            pst.setInt(6, ent.getNum_venta());
            pst.setString(7, ent.getRuta_dump());
            pst.setString(8, ent.getRutaPse());
            pst.setString(9, ent.getToken());
            pst.setString(9, ent.getRutadocs());
            pst.setString(10, ent.getNombreImpresora());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    public static boolean Actualizar(Parametros ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update parametros set nombre_empresa = ?, direccion = ?, telefono = ?,"
                + "ruc = ?,monto_kilo = ?,num_venta = ? ,ruta_dump = ?, ruta_pse = ?, token = ?,rutadocs = ?,"
                + "nombre_impresora = ? "
                     + "where idparametro = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getNombre_empresa());
            pst.setString(2, ent.getDireccion());
            pst.setString(3, ent.getTelefono());
            pst.setString(4, ent.getRuc());
            pst.setFloat(5, ent.getMonto_kilo());
            pst.setFloat(6, ent.getNum_venta());
            pst.setString(7, ent.getRuta_dump());
            pst.setString(8, ent.getRutaPse());
            pst.setString(9, ent.getToken());
            pst.setString(10, ent.getRutadocs());
            pst.setString(11, ent.getNombreImpresora());
            pst.setFloat(12, ent.getIdparametro());
            
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Borrar(Parametros ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "delete from parametros where idparametro = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getIdparametro());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }
    public static boolean CreaDB() throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "create database dbbodega";
        try (Connection cn = Conexion.Conexion2();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }
public static boolean EliminaDB() throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "drop database if exists dbbodega";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }
    private static LinkedList<Parametros> ListaParametros() throws SQLException, ClassNotFoundException {
        LinkedList<Parametros> aux = new LinkedList<>();
        String sql = "select idparametro, nombre_empresa, direccion, telefono,ruc,"
                    + "monto_kilo,estado,ifnull(num_venta,0),ifnull(ruta_dump,''),"
                + "ifnull(ruta_pse,'') ruta_pse,ifnull(token,'') token,ifnull(rutadocs,'') rutadocs,"
                + "ifnull(nombre_impresora,'') nombre_impresora "
                + "from parametros";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Parametros(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                            rs.getFloat(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),
                            rs.getString(11),rs.getString(12),rs.getString(13)));
                }

            }

        }
        return aux;
    }
    public static LinkedList<Parametros> Lista() throws SQLException, ClassNotFoundException {
        return ListaParametros();
    }

    public static boolean Guardar(Parametros i) throws ClassNotFoundException, SQLException {
        return Nuevo(i);
    }
//   public static boolean EvaluarDia(Date fecha) throws ClassNotFoundException, SQLException
//   {
//       return Evaluar(fecha);
//   }

    public static boolean Modificar(Parametros param) throws ClassNotFoundException, SQLException {
        return Actualizar(param);
    }
}
