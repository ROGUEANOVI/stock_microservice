package com.rogueanovi.stock_microservice.brands.domain.usecase;

import com.rogueanovi.stock_microservice.brands.domain.exception.BrandAlreadyExistsException;
import com.rogueanovi.stock_microservice.brands.domain.exception.constant.ExceptionMessage;
import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import com.rogueanovi.stock_microservice.brands.domain.port.api.ICreateBrandServicePort;
import com.rogueanovi.stock_microservice.brands.domain.port.spi.ICreateBrandPersistencePort;

public class CreateBrandUseCase implements ICreateBrandServicePort {
    private final ICreateBrandPersistencePort brandPersistencePort;

    public CreateBrandUseCase(ICreateBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void createBrand(Brand brand) {
        if (brandPersistencePort.existsBrandByName(brand.getName())) {
            throw new BrandAlreadyExistsException(ExceptionMessage.BRAND_ALREADY_EXISTS);
        }
        brandPersistencePort.createBrand(brand);
    }
}
