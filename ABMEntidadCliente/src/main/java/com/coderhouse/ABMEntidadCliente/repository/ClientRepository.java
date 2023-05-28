package com.coderhouse.ABMEntidadCliente.repository;

import com.coderhouse.ABMEntidadCliente.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
