package com.alaparic.carregistry.repository;


import com.alaparic.carregistry.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
