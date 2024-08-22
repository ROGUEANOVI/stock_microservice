package com.rogueanovi.stock_microservice.brands.application.handler;

import com.rogueanovi.stock_microservice.brands.application.dto.BrandResponse;

import java.util.List;

public interface IListBrandsHandler {
    List<BrandResponse> listBrands(Integer page, Integer size, String sortDirection);
}
