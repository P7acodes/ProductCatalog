package org.ajnakicodes.controllers;

import org.ajnakicodes.models.Product;
import org.ajnakicodes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ajnakicodes.services.ProductService.productRepository;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {return ProductService.products();}

    public Product getProduct(@PathVariable String id) {return productService.product(id);}

    @PostMapping
    public Product addProduct(@RequestParam("name") String name,
                              @RequestParam("type") String type,
                              @RequestParam("description") String description,
                              @RequestParam("imageUrl") String imageUrl,
                              @RequestParam("price") Double price
                              ) {
        return productService.createProduct(name, type, description, imageUrl,price));
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Double getPrix(String id){}
}
