package com.coderHouse.FacturacionEntregaFinalLetticugna.controller;

import com.coderHouse.FacturacionEntregaFinalLetticugna.middleware.ResponseHandler;
import com.coderHouse.FacturacionEntregaFinalLetticugna.model.Client;
import com.coderHouse.FacturacionEntregaFinalLetticugna.model.Product;
import com.coderHouse.FacturacionEntregaFinalLetticugna.service.ClientService;
import com.coderHouse.FacturacionEntregaFinalLetticugna.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getProdcuttById (@PathVariable() int id) {
        try {
            System.out.println(id);
            Product productFound = productService.getProductById(id);
            return ResponseHandler.generateResponse(
                    "Product get successfully",
                    HttpStatus.OK,
                    productFound
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @PostMapping
    public ResponseEntity<Object> postProduct (@RequestBody Product product) {
        try {
            System.out.println("Antes de entrar al servicio" + product);
            Product productSaved = productService.postPost(product);
            return ResponseHandler.generateResponse(
                    "Data retrieved successfully",
                    HttpStatus.OK,
                    productSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteProductById (@PathVariable() int id) {
        try {
            System.out.println(id);
            String mensaje = productService.deleteProductById(id);
            return ResponseHandler.generateResponse(
                    "Product delete successfully",
                    HttpStatus.OK,
                    mensaje
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> putProductById (  @PathVariable("id") int id, @RequestBody Product product){
        try {
            System.out.println("Antes de entrar al servicio" + product);
            String mensaje = productService.updateProductById(product,id);
            return ResponseHandler.generateResponse(
                    "Data retrieved successfully",
                    HttpStatus.OK,
                    mensaje
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping
    public ResponseEntity<Object> getProductList () throws ParseException {
        try {
            //  System.out.println(id);
            List<Product> list = new ArrayList<>();
            list = productService.getProductList();
            return ResponseHandler.generateResponse(
                    "Client get successfully",
                    HttpStatus.OK,
                    list
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }


}
