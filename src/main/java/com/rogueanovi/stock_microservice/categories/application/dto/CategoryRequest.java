package com.rogueanovi.stock_microservice.categories.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    private String name;
    private String description;

    public CategoryRequest(String name, String description) {
        this.name = name.trim();
        this.description = description.trim();
    }
}
