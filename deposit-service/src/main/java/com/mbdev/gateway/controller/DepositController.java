package com.mbdev.gateway.controller;

import com.mbdev.gateway.controller.dto.DepositRequestDTO;
import com.mbdev.gateway.controller.dto.DepositResponseDTO;
import com.mbdev.gateway.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {


    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService){
        this.depositService=depositService;
    }

    @PostMapping("/deposits")
    public DepositResponseDTO deposit(@RequestBody DepositRequestDTO requestDTO){
        return depositService.deposit(requestDTO.getAccountId(), requestDTO.getBillId(), requestDTO.getAmount());
    }
}
