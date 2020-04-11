
import com.google.gson.Gson;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
@ServerEndpoint("/echo")
public class EchoServer {
    //private final Set<Session> sessions=new HashSet<>();
    final static Set<Session> sessions= new HashSet<>();
    private static List<Message> messages = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session){

        sessions.add(session);



        System.out.println(session.getId()+"has opened a connection");
    }
    @OnMessage
    public void onMessage(String text, Session session){
        Message msg = new Gson().fromJson(text, Message.class);
        messages.add(msg);
        for(Session acsession:sessions){
            if(acsession.isOpen()){
                try {
                    acsession.getBasicRemote().sendText(new Gson().toJson(messages));


                } catch (IOException e) {
                    sessions.remove(acsession);
                    e.printStackTrace();
                }
            }

        }


    }
    @OnClose
    public void onClose(Session session){
        sessions.remove(session);
    }


}
