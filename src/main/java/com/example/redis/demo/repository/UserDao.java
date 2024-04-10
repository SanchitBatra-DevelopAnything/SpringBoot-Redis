package com.example.redis.demo.repository;

import com.example.redis.demo.model.User;

import java.util.List;

public interface UserDao {
    public boolean saveUser(User user);

    List<User> fetchAllUsers();
}
