package com.example.bankaccounts.mappers;

import com.example.bankaccounts.dto.BankAccountResponse;
import com.example.bankaccounts.entities.BankAccount;

import java.util.List;
import java.util.stream.Collectors;

public class BankAccountMapper {
    public static BankAccountResponse map(BankAccount bankAccount) {
        return new BankAccountResponse(
                bankAccount.getAccountId(),
                bankAccount.getAccountNumber(),
                bankAccount.getBankName(),
                bankAccount.getBalance(),
                BankingServiceMapper.map(bankAccount.getBankingServices())
        );
    }

    public static List<BankAccountResponse> map(List<BankAccount> bankAccounts) {
        return bankAccounts.stream()
                .map(BankAccountMapper::map)
                .collect(Collectors.toList());
    }
}
