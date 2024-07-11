package io.kadev.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "service-produit", url = "http://localhost:8078")
public interface GestionProduits {
    @GetMapping("/produit/prix/{id}")
    Double getPrix(@PathVariable String id);
    @GetMapping("/produit/disponible")
    boolean isDisponible(@RequestParam("id") String id, @RequestParam("qtt") int quantite);
    @PostMapping("/produit/update")
    String updateStock(@RequestBody Map<String, Integer> produits);
}
