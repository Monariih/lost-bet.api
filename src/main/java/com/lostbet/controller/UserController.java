package com.lostbet.controller;

import com.lostbet.entity.User;
import com.lostbet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> getUsers() throws SQLException {
        return userService.getAllUsers();
    }

}
