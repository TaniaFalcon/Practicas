package com.bbsw.practice.user.model;

import com.bbsw.practice.item.model.ItemData;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="userdata")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    @SequenceGenerator(name="userSequence", sequenceName = "userSequence", allocationSize = 1, schema = "erp")
    @Column(name="iduser")
    Long idUser;

    @Column(name="username", unique = true)
    String username;

    @Column(name="password")
    String password;

    @OneToMany(mappedBy = "userData", cascade = CascadeType.ALL)
    List<ItemData> itemDataList;
}
