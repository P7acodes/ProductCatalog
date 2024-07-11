package io.kadev.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    private String id;
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private CarteBancaire carteBancaire;
    private List<String> commandes;

    public Client(String prenom, String nom, Date dn, CarteBancaire cb) {
        this.id = UUID.randomUUID().toString();
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dn;
        this.carteBancaire = cb;
        this.commandes = new ArrayList<>();
    }

}
