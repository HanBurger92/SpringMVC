package com.springmvc.service;

import com.springmvc.dao.BasicDataManagementDao;
import com.springmvc.entity.Consumer;
import com.springmvc.entity.Product;
import com.springmvc.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BasicDataManagementService {

    @Autowired
    private BasicDataManagementDao basicDataManagementDao;

    // Consumer Service
    public List<Consumer> consumerSelect(Map<String, Object> map){
        return basicDataManagementDao.selectConsumer(map);
    }
    public void insertConsumer(Consumer consumer){
        basicDataManagementDao.insertConsumer(consumer);
    }
    public void deleteConsumer(String consumerCode) {basicDataManagementDao.deleteConsumer(consumerCode);}
    public void updateConsumer(Consumer consumer) {basicDataManagementDao.updateConsumer(consumer);}

    // Supplier Service
    public List<Supplier> supplierSelect(Map<String, Object> map){
        return basicDataManagementDao.selectSupplier(map);
    }
    public void insertSupplier(Supplier supplier){ basicDataManagementDao.insertSupplier(supplier); }
    public void deleteSupplier(String supplierCode) {basicDataManagementDao.deleteSupplier(supplierCode);}
    public void updateSupplier(Supplier supplier) {basicDataManagementDao.updateSupplier(supplier);}

    // Product Service
    public List<Product> productSelect(Map<String, Object> map){ return basicDataManagementDao.selectProduct(map); }
    public void insertProduct(Product product){ basicDataManagementDao.insertProduct(product); }
    public void deleteProduct(String productCode) {basicDataManagementDao.deleteProduct(productCode);}
    public void updateProduct(Product product) {basicDataManagementDao.updateProduct(product);}
}
