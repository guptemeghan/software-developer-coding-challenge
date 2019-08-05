package com.example.auction.Dao;

import com.example.auction.Model.Bid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by meghan on 8/4/2019.
 */
@Repository
public interface BidRepository extends CrudRepository<Bid, Integer> {

}
