
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion(){

        Connection conexion = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_integrador","root","234C09d");
        }catch(Exception e){
            e.printStackTrace();
        }

        return conexion;
    }
}
