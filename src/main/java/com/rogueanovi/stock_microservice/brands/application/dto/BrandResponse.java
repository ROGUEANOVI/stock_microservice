package com.rogueanovi.stock_microservice.brands.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandResponse {
    Long id;
    private String name;
    private String description;
}
