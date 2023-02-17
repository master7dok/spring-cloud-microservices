package com.mbdev.bill.controller;

import com.mbdev.bill.controller.dto.BillRequestDTO;
import com.mbdev.bill.controller.dto.BillResponseDTO;
import com.mbdev.bill.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/{billId}")
    public BillResponseDTO getBill(@PathVariable Long billId){
        return new BillResponseDTO(billService.getBillById(billId));
    }

    @PostMapping("/")
    public Long createBill(@RequestBody BillRequestDTO billRequestDTO){
        return billService.createBill(billRequestDTO.getAccountId(), billRequestDTO.getAmount(), billRequestDTO.getIsDefault(), billRequestDTO.getCreationDate(), billRequestDTO.getOverdraftEnable());
    }

    @PutMapping("/{billId}")
    public BillResponseDTO updateBill(@PathVariable Long billId, @RequestBody BillRequestDTO billRequestDTO){
        return new BillResponseDTO(billService.updateBill(billId,billRequestDTO.getAccountId() ,billRequestDTO.getAmount(),
                billRequestDTO.getIsDefault(), billRequestDTO.getOverdraftEnable()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDTO deleteBill(@PathVariable Long billId){
        return new BillResponseDTO(billService.deleteBill(billId));
    }

    @GetMapping("/account/{accountId}")
    public List<BillResponseDTO> getBillsByAccountId(@PathVariable Long accountId){
        return billService.getBillsByAccountId(accountId)
                .stream()
                .map(BillResponseDTO::new)
                .collect(Collectors.toList());
    }




















}
