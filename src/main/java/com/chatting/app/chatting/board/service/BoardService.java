package com.chatting.app.chatting.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatting.app.chatting.board.entity.Board;
import com.chatting.app.chatting.board.mapper.BoardMapper;

@Service
public class BoardService {
  @Autowired
  BoardMapper boardMapper;

  public List<Board> findAll() {
    return boardMapper.findAll();
  }
}
