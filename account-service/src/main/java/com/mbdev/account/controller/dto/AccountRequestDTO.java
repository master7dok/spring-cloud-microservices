package com.mbdev.account.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor

public class AccountRequestDTO {

    private Long accountId;

    private String name;

    private String email;

    private String Phone;

    private List<Long> bills;

    private OffsetDateTime offsetDateTime;
}
