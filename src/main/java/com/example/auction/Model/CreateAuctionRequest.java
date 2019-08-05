package com.example.auction.Model;

/**
 * Created by meghan on 8/5/2019.
 */
public class CreateAuctionRequest {
    private int carId;
    private int startingPrice;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }
}
