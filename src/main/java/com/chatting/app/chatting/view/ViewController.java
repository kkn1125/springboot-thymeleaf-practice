package com.chatting.app.chatting.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
  @RequestMapping("")
  public String index(Model model) {
    System.out.println("test2");
    model.addAttribute("data", "q123");
    return "index";
  }

  @RequestMapping("chatting-room")
  public String chattingRoom(Model model) {
    System.out.println("test2");
    model.addAttribute("data", "q123");
    return "chatting/chatting-room.html";
  }

}
