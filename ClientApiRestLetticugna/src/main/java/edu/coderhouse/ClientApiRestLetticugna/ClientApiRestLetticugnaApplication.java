package edu.coderhouse.ClientApiRestLetticugna;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApiRestLetticugnaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientApiRestLetticugnaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening. Access H2 on: http://localhost:8888/h2-console");

	}
}

