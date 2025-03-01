package com.rightguy.services;

import com.rightguy.model.Bid;
import com.rightguy.repositories.BidRepository;

import java.util.List;
import java.util.Optional;

public class BidServiceImpl implements BidService {
    BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public Bid createBid(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public Optional<Bid> getBidById(Long id) {
        return bidRepository.findById(id);
    }

    @Override
    public List<Bid> getBidsForJob(Long jobId) {
        return bidRepository.findAllByJobId(jobId);
    }
}
