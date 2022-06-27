package com.example.bankaccounts.mappers;

import com.example.bankaccounts.dto.UserResponse;
import com.example.bankaccounts.entities.User;

public class UserMapper {
    public static UserResponse map(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                BankAccountMapper.map(user.getBankAccounts())
        );
    }
}
