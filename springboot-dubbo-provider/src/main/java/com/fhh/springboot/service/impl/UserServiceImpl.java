package com.fhh.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fhh.springboot.Dao.UserDao1;
import com.fhh.springboot.Entity.User1;
import com.fhh.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * 功能描述：（）
 * Created by biubiubiu小浩 on 2018-09-18 20:07
 */
/*dubbo注解*/
@Service(version = "1.0.0")
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao1 userDao;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    private static final RedisSerializer redisSerializer = new StringRedisSerializer();

    @Override
    public String sayHi(String name) {
        return "Hi,SpringBoot-Dubbo"+name;
    }

    @Override
    public User1 getUserById(int id) {
        redisTemplate.setKeySerializer(redisSerializer);
        User1 user = (User1) redisTemplate.opsForValue().get("userNew" + id);
        //高并发情况下，存在缓存穿透，此处用双重检测锁
        if (null == user) {
            synchronized (this){
                user = (User1) redisTemplate.opsForValue().get("userNew" + id);
                if (null == user) {
                    System.out.println("查询数据库");
                    user = userDao.selectByPrimaryKey(id);
                    if (!ObjectUtils.isEmpty(user)) {
                        redisTemplate.opsForValue().set("userNew" + id, user);
                    }
                }
                if (ObjectUtils.isEmpty(user)) {
                    return new User1("未查找到该用户！", 0, 0);
                }
            }
        }else {
            System.out.println("查询缓存");
        }
        return user;
    }
}
