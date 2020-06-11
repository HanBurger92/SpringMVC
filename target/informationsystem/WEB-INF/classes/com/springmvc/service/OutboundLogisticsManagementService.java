package com.springmvc.service;

import com.springmvc.dao.InboundLogisticsManagementDao;
import com.springmvc.dao.OutboundLogisticsManagementDao;
import com.springmvc.entity.Outbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OutboundLogisticsManagementService {

    @Autowired
    private OutboundLogisticsManagementDao outboundLogisticsManagementDao;

    private static String AUTHORIZATION_ERROR = "This account is not authorized to perform this action";
    private static String DUPLICATE_INSERTION_ERROR = "Duplicated Code, Insertion failed";
    private static String SUCCESS = "Completed";

    public List<Outbound> selectOutbound(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        List<Outbound> list = new ArrayList<>();
        map.put("receipt", request.getParameter("receipt"));
        map.put("supplier", request.getParameter("supplier"));
        map.put("startDate", request.getParameter("startDate"));
        map.put("endDate", request.getParameter("endDate"));

        list = outboundLogisticsManagementDao.selectOutbound(map);
        return list;
    }

    public String insertOutbound(HttpServletRequest request, Outbound outbound){
        HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<>();
        map.put("receipt", outbound.getOutboundReceipt());
        List<Outbound> list = outboundLogisticsManagementDao.selectOutbound(map);

        if(!list.isEmpty()){
            return DUPLICATE_INSERTION_ERROR;
        }else if(!session.getAttribute("role").toString().equals("manager")){
            return AUTHORIZATION_ERROR;
        }else{
            outboundLogisticsManagementDao.insertOutbound(outbound);
            return SUCCESS;
        }
    }

    public String deleteOutbound(HttpServletRequest request, String receipt){
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("manager")){
            return AUTHORIZATION_ERROR;
        }else{
            outboundLogisticsManagementDao.deleteOutbound(receipt);
            return SUCCESS;
        }
    }

    public String updateOutbound(HttpServletRequest request, Outbound outbound){
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("manager")){
            return AUTHORIZATION_ERROR;
        }else{
            outboundLogisticsManagementDao.updateOutbound(outbound);
            return SUCCESS;
        }
    }
}
