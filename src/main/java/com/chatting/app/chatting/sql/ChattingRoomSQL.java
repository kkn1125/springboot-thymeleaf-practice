package com.chatting.app.chatting.sql;

public class ChattingRoomSQL {
  public static final String FIND_ALL = """
      SELECT * FROM chatting_room
      """;
  public static final String FIND_ALL_ADDRESS = "com.chatting.app.chatting.chattingroom.mapper.ChattingRoomMapper.findAll";

  public static final String FIND_ONE = """
      SELECT * FROM chatting_room WHERE id = #{id}
      """;
  public static final String FIND_ONE_ADDRESS = "com.chatting.app.chatting.chattingroom.mapper.ChattingRoomMapper.findOne";

  public static final String INSERT = """
      INSERT INTO chatting_room (user_id, title, `description`) VALUES (#{chattingRoom.userId}, #{chattingRoom.title}, #{chattingRoom.description})
      """;
}