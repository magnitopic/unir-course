package com.alaparic.carregistry.controllers;

import com.alaparic.carregistry.model.Car;
import com.alaparic.carregistry.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cars")
@Slf4j
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        log.info("Adding new car");
        try {
            Car savedCar = carService.saveCar(car);
            return ResponseEntity.ok(savedCar);
        } catch (Exception e) {
            log.error("Error saving car", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        log.info("Getting car with id: {}", id);
        return carService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car car) {
        log.info("Updating car with id: {}", id);
        try {
            return carService.updateCar(id, car)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            log.error("Error updating car", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer id) {
        log.info("Deleting car with id: {}", id);
        if (carService.getCarById(id).isPresent()) {
            carService.deleteCar(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}