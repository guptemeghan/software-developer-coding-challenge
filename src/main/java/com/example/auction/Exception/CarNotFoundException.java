package com.example.auction.Exception;

/**
 * Created by meghan on 8/5/2019.
 */
public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String s) {
        super(s);
    }
}
