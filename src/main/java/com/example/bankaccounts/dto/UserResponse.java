package com.example.bankaccounts.dto;

import java.util.List;

public class UserResponse {

    private final long id;
    private final String name;
    private final String email;
    private final String phone;

    private final List<BankAccountResponse> bankAccounts;

    public UserResponse(long id, String name, String email, String phone, List<BankAccountResponse> bankAccounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bankAccounts = bankAccounts;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<BankAccountResponse> getBankAccounts() {
        return bankAccounts;
    }
}
