package com.example.auction.Service;

import com.example.auction.Model.Auction;
import com.example.auction.Model.Car;

/**
 * Created by meghan on 8/4/2019.
 */
public interface IAuctionService {
    Auction createAuction(Car car, double startingPrice);
    Auction getAuctionById(int auctionId);
    Auction getAuctionByCar(int carId);
}
