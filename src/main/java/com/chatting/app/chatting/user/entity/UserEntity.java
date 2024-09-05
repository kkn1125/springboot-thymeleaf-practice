package com.chatting.app.chatting.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
  int id;
  String userId;
  String username;
  String password;
  String email;
  String address1;
  String address2;
  String zipNumber;
  String memo;
}
