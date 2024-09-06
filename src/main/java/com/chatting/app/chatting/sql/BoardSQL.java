package com.chatting.app.chatting.sql;

public class BoardSQL {
  public static final String FIND_ALL = """
      SELECT * FROM board
      """;
  public static final String FIND_ALL_ADDRESS = "com.chatting.app.chatting.board.mapper.BoardMapper.findAll";
}
