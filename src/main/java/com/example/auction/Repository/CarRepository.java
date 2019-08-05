package com.example.auction.Repository;

import com.example.auction.Model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by meghan on 8/4/2019.
 */
@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

}