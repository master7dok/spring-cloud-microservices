package com.mbdev.gateway.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deposit;
    private BigDecimal amount;
    private Long billId;
    private OffsetDateTime offsetDateTime;

    private String email;

    public Deposit(BigDecimal amount, Long billId, OffsetDateTime now, String email) {
        this.amount = amount;
        this.billId = billId;
        this.offsetDateTime = offsetDateTime;
        this.email = email;
    }
}
