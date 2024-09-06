package com.chatting.app.chatting.advice;

import lombok.Getter;

@Getter
public class ResponseFormat {
  private int status;
  private String code;
  private Object data;

  public ResponseFormat(int status, String code, Object body) {
    this.status = status;
    this.code = code;
    this.data = body;
  }
}
