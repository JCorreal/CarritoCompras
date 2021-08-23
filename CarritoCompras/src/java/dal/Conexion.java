package dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //Metodo para obtener la conexion con la base de datos
    public static synchronized Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/bdtutorial", "root", "");
        } catch (Exception e) {
            cn = null;
        } finally {
            return cn;
        }
    }
}
