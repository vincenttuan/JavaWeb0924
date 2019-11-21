package com.mycompany.web.websocket.client;

import java.net.URI;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.websocket.ContainerProvider;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;


public class ClientEndpoint {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("ws://localhost:8080/JavaWeb0924/websocket");
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(new SocketHandler(), uri);
        RemoteEndpoint.Async remote = session.getAsyncRemote();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("請輸入訊息: ");
            String msg = scanner.nextLine();
            if(msg.equalsIgnoreCase("exit")) {
                break;
            }
            remote.sendText("{\"userName\":\"javaclient\", \"message\":\"" + msg + "\"}");
        }
        
        session.close();
        
    }
}
