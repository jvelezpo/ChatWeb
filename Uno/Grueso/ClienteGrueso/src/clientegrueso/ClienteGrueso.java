package clientegrueso;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;


public class ClienteGrueso extends JFrame{
    public static JFrame chatGrueso = new JFrame("Cliente Grueso");
    public static String nombreUsuario = "";
    public static String sala = "";
    public static ArrayList<String> usuariosOnline = new ArrayList<>();
    
    
    public static void main(String[] args) {
        chatGrueso.setVisible(true);
        chatGrueso.setSize(800,600);
        chatGrueso.setLocation(100,100);
        chatGrueso.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Usuario usuario = new Usuario();
        
        chatGrueso.add(usuario);
        
        HiloGetOnlineUsers elHilo = new HiloGetOnlineUsers();
        elHilo.start();
        
        chatGrueso.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                if(!nombreUsuario.equals("")){
                    Help help = new Help();
                    help.deleteUser(nombreUsuario);
                }
            }
        });
    }
    
    
}
