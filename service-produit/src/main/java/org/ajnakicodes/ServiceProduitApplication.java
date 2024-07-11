package org.ajnakicodes;

import org.ajnakicodes.models.Product;
import org.ajnakicodes.repositories.ProductRepository;
import org.ajnakicodes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories
public class ServiceProduitApplication implements CommandLineRunner {

	@Autowired
	ProductService productService;

	public static void main(String[] args){
		SpringApplication.run(ServiceProduitApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		Product p = new Product("p", "Electro", "Batteur", "https://uihidua.fr", 110.1, 10);
		productService.createProduct(p);
        productService.createProduct("p1", "Electro", "Batteur", "https://uihidua.fr", 110.1, 8);
		productService.createProduct("p2", "test1", "Batteur", "https://uihidua.fr", 110.1, 8);
		productService.createProduct("p3", "test2", "Batteur", "https://uihidua.fr", 110.1, 8);
		productService.createProduct("p4", "test3", "Batteur", "https://uihidua.fr", 110.1, 8);
		productService.createProduct("p5", "test4", "Batteur", "https://uihidua.fr", 110.1, 8);
		productService.createProduct("p6", "test5", "Batteur", "https://uihidua.fr", 110.1, 8);

	}
}
