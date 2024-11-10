package com.alaparic.carregistry.controllers;

import com.alaparic.carregistry.model.Car;
import com.alaparic.carregistry.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cars")
@Slf4j
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping
    public CompletableFuture<ResponseEntity<Car>> addCar(@RequestBody Car car) {
        log.info("Adding new car asynchronously");
        return carService.saveCarAsync(car)
                .thenApply(ResponseEntity::ok)
                .exceptionally(e -> {
                    log.error("Error saving car", e);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                });
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        log.info("Getting car with id: {}", id);
        return carService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<Car>> updateCar(@PathVariable Integer id, @RequestBody Car car) {
        log.info("Updating car with id: {} asynchronously", id);
        return carService.updateCarAsync(id, car)
                .thenApply(optionalCar -> optionalCar
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build()))
                .exceptionally(e -> {
                    log.error("Error updating car", e);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                });
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteCar(@PathVariable Integer id) {
        log.info("Deleting car with id: {} asynchronously", id);
        return carService.getCarById(id)
                .map(car -> carService.deleteCarAsync(id)
                        .thenApply(v -> ResponseEntity.ok().<Void>build()))
                .orElse(CompletableFuture.completedFuture(ResponseEntity.notFound().build()));
    }
}
