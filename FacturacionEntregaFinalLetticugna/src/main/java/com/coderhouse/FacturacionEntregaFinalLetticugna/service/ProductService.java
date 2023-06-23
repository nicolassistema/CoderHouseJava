package com.coderhouse.FacturacionEntregaFinalLetticugna.service;

import com.coderhouse.FacturacionEntregaFinalLetticugna.model.Product;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.RequestProductDetail;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsById(List<RequestProductDetail> productListId) throws Exception {
        List<Product> productList = new ArrayList<>();
        for (RequestProductDetail requestProduct:
                productListId) {
            Optional<Product> productFound = productRepository.findById(requestProduct.getProductId());
            if (productFound.isEmpty()){
                throw new Exception("Product with id: " + requestProduct.getProductId() + " not found.");
            }
            productList.add(productFound.get());
        }
        return productList;
    }

    public String putProductById(Product product, int id) throws Exception {
        Optional<Product> productExist = productRepository.findById(id);//obtengo el producto por id
        if(productExist.isEmpty()){// si el product es null devuelvo null
            throw new Exception("Product not exist");
        } else {
            productRepository.save(product);
            return "El producto con el id " + productExist.get().getId() + " a sido modificado de la siguiente manera: Title "  +  product.getTitle() + " | Description "+  product.getDescription() + " | Stock "+  product.getStock() + " | Price "+  product.getPrice() + " | Code Product "+  product.getCode();
        }
    }


}
