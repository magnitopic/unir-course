package com.alaparic.carregistry.controllers;

import com.alaparic.carregistry.model.Car;
import com.alaparic.carregistry.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public Car getCarData() {
        log.info("Accessing the application through /cars endpoint");
        return carService.getCarData();
    }
}
