package com.xzj.springbootandvue.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = {"定时器"})
@RestController
@RequestMapping("timer")
public class timerController {

    @GetMapping("timer")
    public void time(){
        timer();
    }

    @Scheduled(cron = "1/8 * * * * *")
    void timer(){
        log.info("*****");
    }

}
