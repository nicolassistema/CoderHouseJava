package com.coderHouse.FacturacionEntregaFinalLetticugna.service;

import com.coderHouse.FacturacionEntregaFinalLetticugna.model.Client;
import com.coderHouse.FacturacionEntregaFinalLetticugna.model.Product;
import com.coderHouse.FacturacionEntregaFinalLetticugna.repository.ClientRepository;
import com.coderHouse.FacturacionEntregaFinalLetticugna.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);//obtengo el producto por id
        if(product.isEmpty()){// si el prodcuto es null devuelvo null
            return null;
        } else {
            return product.get();
        }
    }

    public Product postPost(Product product) throws Exception {
        return productRepository.save(product);
    }

    public String deleteProductById(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);//obtengo el producto por id
        if(product.isEmpty()){// si el producto es null devuelvo null
            return null;
        } else {
            productRepository.delete(product.get());
            return "El producto " + product.get().getId() + " a sido eliminado de la lista";
        }
    }

    public String updateProductById(Product product, int id) throws Exception {
        Optional<Product> productExist = productRepository.findById(id);//obtengo el producto por id
        if(productExist.isEmpty()){// si el product es null devuelvo null
            throw new Exception("Product not exist");
        } else {
            return "El producto con el id " + productExist.get().getId() + " a sido modificado de la siguiente manera: Title "  +  product.getTitle() + " | Description "+  product.getDescription() + " | Stock "+  product.getStock() + " | Price "+  product.getPrice() + " | Code Product "+  product.getCodeProduct();
        }
    }

    public List<Product> getProductList() throws ParseException {

        List<Product> productList = productRepository.findAll();
       // List<Product> clientListOfMaps = new ArrayList<>();
        if(productList.isEmpty()){
            return null;
        } else {

            return productList;
        }
    }



}
