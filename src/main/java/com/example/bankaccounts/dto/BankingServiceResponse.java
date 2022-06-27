package com.example.bankaccounts.dto;

import com.example.bankaccounts.entities.ServiceType;

import java.time.LocalDateTime;

public class BankingServiceResponse {
    private final Long serviceId;
    private final boolean active;
    private final LocalDateTime activatedOn;
    private final ServiceType serviceType;

    public BankingServiceResponse(Long serviceId, boolean active, LocalDateTime activatedOn, ServiceType serviceType) {
        this.serviceId = serviceId;
        this.active = active;
        this.activatedOn = activatedOn;
        this.serviceType = serviceType;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getActivatedOn() {
        return activatedOn;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }
}
