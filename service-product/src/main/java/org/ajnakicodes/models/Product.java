package org.ajnakicodes.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private String description;
    private String imageUrl;
    private Boolean isAvailable;
    private double price;

    public Product(String name, String type, String description, String imageUrl, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}
