package com.coderhouse.FacturacionPrimeraEntregaLetticugna.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Client client;

    private String created_at;

    private double total;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)//cuando se hace la consulta  trae las  relacionas al de la factura con el detalle de la factura
    private List<InvoiceDetail> invoiceDetail;






    public List<InvoiceDetail> getInvoiceDetail() {
        return invoiceDetail;
    }

    public void setInvoiceDetail(List<InvoiceDetail> invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
    }

    //Resto de los métodos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", client=" + client +
                ", created_at='" + created_at + '\'' +
                ", total=" + total +
                '}';
    }
}