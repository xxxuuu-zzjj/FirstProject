package com.tartan.loginterpretation.config;

import com.tartan.loginterpretation.netty.NettyTcpClient;
import com.tartan.loginterpretation.netty.RxtxNettyServer;
import com.tartan.loginterpretation.netty.vo.NettyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AfterBootAction implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        /* NettyConfig rxtxNettyServerConfig = new NettyConfig();
        rxtxNettyServerConfig.setComAddr("COM1");
        rxtxNettyServerConfig.setBaudrate(9600);
        RxtxNettyServer rxtxNettyServer=new RxtxNettyServer();
        rxtxNettyServer.start(rxtxNettyServerConfig);*/
        /*NettyConfig tcpNettyClientConfig = new NettyConfig();
        tcpNettyClientConfig.setIp("127.0.0.1");
        tcpNettyClientConfig.setPort(8080);
        NettyTcpClient nettyTcpClient = new NettyTcpClient();
        nettyTcpClient.init(tcpNettyClientConfig);*/

    }
}
