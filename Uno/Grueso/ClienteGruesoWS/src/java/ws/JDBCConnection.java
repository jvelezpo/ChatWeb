package ws;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class JDBCConnection {

    private static Connection connection;

    public static Connection getConexion() throws Exception{
        if (connection == null)
            return getJDBConnection();
        else
            return connection;
    }

    private static Connection getJDBConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/chatweb";
        connection = (Connection) DriverManager.getConnection(url, "root", "");
        return connection;
    }

    public static void cerrarConexion(){
        try{
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}