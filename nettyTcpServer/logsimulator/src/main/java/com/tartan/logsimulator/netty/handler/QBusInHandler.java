package com.tartan.logsimulator.netty.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lin Yiheng
 * @date 2022年2月19日
 * @Description
 */

@Slf4j
@ChannelHandler.Sharable
public class QBusInHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!(msg instanceof String)) {
            super.channelRead(ctx, msg);
            return;
        }
        log.info(msg.toString());
    }
}
