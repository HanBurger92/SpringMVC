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


@Controller
@SessionAttributes({"username","password","role"}) // save user information to session
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;
    private User user;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    public String home(){
        return "home";
    }

    /**
     * Check userName and password input by the user at login page
     * save the information to the session (by annotation @SessionAttribute and ModelMap)
     * @param userName
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String userName, @RequestParam String password, ModelMap model){
        user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        model.addAttribute("username", userName);
        model.addAttribute("password", password);

        if(userService.login(user) == null){
            return "loginFail";
        }else{
            model.addAttribute("role", userService.login(user).getRole()); // add Role to Session for authority check
            return "redirect:/mainPage";
        }
    }
}
