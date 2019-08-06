package com.example.auction.Controller;

import com.example.auction.Exception.AuctionNotFoundException;
import com.example.auction.Model.*;
import com.example.auction.Service.IAuctionService;
import com.example.auction.Service.IBidService;
import com.example.auction.Service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by meghan on 8/5/2019.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BidController.class)
public class BidControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IBidService bidService;

    @MockBean
    private IUserService userService;

    @MockBean
    private IAuctionService auctionService;

    @Test
    public void placeBidSuccess() throws Exception {

        CreateBidRequest req = new CreateBidRequest(1,1,10.0);

        Users user = new Users("Meghan", "Gupte", "meghan.gupte@gmail.com");
        Bid bid = new Bid(100, user);

        ObjectMapper objectMapper = new ObjectMapper();
        String bidRequest = objectMapper.writeValueAsString(req);

        when(bidService.createBid(any(Bid.class))).thenReturn(bid);
        mockMvc.perform(post("/bids").content(bidRequest).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void createBidThrowsAuctionNotFoundException() throws Exception {

        CreateBidRequest req = new CreateBidRequest(1,1,10.0);

        Users user = new Users("Meghan", "Gupte", "meghan.gupte@gmail.com");
        Bid bid = new Bid(100, user);

        ObjectMapper objectMapper = new ObjectMapper();
        String bidRequest = objectMapper.writeValueAsString(req);

        when(bidService.createBid(any(Bid.class))).thenThrow(AuctionNotFoundException.class);
        mockMvc.perform(post("/bids").content(bidRequest).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @Test
    public void getAllBidsBasedOnCarId() throws Exception {

        CreateBidRequest req = new CreateBidRequest(1,1,10.0);

        Users user1 = new Users("Meghan1", "Gupte1", "meghan.gupte1@gmail.com");
        Bid bid1 = new Bid(100, user1);

        Users user2 = new Users("Meghan2", "Gupte2", "meghan.gupte2@gmail.com");
        Bid bid2 = new Bid(200, user2);

        List<Bid> lisOfBids = new ArrayList<>();
        lisOfBids.add(bid1);
        lisOfBids.add(bid2);

        Car car = new Car();

        Auction auction = new Auction(car, 5, lisOfBids);

        ObjectMapper objectMapper = new ObjectMapper();
        String bidRequest = objectMapper.writeValueAsString(req);

        when(auctionService.getAuctionByCar(any(Integer.class))).thenReturn(auction);
        mockMvc.perform(get("/bids/all/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].user.firstName").value(bid1.getUser().getFirstName()))
                .andExpect(jsonPath("$.[1].user.firstName").value(bid2.getUser().getFirstName()));
    }

    @Test
    public void getWinningBidBasedOnCarId() throws Exception {

        CreateBidRequest req = new CreateBidRequest(1,1,10.0);

        Users user1 = new Users("Meghan1", "Gupte1", "meghan.gupte1@gmail.com");
        Bid bid1 = new Bid(100, user1);

        Users user2 = new Users("Meghan2", "Gupte2", "meghan.gupte2@gmail.com");
        Bid bid2 = new Bid(200, user2);

        List<Bid> lisOfBids = new ArrayList<>();
        lisOfBids.add(bid1);
        lisOfBids.add(bid2);

        Car car = new Car();

        Auction auction = new Auction(car, 5, lisOfBids, bid2);

        ObjectMapper objectMapper = new ObjectMapper();
        String bidRequest = objectMapper.writeValueAsString(req);

        when(auctionService.getAuctionByCar(any(Integer.class))).thenReturn(auction);
        mockMvc.perform(get("/bids/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.user.firstName").value(bid2.getUser().getFirstName()))
                .andExpect(jsonPath("$.amount").value(bid2.getAmount()));
    }

}
