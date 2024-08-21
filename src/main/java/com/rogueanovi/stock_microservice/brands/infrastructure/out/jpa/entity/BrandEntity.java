package com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "brand")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50 , message = "Name must be between 1 and 50 characters")
    @NotBlank(message = "Name cannot be blank")
    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Size(min = 1, max = 120, message = "Description must be between 1 and 120 characters")
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
