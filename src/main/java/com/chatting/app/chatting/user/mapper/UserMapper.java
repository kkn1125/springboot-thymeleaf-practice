package com.chatting.app.chatting.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.chatting.app.chatting.sql.UserSQL;
import com.chatting.app.chatting.user.entity.User;
import com.chatting.app.chatting.user.entity.UserWithoutPasswordDTO;

@Mapper
public interface UserMapper {
  @Select(UserSQL.FIND_ALL)
  List<User> findAll();

  @Select(UserSQL.FIND_ALL_WITHOUT_PASSWORD)
  List<UserWithoutPasswordDTO> findAllWithoutPassword();

  @Insert(UserSQL.INSERT)
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void create(User user);
}