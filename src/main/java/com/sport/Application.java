package com.sport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(value = "com.sport.dao")
@SpringBootApplication
@ServletComponentScan
public class Application {

    public static void main(String[] args) {
        System.out.println("App Start------------------->");
        SpringApplication.run(Application.class, args);
    }
}
