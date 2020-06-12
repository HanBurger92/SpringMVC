package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/mainPage/userSetting")
public class UserSettingController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    public ModelAndView userSelect(@RequestParam Map<String, Object> params){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userService.selectUser(params));
        modelAndView.setViewName("userSetting");
        return modelAndView;
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public ModelAndView userInsert(HttpServletRequest request, @RequestParam Map<String, Object> params){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUserName(params.get("userName").toString());
        user.setPassword(params.get("password").toString());
        user.setRole(params.get("role").toString());

        modelAndView.addObject("msg", userService.insertUser(request, user));
        modelAndView.setViewName("userSetting");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView userDelete(HttpServletRequest request, Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", userService.deleteUser(request, id));
        modelAndView.setViewName("userSetting");
        return modelAndView;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ModelAndView userUpdate (HttpServletRequest request, User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", userService.updateUser(request, user));
        modelAndView.setViewName("userSetting");
        return modelAndView;
    }
}
