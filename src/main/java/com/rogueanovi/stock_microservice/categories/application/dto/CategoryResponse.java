package com.rogueanovi.stock_microservice.categories.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    Long id;
    private String name;
    private String description;
}
