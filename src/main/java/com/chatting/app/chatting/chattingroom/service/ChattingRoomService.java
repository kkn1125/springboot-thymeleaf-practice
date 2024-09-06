package com.chatting.app.chatting.chattingroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatting.app.chatting.chattingroom.entity.ChattingRoom;
import com.chatting.app.chatting.chattingroom.entity.ReadChattingRoom;
import com.chatting.app.chatting.chattingroom.mapper.ChattingRoomMapper;

@Service
public class ChattingRoomService {
  @Autowired
  ChattingRoomMapper chattingRoomMapper;

  public List<ReadChattingRoom> findAll() {
    return chattingRoomMapper.findAll();
  }

  public ReadChattingRoom findOne(String id) {
    return chattingRoomMapper.findOne(id);
  }

  public void create(ChattingRoom chattingRoom) {
    chattingRoomMapper.create(chattingRoom);
  }

}
