package com.bbsw.practice.supplier.service;

import com.bbsw.practice.supplier.model.SupplierData;
import com.bbsw.practice.supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<SupplierData> findAll(){
        return supplierRepository.findAll();
    }
}
