package chatgrueso;

import javax.swing.JFrame;


public class ChatGrueso extends JFrame{
    public static JFrame miVentana = new JFrame("Chat" );
    public static String nombreUsuario = "";
    
    public static void main(String[] args) {
        
        miVentana.setVisible(true);
        miVentana.setSize(500,400);
        miVentana.setLocation(400,200);
        miVentana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Ingreso ingreso = new Ingreso();
        
        miVentana.add(ingreso);
    }
    
    public void setChateo(){
        
    }
}
