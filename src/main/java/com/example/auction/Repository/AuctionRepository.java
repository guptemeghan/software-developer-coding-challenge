package com.example.auction.Repository;

import com.example.auction.Model.Auction;
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
