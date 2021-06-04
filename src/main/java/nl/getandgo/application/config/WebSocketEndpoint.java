package nl.getandgo.application.config;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/websocket/{user_Id}")
@Component
public class WebSocketEndpoint {
    private Session session;

    //Open Connection
    @OnOpen
    public void onOpen(Session session, @PathParam("useId") String userId){
        //Save it to Pool
        SessionPool.sessions.put("userId",session);
        System.out.println(userId);
    }
    //Close Connection
    @OnClose
    public void onClose(Session session) throws IOException {
        SessionPool.close(session.getId());
        session.close();
    }


    @OnMessage
    public void onMessage(String message,Session session){
        SessionPool.sendMessage(message);
    }

}
