package org.ajnakicodes.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String description;
    private String imageUrl;
    private Integer quantity;
    private Integer nombreAchats;
    private double price;

    public Product(String name, String type, String description, String imageUrl, double price, Integer qtt) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.quantity = qtt;
        this.nombreAchats = 0;
    }
}
