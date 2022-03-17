package com.tartan.insert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
@SpringBootApplication
public class InsertApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsertApplication.class, args);
    }

}
