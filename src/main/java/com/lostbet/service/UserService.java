package com.lostbet.service;

import com.lostbet.model.User;
import com.lostbet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUser(long usercpf) {
        Optional<User> user = userRepository.findByUsercpf(usercpf);
        return user.orElseGet(User::new);
    }

    public User deposit(User user) {
        return userRepository.save(user);
    }

    public User delete(long usercpf) {
        return null;
    }

}
