package com.springmvc.service;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    private static String AUTHORIZATION_ERROR = "This account is not authorized to perform this action";
    private static String DUPLICATE_INSERTION_ERROR = "Duplicated Code, Insertion failed";
    private static String SUCCESS = "Completed";

    public User login(User user){
        return userDao.login(user);
    }

    public List<User> selectUser(Map<String, Object> map){
        return userDao.userSelect(map);
    }

    public String insertUser(HttpServletRequest request, User user){
        HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<>();
        List<User> list = new ArrayList<>();

        map.put("username",user.getUserName());
        list = userDao.userSelect(map);

        if(!list.isEmpty()){
            return DUPLICATE_INSERTION_ERROR;
        }else if(!session.getAttribute("role").toString().equals("admin")){
            return AUTHORIZATION_ERROR;
        }else {
            userDao.userInsert(user);
            return SUCCESS;
        }
    }

    public String deleteUser(HttpServletRequest request, Integer id){
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("admin")){
            return AUTHORIZATION_ERROR;
        }else {
            userDao.deleteUser(id);
            return SUCCESS;
        }
    }

    public String updateUser(HttpServletRequest request, User user){
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("admin")){
            return AUTHORIZATION_ERROR;
        }else {
            userDao.updateUser(user);
            return SUCCESS;
        }
    }
}
