package accesodatos;

import entidades.Categorias;
import entidades.DocRef;
import entidades.Ingresos;
import entidades.NumeracionDocumento;
import entidades.TipoDoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class DocRefADN {
    
       private static boolean Nuevo(DocRef ent) throws ClassNotFoundException, SQLException{
   int r = 0;
   String sql = "insert into doc_ref(docref_id,idingreso,dr.tipodoc_id,serie,numero) "
           + "values(null, ?,?,?,?)";
       try(Connection cn = Conexion.Conexion();
               PreparedStatement pst = cn.prepareStatement(sql)){ 
//           pst.setString(1, ent.getNombre());
           pst.setInt(1, ent.getIngreso().getIdIngreso());
           pst.setInt(2, ent.getTipoDoc().getTipodocId());
           pst.setString(3, ent.getSerie());
           pst.setInt(4, ent.getNumero());
           r = pst.executeUpdate();
       }
       return r == 1 ? true : false;
   }
   
   private static LinkedList<DocRef> data(DocRef c) throws SQLException, ClassNotFoundException {
        LinkedList<DocRef> aux = new LinkedList<>();
        String sql = "select docref_id,idingreso,dr.tipodoc_id,td.nombre,td.value,serie,numero from doc_ref dr "
                + "inner join tipodoc td on td.tipodoc_id = dr.tipodoc_id "
                + "where docref_id = ?";
        try (Connection cn = Conexion.Conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {//manejador de recursos            
            ps.setInt(1, c.getId());
            try (ResultSet rs = ps.executeQuery()) { //leer el valor
                while (rs.next()) {//leer los valores devuelto
                    aux.add(new DocRef(rs.getInt(1),new Ingresos(rs.getInt(2)),new TipoDoc( rs.getInt(3)
                            , rs.getString(4), rs.getString(5), ""), rs.getString(6), rs.getInt(7)));
                }
                
            }
            
        }
        return aux;
    }

    public static boolean Guardar(DocRef p) throws SQLException, ClassNotFoundException {
        return Nuevo(p);
    }

    public static LinkedList<DocRef> getById(DocRef p) throws ClassNotFoundException, SQLException {
        return data(p);
    }

}
