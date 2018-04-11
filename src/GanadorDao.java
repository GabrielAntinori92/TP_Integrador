import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GanadorDao {

    public void insertGanador(Jugador j){
        Connection conn = null;
        PreparedStatement stm = null;

        try{
            conn = Conexion.getConexion();
            stm =  conn.prepareStatement("insert into ganadores(nombre,puntos) values(?,?)");

            stm.setString(1,j.getNombre());
            stm.setString(2,Integer.toString(j.getPuntos()));
            stm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
