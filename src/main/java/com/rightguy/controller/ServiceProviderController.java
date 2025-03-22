package com.rightguy.controller;

import com.rightguy.dtos.ProviderProfileDto;
import com.rightguy.model.ServiceProviderProfile;
import com.rightguy.model.Services;
import com.rightguy.services.providerservice.ProviderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ServiceProviderController {
    private final ProviderService providerService;

    public ServiceProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }
    @PutMapping("/{profileId}")
    public ResponseEntity<ServiceProviderProfile> updateProfile(
            @PathVariable Long profileId,
            @RequestBody @Valid ProviderProfileDto profileDto) {

        ServiceProviderProfile updatedProfile = providerService.updateProfile(profileId, profileDto);
        return ResponseEntity.ok(updatedProfile);
    }
}
