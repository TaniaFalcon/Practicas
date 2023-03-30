package com.bbsw.practice.price.service;

import com.bbsw.practice.price.repository.PriceReductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceReductionService {

    @Autowired
    PriceReductionRepository priceReductionRepository;

}
