package com.example.bankaccounts.mappers;

import com.example.bankaccounts.dto.BankingServiceResponse;
import com.example.bankaccounts.entities.BankingService;

import java.util.List;
import java.util.stream.Collectors;

public class BankingServiceMapper {
    public static BankingServiceResponse map(BankingService bankingService) {
        return new BankingServiceResponse(
                bankingService.getServiceId(),
                bankingService.isActive(),
                bankingService.getActivatedOn(),
                bankingService.getServiceType()
        );
    }

    public static List<BankingServiceResponse> map(List<BankingService> bankingServices) {
        return bankingServices.stream()
                .map(BankingServiceMapper::map)
                .collect(Collectors.toList());
    }
}
