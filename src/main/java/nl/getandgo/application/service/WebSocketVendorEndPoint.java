package nl.getandgo.application.service;

import lombok.extern.slf4j.Slf4j;
import nl.getandgo.application.Util.JwtHelper;
import nl.getandgo.application.Util.SpringContextUtil;
import nl.getandgo.application.model.User;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/vendor/{email}/{jwt}")
@Slf4j
public class WebSocketVendorEndPoint {
    private Session session;
    private static Map<Long,Session> webSockets=new ConcurrentHashMap();
    private UserRepository userRepository;
    private StatisticService statisticService;
    private JwtHelper jwtHelper;

    /**
     * "ServerEndPoint" Not Support Inject, Manual SettUp Dependency" By Using Util: "SpringContextUtil"
     * */
    private void SetBeanDependency(){
        if(jwtHelper==null||userRepository==null){
            this.jwtHelper=(JwtHelper)SpringContextUtil.getBean("jwtHelper");
            this.userRepository=(UserRepository) SpringContextUtil.getBean("userRepository");
            this.statisticService=(StatisticService) SpringContextUtil.getBean("statisticService");
        }
    }
    /**
     * Open Connection
     * */
    @OnOpen
    public void onOpen(Session session, @PathParam("email") String email,@PathParam("jwt") String jwt) throws IOException {
        SetBeanDependency();
        //1.Check if the vendor exists in system
        VendorUser vendorUser = userRepository.findVendorByEmail(email).orElse(null);
        if (vendorUser==null){
            log.info("[vendor websocket message] Unauthorized user tried to connect ~ !, current connection:{}, email: {},Jwt_Token{}",webSockets.size(),email,jwt);return;
        }
        //2.Verify the Jwt Token
        try {
            //When Jwt Token in unvalidated
            if (!jwtHelper.validateToken(jwt,vendorUser)){
                log.info("[vendor websocket message] Unauthorized user tried to connect ~ !, current connection:{}, email: {},Jwt_Token{}",webSockets.size(),email,jwt);return;
            }
        }catch (Exception e){
            //When Jwt Token in wrong format
            log.info("[vendor websocket message] Unvalidated Jwt Token, current connection:{}, email: {},Jwt_Token{}",webSockets.size(),email,jwt);return;
        }
        //3.Subscribe into Session
        this.session=session;
        webSockets.put(vendorUser.getUser_id(),session);
        String data=statisticService.getOrderOverTurnLastHalfYearText(vendorUser.getUser_id());
        this.session.getBasicRemote().sendText(data);
        log.info("[vendor websocket message] new connection ~ !, total connection:{}, VendorUser: {},Token{}",webSockets.size(),email,jwt);
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);
        log.info("[websocket message] vendor connection close ~ !, total connection:{}",webSockets.size());
    }

    @OnMessage
    public void onMessage(String message){
        log.info("[websocket message] receive Message ~ ! {}",message);
    }


    /**
     *
     * */
    public void notifyVendorNewOrders(User user, Long vendor_id){
        try {
            log.info("[websocket message] Customer: {} placed an new order , message={}, ",user.getEmail(),"notify to vendor_id="+ vendor_id);
            SetBeanDependency();
            //Prepared The data
            String data =null;
           for(Long i: webSockets.keySet()){
               //Same message Only get once
               if(data==null){data = statisticService.getOrderOverTurnLastHalfYearText(vendor_id);}
               if(vendor_id.equals(i)){
                   webSockets.get(i).getBasicRemote().sendText(data);
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
