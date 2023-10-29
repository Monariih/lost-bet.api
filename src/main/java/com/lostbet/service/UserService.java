package com.lostbet.service;

import com.lostbet.dao.UserCreateDAO;
import com.lostbet.dao.UserDAO;
import com.lostbet.entity.User;
import com.lostbet.entity.UserCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserCreateDAO userCreateDAO;

    public User updateUser(long cpf, User user) throws SQLException{
        return userDAO.updateUser(cpf, user);
    }
    public User getUser(long cpf) throws SQLException {
        return userDAO.getUser(cpf);
    }
    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public UserCreate saveUser(UserCreate userCreate) throws Exception{
        Long cpf = userCreateDAO.createUser(userCreate);
        if (cpf != null) {
            userCreate.setCpf(cpf);
            return userCreate;
        } else {
            return null;
        }
    }

}
