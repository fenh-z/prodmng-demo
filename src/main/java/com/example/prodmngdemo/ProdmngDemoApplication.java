package com.example.prodmngdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication(scanBasePackages = "com.example")
@MapperScan(
        basePackages = "com.example.atom.dao",
        annotationClass = Repository.class
)
public class ProdmngDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdmngDemoApplication.class, args);
    }

}
