package com.chatting.app.chatting.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chatting.app.chatting.chattingroom.entity.ChattingRoom;
import com.chatting.app.chatting.chattingroom.entity.ReadChattingRoom;
import com.chatting.app.chatting.chattingroom.service.ChattingRoomService;
import java.util.UUID;

@Controller
public class ViewController {
  @Autowired
  ChattingRoomService chattingRoomService;

  @RequestMapping("")
  public String index(Model model) {
    model.addAttribute("title", "Main");
    model.addAttribute("data", "q123");
    return "pages/index";
  }

  @RequestMapping("chatting-room")
  public String chattingRoom(Model model) {
    model.addAttribute("title", "Chatting Room");

    List<ReadChattingRoom> chattingRoomList = chattingRoomService.findAll();
    model.addAttribute("chattingRoomList", chattingRoomList);

    return "pages/chatting/chatting-room";
  }

  @RequestMapping("chatting-room/{id}")
  public String chattingRoom(Model model, @PathVariable("id") String id) {
    model.addAttribute("title", "Chatting Room :: " + id);

    ReadChattingRoom chattingRoom = chattingRoomService.findOne(id);
    System.out.println("chattingRoom" + chattingRoom);

    if (chattingRoom == null) {
      model.addAttribute("title", "NotFound");
      return "pages/notfound";
    }

    model.addAttribute("chattingRoom", chattingRoom);
    model.addAttribute("socketId", UUID.randomUUID());

    return "pages/chatting/chatting-room-detail";
  }

}
