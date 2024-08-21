package com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.repository;

import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
