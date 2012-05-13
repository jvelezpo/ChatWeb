package chatgrueso;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloMensajes extends Thread{
    public void run(){
        
        while(true){
            Connection con = null;
            Statement sentencia = null;
            ResultSet rs = null;
            try {
                con = JDBCConnection.getConexion();
                sentencia = con.createStatement();
                String mensajes = "";
                sentencia = con.createStatement();
                rs = sentencia.executeQuery("SELECT * FROM mensajes ORDER BY created_at LIMIT 0 , 20");
                while (rs.next()){
                    mensajes += rs.getString("de") + ": ";
                    mensajes += rs.getString("texto") + "\n";
                }

                
                Chateo.jTextArea1.setText(mensajes);
                
                sleep(3000);
            }catch (Exception ex) {
                    Logger.getLogger(HiloMensajes.class.getName()).log(Level.SEVERE, null, ex);    
            }
        }
    }
}
