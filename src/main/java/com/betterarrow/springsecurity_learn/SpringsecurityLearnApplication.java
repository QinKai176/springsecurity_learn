package com.betterarrow.springsecurity_learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.betterarrow.springsecurity_learn.mapper")
public class SpringsecurityLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityLearnApplication.class, args);
    }

}
