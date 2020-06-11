package com.springmvc.controller;

import com.springmvc.entity.Inbound;
import com.springmvc.service.InboundLogisticsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mainPage/inboundLogisticsManagement")
public class InboundLogisticsManagementController {

    @Autowired
    private InboundLogisticsManagementService inboundLogisticsManagementService;

    @RequestMapping(value = "/selectInbound", method = RequestMethod.POST)
    public ModelAndView inboundSelect(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("inboundList", inboundLogisticsManagementService.selectInbound(request));
        modelAndView.setViewName("inboundLogisticsManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/insertInbound", method = RequestMethod.POST)
    public ModelAndView inboundInsert(Inbound inbound, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",inboundLogisticsManagementService.insertInbound(inbound, request));
        modelAndView.setViewName("inboundLogisticsManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteInbound", method = RequestMethod.GET)
    public ModelAndView inboundDelete(String inboundReceipt, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", inboundLogisticsManagementService.deleteInbound(inboundReceipt, request));
        modelAndView.setViewName("inboundLogisticsManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/updateInbound", method = RequestMethod.POST)
    public ModelAndView inboundUpdate(Inbound inbound, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", inboundLogisticsManagementService.updateInbound(inbound, request));
        modelAndView.setViewName("inboundLogisticsManagement");
        return modelAndView;
    }
}
