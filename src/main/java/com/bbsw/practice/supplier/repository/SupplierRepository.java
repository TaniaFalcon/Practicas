package com.bbsw.practice.supplier.repository;

import com.bbsw.practice.supplier.model.SupplierData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierData,Long>  {

    List<SupplierData> findAll();
}
