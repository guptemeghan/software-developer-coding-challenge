package com.example.auction.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by meghan on 8/4/2019.
 */
@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auctionId;

    private double startingPrice;

    @OneToOne(targetEntity = Car.class)
    @JoinColumn(name = "id")
    private Car car;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auction", cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<Bid> bids;

    @OneToOne(targetEntity = Users.class)
    private Users winnerUser;

    @OneToOne(targetEntity = Bid.class)
    private Bid winningBid;

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Users getWinnerUser() {
        return winnerUser;
    }

    public void setWinnerUser(Users winnerUser) {
        this.winnerUser = winnerUser;
    }

    public Bid getWinningBid() {
        return winningBid;
    }

    public void setWinningBid(Bid winningBid) {
        this.winningBid = winningBid;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Auction() {
    }

    public Auction(Car car) {
        this.car = car;
    }

    public Auction(Car car, double startingPrice) {
        this.setCar(car);
        this.setStartingPrice(startingPrice);
    }
}
