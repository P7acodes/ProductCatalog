package io.kadev.services;

import io.kadev.models.CarteBancaire;
import io.kadev.models.Client;
import io.kadev.repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DetecteurFraude detecteurFraude;

    @Autowired
    GestionProduits gestionProduits;

    public Client createNewClient(String prenom, String nom, Date dn, CarteBancaire cb) {
        return clientRepository.save(new Client(prenom, nom, dn, cb));
    }
    public Client createNewClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> clients() {
        return clientRepository.findAll();
    }

    public Client client(String id) {
        return clientRepository.findById(id).get();
    }

    public String passerUneCommande(Map<String, Integer> produits, Client client) {
        double somme = 0.0;
        if(produits == null || produits.isEmpty()) return "Cette commande est vide";
        for (Map.Entry entry : produits.entrySet()) {
//            if(!gestionProduits.isDisponible((String) entry.getKey())) return "Commande non passé, produit en rupture de stock";
//            somme += gestionProduits.getPrix((String) entry.getKey());
        }
        if(!detecteurFraude.isValid(client.getCarteBancaire())) {
            return "Fraude détectée !!!";
        }
//        gestionProduits.updateStock(produits);
        return "Félicitation commande effectuer, somme prélevée est de ".concat(String.valueOf(somme));
    }

}
