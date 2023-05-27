package edu.coderhouse.FacturacionSegundaEntregaLetticugna.service;

import edu.coderhouse.FacturacionSegundaEntregaLetticugna.model.Client;
import edu.coderhouse.FacturacionSegundaEntregaLetticugna.model.Product;
import edu.coderhouse.FacturacionSegundaEntregaLetticugna.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product postProduct(Product product) throws Exception {
        return productRepository.save(product);
    }

    public Product getProduct(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            return null;
        } else {
            return product.get();
        }
    }


}
