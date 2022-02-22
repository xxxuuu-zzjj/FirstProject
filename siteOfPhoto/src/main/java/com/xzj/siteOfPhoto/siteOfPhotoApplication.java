package com.xzj.siteOfPhoto;

import com.xzj.siteOfPhoto.utils.siteByPhoto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class siteOfPhotoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(siteOfPhotoApplication.class, args);
        File file = new File("C:\\project\\XU\\weibo.jpg");
        siteByPhoto.readImageInfo(file);
    }

}
