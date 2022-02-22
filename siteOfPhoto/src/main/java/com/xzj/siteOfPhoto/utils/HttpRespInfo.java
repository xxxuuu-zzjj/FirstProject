package com.xzj.siteOfPhoto.utils;

import lombok.Data;

@Data
public class HttpRespInfo {
    private Integer statusCode;
    private String content;

    public HttpRespInfo(Integer statusCode, String content) {
        this.statusCode = statusCode;
        this.content = content;
    }
}
