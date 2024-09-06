package com.chatting.app.chatting.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatting.app.chatting.board.entity.Board;
import com.chatting.app.chatting.board.service.BoardService;

@RestController
@RequestMapping("/boards")
public class BoardController {
  @Autowired
  BoardService boardService;

  @GetMapping("/list")
  public List<Board> findAll() {
    return boardService.findAll();
  }
}
