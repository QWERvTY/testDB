package com.example.demo;

import java.util.Queue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mapper")
@ComponentScan(basePackages = {"com.example"})
public class TestDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDbApplication.class, args);
	}

}
