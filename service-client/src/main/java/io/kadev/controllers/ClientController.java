package io.kadev.controllers;

import io.kadev.models.CarteBancaire;
import io.kadev.models.Client;
import io.kadev.services.ClientService;
import jakarta.ws.rs.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private ClientService  clientService;

    @GetMapping("all")
    public List<Client> getClients(){
        return clientService.clients();
    }

    @GetMapping("{id}")
    public Client getClient(@PathVariable String id){
        return clientService.client(id);
    }

    @PostMapping("/create")
    public Client createClient(@RequestParam("prenom") String prenom,
                               @RequestParam("nom") String nom,
                               @RequestParam("ncb") String ncb,
                               @RequestParam("cscb") Long cscb) {
        return clientService.createNewClient(prenom, nom, null, new CarteBancaire(ncb,cscb,nom));
    }

}
