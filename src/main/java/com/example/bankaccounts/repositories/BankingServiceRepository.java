package com.example.bankaccounts.repositories;

import com.example.bankaccounts.entities.BankingService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingServiceRepository extends JpaRepository<BankingService, Long> {
}
