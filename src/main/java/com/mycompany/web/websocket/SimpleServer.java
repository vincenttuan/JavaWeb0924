package com.mycompany.web.websocket;

import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/server")
public class SimpleServer {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("接到連線, sessionID: " + session.getId());
    }
    
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        
    }
    
    @OnClose
    public void onClose(Session session) {
        
    }
    
    @OnError
    public void onError(Throwable error) {
        
    }
    
}
