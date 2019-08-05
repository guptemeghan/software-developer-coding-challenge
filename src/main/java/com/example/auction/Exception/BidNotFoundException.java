package com.example.auction.Exception;

/**
 * Created by meghan on 8/5/2019.
 */
public class BidNotFoundException extends RuntimeException {
    public BidNotFoundException(String s) {
        super(s);
    }
}
