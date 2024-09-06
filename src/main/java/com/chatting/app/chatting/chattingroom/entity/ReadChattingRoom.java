package com.chatting.app.chatting.chattingroom.entity;

import com.chatting.app.chatting.implement.IDateEntity;
import com.chatting.app.chatting.user.entity.UserWithoutPasswordDTO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({ "id", "userId", "title", "description", "user", "createdAt", "updatedAt" })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReadChattingRoom extends IDateEntity {
  int id;
  int userId;
  String title;
  String description;
  UserWithoutPasswordDTO user;
}
