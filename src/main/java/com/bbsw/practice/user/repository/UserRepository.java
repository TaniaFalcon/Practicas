package com.bbsw.practice.user.repository;

import com.bbsw.practice.user.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData,Long> {

    UserData findByUsername(String username);

}
