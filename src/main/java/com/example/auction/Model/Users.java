package com.example.auction.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by meghan on 8/4/2019.
 */
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    private String emailAddr;

    @OneToMany //one user can make many bids
    private List<Bid> listOfBids;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public Users(){}

    public Users(String firstName, String lastName, String emailAddr) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmailAddr(emailAddr);
    }
}
