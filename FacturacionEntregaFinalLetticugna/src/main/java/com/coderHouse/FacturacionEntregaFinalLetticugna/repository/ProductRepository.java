package com.coderHouse.FacturacionEntregaFinalLetticugna.repository;

import com.coderHouse.FacturacionEntregaFinalLetticugna.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
