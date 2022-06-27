package com.example.bankaccounts.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BankingService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    @Column
    private boolean active;
    @Column
    private LocalDateTime activatedOn;
    @ManyToOne
    private BankAccount bankAccount;
    @Column
    private ServiceType serviceType;

    public BankingService() {
    }

    public BankingService(BankAccount bankAccount, ServiceType serviceType, boolean active, LocalDateTime activatedOn) {
        this.active = active;
        this.activatedOn = activatedOn;
        this.bankAccount = bankAccount;
        this.serviceType = serviceType;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getActivatedOn() {
        return activatedOn;
    }

    public void setActivatedOn(LocalDateTime localDateTime) {
        this.activatedOn = localDateTime;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
