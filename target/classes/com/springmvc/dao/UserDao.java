package com.springmvc.dao;

import com.springmvc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userDao")
public interface UserDao {

    User login(User user);
    List<User> userSelect(Map<String, Object> map);
    void userInsert(User user);
    void deleteUser(Integer id);
    void updateUser(User user);
}
