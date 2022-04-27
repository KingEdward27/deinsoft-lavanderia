package accesodatos;
import entidades.ProductoDetalle;
import entidades.Categorias;
import entidades.ConsultaProductos;
import entidades.Detalle_Venta;
import entidades.Marcas;
import entidades.UnidadMedidas;
import entidades.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ProductosADN {

    private static boolean Nuevo(Productos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "insert into productos(idmarca, idcategoria,idunidadmedida, descripcion,paquete, costo,precio,precio2, stock,stockminimo,codigobarra,observacion, estado) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getMarca().getIdMarcas());
            pst.setInt(2, ent.getCategoriasx().getIdcategoria());
            pst.setInt(3, ent.getUnidadmedidasx().getIdUnidadmedida());
            pst.setString(4, ent.getDescripcion()); 
            pst.setFloat(5, ent.getPaquetes());
            pst.setFloat(6, ent.getCosto());
            pst.setFloat(7, ent.getPrecio());
            pst.setFloat(8, ent.getPrecio2());
            pst.setFloat(9, ent.getStock());
            pst.setFloat(10, ent.getStockMinimo());
            pst.setString(11, ent.getCodbarra());
            pst.setString(12, ent.getObservacion());
            pst.setString(13, ent.getEstado());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Actualizar(Productos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update productos set idmarca = ?,idcategoria=?,idunidadmedida=?, descripcion = ?,paquete=?,costo=?, precio = ?,precio2=?,stockminimo=?,codigobarra=?,observacion=? "
                + "where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getMarca().getIdMarcas());
            pst.setInt(2, ent.getCategoriasx().getIdcategoria());
            pst.setInt(3, ent.getUnidadmedidasx().getIdUnidadmedida());
            pst.setString(4, ent.getDescripcion()); 
            pst.setFloat(5, ent.getPaquetes());
            pst.setFloat(6, ent.getCosto());
            pst.setFloat(7, ent.getPrecio());
            pst.setFloat(8, ent.getPrecio2());
            pst.setFloat(9, ent.getStockMinimo());
            pst.setString(10, ent.getCodbarra());
            pst.setString(11, ent.getObservacion());
            pst.setInt(12, ent.getIdProducto());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Estado(Productos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update productos set estado=? where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getEstado());
            pst.setInt(2, ent.getIdProducto());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Existe(Productos ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idproducto) from productos where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getIdProducto());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }

    private static int CodMarca(String descripcion) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select idmarca from marcas where nombre = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, descripcion);            
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r;
    }
    private static int CodCategoria(String descripcion) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select idcategoria from categorias where nombre = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, descripcion);            
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r;
    }
    private static int CodUnidad(String descripcion) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select idunidadmedida from unidadmedidas where nombre = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, descripcion);            
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r;
    }
    private static boolean ExisteNombre(Productos ent) throws SQLException, ClassNotFoundException {
        int r = 0;
        String sql = "select count(idproducto) from productos where descripcion = ? and idproducto <> ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getDescripcion());
            pst.setInt(2, ent.getIdProducto());
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }
    
    private static float CantidadesXPaquete(int idproducto) throws SQLException, ClassNotFoundException {
        float r = 0;
        String sql = "select paquete from productos where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, idproducto);            
            // leer el siguiente valor:
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                r = rs.getFloat(1);
            }
        }
        return r;
    }
    private static LinkedList<Productos> ListaProductos_cat(Productos c) throws SQLException, ClassNotFoundException {
        LinkedList<Productos> aux = new LinkedList<>();
        String sql = "select p.idproducto,m.nombre,c.nombre,u.nombre,p.descripcion,p.costo,p.precio,p.precio2,p.paquete,p.stock,p.stockminimo,p.codigobarra,p.observacion,p.estado "
                + "from productos p inner join marcas m on p.idmarca=m.idmarca "
                + "inner join categorias c on p.idcategoria=c.idcategoria "
                + "inner join unidadmedidas u on p.idunidadmedida=u.idunidadmedida"
                + " where c.nombre like concat('%',?,'%') and m.nombre like concat('%',?,'%') and "
                + " p.descripcion like concat('%',?,'%') and p.codigobarra like concat('%',?,'%') "
                + "and p.estado like ? order by p.orden asc";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
//            ps.setString(1, c.getMarca().getNombre());
            ps.setString(1, c.getCategoriasx().getNom());
            ps.setString(2, c.getMarca().getNombre());
            ps.setString(3, c.getDescripcion());
            ps.setString(4, c.getCodbarra());
            ps.setString(5, c.getEstado());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Productos(rs.getInt(1), new Marcas(rs.getString(2)),new Categorias(0, rs.getString(3)),new UnidadMedidas(0, rs.getString(4)), rs.getString(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8),rs.getFloat(9),rs.getFloat(10),rs.getFloat(11),rs.getString(12),rs.getString(13),rs.getString(14)));
                }

            }catch(SQLException ex)
            {
                System.out.println("ex: "+ex.toString());
            }

        }
        return aux;
    }
    private static LinkedList<ConsultaProductos> ListaProductos3(ConsultaProductos c) throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaProductos> aux = new LinkedList<>();
        String sql = "select p.idproducto,c.nombre,m.nombre,p.descripcion,u.nombre,p.stock,p.precio\n"
                + "from productos p inner join marcas m on m.idmarca=p.idmarca\n"
                + "inner join categorias c on c.idcategoria=p.idcategoria\n"
                + "inner join unidadmedidas u on u.idunidadmedida=p.idunidadmedida "
                + "where c.nombre like concat(?,'%') and m.nombre like concat(?,'%') and p.descripcion like concat(?,'%') and p.estado like '1'";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, c.getCateg());
            ps.setString(2, c.getMarc());
            ps.setString(3, c.getDesc());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaProductos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getFloat(7)));
                }

            }

        }
        return aux;
    }
    private static LinkedList<ConsultaProductos> ListaProductos4() throws SQLException, ClassNotFoundException {
        LinkedList<ConsultaProductos> aux = new LinkedList<>();
        String sql = "select p.idproducto,c.nombre,m.nombre,p.descripcion,u.nombre,p.stock,p.precio\n"
                + "from productos p inner join marcas m on m.idmarca=p.idmarca\n"
                + "inner join categorias c on c.idcategoria=p.idcategoria\n"
                + "inner join unidadmedidas u on u.idunidadmedida=p.idunidadmedida "
                + "where p.stock < p.stockminimo and p.estado like '1'";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ConsultaProductos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getFloat(7)));
                }

            }

        }
        return aux;
    }
    private static LinkedList<ProductoDetalle> ListaProductos5(Productos p) throws SQLException, ClassNotFoundException {
        LinkedList<ProductoDetalle> aux = new LinkedList<>();
        String sql = "select p.idproducto,1,p.descripcion,p.precio,p.precio\n"
                + "from productos p "
                + "where p.estado like '1' and codigobarra like concat(?,'%') ";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setString(1, p.getCodbarra());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new ProductoDetalle(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5)));
                }

            }

        }
        return aux;
    }
    private static LinkedList<Productos> ListaProductos6(Productos c) throws SQLException, ClassNotFoundException {
        LinkedList<Productos> aux = new LinkedList<>();
        String sql = "select p.idproducto,m.nombre,c.nombre,u.nombre,p.descripcion,p.costo,p.precio,p.precio2,p.paquete,p.stock,p.stockminimo,p.codigobarra,p.observacion,p.estado "
                + "from productos p inner join marcas m on p.idmarca=m.idmarca "
                + "inner join categorias c on p.idcategoria=c.idcategoria "
                + "inner join unidadmedidas u on p.idunidadmedida=u.idunidadmedida"
                + " where p.codigobarra like concat(?,'%') and p.estado like 1";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
//            ps.setString(1, c.getMarca().getNombre());
            ps.setString(1, c.getCodbarra());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new Productos(rs.getInt(1), new Marcas(rs.getString(2)),new Categorias(0, rs.getString(3)),new UnidadMedidas(0, rs.getString(4)), rs.getString(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8),rs.getFloat(9),rs.getFloat(10),rs.getFloat(11),rs.getString(12),rs.getString(13),rs.getString(14)));
                }

            }

        }
        return aux;
    }
    private static float Stock(Productos ent) throws ClassNotFoundException, SQLException {
        float r = 0f;
        String sql = "select stock from productos where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, ent.getIdProducto());
            try (ResultSet rs = pst.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    r=rs.getFloat(1);
                }

            }
        }
        return r;
    }
    private static boolean Stock1(Productos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update productos set stock = stock + ? where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setFloat(1, ent.getStock());
            pst.setInt(2, ent.getIdProducto());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }
    private static boolean Costo(Productos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update productos set costo = ? where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setFloat(1, ent.getCosto());
            pst.setInt(2, ent.getIdProducto());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }
    private static boolean Precio(Productos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update productos set precio = ? where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setFloat(1, ent.getPrecio());
            pst.setInt(2, ent.getIdProducto());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }
    private static boolean Precio2(Productos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update productos set precio2 = ? where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setFloat(1, ent.getPrecio2());
            pst.setInt(2, ent.getIdProducto());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }
    private static boolean Stock2(Productos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "update productos set stock = stock - ? where idproducto = ?";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setFloat(1, ent.getStock());
            pst.setInt(2, ent.getIdProducto());
            r = pst.executeUpdate();
        }
        return r == 1 ? true : false;
    }
    private static boolean ExisteCodBarra(Productos ent) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "select count(idproducto) from productos where codigobarra = ? and codigobarra not like ''";
        try (Connection cn = Conexion.Conexion();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, ent.getCodbarra());
            try (ResultSet rs = pst.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    r=rs.getInt(1);
                }

            }
            
        }
        return r > 0 ? true : false;
    }
    public static boolean Guardar(Productos p) throws SQLException, ClassNotFoundException {
        if (Existe(p)) {
            return Actualizar(p);
        } else {
            return Nuevo(p);
        }
    }

    public static boolean CambiarEstado(Productos p) throws ClassNotFoundException, SQLException {
        return Estado(p);
    }

