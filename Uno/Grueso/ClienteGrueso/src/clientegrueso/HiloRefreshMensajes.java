package clientegrueso;

import java.util.logging.Level;
import java.util.logging.Logger;
import ws.Chat_Service;


public class HiloRefreshMensajes extends Thread{
    Chat_Service chat = new Chat_Service();
    ws.Chat c = chat.getChatPort();
    
    public void run(){
        while(true){
            try {
                
                String texto = "";
                for(int i = 0; i < c.getMsg(ClienteGrueso.sala).size(); i++){
                    texto += c.getMsg(ClienteGrueso.sala).get(i).toString() + "\n";
                }
                ChatWindow.tTextos.setText("");
                ChatWindow.tTextos.setText(texto);

                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloRefreshMensajes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
