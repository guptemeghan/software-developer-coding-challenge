package com.example.auction.Service;

import com.example.auction.Model.Car;

/**
 * Created by meghan on 8/4/2019.
 */
public interface ICarService {
    Car createCar(Car car);
    Car getCarById(int id);
}
