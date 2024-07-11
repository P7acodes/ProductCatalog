package io.kadev;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ServiceConfigurationApplication implements CommandLineRunner {

	@Value("${user.home}")
	private String userHome;

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(userHome);
	}
}
