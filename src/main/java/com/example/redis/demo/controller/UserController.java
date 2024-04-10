package com.example.redis.demo.controller;

import com.example.redis.demo.model.User;
import com.example.redis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user)
    {
        boolean result = userService.saveUser(user);
        if(result)
        {
            return ResponseEntity.ok("CREATED USER SUCCESSFULLY");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> fetchAllUsers()
    {
        List<User> users;
        users = userService.fetchAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> fetchUser(@PathVariable("id") long id)
    {
        User user;
        user = userService.fetchUser(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id)
    {
        //delete will be done as per the repository method given
        return ResponseEntity.ok("DELETED");
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id , @RequestBody User user)
    {
        // delete the user , and then save the user again to update that user.
        return ResponseEntity.ok(new User());
    }
}
