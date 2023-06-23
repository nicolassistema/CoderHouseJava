package com.coderhouse.FacturacionEntregaFinalLetticugna.controller;


import com.coderhouse.FacturacionEntregaFinalLetticugna.middleware.ResponseHandler;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.Client;
import com.coderhouse.FacturacionEntregaFinalLetticugna.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    //CRUD cliente

    //Create
    @PostMapping
    public ResponseEntity<Object> postClient (@RequestBody Client client) {
        try {
            System.out.println(client);
            Client clientSaved = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Data retrieved successfully",
                    HttpStatus.OK,
                    clientSaved
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
    public ResponseEntity<Object> getClient (@PathVariable() int id) {
        try {
            System.out.println(id);
            Client clientFound = clientService.getClientById(id);
            return ResponseHandler.generateResponse(
                    "Client get successfully",
                    HttpStatus.OK,
                    clientFound
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
    public ResponseEntity<Object> putClientById (  @PathVariable("id") int id, @RequestBody Client client){
        try {
            System.out.println("Antes de entrar al servicio" + client);
            String mensaje = clientService.updateClientById(client,id);//obtengo el objeto map
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


    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteClientById (@PathVariable() int id) {
        try {
            System.out.println(id);
            String mensaje = clientService.deleteClientById(id);
            return ResponseHandler.generateResponse(
                    "Client delete successfully",
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