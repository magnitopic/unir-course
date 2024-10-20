package com.alaparic.carregistry.service;

import com.alaparic.carregistry.model.Car;
import com.alaparic.carregistry.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;


@Service
@Slf4j
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Value("${car.message}")
    private String carMessage;

    public Car getCarData() {
        log.info("Car message from properties: {}", carMessage);
        return carRepository.getCar();
    }

    public Car saveCar(Car car) {
        log.info("Saving car: {}", car);
        return carRepository.save(car);
    }

    public Optional<Car> getCarById(Integer id) {
        log.info("Getting car with id: {}", id);
        return carRepository.findById(id);
    }

    public Optional<Car> updateCar(Integer id, Car car) {
        log.info("Updating car with id: {}", id);
        return carRepository.findById(id)
                .map(existingCar -> {
                    car.setId(id);
                    return carRepository.save(car);
                });
    }

    public void deleteCar(Integer id) {
        log.info("Deleting car with id: {}", id);
        carRepository.deleteById(id);
    }
}