//    public static LinkedList<Productos> ListaMarca(Productos c) throws SQLException, ClassNotFoundException {
//        return ListaProductos1(c);
//    }
//
//    public static LinkedList<Productos> ListaDescripcion(Productos c) throws SQLException, ClassNotFoundException {
//        return ListaProductos2(c);
//    }

    public static boolean Evaluar(Productos p) throws SQLException, ClassNotFoundException {
        return ExisteNombre(p);
    }

    public static boolean AñadirStock(Productos p) throws SQLException, ClassNotFoundException {
        return Stock1(p);
    }

    public static boolean QuitarStock(Productos p) throws SQLException, ClassNotFoundException {
        return Stock2(p);
    }
    public static LinkedList<ConsultaProductos> ConsultaProductos(ConsultaProductos c) throws SQLException, ClassNotFoundException {
        return ListaProductos3(c);
    }
    public static LinkedList<ConsultaProductos> StockMinimo() throws SQLException, ClassNotFoundException {
        return ListaProductos4();
    }
    public static LinkedList<ProductoDetalle> FiltroCodBarra(Productos p) throws SQLException, ClassNotFoundException {
        return ListaProductos5(p);
    }
    public static float CapturaStock(Productos p) throws SQLException, ClassNotFoundException {
        return Stock(p);
    }
    public static LinkedList<Productos> ListaProductos_Cat(Productos p) throws SQLException, ClassNotFoundException {
        return ListaProductos_cat(p);
    }
    public static int CodigoMarca(String descripcion) throws SQLException, ClassNotFoundException {
        return CodMarca(descripcion);
    }
    public static int CodigoCategoria(String descripcion) throws SQLException, ClassNotFoundException {
        return CodCategoria(descripcion);
    }
    public static int CodigoUnidad(String descripcion) throws SQLException, ClassNotFoundException {
        return CodUnidad(descripcion);
    }
    public static float Cantidad_XPaquete(int idproducto) throws SQLException, ClassNotFoundException {
        return CantidadesXPaquete(idproducto);
    }
    public static boolean ActualizarCosto(Productos p) throws SQLException, ClassNotFoundException {
        return Costo(p);
    }
    //precio
    public static boolean ActualizarPrecio(Productos p) throws SQLException, ClassNotFoundException {
        return Precio(p);
    }
    public static boolean ActualizarPrecio2(Productos p) throws SQLException, ClassNotFoundException {
        return Precio2(p);
    }
    public static LinkedList<Productos> DatosProducto(Productos p) throws SQLException, ClassNotFoundException {
        return ListaProductos6(p);
    }
    public static boolean Existe_CodBarra(Productos p) throws SQLException, ClassNotFoundException {
        return ExisteCodBarra(p);
    }
}
