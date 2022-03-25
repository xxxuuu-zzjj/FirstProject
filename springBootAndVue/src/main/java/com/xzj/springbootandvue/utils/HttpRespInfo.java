package com.xzj.springbootandvue.utils;

import lombok.Data;

/**
 * @author Yiheng Lin
 * @date 2020/8/28 15:03
 */
@Data
public class HttpRespInfo {
    private Integer statusCode;
    private String content;

    public HttpRespInfo(Integer statusCode, String content) {
        this.statusCode = statusCode;
        this.content = content;
    }
}
