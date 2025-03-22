package com.rightguy.services.providerservice;

import com.rightguy.dtos.ProviderProfileDto;
import com.rightguy.model.ServiceProviderProfile;
import org.springframework.stereotype.Service;



public interface ProviderService {
    ServiceProviderProfile updateProfile(Long userId, ProviderProfileDto profileDto);
}
