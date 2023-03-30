package com.bbsw.practice.item.model;

import com.bbsw.practice.item.ReasonEnum;
import com.bbsw.practice.user.model.UserData;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="desactiveitems")
public class Desactive {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "desactivesequence")
    @SequenceGenerator(name = "desactivesequence", sequenceName = "desactivesequence", allocationSize = 1, schema = "erp")
    @Column(name="iddesactive")
    Long idDesactive;
    @Column(name="reason")
    @Enumerated(EnumType.STRING)
    ReasonEnum reason;
    @Column(name = "register")
    LocalDate register;
    @ManyToOne
    @JoinColumn(name="item")
    @JsonBackReference("desactiveitem")
    Item item;
    @ManyToOne
    @JoinColumn(name="username")
    @JsonBackReference("desactiveuser")
    UserData username;
}
