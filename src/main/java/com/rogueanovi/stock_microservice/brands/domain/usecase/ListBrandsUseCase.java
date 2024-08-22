package com.rogueanovi.stock_microservice.brands.domain.usecase;

import com.rogueanovi.stock_microservice.brands.domain.exception.NoDataFoundBrandException;
import com.rogueanovi.stock_microservice.brands.domain.exception.constant.BrandExceptionMessages;
import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import com.rogueanovi.stock_microservice.brands.domain.port.api.IListBrandsServicePort;
import com.rogueanovi.stock_microservice.brands.domain.port.spi.IListBrandsPersistencePort;

import java.util.List;

public class ListBrandsUseCase implements IListBrandsServicePort {
    private final IListBrandsPersistencePort brandsPersistencePort;

    public ListBrandsUseCase(IListBrandsPersistencePort brandsPersistencePort) {
        this.brandsPersistencePort = brandsPersistencePort;
    }

    @Override
    public List<Brand> listBrands(Integer page, Integer size, String sortDirection) {
        List<Brand> brands = brandsPersistencePort.listBrands(page, size, sortDirection);
        if (brands.isEmpty()) {
            throw new NoDataFoundBrandException(BrandExceptionMessages.NO_DATA_FOUND_BRAND);
        }
        return brands;
    }
}
