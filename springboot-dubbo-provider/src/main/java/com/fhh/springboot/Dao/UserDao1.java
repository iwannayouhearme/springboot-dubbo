package com.fhh.springboot.Dao;

import com.fhh.springboot.Entity.User1;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能描述：（）
 * Created by biubiubiu小浩 on 2018-09-16 15:24
 */
@Mapper
public interface UserDao1 {
    int deleteByPrimaryKey(Integer id);

    int insert(User1 record);

    int insertSelective(User1 record);

    User1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User1 record);

    int updateByPrimaryKey(User1 record);
}
