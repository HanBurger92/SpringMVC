package com.springmvc.controller;

import com.springmvc.service.InboundLogisticsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mainPage/inboundLogisticsManagement")
public class inboundLogisticsController {

    @Autowired
    InboundLogisticsManagementService inboundLogisticsManagementService;

    @RequestMapping(value = "/inboundSelect", method = RequestMethod.POST)
    public ModelAndView inboundSelect(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("inboundLogisticsManagement");
        return modelAndView;
    }
}
