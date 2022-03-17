package com.tartan.insert.controller;

import com.tartan.insert.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = {"批量插入"})
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserServiceImpl userService;

    @ApiOperation("user插入数据")
    @PostMapping("insertUser")
    public void insert(){
        userService.insert();
    }
}
