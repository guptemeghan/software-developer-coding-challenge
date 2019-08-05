package com.example.auction.Service;

import com.example.auction.Dao.BidRepository;
import com.example.auction.Model.Bid;
import org.springframework.stereotype.Service;

/**
 * Created by meghan on 8/4/2019.
 */
@Service
public class BidService implements IBidService {

    private BidRepository bidRepository;

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public Bid createBid(Bid bid) {
        return bidRepository.save(bid);
    }
}
