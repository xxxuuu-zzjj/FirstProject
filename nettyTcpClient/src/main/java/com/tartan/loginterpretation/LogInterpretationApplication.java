package com.tartan.loginterpretation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@Slf4j
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
@SpringBootApplication
public class LogInterpretationApplication {
    public static void main(String[] args){
        SpringApplication.run(LogInterpretationApplication.class,args);
    }
}
