package com.api.mybatis_spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@MapperScan("com.api.mybatis_spring.usuario.repository")
public class MybatisSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringApplication.class, args);
    }

}
