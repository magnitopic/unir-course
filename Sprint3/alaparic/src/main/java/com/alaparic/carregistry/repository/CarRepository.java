package com.alaparic.carregistry.repository;

import com.alaparic.carregistry.model.Car;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class CarRepository {
    private final Map<Integer, Car> cars = new HashMap<>();
    private int nextId = 1;

    public Car getCar() {
        Car car = new Car("VW", "Golf", 2009, 4, false);
        log.info("Car data: {}", car);

        return car;
    }

    public Car save(Car car) {
        if (car.getId() == null)
            car.setId(nextId++);
        cars.put(car.getId(), car);
        log.info("Saved car: {}", car);
        return car;
    }

    public Optional<Car> findById(Integer id) {
        return Optional.ofNullable(cars.get(id));
    }

    public void deleteById(Integer id) {
        cars.remove(id);
        log.info("Delete car with id: {}", id);
    }
}
