package com.springmvc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mainPage")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(){
        return "mainPage";
    }

    @RequestMapping(value = "/basicDataManagement", method = RequestMethod.GET)
    public String basicDataManagement(){
        return "basicDataManagement";
    }

    @RequestMapping(value = "/inboundLogisticsManagement", method = RequestMethod.GET)
    public String inboundLogisticsManagement(){
        return "inboundLogisticsManagement";
    }

    @RequestMapping(value = "/outboundLogisticsManagement", method = RequestMethod.GET)
    public String outboundLogisticsManagement(){
        return "outboundLogisticsManagement";
    }

    @RequestMapping(value = "/comprehensiveStatement", method = RequestMethod.GET)
    public String comprehensiveStatement(){
        return "userSetting";
    }

    @RequestMapping(value = "/userSetting" , method = RequestMethod.GET)
    public ModelAndView userSetting(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        if(!session.getAttribute("role").toString().equals("admin")){
            modelAndView.addObject("msg","this account is not authorized to use this function");
            modelAndView.setViewName("mainPage");
            return modelAndView;
        }else {
            modelAndView.setViewName("userSetting");
            return modelAndView;
        }
    }
}
