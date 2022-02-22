package com.tartan.logsimulator.config;

import com.tartan.logsimulator.netty.NettyTcpServer;
import com.tartan.logsimulator.netty.RxtxNettyClient;
import com.tartan.logsimulator.netty.vo.NettyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AfterBootAction implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        NettyConfig rxtxNettyServerConfig = new NettyConfig();
//        rxtxNettyServerConfig.setComAddr("COM2");
//        rxtxNettyServerConfig.setBaudrate(9600);
//        RxtxNettyClient rxtxNettyClient=new RxtxNettyClient();
//        rxtxNettyClient.start(rxtxNettyServerConfig);
        NettyConfig nettyTcpClientConfig = new NettyConfig();
        nettyTcpClientConfig.setPort(8080);
        NettyTcpServer nettyTcpServer = new NettyTcpServer();
        nettyTcpServer.start(nettyTcpClientConfig);
    }
}
