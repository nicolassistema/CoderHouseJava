package com.coderhouse.FacturacionPrimeraEntregaLetticugna.middleware;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {//es para normalizar todas las respuestas de mi aplicacion
    public static ResponseEntity<Object> generateResponse(
            String message,
            HttpStatus status,
            Object responseObj
    ) {
        Map<String, Object> map = new HashMap<>();//esto devuelve un formato clave varlo, es como un json
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, status);
    }
}