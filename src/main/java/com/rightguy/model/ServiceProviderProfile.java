package com.rightguy.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ServiceProviderProfile {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToMany
    @JoinTable(
          name = "provider_service",
          joinColumns = @JoinColumn(name = "provider_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> services;


}
