package com.example.redis.demo.service;

import com.example.redis.demo.model.User;
import com.example.redis.demo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserDao userDAO;

    public boolean saveUser(User user) {
        return userDAO.saveUser(user);
    }
}
