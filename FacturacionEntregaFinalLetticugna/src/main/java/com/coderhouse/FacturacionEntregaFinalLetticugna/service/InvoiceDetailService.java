package com.coderhouse.FacturacionEntregaFinalLetticugna.service;

import com.coderhouse.FacturacionEntregaFinalLetticugna.model.*;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.InvoiceDetailRepository;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    private ProductRepository productRepository;

    public void saveInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception {
        invoiceDetailRepository.save(invoiceDetail);
    }

    public List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(int invoice_id) throws Exception {
        return invoiceDetailRepository.getInvoiceDetailsByInvoiceId(invoice_id);
    }


}
