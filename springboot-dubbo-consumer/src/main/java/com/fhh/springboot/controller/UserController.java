package com.fhh.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fhh.springboot.Entity.User1;
import com.fhh.springboot.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：（）
 * Created by biubiubiu小浩 on 2018-09-16 15:4
 */
@RestController
public class UserController {
    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping(value = "/sayHi")
    public String addUser(String userName){
        String hi = userService.sayHi(userName);
        return  hi;
    }

    @RequestMapping(value = "/findUser")
    public User1 findUser(int id){
      return userService.getUserById(id);
    }
}
