package com.mbdev.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String name;

    private String email;

    private String Phone;

    private OffsetDateTime offsetDateTime;

    @ElementCollection
    private List<Long> bills;

    public Account(String name, String email, String phone, OffsetDateTime offsetDateTime, List<Long> bills) {
        this.name = name;
        this.email = email;
        Phone = phone;
        this.offsetDateTime = offsetDateTime;
        this.bills = bills;
    }
}
