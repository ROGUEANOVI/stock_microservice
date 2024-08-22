package com.rogueanovi.stock_microservice.brands.domain.port.spi;

import com.rogueanovi.stock_microservice.brands.domain.model.Brand;

public interface ICreateBrandPersistencePort {
    void createBrand(Brand brand);
    boolean existsBrandByName(String name);
}
