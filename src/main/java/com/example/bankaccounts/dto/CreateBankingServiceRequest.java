package com.example.bankaccounts.dto;

import com.example.bankaccounts.entities.ServiceType;

import java.time.LocalDateTime;

public class CreateBankingServiceRequest {

    private final ServiceType serviceType;
    private final boolean active;
    private final LocalDateTime activatedOn;

    public CreateBankingServiceRequest(ServiceType serviceType, boolean active, LocalDateTime activatedOn) {
        this.serviceType = serviceType;
        this.active = active;
        this.activatedOn = activatedOn;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getActivatedOn() {
        return activatedOn;
    }


}
