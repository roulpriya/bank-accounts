package com.example.bankaccounts.dto;

import java.util.List;

public class BankAccountResponse {
    private final Long accountId;
    private final String accountNumber;
    private final String bankName;
    private final float balance;
    private final List<BankingServiceResponse> bankingServices;


    public BankAccountResponse(Long accountId, String accountNumber, String bankName, float balance, List<BankingServiceResponse> bankingServices) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
        this.bankingServices = bankingServices;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public float getBalance() {
        return balance;
    }

    public List<BankingServiceResponse> getBankingServices() {
        return bankingServices;
    }
}
