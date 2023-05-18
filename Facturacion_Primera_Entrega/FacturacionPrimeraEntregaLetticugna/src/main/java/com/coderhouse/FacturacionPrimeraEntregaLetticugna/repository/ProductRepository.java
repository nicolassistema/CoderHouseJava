package com.coderhouse.FacturacionPrimeraEntregaLetticugna.repository;

import com.coderhouse.FacturacionPrimeraEntregaLetticugna.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Producto, Integer> {
}