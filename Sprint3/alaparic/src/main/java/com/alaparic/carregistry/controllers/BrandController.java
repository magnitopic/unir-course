package com.alaparic.carregistry.controllers;

import com.alaparic.carregistry.model.Brand;
import com.alaparic.carregistry.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/brands")
@Slf4j
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public CompletableFuture<ResponseEntity<List<Brand>>> getAllBrands() {
        return brandService.getAllBrandsAsync()
                .thenApply(ResponseEntity::ok)
                .exceptionally(e -> {
                    log.error("Error fetching all brands", e);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                });
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Integer id) {
        return brandService.getBrandById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<Brand>> createBrand(@RequestBody Brand brand) {
        return brandService.saveBrandAsync(brand)
                .thenApply(ResponseEntity::ok)
                .exceptionally(e -> {
                    log.error("Error creating brand", e);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                });
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<Brand>> updateBrand(@PathVariable Integer id, @RequestBody Brand brand) {
        return brandService.updateBrandAsync(id, brand)
                .thenApply(optionalBrand -> optionalBrand
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build()))
                .exceptionally(e -> {
                    log.error("Error updating brand", e);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                });
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteBrand(@PathVariable Integer id) {
        return brandService.deleteBrandAsync(id)
                .thenApply(deleted -> deleted
                        ? ResponseEntity.ok().<Void>build()
                        : ResponseEntity.notFound().<Void>build())
                .exceptionally(e -> {
                    log.error("Error deleting brand", e);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                });
    }
}