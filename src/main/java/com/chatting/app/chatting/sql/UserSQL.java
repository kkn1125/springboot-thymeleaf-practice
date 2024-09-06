package com.chatting.app.chatting.sql;

public class UserSQL {
  public static final String FIND_ALL = """
      SELECT
      id,
      password,
      username,
      email,
      address1,
      address2,
      zip_number,
      memo,
      created_at,
      updated_at
      FROM user
      """;
  public static final String FIND_ALL_WITHOUT_PASSWORD = """
      SELECT
      id,
      username,
      email,
      address1,
      address2,
      zip_number,
      memo,
      created_at,
      updated_at
      FROM user
      """;
  public static final String FIND_ALL_ADDRESS = "com.chatting.app.chatting.user.mapper.UserMapper.findAll";
  public static final String FIND_ALL_WITHOUT_PASSWORD_ADDRESS = "com.chatting.app.chatting.user.mapper.UserMapper.findAllWithoutPassword";

  public static final String INSERT = """
      INSERT INTO user (username, password, email, address1, address2, zip_number,
      memo) VALUES (#{username}, #{password}, #{email}, #{address1}, #{address2},
      #{zipNumber}, #{memo})
      """;
}