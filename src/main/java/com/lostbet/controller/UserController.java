package com.lostbet.controller;

import com.lostbet.model.User;
import com.lostbet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/v1/users")
    public List<User> getUsers() {
        return userService.listUsers();
    }

    @PostMapping(value = "/v1/create")
    public User getUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(value = "/v1/user/{usercpf}")
    public User getUser(@PathVariable long usercpf) {
        return userService.getUser(usercpf);
    }

    @PutMapping(value = "/v1/user/{usercpf}")
    public User depositUser(@RequestBody User user) {
        return userService.deposit(user);
    }

    @DeleteMapping(value = "/v1/user/{usercpf}")
    public User deleteUser(@PathVariable long usercpf) {
        return userService.delete(usercpf);
    }

}
