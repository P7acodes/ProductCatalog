package io.kadev.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class CarteBancaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroCarte;
    private Long codeSecret;
    private String nomProprietaire;

    public CarteBancaire(String nc, Long cs, String np) {
        this.numeroCarte = nc;
        this.codeSecret = cs;
        this.nomProprietaire = np;
    }

}
