package com.bbsw.practice.supplier.repository;

import com.bbsw.practice.supplier.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long>  {

    List<Supplier> findAll();
    Supplier findByName(String name);
    List<Supplier> findByNameIn(List<String> names);
}
