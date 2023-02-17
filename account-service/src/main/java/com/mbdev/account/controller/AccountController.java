package com.mbdev.account.controller;

import com.mbdev.account.controller.dto.AccountRequestDTO;
import com.mbdev.account.controller.dto.AccountResponseDTO;
import com.mbdev.account.controller.service.AccountService;
import com.mbdev.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountService accountService;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountService accountService,
                             AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/{accountId}")
    public AccountResponseDTO getAccount(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.getAccountById(accountId));
    }

    @PostMapping("/")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.createAccount(accountRequestDTO.getName(), accountRequestDTO.getEmail(),
                accountRequestDTO.getPhone(), accountRequestDTO.getBills());
    }


    @PutMapping("/{accountId")
    public AccountResponseDTO updateAccount(@PathVariable Long accountId, @RequestBody AccountRequestDTO accountRequestDTO){
       return new AccountResponseDTO(accountService.updateAccount(accountId,accountRequestDTO.getName(), accountRequestDTO.getEmail(),
               accountRequestDTO.getPhone(), accountRequestDTO.getBills()));
    }


    @DeleteMapping("/{accountId")
    public AccountResponseDTO deleteAccount(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.deleteAccount(accountId));
    }



}
