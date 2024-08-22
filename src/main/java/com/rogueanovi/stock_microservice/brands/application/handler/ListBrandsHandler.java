package com.rogueanovi.stock_microservice.brands.application.handler;

import com.rogueanovi.stock_microservice.brands.application.dto.BrandResponse;
import com.rogueanovi.stock_microservice.brands.application.mapper.BrandResponseMapper;
import com.rogueanovi.stock_microservice.brands.domain.port.api.IListBrandsServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ListBrandsHandler implements IListBrandsHandler {
    private final IListBrandsServicePort listBrandsServicePort;
    private final BrandResponseMapper brandResponseMapper;
    @Override
    public List<BrandResponse> listBrands(Integer page, Integer size, String sortDirection) {
        return brandResponseMapper.toBrandResponseList(listBrandsServicePort.listBrands(page, size, sortDirection));
    }
}
