package com.tartan.logsimulator.task;

import com.tartan.logsimulator.netty.handler.InformationHandler;
import org.apache.commons.io.FileUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class GrTask {

    private Integer index = 0;

    @Scheduled(fixedRate = 1000L)
    public void transGr() throws IOException {

        List<String> grList = FileUtils.readLines(new File("./gr.txt"), "UTF-8");
        int size = grList.size();
        if (InformationHandler.currentChannel.isOpen()) {
            InformationHandler.currentChannel.writeAndFlush(grList.get(index++));
        }
        if(index.equals(size-1))
            index = 0;
    }
}
