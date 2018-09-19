package com.fhh.springboot.service;

import com.fhh.springboot.Entity.User1;

/**
 * 功能描述：（）
 * Created by biubiubiu小浩 on 2018-09-17 19:38
 */
public interface UserService {
    public String sayHi(String name);

    public User1 getUserById(int id);
}
