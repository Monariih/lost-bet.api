package com.lostbet.controller;

import com.lostbet.entity.User;
import com.lostbet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/v1/users")
    public List<User> getUsers() throws SQLException {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/v1/user/{cpf}")
    public User getUser(@PathVariable long cpf) throws SQLException {
        return userService.getUser(cpf);
    }

    @PatchMapping(value = "/v1/user/{cpf}")
    public User updateBalance(@PathVariable long cpf,@RequestBody User user) throws SQLException {
        return userService.updateUser(cpf, user);
    }
}
