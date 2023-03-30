package com.bbsw.practice.item.repository;


import com.bbsw.practice.item.model.Desactive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesactiveRepository extends JpaRepository<Desactive,Long> {

}
