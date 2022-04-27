package accesodatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public static Connection Conexion() throws ClassNotFoundException, SQLException {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbbodega", "deinsoft", "capei123");
//            return cn;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";
        String host = "", puerto = "", db = "", usuario = "", contraseña = "";
        try {
            archivo = new File("config32.sys");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
//            }
            while ((linea = br.readLine()) != null) {
                char darreglo[] = linea.toCharArray();
//                for (int i = 0; i < darreglo.length; i++) {
//                    darreglo[i]=(char)(darreglo[i]-(char)123);
//                }
//                String nuevalinea = String.valueOf(darreglo);
                String[] vector = linea.split(",");
                host = vector[0];
                puerto = vector[1];
                db = vector[2];
                usuario = vector[3];
                if (vector.length>4) {
                    contraseña = vector[4];
                }
                 
                 
            }
             
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos: "+e.toString());
        }
         return DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + db, usuario, contraseña);
    }  
    public static Connection Conexion2() throws ClassNotFoundException, SQLException {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbbodega", "deinsoft", "capei123");
//            return cn;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";
        String host = "", puerto = "", db = "", usuario = "", contraseña = "";
        try {
            archivo = new File("config32.sys");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
//            }
            while ((linea = br.readLine()) != null) {
                char darreglo[] = linea.toCharArray();
//                for (int i = 0; i < darreglo.length; i++) {
//                    darreglo[i]=(char)(darreglo[i]-(char)123);
//                }
//                String nuevalinea = String.valueOf(darreglo);
                String[] vector = linea.split(",");
                host = vector[0];
                puerto = vector[1];
                db = vector[2];
                usuario = vector[3];
                if (vector.length>4) {
                    contraseña = vector[4];
                }
                 
                 
            }
             
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos: "+e.toString());
        }
         return DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/mysql", usuario, contraseña);
    }  
}
