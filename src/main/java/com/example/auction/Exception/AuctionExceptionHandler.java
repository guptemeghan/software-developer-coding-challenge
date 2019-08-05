package com.example.auction.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Created by meghan on 8/5/2019.
 */
@ControllerAdvice
public class AuctionExceptionHandler {

        @ResponseBody
        @ExceptionHandler(IllegalArgumentException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String illegalArgumentHandler(IllegalArgumentException ex) {
            return ex.getMessage();
        }

        @ResponseBody
        @ExceptionHandler(IncorrectAmountException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        String incorrectAmountExceptionHandler(IncorrectAmountException ex) {
            return ex.getMessage();
        }

        @ResponseBody
        @ExceptionHandler(UserNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String userNotFoundExceptionHandler(UserNotFoundException ex) {
            return ex.getMessage();
        }

        @ResponseBody
        @ExceptionHandler(CarNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String carNotFoundExceptionHandler(CarNotFoundException ex) {
            return ex.getMessage();
        }

        @ResponseBody
        @ExceptionHandler(AuctionNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String auctionNotFoundExceptionHandler(AuctionNotFoundException ex) {
            return ex.getMessage();
        }

        @ResponseBody
        @ExceptionHandler(BidNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String bidNotFoundExceptionHandler(BidNotFoundException ex) {
            return ex.getMessage();
        }

}
