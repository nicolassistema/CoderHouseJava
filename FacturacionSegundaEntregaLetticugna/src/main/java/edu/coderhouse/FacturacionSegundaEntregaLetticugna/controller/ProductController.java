package edu.coderhouse.FacturacionSegundaEntregaLetticugna.controller;


import edu.coderhouse.FacturacionSegundaEntregaLetticugna.middleware.ResponseHandler;
import edu.coderhouse.FacturacionSegundaEntregaLetticugna.model.Client;
import edu.coderhouse.FacturacionSegundaEntregaLetticugna.model.Product;
import edu.coderhouse.FacturacionSegundaEntregaLetticugna.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    //Create
    @PostMapping
    public ResponseEntity<Object> postProduct (@RequestBody Product product) {
        try {
            System.out.println(product);
            Product ProductSaved = productService.postProduct(product);
            return ResponseHandler.generateResponse(
                    "Data retrieved successfully",
                    HttpStatus.OK,
                    ProductSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getProduct (@PathVariable() int id) {
        try {
            System.out.println(id);
            Product productFound = productService.getProduct(id);
            return ResponseHandler.generateResponse(
                    "Client get successfully",
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



}
