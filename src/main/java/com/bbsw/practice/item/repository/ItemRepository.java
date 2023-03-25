package com.bbsw.practice.item.repository;

import com.bbsw.practice.item.model.ItemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<ItemData,Long> {
    //Nombrar metodos
}
