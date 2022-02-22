package com.tartan.logsimulator.netty.handler;


import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * netty客户端心跳处理
 *
 * @author Lin Yiheng
 * @date 2021年11月24日
 * @Description
 */
@Slf4j
@ChannelHandler.Sharable
// @Service("heartHandler")
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        Boolean rdStatus = true;
        Boolean wtStatus = true;
        log.info(ctx.name());
        if (evt instanceof IdleStateEvent) {//超时事件
            IdleStateEvent idleEvent = (IdleStateEvent) evt;
            if (idleEvent.state() == IdleState.READER_IDLE) {//读
                rdStatus = false;
            } else if (idleEvent.state() == IdleState.WRITER_IDLE) {//写
                wtStatus = false;
            } else if (idleEvent.state() == IdleState.ALL_IDLE) {//全部

            }
/*
            JSONObject instStatus = new JSONObject();
            instStatus.put("action", WebSockAction.INST_STATUS.code);
            instStatus.put("name", ctx.name());
            instStatus.put("rdStatus", rdStatus);
            instStatus.put("wtStatus", wtStatus);

            Channel channel = PageKeyChannelRel.get(WSChannelKey.HOME_PAGE_CHANNEL);
            if (channel != null) {
                channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(instStatus)));
            }
*/
        }
        super.userEventTriggered(ctx, evt);
    }
}