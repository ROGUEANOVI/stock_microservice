package com.rogueanovi.stock_microservice.brands.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandRequest {
    private String name;
    private String description;

    public BrandRequest(String name, String description) {
        this.name = name.trim();
        this.description = description.trim();
    }
}
