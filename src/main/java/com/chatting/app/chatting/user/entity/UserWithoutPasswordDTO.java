package com.chatting.app.chatting.user.entity;

import com.chatting.app.chatting.implement.IDateEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({ "id", "username", "email", "address1", "address2", "zipNumber", "memo", "createdAt",
    "updatedAt" })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserWithoutPasswordDTO extends IDateEntity {
  int id;
  String username;
  String email;
  String address1;
  String address2;
  String zipNumber;
  String memo;
}
