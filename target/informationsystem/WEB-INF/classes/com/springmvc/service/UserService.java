package com.springmvc.service;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User login(User user){
        return userDao.login(user);
    }
}
