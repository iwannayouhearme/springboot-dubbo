package com.fhh.springboot.Entity;

import java.io.Serializable;

/**
 * 功能描述：（）
 * Created by biubiubiu小浩 on 2018-09-15 22:48
 */
public class User1 implements Serializable{
    private String userName;
    private Integer age;
    private Integer id;

    public User1(){

    }
    public User1(String userName, Integer age, Integer id){
       this.userName = userName;
       this.age = age;
       this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
