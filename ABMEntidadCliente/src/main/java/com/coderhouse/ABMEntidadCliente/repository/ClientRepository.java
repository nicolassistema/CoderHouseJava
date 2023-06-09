package com.coderhouse.ABMEntidadCliente.repository;

import com.coderhouse.ABMEntidadCliente.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByNameLike(String name);


}
