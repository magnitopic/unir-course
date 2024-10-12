package com.alaparic.carregistry.repository;

import com.alaparic.carregistry.model.Car;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CarRepository {
    public Car getCar(){
        Car car = new Car("VW", "Golf", 2009, 4, false);
        log.info("Car data: {}", car);

        return car;
    }
}
