package com.example.bankaccounts.controllers;


import com.example.bankaccounts.dto.BankAccountResponse;
import com.example.bankaccounts.dto.CreateBankAccountRequest;
import com.example.bankaccounts.entities.ServiceType;
import com.example.bankaccounts.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-account")
public class BankAccountController {

    private final BankAccountService bankService;

    @Autowired
    public BankAccountController(BankAccountService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{accountId}")
    public BankAccountResponse getBankAccount(@PathVariable long accountId) {
        return bankService.get(accountId);
    }

    @PostMapping("/")
    public BankAccountResponse createBankAccount(@RequestBody CreateBankAccountRequest request) {
        return bankService.create(request);

    }

    @GetMapping("/")
    public List<BankAccountResponse> getAllBankAccountsByService(@RequestParam("SERVICE_TYPE") ServiceType serviceType) {
        return bankService.getAllBankAccountsByService(serviceType);
    }

}

