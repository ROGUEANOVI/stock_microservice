package com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.repository;

import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
    boolean existsByName(String name);
}
