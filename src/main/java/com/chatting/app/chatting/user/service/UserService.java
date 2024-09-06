package com.chatting.app.chatting.user.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatting.app.chatting.user.entity.User;
import com.chatting.app.chatting.user.entity.UserWithoutPasswordDTO;
import com.chatting.app.chatting.user.mapper.UserMapper;

@Service
public class UserService {
  @Autowired
  UserMapper userMapper;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  String encryptPassword(String password) {
    System.out.println(password);
    return bCryptPasswordEncoder.encode(password);
  }

  public List<User> findAll() {
    return userMapper.findAll();
  }

  public List<UserWithoutPasswordDTO> findAllWithoutPassword() {
    return userMapper.findAllWithoutPassword();
  }

  public void create(User user) {
    user.setPassword(encryptPassword(user.getPassword()));
    userMapper.create(user);
  }
}
