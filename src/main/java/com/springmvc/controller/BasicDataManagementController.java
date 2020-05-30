package com.springmvc.controller;

import com.springmvc.entity.Consumer;
import com.springmvc.service.BasicDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mainPage/basicDataManagement")
public class BasicDataManagementController {

    @Autowired
    private BasicDataManagementService basicDataManagementService;

    // Consumer query
    @RequestMapping(value = "/consumerSelect", method = RequestMethod.POST)
    public ModelAndView consumerSelect(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Consumer> consumerList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", request.getParameter("code"));
        map.put("name", request.getParameter("name"));
        map.put("linkman", request.getParameter("linkman"));
        consumerList = basicDataManagementService.select(map);
        modelAndView.setViewName("basicDataManagement");
        modelAndView.addObject(consumerList);
        return modelAndView;
    }

    @RequestMapping(value = "/consumerInsert", method = RequestMethod.POST)
    public void consumerInsert(Consumer consumer){
        basicDataManagementService.insert(consumer);
    }

    @RequestMapping(value = "/supplierSelect", method = RequestMethod.POST)
    public void supplierSelect(){

    }

    @RequestMapping(value = "/productSelect", method = RequestMethod.POST)
    public void productSelect(){

    }


}
