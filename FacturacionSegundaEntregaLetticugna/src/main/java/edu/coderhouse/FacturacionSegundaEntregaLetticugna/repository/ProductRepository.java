package edu.coderhouse.FacturacionSegundaEntregaLetticugna.repository;

import edu.coderhouse.FacturacionSegundaEntregaLetticugna.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
