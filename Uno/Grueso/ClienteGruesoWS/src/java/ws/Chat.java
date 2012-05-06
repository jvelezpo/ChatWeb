package ws;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sebastian
 */
@WebService(serviceName = "Chat")
public class Chat {
    
    @WebMethod
    public ArrayList getUsersOnline(){
        try{
            Connection con = JDBCConnection.getConexion();
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM onlines ORDER BY name");
            ArrayList<String> onlines = new ArrayList<String>();
            while (rs.next()){
                onlines.add(rs.getString("name"));
            }
            rs.close();
            sentencia.close();
            return onlines;
        }catch(Exception e){
            return null;
        }
    }
    
    @WebMethod
    public boolean setUserOnline(String user){
        try{
            Help help = new Help();
            user = help.capitalize(user);
            String name = "";
            Connection con = JDBCConnection.getConexion();
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM onlines WHERE name = '"+user+"'");
            while (rs.next()){
                name = rs.getString("name");
            }
            rs.close();
            sentencia.close();
         
            if (name.equals(user)){
                return false;
            }else{
                Date d = new Date();    
                d.setHours(d.getHours()+5);
                String fecha = new Timestamp(d.getTime()).toString();
                sentencia = con.createStatement();

                sentencia.executeUpdate("INSERT INTO onlines VALUES (NULL , '"+user+"', '"+fecha+"', '"+fecha+"')");
                sentencia.close();
                return true;
            }
        }catch(Exception e){
            return false;
        }
    }
    
    @WebMethod
    public boolean deleteUserOnline(String user){
        Date d = new Date();
        d.setHours(d.getHours()+5);
        String fecha = new Timestamp(d.getTime()).toString();
        try{
            Connection con = JDBCConnection.getConexion();
            Statement sentencia = con.createStatement();
            
            sentencia.executeUpdate("DELETE FROM onlines WHERE name = '"+user+"'");
            sentencia.close();
  
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @WebMethod
    public ArrayList getSalas(){
        try{
            Connection con = JDBCConnection.getConexion();
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SHOW tables");
            ArrayList<String> salas = new ArrayList<String>();
            while (rs.next()){
                salas.add(rs.getString("Tables_in_chatweb"));
            }
            rs.close();
            sentencia.close();
            salas.remove("onlines");
            salas.remove("schema_migrations");
            return salas;
        }catch(Exception e){
            return null;
        }
    }
    
    @WebMethod
    public boolean checkSala(String sala){
        try{
            Connection con = JDBCConnection.getConexion();
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SHOW tables");
            ArrayList<String> salas = new ArrayList<String>();
            while (rs.next()){
                salas.add(rs.getString("Tables_in_chatweb"));
            }
            rs.close();
            sentencia.close();
            if(salas.contains(sala.toLowerCase()))
                return true;
            else
                return false;
        }catch(Exception e){
            return false;
        }
    }
    
    @WebMethod
    public boolean newMsg(String msg, String sala){
        try{
            Date d = new Date();    
            d.setHours(d.getHours()+5);
            String fecha = new Timestamp(d.getTime()).toString();
            
            Connection con = JDBCConnection.getConexion();
            Statement sentencia = con.createStatement();

            sentencia.executeUpdate("INSERT INTO "+sala+" VALUES (NULL , '"+msg+"', '"+fecha+"', '"+fecha+"')");
            sentencia.close();
  
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @WebMethod
    public ArrayList getMsg(String sala){
        try{
            Connection con = JDBCConnection.getConexion();
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM "+sala+" ORDER BY created_at");
            ArrayList<String> content = new ArrayList<String>();
            while (rs.next()){
                content.add(rs.getString("content"));
            }
            rs.close();
            sentencia.close();
            return content;
        }catch(Exception e){
            return null;
        }
    }
    
}
