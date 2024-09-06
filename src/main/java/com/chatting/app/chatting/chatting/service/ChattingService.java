package com.chatting.app.chatting.chatting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatting.app.chatting.chatting.entity.Chatting;
import com.chatting.app.chatting.chatting.mapper.ChattingMapper;

@Service
public class ChattingService {
  @Autowired
  ChattingMapper chattingMapper;

  public List<Chatting> findAll() {
    return chattingMapper.findAll();
  }
}
