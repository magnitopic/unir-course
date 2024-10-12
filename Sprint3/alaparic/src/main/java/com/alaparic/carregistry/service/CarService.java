package com.alaparic.carregistry.service;

import com.alaparic.carregistry.model.Car;
import com.alaparic.carregistry.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


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
}