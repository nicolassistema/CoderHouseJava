package com.coderhouse.FacturacionEntregaFinalLetticugna.service;

import com.coderhouse.FacturacionEntregaFinalLetticugna.model.Client;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.Product;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.RequestProductDetail;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList() throws ParseException {
        List<Product> productList = productRepository.findAll();
        if(productList.isEmpty()){
            return null;
        } else {
            return productList;
        }
    }

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

    public Product getProductById(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new Exception("Product with id: " + id + " not found.");
        } else {
            return product.get();
        }
    }

    public Product postProduct(Product product) throws Exception {

        if ( !product.titleValidate(product.getTitle())) {
            throw new Exception("Title Null");
        } else if ( !product.descriptionValidate(product.getDescription())) {
            throw new Exception("Description Null");
        } else if ( !product.codeValidate(product.getCode())) {
            throw new Exception("Code Null");
        } else if ( !product.stockValidate(product.getStock())) {
            System.out.println("getStock: " + product.getStock());
            throw new Exception("Stock Null");
        } else if ( !product.priceValidate(product.getPrice())) {
            System.out.println("getPrice: " + product.getPrice());
            throw new Exception("Price Null");
        } else {
             productRepository.save(product);
            return null;
        }
    }

    public String updateProductById(Product product, int id) throws Exception {
        Optional<Product> productExist = productRepository.findById(id);//obtengo el cliente por id
        if(productExist.isEmpty()) {// si el cliente es null devuelvo null
            throw new Exception("Product not exist");
        } else if ( !product.titleValidate(product.getTitle())) {
            throw new Exception("Title Null");
        } else if ( !product.descriptionValidate(product.getDescription())) {
            throw new Exception("Description Null");
        } else if ( !product.codeValidate(product.getCode())) {
            throw new Exception("Code Null");
        } else if ( !product.stockValidate(product.getStock())) {
            System.out.println("getStock: " + product.getStock());
            throw new Exception("Stock Null");
        } else if ( !product.priceValidate(product.getPrice())) {
            System.out.println("getPrice: " + product.getPrice());
            throw new Exception("Price Null");
    } else {
            productExist.get().setTitle(product.getTitle());
            productRepository.save(productExist.get());
            return null;
        }
    }

    public String deleteProductById(int id) throws Exception {
        try {
            Optional<Product> product = productRepository.findById(id);//obtengo el producto por id
            if(product.isEmpty()){// si el cliente es null devuelvo null
                throw new Exception("Product not exist");
            } else {
                productRepository.delete(product.get());
                return null;
            }
        } catch (Exception e) {
            throw new Exception("No se puede borrar este prodcuto ya que tiene invoices cargados");
        }



    }




}
