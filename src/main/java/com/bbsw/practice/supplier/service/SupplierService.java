package com.bbsw.practice.supplier.service;

import com.bbsw.practice.supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;


}
