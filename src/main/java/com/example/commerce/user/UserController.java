package com.example.commerce.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<User> AllUser(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] notFound",id));
        }
        return user;
    }

}
