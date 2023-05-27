package edu.coderhouse.FacturacionSegundaEntregaLetticugna.repository;

import edu.coderhouse.FacturacionSegundaEntregaLetticugna.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Integer> {
}
