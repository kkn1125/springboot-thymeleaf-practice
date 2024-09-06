package com.chatting.app.chatting.chattingroom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.chatting.app.chatting.chattingroom.entity.ChattingRoom;
import com.chatting.app.chatting.chattingroom.entity.ReadChattingRoom;
import com.chatting.app.chatting.sql.ChattingRoomSQL;
import com.chatting.app.chatting.sql.UserSQL;
import com.chatting.app.chatting.user.entity.User;
import com.chatting.app.chatting.user.entity.UserWithoutPasswordDTO;

@Mapper
public interface ChattingRoomMapper {
  @Select(ChattingRoomSQL.FIND_ALL)
  @Results(value = {
      @Result(property = "id", column = "id"),
      @Result(property = "userId", column = "user_id"),
      @Result(property = "title", column = "title"),
      @Result(property = "description", column = "description"),
      @Result(property = "createdAt", column = "created_at"),
      @Result(property = "updatedAt", column = "updated_at"),
      @Result(property = "user", javaType = UserWithoutPasswordDTO.class, column = "user_id", one = @One(select = UserSQL.FIND_ALL_WITHOUT_PASSWORD_ADDRESS)),
  })
  List<ReadChattingRoom> findAll();

  @Select(ChattingRoomSQL.FIND_ONE)
  @Results(value = {
      @Result(property = "id", column = "id"),
      @Result(property = "userId", column = "user_id"),
      @Result(property = "title", column = "title"),
      @Result(property = "description", column = "description"),
      @Result(property = "createdAt", column = "created_at"),
      @Result(property = "updatedAt", column = "updated_at"),
      @Result(property = "user", javaType = UserWithoutPasswordDTO.class, column = "user_id", one = @One(select = UserSQL.FIND_ALL_WITHOUT_PASSWORD_ADDRESS)),
  })
  ReadChattingRoom findOne(@Param("id") String id);

  @Insert(ChattingRoomSQL.INSERT)
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void create(@Param("chattingRoom") ChattingRoom chattingRoom);

}
