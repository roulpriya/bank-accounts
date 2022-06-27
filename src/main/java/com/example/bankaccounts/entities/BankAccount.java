package com.example.bankaccounts.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class BankAccount {

    @OneToMany(mappedBy = "bankAccount")
    List<BankingService> bankingServices;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column
    private String accountNumber;
    @Column
    private String bankName;
    @Column
    private float balance;
    @ManyToOne
    private User user;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String bankName, float balance, User user) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
        this.user = user;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<BankingService> getBankingServices() {
        return bankingServices;
    }

    public void setBankingServices(List<BankingService> bankingServices) {
        this.bankingServices = bankingServices;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
