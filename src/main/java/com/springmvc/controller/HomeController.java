package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;
    private User user;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));

        if(userService.login(user) == null){
            return "loginFail";
        }else{
            user = userService.login(user);
            session.setAttribute("username",user.getUserName());
            session.setAttribute("role", user.getRole());
            return "redirect:/mainPage";
        }
    }
}
