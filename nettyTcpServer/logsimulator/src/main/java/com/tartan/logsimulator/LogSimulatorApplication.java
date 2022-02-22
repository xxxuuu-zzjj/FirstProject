package com.tartan.logsimulator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
@SpringBootApplication
public class LogSimulatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogSimulatorApplication.class, args);
    }
}
