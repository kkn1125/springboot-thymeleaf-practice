package com.chatting.app.chatting.chatting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatting.app.chatting.chatting.entity.Chatting;
import com.chatting.app.chatting.chatting.service.ChattingService;

@RestController
@RequestMapping("/chattings")
public class ChattingController {

  @Autowired
  ChattingService chattingService;

  @GetMapping("/list")
  List<Chatting> findAll() {
    return chattingService.findAll();
  }
}
