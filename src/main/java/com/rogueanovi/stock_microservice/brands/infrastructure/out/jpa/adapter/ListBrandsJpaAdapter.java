package com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.adapter;

import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import com.rogueanovi.stock_microservice.brands.domain.port.spi.IListBrandsPersistencePort;
import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.entity.BrandEntity;
import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class ListBrandsJpaAdapter implements IListBrandsPersistencePort {
    private final IBrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Override
    public List<Brand> listBrands(Integer page, Integer size, String sortDirection) {
        Pageable pageable = PageRequest.of(page, size);
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), "name");

        if (!sort.isEmpty()) pageable = PageRequest.of(page, size).withSort(sort);

        List<BrandEntity> brandEntities = brandRepository.findAll(pageable).getContent();

        return brandEntityMapper.toBrandList(brandEntities);
    }
}
