package com.alaparic.carregistry.repository;

import com.alaparic.carregistry.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Car getCar();
}
