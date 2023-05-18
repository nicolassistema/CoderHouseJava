package com.coderhouse.FacturacionPrimeraEntregaLetticugna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)//esto genera auto incremental del id en la tabla
    private int id;

    @ManyToOne
    @JoinColumn(name="id_invoice")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;


    private int amount;
    private double price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "id=" + id +
                ", invoice=" + invoice +
                ", product=" + product +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }



}
