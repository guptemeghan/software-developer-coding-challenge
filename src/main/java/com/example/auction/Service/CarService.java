package com.example.auction.Service;

import com.example.auction.Repository.CarRepository;
import com.example.auction.Exception.CarNotFoundException;
import com.example.auction.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by meghan on 8/4/2019.
 */
@Service
public class CarService implements ICarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(int id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car not found for that carId"));
    }
}
