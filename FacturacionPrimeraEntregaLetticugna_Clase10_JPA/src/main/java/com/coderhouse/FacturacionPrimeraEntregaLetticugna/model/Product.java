package com.coderhouse.FacturacionPrimeraEntregaLetticugna.model;

import jakarta.persistence.*;

import java.util.List;

//Acá vemos la MAGIA de Hibernate.
// Estamos utilizando el ORM, para transformar las tablas en clases de Java.

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)//esto genera auto incremental del id en la tabla
    private int id;
    private String description;
    private String code;
    private double price;
    private int stock;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)//cuando se hace la consulta  trae las  relacionas al de la factura con el detalle de la factura
    private List<InvoiceDetail> invoiceDetail;






    public List<InvoiceDetail> getInvoiceDetail() {
        return invoiceDetail;
    }

    public void setInvoiceDetail(List<InvoiceDetail> invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
    }

    //Getters y setters y override methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
