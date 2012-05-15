package clientegrueso;

import ws.Chat;
import ws.Chat_Service;

public class Help {
    
    Chat_Service chat = new Chat_Service();
    Chat c = chat.getChatPort();
    
    public String capitalize(String s) {
        if (s.length() == 0) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
    
    public void deleteUser(String user){
        c.deleteUserOnline(user);
    }
}
