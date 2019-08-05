package com.example.auction.Service;

import com.example.auction.Repository.BidRepository;
import com.example.auction.Exception.IncorrectAmountException;
import com.example.auction.Model.Auction;
import com.example.auction.Model.Bid;
import com.example.auction.Model.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Users user = bid.getUser();
        Auction auction = bid.getAuction();
        if(Double.compare(bid.getAmount(), auction.getStartingPrice()) < 0) {
            throw new IncorrectAmountException("Amount less than minimum auction price");
        }

        if(auction.getWinningBid()!=null && Double.compare(bid.getAmount(), auction.getWinningBid().getAmount()) < 0) {
            throw new IncorrectAmountException("Amount less than current largest bid");
        }

        auction.setWinningBid(bid);
        bid.setAuction(auction);
        auction.setWinnerUser(user);
        List<Bid> listOfBids;
        if(auction.getBids()==null) {
            listOfBids = new ArrayList<>();
        } else {
            listOfBids = auction.getBids();
        }
        listOfBids.add(bid);
        auction.setBids(listOfBids);


        return bidRepository.save(bid);
    }
}
