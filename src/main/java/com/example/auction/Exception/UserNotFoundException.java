package com.example.auction.Exception;

/**
 * Created by meghan on 8/5/2019.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
