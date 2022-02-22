package com.tartan.logsimulator.netty;


import com.tartan.logsimulator.netty.handler.ExceptionHandler;
import com.tartan.logsimulator.netty.handler.HeartBeatServerHandler;
import com.tartan.logsimulator.netty.handler.InformationHandler;
import com.tartan.logsimulator.netty.vo.NettyConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
public class NettyTcpServer {
    private final EventLoopGroup bossGroup = new NioEventLoopGroup();
    //开启两个线程池
    private final EventLoopGroup workGroup = new NioEventLoopGroup();
    //启动装饰类
    private final ServerBootstrap serverBootstrap = new ServerBootstrap();
    //启动端口获取
    private int port;

    private static ExceptionHandler exceptionHandler = new ExceptionHandler();

    private static HeartBeatServerHandler heartBeatServerHandler = new HeartBeatServerHandler();


    /**
     * 启动TcpSockNetty实例
     */
    public void start(NettyConfig nettyConfig) {
        String proctocal = nettyConfig.getProtocal();

        this.port = nettyConfig.getPort();

        serverBootstrap.group(bossGroup, workGroup)
                //非阻塞
                .channel(NioServerSocketChannel.class)
                //连接缓冲池的大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                //设置通道Channel的分配器
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new InformationHandler());
                    }
                });

        ChannelFuture channelFuture = null;
        //启动成功标识
        boolean startFlag = false;
        //启动失败时，多次启动，直到启动成功为止
        while (!startFlag) {
            try {
                channelFuture = serverBootstrap.bind(port).sync();
                startFlag = true;
            } catch (Exception e) {
                log.info("端口号：" + port + "已被占用！");
                port++;
                log.info("尝试一个新的端口：" + port);
                //重新便规定端口号
                serverBootstrap.localAddress(new InetSocketAddress(port));
            }
        }

        //服务端启动监听事件
        channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                //启动成功后的处理
                if (future.isSuccess()) {
                    log.info("netty TCP服务器启动成功，Started Successed");
                } else {
                    log.info("netty TCP服务器启动失败，Started Failed");
                }
            }
        });

        try {
            // 7 监听通道关闭事件
            // 应用程序会一直等待，直到channel关闭
            ChannelFuture closeFuture = channelFuture.channel().closeFuture();
            closeFuture.sync();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("发生其他异常", e);
        } finally {
            // 8 优雅关闭EventLoopGroup，
            // 释放掉所有资源包括创建的线程
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    /**
     * 关闭Tcp Socket Netty实例
     */
    public void close() {
        // 优雅关闭EventLoopGroup，
        // 释放掉所有资源包括创建的线程
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }
}
