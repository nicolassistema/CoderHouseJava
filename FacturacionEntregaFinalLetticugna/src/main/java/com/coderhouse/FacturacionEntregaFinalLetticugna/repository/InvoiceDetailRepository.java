package com.coderhouse.FacturacionEntregaFinalLetticugna.repository;

import com.coderhouse.FacturacionEntregaFinalLetticugna.model.InvoiceDetail;
import com.coderhouse.FacturacionEntregaFinalLetticugna.model.InvoiceDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
    @Query("SELECT new com.coderhouse.FacturacionEntregaFinalLetticugna.model.InvoiceDetailDTO(" +
            "p.title, " +
            "p.description, " +
            "p.code, " +
            "d.price, " +
            "d.quantity" +
            ") FROM Invoice i JOIN i.invoiceDetails d JOIN d.product p WHERE i.id = :invoice_id")
    List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(@Param("invoice_id") int invoice_id);

}
