package com.springmvc.service;

import com.springmvc.dao.InboundLogisticsManagementDao;
import com.springmvc.entity.Inbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InboundLogisticsManagementService {

    @Autowired
    private InboundLogisticsManagementDao inboundLogisticsManagementDao;

    private static String AUTHORIZATION_ERROR = "This account is not authorized to perform this action";
    private static String DUPLICATE_INSERTION_ERROR = "Duplicated Code, Insertion failed";
    private static String SUCCESS = "Completed";

    public List<Inbound> selectInbound(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        List<Inbound> inboundList = new ArrayList<>();
        map.put("receipt", request.getParameter("inboundReceipt"));
        map.put("supplier", request.getParameter("supplier"));
        map.put("startDate", request.getParameter("startDate"));
        map.put("endDate", request.getParameter("endDate"));
        inboundList = inboundLogisticsManagementDao.selectInbound(map);
        return inboundList;
    }

    public String insertInbound(Inbound inbound, HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<>();
        List<Inbound> list = new ArrayList<>();

        map.put("receipt", inbound.getInboundReceipt());
        list = inboundLogisticsManagementDao.selectInbound(map); // Check isDuplicate

        if(!list.isEmpty()){
            return DUPLICATE_INSERTION_ERROR;
        }else if(!session.getAttribute("role").toString().equals("manager")){
            return AUTHORIZATION_ERROR;
        }else{
            inboundLogisticsManagementDao.insertInbound(inbound);
            return SUCCESS;
        }
    }

    public String deleteInbound(String inboundReceipt, HttpServletRequest request){
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("manager")){
            return AUTHORIZATION_ERROR;
        }else{
            inboundLogisticsManagementDao.deleteInbound(inboundReceipt);
            return SUCCESS;
        }
    }

    public String updateInbound(Inbound inbound, HttpServletRequest request){
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("manager")){
            return AUTHORIZATION_ERROR;
        }else {
            inboundLogisticsManagementDao.updateInbound(inbound);
            return SUCCESS;
        }
    }
}
