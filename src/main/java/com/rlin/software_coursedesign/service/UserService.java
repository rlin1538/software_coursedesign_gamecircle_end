package com.rlin.software_coursedesign.service;

import com.rlin.software_coursedesign.dao.UserDAO;
import com.rlin.software_coursedesign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userDAO.findByUserName(username);
    }

    public User get(String username, String password){
        return userDAO.getByUserNameAndUserPassword(username, password);
    }

    public void add(User user) {
        userDAO.save(user);
    }

    public  void change(User user) { userDAO.save(user); }
}
