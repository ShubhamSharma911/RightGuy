package com.rightguy.repositories;

import com.rightguy.model.ServiceProviderProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderProfileRepository extends JpaRepository<ServiceProviderProfile, Long> {
    ServiceProviderProfile findByServiceProvider(Long profileId);
}
