package com.rogueanovi.stock_microservice.brands.domain.port.spi;

import com.rogueanovi.stock_microservice.brands.domain.model.Brand;

import java.util.List;

public interface IListBrandsPersistencePort {
    List<Brand> listBrands(Integer page, Integer size, String sortDirection);
}
