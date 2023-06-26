package com.coderhouse.FacturacionEntregaFinalLetticugna.controller;

import com.coderhouse.FacturacionEntregaFinalLetticugna.middleware.ResponseHandler;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.InvoiceDTO;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.InvoiceWithDetailsDTO;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.InvoiceRequest;
import com.coderhouse.FacturacionEntregaFinalLetticugna.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Object> postInvoice(@RequestBody InvoiceRequest reqInvoice) {
        try {
            System.out.println(reqInvoice);
            //DTO Data transfer object
            InvoiceDTO data = invoiceService.postInvoice(reqInvoice);
            return ResponseHandler.generateResponse(
                    "Invoice created successful",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }

    @GetMapping(path = "{invoice_id}")
    public ResponseEntity<Object> getInvoiceById(@PathVariable int invoice_id) {
        try {
            System.out.println(invoice_id);
            InvoiceWithDetailsDTO data = invoiceService.getInvoiceById(invoice_id);


            return ResponseHandler.generateResponse(
                    "Get Invoice by Id succesful",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping(path = "/client/{id}")
    public ResponseEntity<Object> getInvoicesByClientId(@PathVariable int id) {
        try {
            List<InvoiceDTO> data = invoiceService.getInvoicesByClientId(id);
            return ResponseHandler.generateResponse(
                    "Get Invoices by Client id successful",
                    HttpStatus.OK,
                    data
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

