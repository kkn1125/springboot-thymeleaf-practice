package com.chatting.app.chatting.websocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
  private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<>();

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    CLIENTS.remove(session.getId());
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    String id = session.getId();
    CLIENTS.put(id, session);
    CLIENTS.entrySet().forEach(arg -> {
      try {
        TextMessage newMessage = new TextMessage(
            "{\"action\":\"" + "connect" + "\",\"user\":\"" + id + "\",\"message\":\""
                + "connected"
                + "\"}");
        arg.getValue().sendMessage(newMessage);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String id = session.getId();
    System.out.println(id);
    CLIENTS.entrySet().forEach(arg -> {
      // if (!arg.getKey().equals(id)) {
      // try {
      // System.out.println("message: " + message);
      // arg.getValue().sendMessage(message);
      // } catch (Exception e) {
      // e.printStackTrace();
      // }
      // } else {
      try {
        String payload = message.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(payload);
        String actionMessage = node.get("action").asText();
        // String userMessage = node.get("user").asText();
        String textMessage = node.get("message").asText();
        TextMessage newMessage = new TextMessage(
            "{\"action\":\"" + actionMessage + "\",\"user\":\"" + id + "\",\"message\":\""
                + (textMessage == null ? "" : textMessage)
                + "\"}");
        System.out.println(textMessage);
        arg.getValue().sendMessage(newMessage);
      } catch (IOException e) {
        e.printStackTrace();
      }
      // }
    });
  }

}
