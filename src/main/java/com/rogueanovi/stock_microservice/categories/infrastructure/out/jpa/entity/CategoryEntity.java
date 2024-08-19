package com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50)
    @NotBlank(message = "Description cannot be blank")
    @NotEmpty(message = "Description cannot be empty")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Size(min = 1, max = 90)
    @NotBlank(message = "Description cannot be blank")
    @NotEmpty(message = "Description cannot be empty")
    @Column(name = "description", nullable = false)
    private String description;

    public void setName(String name) {
        this.name = name != null ? name.trim() : null;
    }

    public void setDescription(String description) {
        this.description = description != null ? description.trim() : null;
    }
}
