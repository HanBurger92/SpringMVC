package com.springmvc.dao;

import com.springmvc.entity.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("basicDataManagementDao")
public interface BasicDataManagementDao {

    // Supplier business logic
    void insert(Supplier supplier);
    void supplierDelete(String supplierCode);
    List<Supplier> selectSupplier();
    void updateSupplier(Supplier supplier);

}
