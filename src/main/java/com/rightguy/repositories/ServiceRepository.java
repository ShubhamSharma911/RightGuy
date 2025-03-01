package com.rightguy.repositories;

import com.rightguy.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByName(String name);
}
