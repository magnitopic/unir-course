package com.alaparic.carregistry.service;

import com.alaparic.carregistry.model.Car;
import com.alaparic.carregistry.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class CarService {
    @Value("${car.message}")
    private String carMessage;

    @Autowired
    private CarRepository carRepository;

    /**
     * Usa hilos porque guardar un coche puede ser una operación pesada.
     * El hilo principal queda libre mientras un hilo trabajador hace la operación.
     */
    @Async("taskExecutor")
    public CompletableFuture<Car> saveCarAsync(Car car) {
        log.info("Saving car asynchronously: {}", car);
        return CompletableFuture.completedFuture(carRepository.save(car));
    }

    /**
     * No usa hilos porque es una búsqueda rápida por ID.
     * Es más eficiente hacerlo de forma síncrona.
     */
    public Optional<Car> getCarById(Integer id) {
        log.info("Getting car with id: {}", id);
        return carRepository.findById(id);
    }

    /**
     * Usa hilos porque actualizar implica buscar y guardar.
     * Un hilo trabajador se encarga de todo el proceso mientras el principal sigue libre.
     */
    @Async("taskExecutor")
    public CompletableFuture<Optional<Car>> updateCarAsync(Integer id, Car car) {
        log.info("Updating car asynchronously with id: {}", id);
        return CompletableFuture.completedFuture(
                carRepository.findById(id)
                        .map(existingCar -> {
                            car.setId(id);
                            return carRepository.save(car);
                        })
        );
    }

    /**
     * Usa hilos porque borrar puede implicar borrar datos relacionados.
     * El cliente no tiene que esperar a que termine el borrado.
     */
    @Async("taskExecutor")
    public CompletableFuture<Void> deleteCarAsync(Integer id) {
        log.info("Deleting car asynchronously with id: {}", id);
        carRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}