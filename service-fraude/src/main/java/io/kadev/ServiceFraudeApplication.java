package io.kadev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceFraudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFraudeApplication.class, args);
	}

}
