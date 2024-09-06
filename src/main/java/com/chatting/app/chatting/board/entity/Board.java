package com.chatting.app.chatting.board.entity;

import com.chatting.app.chatting.implement.IDateEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({ "id", "userId", "title", "contents", "memo", "createdAt", "updatedAt" })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends IDateEntity {
  int id;
  String userId;
  String title;
  String contents;
  String memo;
}
