package com.example.auction.Model;

import javax.persistence.*;

/**
 * Created by meghan on 8/4/2019.
 */
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String make;
    private String model;
    private String color;
    private double price;

    @OneToOne(targetEntity = Auction.class, cascade = CascadeType.ALL, mappedBy = "car")
    protected Auction auction;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
