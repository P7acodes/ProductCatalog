package io.kadev.services;

import io.kadev.models.CarteBancaire;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-fraude", url = "http://localhost:8078")
public interface DetecteurFraude {

    @PostMapping("/fraude")
    boolean isValid(@RequestBody CarteBancaire carteBancaire);

}
