package clientegrueso;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ws.*;

public class HiloGetOnlineUsers extends Thread{
    Chat_Service chat = new Chat_Service();
    ws.Chat c = chat.getChatPort();
    
    public void run(){
        while(true){
            try {
                ClienteGrueso.usuariosOnline.clear();
                for(int i = 0; i < c.getUsersOnline().size(); i++){
                    ClienteGrueso.usuariosOnline.add(String.valueOf(c.getUsersOnline().get(i)));
                }
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloGetOnlineUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
