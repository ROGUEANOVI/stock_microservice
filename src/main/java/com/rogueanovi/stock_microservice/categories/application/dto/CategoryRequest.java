package com.rogueanovi.stock_microservice.categories.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    public CategoryRequest(String name, String description) {
        this.name = name.trim();
        this.description = description.trim();
    }

    @Size(min = 1, max = 50 , message = "Name must be between 1 and 50 characters")
    @NotBlank(message = "Description cannot be blank")
    @NotEmpty(message = "Description cannot be empty")
    private String name;

    @Size(min = 1, max = 90, message = "Description must be between 1 and 90 characters")
    @NotBlank(message = "Description cannot be blank")
    @NotEmpty(message = "Description cannot be empty")
    private String description;
}
