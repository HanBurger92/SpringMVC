package com.springmvc.dao;

import com.springmvc.entity.Inbound;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("inboundLogisticsManagement")
public interface InboundLogisticsManagementDao {

    List<Inbound> selectInbound(Map<String, Object> map);
    void deleteInbound(String inboundReceipt);
    void insertInbound(Inbound inbound);
    void updateInbound(Inbound inbound);
}
