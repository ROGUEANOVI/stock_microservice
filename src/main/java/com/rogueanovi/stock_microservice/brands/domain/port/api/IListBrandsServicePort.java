package com.rogueanovi.stock_microservice.brands.domain.port.api;

import com.rogueanovi.stock_microservice.brands.domain.model.Brand;

import java.util.List;

public interface IListBrandsServicePort {
    List<Brand> listBrands(Integer page, Integer size, String sortDirection);
}
