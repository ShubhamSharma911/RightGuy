package com.rightguy.dtos;

import java.util.List;

public class ProviderProfileDto {
    private List<String> services;

    public ProviderProfileDto() {}

    public ProviderProfileDto(List<String> services){
        this.services = services;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}
