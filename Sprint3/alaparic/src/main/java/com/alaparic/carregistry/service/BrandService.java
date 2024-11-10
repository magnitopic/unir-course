package com.alaparic.carregistry.service;

import com.alaparic.carregistry.model.Brand;
import com.alaparic.carregistry.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    /**
     * Usa hilos porque puede devolver muchas marcas.
     * Permite que otras operaciones continúen mientras se buscan los datos.
     */
    @Async("taskExecutor")
    public CompletableFuture<List<Brand>> getAllBrandsAsync() {
        return CompletableFuture.completedFuture(brandRepository.findAll());
    }

    /**
     * No usa hilos porque es una búsqueda simple y rápida por ID.
     */
    public Optional<Brand> getBrandById(Integer id) {
        return brandRepository.findById(id);
    }

    /**
     * Usa hilos para guardar marcas sin bloquear el hilo principal.
     * El cliente puede seguir trabajando mientras se guarda.
     */
    @Async("taskExecutor")
    public CompletableFuture<Brand> saveBrandAsync(Brand brand) {
        return CompletableFuture.completedFuture(brandRepository.save(brand));
    }

    /**
     * Usa hilos porque necesita comprobar si existe y luego actualizar.
     * Un hilo trabajador hace todo el proceso de actualización.
     */
    @Async("taskExecutor")
    public CompletableFuture<Optional<Brand>> updateBrandAsync(Integer id, Brand brand) {
        if (brandRepository.existsById(id)) {
            brand.setId(id);
            return CompletableFuture.completedFuture(Optional.of(brandRepository.save(brand)));
        }
        return CompletableFuture.completedFuture(Optional.empty());
    }

    /**
     * Usa hilos porque el borrado puede ser complejo si hay datos relacionados.
     * El cliente no necesita esperar a que termine el proceso.
     */
    @Async("taskExecutor")
    public CompletableFuture<Boolean> deleteBrandAsync(Integer id) {
        if (brandRepository.existsById(id)) {
            brandRepository.deleteById(id);
            return CompletableFuture.completedFuture(true);
        }
        return CompletableFuture.completedFuture(false);
    }
}