package com.tartan.loginterpretation.netty;

import com.tartan.loginterpretation.netty.codec.QBusDecoder;
import com.tartan.loginterpretation.netty.codec.WITSDecoder;
import com.tartan.loginterpretation.netty.handler.QBusInHandler;
import com.tartan.loginterpretation.netty.handler.TcpClientHandler;
import com.tartan.loginterpretation.netty.handler.WitsInHandler;
import com.tartan.loginterpretation.netty.vo.NettyConfig;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

public class NettyTcpClient {


    private String ip;
    private Integer port;
    private EventLoopGroup workerGroup;
    private Bootstrap bootstrap;
    private ChannelFuture future;
    private Channel channel;
    private volatile Boolean transferRemoteStatus; //false:远传失败，true:远传成功


    public Boolean getTransferRemoteStatus() {
        return transferRemoteStatus;
    }

    public void init(NettyConfig nettyConfig) throws Exception {
        this.transferRemoteStatus = false;
        this.ip = nettyConfig.getIp();
        this.port = nettyConfig.getPort();
        workerGroup = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new WITSDecoder());
                        ch.pipeline().addLast(new WitsInHandler());
                    }
                });
        future = bootstrap.connect(ip, port).sync();
        channel = future.channel();
    }

    public void close() {
        transferRemoteStatus = false;
        workerGroup.shutdownGracefully();
    }

    public void remoteTransfer(String msg) {
        try {
            //发送TCP报文
            byte[] data = msg.getBytes(CharsetUtil.UTF_8);
            ByteBuf byteBufMsg = Unpooled.buffer();
            byteBufMsg.writeBytes(data);
            channel.writeAndFlush(byteBufMsg);

            transferRemoteStatus = true;
            transferRemoteStatus = channel.isWritable();
        } catch (Exception e) {
            e.printStackTrace();
            transferRemoteStatus = false;
        }
    }
}
