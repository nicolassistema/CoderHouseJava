package com.coderhouse.FacturacionPrimeraEntregaLetticugna.repository;

import com.coderhouse.FacturacionPrimeraEntregaLetticugna.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente, Integer>{
}
