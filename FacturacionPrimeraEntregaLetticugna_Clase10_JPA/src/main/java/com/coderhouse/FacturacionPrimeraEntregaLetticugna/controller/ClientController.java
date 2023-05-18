package com.coderhouse.FacturacionPrimeraEntregaLetticugna.controller;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.middleware.ResponseHandler;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.model.Client;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//anotation
@RequestMapping(path = "api/v1/client")//cual va a seer la url para acceder a este recurso
public class ClientController {


    @Autowired
    private ClientService clientService;

    //CRUD cliente


    @PostMapping
   // public String postClient(@RequestBody Client client) {
    public ResponseEntity<Object> postClient(@RequestBody Client client) {//el servidor va a mapear todo lo que reciba den cliente
            try {
        System.out.println(client);
         Client clientSaved = clientService.postClient(client);//asi como lo recibe se lo envia al servicio
          return ResponseHandler.generateResponse(//esto hace que se genere respuesta
              "Client stored successfully",
              HttpStatus.OK,//esto es el estado de la respuesta
                    //null
                  clientSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),//se devuelve una respuesta de error
                    HttpStatus.INTERNAL_SERVER_ERROR,//en este caso devolvemos un error 500
                    null
            );
        }
    }

    @GetMapping(path = "{id}")//agrega al sub path el id por que hay que buscarlo por id
    public ResponseEntity<Object> getClient(@PathVariable int id) {//el servidor va a mapear todo lo que reciba den cliente
        try {
            System.out.println(id);
            Client clientGet = clientService.getClient(id);//asi como lo recibe se lo envia al servicio
            return ResponseHandler.generateResponse(//esto hace que se genere respuesta

                    "Client stored successfully",
                    HttpStatus.OK,//esto es el estado de la respuesta
                   // null
                    clientGet

            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),//se devuelve una respuesta de error
                    HttpStatus.INTERNAL_SERVER_ERROR,//en este caso devolvemos un error 500
                    null
            );
        }
    }


}