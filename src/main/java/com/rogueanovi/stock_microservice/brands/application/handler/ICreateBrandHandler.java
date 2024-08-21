package com.rogueanovi.stock_microservice.brands.application.handler;

import com.rogueanovi.stock_microservice.brands.application.dto.BrandRequest;

public interface ICreateBrandHandler {
    void createBrand(BrandRequest brandRequest);
}
