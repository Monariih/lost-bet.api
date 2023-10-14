package com.lostbet.controller;

import com.lostbet.entity.UserCreate;
import com.lostbet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/create")
public class UserCreateController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public UserCreate saveUser(@RequestBody UserCreate user) throws Exception{
        return userService.saveUser(user);
    }
}
