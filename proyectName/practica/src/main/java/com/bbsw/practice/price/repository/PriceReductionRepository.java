package com.bbsw.practice.price.repository;

import com.bbsw.practice.price.model.PriceReductionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceReductionRepository extends JpaRepository<PriceReductionData,Long> {
}
