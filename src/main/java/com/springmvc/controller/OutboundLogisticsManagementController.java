package com.springmvc.controller;

import com.springmvc.entity.Outbound;
import com.springmvc.service.OutboundLogisticsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mainPage/outboundLogisticsManagement")
public class OutboundLogisticsManagementController {

    @Autowired
    private OutboundLogisticsManagementService outboundLogisticsManagementService;

    @RequestMapping(value = "/selectOutbound", method = RequestMethod.POST)
    public ModelAndView outboundSelect(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("outboundList", outboundLogisticsManagementService.selectOutbound(request));
        modelAndView.setViewName("outboundLogisticsManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/insertOutbound", method = RequestMethod.POST)
    public ModelAndView outboundInsert(Outbound outbound, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",outboundLogisticsManagementService.insertOutbound(request, outbound));
        modelAndView.setViewName("outboundLogisticsManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteOutbound", method = RequestMethod.GET)
    public ModelAndView outboundDelete(String outboundReceipt, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", outboundLogisticsManagementService.deleteOutbound(request, outboundReceipt));
        modelAndView.setViewName("outboundLogisticsManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/updateOutbound", method = RequestMethod.POST)
    public ModelAndView outboundUpdate(Outbound outbound, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", outboundLogisticsManagementService.updateOutbound(request,outbound));
        modelAndView.setViewName("outboundLogisticsManagement");
        return modelAndView;
    }
}