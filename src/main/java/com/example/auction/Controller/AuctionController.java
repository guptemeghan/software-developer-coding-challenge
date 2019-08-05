package com.example.auction.Controller;

import com.example.auction.Model.Auction;
import com.example.auction.Model.Car;
import com.example.auction.Model.Users;
import com.example.auction.Service.IAuctionService;
import com.example.auction.Service.ICarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by meghan on 8/4/2019.
 */
@RestController
@RequestMapping("/auction")
public class AuctionController {

    private IAuctionService auctionService;

    private ICarService carService;

    public AuctionController(IAuctionService auctionService, ICarService carService) {
        this.auctionService = auctionService;
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Auction> createAuction(@RequestParam int carId, @RequestParam double startingPrice) throws Exception {
        Car car = carService.getCarById(carId);
        if(car==null) {

        }
        return new ResponseEntity<>(auctionService.createAuction(car, startingPrice), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public Auction getAuction(@PathVariable int id) {
        return auctionService.getAuctionById(id);
    }
}
