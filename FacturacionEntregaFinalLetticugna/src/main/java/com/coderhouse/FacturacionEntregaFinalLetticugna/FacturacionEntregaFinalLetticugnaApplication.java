package com.coderhouse.FacturacionEntregaFinalLetticugna;


import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.ClientRepository;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacturacionEntregaFinalLetticugnaApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productoRepository;

    @Autowired
    private ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(FacturacionEntregaFinalLetticugnaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Server listening. Access H2 on: http://localhost:8888/h2-console");


    }
}
