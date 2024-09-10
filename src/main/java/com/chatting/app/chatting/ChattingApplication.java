package com.chatting.app.chatting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({ "com.chatting.app.chatting" })
@SpringBootApplication
public class ChattingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChattingApplication.class, args);
	}

}
