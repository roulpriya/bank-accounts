package com.example.bankaccounts.repositories;

import com.example.bankaccounts.entities.BankAccount;
import com.example.bankaccounts.entities.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @Query("select b from BankAccount b join b.bankingServices bs where bs.serviceType = ?1 and bs.active = true")
    List<BankAccount> findAllByActiveServiceType(ServiceType serviceType);
}

