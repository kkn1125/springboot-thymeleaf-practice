package com.chatting.app.chatting.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalResponseFormatter implements ResponseBodyAdvice<Object> {

  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    // return !Void.TYPE.equals(returnType.getParameterType());
    return true;
  }

  @Override
  @Nullable
  public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
      Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
      ServerHttpResponse response) {
    HttpServletResponse httpServletResponse = ((ServletServerHttpResponse) response).getServletResponse();
    int status = httpServletResponse.getStatus();
    String code = status != 200 ? "fail" : "ok";
    return new ResponseFormat(status, code, body);
  }

}
