package com.tartan.logsimulator.netty;

import com.tartan.logsimulator.netty.codec.QBusDecoder;
import com.tartan.logsimulator.netty.handler.ExceptionHandler;
import com.tartan.logsimulator.netty.handler.HeartBeatServerHandler;
import com.tartan.logsimulator.netty.handler.QBusInHandler;
import com.tartan.logsimulator.netty.vo.NettyConfig;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.rxtx.RxtxChannel;
import io.netty.channel.rxtx.RxtxChannelConfig;
import io.netty.channel.rxtx.RxtxDeviceAddress;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;

/**
 * RxtxNettyServer Netty串口服务器配置
 *
 * @author Lin Yiheng
 * @date 2021-11-19
 */


@Slf4j
public class RxtxNettyClient {
    public RxtxChannel channel;
    private ExceptionHandler exceptionHandler = new ExceptionHandler();
    private HeartBeatServerHandler heartBeatServerHandler = new HeartBeatServerHandler();
    private final OioEventLoopGroup group = new OioEventLoopGroup();


    private String comAddr;
    private Integer baudrate;
    private static ChannelInboundHandlerAdapter nettyDecoder;

    public void start(NettyConfig nettyServerConfig) {

        String proctocal = nettyServerConfig.getProtocal();
        nettyDecoder = new QBusDecoder();
        ChannelInboundHandlerAdapter nettyInHandler = new QBusInHandler();

        this.comAddr = nettyServerConfig.getComAddr();
        this.baudrate = nettyServerConfig.getBaudrate();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channelFactory(new ChannelFactory<RxtxChannel>() {

                        @Override
                        public RxtxChannel newChannel() {
                            return channel;
                        }
                    }).handler(new ChannelInitializer<RxtxChannel>() {
                        @Override
                        protected void initChannel(RxtxChannel ch) throws Exception {
                            ChannelPipeline chPipeLine = ch.pipeline();
                            //添加编解码和处理器(节点间通讯用)
                            chPipeLine.addLast(new StringEncoder());
                        }
                    });
            channel = new RxtxChannel();
            // 设置channel的基本属性，波特率，数据位
            channel.config().setBaudrate(baudrate)
                    .setDatabits(RxtxChannelConfig.Databits.DATABITS_8)
                    .setParitybit(RxtxChannelConfig.Paritybit.NONE)
                    .setStopbits(RxtxChannelConfig.Stopbits.STOPBITS_1);
            //串口地址
            RxtxDeviceAddress com1 = new RxtxDeviceAddress(comAddr);
            ChannelFuture future = b.connect(com1).sync();
            //服务端启动监听事件
            future.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    //启动成功后的处理
                    if (future.isSuccess()) {
                        log.info("netty dtu服务器启动成功，Started Successed");
                    } else {
                        log.info("netty dtu服务器启动失败，Started Failed");
                    }
                }
            });
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public void close() {
        group.shutdownGracefully();
    }

}
