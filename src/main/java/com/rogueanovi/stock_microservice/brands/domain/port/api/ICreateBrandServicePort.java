package com.rogueanovi.stock_microservice.brands.domain.port.api;

import com.rogueanovi.stock_microservice.brands.domain.model.Brand;

public interface ICreateBrandServicePort {
    void createBrand(Brand brand);
}
