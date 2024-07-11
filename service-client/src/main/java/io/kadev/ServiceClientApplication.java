package io.kadev;

import io.kadev.models.CarteBancaire;
import io.kadev.models.Client;
import io.kadev.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class ServiceClientApplication implements CommandLineRunner {

	@Autowired
	private ClientService clientService;

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client client = new Client("Hamza", "KADIMI", new Date(), new CarteBancaire("21519816548", 120L, "KADIMI"));
		clientService.createNewClient(client);
		Client client1 = new Client("Abdelhaq", "AJNAKI", new Date(), new CarteBancaire("29826868", 188L, "AJNAKI"));
		clientService.createNewClient(client1);
		Client client2 = new Client("Test", "TEST", new Date(), new CarteBancaire("600508295085", 788L, "TEST"));
		clientService.createNewClient(client2);
	}
}
