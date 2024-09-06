package com.chatting.app.chatting.chattingroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatting.app.chatting.chattingroom.entity.ChattingRoom;
import com.chatting.app.chatting.chattingroom.entity.ReadChattingRoom;
import com.chatting.app.chatting.chattingroom.service.ChattingRoomService;

@RestController
@RequestMapping("/chattingrooms")
public class ChattingRoomContoller {
  @Autowired
  ChattingRoomService chattingRoomService;

  @GetMapping("/list")
  public List<ReadChattingRoom> findAll() {
    return chattingRoomService.findAll();
  }

  @PostMapping("")
  public int postMethodName(@RequestBody ChattingRoom chattingRoom) {
    chattingRoomService.create(chattingRoom);
    return chattingRoom.getId();
  }

}
