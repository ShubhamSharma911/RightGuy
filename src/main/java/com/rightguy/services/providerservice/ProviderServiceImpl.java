package com.rightguy.services.providerservice;

import com.rightguy.dtos.ProviderProfileDto;
import com.rightguy.model.Services;
import com.rightguy.model.ServiceProviderProfile;
import com.rightguy.repositories.ServiceProviderProfileRepository;
import com.rightguy.repositories.ServiceRepository;
import com.rightguy.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class ProviderServiceImpl implements ProviderService{

    ServiceProviderProfileRepository profileRepository;
    UserService userService;
    ServiceRepository serviceRepository;

    @Autowired
    public ProviderServiceImpl(ServiceProviderProfileRepository profileRepository, UserService userService, ServiceRepository serviceRepository) {
        this.profileRepository = profileRepository;
        this.userService = userService;
        this.serviceRepository = serviceRepository;
    }


    @Override
    public ServiceProviderProfile updateProfile(Long profileId, ProviderProfileDto profileDto) {

        ServiceProviderProfile profile = profileRepository.findById(profileId)
                .orElseThrow(()-> new RuntimeException("Provider profile not found"));

        Set<Services> services = new HashSet<>();

        for(String serviceName : profileDto.getServices()) {
            Services service = serviceRepository.findByName(serviceName)
                    .orElseGet(()-> {
                        Services newServices = new Services();
                        newServices.setName(serviceName);
                        return serviceRepository.save(newServices);
                    });
            services.add(service);
        }

        profile.setServices(services);
        return profileRepository.save(profile);
    }
}
