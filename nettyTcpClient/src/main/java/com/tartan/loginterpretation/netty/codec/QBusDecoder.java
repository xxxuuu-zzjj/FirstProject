package com.tartan.loginterpretation.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lin Yiheng
 * @date 2021/11/22
 * @Description 用于处理从仪器传来的wits数据，并将其按wits会话进行分割解析
 */
@Slf4j
public class QBusDecoder extends ByteToMessageDecoder{
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("depending");
        String content = in.toString(CharsetUtil.UTF_8);
        log.info("Content:"+content);
        String regex = "\\[\r\n";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        int endIndex = -1;
        while (m.find()) {
            out.add(m.group());
            endIndex = m.end();
        }
        if (endIndex >= 0) {
            in.readerIndex(endIndex);
        }
    }
}
