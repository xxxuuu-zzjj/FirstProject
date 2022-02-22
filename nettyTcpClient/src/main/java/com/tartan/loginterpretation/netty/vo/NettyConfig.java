package com.tartan.loginterpretation.netty.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class NettyConfig {
    private String nettyServerType; // netty服务类型
    // Rxtx的相关配置项
    private Integer baudrate; //波特率
    private String comAddr; //串口地址

    // TcpSock及WebSock的相关配置项
    private String ip;
    private Integer port; // 启动端口
    private String protocal; //传输的内容协议WITS, QBus
}
