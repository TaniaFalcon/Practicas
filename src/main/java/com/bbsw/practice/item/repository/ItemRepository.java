package com.bbsw.practice.item.repository;


import com.bbsw.practice.item.StateEnum;
import com.bbsw.practice.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findByState(StateEnum state);
    Item findByItemCode(BigDecimal itemCode);
}
