package org.ajnakicodes.controllers;

import lombok.extern.slf4j.Slf4j;
import org.ajnakicodes.models.Product;
import org.ajnakicodes.repositories.ProductRepository;
import org.ajnakicodes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/produit")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> getAllProducts() {return productService.products();}



    @PostMapping
    public Product addProduct(@RequestParam("name") String name,
                              @RequestParam("type") String type,
                              @RequestParam("description") String description,
                              @RequestParam("imageUrl") String imageUrl,
                              @RequestParam("price") Double price,
                              @RequestParam("qtt") Integer qtt
                              ) {
        return productService.createProduct(name, type, description, imageUrl,price,qtt);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("/prix/{id}")
    public Double getPrix(@PathVariable String id){
        return productRepository.findById(id).get().getPrice();
    }

    @GetMapping("/disponible")
    public boolean isDisponible(@RequestParam("id") String id, @RequestParam("qtt") int qtt) {
        log.info("test");
        return productRepository.findById(id).get().getQuantity() >= qtt;
    }

    @PostMapping("/update")
    String updateStock(@RequestBody Map<String, Integer> produits) {
        for (Map.Entry entry : produits.entrySet()) {
            Product p = productRepository.findById(String.valueOf(entry.getKey())).get();
            p.setQuantity(p.getQuantity() - (Integer) entry.getValue());
            p.setNombreAchats(p.getNombreAchats() + (Integer) entry.getValue());
            productRepository.save(p);
        }
        return UUID.randomUUID().toString();
    }

}
