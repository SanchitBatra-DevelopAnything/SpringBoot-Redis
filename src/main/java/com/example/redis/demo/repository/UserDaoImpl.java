package com.example.redis.demo.repository;

import com.example.redis.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER"; //hash key for all user objects to be stored.

    @Override
    public boolean saveUser(User user) {
        try
        {
            //HASH_KEY_FOR_ALL_DOMAIN_OBJECTS , KEY FOR THIS OBJECT , VALUE OF THIS OBJECT.
            redisTemplate.opsForHash().put(KEY , user.getId()+"" , user);
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
