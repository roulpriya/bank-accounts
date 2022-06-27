package com.example.bankaccounts.dto;

import java.util.List;

public class CreateBankAccountRequest {
    private final String accountNumber;
    private final String bankName;
    private final float balance;
    private final long userId;
    private final List<CreateBankingServiceRequest> bankingServices;

    public CreateBankAccountRequest(String accountNumber, String bankName, float balance, long userId, List<CreateBankingServiceRequest> bankingServices) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
        this.userId = userId;
        this.bankingServices = bankingServices;
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

    public long getUserId() {
        return userId;
    }

    public List<CreateBankingServiceRequest> getBankingServices() {
        return bankingServices;
    }
}
