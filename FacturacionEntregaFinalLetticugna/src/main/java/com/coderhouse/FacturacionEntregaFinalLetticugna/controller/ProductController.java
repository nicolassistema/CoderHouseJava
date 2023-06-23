package com.coderhouse.FacturacionEntregaFinalLetticugna.controller;

import com.coderhouse.FacturacionEntregaFinalLetticugna.middleware.ResponseHandler;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.Product;
import com.coderhouse.FacturacionEntregaFinalLetticugna.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> putProductById(@PathVariable("id") int id, @RequestBody Product product){
        try {
            System.out.println("Antes de entrar al servicio" + product);
            String mensaje = productService.putProductById(product,id);
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
}
