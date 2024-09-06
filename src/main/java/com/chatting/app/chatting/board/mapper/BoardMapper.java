package com.chatting.app.chatting.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.chatting.app.chatting.board.entity.Board;
import com.chatting.app.chatting.sql.BoardSQL;

@Mapper
public interface BoardMapper {
  @Select(BoardSQL.FIND_ALL)
  List<Board> findAll();
}