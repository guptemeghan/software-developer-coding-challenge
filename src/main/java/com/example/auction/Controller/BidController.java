package com.example.auction.Controller;

import com.example.auction.Exception.IncorrectAmountException;
import com.example.auction.Model.Auction;
import com.example.auction.Model.Bid;
import com.example.auction.Model.Users;
import com.example.auction.Service.IAuctionService;
import com.example.auction.Service.IBidService;
import com.example.auction.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by meghan on 8/4/2019.
 */
@RestController
@RequestMapping("/bids")
public class BidController {
    private IBidService bidService;
    private IUserService userService;
    private IAuctionService auctionService;

    @Autowired
    public BidController(IBidService bidService, IUserService userService, IAuctionService auctionService) {

        this.bidService = bidService;
        this.userService = userService;
        this.auctionService = auctionService;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> addBid(@RequestParam double bidAmount, @RequestParam int userId, @RequestParam int auctionId) throws Exception {
        Users user = userService.getUserById(userId);
        Auction auction = auctionService.getAuctionById(auctionId);
        Bid bid = new Bid(bidAmount, user, auction);

        return new ResponseEntity<>(bidService.createBid(bid), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{carId}")
    public Bid getWinningBids(@PathVariable int carId) {
        Auction auction = auctionService.getAuctionByCar(carId);
        return auction.getWinningBid();
    }

    @GetMapping(value = "/all/{carId}")
    public List<Bid> getAllBidsForCar(@PathVariable int carId) {
        Auction auction = auctionService.getAuctionByCar(carId);
        return auction.getBids();
    }
}
