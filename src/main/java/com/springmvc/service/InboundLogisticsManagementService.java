package com.springmvc.service;

import com.springmvc.dao.InboundLogisticsManagementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboundLogisticsManagementService {

    @Autowired
    InboundLogisticsManagementDao inboundLogisticsManagementDao;
}
