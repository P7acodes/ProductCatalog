package org.ajnakicodes.repositories;

import org.ajnakicodes.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
