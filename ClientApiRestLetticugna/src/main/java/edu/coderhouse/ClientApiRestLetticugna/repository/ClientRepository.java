package edu.coderhouse.ClientApiRestLetticugna.repository;

import edu.coderhouse.ClientApiRestLetticugna.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
