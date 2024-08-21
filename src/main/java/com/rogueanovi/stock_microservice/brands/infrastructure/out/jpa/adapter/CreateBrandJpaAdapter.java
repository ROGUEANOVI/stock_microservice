package com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.adapter;

import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import com.rogueanovi.stock_microservice.brands.domain.port.spi.ICreateBrandPersistencePort;
import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateBrandJpaAdapter implements ICreateBrandPersistencePort {
    private final IBrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Override
    public void createBrand(Brand brand) {
        brandRepository.save(brandEntityMapper.toEntity(brand));
    }

    @Override
    public boolean existsBrandByName(String name) {
        return brandRepository.existsByName(name);
    }
}
