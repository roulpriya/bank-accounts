package com.example.bankaccounts.repositories;

import com.example.bankaccounts.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
