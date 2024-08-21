package com.rogueanovi.stock_microservice.brands.infrastructure.configuration;

import com.rogueanovi.stock_microservice.brands.domain.port.api.ICreateBrandServicePort;
import com.rogueanovi.stock_microservice.brands.domain.port.spi.ICreateBrandPersistencePort;
import com.rogueanovi.stock_microservice.brands.domain.usecase.CreateBrandUseCase;
import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.adapter.CreateBrandJpaAdapter;
import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BrandBeanConfiguration {
    private final BrandEntityMapper brandEntityMapper;
    private final IBrandRepository brandRepository;

    @Bean
    public ICreateBrandPersistencePort createBrandPersistencePort() {
        return new CreateBrandJpaAdapter(brandRepository, brandEntityMapper);
    }

    @Bean
    public ICreateBrandServicePort createBrandServicePort() {
        return new CreateBrandUseCase(createBrandPersistencePort());
    }
}
