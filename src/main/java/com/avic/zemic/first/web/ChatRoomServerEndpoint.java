package com.avic.zemic.first.web;

import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import static com.avic.zemic.first.util.WebSocketUtils.ONLINE_USER_SESSIONS;
import static com.avic.zemic.first.util.WebSocketUtils.sendMessageAll;

@RestController
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        ONLINE_USER_SESSIONS.put(username, session);
        String message = "欢迎你，" + username + ",祝您聊天愉快！！！";
        System.out.println("发送消息：" + message);
        sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username,String message) {
        System.out.println("用户[" + username + "],发送消息" + message);
        sendMessageAll("用户[" + username + "]：" + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        // 当前的Session移除
        ONLINE_USER_SESSIONS.remove(username);

        sendMessageAll("用户[" + username + "]退出聊天室");

        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            System.out.println("onError ");
            e.printStackTrace();
        }
    }
}
