package com.springmvc.service;

import com.springmvc.dao.BasicDataManagementDao;
import com.springmvc.entity.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BasicDataManagementService {

    @Autowired
    private BasicDataManagementDao basicDataManagementDao;

    public List<Consumer> select(Map<String, Object> map){
        return basicDataManagementDao.selectConsumer(map);
    }

    public void insert(Consumer consumer){
        basicDataManagementDao.insert(consumer);
    }
}
