package com.xzj.springbootandvue.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Slf4j
@RestController
public class uploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
    //TODO: 多个文件上传 遍历单次上传
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req){
        //上传应该选择绝对路径  待定
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile");
        String format = sdf.format(new Date());
        File folder = new File(realPath+format);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        //getName方法得到的文件名没有后缀
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
        try {
            uploadFile.transferTo(new File(folder, newName));   //文件保存操作
            String filePath = req.getScheme() + "://" + req.getServerName()
                    + ":" + req.getServerPort() + "/uploadFile" + format + newName;
            return filePath;
        }catch (IOException e){
            e.printStackTrace();
        }
        return "upload fail";
    }

}
