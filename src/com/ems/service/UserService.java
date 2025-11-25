package com.ems.service;

import com.ems.dao.UserDAO;
import com.ems.model.User;

public class UserService {
    private UserDAO dao = new UserDAO();

    public User login(String username, String password) {
        return dao.authenticate(username, password);
    }
}