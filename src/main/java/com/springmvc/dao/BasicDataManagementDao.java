package com.springmvc.dao;

import com.springmvc.entity.Consumer;
import com.springmvc.entity.Product;
import com.springmvc.entity.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("basicDataManagementDao")
public interface BasicDataManagementDao {

    // Consumer Business Logic
    List<Consumer> selectConsumer(Map<String, Object> map);
    void insertConsumer(Consumer consumer);
    void updateConsumer(Consumer consumer);
    void deleteConsumer(String consumerCode);

    // Supplier business logic
    void insertSupplier(Supplier supplier);
    void deleteSupplier(String supplierCode);
    List<Supplier> selectSupplier(Map<String, Object> map);
    void updateSupplier(Supplier supplier);

    //Product business logic
    List<Product> selectProduct(Map<String, Object> map);
    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(String productCode);
}
