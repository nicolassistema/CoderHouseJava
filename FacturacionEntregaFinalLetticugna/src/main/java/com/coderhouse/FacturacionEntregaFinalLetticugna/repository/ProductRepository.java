package com.coderhouse.FacturacionEntregaFinalLetticugna.repository;


import com.coderhouse.FacturacionEntregaFinalLetticugna.model.Client;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Integer> {

}