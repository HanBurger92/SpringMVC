package com.springmvc.dao;

import com.springmvc.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {

    User login(User user);
}
