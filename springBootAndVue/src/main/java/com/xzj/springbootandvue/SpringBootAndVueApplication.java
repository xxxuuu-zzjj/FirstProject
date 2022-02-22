package com.xzj.springbootandvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootAndVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndVueApplication.class, args);
    }

}
