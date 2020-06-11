package com.springmvc.dao;

import com.springmvc.entity.Outbound;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("outboundLogisticsManagement")
public interface OutboundLogisticsManagementDao {

    List<Outbound> selectOutbound(Map<String, Object> map);
    void insertOutbound(Outbound outbound);
    void deleteOutbound(String outboundReceipt);
    void updateOutbound(Outbound outbound);
}
