package com.rightguy.repositories;

import com.rightguy.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BidRepository extends JpaRepository<Bid, Integer> {
    Optional<Bid> findById(Long id);

    List<Bid> findAllByJobId(Long jobId);

}
