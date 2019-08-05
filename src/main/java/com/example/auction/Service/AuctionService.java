package com.example.auction.Service;

import com.example.auction.Dao.AuctionRepository;
import com.example.auction.Exception.AuctionNotFoundException;
import com.example.auction.Model.Auction;
import com.example.auction.Model.Car;
import org.springframework.stereotype.Service;

/**
 * Created by meghan on 8/4/2019.
 */
@Service
public class AuctionService implements IAuctionService {

    private AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Auction createAuction(Car car, double startingPrice) {
        Auction auction = new Auction(car, startingPrice);
        return auctionRepository.save(auction);
    }

    @Override
    public Auction getAuctionById(int auctionId) {
        return auctionRepository.findById(auctionId).orElseThrow(() -> new AuctionNotFoundException("Not auction found for that auctionId"));
    }

    @Override
    public Auction getAuctionByCar(int carId) {
        return auctionRepository.findByCarId(carId).orElseThrow(()-> new AuctionNotFoundException("No auction found for that carId"));
    }
}
