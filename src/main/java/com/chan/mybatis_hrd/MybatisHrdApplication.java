package com.chan.mybatis_hrd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chan.mybatis_hrd.repository")
public class MybatisHrdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisHrdApplication.class, args);
    }

}
