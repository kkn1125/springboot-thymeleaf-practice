package com.chatting.app.chatting.chatting.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.chatting.app.chatting.chatting.entity.Chatting;
import com.chatting.app.chatting.sql.ChattingSQL;

@Mapper
public interface ChattingMapper {
  @Select(ChattingSQL.FIND_ALL)
  public List<Chatting> findAll();
}
