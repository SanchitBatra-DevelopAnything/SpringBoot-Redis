package com.example.redis.demo.repository;

import com.example.redis.demo.model.User;

public interface UserDao {
    public boolean saveUser(User user);
}
