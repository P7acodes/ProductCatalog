package io.kadev.repositories;

import io.kadev.models.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteBancaireRepository extends JpaRepository<CarteBancaire, Long> {
}
