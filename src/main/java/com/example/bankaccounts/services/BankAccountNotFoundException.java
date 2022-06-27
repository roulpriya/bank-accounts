package com.example.bankaccounts.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BankAccountNotFoundException extends ResponseStatusException {
    public BankAccountNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Bank account not found");
    }
}
