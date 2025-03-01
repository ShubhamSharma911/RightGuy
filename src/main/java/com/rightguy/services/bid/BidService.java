package com.rightguy.services;

import com.rightguy.model.Bid;

import java.util.List;
import java.util.Optional;

public interface BidService {
    Bid createBid(Bid bid);
    Optional<Bid> getBidById(Long id);
    List<Bid> getBidsForJob(Long jobId);
}
