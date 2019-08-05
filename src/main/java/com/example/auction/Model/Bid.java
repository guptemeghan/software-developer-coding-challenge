package com.example.auction.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by meghan on 8/4/2019.
 */
@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bidId;

    @ManyToOne //many bids can be made by one user
    @JoinColumn(name = "user_id")
    private Users user;

    private double amount;

    @ManyToOne(targetEntity = Auction.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_id")
    @JsonIgnore
    private Auction auction;

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Bid() {}

    public Bid(double amount, Users user) {
        this.setAmount(amount);
        this.setUser(user);
    }

    public Bid(double amount, Users user, Auction auction) {
        this.setAmount(amount);
        this.setUser(user);
        this.setAuction(auction);
    }
}
