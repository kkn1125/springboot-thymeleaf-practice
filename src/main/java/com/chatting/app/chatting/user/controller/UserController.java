package com.chatting.app.chatting.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatting.app.chatting.user.entity.User;
import com.chatting.app.chatting.user.entity.UserWithoutPasswordDTO;
import com.chatting.app.chatting.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/list")
  public List<UserWithoutPasswordDTO> findAll() {
    return userService.findAllWithoutPassword();
  }

  @PostMapping("")
  public int create(@RequestBody User user) {
    userService.create(user);
    return user.getId();
  }

}
