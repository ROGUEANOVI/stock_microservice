package com.rogueanovi.stock_microservice.brands.application.handler;

import com.rogueanovi.stock_microservice.brands.application.dto.BrandRequest;
import com.rogueanovi.stock_microservice.brands.application.mapper.BrandRequestMapper;
import com.rogueanovi.stock_microservice.brands.domain.port.api.ICreateBrandServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor

public class CreateBrandHandler implements ICreateBrandHandler {
    private final ICreateBrandServicePort createBrandServicePort;
    private final BrandRequestMapper brandRequestMapper;

    @Override
    public void createBrand(BrandRequest brandRequest) {
        createBrandServicePort.createBrand(brandRequestMapper.toBrand(brandRequest));
    }
}
