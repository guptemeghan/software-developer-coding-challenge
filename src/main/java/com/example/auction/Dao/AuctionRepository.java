package com.example.auction.Dao;

import com.example.auction.Model.Auction;
import com.example.auction.Model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by meghan on 8/4/2019.
 */
@Repository
public interface AuctionRepository extends CrudRepository<Auction, Integer> {
    Optional<Auction> findByCarId(int itemId);
}
