package io.kadev.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "service-produit", url = "http://localhost:8078")
public interface GestionProduits {
    @GetMapping("/produit/prix/{id}")
    Double getPrix(@PathVariable String idProduit);
    @GetMapping("/produit/disponible/{id}")
    boolean isDisponible(@PathVariable String idProduit);
    @PostMapping("/produit/update")
    boolean updateStock(@RequestBody Map<String, Integer> produits);
}
