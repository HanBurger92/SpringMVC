package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "comprehensiveStatement";
    }

    @RequestMapping(value = "/userSetting" , method = RequestMethod.GET)
    public String userSetting(){return "userSetting";}
}
