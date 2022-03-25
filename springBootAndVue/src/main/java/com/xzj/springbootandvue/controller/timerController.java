package com.xzj.springbootandvue.controller;

import com.xzj.springbootandvue.utils.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@Api(tags = {"定时器"})
@RestController
@RequestMapping("timer")
public class timerController {

    @GetMapping("timer")
    public void time() throws IOException {
        timer();
    }

    @Scheduled(cron = "1/3 * * * * *")
    void timer() throws IOException {
        String a = "111";
        String url = "http://127.0.0.1:8080/drillingLogin/count/getVisitCount";
        String url2 = "http://127.0.0.1:8080/drillingLogin/count/updateCount";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url2);
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url);
    }

    @Scheduled(cron = "1/3 * * * * *")
    void timer2() throws IOException {
        String a = "222";
        String url = "http://127.0.0.1:8080/drillingLogin/count/getVisitCount";
        String url2 = "http://127.0.0.1:8080/drillingLogin/count/updateCount";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url2);
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url);
    }

    @Scheduled(cron = "1/3 * * * * *")
    void timer3() throws IOException {
        String a = "333";
        String url = "http://127.0.0.1:8080/drillingLogin/count/getVisitCount";
        String url2 = "http://127.0.0.1:8080/drillingLogin/count/updateCount";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url2);
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url);
    }

    @Scheduled(cron = "1/3 * * * * *")
    void timer4() throws IOException {
        String a = "111";
        String url = "http://127.0.0.1:8080/drillingLogin/count/getVisitCount";
        String url2 = "http://127.0.0.1:8080/drillingLogin/count/updateCount";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url2);
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url);
    }

    @Scheduled(cron = "1/3 * * * * *")
    void timer5() throws IOException {
        String a = "222";
        String url = "http://127.0.0.1:8080/drillingLogin/count/getVisitCount";
        String url2 = "http://127.0.0.1:8080/drillingLogin/count/updateCount";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url2);
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url);
    }

    @Scheduled(cron = "1/3 * * * * *")
    void timer6() throws IOException {
        String a = "333";
        String url = "http://127.0.0.1:8080/drillingLogin/count/getVisitCount";
        String url2 = "http://127.0.0.1:8080/drillingLogin/count/updateCount";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url2);
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url);
    }

    @Scheduled(cron = "1/3 * * * * *")
    void timer7() throws IOException {
        String a = "111";
        String url = "http://127.0.0.1:8080/drillingLogin/count/getVisitCount";
        String url2 = "http://127.0.0.1:8080/drillingLogin/count/updateCount";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url2);
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url);
    }

    @Scheduled(cron = "1/3 * * * * *")
    void timer8() throws IOException {
        String a = "222";
        String url = "http://127.0.0.1:8080/drillingLogin/count/getVisitCount";
        String url2 = "http://127.0.0.1:8080/drillingLogin/count/updateCount";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url2);
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url);
    }

    @Scheduled(cron = "1/3 * * * * *")
    void timer9() throws IOException {
        String a = "333";
        String url = "http://127.0.0.1:8080/drillingLogin/count/getVisitCount";
        String url2 = "http://127.0.0.1:8080/drillingLogin/count/updateCount";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url2);
        httpClientUtil.getRespInfo(JSON.toJSON(a).toString(),url);
    }

}
