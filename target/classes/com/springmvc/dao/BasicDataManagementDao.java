package com.springmvc.dao;

import com.springmvc.entity.Consumer;
import com.springmvc.entity.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("basicDataManagementDao")
public interface BasicDataManagementDao {

    // Supplier business logic
    void insert(Supplier supplier);
    void supplierDelete(String supplierCode);
    List<Supplier> selectSupplier();
    void updateSupplier(Supplier supplier);

    // Consumer Business Logic
    List<Consumer> selectConsumer(Map<String, Object> map);
    void insert(Consumer consumer);

}
