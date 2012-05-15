package clientegrueso;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloRefreshOnlineUsers extends Thread{
    public void run(){
        while(true){
            try {
                String uOnlines = "";
                for(int i = 0; i < ClienteGrueso.usuariosOnline.size(); i++)
                    uOnlines += ClienteGrueso.usuariosOnline.get(i) + "\n";
                ChatWindow.tOnlines.setText("");
                ChatWindow.tOnlines.setText(uOnlines);
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloRefreshOnlineUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
