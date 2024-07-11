package io.kadev;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("fraude")
@Slf4j
public class FraudeController {
    @PostMapping
    public boolean isValid(@RequestBody CarteBancaire carteBancaire){
        log.info("Recuperation des données de la carte : {}", carteBancaire);
        log.info("Vérification en cours ...");
        Random random = new Random();
        int fraudChance = random.nextInt(5);
        if(fraudChance != 1) {
            log.info("Carte Bancaire valide");
        } else {
            log.warn("Carte bancaire invalide");
        }
        return fraudChance != 1;
    }
}
