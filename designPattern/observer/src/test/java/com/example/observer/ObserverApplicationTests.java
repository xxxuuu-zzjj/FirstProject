package com.example.observer;

import com.example.observer.service.Observer;
import com.example.observer.service.ObserverAbleServer;
import com.example.observer.service.ObserverServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObserverApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void observerTest() {
        ObserverAbleServer server = new ObserverAbleServer();

        Observer userZhang = new ObserverServer("ZhangSan");
        Observer userLi = new ObserverServer("LiSi");
        Observer userWang = new ObserverServer("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");

    }
}

