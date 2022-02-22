package com.tartan.logsimulator.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ChannelHandler.Sharable
public class InformationHandler extends ChannelInboundHandlerAdapter {

    public static Channel currentChannel;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object o) throws Exception {
        currentChannel = ctx.channel();
        log.info("content:"+o.toString());

    }
}
