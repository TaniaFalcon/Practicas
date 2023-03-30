package com.bbsw.practice.user.model;

import com.bbsw.practice.item.model.Desactive;
import com.bbsw.practice.item.model.Item;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="userdata")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersequence")
    @SequenceGenerator(name="usersequence", sequenceName = "usersequence", allocationSize = 1, schema = "erp")
    @Column(name="iduser")
    Long idUser;
    @Column(name="username", unique = true, nullable = false)
    String username;
    @Column(name="password", nullable = false)
    String password;
    @OneToMany(mappedBy = "userdata", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference("useritem")
    List<Item> items;

    @OneToMany(mappedBy = "username", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference("desactiveuser")
    List<Desactive> desactive;
}
