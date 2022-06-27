package com.example.bankaccounts.services;

import com.example.bankaccounts.dto.BankAccountResponse;
import com.example.bankaccounts.dto.CreateBankAccountRequest;
import com.example.bankaccounts.entities.BankAccount;
import com.example.bankaccounts.entities.BankingService;
import com.example.bankaccounts.entities.ServiceType;
import com.example.bankaccounts.entities.User;
import com.example.bankaccounts.mappers.BankAccountMapper;
import com.example.bankaccounts.repositories.BankAccountRepository;
import com.example.bankaccounts.repositories.BankingServiceRepository;
import com.example.bankaccounts.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankingServiceRepository bankingServiceRepository;
    private final UserRepository userRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository, BankingServiceRepository bankingServiceRepository, UserRepository userRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankingServiceRepository = bankingServiceRepository;
        this.userRepository = userRepository;
    }

    public BankAccountResponse get(long accountId) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElseThrow(BankAccountNotFoundException::new);
        return BankAccountMapper.map(bankAccount);

    }


    public BankAccountResponse create(CreateBankAccountRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(UserNotFoundException::new);
        BankAccount bankAccount = new BankAccount(request.getAccountNumber(), request.getBankName(), request.getBalance(), user);
        bankAccountRepository.save(bankAccount);

        List<BankingService> bankingServices = request.getBankingServices().stream()
                .map(bankingServiceRequest -> new BankingService(
                        bankAccount,
                        bankingServiceRequest.getServiceType(),
                        bankingServiceRequest.isActive(),
                        bankingServiceRequest.getActivatedOn()))
                .collect(Collectors.toList());

        bankingServiceRepository.saveAll(bankingServices);

        bankAccount.setBankingServices(bankingServices);
        bankAccountRepository.save(bankAccount);

        return BankAccountMapper.map(bankAccount);
    }

    public List<BankAccountResponse> getAllBankAccountsByService(ServiceType serviceType) {
        List<BankAccount> bankAccounts = bankAccountRepository.findAllByActiveServiceType(serviceType);
        return BankAccountMapper.map(bankAccounts);
    }
}
