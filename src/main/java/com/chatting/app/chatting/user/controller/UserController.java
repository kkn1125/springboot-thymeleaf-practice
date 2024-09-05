package com.chatting.app.chatting.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatting.app.chatting.user.entity.UserEntity;

@RestController
@RequestMapping("/users")
public class UserController {

  @GetMapping("")
  public List<UserEntity> findAll() {
    return new ArrayList<UserEntity>();
  }
}
