package com.example.auction.Controller;

import com.example.auction.Model.Car;
import com.example.auction.Service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by meghan on 8/4/2019.
 */
@RestController
@RequestMapping("/cars")
public class CarController {
    private ICarService carService;

    @Autowired
    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car findCarByID(@PathVariable int id) {
        return carService.getCarById(id);
    }
}
