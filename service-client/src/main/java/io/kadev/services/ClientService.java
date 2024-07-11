package io.kadev.services;

import io.kadev.models.CarteBancaire;
import io.kadev.models.Client;
import io.kadev.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client createNewClient(String prenom, String nom, Date dn, CarteBancaire cb) {
        return clientRepository.save(new Client(prenom, nom, dn, cb));
    }

    public List<Client> clients() {
        return clientRepository.findAll();
    }

    public Client client(String id) {
        return clientRepository.findById(id).get();
    }

}
