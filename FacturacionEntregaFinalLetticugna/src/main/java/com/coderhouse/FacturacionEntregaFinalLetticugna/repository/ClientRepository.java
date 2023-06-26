package com.coderhouse.FacturacionEntregaFinalLetticugna.repository;

import com.coderhouse.FacturacionEntregaFinalLetticugna.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "SELECT c.id, c.name, c.lastname, c.docnumber  FROM client c inner join invoice i  on i.client_id = c.id where i.id = :invoice_id", nativeQuery = true)
    Client getClientIdByIDInvoice(int invoice_id);


}
