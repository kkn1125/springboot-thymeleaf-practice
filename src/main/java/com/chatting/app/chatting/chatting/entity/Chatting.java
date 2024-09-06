package com.chatting.app.chatting.chatting.entity;

import com.chatting.app.chatting.implement.ICreateEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({ "id", "userId", "chattingRoomId", "message", "createdAt" })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chatting extends ICreateEntity {
  int id;
  int userId;
  int chattingRoomId;
  String message;
}
