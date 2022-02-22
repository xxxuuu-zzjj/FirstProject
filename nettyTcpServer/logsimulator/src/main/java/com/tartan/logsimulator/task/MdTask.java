package com.tartan.logsimulator.task;

import com.tartan.logsimulator.netty.RxtxNettyClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MdTask {

    public static RxtxNettyClient rxtxNettyClient;

    String depthStr = "&&\r\n" + "1984Tartan/DTU\r\n" + "010519700101\r\n" + "0106015531\r\n" + "010811.00\r\n" + "011011.00\r\n" +
            "0112-999.25\r\n" + "011312.28\r\n" + "0114-6.10\r\n" + "01150.00\r\n" + "0117-999.25\r\n" + "0120-999.25\r\n" +
            "0123-999.25\r\n" + "0124-999.25\r\n" + "0141-999.25\r\n" + "0142-999.25\r\n" + "0143-999.25\r\n" + "0144-999.25\r\n" +
            "0145-999.25\r\n" + "0146-999.25\r\n" + "0147-999.25\r\n" + "0148-999.25\r\n" + "0149-999.25\r\n" + "0150-999.25\r\n" +
            "0151-999.25\r\n" + "0152-999.25\r\n" + "!!";

    @Scheduled(fixedRate = 1000L)
    public void transMd(){
        String[] stringList = depthStr.split("\n");
        String subStr = null;
        StringBuffer strBuff = new StringBuffer();
        for (String s : stringList) {
            if(s.length()>4)
                subStr = s.substring(0,4);
            else{
                strBuff.append(s);
                continue;
            }
            if(subStr.equals("0108") || subStr.equals("0110")){
                String updateStr = s.substring(4);
                Float depth = Float.valueOf(updateStr)+1;
                s = subStr+depth;
            }
            strBuff.append(s);
        }
        System.out.println(strBuff);
        rxtxNettyClient.channel.writeAndFlush(strBuff.toString());
    }
}
