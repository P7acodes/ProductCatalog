package org.ajnakicodes.services;

import lombok.AllArgsConstructor;
import org.ajnakicodes.models.Product;
import org.ajnakicodes.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public Product createProduct(String name, String type, String description, String imageUrl, Double price, Integer qtt){
        return productRepository.save(new Product(name, type, description, imageUrl, price, qtt));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> products() {return productRepository.findAll();}

    public Product product(String id){return productRepository.findById(id).get();}
}
