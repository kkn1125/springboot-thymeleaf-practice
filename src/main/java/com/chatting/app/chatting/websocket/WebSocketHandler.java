package com.chatting.app.chatting.websocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
  private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<>();

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    CLIENTS.remove(session.getId());
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    CLIENTS.put(session.getId(), session);
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String id = session.getId();
    CLIENTS.entrySet().forEach(arg -> {
      if (!arg.getKey().equals(id)) {
        try {
          System.out.println("message: " + message);
          arg.getValue().sendMessage(message);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else {
        try {
          System.out.println("message: " + message);
          arg.getValue().sendMessage(message);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }

}
