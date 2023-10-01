package com.lostbet.service;

import com.lostbet.dao.UserDAO;
import com.lostbet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

}
